package com.google.security.zynamics.zylib.general;

import java.util.*;

public final class ByteHelpers
{
    public static byte[] combine(final List list) {
        int n = 0;
        final Iterator<byte[]> iterator = list.iterator();
        while (iterator.hasNext()) {
            n += iterator.next().length;
        }
        final byte[] array = new byte[n];
        int n2 = 0;
        for (final byte[] array2 : list) {
            System.arraycopy(array2, 0, array, n2, array2.length);
            n2 += array2.length;
        }
        return array;
    }
    
    public static long readDwordBigEndian(final byte[] array, final int n) {
        return (array[n + 0] & 0xFFL) * 256L * 256L * 256L + (array[n + 1] & 0xFFL) * 256L * 256L + (array[n + 2] & 0xFFL) * 256L + (array[n + 3] & 0xFFL);
    }
    
    public static long readDwordLittleEndian(final byte[] array, final int n) {
        return (array[n + 3] & 0xFFL) * 256L * 256L * 256L + (array[n + 2] & 0xFFL) * 256L * 256L + (array[n + 1] & 0xFFL) * 256L + (array[n + 0] & 0xFFL);
    }
    
    public static long readQwordBigEndian(final byte[] array, final int n) {
        return (array[n + 0] & 0xFFL) * 256L * 256L * 256L * 256L * 256L * 256L * 256L + (array[n + 1] & 0xFFL) * 256L * 256L * 256L * 256L * 256L * 256L + (array[n + 2] & 0xFFL) * 256L * 256L * 256L * 256L * 256L + (array[n + 3] & 0xFFL) * 256L * 256L * 256L * 256L + (array[n + 4] & 0xFFL) * 256L * 256L * 256L + (array[n + 5] & 0xFFL) * 256L * 256L + (array[n + 6] & 0xFFL) * 256L + (array[n + 7] & 0xFFL);
    }
    
    public static long readQwordLittleEndian(final byte[] array, final int n) {
        return (array[n + 7] & 0xFFL) * 256L * 256L * 256L * 256L * 256L * 256L * 256L + (array[n + 6] & 0xFFL) * 256L * 256L * 256L * 256L * 256L * 256L + (array[n + 5] & 0xFFL) * 256L * 256L * 256L * 256L * 256L + (array[n + 4] & 0xFFL) * 256L * 256L * 256L * 256L + (array[n + 3] & 0xFFL) * 256L * 256L * 256L + (array[n + 2] & 0xFFL) * 256L * 256L + (array[n + 1] & 0xFFL) * 256L + (array[n + 0] & 0xFFL);
    }
    
    public static long readWordBigEndian(final byte[] array, final int n) {
        return (array[n + 0] & 0xFFL) * 256L + (array[n + 1] & 0xFFL);
    }
    
    public static long readWordLittleEndian(final byte[] array, final int n) {
        return (array[n + 1] & 0xFFL) * 256L + (array[n + 0] & 0xFFL);
    }
    
    public static byte[] toArray(final List list) {
        final byte[] array = new byte[list.size()];
        for (int i = 0; i < array.length; ++i) {
            array[i] = list.get(i);
        }
        return array;
    }
    
    public static byte[] toBigEndianDword(final long n) {
        return new byte[] { (byte)((n & 0xFF000000L) >>> 24), (byte)((n & 0xFF0000L) >>> 16), (byte)((n & 0xFF00L) >>> 8), (byte)(n & 0xFFL) };
    }
    
    public static byte[] toBigEndianWord(final long n) {
        return new byte[] { (byte)((n & 0xFF00L) >>> 8), (byte)(n & 0xFFL) };
    }
    
    public static byte[] toLittleEndianDword(final long n) {
        return new byte[] { (byte)(n & 0xFFL), (byte)((n & 0xFF00L) >>> 8), (byte)((n & 0xFF0000L) >>> 16), (byte)((n & 0xFF000000L) >>> 24) };
    }
    
    public static byte[] toLittleEndianWord(final long n) {
        return new byte[] { (byte)(n & 0xFFL), (byte)((n & 0xFF00L) >>> 8) };
    }
}
