/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.Preconditions;
import com.google.common.io.ByteBuffers$1;
import com.google.common.io.ByteBuffers$2;
import com.google.common.io.ByteSource;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@GoogleInternal
public final class ByteBuffers {
    private ByteBuffers() {
    }

    public static ByteBuffer allocate(int n2) {
        return ByteBuffer.allocate(n2).order(ByteOrder.LITTLE_ENDIAN);
    }

    public static ByteBuffer allocateDirect(int n2) {
        return ByteBuffer.allocateDirect(n2).order(ByteOrder.LITTLE_ENDIAN);
    }

    public static ByteBuffer allocateDirectAndFlip(int n2) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(n2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.flip();
        return byteBuffer;
    }

    public static ByteBuffer wrap(byte[] arrby) {
        return ByteBuffer.wrap(arrby).order(ByteOrder.LITTLE_ENDIAN);
    }

    public static byte[] extractBytes(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0 && byteBuffer.position() == 0 && byteBuffer.limit() == byteBuffer.capacity()) {
            return byteBuffer.array();
        }
        byte[] arrby = new byte[byteBuffer.remaining()];
        byteBuffer.get(arrby);
        byteBuffer.position(byteBuffer.position() - arrby.length);
        return arrby;
    }

    public static ByteSource asByteSource(ByteBuffer byteBuffer) {
        Preconditions.checkNotNull(byteBuffer);
        return new ByteBuffers$1(byteBuffer);
    }

    public static InputStream newConsumingInputStream(ByteBuffer byteBuffer) {
        Preconditions.checkNotNull(byteBuffer);
        return new ByteBuffers$2(byteBuffer);
    }
}

