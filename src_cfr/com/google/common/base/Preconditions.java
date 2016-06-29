/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtCompatible
public final class Preconditions {
    private Preconditions() {
    }

    public static void checkArgument(boolean bl2) {
        if (bl2) return;
        throw new IllegalArgumentException();
    }

    public static void checkArgument(boolean bl2, @Nullable Object object) {
        if (bl2) return;
        throw new IllegalArgumentException(String.valueOf(object));
    }

    public static /* varargs */ void checkArgument(boolean bl2, @Nullable String string, @Nullable Object ... arrobject) {
        if (bl2) return;
        throw new IllegalArgumentException(Preconditions.format(string, arrobject));
    }

    public static void checkState(boolean bl2) {
        if (bl2) return;
        throw new IllegalStateException();
    }

    public static void checkState(boolean bl2, @Nullable Object object) {
        if (bl2) return;
        throw new IllegalStateException(String.valueOf(object));
    }

    public static /* varargs */ void checkState(boolean bl2, @Nullable String string, @Nullable Object ... arrobject) {
        if (bl2) return;
        throw new IllegalStateException(Preconditions.format(string, arrobject));
    }

    public static Object checkNotNull(Object object) {
        if (object != null) return object;
        throw new NullPointerException();
    }

    public static Object checkNotNull(Object object, @Nullable Object object2) {
        if (object != null) return object;
        throw new NullPointerException(String.valueOf(object2));
    }

    public static /* varargs */ Object checkNotNull(Object object, @Nullable String string, @Nullable Object ... arrobject) {
        if (object != null) return object;
        throw new NullPointerException(Preconditions.format(string, arrobject));
    }

    @Deprecated
    @GoogleInternal
    public static Iterable checkContentsNotNull(Iterable iterable) {
        if (!Preconditions.containsOrIsNull(iterable)) return iterable;
        throw new NullPointerException();
    }

    @Deprecated
    @GoogleInternal
    public static Iterable checkContentsNotNull(Iterable iterable, @Nullable Object object) {
        if (!Preconditions.containsOrIsNull(iterable)) return iterable;
        throw new NullPointerException(String.valueOf(object));
    }

    @Deprecated
    @GoogleInternal
    public static /* varargs */ Iterable checkContentsNotNull(Iterable iterable, @Nullable String string, @Nullable Object ... arrobject) {
        if (!Preconditions.containsOrIsNull(iterable)) return iterable;
        throw new NullPointerException(Preconditions.format(string, arrobject));
    }

    @GoogleInternal
    private static boolean containsOrIsNull(@Nullable Iterable iterable) {
        Object t2;
        if (iterable == null) {
            return true;
        }
        if (iterable instanceof Collection) {
            Collection collection = (Collection)iterable;
            try {
                return collection.contains(null);
            }
            catch (NullPointerException var2_3) {
                return false;
            }
        }
        Iterator iterator = iterable.iterator();
        do {
            if (!iterator.hasNext()) return false;
        } while ((t2 = iterator.next()) != null);
        return true;
    }

    public static int checkElementIndex(int n2, int n3) {
        return Preconditions.checkElementIndex(n2, n3, "index");
    }

    public static int checkElementIndex(int n2, int n3, @Nullable String string) {
        if (n2 < 0) throw new IndexOutOfBoundsException(Preconditions.badElementIndex(n2, n3, string));
        if (n2 < n3) return n2;
        throw new IndexOutOfBoundsException(Preconditions.badElementIndex(n2, n3, string));
    }

    private static String badElementIndex(int n2, int n3, String string) {
        if (n2 < 0) {
            return Preconditions.format("%s (%s) must not be negative", string, n2);
        }
        if (n3 >= 0) return Preconditions.format("%s (%s) must be less than size (%s)", string, n2, n3);
        throw new IllegalArgumentException(new StringBuilder(26).append("negative size: ").append(n3).toString());
    }

    public static int checkPositionIndex(int n2, int n3) {
        return Preconditions.checkPositionIndex(n2, n3, "index");
    }

    public static int checkPositionIndex(int n2, int n3, @Nullable String string) {
        if (n2 < 0) throw new IndexOutOfBoundsException(Preconditions.badPositionIndex(n2, n3, string));
        if (n2 <= n3) return n2;
        throw new IndexOutOfBoundsException(Preconditions.badPositionIndex(n2, n3, string));
    }

    private static String badPositionIndex(int n2, int n3, String string) {
        if (n2 < 0) {
            return Preconditions.format("%s (%s) must not be negative", string, n2);
        }
        if (n3 >= 0) return Preconditions.format("%s (%s) must not be greater than size (%s)", string, n2, n3);
        throw new IllegalArgumentException(new StringBuilder(26).append("negative size: ").append(n3).toString());
    }

    public static void checkPositionIndexes(int n2, int n3, int n4) {
        if (n2 < 0) throw new IndexOutOfBoundsException(Preconditions.badPositionIndexes(n2, n3, n4));
        if (n3 < n2) throw new IndexOutOfBoundsException(Preconditions.badPositionIndexes(n2, n3, n4));
        if (n3 <= n4) return;
        throw new IndexOutOfBoundsException(Preconditions.badPositionIndexes(n2, n3, n4));
    }

    private static String badPositionIndexes(int n2, int n3, int n4) {
        if (n2 < 0) return Preconditions.badPositionIndex(n2, n4, "start index");
        if (n2 > n4) {
            return Preconditions.badPositionIndex(n2, n4, "start index");
        }
        if (n3 < 0) return Preconditions.badPositionIndex(n3, n4, "end index");
        if (n3 <= n4) return Preconditions.format("end index (%s) must not be less than start index (%s)", n3, n2);
        return Preconditions.badPositionIndex(n3, n4, "end index");
    }

    static /* varargs */ String format(String string, @Nullable Object ... arrobject) {
        int n2;
        string = String.valueOf(string);
        StringBuilder stringBuilder = new StringBuilder(string.length() + 16 * arrobject.length);
        int n3 = 0;
        int n4 = 0;
        while (n4 < arrobject.length && (n2 = string.indexOf("%s", n3)) != -1) {
            stringBuilder.append(string.substring(n3, n2));
            stringBuilder.append(arrobject[n4++]);
            n3 = n2 + 2;
        }
        stringBuilder.append(string.substring(n3));
        if (n4 >= arrobject.length) return stringBuilder.toString();
        stringBuilder.append(" [");
        stringBuilder.append(arrobject[n4++]);
        do {
            if (n4 >= arrobject.length) {
                stringBuilder.append(']');
                return stringBuilder.toString();
            }
            stringBuilder.append(", ");
            stringBuilder.append(arrobject[n4++]);
        } while (true);
    }
}

