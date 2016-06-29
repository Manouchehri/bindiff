package com.google.common.primitives;

import javax.annotation.*;
import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;

@CheckReturnValue
@GwtCompatible
public final class SignedBytes
{
    public static final byte MAX_POWER_OF_TWO = 64;
    
    public static byte checkedCast(final long n) {
        final byte b = (byte)n;
        if (b != n) {
            throw new IllegalArgumentException(new StringBuilder(34).append("Out of range: ").append(n).toString());
        }
        return b;
    }
    
    public static byte saturatedCast(final long n) {
        if (n > 127L) {
            return 127;
        }
        if (n < -128L) {
            return -128;
        }
        return (byte)n;
    }
    
    public static int compare(final byte b, final byte b2) {
        return b - b2;
    }
    
    public static byte min(final byte... array) {
        Preconditions.checkArgument(array.length > 0);
        byte b = array[0];
        for (int i = 1; i < array.length; ++i) {
            if (array[i] < b) {
                b = array[i];
            }
        }
        return b;
    }
    
    public static byte max(final byte... array) {
        Preconditions.checkArgument(array.length > 0);
        byte b = array[0];
        for (int i = 1; i < array.length; ++i) {
            if (array[i] > b) {
                b = array[i];
            }
        }
        return b;
    }
    
    public static String join(final String s, final byte... array) {
        Preconditions.checkNotNull(s);
        if (array.length == 0) {
            return "";
        }
        final StringBuilder sb = new StringBuilder(array.length * 5);
        sb.append(array[0]);
        for (int i = 1; i < array.length; ++i) {
            sb.append(s).append(array[i]);
        }
        return sb.toString();
    }
    
    public static Comparator lexicographicalComparator() {
        return SignedBytes$LexicographicalComparator.INSTANCE;
    }
}
