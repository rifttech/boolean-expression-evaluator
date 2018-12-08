package com.github.rifttech.bec;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

@Slf4j
public class BooleanEvaluatorVisitorTest {

    @Test
    public void testBinaryOpAnd() {
        final String expression = "A AND B";
        Map<String, Boolean> vars = new HashMap<>();

        vars.put("A", true);
        vars.put("B", true);
        assertTrue(evaluate(expression, vars));

        vars.put("A", true);
        vars.put("B", false);
        assertFalse(evaluate(expression, vars));

        vars.put("A", false);
        vars.put("B", true);
        assertFalse(evaluate(expression, vars));

        vars.put("A", false);
        vars.put("B", false);
        assertFalse(evaluate(expression, vars));
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

    }
    private static class PackageBuilder {
        private List<ExpressionPackage> list = new ArrayList<>();
        static PackageBuilder setup(){
            return new PackageBuilder();
        }
        PackageBuilder of(String expr, boolean expected){
            this.list.add(new ExpressionPackage(expr, expected));
            return this;
        }
        List<ExpressionPackage> get(){
            return this.list;
        }
    }
}