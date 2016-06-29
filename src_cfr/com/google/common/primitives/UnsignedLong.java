/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 *  javax.annotation.Nullable
 */
package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Longs;
import com.google.common.primitives.UnsignedLongs;
import java.io.Serializable;
import java.math.BigInteger;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible(serializable=1)
public final class UnsignedLong
extends Number
implements Serializable,
Comparable {
    private static final long UNSIGNED_MASK = Long.MAX_VALUE;
    public static final UnsignedLong ZERO = new UnsignedLong(0);
    public static final UnsignedLong ONE = new UnsignedLong(1);
    public static final UnsignedLong MAX_VALUE = new UnsignedLong(-1);
    private final long value;

    private UnsignedLong(long l2) {
        this.value = l2;
    }

    public static UnsignedLong fromLongBits(long l2) {
        return new UnsignedLong(l2);
    }

    public static UnsignedLong valueOf(long l2) {
        Preconditions.checkArgument(l2 >= 0, "value (%s) is outside the range for an unsigned long value", l2);
        return UnsignedLong.fromLongBits(l2);
    }

    public static UnsignedLong valueOf(BigInteger bigInteger) {
        Preconditions.checkNotNull(bigInteger);
        Preconditions.checkArgument(bigInteger.signum() >= 0 && bigInteger.bitLength() <= 64, "value (%s) is outside the range for an unsigned long value", bigInteger);
        return UnsignedLong.fromLongBits(bigInteger.longValue());
    }

    public static UnsignedLong valueOf(String string) {
        return UnsignedLong.valueOf(string, 10);
    }

    public static UnsignedLong valueOf(String string, int n2) {
        return UnsignedLong.fromLongBits(UnsignedLongs.parseUnsignedLong(string, n2));
    }

    @CheckReturnValue
    public UnsignedLong plus(UnsignedLong unsignedLong) {
        return UnsignedLong.fromLongBits(this.value + ((UnsignedLong)Preconditions.checkNotNull((Object)unsignedLong)).value);
    }

    @CheckReturnValue
    public UnsignedLong minus(UnsignedLong unsignedLong) {
        return UnsignedLong.fromLongBits(this.value - ((UnsignedLong)Preconditions.checkNotNull((Object)unsignedLong)).value);
    }

    @CheckReturnValue
    public UnsignedLong times(UnsignedLong unsignedLong) {
        return UnsignedLong.fromLongBits(this.value * ((UnsignedLong)Preconditions.checkNotNull((Object)unsignedLong)).value);
    }

    @CheckReturnValue
    public UnsignedLong dividedBy(UnsignedLong unsignedLong) {
        return UnsignedLong.fromLongBits(UnsignedLongs.divide(this.value, ((UnsignedLong)Preconditions.checkNotNull((Object)unsignedLong)).value));
    }

    @CheckReturnValue
    public UnsignedLong mod(UnsignedLong unsignedLong) {
        return UnsignedLong.fromLongBits(UnsignedLongs.remainder(this.value, ((UnsignedLong)Preconditions.checkNotNull((Object)unsignedLong)).value));
    }

    @Override
    public int intValue() {
        return (int)this.value;
    }

    @Override
    public long longValue() {
        return this.value;
    }

    @Override
    public float floatValue() {
        float f2 = this.value & Long.MAX_VALUE;
        if (this.value >= 0) return f2;
        f2 += 9.223372E18f;
        return f2;
    }

    @Override
    public double doubleValue() {
        double d2 = this.value & Long.MAX_VALUE;
        if (this.value >= 0) return d2;
        d2 += 9.223372036854776E18;
        return d2;
    }

    public BigInteger bigIntegerValue() {
        BigInteger bigInteger = BigInteger.valueOf(this.value & Long.MAX_VALUE);
        if (this.value >= 0) return bigInteger;
        return bigInteger.setBit(63);
    }

    public int compareTo(UnsignedLong unsignedLong) {
        Preconditions.checkNotNull(unsignedLong);
        return UnsignedLongs.compare(this.value, unsignedLong.value);
    }

    public int hashCode() {
        return Longs.hashCode(this.value);
    }

    public boolean equals(@Nullable Object object) {
        if (!(object instanceof UnsignedLong)) return false;
        UnsignedLong unsignedLong = (UnsignedLong)object;
        if (this.value != unsignedLong.value) return false;
        return true;
    }

    public String toString() {
        return UnsignedLongs.toString(this.value);
    }

    public String toString(int n2) {
        return UnsignedLongs.toString(this.value, n2);
    }
}

