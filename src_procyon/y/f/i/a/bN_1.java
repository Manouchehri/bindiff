package y.f.i.a;

import java.util.*;
import y.f.*;
import y.c.*;

class bN
{
    final List a;
    final int b;
    final HashSet c;
    final boolean d;
    private final bF e;
    
    bN(final bF e, final List a, final int b) {
        this.e = e;
        this.c = new HashSet();
        this.a = a;
        this.b = b;
        this.d = a.get(0).a(b).g();
    }
    
    D a() {
        final int a = ab.a;
        final D d = new D();
        final D b = this.b();
        final HashMap hashMap = new HashMap<w, List<?>>();
        p p = b.k();
    Label_0168:
        while (true) {
            while (p != null) {
                bO bo = (bO)p.c();
                bO.b(bo);
                final Iterator iterator = bo.a.iterator();
                if (a == 0) {
                    final Iterator iterator2 = iterator;
                    while (iterator2.hasNext()) {
                        final w w = iterator2.next();
                        final int containsKey = hashMap.containsKey(w) ? 1 : 0;
                        if (a != 0) {
                            break Label_0168;
                        }
                        List<?> list = null;
                        Label_0137: {
                            if (containsKey != 0) {
                                list = hashMap.get(w);
                                if (a == 0) {
                                    break Label_0137;
                                }
                            }
                            list = (List<?>)new D();
                            hashMap.put(w, list);
                        }
                        list.add(p);
                        if (a != 0) {
                            break;
                        }
                    }
                    p = p.a();
                    if (a != 0) {
                        break;
                    }
                    continue;
                    int containsKey = 0;
                    if (containsKey <= 0) {
                        return;
                    }
                    final p b2 = this.b(b);
                    bo = (bO)b2.c();
                    b.h(b2);
                }
                final bN a2 = this.a(bo, b, hashMap);
                if (a2 == null) {
                    break;
                }
                final D d2 = d;
                if (a == 0) {
                    d2.add(a2);
                    if (a == 0) {
                        break;
                    }
                }
                return d2;
            }
            b.size();
            continue Label_0168;
        }
    }
    
    private bN a(final bO bo, final D d, final HashMap hashMap) {
        final int a = ab.a;
        final HashSet<p> set = new HashSet<p>();
        final D d2 = new D();
        final D d3 = new D();
        final D d4 = new D();
        final ah ah = new ah(bo.c, d4);
        Iterator<w> iterator = (Iterator<w>)bo.a.iterator();
    Label_0420:
        while (true) {
            Object c = null;
            Label_0376: {
            Label_0332:
                while (true) {
                    iterator.hasNext();
                    boolean add = false;
                Label_0235_Outer:
                    while (add) {
                        final w w = iterator.next();
                        final ai a2 = w.a(this.b);
                        Label_0246: {
                            if (bo.a.size() > 1) {
                                d4.add(a2);
                                a2.a(ah);
                                while (true) {
                                    for (final v v : w.d()) {
                                        if (v.i() != null && v.d() == this.b) {
                                            v.a(ah);
                                        }
                                        if (v.j() != null) {
                                            final int e = v.e();
                                            final int b = this.b;
                                            if (a == 0) {
                                                if (e != b) {
                                                    continue Label_0235_Outer;
                                                }
                                                v.b(ah);
                                                if (a != 0) {
                                                    break;
                                                }
                                                continue Label_0235_Outer;
                                            }
                                            else {
                                                if (e > b) {
                                                    d3.add(w);
                                                }
                                                break Label_0246;
                                            }
                                        }
                                    }
                                    w.e();
                                    final int n = this.b + 1;
                                    continue;
                                }
                            }
                        }
                        for (final p p3 : hashMap.get(w)) {
                            c = p3.c();
                            if (a != 0) {
                                break Label_0376;
                            }
                            if (c == bo) {
                                continue;
                            }
                            add = set.add(p3);
                            if (a != 0) {
                                continue Label_0235_Outer;
                            }
                            if (!add) {
                                continue;
                            }
                            d2.add((w)p3);
                            if (a != 0) {
                                break Label_0332;
                            }
                        }
                        continue Label_0420;
                    }
                    break;
                }
                if (ah.b().size() > 0) {
                    ah.d();
                }
                iterator = d2.iterator();
                if (!iterator.hasNext()) {
                    break Label_0420;
                }
                iterator.next();
            }
            final p p4 = (p)c;
            if (!((bO)p4.c()).b(bo.a)) {
                continue;
            }
            d.h(p4);
            if (a != 0) {
                return null;
            }
            if (a == 0) {
                continue;
            }
            break;
        }
        if (d3.size() > 1) {
            return new bN(this.e, d3, this.b + 1);
        }
        return null;
    }
    
