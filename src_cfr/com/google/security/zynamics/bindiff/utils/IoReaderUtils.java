/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.utils;

import com.google.common.base.Preconditions;
import com.google.common.io.ByteStreams;
import java.io.IOException;
import java.io.InputStream;

public class IoReaderUtils {
    public static synchronized byte[] readByteArray(InputStream inputStream, int n2) {
        byte[] arrby = new byte[n2];
        int n3 = ByteStreams.read(inputStream, arrby, 0, n2);
        if (n3 >= n2) return arrby;
        throw new IOException("Unexpected end of file");
    }

    public static int readIntegerValue(InputStream inputStream, int n2) {
        Preconditions.checkArgument(n2 >= 1 && n2 <= 4, "Illegal length (not in range 1 to 4)");
        byte[] arrby = IoReaderUtils.readByteArray(inputStream, n2);
        int n3 = 0;
        int n4 = 0;
        while (n4 < n2) {
            int n5 = arrby[n4];
            n3 |= (n5 &= 255) << n4 * 8;
            ++n4;
        }
        return n3;
    }

    public static long readLongValue(InputStream inputStream, int n2) {
        Preconditions.checkArgument(n2 >= 1 && n2 <= 8, "Illegal length (not in range 1 to 8)");
        byte[] arrby = IoReaderUtils.readByteArray(inputStream, n2);
        long l2 = 0;
        int n3 = 0;
        while (n3 < n2) {
            long l3 = arrby[n3];
            l3 &= 255;
            l2 |= (l3 <<= n3 * 8);
            ++n3;
        }
        return l2;
    }

    public static long readUnsignedIntegerValue(InputStream inputStream, int n2) {
        Preconditions.checkArgument(n2 >= 1 && n2 <= 4, "Illegal length (not in range 1 to 4)");
        return IoReaderUtils.readLongValue(inputStream, n2);
    }

    public static long skip(InputStream inputStream, int n2) {
        if (n2 == 0) {
            return 0;
        }
        long l2 = inputStream.skip(n2);
        if (l2 == (long)n2) return l2;
        l2 += inputStream.skip((long)n2 - l2);
        return l2;
    }
}

