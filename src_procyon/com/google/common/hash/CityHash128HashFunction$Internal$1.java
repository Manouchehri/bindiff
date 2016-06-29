package com.google.common.hash;

import com.google.common.base.*;
import javax.annotation.*;
import java.util.*;
import com.google.common.annotations.*;
import java.nio.*;

enum CityHash128HashFunction$Internal$1
{
    CityHash128HashFunction$Internal$1(final String s, final int n) {
    }
    
    @Override
    protected HashCode fingerprint(final byte[] array, int n, int i, long n2, long access$200) {
        if (i < 128) {
            return cityMurmur(array, n, i, n2, access$200);
        }
        final byte[] array2 = new byte[16];
        final long[] array3 = new long[2];
        final long[] array4 = new long[2];
        long n3 = i * -8261664234251669945L;
        array3[0] = Long.rotateRight(access$200 ^ 0x8D58AC26AFE12E47L, 49) * -8261664234251669945L + LittleEndianByteArray.load64(array, n);
        array3[1] = Long.rotateRight(array3[0], 42) * -8261664234251669945L + LittleEndianByteArray.load64(array, n + 8);
        array4[0] = Long.rotateRight(access$200 + n3, 35) * -8261664234251669945L + n2;
        array4[1] = Long.rotateRight(n2 + LittleEndianByteArray.load64(array, n + 88), 53) * -8261664234251669945L;
        do {
            n2 = Long.rotateRight(n2 + access$200 + array3[0] + LittleEndianByteArray.load64(array, n + 16), 37) * -8261664234251669945L;
            access$200 = Long.rotateRight(access$200 + array3[1] + LittleEndianByteArray.load64(array, n + 48), 42) * -8261664234251669945L;
            n2 ^= array4[1];
            access$200 ^= array3[0];
            final long rotateRight = Long.rotateRight(n3 ^ array4[0], 33);
            this.weakHashLength32WithSeeds(array, n, array3[1] * -8261664234251669945L, n2 + array4[0], array3);
            this.weakHashLength32WithSeeds(array, n + 32, rotateRight + array4[1], access$200, array4);
            final long n4 = Long.rotateRight(rotateRight + access$200 + array3[0] + LittleEndianByteArray.load64(array, n + 80), 37) * -8261664234251669945L;
            access$200 = Long.rotateRight(access$200 + array3[1] + LittleEndianByteArray.load64(array, n + 112), 42) * -8261664234251669945L;
            n3 = (n4 ^ array4[1]);
            access$200 ^= array3[0];
            n2 = Long.rotateRight(n2 ^ array4[0], 33);
            this.weakHashLength32WithSeeds(array, n + 64, array3[1] * -8261664234251669945L, n3 + array4[0], array3);
            this.weakHashLength32WithSeeds(array, n + 96, n2 + array4[1], access$200, array4);
            n += 128;
            i -= 128;
        } while (i >= 128);
        access$200 += Long.rotateRight(array4[0], 37) * -6505348102511208375L + n3;
        n2 += Long.rotateRight(array3[0] + n3, 49) * -6505348102511208375L;
        n += i - 32;
        while (i > 0) {
            access$200 = Long.rotateRight(access$200 - n2, 42) * -6505348102511208375L + array3[1];
            final long[] array5 = array4;
            final int n5 = 0;
            array5[n5] += LittleEndianByteArray.load64(array, n + 16);
            n2 = Long.rotateRight(n2, 49) * -6505348102511208375L + array4[0];
            final long[] array6 = array4;
            final int n6 = 0;
            array6[n6] += array3[0];
            this.weakHashLength32WithSeeds(array, n, array3[0], array3[1], array3);
            n -= 32;
            i -= 32;
        }
        n2 = hashLength16(n2, array3[0]);
        access$200 = hashLength16(access$200, array4[0]);
        LittleEndianByteArray.store64(array2, 0, hashLength16(n2 + array4[1], access$200 + array3[1]));
        LittleEndianByteArray.store64(array2, 8, hashLength16(n2 + array3[1], array4[1]) + access$200);
        return HashCode.fromBytesNoCopy(array2);
    }
    
    private void weakHashLength32WithSeeds(final byte[] array, final int n, long n2, long rotateRight, final long[] array2) {
        final long load64 = LittleEndianByteArray.load64(array, n);
        final long load65 = LittleEndianByteArray.load64(array, n + 8);
        final long load66 = LittleEndianByteArray.load64(array, n + 16);
        final long load67 = LittleEndianByteArray.load64(array, n + 24);
        n2 += load64;
        rotateRight = Long.rotateRight(rotateRight + n2 + load67, 51);
        final long n3 = n2;
        n2 += load65;
        n2 += load66;
        rotateRight += Long.rotateRight(n2, 23);
        array2[0] = n2 + load67;
        array2[1] = rotateRight + n3;
    }
}
