package com.google.common.io;

import com.google.common.annotations.*;
import com.google.common.base.*;
import java.nio.channels.*;
import java.nio.*;
import java.util.*;
import java.io.*;

@Beta
public final class ByteStreams
{
    private static final int BUF_SIZE = 8192;
    private static final int ZERO_COPY_CHUNK_SIZE = 524288;
    private static final OutputStream NULL_OUTPUT_STREAM;
    
    public static long copy(final InputStream inputStream, final OutputStream outputStream) {
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(outputStream);
        final byte[] array = new byte[8192];
        long n = 0L;
        while (true) {
            final int read = inputStream.read(array);
            if (read == -1) {
                break;
            }
            outputStream.write(array, 0, read);
            n += read;
        }
        return n;
    }
    
    public static long copy(final ReadableByteChannel readableByteChannel, final WritableByteChannel writableByteChannel) {
        Preconditions.checkNotNull(readableByteChannel);
        Preconditions.checkNotNull(writableByteChannel);
        if (readableByteChannel instanceof FileChannel) {
            final FileChannel fileChannel = (FileChannel)readableByteChannel;
            long position;
            final long n = position = fileChannel.position();
            long transferTo;
            do {
                transferTo = fileChannel.transferTo(position, 524288L, writableByteChannel);
                position += transferTo;
                fileChannel.position(position);
            } while (transferTo > 0L || position < fileChannel.size());
            return position - n;
        }
        final ByteBuffer allocate = ByteBuffer.allocate(8192);
        long n2 = 0L;
        while (readableByteChannel.read(allocate) != -1) {
            allocate.flip();
            while (allocate.hasRemaining()) {
                n2 += writableByteChannel.write(allocate);
            }
            allocate.clear();
        }
        return n2;
    }
    
    public static byte[] toByteArray(final InputStream inputStream) {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copy(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
    
    static byte[] toByteArray(final InputStream inputStream, final int n) {
        final byte[] array = new byte[n];
        int read;
        for (int i = n; i > 0; i -= read) {
            final int n2 = n - i;
            read = inputStream.read(array, n2, i);
            if (read == -1) {
                return Arrays.copyOf(array, n2);
            }
        }
        final int read2 = inputStream.read();
        if (read2 == -1) {
            return array;
        }
        final ByteStreams$FastByteArrayOutputStream byteStreams$FastByteArrayOutputStream = new ByteStreams$FastByteArrayOutputStream(null);
        byteStreams$FastByteArrayOutputStream.write(read2);
        copy(inputStream, byteStreams$FastByteArrayOutputStream);
        final byte[] array2 = new byte[array.length + byteStreams$FastByteArrayOutputStream.size()];
        System.arraycopy(array, 0, array2, 0, array.length);
        byteStreams$FastByteArrayOutputStream.writeTo(array2, array.length);
        return array2;
    }
    
    public static ByteArrayDataInput newDataInput(final byte[] array) {
        return newDataInput(new ByteArrayInputStream(array));
    }
    
    public static ByteArrayDataInput newDataInput(final byte[] array, final int n) {
        Preconditions.checkPositionIndex(n, array.length);
        return newDataInput(new ByteArrayInputStream(array, n, array.length - n));
    }
    
    public static ByteArrayDataInput newDataInput(final ByteArrayInputStream byteArrayInputStream) {
        return new ByteStreams$ByteArrayDataInputStream((ByteArrayInputStream)Preconditions.checkNotNull(byteArrayInputStream));
    }
    
    public static ByteArrayDataOutput newDataOutput() {
        return newDataOutput(new ByteArrayOutputStream());
    }
    
    public static ByteArrayDataOutput newDataOutput(final int n) {
        if (n < 0) {
            throw new IllegalArgumentException(String.format("Invalid size: %s", n));
        }
        return newDataOutput(new ByteArrayOutputStream(n));
    }
    
    public static ByteArrayDataOutput newDataOutput(final ByteArrayOutputStream byteArrayOutputStream) {
        return new ByteStreams$ByteArrayDataOutputStream((ByteArrayOutputStream)Preconditions.checkNotNull(byteArrayOutputStream));
    }
    
    public static OutputStream nullOutputStream() {
        return ByteStreams.NULL_OUTPUT_STREAM;
    }
    
    public static InputStream limit(final InputStream inputStream, final long n) {
        return new ByteStreams$LimitedInputStream(inputStream, n);
    }
    
    public static void readFully(final InputStream inputStream, final byte[] array) {
        readFully(inputStream, array, 0, array.length);
    }
    
    public static void readFully(final InputStream inputStream, final byte[] array, final int n, final int n2) {
        final int read = read(inputStream, array, n, n2);
        if (read != n2) {
            throw new EOFException(new StringBuilder(81).append("reached end of stream after reading ").append(read).append(" bytes; ").append(n2).append(" bytes expected").toString());
        }
    }
    
    public static void skipFully(final InputStream inputStream, long n) {
        final long n2 = n;
        while (n > 0L) {
            final long skip = inputStream.skip(n);
            if (skip == 0L) {
                if (inputStream.read() == -1) {
                    throw new EOFException(new StringBuilder(100).append("reached end of stream after skipping ").append(n2 - n).append(" bytes; ").append(n2).append(" bytes expected").toString());
                }
                --n;
            }
            else {
                n -= skip;
            }
        }
    }
    
    public static Object readBytes(final InputStream inputStream, final ByteProcessor byteProcessor) {
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(byteProcessor);
        final byte[] array = new byte[8192];
        int read;
        do {
            read = inputStream.read(array);
        } while (read != -1 && byteProcessor.processBytes(array, 0, read));
        return byteProcessor.getResult();
    }
    
    public static int read(final InputStream inputStream, final byte[] array, final int n, final int n2) {
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(array);
        if (n2 < 0) {
            throw new IndexOutOfBoundsException("len is negative");
        }
        int i;
        int read;
        for (i = 0; i < n2; i += read) {
            read = inputStream.read(array, n + i, n2 - i);
            if (read == -1) {
                break;
            }
        }
        return i;
    }
    
    static {
        NULL_OUTPUT_STREAM = new ByteStreams$1();
    }
}
