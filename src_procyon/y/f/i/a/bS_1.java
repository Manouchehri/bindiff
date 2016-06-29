package y.f.i.a;

import java.util.*;
import y.f.*;
import y.c.*;
import y.d.*;

class bS extends K
{
    private HashMap a;
    private List b;
    
    public void a() {
        super.a();
        this.a = null;
        this.b = null;
    }
    
    public void a(final R r, final List list) {
        final int a = ab.a;
        final List<bU> list2 = this.a.get(r);
        if (list2 != null) {
        Label_0201_Outer:
            for (final bU bu : list2) {
                final d a2 = bU.a(bu);
                R a3 = null;
                int n = 0;
                int i = 0;
                while (true) {
                    while (i < bU.b(bu).length) {
                        final y.d.m m = bU.b(bu)[i];
                        final R r2 = a3;
                        if (a == 0) {
                            Label_0191: {
                                Label_0158: {
                                    if (r2 != null && !a3.g().a(m.d())) {
                                        this.a(a3, this.a(a2, bu, n, i - n + 1));
                                        if (a == 0) {
                                            break Label_0158;
                                        }
                                    }
                                    if (a3 != null) {
                                        break Label_0191;
                                    }
                                }
                                a3 = this.a(list, m, a3, bU.c(bu) + i, a2);
                                n = i;
                                if (a3 == null) {
                                    break;
                                }
                            }
                            ++i;
                            if (a != 0) {
                                break;
                            }
                            continue Label_0201_Outer;
                        }
                        else {
                            if (r2 == null) {
                                continue Label_0201_Outer;
                            }
                            this.a(a3, this.a(a2, bu, n, bU.b(bu).length - n));
                            if (a != 0) {
                                return;
                            }
                            if (a != 0) {
                                break Label_0201_Outer;
                            }
                            continue Label_0201_Outer;
                        }
                    }
                    continue;
                }
            }
            this.a.remove(r);
        }
    }
    
    private bU a(final d d, final bU bu, final int n, final int n2) {
        final y.d.m[] array = new y.d.m[n2];
        System.arraycopy(bU.b(bu), n, array, 0, n2);
        return new bU(d, array, bU.c(bu) + n, null);
    }
    
    private R a(final List list, final y.d.m m, final R r, final int n, final d d) {
        final int a = ab.a;
        R r2 = null;
        for (final R r3 : this.a(list, m)) {
            if (r3.g().a(m.d())) {
                r2 = r3;
                if (a == 0) {
                    continue;
                }
            }
            if (r3 != r) {
                this.a(r3, new bU(d, new y.d.m[] { m }, n, null));
                if (a != 0) {
                    break;
                }
                continue;
            }
        }
        return r2;
    }
    
    private void a(final R r, final bU bu) {
        List<bU> list = this.a.get(r);
        if (list == null) {
            list = new ArrayList<bU>();
            this.a.put(r, list);
        }
        list.add(bu);
    }
    
    private List a(final List list, final y.d.m m) {
        final int a = ab.a;
        final ArrayList<R> list2 = new ArrayList<R>();
        ArrayList<R> list3 = null;
        for (final R r : list) {
            if (m.a(r.g())) {
                list3 = list2;
                if (a != 0) {
                    return list3;
                }
                list3.add(r);
                if (a != 0) {
                    break;
                }
                continue;
            }
        }
        return list3;
    }
    
    public void b(final R r) {
        final int a = ab.a;
        final List<bU> list = this.a.get(r);
        if (list != null && list.size() > 0) {
            final bc b = r.b();
            for (final bU bu : list) {
                final y g = r.g();
                final t c = bU.b(bu)[0].c();
                final t d = bU.b(bu)[bU.b(bu).length - 1].d();
                final bV a2 = this.a(g, c, true);
                final bV a3 = this.a(g, d, false);
                b.a(new v(bU.a(bu), r, a2.a, a3.a, a2.b, a3.b, bU.c(bu)));
                if (a != 0) {
                    break;
                }
            }
        }
    }
    
    private bV a(final y y, final t t, final boolean b) {
        final double c = y.c();
        final double n = c + y.a();
        final double d = y.d();
        final double n2 = d + y.b();
        final double a = t.a();
        final double b2 = t.b();
        if (a < c + 1.0E-6) {
            return new bV(b ? y.f.y.b : y.f.y.d, new P(b2, b2, c, true), null);
        }
        if (a > n - 1.0E-6) {
            return new bV(b ? y.f.y.d : y.f.y.b, new P(b2, b2, n, true), null);
        }
        if (b2 < d + 1.0E-6) {
            return new bV(b ? y.f.y.c : y.f.y.a, new P(a, a, d, false), null);
        }
        if (b2 > n2 - 1.0E-6) {
            return new bV(b ? y.f.y.a : y.f.y.c, new P(a, a, n2, false), null);
        }
        return new bV(null, null, null);
    }
    
    public void a(final R r) {
        if (this.b != null) {
            this.a.put(r, this.b);
            this.b = null;
        }
    }
    
    public void a(final Z z, final I i) {
        final int j = ab.a;
        super.a(z, i);
        final X a = z.a();
        this.a = new HashMap();
        final y.f.i.a.y c = z.c();
        final c c2 = a.c(c.h());
        if (c.f() == 0 || c2 == null) {
            return;
        }
        this.b = new D();
        final e p2 = a.p();
        do {
            Label_0075: {
                p2.f();
            }
            boolean a2 = false;
            Label_0082:
            while (a2) {
                final d a3 = p2.a();
                Label_0244: {
                    if (!c2.d(a3)) {
                        final s k = a.l(a3).j();
                        if (y.f.i.a.y.b(a3, a)) {
                            this.b.add(new bU(a3, y.f.i.a.y.c(a3, a), 0, null));
                            if (j == 0) {
                                break Label_0244;
                            }
                        }
                        int n = 0;
                        while (k.f()) {
                            final y.d.m a4 = k.a();
                            a2 = this.a(a4);
                            if (j != 0) {
                                continue Label_0082;
                            }
                            if (a2) {
                                this.b.add(new bU(a3, new y.d.m[] { a4 }, n, null));
                            }
                            k.g();
                            ++n;
                            if (j != 0) {
                                break;
                            }
                        }
                    }
                }
                p2.g();
                continue Label_0075;
            }
            break;
        } while (j == 0);
    }
    
    private boolean a(final y.d.m m) {
        return m.b() || m.a();
    }
}
