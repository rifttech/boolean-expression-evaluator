package com.github.rifttech.bec;

import com.github.rifttech.antlr4.GrammarBaseVisitor;
import com.github.rifttech.antlr4.GrammarParser;

import java.util.Map;
import java.util.Objects;

public class BooleanEvaluatorVisitor extends GrammarBaseVisitor<Boolean> {
    private final Map<String, Boolean> vars;

    BooleanEvaluatorVisitor(Map<String, Boolean> vars) {
        this.vars = vars;
    }

    @Override
    public Boolean visitBinaryExpression(GrammarParser.BinaryExpressionContext ctx) {
        if(Objects.nonNull(ctx.op1) && ctx.op1.AND() != null){
            return asBoolean(ctx.left) && asBoolean(ctx.right);
        } else if(Objects.nonNull(ctx.op1) && ctx.op1.NAND() != null){
           return !(asBoolean(ctx.left) || asBoolean(ctx.right));
        } else if (ctx.op2.OR() != null){
            return asBoolean(ctx.left) || asBoolean(ctx.right);
        } else if (ctx.op2.XOR() != null){
            boolean p = asBoolean(ctx.left);
            boolean q = asBoolean(ctx.right);
            return (p||q) && !(p&&q);
        } else if (ctx.op2.NOR() != null){
            boolean p = asBoolean(ctx.left);
            boolean q = asBoolean(ctx.right);
            return !(p || q);
        }else {
            throw new UnsupportedOperationException(ctx.getText());
        }
    }

    @Override
    public Boolean visitParse(GrammarParser.ParseContext ctx) {
        return super.visit(ctx.expression());
    }


    @Override
    public Boolean visitBoolExpression(GrammarParser.BoolExpressionContext ctx) {
        return visitBool(ctx.bool());
    }

    @Override
    public Boolean visitIdentifierExpression(GrammarParser.IdentifierExpressionContext ctx) {
        return vars.get(ctx.IDENTIFIER().getText());
    }

    @Override
    public Boolean visitNotExpression(GrammarParser.NotExpressionContext ctx) {
        return !visit(ctx.expression());
    }

    @Override
    public Boolean visitParenExpression(GrammarParser.ParenExpressionContext ctx) {
        return super.visit(ctx.expression());
    }

    @Override
    public Boolean visitBool(GrammarParser.BoolContext ctx) {
        if(ctx.TRUE() != null){
            return true;
        }else if (ctx.FALSE() != null){
            return false;
        }else {
            throw new IllegalArgumentException("Boolean can be FALSE OR TRUE");
        }
    }

    private boolean asBoolean(GrammarParser.ExpressionContext ctx){
        return visit(ctx);
    }
}
