package y.f.i.a;

import y.f.*;

class bC
{
    private v c;
    private static final Object d;
    private static final Object e;
    private static final Object f;
    private boolean g;
    private Object[] h;
    private M[] i;
    boolean a;
    private M[] j;
    boolean b;
    
    public bC(final v c) {
        final int a = ab.a;
        this.h = new Object[4];
        this.i = new M[4];
        this.j = new M[4];
        this.c = c;
        final y k = c.k();
        final y l = c.l();
        if (k == null || l == null) {
            this.g = true;
            return;
        }
        final int f = k.f();
        final int f2 = l.c().f();
        Label_0341: {
            if (f == f2) {
                final M e = this.c.i().e();
                final M e2 = this.c.j().e();
                if (e.a(e2, Math.min(1.0E-6, Math.min(e.d(), e2.d())))) {
                    this.g = true;
                    if (a == 0) {
                        return;
                    }
                }
                final boolean b = k == y.b || k == y.a;
                final boolean b2 = (b && e.a() < e2.a()) || (!b && e.b() > e2.b());
                final Object o = b2 ? bC.d : bC.e;
                int i = 0;
                while (i < 4) {
                    Label_0333: {
                        if (f != i) {
                            this.h[i] = o;
                            if (a == 0) {
                                break Label_0333;
                            }
                        }
                        final M c2 = M.c(e, e2);
                        final M b3 = M.b(e, e2);
                        if (b2) {
                            this.a = true;
                            this.i[i] = c2;
                            this.j[i] = b3;
                            if (a == 0) {
                                break Label_0333;
                            }
                        }
                        this.b = true;
                        this.j[i] = c2;
                        this.i[i] = b3;
                    }
                    ++i;
                    if (a != 0) {
                        break Label_0341;
                    }
                }
                return;
            }
        }
        final int n = (f2 < f) ? (f2 + 4) : f2;
        int j = f + 1;
    Label_0413_Outer:
        while (true) {
            while (true) {
                while (j < n) {
                    this.h[j % 4] = bC.d;
                    ++j;
                    if (a != 0) {
                        final int n2 = f;
                        final int n3 = n2;
                        int n4 = f2 + 1;
                        while (n4 < n3) {
                            this.h[n4 % 4] = bC.e;
                            ++n4;
                            if (a != 0) {
                                return;
                            }
                            if (a != 0) {
                                break;
                            }
                        }
                        final y.d.y g = this.c.h().g();
                        M m = null;
                        M m2 = null;
                        Label_0738: {
                            Label_0673: {
                                switch (f) {
                                    case 0: {
                                        m = new M(g.c(), this.c.i().c());
                                        m2 = new M(this.c.i().b(), g.c() + g.a());
                                        if (a != 0) {
                                            break Label_0673;
                                        }
                                        break Label_0738;
                                    }
                                    case 1: {
                                        m = new M(g.d(), this.c.i().c());
                                        m2 = new M(this.c.i().b(), g.d() + g.b());
                                        if (a != 0) {
                                            break Label_0673;
                                        }
                                        break Label_0738;
                                    }
                                    case 2: {
                                        m = new M(this.c.i().b(), g.c() + g.a());
                                        m2 = new M(g.c(), this.c.i().c());
                                        if (a != 0) {
                                            break Label_0673;
                                        }
                                        break Label_0738;
                                    }
                                    case 3: {
                                        m = new M(this.c.i().b(), g.d() + g.b());
                                        m2 = new M(g.d(), this.c.i().c());
                                        if (a != 0) {
                                            break;
                                        }
                                        break Label_0738;
                                    }
                                }
                            }
                            m = null;
                            m2 = null;
                        }
                        this.i[f] = m;
                        this.j[f] = m2;
                        M m3 = null;
                        M m4 = null;
                        Label_1030: {
                            Label_0965: {
                                switch (f2) {
                                    case 0: {
                                        m3 = new M(g.c(), this.c.j().c());
                                        m4 = new M(this.c.j().b(), g.c() + g.a());
                                        if (a != 0) {
                                            break Label_0965;
                                        }
                                        break Label_1030;
                                    }
                                    case 1: {
                                        m3 = new M(g.d(), this.c.j().c());
                                        m4 = new M(this.c.j().b(), g.d() + g.b());
                                        if (a != 0) {
                                            break Label_0965;
                                        }
                                        break Label_1030;
                                    }
                                    case 2: {
                                        m3 = new M(this.c.j().b(), g.c() + g.a());
                                        m4 = new M(g.c(), this.c.j().c());
                                        if (a != 0) {
                                            break Label_0965;
                                        }
                                        break Label_1030;
                                    }
                                    case 3: {
                                        m3 = new M(this.c.j().b(), g.d() + g.b());
                                        m4 = new M(g.d(), this.c.j().c());
                                        if (a != 0) {
                                            break;
                                        }
                                        break Label_1030;
                                    }
                                }
                            }
                            m4 = null;
                            m3 = null;
                        }
                        this.i[f2] = m4;
                        this.j[f2] = m3;
                        return;
                    }
                    if (a != 0) {
                        break;
                    }
                }
                if (f < f2) {
                    final int n2 = f + 4;
                    continue;
                }
                break;
            }
            continue Label_0413_Outer;
        }
    }
    
