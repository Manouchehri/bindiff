/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckForNull
 *  javax.annotation.CheckReturnValue
 *  javax.annotation.Nullable
 */
package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles$DoubleArrayAsList;
import com.google.common.primitives.Doubles$DoubleConverter;
import com.google.common.primitives.Doubles$LexicographicalComparator;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.CheckForNull;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
@GwtCompatible(emulated=1)
public final class Doubles {
    public static final int BYTES = 8;
    @GwtIncompatible(value="regular expressions")
    static final Pattern FLOATING_POINT_PATTERN = Doubles.fpPattern();

    private Doubles() {
    }

    public static int hashCode(double d2) {
        return Double.valueOf(d2).hashCode();
    }

    static int compare(double d2, double d3) {
        return Double.compare(d2, d3);
    }

    public static boolean isFinite(double d2) {
        boolean bl2;
        boolean bl3 = Double.NEGATIVE_INFINITY < d2;
        if (d2 < Double.POSITIVE_INFINITY) {
            bl2 = true;
            return bl3 & bl2;
        }
        bl2 = false;
        return bl3 & bl2;
    }

    public static boolean contains(double[] arrd, double d2) {
        double[] arrd2 = arrd;
        int n2 = arrd2.length;
        int n3 = 0;
        while (n3 < n2) {
            double d3 = arrd2[n3];
            if (d3 == d2) {
                return true;
            }
            ++n3;
        }
        return false;
    }

    public static int indexOf(double[] arrd, double d2) {
        return Doubles.indexOf(arrd, d2, 0, arrd.length);
    }

    private static int indexOf(double[] arrd, double d2, int n2, int n3) {
        int n4 = n2;
        while (n4 < n3) {
            if (arrd[n4] == d2) {
                return n4;
            }
            ++n4;
        }
        return -1;
    }

    public static int indexOf(double[] arrd, double[] arrd2) {
        Preconditions.checkNotNull(arrd, "array");
        Preconditions.checkNotNull(arrd2, "target");
        if (arrd2.length == 0) {
            return 0;
        }
        int n2 = 0;
        block0 : while (n2 < arrd.length - arrd2.length + 1) {
            int n3 = 0;
            while (n3 < arrd2.length) {
                if (arrd[n2 + n3] != arrd2[n3]) {
                    ++n2;
                    continue block0;
                }
                ++n3;
            }
            return n2;
            break;
        }
        return -1;
    }

    public static int lastIndexOf(double[] arrd, double d2) {
        return Doubles.lastIndexOf(arrd, d2, 0, arrd.length);
    }

    private static int lastIndexOf(double[] arrd, double d2, int n2, int n3) {
        int n4 = n3 - 1;
        while (n4 >= n2) {
            if (arrd[n4] == d2) {
                return n4;
            }
            --n4;
        }
        return -1;
    }

    public static /* varargs */ double min(double ... arrd) {
        Preconditions.checkArgument(arrd.length > 0);
        double d2 = arrd[0];
        int n2 = 1;
        while (n2 < arrd.length) {
            d2 = Math.min(d2, arrd[n2]);
            ++n2;
        }
        return d2;
    }

    public static /* varargs */ double max(double ... arrd) {
        Preconditions.checkArgument(arrd.length > 0);
        double d2 = arrd[0];
        int n2 = 1;
        while (n2 < arrd.length) {
            d2 = Math.max(d2, arrd[n2]);
            ++n2;
        }
        return d2;
    }

    public static /* varargs */ double[] concat(double[] ... arrd) {
        double[] arrd2;
        int n2 = 0;
        double[][] arrd3 = arrd;
        int n3 = arrd3.length;
        for (int i2 = 0; i2 < n3; n2 += arrd2.length, ++i2) {
            arrd2 = arrd3[i2];
        }
        arrd3 = new double[n2];
        n3 = 0;
        double[][] arrd4 = arrd;
        int n4 = arrd4.length;
        int n5 = 0;
        while (n5 < n4) {
            double[] arrd5 = arrd4[n5];
            System.arraycopy(arrd5, 0, arrd3, n3, arrd5.length);
            n3 += arrd5.length;
            ++n5;
        }
        return arrd3;
    }

