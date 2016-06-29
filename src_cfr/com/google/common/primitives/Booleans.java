/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 */
package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Booleans$BooleanArrayAsList;
import com.google.common.primitives.Booleans$LexicographicalComparator;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
@GwtCompatible
public final class Booleans {
    private Booleans() {
    }

    public static int hashCode(boolean bl2) {
        if (!bl2) return 1237;
        return 1231;
    }

    @Deprecated
    public static int compare(boolean bl2, boolean bl3) {
        if (bl2 == bl3) {
            return 0;
        }
        if (!bl2) return -1;
        return 1;
    }

    public static boolean contains(boolean[] arrbl, boolean bl2) {
        boolean[] arrbl2 = arrbl;
        int n2 = arrbl2.length;
        int n3 = 0;
        while (n3 < n2) {
            boolean bl3 = arrbl2[n3];
            if (bl3 == bl2) {
                return true;
            }
            ++n3;
        }
        return false;
    }

    public static int indexOf(boolean[] arrbl, boolean bl2) {
        return Booleans.indexOf(arrbl, bl2, 0, arrbl.length);
    }

    private static int indexOf(boolean[] arrbl, boolean bl2, int n2, int n3) {
        int n4 = n2;
        while (n4 < n3) {
            if (arrbl[n4] == bl2) {
                return n4;
            }
            ++n4;
        }
        return -1;
    }

    public static int indexOf(boolean[] arrbl, boolean[] arrbl2) {
        Preconditions.checkNotNull(arrbl, "array");
        Preconditions.checkNotNull(arrbl2, "target");
        if (arrbl2.length == 0) {
            return 0;
        }
        int n2 = 0;
        block0 : while (n2 < arrbl.length - arrbl2.length + 1) {
            int n3 = 0;
            while (n3 < arrbl2.length) {
                if (arrbl[n2 + n3] != arrbl2[n3]) {
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

    public static int lastIndexOf(boolean[] arrbl, boolean bl2) {
        return Booleans.lastIndexOf(arrbl, bl2, 0, arrbl.length);
    }

    private static int lastIndexOf(boolean[] arrbl, boolean bl2, int n2, int n3) {
        int n4 = n3 - 1;
        while (n4 >= n2) {
            if (arrbl[n4] == bl2) {
                return n4;
            }
            --n4;
        }
        return -1;
    }

    public static /* varargs */ boolean[] concat(boolean[] ... arrbl) {
        boolean[] arrbl2;
        int n2 = 0;
        boolean[][] arrbl3 = arrbl;
        int n3 = arrbl3.length;
        for (int i2 = 0; i2 < n3; n2 += arrbl2.length, ++i2) {
            arrbl2 = arrbl3[i2];
        }
        arrbl3 = new boolean[n2];
        n3 = 0;
        boolean[][] arrbl4 = arrbl;
        int n4 = arrbl4.length;
        int n5 = 0;
        while (n5 < n4) {
            boolean[] arrbl5 = arrbl4[n5];
            System.arraycopy(arrbl5, 0, arrbl3, n3, arrbl5.length);
            n3 += arrbl5.length;
            ++n5;
        }
        return arrbl3;
    }

    public static boolean[] ensureCapacity(boolean[] arrbl, int n2, int n3) {
        boolean[] arrbl2;
        Preconditions.checkArgument(n2 >= 0, "Invalid minLength: %s", n2);
        Preconditions.checkArgument(n3 >= 0, "Invalid padding: %s", n3);
        if (arrbl.length < n2) {
            arrbl2 = Booleans.copyOf(arrbl, n2 + n3);
            return arrbl2;
        }
        arrbl2 = arrbl;
        return arrbl2;
    }

    private static boolean[] copyOf(boolean[] arrbl, int n2) {
        boolean[] arrbl2 = new boolean[n2];
        System.arraycopy(arrbl, 0, arrbl2, 0, Math.min(arrbl.length, n2));
        return arrbl2;
    }

    public static /* varargs */ String join(String string, boolean ... arrbl) {
        Preconditions.checkNotNull(string);
        if (arrbl.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(arrbl.length * 7);
        stringBuilder.append(arrbl[0]);
        int n2 = 1;
        while (n2 < arrbl.length) {
            stringBuilder.append(string).append(arrbl[n2]);
            ++n2;
        }
        return stringBuilder.toString();
    }

    public static Comparator lexicographicalComparator() {
        return Booleans$LexicographicalComparator.INSTANCE;
    }

    public static boolean[] toArray(Collection collection) {
        if (collection instanceof Booleans$BooleanArrayAsList) {
            return ((Booleans$BooleanArrayAsList)collection).toBooleanArray();
        }
        Object[] arrobject = collection.toArray();
        int n2 = arrobject.length;
        boolean[] arrbl = new boolean[n2];
        int n3 = 0;
        while (n3 < n2) {
            arrbl[n3] = (Boolean)Preconditions.checkNotNull(arrobject[n3]);
            ++n3;
        }
        return arrbl;
    }

    public static /* varargs */ List asList(boolean ... arrbl) {
        if (arrbl.length != 0) return new Booleans$BooleanArrayAsList(arrbl);
        return Collections.emptyList();
    }

    @Beta
    public static /* varargs */ int countTrue(boolean ... arrbl) {
        int n2 = 0;
        boolean[] arrbl2 = arrbl;
        int n3 = arrbl2.length;
        int n4 = 0;
        while (n4 < n3) {
            boolean bl2 = arrbl2[n4];
            if (bl2) {
                ++n2;
            }
            ++n4;
        }
        return n2;
    }

    static /* synthetic */ int access$000(boolean[] arrbl, boolean bl2, int n2, int n3) {
        return Booleans.indexOf(arrbl, bl2, n2, n3);
    }

    static /* synthetic */ int access$100(boolean[] arrbl, boolean bl2, int n2, int n3) {
        return Booleans.lastIndexOf(arrbl, bl2, n2, n3);
    }
}

