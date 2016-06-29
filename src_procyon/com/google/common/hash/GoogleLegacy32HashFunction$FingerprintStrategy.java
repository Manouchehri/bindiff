package com.google.common.hash;

enum GoogleLegacy32HashFunction$FingerprintStrategy
{
    WORKING("WORKING", 0), 
    BROKEN("BROKEN", 1);
    
    private GoogleLegacy32HashFunction$FingerprintStrategy(final String s, final int n) {
    }
    
    abstract int maybeAddSignCruft(final int p0);
    
    abstract int word32At(final byte[] p0, final int p1);
}