    private int a(final y y, final boolean b) {
        if (b) {
            return y.f();
        }
        return (y.f() + 2) % 4;
    }
    
    public bE a(final v v, final bD bd) {
        final int a = ab.a;
        if (this.g || v.k() == null) {
            return new bE(0);
        }
        M m = null;
        final int a2 = this.a(v.k(), true);
        Object o = null;
        Label_0244: {
            if (this.h[a2] != null) {
                o = this.h[a2];
                if (a == 0) {
                    break Label_0244;
                }
            }
            M i = null;
            Label_0107: {
                if (v.c() != 0) {
                    i = v.i().e();
                    if (a == 0) {
                        break Label_0107;
                    }
                }
                m = (i = M.a(v.i().e(), v.j().e()));
            }
            final double n = (i.d() > 1.0E-6) ? 1.0E-6 : 0.0;
            final boolean a3 = this.i[a2].a(i, n);
            final boolean b = this.a ? (!a3) : a3;
            final boolean a4 = this.j[a2].a(i, n);
            final boolean b2 = this.b ? (!a4) : a4;
            o = (b ? (b2 ? bC.f : bC.d) : (b2 ? bC.e : null));
        }
        final int a5 = this.a(v.l(), false);
        Object o2 = null;
        Label_0464: {
            if (this.h[a5] != null) {
                o2 = this.h[a5];
                if (a == 0) {
                    break Label_0464;
                }
            }
            M e = null;
            Label_0327: {
                if (v.c() != 0) {
                    e = v.j().e();
                    if (a == 0) {
                        break Label_0327;
                    }
                }
                e = ((m != null) ? m : M.a(v.i().e(), v.j().e()));
            }
            final double n2 = (e.d() > 1.0E-6) ? 1.0E-6 : 0.0;
            final boolean a6 = this.i[a5].a(e, n2);
            final boolean b3 = this.a ? (!a6) : a6;
            final boolean a7 = this.j[a5].a(e, n2);
            final boolean b4 = this.b ? (!a7) : a7;
            o2 = (b3 ? (b4 ? bC.f : bC.d) : (b4 ? bC.e : null));
        }
        if (o == null || o2 == null) {
            return new bE(0);
        }
        if (o == bC.f && o2 == bC.f) {
            return new bE(0, bd);
        }
        if (o == bC.f || o2 == bC.f) {
            final bE be = new bE(0, new bD(v.g(), this.c.g(), (o != bC.f) ? o : o2, 1));
            be.a(bd);
            return be;
        }
        if (o == o2) {
            int n3 = (bd != null && !bD.b(bd).equals(o)) ? bd.c() : 0;
            if (this.c.c() == 2 && v.c() == 2 && this.h[a2] != null && this.h[a5] != null) {
                double n4 = 0.0;
                double n5 = 0.0;
                int n6 = 0;
                int n7 = 0;
                Label_0791: {
                    if (v.k().d()) {
                        n4 = v.j().e().c(v.i().f());
                        n5 = v.i().e().c(v.j().f());
                        n6 = v.k().c().f();
                        n7 = v.l().f();
                        if (a == 0) {
                            break Label_0791;
                        }
                    }
                    n4 = v.i().e().c(v.j().f());
                    n5 = v.j().e().c(v.i().f());
                    n7 = v.k().c().f();
                    n6 = v.l().f();
                }
                if ((o == bC.d && !this.i[n6].a(n5) && !this.i[n7].a(n4)) || (o == bC.e && !this.j[n6].a(n5) && !this.j[n7].a(n4))) {
                    n3 += 2;
                }
            }
            return new bE(n3);
        }
        return new bE(1 + ((bd != null && !bD.b(bd).equals(o)) ? bd.c() : 0));
    }
    
    static {
        d = "LEFT_SIDE";
        e = "RIGHT_SIDE";
        f = "BOTH_SIDES";
    }
}
