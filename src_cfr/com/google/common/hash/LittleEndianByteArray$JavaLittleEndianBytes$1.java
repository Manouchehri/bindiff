/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.hash.LittleEndianByteArray$1;
import com.google.common.hash.LittleEndianByteArray$JavaLittleEndianBytes;
import com.google.common.primitives.Longs;

final class LittleEndianByteArray$JavaLittleEndianBytes$1
extends LittleEndianByteArray$JavaLittleEndianBytes {
    LittleEndianByteArray$JavaLittleEndianBytes$1(String string2, int n3) {
        super(string, n2, null);
    }

    @Override
    public long getLongLittleEndian(byte[] arrby, int n2) {
        return Longs.fromBytes(arrby[n2 + 7], arrby[n2 + 6], arrby[n2 + 5], arrby[n2 + 4], arrby[n2 + 3], arrby[n2 + 2], arrby[n2 + 1], arrby[n2]);
    }

    @Override
    public void putLongLittleEndian(byte[] arrby, int n2, long l2) {
        long l3 = 255;
        int n3 = 0;
        while (n3 < 8) {
            arrby[n2 + n3] = (byte)((l2 & l3) >> n3 * 8);
            l3 <<= 8;
            ++n3;
        }
    }
}

