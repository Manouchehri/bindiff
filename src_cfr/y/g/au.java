/*
 * Decompiled with CFR 0_115.
 */
package y.g;

import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import y.g.av;
import y.g.aw;
import y.g.p;

class au {
    private static final Comparator a = new aw(null);

    static void a(List list, Comparator comparator) {
        boolean bl2 = p.c;
        Object[] arrobject = list.toArray();
        au.b(arrobject, 0, arrobject.length, comparator);
        ListIterator<Object> listIterator = list.listIterator();
        int n2 = 0;
        int n3 = arrobject.length;
        do {
            if (n2 >= n3) return;
            listIterator.next();
            listIterator.set(arrobject[n2]);
            ++n2;
        } while (!bl2);
    }

    static void a(Object[] arrobject, Comparator comparator) {
        au.b(arrobject, 0, arrobject.length, comparator);
    }

    static void a(Object[] arrobject, int n2, int n3, Comparator comparator) {
        au.b(arrobject, n2, n3, comparator);
    }

    private static void b(Object[] arrobject, int n2, int n3, Comparator comparator) {
        au.a(arrobject, new Object[n3 - n2], n2, n3 - 1, - n2, comparator == null ? a : comparator);
    }

    private static void a(Object[] arrobject, Object[] arrobject2, int n2, int n3, int n4, Comparator comparator) {
        int n5;
        int n6;
        boolean bl2;
        int n7;
        block7 : {
            bl2 = p.c;
            if (n3 - n2 < 8) {
                n6 = n2 + 1;
                n5 = n3 + 1;
                do {
                    Object object;
                    int n8 = n6;
                    block1 : do {
                        if (n8 >= n5) return;
                        object = arrobject[n6];
                        for (n7 = n6; n7 > n2; --n7) {
                            n8 = comparator.compare(arrobject[n7 - 1], object);
                            if (bl2) continue block1;
                            if (n8 <= 0) break block1;
                            arrobject[n7] = arrobject[n7 - 1];
                            if (!bl2) continue;
                        }
                        break;
                    } while (true);
                    arrobject[n7] = object;
                    ++n6;
                } while (!bl2);
            }
            n6 = (n2 + n3) / 2;
            au.a(arrobject, arrobject2, n2, n6, n4, comparator);
            au.a(arrobject, arrobject2, n6 + 1, n3, n4, comparator);
            if (comparator.compare(arrobject[n6], arrobject[n6 + 1]) <= 0) return;
            System.arraycopy(arrobject, n2, arrobject2, n4 + n2, n6 - n2 + 1);
            for (n5 = n6; n5 < n3; ++n5) {
                arrobject2[n4 + n3 + n6 - n5] = arrobject[n5 + 1];
                if (!bl2) {
                    if (!bl2) continue;
                }
                break block7;
            }
            n5 = n4 + n2;
        }
        int n9 = n4 + n3;
        n7 = n4 + n6;
        int n10 = n2;
        int n11 = n3 + 1;
        do {
            if (n10 >= n11) return;
            arrobject[n10] = n5 > n7 || comparator.compare(arrobject2[n5], arrobject2[n9]) > 0 ? arrobject2[n9--] : arrobject2[n5++];
            ++n10;
        } while (!bl2);
    }
}

