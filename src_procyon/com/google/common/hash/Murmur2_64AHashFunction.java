package com.google.common.hash;

import com.google.common.annotations.*;
import java.nio.*;
import javax.annotation.*;

@GoogleInternal
final class Murmur2_64AHashFunction extends AbstractNonStreamingHashFunction
{
    private static final long M = -4132994306676758123L;
    private static final int R = 47;
    private final long seed;
    
    Murmur2_64AHashFunction(final long seed) {
        this.seed = seed;
    }
    
    @Override
    public HashCode hashBytes(final byte[] array, final int n, final int n2) {
        final ByteBuffer order = ByteBuffer.wrap(array, n, n2).order(ByteOrder.LITTLE_ENDIAN);
        long n3 = this.seed ^ order.remaining() * -4132994306676758123L;
        while (order.remaining() >= 8) {
            final long n4 = order.getLong() * -4132994306676758123L;
            n3 = (n3 ^ (n4 ^ n4 >>> 47) * -4132994306676758123L) * -4132994306676758123L;
        }
        if (order.hasRemaining()) {
            int n5 = 0;
            while (order.hasRemaining()) {
                n3 ^= (order.get() & 0xFFL) << n5;
                n5 += 8;
            }
            n3 *= -4132994306676758123L;
        }
        final long n6 = (n3 ^ n3 >>> 47) * -4132994306676758123L;
        return HashCode.fromLong(n6 ^ n6 >>> 47);
    }
    
    @Override
    public int bits() {
        return 64;
    }
    
    @Override
    public String toString() {
        return new StringBuilder(46).append("LegacyHashing.murmur2_64(").append(this.seed).append(")").toString();
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return o instanceof Murmur2_64AHashFunction && this.seed == ((Murmur2_64AHashFunction)o).seed;
    }
    
    @Override
    public int hashCode() {
        return (int)(this.seed ^ this.getClass().hashCode());
    }
}
