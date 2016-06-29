/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.general;

import java.util.Iterator;
import java.util.List;

public final class ByteHelpers {
    public static byte[] combine(List list) {
        int n2 = 0;
        for (byte[] arrby : list) {
            n2 += arrby.length;
        }
        byte[] arrby2 = new byte[n2];
        int n3 = 0;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            byte[] arrby3 = (byte[])iterator.next();
            System.arraycopy(arrby3, 0, arrby2, n3, arrby3.length);
            n3 += arrby3.length;
        }
        return arrby2;
    }

    public static long readDwordBigEndian(byte[] arrby, int n2) {
        return ((long)arrby[n2 + 0] & 255) * 256 * 256 * 256 + ((long)arrby[n2 + 1] & 255) * 256 * 256 + ((long)arrby[n2 + 2] & 255) * 256 + ((long)arrby[n2 + 3] & 255);
    }

    public static long readDwordLittleEndian(byte[] arrby, int n2) {
        return ((long)arrby[n2 + 3] & 255) * 256 * 256 * 256 + ((long)arrby[n2 + 2] & 255) * 256 * 256 + ((long)arrby[n2 + 1] & 255) * 256 + ((long)arrby[n2 + 0] & 255);
    }

    public static long readQwordBigEndian(byte[] arrby, int n2) {
        return ((long)arrby[n2 + 0] & 255) * 256 * 256 * 256 * 256 * 256 * 256 * 256 + ((long)arrby[n2 + 1] & 255) * 256 * 256 * 256 * 256 * 256 * 256 + ((long)arrby[n2 + 2] & 255) * 256 * 256 * 256 * 256 * 256 + ((long)arrby[n2 + 3] & 255) * 256 * 256 * 256 * 256 + ((long)arrby[n2 + 4] & 255) * 256 * 256 * 256 + ((long)arrby[n2 + 5] & 255) * 256 * 256 + ((long)arrby[n2 + 6] & 255) * 256 + ((long)arrby[n2 + 7] & 255);
    }

    public static long readQwordLittleEndian(byte[] arrby, int n2) {
        return ((long)arrby[n2 + 7] & 255) * 256 * 256 * 256 * 256 * 256 * 256 * 256 + ((long)arrby[n2 + 6] & 255) * 256 * 256 * 256 * 256 * 256 * 256 + ((long)arrby[n2 + 5] & 255) * 256 * 256 * 256 * 256 * 256 + ((long)arrby[n2 + 4] & 255) * 256 * 256 * 256 * 256 + ((long)arrby[n2 + 3] & 255) * 256 * 256 * 256 + ((long)arrby[n2 + 2] & 255) * 256 * 256 + ((long)arrby[n2 + 1] & 255) * 256 + ((long)arrby[n2 + 0] & 255);
    }

    public static long readWordBigEndian(byte[] arrby, int n2) {
        return ((long)arrby[n2 + 0] & 255) * 256 + ((long)arrby[n2 + 1] & 255);
    }

    public static long readWordLittleEndian(byte[] arrby, int n2) {
        return ((long)arrby[n2 + 1] & 255) * 256 + ((long)arrby[n2 + 0] & 255);
    }

    public static byte[] toArray(List list) {
        byte[] arrby = new byte[list.size()];
        int n2 = 0;
        while (n2 < arrby.length) {
            arrby[n2] = ((Byte)list.get(n2)).byteValue();
            ++n2;
        }
        return arrby;
    }

    public static byte[] toBigEndianDword(long l2) {
        return new byte[]{(byte)((l2 & 0xFF000000L) >>> 24), (byte)((l2 & 0xFF0000) >>> 16), (byte)((l2 & 65280) >>> 8), (byte)(l2 & 255)};
    }

    public static byte[] toBigEndianWord(long l2) {
        return new byte[]{(byte)((l2 & 65280) >>> 8), (byte)(l2 & 255)};
    }

    public static byte[] toLittleEndianDword(long l2) {
        return new byte[]{(byte)(l2 & 255), (byte)((l2 & 65280) >>> 8), (byte)((l2 & 0xFF0000) >>> 16), (byte)((l2 & 0xFF000000L) >>> 24)};
    }

    public static byte[] toLittleEndianWord(long l2) {
        return new byte[]{(byte)(l2 & 255), (byte)((l2 & 65280) >>> 8)};
    }
}

