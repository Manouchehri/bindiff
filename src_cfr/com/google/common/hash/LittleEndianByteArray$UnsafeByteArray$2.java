/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.hash.LittleEndianByteArray$1;
import com.google.common.hash.LittleEndianByteArray$UnsafeByteArray;

final class LittleEndianByteArray$UnsafeByteArray$2
extends LittleEndianByteArray$UnsafeByteArray {
    LittleEndianByteArray$UnsafeByteArray$2(String string2, int n3) {
        super(string, n2, null);
    }

    @Override
    public long getLongLittleEndian(byte[] arrby, int n2) {
        long l2 = LittleEndianByteArray$UnsafeByteArray.access$200().getLong((Object)arrby, (long)n2 + (long)LittleEndianByteArray$UnsafeByteArray.access$100());
        return Long.reverseBytes(l2);
    }

    @Override
    public void putLongLittleEndian(byte[] arrby, int n2, long l2) {
        long l3 = Long.reverseBytes(l2);
        LittleEndianByteArray$UnsafeByteArray.access$200().putLong((Object)arrby, (long)n2 + (long)LittleEndianByteArray$UnsafeByteArray.access$100(), l3);
    }
}

