package com.google.common.hash;

enum Funnels$UnencodedCharsFunnel implements Funnel
{
    INSTANCE("INSTANCE", 0);
    
    private Funnels$UnencodedCharsFunnel(final String s, final int n) {
    }
    
    public void funnel(final CharSequence charSequence, final PrimitiveSink primitiveSink) {
        primitiveSink.putUnencodedChars(charSequence);
    }
    
    @Override
    public String toString() {
        return "Funnels.unencodedCharsFunnel()";
    }
}
