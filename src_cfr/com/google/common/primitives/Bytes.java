/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 */
package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Bytes$ByteArrayAsList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
@GwtCompatible
public final class Bytes {
    private Bytes() {
    }

    public static int hashCode(byte by2) {
        return by2;
    }

    public static boolean contains(byte[] arrby, byte by2) {
        byte[] arrby2 = arrby;
        int n2 = arrby2.length;
        int n3 = 0;
        while (n3 < n2) {
            byte by3 = arrby2[n3];
            if (by3 == by2) {
                return true;
            }
            ++n3;
        }
        return false;
    }

    public static int indexOf(byte[] arrby, byte by2) {
        return Bytes.indexOf(arrby, by2, 0, arrby.length);
    }

    private static int indexOf(byte[] arrby, byte by2, int n2, int n3) {
        int n4 = n2;
        while (n4 < n3) {
            if (arrby[n4] == by2) {
                return n4;
            }
            ++n4;
        }
        return -1;
    }

    public static int indexOf(byte[] arrby, byte[] arrby2) {
        Preconditions.checkNotNull(arrby, "array");
        Preconditions.checkNotNull(arrby2, "target");
        if (arrby2.length == 0) {
            return 0;
        }
        int n2 = 0;
        block0 : while (n2 < arrby.length - arrby2.length + 1) {
            int n3 = 0;
            while (n3 < arrby2.length) {
                if (arrby[n2 + n3] != arrby2[n3]) {
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

    public static int lastIndexOf(byte[] arrby, byte by2) {
        return Bytes.lastIndexOf(arrby, by2, 0, arrby.length);
    }

    private static int lastIndexOf(byte[] arrby, byte by2, int n2, int n3) {
        int n4 = n3 - 1;
        while (n4 >= n2) {
            if (arrby[n4] == by2) {
                return n4;
            }
            --n4;
        }
        return -1;
    }

    public static /* varargs */ byte[] concat(byte[] ... arrby) {
        byte[] arrby2;
        int n2 = 0;
        byte[][] arrby3 = arrby;
        int n3 = arrby3.length;
        for (int i2 = 0; i2 < n3; n2 += arrby2.length, ++i2) {
            arrby2 = arrby3[i2];
        }
        arrby3 = new byte[n2];
        n3 = 0;
        byte[][] arrby4 = arrby;
        int n4 = arrby4.length;
        int n5 = 0;
        while (n5 < n4) {
            byte[] arrby5 = arrby4[n5];
            System.arraycopy(arrby5, 0, arrby3, n3, arrby5.length);
            n3 += arrby5.length;
            ++n5;
        }
        return arrby3;
    }

    public static byte[] ensureCapacity(byte[] arrby, int n2, int n3) {
        byte[] arrby2;
        Preconditions.checkArgument(n2 >= 0, "Invalid minLength: %s", n2);
        Preconditions.checkArgument(n3 >= 0, "Invalid padding: %s", n3);
        if (arrby.length < n2) {
            arrby2 = Bytes.copyOf(arrby, n2 + n3);
            return arrby2;
        }
        arrby2 = arrby;
        return arrby2;
    }

    private static byte[] copyOf(byte[] arrby, int n2) {
        byte[] arrby2 = new byte[n2];
        System.arraycopy(arrby, 0, arrby2, 0, Math.min(arrby.length, n2));
        return arrby2;
    }

    public static byte[] toArray(Collection collection) {
        if (collection instanceof Bytes$ByteArrayAsList) {
            return ((Bytes$ByteArrayAsList)collection).toByteArray();
        }
        Object[] arrobject = collection.toArray();
        int n2 = arrobject.length;
        byte[] arrby = new byte[n2];
        int n3 = 0;
        while (n3 < n2) {
            arrby[n3] = ((Number)Preconditions.checkNotNull(arrobject[n3])).byteValue();
            ++n3;
        }
        return arrby;
    }

    public static /* varargs */ List asList(byte ... arrby) {
        if (arrby.length != 0) return new Bytes$ByteArrayAsList(arrby);
        return Collections.emptyList();
    }

    static /* synthetic */ int access$000(byte[] arrby, byte by2, int n2, int n3) {
        return Bytes.indexOf(arrby, by2, n2, n3);
    }

    static /* synthetic */ int access$100(byte[] arrby, byte by2, int n2, int n3) {
        return Bytes.lastIndexOf(arrby, by2, n2, n3);
    }
}

