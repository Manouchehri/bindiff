package y.h;

import java.util.*;
import y.h.a.*;
import y.c.*;

final class Q implements cg
{
    boolean a;
    private final O b;
    
    private Q(final O b) {
        this.b = b;
    }
    
    public Iterator a(final bu bu, final int n) {
        final hM hm = new hM(this.a((i)bu, n));
        if ((n & 0x7C) != 0x0) {
            return new hQ(bu, hm, n, true);
        }
        return hm;
    }
    
    public Iterator b(final bu bu, final int n) {
        final hL hl = new hL(this.a((i)bu, n));
        if ((n & 0x7C) != 0x0) {
            return new hQ(bu, hl, n, false);
        }
        return hl;
    }
    
    private ArrayList a(final i i, final int n) {
        return this.a(i, (n & 0x51) != 0x0, (n & 0x2E) != 0x0);
    }
    
    private ArrayList a(final i i, final boolean b, final boolean b2) {
        final boolean z = fj.z;
        final ArrayList list = new ArrayList<d>(Math.min(250, i.g() + i.e()));
        ArrayList<d> list2 = null;
        Label_0242: {
            Label_0230: {
                Label_0173: {
                    if (b2 && this.a) {
                        final e p3 = i.p();
                        while (p3.f()) {
                            list.add(p3.a());
                            p3.g();
                            if (z) {
                                break Label_0173;
                            }
                            if (z) {
                                break;
                            }
                        }
                    }
                    if (b) {
                        final v a = v.a(i);
                        if (a != null) {
                            a.a(a.e(i), new P(this, list));
                            if (!z) {
                                break Label_0173;
                            }
                        }
                        final x o = i.o();
                        while (o.f()) {
                            list.add((d)o.e());
                            o.g();
                            if (z) {
                                break Label_0230;
                            }
                            if (z) {
                                break;
                            }
                        }
                    }
                }
                if (b2 && !this.a) {
                    final e p4 = i.p();
                    while (p4.f()) {
                        list2 = (ArrayList<d>)list;
                        if (z) {
                            break Label_0242;
                        }
                        list2.add(p4.a());
                        p4.g();
                        if (z) {
                            break;
                        }
                    }
                }
            }
            final ArrayList list3 = new ArrayList(list.size());
        }
        final ArrayList<d> list4 = list2;
        if (!list.isEmpty() && i instanceof bu) {
            final ArrayList[] a2 = this.a(list, (bu)i);
            int j = 0;
            while (j < a2.length) {
                final ArrayList list5 = a2[j];
                final ArrayList<d> list7;
                final ArrayList<d> list6 = list7 = (ArrayList<d>)list5;
                if (z) {
                    return list7;
                }
                Label_0345: {
                    if (list6 != null) {
                        int k = 0;
                        while (k < list5.size()) {
                            list4.add(list5.get(k));
                            ++k;
                            if (z) {
                                break Label_0345;
                            }
                            if (z) {
                                break;
                            }
                        }
                    }
                    ++j;
                }
                if (z) {
                    break;
                }
            }
        }
        return list4;
    }
    
    private ArrayList[] a(final ArrayList list, final bu bu) {
        final boolean z = fj.z;
        int max = 0;
        ArrayList[] array = new ArrayList[10];
        int i = 0;
        while (true) {
            while (i < list.size()) {
                final q value = list.get(i);
                final int n = (value instanceof q) ? 1 : 0;
                if (!z) {
                    int n2 = 0;
                    Label_0086: {
                        if (n != 0) {
                            n2 = this.b.getLayer(bu, value);
                            if (!z) {
                                break Label_0086;
                            }
                        }
                        n2 = this.b.getLayer(bu, (d)value);
                    }
                    max = Math.max(n2, max);
                    if (n2 >= array.length) {
                        final ArrayList[] array2 = new ArrayList[n2 + 5];
                        System.arraycopy(array, 0, array2, 0, array.length);
                        array = array2;
                    }
                    if (array[n2] == null) {
                        array[n2] = new ArrayList(64);
                    }
                    array[n2].add(value);
                    ++i;
                    if (z) {
                        break;
                    }
                    continue;
                }
                else {
                    if (n < array.length - 1) {
                        final ArrayList[] array3 = new ArrayList[max + 1];
                        System.arraycopy(array, 0, array3, 0, max + 1);
                        return array3;
                    }
                    return array;
                }
            }
            continue;
        }
    }
    
    Q(final O o, final P p2) {
        this(o);
    }
}
