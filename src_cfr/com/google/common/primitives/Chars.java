/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 */
package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Chars$CharArrayAsList;
import com.google.common.primitives.Chars$LexicographicalComparator;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
@GwtCompatible(emulated=1)
public final class Chars {
    public static final int BYTES = 2;

    private Chars() {
    }

    public static int hashCode(char c2) {
        return c2;
    }

    public static char checkedCast(long l2) {
        char c2 = (char)l2;
        if ((long)c2 == l2) return c2;
        throw new IllegalArgumentException(new StringBuilder(34).append("Out of range: ").append(l2).toString());
    }

    public static char saturatedCast(long l2) {
        if (l2 > 65535) {
            return '\uffff';
        }
        if (l2 >= 0) return (char)l2;
        return '\u0000';
    }

    @Deprecated
    public static int compare(char c2, char c3) {
        return c2 - c3;
    }

    public static boolean contains(char[] arrc, char c2) {
        char[] arrc2 = arrc;
        int n2 = arrc2.length;
        int n3 = 0;
        while (n3 < n2) {
            char c3 = arrc2[n3];
            if (c3 == c2) {
                return true;
            }
            ++n3;
        }
        return false;
    }

    public static int indexOf(char[] arrc, char c2) {
        return Chars.indexOf(arrc, c2, 0, arrc.length);
    }

    private static int indexOf(char[] arrc, char c2, int n2, int n3) {
        int n4 = n2;
        while (n4 < n3) {
            if (arrc[n4] == c2) {
                return n4;
            }
            ++n4;
        }
        return -1;
    }

    public static int indexOf(char[] arrc, char[] arrc2) {
        Preconditions.checkNotNull(arrc, "array");
        Preconditions.checkNotNull(arrc2, "target");
        if (arrc2.length == 0) {
            return 0;
        }
        int n2 = 0;
        block0 : while (n2 < arrc.length - arrc2.length + 1) {
            int n3 = 0;
            while (n3 < arrc2.length) {
                if (arrc[n2 + n3] != arrc2[n3]) {
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

    public static int lastIndexOf(char[] arrc, char c2) {
        return Chars.lastIndexOf(arrc, c2, 0, arrc.length);
    }

    private static int lastIndexOf(char[] arrc, char c2, int n2, int n3) {
        int n4 = n3 - 1;
        while (n4 >= n2) {
            if (arrc[n4] == c2) {
                return n4;
            }
            --n4;
        }
        return -1;
    }

    public static /* varargs */ char min(char ... arrc) {
        Preconditions.checkArgument(arrc.length > 0);
        char c2 = arrc[0];
        int n2 = 1;
        while (n2 < arrc.length) {
            if (arrc[n2] < c2) {
                c2 = arrc[n2];
            }
            ++n2;
        }
        return c2;
    }

    public static /* varargs */ char max(char ... arrc) {
        Preconditions.checkArgument(arrc.length > 0);
        char c2 = arrc[0];
        int n2 = 1;
        while (n2 < arrc.length) {
            if (arrc[n2] > c2) {
                c2 = arrc[n2];
            }
            ++n2;
        }
        return c2;
    }

    public static /* varargs */ char[] concat(char[] ... arrc) {
        char[] arrc2;
        int n2 = 0;
        char[][] arrc3 = arrc;
        int n3 = arrc3.length;
        for (int i2 = 0; i2 < n3; n2 += arrc2.length, ++i2) {
            arrc2 = arrc3[i2];
        }
        arrc3 = new char[n2];
        n3 = 0;
        char[][] arrc4 = arrc;
        int n4 = arrc4.length;
        int n5 = 0;
        while (n5 < n4) {
            char[] arrc5 = arrc4[n5];
            System.arraycopy(arrc5, 0, arrc3, n3, arrc5.length);
            n3 += arrc5.length;
            ++n5;
        }
        return arrc3;
    }

    @GwtIncompatible(value="doesn't work")
    public static byte[] toByteArray(char c2) {
        return new byte[]{(byte)(c2 >> 8), (byte)c2};
    }

    @GwtIncompatible(value="doesn't work")
    public static char fromByteArray(byte[] arrby) {
        Preconditions.checkArgument(arrby.length >= 2, "array too small: %s < %s", arrby.length, 2);
        return Chars.fromBytes(arrby[0], arrby[1]);
    }

    @GwtIncompatible(value="doesn't work")
    public static char fromBytes(byte by2, byte by3) {
        return (char)(by2 << 8 | by3 & 255);
    }

    public static char[] ensureCapacity(char[] arrc, int n2, int n3) {
        char[] arrc2;
        Preconditions.checkArgument(n2 >= 0, "Invalid minLength: %s", n2);
        Preconditions.checkArgument(n3 >= 0, "Invalid padding: %s", n3);
        if (arrc.length < n2) {
            arrc2 = Chars.copyOf(arrc, n2 + n3);
            return arrc2;
        }
        arrc2 = arrc;
        return arrc2;
    }

    private static char[] copyOf(char[] arrc, int n2) {
        char[] arrc2 = new char[n2];
        System.arraycopy(arrc, 0, arrc2, 0, Math.min(arrc.length, n2));
        return arrc2;
    }

    public static /* varargs */ String join(String string, char ... arrc) {
        Preconditions.checkNotNull(string);
        int n2 = arrc.length;
        if (n2 == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(n2 + string.length() * (n2 - 1));
        stringBuilder.append(arrc[0]);
        int n3 = 1;
        while (n3 < n2) {
            stringBuilder.append(string).append(arrc[n3]);
            ++n3;
        }
        return stringBuilder.toString();
    }

    public static Comparator lexicographicalComparator() {
        return Chars$LexicographicalComparator.INSTANCE;
    }

    public static char[] toArray(Collection collection) {
        if (collection instanceof Chars$CharArrayAsList) {
            return ((Chars$CharArrayAsList)collection).toCharArray();
        }
        Object[] arrobject = collection.toArray();
        int n2 = arrobject.length;
        char[] arrc = new char[n2];
        int n3 = 0;
        while (n3 < n2) {
            arrc[n3] = ((Character)Preconditions.checkNotNull(arrobject[n3])).charValue();
            ++n3;
        }
        return arrc;
    }

    public static /* varargs */ List asList(char ... arrc) {
        if (arrc.length != 0) return new Chars$CharArrayAsList(arrc);
        return Collections.emptyList();
    }

    static /* synthetic */ int access$000(char[] arrc, char c2, int n2, int n3) {
        return Chars.indexOf(arrc, c2, n2, n3);
    }

    static /* synthetic */ int access$100(char[] arrc, char c2, int n2, int n3) {
        return Chars.lastIndexOf(arrc, c2, n2, n3);
    }
}

