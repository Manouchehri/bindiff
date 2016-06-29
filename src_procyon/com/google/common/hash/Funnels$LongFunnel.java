package com.google.common.hash;

enum Funnels$LongFunnel implements Funnel
{
    INSTANCE("INSTANCE", 0);
    
    private Funnels$LongFunnel(final String s, final int n) {
    }
    
    public void funnel(final Long n, final PrimitiveSink primitiveSink) {
        primitiveSink.putLong(n);
    }
    
    @Override
    public String toString() {
        return "Funnels.longFunnel()";
    }
}
