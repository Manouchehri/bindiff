package com.google.common.hash;

import com.google.common.primitives.*;

enum LittleEndianByteArray$JavaLittleEndianBytes$1
{
    LittleEndianByteArray$JavaLittleEndianBytes$1(final String s, final int n) {
    }
    
    @Override
    public long getLongLittleEndian(final byte[] array, final int n) {
        return Longs.fromBytes(array[n + 7], array[n + 6], array[n + 5], array[n + 4], array[n + 3], array[n + 2], array[n + 1], array[n]);
    }
    
    @Override
    public void putLongLittleEndian(final byte[] array, final int n, final long n2) {
        long n3 = 255L;
        for (int i = 0; i < 8; ++i) {
            array[n + i] = (byte)((n2 & n3) >> i * 8);
            n3 <<= 8;
        }
    }
}
