package com.google.common.hash;

import com.google.common.primitives.*;

enum GoogleLegacy32HashFunction$FingerprintStrategy$2
{
    GoogleLegacy32HashFunction$FingerprintStrategy$2(final String s, final int n) {
    }
    
    @Override
    int maybeAddSignCruft(final int n) {
        return n;
    }
    
    @Override
    int word32At(final byte[] array, final int n) {
        return Ints.fromBytes(array[n + 3], array[n + 2], array[n + 1], array[n]);
    }
}
