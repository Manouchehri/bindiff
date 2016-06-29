package com.google.common.io;

final class CharSource$EmptyCharSource extends CharSource$CharSequenceCharSource
{
    private static final CharSource$EmptyCharSource INSTANCE;
    
    private CharSource$EmptyCharSource() {
        super("");
    }
    
    @Override
    public String toString() {
        return "CharSource.empty()";
    }
    
    static {
        INSTANCE = new CharSource$EmptyCharSource();
    }
}
