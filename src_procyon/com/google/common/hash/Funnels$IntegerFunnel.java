package com.google.common.hash;

enum Funnels$IntegerFunnel implements Funnel
{
    INSTANCE("INSTANCE", 0);
    
    private Funnels$IntegerFunnel(final String s, final int n) {
    }
    
    public void funnel(final Integer n, final PrimitiveSink primitiveSink) {
        primitiveSink.putInt(n);
    }
    
    @Override
    public String toString() {
        return "Funnels.integerFunnel()";
    }
}
