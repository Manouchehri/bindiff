/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteProcessor;
import com.google.common.io.ByteStreams$1;
import com.google.common.io.ByteStreams$ByteArrayDataInputStream;
import com.google.common.io.ByteStreams$ByteArrayDataOutputStream;
import com.google.common.io.ByteStreams$FastByteArrayOutputStream;
import com.google.common.io.ByteStreams$LimitedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Arrays;

@Beta
public final class ByteStreams {
    private static final int BUF_SIZE = 8192;
    private static final int ZERO_COPY_CHUNK_SIZE = 524288;
    private static final OutputStream NULL_OUTPUT_STREAM = new ByteStreams$1();

    private ByteStreams() {
    }

    public static long copy(InputStream inputStream, OutputStream outputStream) {
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(outputStream);
        byte[] arrby = new byte[8192];
        long l2 = 0;
        int n2;
        while ((n2 = inputStream.read(arrby)) != -1) {
            outputStream.write(arrby, 0, n2);
            l2 += (long)n2;
        }
        return l2;
    }

    public static long copy(ReadableByteChannel readableByteChannel, WritableByteChannel writableByteChannel) {
        Preconditions.checkNotNull(readableByteChannel);
        Preconditions.checkNotNull(writableByteChannel);
        if (readableByteChannel instanceof FileChannel) {
            long l2;
            long l3;
            FileChannel fileChannel = (FileChannel)readableByteChannel;
            long l4 = l2 = fileChannel.position();
            do {
                l3 = fileChannel.transferTo(l4, 524288, writableByteChannel);
                fileChannel.position(l4 += l3);
            } while (l3 > 0 || l4 < fileChannel.size());
            return l4 - l2;
        }
        ByteBuffer byteBuffer = ByteBuffer.allocate(8192);
        long l5 = 0;
        while (readableByteChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                l5 += (long)writableByteChannel.write(byteBuffer);
            }
            byteBuffer.clear();
        }
        return l5;
    }

    public static byte[] toByteArray(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteStreams.copy(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    static byte[] toByteArray(InputStream inputStream, int n2) {
        int n3;
        int n4;
        byte[] arrby = new byte[n2];
        for (int i2 = n2; i2 > 0; i2 -= n4) {
            n3 = n2 - i2;
            n4 = inputStream.read(arrby, n3, i2);
            if (n4 != -1) continue;
            return Arrays.copyOf(arrby, n3);
        }
        n3 = inputStream.read();
        if (n3 == -1) {
            return arrby;
        }
        ByteStreams$FastByteArrayOutputStream byteStreams$FastByteArrayOutputStream = new ByteStreams$FastByteArrayOutputStream(null);
        byteStreams$FastByteArrayOutputStream.write(n3);
        ByteStreams.copy(inputStream, byteStreams$FastByteArrayOutputStream);
        byte[] arrby2 = new byte[arrby.length + byteStreams$FastByteArrayOutputStream.size()];
        System.arraycopy(arrby, 0, arrby2, 0, arrby.length);
        byteStreams$FastByteArrayOutputStream.writeTo(arrby2, arrby.length);
        return arrby2;
    }

    public static ByteArrayDataInput newDataInput(byte[] arrby) {
        return ByteStreams.newDataInput(new ByteArrayInputStream(arrby));
    }

    public static ByteArrayDataInput newDataInput(byte[] arrby, int n2) {
        Preconditions.checkPositionIndex(n2, arrby.length);
        return ByteStreams.newDataInput(new ByteArrayInputStream(arrby, n2, arrby.length - n2));
    }

    public static ByteArrayDataInput newDataInput(ByteArrayInputStream byteArrayInputStream) {
        return new ByteStreams$ByteArrayDataInputStream((ByteArrayInputStream)Preconditions.checkNotNull(byteArrayInputStream));
    }

    public static ByteArrayDataOutput newDataOutput() {
        return ByteStreams.newDataOutput(new ByteArrayOutputStream());
    }

    public static ByteArrayDataOutput newDataOutput(int n2) {
        if (n2 >= 0) return ByteStreams.newDataOutput(new ByteArrayOutputStream(n2));
        throw new IllegalArgumentException(String.format("Invalid size: %s", n2));
    }

    public static ByteArrayDataOutput newDataOutput(ByteArrayOutputStream byteArrayOutputStream) {
        return new ByteStreams$ByteArrayDataOutputStream((ByteArrayOutputStream)Preconditions.checkNotNull(byteArrayOutputStream));
    }

    public static OutputStream nullOutputStream() {
        return NULL_OUTPUT_STREAM;
    }

    public static InputStream limit(InputStream inputStream, long l2) {
        return new ByteStreams$LimitedInputStream(inputStream, l2);
    }

    public static void readFully(InputStream inputStream, byte[] arrby) {
        ByteStreams.readFully(inputStream, arrby, 0, arrby.length);
    }

    public static void readFully(InputStream inputStream, byte[] arrby, int n2, int n3) {
        int n4 = ByteStreams.read(inputStream, arrby, n2, n3);
        if (n4 == n3) return;
        throw new EOFException(new StringBuilder(81).append("reached end of stream after reading ").append(n4).append(" bytes; ").append(n3).append(" bytes expected").toString());
    }

    public static void skipFully(InputStream inputStream, long l2) {
        long l3 = l2;
        while (l2 > 0) {
            long l4 = inputStream.skip(l2);
            if (l4 == 0) {
                if (inputStream.read() == -1) {
                    long l5 = l3 - l2;
                    throw new EOFException(new StringBuilder(100).append("reached end of stream after skipping ").append(l5).append(" bytes; ").append(l3).append(" bytes expected").toString());
                }
                --l2;
                continue;
            }
            l2 -= l4;
        }
    }

    public static Object readBytes(InputStream inputStream, ByteProcessor byteProcessor) {
        int n2;
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(byteProcessor);
        byte[] arrby = new byte[8192];
        do {
            if ((n2 = inputStream.read(arrby)) == -1) return byteProcessor.getResult();
        } while (byteProcessor.processBytes(arrby, 0, n2));
        return byteProcessor.getResult();
    }

    public static int read(InputStream inputStream, byte[] arrby, int n2, int n3) {
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(arrby);
        if (n3 < 0) {
            throw new IndexOutOfBoundsException("len is negative");
        }
        int n4 = 0;
        while (n4 < n3) {
            int n5 = inputStream.read(arrby, n2 + n4, n3 - n4);
            if (n5 == -1) {
                return n4;
            }
            n4 += n5;
        }
        return n4;
    }
}