    private D b() {
        final int a = ab.a;
        y y = null;
        final D d = new D();
        final D d2 = new D();
        for (final w w : this.a) {
            final y h = w.a(this.b).h();
            if (y == null) {
                y = h;
            }
            if (y == h) {
                d.add(w);
                if (a == 0) {
                    continue;
                }
            }
            d2.add(w);
            if (a != 0) {
                break;
            }
        }
        final bM bm = new bM(this);
        d.sort(bm);
        d2.sort(bm);
        return this.a(this.a(d), this.a(d2));
    }
    
    private D a(final D d) {
        final int i = ab.a;
        final D d2 = new D();
        final C m = d.m();
        D d4 = null;
        do {
            Label_0018: {
                m.f();
            }
            boolean d3 = false;
            Label_0024:
            while (d3) {
                final w w = (w)m.d();
                final M c = w.a(this.b).c();
                bO bo = new bO(this, w);
                d4 = d2;
                if (i == 0) {
                    p p = d4.k();
                    while (p != null) {
                        final bO bo2 = (bO)p.c();
                        d3 = bo2.c.d(c);
                        if (i != 0) {
                            continue Label_0024;
                        }
                        Label_0199: {
                            if (d3) {
                                bo = null;
                                bo2.a(w);
                            }
                            else if (c.c(bo2.c) && bo != null) {
                                final Iterator iterator = bo2.a.iterator();
                                while (iterator.hasNext()) {
                                    bo.a(iterator.next());
                                    if (i != 0) {
                                        break Label_0199;
                                    }
                                    if (i != 0) {
                                        break;
                                    }
                                }
                            }
                            p = p.a();
                        }
                        if (i != 0) {
                            break;
                        }
                    }
                    if (bo != null) {
                        d2.b(bo);
                    }
                    m.g();
                    continue Label_0018;
                }
                return d4;
            }
            break;
        } while (i == 0);
        return d4;
    }
    
    private D a(final D d, final D d2) {
        final int a = ab.a;
        final D d3 = new D();
        p p2 = d2.l();
    Label_0246_Outer:
        while (p2 != null) {
            final bO bo = (bO)p2.c();
            final M c = bo.c;
            final D d4 = d;
            if (a == 0) {
                p p3 = d.l();
                while (true) {
                    while (p3 != null) {
                        final bO bo2 = (bO)p3.c();
                        final M c2 = bo2.c;
                        if (c2.d(c)) {
                            bo2.a(bo);
                            if (a == 0) {
                                break;
                            }
                        }
                        if (c.c(c2)) {
                            bo.a(bo2.a);
                            d3.add(bo);
                            if (a == 0) {
                                break;
                            }
                        }
                        Label_0210: {
                            if (c2.c(c)) {
                                bo2.a(bo.a);
                                if (a == 0) {
                                    break Label_0210;
                                }
                            }
                            if (c2.a(c, 1.0E-6)) {
                                final M a2 = M.a(c2, c);
                                if (!this.c.contains(a2)) {
                                    d3.add(new bO(this, bo2, bo, a2));
                                }
                            }
                        }
                        p3 = p3.b();
                        if (p3 == null) {
                            d3.add(bo);
                            if (a == 0) {
                                if (a != 0) {
                                    break;
                                }
                                continue Label_0246_Outer;
                            }
                            else {
                                if (a != 0) {
                                    break Label_0246_Outer;
                                }
                                continue Label_0246_Outer;
                            }
                        }
                    }
                    p2 = p2.b();
                    continue;
                }
            }
            return d4;
        }
        d3.a(d);
        return d3;
    }
    
    private p b(final D d) {
        final int a = ab.a;
        double n = Double.MAX_VALUE;
        p p = d.k();
        p p2 = null;
        while (p != null) {
            p2 = p;
            if (a != 0) {
                return p2;
            }
            final double a2 = ((bO)p2.c()).a();
            if (a2 < n) {
                n = a2;
            }
            p = p.a();
            if (a != 0) {
                break;
            }
        }
        return p2;
    }
    
    static bF a(final bN bn) {
        return bn.e;
    }
}
