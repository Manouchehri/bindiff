package com.google.common.hash;

import com.google.common.annotations.*;
import com.google.common.primitives.*;
import com.google.common.base.*;
import javax.annotation.*;

@Beta
public abstract class HashCode
{
    private static final char[] hexDigits;
    
    @CheckReturnValue
    public abstract int bits();
    
    @CheckReturnValue
    public abstract int asInt();
    
    @CheckReturnValue
    public abstract long asLong();
    
    @CheckReturnValue
    public abstract long padToLong();
    
    @CheckReturnValue
    public abstract byte[] asBytes();
    
    public int writeBytesTo(final byte[] array, final int n, int min) {
        min = Ints.min(min, this.bits() / 8);
        Preconditions.checkPositionIndexes(n, n + min, array.length);
        this.writeBytesToImpl(array, n, min);
        return min;
    }
    
    abstract void writeBytesToImpl(final byte[] p0, final int p1, final int p2);
    
    byte[] getBytesInternal() {
        return this.asBytes();
    }
    
    abstract boolean equalsSameBits(final HashCode p0);
    
    @CheckReturnValue
    public static HashCode fromInt(final int n) {
        return new HashCode$IntHashCode(n);
    }
    
    @CheckReturnValue
    public static HashCode fromLong(final long n) {
        return new HashCode$LongHashCode(n);
    }
    
    @CheckReturnValue
    public static HashCode fromBytes(final byte[] array) {
        Preconditions.checkArgument(array.length >= 1, (Object)"A HashCode must contain at least 1 byte.");
        return fromBytesNoCopy(array.clone());
    }
    
    static HashCode fromBytesNoCopy(final byte[] array) {
        return new HashCode$BytesHashCode(array);
    }
    
    @CheckReturnValue
    public static HashCode fromString(final String s) {
        Preconditions.checkArgument(s.length() >= 2, "input string (%s) must have at least 2 characters", s);
        Preconditions.checkArgument(s.length() % 2 == 0, "input string (%s) must have an even number of characters", s);
        final byte[] array = new byte[s.length() / 2];
        for (int i = 0; i < s.length(); i += 2) {
            array[i / 2] = (byte)((decode(s.charAt(i)) << 4) + decode(s.charAt(i + 1)));
        }
        return fromBytesNoCopy(array);
    }
    
    private static int decode(final char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'f') {
            return c - 'a' + '\n';
        }
        throw new IllegalArgumentException(new StringBuilder(32).append("Illegal hexadecimal character: ").append(c).toString());
    }
    
    @Override
    public final boolean equals(@Nullable final Object o) {
        if (o instanceof HashCode) {
            final HashCode hashCode = (HashCode)o;
            return this.bits() == hashCode.bits() && this.equalsSameBits(hashCode);
        }
        return false;
    }
    
    @Override
    public final int hashCode() {
        if (this.bits() >= 32) {
            return this.asInt();
        }
        final byte[] bytesInternal = this.getBytesInternal();
        int n = bytesInternal[0] & 0xFF;
        for (int i = 1; i < bytesInternal.length; ++i) {
            n |= (bytesInternal[i] & 0xFF) << i * 8;
        }
        return n;
    }
    
    @Override
    public final String toString() {
        final byte[] bytesInternal = this.getBytesInternal();
        final StringBuilder sb = new StringBuilder(2 * bytesInternal.length);
        for (final byte b : bytesInternal) {
            sb.append(HashCode.hexDigits[b >> 4 & 0xF]).append(HashCode.hexDigits[b & 0xF]);
        }
        return sb.toString();
    }
    
    static {
        hexDigits = "0123456789abcdef".toCharArray();
    }
}
