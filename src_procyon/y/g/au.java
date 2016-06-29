package y.g;

import java.util.*;

class au
{
    private static final Comparator a;
    
    static void a(final List list, final Comparator comparator) {
        final boolean c = p.c;
        final Object[] array = list.toArray();
        b(array, 0, array.length, comparator);
        final ListIterator<Object> listIterator = list.listIterator();
        int i = 0;
        while (i < array.length) {
            listIterator.next();
            listIterator.set(array[i]);
            ++i;
            if (c) {
                break;
            }
        }
    }
    
    static void a(final Object[] array, final Comparator comparator) {
        b(array, 0, array.length, comparator);
    }
    
    static void a(final Object[] array, final int n, final int n2, final Comparator comparator) {
        b(array, n, n2, comparator);
    }
    
    private static void b(final Object[] array, final int n, final int n2, final Comparator comparator) {
        a(array, new Object[n2 - n], n, n2 - 1, -n, (comparator == null) ? au.a : comparator);
    }
    
    private static void a(final Object[] array, final Object[] array2, final int n, final int n2, final int n3, final Comparator comparator) {
        final boolean c = p.c;
        if (n2 - n < 8) {
            int n4 = n + 1;
            final int n5 = n2 + 1;
            do {
                int i = 0;
            Label_0025:
                while (i < n5) {
                    final Object o = array[n4];
                    int j = n4;
                    while (j > n) {
                        i = comparator.compare(array[j - 1], o);
                        if (c) {
                            continue Label_0025;
                        }
                        if (i <= 0) {
                            break;
                        }
                        array[j] = array[j - 1];
                        --j;
                        if (c) {
                            break;
                        }
                    }
                    array[j] = o;
                    ++n4;
                }
                return;
            } while (!c);
        }
        final int n6 = (n + n2) / 2;
        a(array, array2, n, n6, n3, comparator);
        a(array, array2, n6 + 1, n2, n3, comparator);
        if (comparator.compare(array[n6], array[n6 + 1]) > 0) {
            System.arraycopy(array, n, array2, n3 + n, n6 - n + 1);
            int k = n6;
            while (true) {
                while (k < n2) {
                    array2[n3 + n2 + n6 - k] = array[k + 1];
                    ++k;
                    if (c) {
                        int n7 = n3 + n2;
                        final int n8 = n3 + n6;
                        int l = n;
                        while (l < n2 + 1) {
                            array[l] = ((k > n8 || comparator.compare(array2[k], array2[n7]) > 0) ? array2[n7--] : array2[k++]);
                            ++l;
                            if (c) {
                                break;
                            }
                        }
                        return;
                    }
                    if (c) {
                        break;
                    }
                }
                k = n3 + n;
                continue;
            }
        }
    }
    
    static {
        a = new aw(null);
    }
}
