package com.google.common.hash;

import com.google.common.base.*;
import javax.annotation.*;
import java.util.*;
import com.google.common.annotations.*;
import java.nio.*;

@GoogleInternal
final class CityHash128HashFunction extends AbstractNonStreamingHashFunction
{
    private static final long K0 = -6505348102511208375L;
    private static final long K1 = -8261664234251669945L;
    private static final long K2 = -4288712594273399085L;
    private static final long K3 = -4102945252841444853L;
    private static final long K4 = -4132994306676758123L;
    private final long[] seed;
    private static final CityHash128HashFunction$InternalImplementation impl;
    
    CityHash128HashFunction(final long n, final long n2) {
        (this.seed = new long[2])[0] = n;
        this.seed[1] = n2;
    }
    
    CityHash128HashFunction() {
        this.seed = null;
    }
    
    @Override
    public HashCode hashBytes(final byte[] array) {
        return this.hashBytes(array, 0, array.length);
    }
    
    @Override
    public HashCode hashBytes(final byte[] array, final int n, final int n2) {
        Preconditions.checkArgument(n >= 0, "offset (%s) cannot be negative", n);
        Preconditions.checkArgument(n2 >= 0, "length (%s) cannot be negative", n2);
        Preconditions.checkArgument(n + n2 <= array.length, "offset (%s) + length (%s) cannot be greater than the byte array length (%s)", n, n2, array.length);
        return CityHash128HashFunction.impl.fingerprint(array, n, n2, this.seed);
    }
    
    @Override
    public String toString() {
        return (this.seed == null) ? "Hashing.cityHash128()" : new StringBuilder(63).append("Hashing.cityHash128(").append(this.seed[0]).append(", ").append(this.seed[1]).append(")").toString();
    }
    
    @Override
    public int bits() {
        return 128;
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return o instanceof CityHash128HashFunction && Arrays.equals(this.seed, ((CityHash128HashFunction)o).seed);
    }
    
    @Override
    public int hashCode() {
        return (this.seed == null) ? this.getClass().hashCode() : ((int)(this.getClass().hashCode() ^ this.seed[0] ^ this.seed[1]));
    }
    
    @VisibleForTesting
    static HashCode hashBytesUsingUnsafe(final byte[] array) {
        return CityHash128HashFunction$Internal.UsingUnsafe.fingerprint(array, 0, array.length, null);
    }
    
    @VisibleForTesting
    static HashCode hashBytesUsingByteBuffer(final byte[] array) {
        return CityHash128HashFunction$Internal.UsingByteBuffer.fingerprint(array, 0, array.length, null);
    }
    
    private static HashCode cityMurmur(final byte[] array, final int n, int i, long hashLength16, long hashLength17) {
        long hashLength18;
        long n2;
        if (i <= 16) {
            hashLength18 = hashLength17 * -8261664234251669945L + hashLength0To16(array, n, i);
            n2 = Long.rotateRight(hashLength16 + ((i >= 8) ? LittleEndianByteArray.load64(array, n) : hashLength18), 32);
        }
        else {
            hashLength18 = hashLength16(LittleEndianByteArray.load64(array, n + i - 8) - 8261664234251669945L, hashLength16);
            n2 = hashLength16(hashLength17 + i, hashLength18 + LittleEndianByteArray.load64(array, n + i - 16));
            hashLength16 += n2;
            final ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i);
            allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            allocateDirect.put(array, n, i);
            allocateDirect.position(0);
            i -= 16;
            do {
                hashLength16 ^= shiftMix(allocateDirect.getLong() * -8261664234251669945L) * -8261664234251669945L;
                hashLength16 *= -8261664234251669945L;
                hashLength17 ^= hashLength16;
                hashLength18 = (hashLength18 ^ shiftMix(allocateDirect.getLong() * -8261664234251669945L) * -8261664234251669945L) * -8261664234251669945L;
                n2 ^= hashLength18;
                i -= 16;
            } while (i > 0);
        }
        hashLength16 = hashLength16(hashLength16, hashLength18);
        hashLength17 = hashLength16(n2, hashLength17);
        final byte[] array2 = new byte[16];
        LittleEndianByteArray.store64(array2, 0, hashLength16(hashLength17, hashLength16));
        LittleEndianByteArray.store64(array2, 8, hashLength16 ^ hashLength17);
        return HashCode.fromBytesNoCopy(array2);
    }
    
    private static long hashLength16(final long n, final long n2) {
        final long n3 = (n2 ^ n) * -4132994306676758123L;
        final long n4 = (n ^ (n3 ^ n3 >>> 47)) * -4132994306676758123L;
        return (n4 ^ n4 >>> 47) * -4132994306676758123L;
    }
    
    private static long hashLength0To16(final byte[] array, final int n, final int n2) {
        if (n2 > 8) {
            final long load64 = LittleEndianByteArray.load64(array, n);
            final long load65 = LittleEndianByteArray.load64(array, n + n2 - 8);
            return hashLength16(load64, Long.rotateRight(load65 + n2, n2)) ^ load65;
        }
        if (n2 >= 4) {
            return hashLength16(n2 + ((LittleEndianByteArray.load32(array, n) & 0xFFFFFFFFL) << 3), LittleEndianByteArray.load32(array, n + n2 - 4) & 0xFFFFFFFFL);
        }
        if (n2 > 0) {
            return shiftMix(((array[n] & 0xFF) + ((array[n2 >> 1] & 0xFF) << 8)) * -4288712594273399085L ^ (n2 + ((array[n2 - 1] & 0xFF) << 2)) * -4102945252841444853L) * -4288712594273399085L;
        }
        return -4288712594273399085L;
    }
    
    private static long shiftMix(final long n) {
        return n ^ n >>> 47;
    }
    
    static {
        impl = (LittleEndianByteArray.usingUnsafe() ? CityHash128HashFunction$Internal.UsingUnsafe : CityHash128HashFunction$Internal.UsingByteBuffer);
    }
}
