package y.h.b;

import y.h.a.*;
import java.util.*;
import y.c.*;
import y.h.*;

final class I
{
    private final Collection a;
    private final Collection b;
    private final Map c;
    
    I(final Collection collection, final Collection collection2, final Map c) {
        this.a = Collections.unmodifiableCollection((Collection<?>)collection);
        this.b = Collections.unmodifiableCollection((Collection<?>)collection2);
        this.c = c;
    }
    
    public Collection a() {
        return this.a;
    }
    
    Collection b() {
        return this.b;
    }
    
    q a(final i i) {
        return this.c.get(i);
    }
    
    static I a(final bu bu) {
        final int i = a.H;
        final v a = v.a(bu);
        if (a == null) {
            return null;
        }
        final ArrayList<q> list = new ArrayList<q>();
        final ArrayList list2 = new ArrayList<i>();
        final HashMap<i, q> hashMap = new HashMap<i, q>();
        final x o = bu.o();
        do {
            Label_0047: {
                o.f();
            }
            boolean b = false;
            Label_0054:
            while (b) {
                final q e = o.e();
                if (i == 0) {
                    Label_0272: {
                        if (a.n(e) == null) {
                            Label_0265: {
                                if (a.k(e)) {
                                    final fj a2 = y.h.b.v.a(bu, e);
                                    if (a2 instanceof a) {
                                        final i l = ((a)a2).l();
                                        list2.add(l);
                                        hashMap.put(l, e);
                                        if (i == 0) {
                                            break Label_0272;
                                        }
                                    }
                                    list.add(e);
                                    final ArrayList list3 = new ArrayList<q>();
                                    list3.add(e);
                                    Label_0161:
                                    while (true) {
                                        boolean b2 = list3.isEmpty();
                                        Label_0166:
                                        while (!b2) {
                                            final x p = a.p(list3.remove(list3.size() - 1));
                                            while (p.f()) {
                                                list.add(p.e());
                                                b = (b2 = a.k(p.e()));
                                                if (i != 0) {
                                                    continue Label_0054;
                                                }
                                                if (i != 0) {
                                                    continue Label_0166;
                                                }
                                                if (b) {
                                                    list3.add(p.e());
                                                }
                                                p.g();
                                                if (i != 0) {
                                                    break Label_0265;
                                                }
                                            }
                                            continue Label_0161;
                                        }
                                        break Label_0272;
                                    }
                                }
                            }
                            list.add(e);
                        }
                    }
                    o.g();
                    continue Label_0047;
                }
                return new I(list, list2, hashMap);
            }
            break;
        } while (i == 0);
        if (list2.isEmpty()) {
            return null;
        }
        return new I(list, list2, hashMap);
    }
}
