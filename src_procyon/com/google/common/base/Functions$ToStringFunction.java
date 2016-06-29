package com.google.common.base;

enum Functions$ToStringFunction implements Function
{
    INSTANCE("INSTANCE", 0);
    
    private Functions$ToStringFunction(final String s, final int n) {
    }
    
    @Override
    public String apply(final Object o) {
        Preconditions.checkNotNull(o);
        return o.toString();
    }
    
    @Override
    public String toString() {
        return "Functions.toStringFunction()";
    }
}
