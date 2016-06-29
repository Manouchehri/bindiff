package com.google.common.hash;

import java.nio.*;
import com.google.common.base.*;
import javax.annotation.*;
import java.util.*;
import com.google.common.annotations.*;

enum CityHash128HashFunction$Internal$2
{
    CityHash128HashFunction$Internal$2(final String s, final int n) {
    }
    
    @Override
    protected HashCode fingerprint(final byte[] array, int n, int i, long n2, long access$200) {
        if (i < 128) {
            return cityMurmur(array, n, i, n2, access$200);
        }
        final long[] array2 = new long[2];
        final long[] array3 = new long[2];
        long n3 = i * -8261664234251669945L;
        array2[0] = Long.rotateRight(access$200 ^ 0x8D58AC26AFE12E47L, 49) * -8261664234251669945L + LittleEndianByteArray.load64(array, n);
        array2[1] = Long.rotateRight(array2[0], 42) * -8261664234251669945L + LittleEndianByteArray.load64(array, n + 8);
        array3[0] = Long.rotateRight(access$200 + n3, 35) * -8261664234251669945L + n2;
        array3[1] = Long.rotateRight(n2 + LittleEndianByteArray.load64(array, n + 88), 53) * -8261664234251669945L;
        final ByteBuffer allocateDirect = ByteBuffer.allocateDirect(128);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        do {
            allocateDirect.position(0);
            allocateDirect.put(array, n, 128);
            n2 = Long.rotateRight(n2 + access$200 + array2[0] + allocateDirect.getLong(16), 37) * -8261664234251669945L;
            access$200 = Long.rotateRight(access$200 + array2[1] + allocateDirect.getLong(48), 42) * -8261664234251669945L;
            n2 ^= array3[1];
            access$200 ^= array2[0];
            final long rotateRight = Long.rotateRight(n3 ^ array3[0], 33);
            allocateDirect.position(0);
            this.weakHashLength32WithSeeds(allocateDirect, array2[1] * -8261664234251669945L, n2 + array3[0], array2);
            this.weakHashLength32WithSeeds(allocateDirect, rotateRight + array3[1], access$200, array3);
            final long n4 = Long.rotateRight(rotateRight + access$200 + array2[0] + LittleEndianByteArray.load64(array, n + 80), 37) * -8261664234251669945L;
            access$200 = Long.rotateRight(access$200 + array2[1] + LittleEndianByteArray.load64(array, n + 112), 42) * -8261664234251669945L;
            n3 = (n4 ^ array3[1]);
            access$200 ^= array2[0];
            n2 = Long.rotateRight(n2 ^ array3[0], 33);
            this.weakHashLength32WithSeeds(allocateDirect, array2[1] * -8261664234251669945L, n3 + array3[0], array2);
            this.weakHashLength32WithSeeds(allocateDirect, n2 + array3[1], access$200, array3);
            n += 128;
            i -= 128;
        } while (i >= 128);
        access$200 += Long.rotateRight(array3[0], 37) * -6505348102511208375L + n3;
        n2 += Long.rotateRight(array2[0] + n3, 49) * -6505348102511208375L;
        allocateDirect.position(0);
        final int n5 = i & 0x1F;
        int n6 = i ^ n5;
        final int n7 = 32 - n5;
        allocateDirect.put(array, n - n7, i + n7);
        while (i > 0) {
            access$200 = Long.rotateRight(access$200 - n2, 42) * -6505348102511208375L + array2[1];
            final long[] array4 = array3;
            final int n8 = 0;
            array4[n8] += allocateDirect.getLong(i + n7 - 16);
            n2 = Long.rotateRight(n2, 49) * -6505348102511208375L + array3[0];
            final long[] array5 = array3;
            final int n9 = 0;
            array5[n9] += array2[0];
            allocateDirect.position(n6);
            this.weakHashLength32WithSeeds(allocateDirect, array2[0], array2[1], array2);
            n6 -= 32;
            i -= 32;
        }
        n2 = hashLength16(n2, array2[0]);
        access$200 = hashLength16(access$200, array3[0]);
        allocateDirect.position(0);
        allocateDirect.putLong(hashLength16(n2 + array3[1], access$200 + array2[1])).putLong(hashLength16(n2 + array2[1], array3[1]) + access$200);
        final byte[] array6 = new byte[16];
        allocateDirect.position(0);
        allocateDirect.get(array6, 0, 16);
        return HashCode.fromBytesNoCopy(array6);
    }
    
    private void weakHashLength32WithSeeds(final ByteBuffer byteBuffer, long n, long rotateRight, final long[] array) {
        final long long1 = byteBuffer.getLong();
        final long long2 = byteBuffer.getLong();
        final long long3 = byteBuffer.getLong();
        final long long4 = byteBuffer.getLong();
        n += long1;
        rotateRight = Long.rotateRight(rotateRight + n + long4, 51);
        final long n2 = n;
        n += long2;
        n += long3;
        rotateRight += Long.rotateRight(n, 23);
        array[0] = n + long4;
        array[1] = rotateRight + n2;
    }
}
