package com.google.common.hash;

import sun.misc.*;
import java.security.*;

enum LittleEndianByteArray$UnsafeByteArray implements LittleEndianByteArray$LittleEndianBytes
{
    UNSAFE_LITTLE_ENDIAN("UNSAFE_LITTLE_ENDIAN", 0), 
    UNSAFE_BIG_ENDIAN("UNSAFE_BIG_ENDIAN", 1);
    
    private static final Unsafe theUnsafe;
    private static final int BYTE_ARRAY_BASE_OFFSET;
    
    private LittleEndianByteArray$UnsafeByteArray(final String s, final int n) {
    }
    
    private static Unsafe getUnsafe() {
        try {
            return Unsafe.getUnsafe();
        }
        catch (SecurityException ex2) {
            try {
                return AccessController.doPrivileged((PrivilegedExceptionAction<Unsafe>)new LittleEndianByteArray$UnsafeByteArray$3());
            }
            catch (PrivilegedActionException ex) {
                throw new RuntimeException("Could not initialize intrinsics", ex.getCause());
            }
        }
    }
    
    static {
        theUnsafe = getUnsafe();
        BYTE_ARRAY_BASE_OFFSET = LittleEndianByteArray$UnsafeByteArray.theUnsafe.arrayBaseOffset(byte[].class);
        if (LittleEndianByteArray$UnsafeByteArray.theUnsafe.arrayIndexScale(byte[].class) != 1) {
            throw new AssertionError();
        }
    }
}
