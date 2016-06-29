package y.g;

import y.c.*;
import java.util.*;

public class e
{
    public static Comparator a(final c c) {
        return new j(c);
    }
    
    public static Comparator b(final c c) {
        return new k(c);
    }
    
    public static Comparator c(final c c) {
        return new i(c);
    }
    
    public static Comparator a() {
        return new f();
    }
    
    public static int a(final int n, final int n2) {
        if (n < n2) {
            return -1;
        }
        if (n > n2) {
            return 1;
        }
        return 0;
    }
    
    public static int a(final long n, final long n2) {
        if (n < n2) {
            return -1;
        }
        if (n > n2) {
            return 1;
        }
        return 0;
    }
    
    public static int a(final float n, final float n2) {
        if (n < n2) {
            return -1;
        }
        if (n > n2) {
            return 1;
        }
        return 0;
    }
    
    public static int a(final double n, final double n2) {
        if (n < n2) {
            return -1;
        }
        if (n > n2) {
            return 1;
        }
        return 0;
    }
    
    public static void a(final List list, final Comparator comparator) {
        if (list.size() < 2) {
            return;
        }
        if (comparator instanceof g || (comparator == null && list.get(0) instanceof g)) {
            au.a(list, comparator);
            if (!p.c) {
                return;
            }
        }
        Collections.sort((List<Object>)list, comparator);
    }
    
    public static void a(final Object[] array, final Comparator comparator) {
        if (array.length < 2) {
            return;
        }
        if (comparator instanceof g || (comparator == null && array[0] instanceof g)) {
            au.a(array, comparator);
            if (!p.c) {
                return;
            }
        }
        Arrays.sort(array, comparator);
    }
    
    public static void a(final Object[] array, final int n, final int n2, final Comparator comparator) {
        if (n > n2) {
            throw new IllegalArgumentException("fromIndex(" + n + ") > toIndex(" + n2 + ")");
        }
        if (n < 0) {
            throw a(n);
        }
        if (n2 > array.length) {
            throw a(n2);
        }
        if (n == n2) {
            return;
        }
        if (comparator instanceof g || (comparator == null && array[n] instanceof g)) {
            au.a(array, n, n2, comparator);
            if (!p.c) {
                return;
            }
        }
        Arrays.sort(array, n, n2, comparator);
    }
    
    private static ArrayIndexOutOfBoundsException a(final int n) {
        return new ArrayIndexOutOfBoundsException("Array index out of range: " + n);
    }
}
