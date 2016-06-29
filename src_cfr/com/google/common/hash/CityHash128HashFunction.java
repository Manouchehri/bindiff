/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.hash;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.hash.AbstractNonStreamingHashFunction;
import com.google.common.hash.CityHash128HashFunction$Internal;
import com.google.common.hash.CityHash128HashFunction$InternalImplementation;
import com.google.common.hash.HashCode;
import com.google.common.hash.LittleEndianByteArray;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import javax.annotation.Nullable;

@GoogleInternal
final class CityHash128HashFunction
extends AbstractNonStreamingHashFunction {
    private static final long K0 = -6505348102511208375L;
    private static final long K1 = -8261664234251669945L;
    private static final long K2 = -4288712594273399085L;
    private static final long K3 = -4102945252841444853L;
    private static final long K4 = -4132994306676758123L;
    private final long[] seed;
    private static final CityHash128HashFunction$InternalImplementation impl = LittleEndianByteArray.usingUnsafe() ? CityHash128HashFunction$Internal.UsingUnsafe : CityHash128HashFunction$Internal.UsingByteBuffer;

    CityHash128HashFunction(long l2, long l3) {
        this.seed = new long[2];
        this.seed[0] = l2;
        this.seed[1] = l3;
    }

    CityHash128HashFunction() {
        this.seed = null;
    }

    @Override
    public HashCode hashBytes(byte[] arrby) {
        return this.hashBytes(arrby, 0, arrby.length);
    }

    @Override
    public HashCode hashBytes(byte[] arrby, int n2, int n3) {
        Preconditions.checkArgument(n2 >= 0, "offset (%s) cannot be negative", n2);
        Preconditions.checkArgument(n3 >= 0, "length (%s) cannot be negative", n3);
        Preconditions.checkArgument(n2 + n3 <= arrby.length, "offset (%s) + length (%s) cannot be greater than the byte array length (%s)", n2, n3, arrby.length);
        return impl.fingerprint(arrby, n2, n3, this.seed);
    }

    public String toString() {
        if (this.seed == null) {
            return "Hashing.cityHash128()";
        }
        long l2 = this.seed[0];
        long l3 = this.seed[1];
        String string = new StringBuilder(63).append("Hashing.cityHash128(").append(l2).append(", ").append(l3).append(")").toString();
        return string;
    }

    @Override
    public int bits() {
        return 128;
    }

    public boolean equals(@Nullable Object object) {
        if (!(object instanceof CityHash128HashFunction)) return false;
        CityHash128HashFunction cityHash128HashFunction = (CityHash128HashFunction)object;
        return Arrays.equals(this.seed, cityHash128HashFunction.seed);
    }

    public int hashCode() {
        int n2;
        if (this.seed == null) {
            n2 = this.getClass().hashCode();
            return n2;
        }
        n2 = (int)((long)this.getClass().hashCode() ^ this.seed[0] ^ this.seed[1]);
        return n2;
    }

    @VisibleForTesting
    static HashCode hashBytesUsingUnsafe(byte[] arrby) {
        return CityHash128HashFunction$Internal.UsingUnsafe.fingerprint(arrby, 0, arrby.length, null);
    }

    @VisibleForTesting
    static HashCode hashBytesUsingByteBuffer(byte[] arrby) {
        return CityHash128HashFunction$Internal.UsingByteBuffer.fingerprint(arrby, 0, arrby.length, null);
    }

    private static HashCode cityMurmur(byte[] arrby, int n2, int n3, long l2, long l3) {
        Object object;
        long l4;
        long l5;
        if (n3 <= 16) {
            l5 = l3 * -8261664234251669945L + CityHash128HashFunction.hashLength0To16(arrby, n2, n3);
            l4 = Long.rotateRight(l2 + (n3 >= 8 ? LittleEndianByteArray.load64(arrby, n2) : l5), 32);
        } else {
            l5 = CityHash128HashFunction.hashLength16(LittleEndianByteArray.load64(arrby, n2 + n3 - 8) + -8261664234251669945L, l2);
            l4 = CityHash128HashFunction.hashLength16(l3 + (long)n3, l5 + LittleEndianByteArray.load64(arrby, n2 + n3 - 16));
            l2 += l4;
            object = ByteBuffer.allocateDirect(n3);
            object.order(ByteOrder.LITTLE_ENDIAN);
            object.put(arrby, n2, n3);
            object.position(0);
            n3 -= 16;
            do {
                l2 ^= CityHash128HashFunction.shiftMix(object.getLong() * -8261664234251669945L) * -8261664234251669945L;
                l3 ^= (l2 *= -8261664234251669945L);
                l5 ^= CityHash128HashFunction.shiftMix(object.getLong() * -8261664234251669945L) * -8261664234251669945L;
                l4 ^= (l5 *= -8261664234251669945L);
            } while ((n3 -= 16) > 0);
        }
        l2 = CityHash128HashFunction.hashLength16(l2, l5);
        l3 = CityHash128HashFunction.hashLength16(l4, l3);
        object = new byte[16];
        LittleEndianByteArray.store64((byte[])object, 0, CityHash128HashFunction.hashLength16(l3, l2));
        LittleEndianByteArray.store64((byte[])object, 8, l2 ^ l3);
        return HashCode.fromBytesNoCopy((byte[])object);
    }

    private static long hashLength16(long l2, long l3) {
        long l4 = (l3 ^ l2) * -4132994306676758123L;
        l4 ^= l4 >>> 47;
        long l5 = (l2 ^ l4) * -4132994306676758123L;
        l5 ^= l5 >>> 47;
        return l5 *= -4132994306676758123L;
    }

    private static long hashLength0To16(byte[] arrby, int n2, int n3) {
        if (n3 > 8) {
            long l2 = LittleEndianByteArray.load64(arrby, n2);
            long l3 = LittleEndianByteArray.load64(arrby, n2 + n3 - 8);
            return CityHash128HashFunction.hashLength16(l2, Long.rotateRight(l3 + (long)n3, n3)) ^ l3;
        }
        if (n3 >= 4) {
            long l4 = (long)LittleEndianByteArray.load32(arrby, n2) & 0xFFFFFFFFL;
            return CityHash128HashFunction.hashLength16((long)n3 + (l4 << 3), (long)LittleEndianByteArray.load32(arrby, n2 + n3 - 4) & 0xFFFFFFFFL);
        }
        if (n3 <= 0) return -4288712594273399085L;
        byte by2 = arrby[n2];
        byte by3 = arrby[n3 >> 1];
        byte by4 = arrby[n3 - 1];
        int n4 = (by2 & 255) + ((by3 & 255) << 8);
        int n5 = n3 + ((by4 & 255) << 2);
        return CityHash128HashFunction.shiftMix((long)n4 * -4288712594273399085L ^ (long)n5 * -4102945252841444853L) * -4288712594273399085L;
    }

    private static long shiftMix(long l2) {
        return l2 ^ l2 >>> 47;
    }

    static /* synthetic */ HashCode access$100(byte[] arrby, int n2, int n3, long l2, long l3) {
        return CityHash128HashFunction.cityMurmur(arrby, n2, n3, l2, l3);
    }

    static /* synthetic */ long access$200(long l2, long l3) {
        return CityHash128HashFunction.hashLength16(l2, l3);
    }
}

