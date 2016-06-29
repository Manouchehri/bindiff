/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.hash.AbstractStreamingHashFunction$AbstractStreamingHasher;
import com.google.common.hash.HashCode;
import com.google.common.primitives.UnsignedBytes;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

final class Murmur3_128HashFunction$Murmur3_128Hasher
extends AbstractStreamingHashFunction$AbstractStreamingHasher {
    private static final int CHUNK_SIZE = 16;
    private static final long C1 = -8663945395140668459L;
    private static final long C2 = 5545529020109919103L;
    private long h1;
    private long h2;
    private int length;

    Murmur3_128HashFunction$Murmur3_128Hasher(int n2) {
        super(16);
        this.h1 = n2;
        this.h2 = n2;
        this.length = 0;
    }

    @Override
    protected void process(ByteBuffer byteBuffer) {
        long l2 = byteBuffer.getLong();
        long l3 = byteBuffer.getLong();
        this.bmix64(l2, l3);
        this.length += 16;
    }

    private void bmix64(long l2, long l3) {
        this.h1 ^= Murmur3_128HashFunction$Murmur3_128Hasher.mixK1(l2);
        this.h1 = Long.rotateLeft(this.h1, 27);
        this.h1 += this.h2;
        this.h1 = this.h1 * 5 + 1390208809;
        this.h2 ^= Murmur3_128HashFunction$Murmur3_128Hasher.mixK2(l3);
        this.h2 = Long.rotateLeft(this.h2, 31);
        this.h2 += this.h1;
        this.h2 = this.h2 * 5 + 944331445;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    protected void processRemaining(ByteBuffer var1_1) {
        var2_2 = 0;
        var4_3 = 0;
        this.length += var1_1.remaining();
        switch (var1_1.remaining()) {
            case 15: {
                var4_3 ^= (long)UnsignedBytes.toInt(var1_1.get(14)) << 48;
            }
            case 14: {
                var4_3 ^= (long)UnsignedBytes.toInt(var1_1.get(13)) << 40;
            }
            case 13: {
                var4_3 ^= (long)UnsignedBytes.toInt(var1_1.get(12)) << 32;
            }
            case 12: {
                var4_3 ^= (long)UnsignedBytes.toInt(var1_1.get(11)) << 24;
            }
            case 11: {
                var4_3 ^= (long)UnsignedBytes.toInt(var1_1.get(10)) << 16;
            }
            case 10: {
                var4_3 ^= (long)UnsignedBytes.toInt(var1_1.get(9)) << 8;
            }
            case 9: {
                var4_3 ^= (long)UnsignedBytes.toInt(var1_1.get(8));
            }
            case 8: {
                var2_2 ^= var1_1.getLong();
                ** break;
            }
            case 7: {
                var2_2 ^= (long)UnsignedBytes.toInt(var1_1.get(6)) << 48;
            }
            case 6: {
                var2_2 ^= (long)UnsignedBytes.toInt(var1_1.get(5)) << 40;
            }
            case 5: {
                var2_2 ^= (long)UnsignedBytes.toInt(var1_1.get(4)) << 32;
            }
            case 4: {
                var2_2 ^= (long)UnsignedBytes.toInt(var1_1.get(3)) << 24;
            }
            case 3: {
                var2_2 ^= (long)UnsignedBytes.toInt(var1_1.get(2)) << 16;
            }
            case 2: {
                var2_2 ^= (long)UnsignedBytes.toInt(var1_1.get(1)) << 8;
            }
            case 1: {
                var2_2 ^= (long)UnsignedBytes.toInt(var1_1.get(0));
                ** break;
            }
        }
        throw new AssertionError((Object)"Should never get here.");
lbl38: // 2 sources:
        this.h1 ^= Murmur3_128HashFunction$Murmur3_128Hasher.mixK1(var2_2);
        this.h2 ^= Murmur3_128HashFunction$Murmur3_128Hasher.mixK2(var4_3);
    }

    @Override
    public HashCode makeHash() {
        this.h1 ^= (long)this.length;
        this.h2 ^= (long)this.length;
        this.h1 += this.h2;
        this.h2 += this.h1;
        this.h1 = Murmur3_128HashFunction$Murmur3_128Hasher.fmix64(this.h1);
        this.h2 = Murmur3_128HashFunction$Murmur3_128Hasher.fmix64(this.h2);
        this.h1 += this.h2;
        this.h2 += this.h1;
        return HashCode.fromBytesNoCopy(ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN).putLong(this.h1).putLong(this.h2).array());
    }

    private static long fmix64(long l2) {
        l2 ^= l2 >>> 33;
        l2 *= -49064778989728563L;
        l2 ^= l2 >>> 33;
        l2 *= -4265267296055464877L;
        l2 ^= l2 >>> 33;
        return l2;
    }

    private static long mixK1(long l2) {
        l2 *= -8663945395140668459L;
        l2 = Long.rotateLeft(l2, 31);
        return l2 *= 5545529020109919103L;
    }

    private static long mixK2(long l2) {
        l2 *= 5545529020109919103L;
        l2 = Long.rotateLeft(l2, 33);
        return l2 *= -8663945395140668459L;
    }
}

