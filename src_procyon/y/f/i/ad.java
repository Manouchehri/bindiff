package y.f.i;

import y.c.*;
import java.util.*;
import y.f.*;
import y.d.*;

final class ad
{
    public static Collection a(final i i, final d d, final boolean b) {
        final c c = i.c(b ? ax.a : ax.b);
        Collection collection = null;
        if (c != null) {
            collection = (Collection)c.b(d);
        }
        return collection;
    }
    
    public static Collection b(final i i, final d d, final boolean b) {
        final c c = i.c(b ? ax.a : ax.b);
        Collection<? extends E> collection = null;
        if (c != null) {
            collection = (Collection<? extends E>)c.b(d);
            if (collection != null) {
                collection = (Collection<? extends E>)new ArrayList<Object>(collection);
            }
        }
        return collection;
    }
    
    public static void a(final X x, final d d, Collection list, Collection list2) {
        final int f = v.f;
        if (!d.e()) {
            return;
        }
        if (list == null) {
            list = new ArrayList<Object>(1);
        }
        ax ax = null;
        Label_0064: {
            if (list.isEmpty()) {
                ax = y.f.ax.b(255);
                if (f == 0) {
                    break Label_0064;
                }
            }
            ax = list.iterator().next();
        }
        if (list2 == null) {
            list2 = new ArrayList<Object>(1);
        }
        ax ax2 = null;
        Label_0115: {
            if (list2.isEmpty()) {
                ax2 = y.f.ax.b(255);
                if (f == 0) {
                    break Label_0115;
                }
            }
            ax2 = list2.iterator().next();
        }
        if (a(ax, ax2)) {
            final boolean[] a = a(ax.a());
            final boolean[] a2 = a(ax2.a());
            Label_0396: {
                Label_0279: {
                    if (b(a) > b(a2)) {
                        int i = 0;
                        while (true) {
                            while (i < a2.length) {
                                final int b2;
                                final boolean b = (b2 = (a[i] ? 1 : 0)) != 0;
                                if (f == 0) {
                                    if (b && a2[i]) {
                                        a[i] = false;
                                    }
                                    ++i;
                                    if (f != 0) {
                                        break;
                                    }
                                    continue;
                                }
                                else {
                                    if (b2 == 0) {
                                        int j = 0;
                                        while (j < a2.length) {
                                            final boolean b3 = a2[j];
                                            if (f != 0) {
                                                return;
                                            }
                                            if (b3) {
                                                final int n = (a2.length + j - 1) % a2.length;
                                                a[n] = true;
                                                a2[n] = false;
                                                if (f == 0) {
                                                    break;
                                                }
                                            }
                                            ++j;
                                            if (f != 0) {
                                                break Label_0279;
                                            }
                                        }
                                    }
                                    break Label_0396;
                                }
                            }
                            int b2 = b(a);
                            continue;
                        }
                    }
                }
                int k = 0;
                while (true) {
                    while (k < a.length) {
                        final int b5;
                        final boolean b4 = (b5 = (a[k] ? 1 : 0)) != 0;
                        if (f == 0) {
                            if (b4 && a2[k]) {
                                a2[k] = false;
                            }
                            ++k;
                            if (f != 0) {
                                break;
                            }
                            continue;
                        }
                        else {
                            if (b5 == 0) {
                                int l = 0;
                                while (l < a.length) {
                                    final boolean b6 = a[l];
                                    if (f != 0) {
                                        return;
                                    }
                                    if (b6) {
                                        final int n2 = (l + 1) % a.length;
                                        a2[n2] = true;
                                        a[n2] = false;
                                        if (f == 0) {
                                            break;
                                        }
                                    }
                                    ++l;
                                    if (f != 0) {
                                        break;
                                    }
                                }
                            }
                            break Label_0396;
                        }
                    }
                    int b5 = b(a2);
                    continue;
                }
            }
            ax = a(ax, a(a));
            ax2 = a(ax, a(a2));
        }
        list.clear();
        list.add(ax);
        list2.clear();
        list2.add(ax2);
    }
    
    private static int a(final boolean[] array) {
        int n = 0;
        if (array[0]) {
            n |= 0x1;
        }
        if (array[1]) {
            n |= 0x4;
        }
        if (array[2]) {
            n |= 0x2;
        }
        if (array[3]) {
            n |= 0x8;
        }
        return n;
    }
    
    private static boolean[] a(final int n) {
        final boolean[] array = new boolean[4];
        if ((n & 0x1) != 0x0) {
            array[0] = true;
        }
        if ((n & 0x4) != 0x0) {
            array[1] = true;
        }
        if ((n & 0x2) != 0x0) {
            array[2] = true;
        }
        if ((n & 0x8) != 0x0) {
            array[3] = true;
        }
        return array;
    }
    
    private static int b(final boolean[] array) {
        final int f = v.f;
        int n = 0;
        int i = 0;
        while (i < array.length) {
            final int n2;
            final boolean b = (n2 = (array[i] ? 1 : 0)) != 0;
            if (f != 0) {
                return n2;
            }
            if (b) {
                ++n;
            }
            ++i;
            if (f != 0) {
                break;
            }
        }
        return n;
    }
    
    private static boolean a(final ax ax, final ax ax2) {
        return (ax.a(1) && ax2.a(1)) || (ax.a(2) && ax2.a(2)) || (ax.a(4) && ax2.a(4)) || (ax.a(8) && ax2.a(8));
    }
    
    private static ax a(final ax ax, final int n) {
        if (ax.b()) {
            return ax.a(ax.c(), ax.d(), n, ax.f());
        }
        return ax.a(n, ax.f());
    }
    
    public static Collection a(final X x, final d d, Collection list, final boolean b) {
        aE ae = null;
        Label_0048: {
            if (b) {
                ae = aE.d(x, d);
                x.b((Object)d).getSourcePoint();
                if (v.f == 0) {
                    break Label_0048;
                }
            }
            ae = aE.e(x, d);
            x.b((Object)d).getTargetPoint();
        }
        if (ae != null) {
            ax ax = y.f.ax.a(ae);
            if (ae.a()) {
                final t t = b ? x.b((Object)d).getSourcePoint() : x.b((Object)d).getTargetPoint();
                ax = y.f.ax.a(t.a, t.b, ax.a());
            }
            if (list == null) {
                list = new ArrayList<ax>(1);
            }
            list.add(ax);
        }
        return list;
    }
}
