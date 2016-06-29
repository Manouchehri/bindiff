package com.google.security.zynamics.zylib.disassembly;

public enum ExpressionType
{
    SYMBOL("SYMBOL", 0), 
    IMMEDIATE_INTEGER("IMMEDIATE_INTEGER", 1), 
    IMMEDIATE_FLOAT("IMMEDIATE_FLOAT", 2), 
    OPERATOR("OPERATOR", 3), 
    REGISTER("REGISTER", 4), 
    SIZE_PREFIX("SIZE_PREFIX", 5), 
    MEMDEREF("MEMDEREF", 6), 
    EXPRESSION_LIST("EXPRESSION_LIST", 7);
    
    private ExpressionType(final String s, final int n) {
    }
}