    @Beta
    public static Converter stringConverter() {
        return Doubles$DoubleConverter.INSTANCE;
    }

    public static double[] ensureCapacity(double[] arrd, int n2, int n3) {
        double[] arrd2;
        Preconditions.checkArgument(n2 >= 0, "Invalid minLength: %s", n2);
        Preconditions.checkArgument(n3 >= 0, "Invalid padding: %s", n3);
        if (arrd.length < n2) {
            arrd2 = Doubles.copyOf(arrd, n2 + n3);
            return arrd2;
        }
        arrd2 = arrd;
        return arrd2;
    }

    private static double[] copyOf(double[] arrd, int n2) {
        double[] arrd2 = new double[n2];
        System.arraycopy(arrd, 0, arrd2, 0, Math.min(arrd.length, n2));
        return arrd2;
    }

    public static /* varargs */ String join(String string, double ... arrd) {
        Preconditions.checkNotNull(string);
        if (arrd.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(arrd.length * 12);
        stringBuilder.append(arrd[0]);
        int n2 = 1;
        while (n2 < arrd.length) {
            stringBuilder.append(string).append(arrd[n2]);
            ++n2;
        }
        return stringBuilder.toString();
    }

    public static Comparator lexicographicalComparator() {
        return Doubles$LexicographicalComparator.INSTANCE;
    }

    public static double[] toArray(Collection collection) {
        if (collection instanceof Doubles$DoubleArrayAsList) {
            return ((Doubles$DoubleArrayAsList)collection).toDoubleArray();
        }
        Object[] arrobject = collection.toArray();
        int n2 = arrobject.length;
        double[] arrd = new double[n2];
        int n3 = 0;
        while (n3 < n2) {
            arrd[n3] = ((Number)Preconditions.checkNotNull(arrobject[n3])).doubleValue();
            ++n3;
        }
        return arrd;
    }

    public static /* varargs */ List asList(double ... arrd) {
        if (arrd.length != 0) return new Doubles$DoubleArrayAsList(arrd);
        return Collections.emptyList();
    }

    @GwtIncompatible(value="regular expressions")
    private static Pattern fpPattern() {
        String string = "(?:\\d++(?:\\.\\d*+)?|\\.\\d++)";
        String string2 = String.valueOf(string).concat("(?:[eE][+-]?\\d++)?[fFdD]?");
        String string3 = "(?:\\p{XDigit}++(?:\\.\\p{XDigit}*+)?|\\.\\p{XDigit}++)";
        String string4 = new StringBuilder(25 + String.valueOf(string3).length()).append("0[xX]").append(string3).append("[pP][+-]?\\d++[fFdD]?").toString();
        String string5 = new StringBuilder(23 + String.valueOf(string2).length() + String.valueOf(string4).length()).append("[+-]?(?:NaN|Infinity|").append(string2).append("|").append(string4).append(")").toString();
        return Pattern.compile(string5);
    }

    @Nullable
    @CheckForNull
    @Beta
    @GwtIncompatible(value="regular expressions")
    public static Double tryParse(String string) {
        if (!FLOATING_POINT_PATTERN.matcher(string).matches()) return null;
        try {
            return Double.parseDouble(string);
        }
        catch (NumberFormatException var1_1) {
            // empty catch block
        }
        return null;
    }

    static /* synthetic */ int access$000(double[] arrd, double d2, int n2, int n3) {
        return Doubles.indexOf(arrd, d2, n2, n3);
    }

    static /* synthetic */ int access$100(double[] arrd, double d2, int n2, int n3) {
        return Doubles.lastIndexOf(arrd, d2, n2, n3);
    }
}

