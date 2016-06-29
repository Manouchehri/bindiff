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
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Floats$FloatArrayAsList;
import com.google.common.primitives.Floats$FloatConverter;
import com.google.common.primitives.Floats$LexicographicalComparator;
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
public final class Floats {
    public static final int BYTES = 4;

    private Floats() {
    }

    public static int hashCode(float f2) {
        return Float.valueOf(f2).hashCode();
    }

    static int compare(float f2, float f3) {
        return Float.compare(f2, f3);
    }

    public static boolean isFinite(float f2) {
        boolean bl2;
        boolean bl3 = Float.NEGATIVE_INFINITY < f2;
        if (f2 < Float.POSITIVE_INFINITY) {
            bl2 = true;
            return bl3 & bl2;
        }
        bl2 = false;
        return bl3 & bl2;
    }

    public static boolean contains(float[] arrf, float f2) {
        float[] arrf2 = arrf;
        int n2 = arrf2.length;
        int n3 = 0;
        while (n3 < n2) {
            float f3 = arrf2[n3];
            if (f3 == f2) {
                return true;
            }
            ++n3;
        }
        return false;
    }

    public static int indexOf(float[] arrf, float f2) {
        return Floats.indexOf(arrf, f2, 0, arrf.length);
    }

    private static int indexOf(float[] arrf, float f2, int n2, int n3) {
        int n4 = n2;
        while (n4 < n3) {
            if (arrf[n4] == f2) {
                return n4;
            }
            ++n4;
        }
        return -1;
    }

    public static int indexOf(float[] arrf, float[] arrf2) {
        Preconditions.checkNotNull(arrf, "array");
        Preconditions.checkNotNull(arrf2, "target");
        if (arrf2.length == 0) {
            return 0;
        }
        int n2 = 0;
        block0 : while (n2 < arrf.length - arrf2.length + 1) {
            int n3 = 0;
            while (n3 < arrf2.length) {
                if (arrf[n2 + n3] != arrf2[n3]) {
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

    public static int lastIndexOf(float[] arrf, float f2) {
        return Floats.lastIndexOf(arrf, f2, 0, arrf.length);
    }

    private static int lastIndexOf(float[] arrf, float f2, int n2, int n3) {
        int n4 = n3 - 1;
        while (n4 >= n2) {
            if (arrf[n4] == f2) {
                return n4;
            }
            --n4;
        }
        return -1;
    }

    public static /* varargs */ float min(float ... arrf) {
        Preconditions.checkArgument(arrf.length > 0);
        float f2 = arrf[0];
        int n2 = 1;
        while (n2 < arrf.length) {
            f2 = Math.min(f2, arrf[n2]);
            ++n2;
        }
        return f2;
    }

    public static /* varargs */ float max(float ... arrf) {
        Preconditions.checkArgument(arrf.length > 0);
        float f2 = arrf[0];
        int n2 = 1;
        while (n2 < arrf.length) {
            f2 = Math.max(f2, arrf[n2]);
            ++n2;
        }
        return f2;
    }

    public static /* varargs */ float[] concat(float[] ... arrf) {
        float[] arrf2;
        int n2 = 0;
        float[][] arrf3 = arrf;
        int n3 = arrf3.length;
        for (int i2 = 0; i2 < n3; n2 += arrf2.length, ++i2) {
            arrf2 = arrf3[i2];
        }
        arrf3 = new float[n2];
        n3 = 0;
        float[][] arrf4 = arrf;
        int n4 = arrf4.length;
        int n5 = 0;
        while (n5 < n4) {
            float[] arrf5 = arrf4[n5];
            System.arraycopy(arrf5, 0, arrf3, n3, arrf5.length);
            n3 += arrf5.length;
            ++n5;
        }
        return arrf3;
    }

    @Beta
    public static Converter stringConverter() {
        return Floats$FloatConverter.INSTANCE;
    }

    public static float[] ensureCapacity(float[] arrf, int n2, int n3) {
        float[] arrf2;
        Preconditions.checkArgument(n2 >= 0, "Invalid minLength: %s", n2);
        Preconditions.checkArgument(n3 >= 0, "Invalid padding: %s", n3);
        if (arrf.length < n2) {
            arrf2 = Floats.copyOf(arrf, n2 + n3);
            return arrf2;
        }
        arrf2 = arrf;
        return arrf2;
    }

    private static float[] copyOf(float[] arrf, int n2) {
        float[] arrf2 = new float[n2];
        System.arraycopy(arrf, 0, arrf2, 0, Math.min(arrf.length, n2));
        return arrf2;
    }

    public static /* varargs */ String join(String string, float ... arrf) {
        Preconditions.checkNotNull(string);
        if (arrf.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(arrf.length * 12);
        stringBuilder.append(arrf[0]);
        int n2 = 1;
        while (n2 < arrf.length) {
            stringBuilder.append(string).append(arrf[n2]);
            ++n2;
        }
        return stringBuilder.toString();
    }

    public static Comparator lexicographicalComparator() {
        return Floats$LexicographicalComparator.INSTANCE;
    }

    public static float[] toArray(Collection collection) {
        if (collection instanceof Floats$FloatArrayAsList) {
            return ((Floats$FloatArrayAsList)collection).toFloatArray();
        }
        Object[] arrobject = collection.toArray();
        int n2 = arrobject.length;
        float[] arrf = new float[n2];
        int n3 = 0;
        while (n3 < n2) {
            arrf[n3] = ((Number)Preconditions.checkNotNull(arrobject[n3])).floatValue();
            ++n3;
        }
        return arrf;
    }

    public static /* varargs */ List asList(float ... arrf) {
        if (arrf.length != 0) return new Floats$FloatArrayAsList(arrf);
        return Collections.emptyList();
    }

    @Nullable
    @CheckForNull
    @Beta
    @GwtIncompatible(value="regular expressions")
    public static Float tryParse(String string) {
        if (!Doubles.FLOATING_POINT_PATTERN.matcher(string).matches()) return null;
        try {
            return Float.valueOf(Float.parseFloat(string));
        }
        catch (NumberFormatException var1_1) {
            // empty catch block
        }
        return null;
    }

    static /* synthetic */ int access$000(float[] arrf, float f2, int n2, int n3) {
        return Floats.indexOf(arrf, f2, n2, n3);
    }

    static /* synthetic */ int access$100(float[] arrf, float f2, int n2, int n3) {
        return Floats.lastIndexOf(arrf, f2, n2, n3);
    }
}

