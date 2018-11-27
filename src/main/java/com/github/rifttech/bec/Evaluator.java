package com.github.rifttech.bec;

import com.github.rifttech.antlr4.GrammarLexer;
import com.github.rifttech.antlr4.GrammarParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.Map;

class Evaluator {
    boolean evaluate(final String expr, Map<String, Boolean> vars){
        GrammarLexer lexer = new GrammarLexer(CharStreams.fromString(expr));
        GrammarParser parser = new GrammarParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.parse();
        BooleanEvaluatorVisitor visitor = new BooleanEvaluatorVisitor(vars);
        return visitor.visit(tree);

    }
}
