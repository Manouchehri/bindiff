package com.google.security.zynamics.bindiff.utils;

import com.google.common.io.*;
import java.io.*;
import com.google.common.base.*;

public class IoReaderUtils
{
    public static synchronized byte[] readByteArray(final InputStream inputStream, final int n) {
        final byte[] array = new byte[n];
        if (ByteStreams.read(inputStream, array, 0, n) < n) {
            throw new IOException("Unexpected end of file");
        }
        return array;
    }
    
    public static int readIntegerValue(final InputStream inputStream, final int n) {
        Preconditions.checkArgument(n >= 1 && n <= 4, (Object)"Illegal length (not in range 1 to 4)");
        final byte[] byteArray = readByteArray(inputStream, n);
        int n2 = 0;
        for (int i = 0; i < n; ++i) {
            n2 |= (byteArray[i] & 0xFF) << i * 8;
        }
        return n2;
    }
    
    public static long readLongValue(final InputStream inputStream, final int n) {
        Preconditions.checkArgument(n >= 1 && n <= 8, (Object)"Illegal length (not in range 1 to 8)");
        final byte[] byteArray = readByteArray(inputStream, n);
        long n2 = 0L;
        for (int i = 0; i < n; ++i) {
            n2 |= (byteArray[i] & 0xFFL) << i * 8;
        }
        return n2;
    }
    
    public static long readUnsignedIntegerValue(final InputStream inputStream, final int n) {
        Preconditions.checkArgument(n >= 1 && n <= 4, (Object)"Illegal length (not in range 1 to 4)");
        return readLongValue(inputStream, n);
    }
    
    public static long skip(final InputStream inputStream, final int n) {
        if (n == 0) {
            return 0L;
        }
        long skip = inputStream.skip(n);
        if (skip != n) {
            skip += inputStream.skip(n - skip);
        }
        return skip;
    }
}
