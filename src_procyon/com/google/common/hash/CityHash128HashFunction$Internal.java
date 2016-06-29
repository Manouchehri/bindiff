package com.google.common.hash;

import javax.annotation.*;

enum CityHash128HashFunction$Internal implements CityHash128HashFunction$InternalImplementation
{
    UsingUnsafe("UsingUnsafe", 0), 
    UsingByteBuffer("UsingByteBuffer", 1);
    
    private CityHash128HashFunction$Internal(final String s, final int n) {
    }
    
    protected abstract HashCode fingerprint(final byte[] p0, final int p1, final int p2, final long p3, final long p4);
    
    @Override
    public HashCode fingerprint(final byte[] array, int n, int n2, @Nullable final long[] array2) {
        long n3;
        long load64;
        if (array2 == null) {
            if (n2 >= 16) {
                n3 = (LittleEndianByteArray.load64(array, n) ^ 0xC70F6907E782AA0BL);
                load64 = LittleEndianByteArray.load64(array, n + 8);
                n += 16;
                n2 -= 16;
            }
            else if (n2 >= 8) {
                n3 = (LittleEndianByteArray.load64(array, n) ^ n2 * -6505348102511208375L);
                load64 = (LittleEndianByteArray.load64(array, n2 - 8) ^ 0x8D58AC26AFE12E47L);
                n2 = 0;
            }
            else {
                n3 = -6505348102511208375L;
                load64 = -8261664234251669945L;
            }
        }
        else {
            n3 = array2[0];
            load64 = array2[1];
        }
        return this.fingerprint(array, n, n2, load64, n3);
    }
}
