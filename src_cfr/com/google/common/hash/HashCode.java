/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 *  javax.annotation.Nullable
 */
package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode$BytesHashCode;
import com.google.common.hash.HashCode$IntHashCode;
import com.google.common.hash.HashCode$LongHashCode;
import com.google.common.primitives.Ints;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@Beta
public abstract class HashCode {
    private static final char[] hexDigits = "0123456789abcdef".toCharArray();

    HashCode() {
    }

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

    public int writeBytesTo(byte[] arrby, int n2, int n3) {
        n3 = Ints.min(n3, this.bits() / 8);
        Preconditions.checkPositionIndexes(n2, n2 + n3, arrby.length);
        this.writeBytesToImpl(arrby, n2, n3);
        return n3;
    }

    abstract void writeBytesToImpl(byte[] var1, int var2, int var3);

    byte[] getBytesInternal() {
        return this.asBytes();
    }

    abstract boolean equalsSameBits(HashCode var1);

    @CheckReturnValue
    public static HashCode fromInt(int n2) {
        return new HashCode$IntHashCode(n2);
    }

    @CheckReturnValue
    public static HashCode fromLong(long l2) {
        return new HashCode$LongHashCode(l2);
    }

    @CheckReturnValue
    public static HashCode fromBytes(byte[] arrby) {
        Preconditions.checkArgument(arrby.length >= 1, "A HashCode must contain at least 1 byte.");
        return HashCode.fromBytesNoCopy((byte[])arrby.clone());
    }

    static HashCode fromBytesNoCopy(byte[] arrby) {
        return new HashCode$BytesHashCode(arrby);
    }

    @CheckReturnValue
    public static HashCode fromString(String string) {
        Preconditions.checkArgument(string.length() >= 2, "input string (%s) must have at least 2 characters", string);
        Preconditions.checkArgument(string.length() % 2 == 0, "input string (%s) must have an even number of characters", string);
        byte[] arrby = new byte[string.length() / 2];
        int n2 = 0;
        while (n2 < string.length()) {
            int n3 = HashCode.decode(string.charAt(n2)) << 4;
            int n4 = HashCode.decode(string.charAt(n2 + 1));
            arrby[n2 / 2] = (byte)(n3 + n4);
            n2 += 2;
        }
        return HashCode.fromBytesNoCopy(arrby);
    }

    private static int decode(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - 48;
        }
        if (c2 < 'a') throw new IllegalArgumentException(new StringBuilder(32).append("Illegal hexadecimal character: ").append(c2).toString());
        if (c2 > 'f') throw new IllegalArgumentException(new StringBuilder(32).append("Illegal hexadecimal character: ").append(c2).toString());
        return c2 - 97 + 10;
    }

    public final boolean equals(@Nullable Object object) {
        if (!(object instanceof HashCode)) return false;
        HashCode hashCode = (HashCode)object;
        if (this.bits() != hashCode.bits()) return false;
        if (!this.equalsSameBits(hashCode)) return false;
        return true;
    }

    public final int hashCode() {
        if (this.bits() >= 32) {
            return this.asInt();
        }
        byte[] arrby = this.getBytesInternal();
        int n2 = arrby[0] & 255;
        int n3 = 1;
        while (n3 < arrby.length) {
            n2 |= (arrby[n3] & 255) << n3 * 8;
            ++n3;
        }
        return n2;
    }

    public final String toString() {
        byte[] arrby = this.getBytesInternal();
        StringBuilder stringBuilder = new StringBuilder(2 * arrby.length);
        byte[] arrby2 = arrby;
        int n2 = arrby2.length;
        int n3 = 0;
        while (n3 < n2) {
            byte by2 = arrby2[n3];
            stringBuilder.append(hexDigits[by2 >> 4 & 15]).append(hexDigits[by2 & 15]);
            ++n3;
        }
        return stringBuilder.toString();
    }
}

