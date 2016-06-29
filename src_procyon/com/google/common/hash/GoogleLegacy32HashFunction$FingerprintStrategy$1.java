package com.google.common.hash;

enum GoogleLegacy32HashFunction$FingerprintStrategy$1
{
    GoogleLegacy32HashFunction$FingerprintStrategy$1(final String s, final int n) {
    }
    
    @Override
    int maybeAddSignCruft(final int n) {
        return (n & 0x7F7F7F7F) - (n & 0x80808080);
    }
    
    @Override
    int word32At(final byte[] array, final int n) {
        return array[n + 0] + (array[n + 1] << 8) + (array[n + 2] << 16) + (array[n + 3] << 24);
    }
}
