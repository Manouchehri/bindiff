/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.hash;

import com.google.common.annotations.GoogleInternal;
import com.google.common.hash.AbstractNonStreamingHashFunction;
import com.google.common.hash.HashCode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.annotation.Nullable;

@GoogleInternal
final class Murmur2_64AHashFunction
extends AbstractNonStreamingHashFunction {
    private static final long M = -4132994306676758123L;
    private static final int R = 47;
    private final long seed;

    Murmur2_64AHashFunction(long l2) {
        this.seed = l2;
    }

    @Override
    public HashCode hashBytes(byte[] arrby, int n2, int n3) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(arrby, n2, n3).order(ByteOrder.LITTLE_ENDIAN);
        long l2 = this.seed ^ (long)byteBuffer.remaining() * -4132994306676758123L;
        while (byteBuffer.remaining() >= 8) {
            long l3 = byteBuffer.getLong();
            l3 *= -4132994306676758123L;
            l3 ^= l3 >>> 47;
            l2 ^= (l3 *= -4132994306676758123L);
            l2 *= -4132994306676758123L;
        }
        if (byteBuffer.hasRemaining()) {
            int n4 = 0;
            while (byteBuffer.hasRemaining()) {
                l2 ^= ((long)byteBuffer.get() & 255) << n4;
                n4 += 8;
            }
            l2 *= -4132994306676758123L;
        }
        l2 ^= l2 >>> 47;
        l2 *= -4132994306676758123L;
        l2 ^= l2 >>> 47;
        return HashCode.fromLong(l2);
    }

    @Override
    public int bits() {
        return 64;
    }

    public String toString() {
        long l2 = this.seed;
        return new StringBuilder(46).append("LegacyHashing.murmur2_64(").append(l2).append(")").toString();
    }

    public boolean equals(@Nullable Object object) {
        if (!(object instanceof Murmur2_64AHashFunction)) return false;
        Murmur2_64AHashFunction murmur2_64AHashFunction = (Murmur2_64AHashFunction)object;
        if (this.seed != murmur2_64AHashFunction.seed) return false;
        return true;
    }

    public int hashCode() {
        return (int)(this.seed ^ (long)this.getClass().hashCode());
    }
}

