package com.google.common.base;

import javax.annotation.*;
import com.google.common.annotations.*;
import java.util.*;

@GwtCompatible
public final class Preconditions
{
    public static void checkArgument(final boolean b) {
        if (!b) {
            throw new IllegalArgumentException();
        }
    }
    
    public static void checkArgument(final boolean b, @Nullable final Object o) {
        if (!b) {
            throw new IllegalArgumentException(String.valueOf(o));
        }
    }
    
    public static void checkArgument(final boolean b, @Nullable final String s, @Nullable final Object... array) {
        if (!b) {
            throw new IllegalArgumentException(format(s, array));
        }
    }
    
    public static void checkState(final boolean b) {
        if (!b) {
            throw new IllegalStateException();
        }
    }
    
    public static void checkState(final boolean b, @Nullable final Object o) {
        if (!b) {
            throw new IllegalStateException(String.valueOf(o));
        }
    }
    
    public static void checkState(final boolean b, @Nullable final String s, @Nullable final Object... array) {
        if (!b) {
            throw new IllegalStateException(format(s, array));
        }
    }
    
    public static Object checkNotNull(final Object o) {
        if (o == null) {
            throw new NullPointerException();
        }
        return o;
    }
    
    public static Object checkNotNull(final Object o, @Nullable final Object o2) {
        if (o == null) {
            throw new NullPointerException(String.valueOf(o2));
        }
        return o;
    }
    
    public static Object checkNotNull(final Object o, @Nullable final String s, @Nullable final Object... array) {
        if (o == null) {
            throw new NullPointerException(format(s, array));
        }
        return o;
    }
    
    @Deprecated
    @GoogleInternal
    public static Iterable checkContentsNotNull(final Iterable iterable) {
        if (containsOrIsNull(iterable)) {
            throw new NullPointerException();
        }
        return iterable;
    }
    
    @Deprecated
    @GoogleInternal
    public static Iterable checkContentsNotNull(final Iterable iterable, @Nullable final Object o) {
        if (containsOrIsNull(iterable)) {
            throw new NullPointerException(String.valueOf(o));
        }
        return iterable;
    }
    
    @Deprecated
    @GoogleInternal
    public static Iterable checkContentsNotNull(final Iterable iterable, @Nullable final String s, @Nullable final Object... array) {
        if (containsOrIsNull(iterable)) {
            throw new NullPointerException(format(s, array));
        }
        return iterable;
    }
    
    @GoogleInternal
    private static boolean containsOrIsNull(@Nullable final Iterable iterable) {
        if (iterable == null) {
            return true;
        }
        if (iterable instanceof Collection) {
            final Collection<Object> collection = (Collection<Object>)iterable;
            try {
                return collection.contains(null);
            }
            catch (NullPointerException ex) {
                return false;
            }
        }
        final Iterator<Object> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == null) {
                return true;
            }
        }
        return false;
    }
    
    public static int checkElementIndex(final int n, final int n2) {
        return checkElementIndex(n, n2, "index");
    }
    
    public static int checkElementIndex(final int n, final int n2, @Nullable final String s) {
        if (n < 0 || n >= n2) {
            throw new IndexOutOfBoundsException(badElementIndex(n, n2, s));
        }
        return n;
    }
    
    private static String badElementIndex(final int n, final int n2, final String s) {
        if (n < 0) {
            return format("%s (%s) must not be negative", s, n);
        }
        if (n2 < 0) {
            throw new IllegalArgumentException(new StringBuilder(26).append("negative size: ").append(n2).toString());
        }
        return format("%s (%s) must be less than size (%s)", s, n, n2);
    }
    
    public static int checkPositionIndex(final int n, final int n2) {
        return checkPositionIndex(n, n2, "index");
    }
    
    public static int checkPositionIndex(final int n, final int n2, @Nullable final String s) {
        if (n < 0 || n > n2) {
            throw new IndexOutOfBoundsException(badPositionIndex(n, n2, s));
        }
        return n;
    }
    
    private static String badPositionIndex(final int n, final int n2, final String s) {
        if (n < 0) {
            return format("%s (%s) must not be negative", s, n);
        }
        if (n2 < 0) {
            throw new IllegalArgumentException(new StringBuilder(26).append("negative size: ").append(n2).toString());
        }
        return format("%s (%s) must not be greater than size (%s)", s, n, n2);
    }
    
    public static void checkPositionIndexes(final int n, final int n2, final int n3) {
        if (n < 0 || n2 < n || n2 > n3) {
            throw new IndexOutOfBoundsException(badPositionIndexes(n, n2, n3));
        }
    }
    
    private static String badPositionIndexes(final int n, final int n2, final int n3) {
        if (n < 0 || n > n3) {
            return badPositionIndex(n, n3, "start index");
        }
        if (n2 < 0 || n2 > n3) {
            return badPositionIndex(n2, n3, "end index");
        }
        return format("end index (%s) must not be less than start index (%s)", n2, n);
    }
    
    static String format(String value, @Nullable final Object... array) {
        value = String.valueOf(value);
        final StringBuilder sb = new StringBuilder(value.length() + 16 * array.length);
        int n = 0;
        int i = 0;
        while (i < array.length) {
            final int index = value.indexOf("%s", n);
            if (index == -1) {
                break;
            }
            sb.append(value.substring(n, index));
            sb.append(array[i++]);
            n = index + 2;
        }
        sb.append(value.substring(n));
        if (i < array.length) {
            sb.append(" [");
            sb.append(array[i++]);
            while (i < array.length) {
                sb.append(", ");
                sb.append(array[i++]);
            }
            sb.append(']');
        }
        return sb.toString();
    }
}
