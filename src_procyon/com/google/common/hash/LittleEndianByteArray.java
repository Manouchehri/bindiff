package com.google.common.hash;

import com.google.common.annotations.*;
import java.nio.*;

@GoogleInternal
final class LittleEndianByteArray
{
    private static final LittleEndianByteArray$LittleEndianBytes byteArray;
    
    static long load64(final byte[] array, final int n) {
        assert array.length >= n + 8;
        return LittleEndianByteArray.byteArray.getLongLittleEndian(array, n);
    }
    
    static long load64Safely(final byte[] array, final int n, final int n2) {
        long n3 = 0L;
        for (int min = Math.min(n2, 8), i = 0; i < min; ++i) {
            n3 |= (array[n + i] & 0xFFL) << i * 8;
        }
        return n3;
    }
    
    static void store64(final byte[] array, final int n, final long n2) {
        assert n >= 0 && n + 8 <= array.length;
        LittleEndianByteArray.byteArray.putLongLittleEndian(array, n, n2);
    }
    
    static int load32(final byte[] array, final int n) {
        return (array[n] & 0xFF) | (array[n + 1] & 0xFF) << 8 | (array[n + 2] & 0xFF) << 16 | (array[n + 3] & 0xFF) << 24;
    }
    
    static boolean usingUnsafe() {
        return LittleEndianByteArray.byteArray instanceof LittleEndianByteArray$UnsafeByteArray;
    }
    
    static {
        LittleEndianByteArray$LittleEndianBytes instance;
        try {
            instance = (ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN) ? LittleEndianByteArray$UnsafeByteArray.UNSAFE_LITTLE_ENDIAN : LittleEndianByteArray$UnsafeByteArray.UNSAFE_BIG_ENDIAN);
        }
        catch (Throwable t) {
            instance = LittleEndianByteArray$JavaLittleEndianBytes.INSTANCE;
        }
        byteArray = instance;
    }
}
