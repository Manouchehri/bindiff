package com.google.common.io;

import com.google.common.annotations.*;
import java.nio.*;
import com.google.common.base.*;
import java.io.*;

@GoogleInternal
public final class ByteBuffers
{
    public static ByteBuffer allocate(final int n) {
        return ByteBuffer.allocate(n).order(ByteOrder.LITTLE_ENDIAN);
    }
    
    public static ByteBuffer allocateDirect(final int n) {
        return ByteBuffer.allocateDirect(n).order(ByteOrder.LITTLE_ENDIAN);
    }
    
    public static ByteBuffer allocateDirectAndFlip(final int n) {
        final ByteBuffer order = ByteBuffer.allocateDirect(n).order(ByteOrder.LITTLE_ENDIAN);
        order.flip();
        return order;
    }
    
    public static ByteBuffer wrap(final byte[] array) {
        return ByteBuffer.wrap(array).order(ByteOrder.LITTLE_ENDIAN);
    }
    
    public static byte[] extractBytes(final ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0 && byteBuffer.position() == 0 && byteBuffer.limit() == byteBuffer.capacity()) {
            return byteBuffer.array();
        }
        final byte[] array = new byte[byteBuffer.remaining()];
        byteBuffer.get(array);
        byteBuffer.position(byteBuffer.position() - array.length);
        return array;
    }
    
    public static ByteSource asByteSource(final ByteBuffer byteBuffer) {
        Preconditions.checkNotNull(byteBuffer);
        return new ByteBuffers$1(byteBuffer);
    }
    
    public static InputStream newConsumingInputStream(final ByteBuffer byteBuffer) {
        Preconditions.checkNotNull(byteBuffer);
        return new ByteBuffers$2(byteBuffer);
    }
}
