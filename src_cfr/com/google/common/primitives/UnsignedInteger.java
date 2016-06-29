/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 *  javax.annotation.Nullable
 */
package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.UnsignedInts;
import java.math.BigInteger;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
@GwtCompatible(emulated=1)
public final class UnsignedInteger
extends Number
implements Comparable {
    public static final UnsignedInteger ZERO = UnsignedInteger.fromIntBits(0);
    public static final UnsignedInteger ONE = UnsignedInteger.fromIntBits(1);
    public static final UnsignedInteger MAX_VALUE = UnsignedInteger.fromIntBits(-1);
    private final int value;

    private UnsignedInteger(int n2) {
        this.value = n2 & -1;
    }

    public static UnsignedInteger fromIntBits(int n2) {
        return new UnsignedInteger(n2);
    }

    public static UnsignedInteger valueOf(long l2) {
        Preconditions.checkArgument((l2 & 0xFFFFFFFFL) == l2, "value (%s) is outside the range for an unsigned integer value", l2);
        return UnsignedInteger.fromIntBits((int)l2);
    }

    public static UnsignedInteger valueOf(BigInteger bigInteger) {
        Preconditions.checkNotNull(bigInteger);
        Preconditions.checkArgument(bigInteger.signum() >= 0 && bigInteger.bitLength() <= 32, "value (%s) is outside the range for an unsigned integer value", bigInteger);
        return UnsignedInteger.fromIntBits(bigInteger.intValue());
    }

    public static UnsignedInteger valueOf(String string) {
        return UnsignedInteger.valueOf(string, 10);
    }

    public static UnsignedInteger valueOf(String string, int n2) {
        return UnsignedInteger.fromIntBits(UnsignedInts.parseUnsignedInt(string, n2));
    }

    public UnsignedInteger plus(UnsignedInteger unsignedInteger) {
        return UnsignedInteger.fromIntBits(this.value + ((UnsignedInteger)Preconditions.checkNotNull((Object)unsignedInteger)).value);
    }

    public UnsignedInteger minus(UnsignedInteger unsignedInteger) {
        return UnsignedInteger.fromIntBits(this.value - ((UnsignedInteger)Preconditions.checkNotNull((Object)unsignedInteger)).value);
    }

    @GwtIncompatible(value="Does not truncate correctly")
    public UnsignedInteger times(UnsignedInteger unsignedInteger) {
        return UnsignedInteger.fromIntBits(this.value * ((UnsignedInteger)Preconditions.checkNotNull((Object)unsignedInteger)).value);
    }

    public UnsignedInteger dividedBy(UnsignedInteger unsignedInteger) {
        return UnsignedInteger.fromIntBits(UnsignedInts.divide(this.value, ((UnsignedInteger)Preconditions.checkNotNull((Object)unsignedInteger)).value));
    }

    public UnsignedInteger mod(UnsignedInteger unsignedInteger) {
        return UnsignedInteger.fromIntBits(UnsignedInts.remainder(this.value, ((UnsignedInteger)Preconditions.checkNotNull((Object)unsignedInteger)).value));
    }

    @Override
    public int intValue() {
        return this.value;
    }

    @Override
    public long longValue() {
        return UnsignedInts.toLong(this.value);
    }

    @Override
    public float floatValue() {
        return this.longValue();
    }

    @Override
    public double doubleValue() {
        return this.longValue();
    }

    public BigInteger bigIntegerValue() {
        return BigInteger.valueOf(this.longValue());
    }

    public int compareTo(UnsignedInteger unsignedInteger) {
        Preconditions.checkNotNull(unsignedInteger);
        return UnsignedInts.compare(this.value, unsignedInteger.value);
    }

    public int hashCode() {
        return this.value;
    }

    public boolean equals(@Nullable Object object) {
        if (!(object instanceof UnsignedInteger)) return false;
        UnsignedInteger unsignedInteger = (UnsignedInteger)object;
        if (this.value != unsignedInteger.value) return false;
        return true;
    }

    public String toString() {
        return this.toString(10);
    }

    public String toString(int n2) {
        return UnsignedInts.toString(this.value, n2);
    }
}

