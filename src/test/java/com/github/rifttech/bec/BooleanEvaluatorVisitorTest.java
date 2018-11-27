package com.github.rifttech.bec;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class BooleanEvaluatorVisitorTest {

    @Test
    public void testBinaryOpAnd() {
        final String expression = "A AND B";
        Map<String, Boolean> vars = new HashMap<>();
        vars.put("A", true);
        vars.put("B", true);
        Evaluator evaluator = new Evaluator();
        boolean evaluate = evaluator.evaluate(expression, vars);
        assertTrue(evaluate);

        vars.put("A", true);
        vars.put("B", false);
        evaluate = evaluator.evaluate(expression, vars);
        assertFalse(evaluate);

        vars.put("A", false);
        vars.put("B", true);
        evaluate = evaluator.evaluate(expression, vars);
        assertFalse(evaluate);

        vars.put("A", false);
        vars.put("B", false);
        evaluate = evaluator.evaluate(expression, vars);
        assertFalse(evaluate);
    }
}