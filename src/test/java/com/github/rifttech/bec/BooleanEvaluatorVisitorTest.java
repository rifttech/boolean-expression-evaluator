package com.github.rifttech.bec;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

@Slf4j
public class BooleanEvaluatorVisitorTest {

    @Test
    public void testBinaryOpAnd() {
        final String expression = "A AND B";
        PackageBuilder
                .setup()
                .of(expression, true, mapOf(True("A"), True("B")))
                .of(expression, false, mapOf(True("A"), False("B")))
                .of(expression, false, mapOf(False("A"), True("B")))
                .of(expression, false, mapOf(False("A"), False("B")))
                .get()
                .forEach(s -> assertEquals(s.isExpectedResult(), evaluate(s.getExpr(),s.getVars())));
    }

    @Test
    public void testBinaryOpOr() {
        final String expression = "A OR B";
        PackageBuilder
                .setup()
                .of(expression, true, mapOf(True("A"), True("B")))
                .of(expression, true, mapOf(True("A"), False("B")))
                .of(expression, true, mapOf(False("A"), True("B")))
                .of(expression, false, mapOf(False("A"), False("B")))
                .get()
                .forEach(s -> assertEquals(s.isExpectedResult(), evaluate(s.getExpr(),s.getVars())));
    }

    @Test
    public void testAtom() {
        List<ExpressionPackage> tests = PackageBuilder.setup()
            .of("TRUE", true)
            .of("FALSE", false)
            .of("TRUE AND TRUE", true)
            .of("TRUE OR TRUE", true)
            .of("NOT TRUE", false)
            .of("NOT FALSE", true)
            .of("NOT NOT TRUE", true)
            .of("NOT NOT NOT TRUE", false)
            .of("NOT TRUE OR NOT FALSE", true)
            .get();

        assertExpressions(tests);
    }

    @Test
    public void textXOR() {
        PackageBuilder.setup()
                .of("A XOR B", false, mapOf(True("A"), True("B")))
                .of("A XOR B", true, mapOf(True("A"), False("B")))
                .of("A XOR B", true, mapOf(False("A"), True("B")))
                .of("A XOR B", false, mapOf(False("A"), False("B")))
                .get()
                .forEach(s -> assertEquals(s.isExpectedResult(), evaluate(s.getExpr(),s.getVars())));
    }

    @Test
    public void textNOR() {
        PackageBuilder.setup()
                .of("A NOR B", false, mapOf(True("A"), True("B")))
                .of("A NOR B", false, mapOf(True("A"), False("B")))
                .of("A NOR B", false, mapOf(False("A"), True("B")))
                .of("A NOR B", true, mapOf(False("A"), False("B")))
                .get()
                .forEach(s -> assertEquals(s.isExpectedResult(), evaluate(s.getExpr(),s.getVars())));
    }

    private static void assertExpressions(List<ExpressionPackage> tests) {
        for (int i = 0; i < tests.size(); i++) {
            log.debug("testing expression {}", i);
            ExpressionPackage testExpr = tests.get(i);
            assertEquals(evaluate(testExpr.expr),testExpr.expectedResult );
        }
    }

    private static boolean evaluate(String expr, Map<String, Boolean> map){
        return new Evaluator().evaluate(expr, map);
    }

    private static boolean evaluate(String expr){
        return new Evaluator().evaluate(expr, Collections.emptyMap());
    }

    @Data
    private static class ExpressionPackage {
        private final String expr;
        private final boolean expectedResult;
        private final Map<String,Boolean> vars;

    }

    private static class PackageBuilder {
        private List<ExpressionPackage> list = new ArrayList<>();
        static PackageBuilder setup(){
            return new PackageBuilder();
        }
        PackageBuilder of(String expr, boolean expected){
            this.list.add(new ExpressionPackage(expr, expected, Collections.emptyMap()));
            return this;
        }
        PackageBuilder of(String expr, boolean expected, Map<String,Boolean> map){
            this.list.add(new ExpressionPackage(expr, expected, map));
            return this;
        }
        List<ExpressionPackage> get(){
            return this.list;
        }
    }

    @Data
    @AllArgsConstructor
    private static class Variable{
        private String name;
        private Boolean value;
    }

    private Variable var(String name, Boolean value){
        return new Variable(name, value);
    }

    private Variable True(String name){
        return new Variable(name, true);
    }

    private Variable False(String name){
        return new Variable(name, false);
    }
    
    private static Map<String, Boolean> mapOf(Variable ... vars){
        if (vars == null) throw new IllegalArgumentException();
        return Arrays.stream(vars).collect(Collectors.toMap(Variable::getName, Variable::getValue));
    }

}