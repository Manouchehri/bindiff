package com.google.common.hash;

enum Funnels$ByteArrayFunnel implements Funnel
{
    INSTANCE("INSTANCE", 0);
    
    private Funnels$ByteArrayFunnel(final String s, final int n) {
    }
    
    public void funnel(final byte[] array, final PrimitiveSink primitiveSink) {
        primitiveSink.putBytes(array);
    }
    
    @Override
    public String toString() {
        return "Funnels.byteArrayFunnel()";
    }
}
