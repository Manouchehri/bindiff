/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.annotations.GoogleInternal;
import com.google.common.hash.LittleEndianByteArray$JavaLittleEndianBytes;
import com.google.common.hash.LittleEndianByteArray$LittleEndianBytes;
import com.google.common.hash.LittleEndianByteArray$UnsafeByteArray;
import java.nio.ByteOrder;

@GoogleInternal
final class LittleEndianByteArray {
    private static final LittleEndianByteArray$LittleEndianBytes byteArray;

    static long load64(byte[] arrby, int n2) {
        if ($assertionsDisabled) return byteArray.getLongLittleEndian(arrby, n2);
        if (arrby.length >= n2 + 8) return byteArray.getLongLittleEndian(arrby, n2);
        throw new AssertionError();
    }

    static long load64Safely(byte[] arrby, int n2, int n3) {
        long l2 = 0;
        int n4 = Math.min(n3, 8);
        int n5 = 0;
        while (n5 < n4) {
            l2 |= ((long)arrby[n2 + n5] & 255) << n5 * 8;
            ++n5;
        }
        return l2;
    }

    static void store64(byte[] arrby, int n2, long l2) {
        if (!$assertionsDisabled) {
            if (n2 < 0) throw new AssertionError();
            if (n2 + 8 > arrby.length) {
                throw new AssertionError();
            }
        }
        byteArray.putLongLittleEndian(arrby, n2, l2);
    }

    static int load32(byte[] arrby, int n2) {
        return arrby[n2] & 255 | (arrby[n2 + 1] & 255) << 8 | (arrby[n2 + 2] & 255) << 16 | (arrby[n2 + 3] & 255) << 24;
    }

    static boolean usingUnsafe() {
        return byteArray instanceof LittleEndianByteArray$UnsafeByteArray;
    }

    private LittleEndianByteArray() {
    }

    static {
        Enum enum_2;
        Enum enum_2;
        try {
            enum_2 = ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN) ? LittleEndianByteArray$UnsafeByteArray.UNSAFE_LITTLE_ENDIAN : LittleEndianByteArray$UnsafeByteArray.UNSAFE_BIG_ENDIAN;
        }
        catch (Throwable var1_1) {
            enum_2 = LittleEndianByteArray$JavaLittleEndianBytes.INSTANCE;
        }
        byteArray = enum_2;
    }
}

