package y.a;

import y.c.*;
import y.g.*;

class ag
{
    private final D a;
    private int b;
    private S c;
    private int d;
    private int e;
    private int f;
    private boolean g;
    private double h;
    private boolean i;
    
    static void a(final C c, final b b, final c c2) {
        final boolean a = h.a;
        c.i();
        while (c.f()) {
            b.a(c.d(), b.c(c.d()) + c2.c(c.d()));
            c.g();
            if (a) {
                break;
            }
        }
    }
    
    static void b(final C c, final b b, final c c2) {
        final boolean a = h.a;
        c.i();
        while (c.f()) {
            b.a(c.d(), b.c(c.d()) - c2.c(c.d()));
            c.g();
            if (a) {
                break;
            }
        }
    }
    
    static void a(final C c, final c c2, final a a) {
        final boolean a2 = h.a;
        c.i();
        while (c.f()) {
            a.a(c.d(), c2.a(c.d()));
            c.g();
            if (a2) {
                break;
            }
        }
    }
    
    static int a(final d d, final A a, final int n) {
        final boolean a2 = h.a;
        final y y = new y();
        y.add(d.c());
        a.a(d.c(), n);
        y.add(d.d());
        a.a(d.d(), -n);
        Label_0177: {
        Block_6:
            while (true) {
                y.isEmpty();
                int i = 0;
            Label_0058:
                while (i == 0) {
                    final q d2 = y.d();
                    final int a3 = a.a(d2);
                    final e j = d2.j();
                    while (j.f()) {
                        final q a4 = j.a().a(d2);
                        final int a5 = a.a(a4);
                        final int n2;
                        i = (n2 = a5);
                        if (a2) {
                            continue Label_0058;
                        }
                        if (a2) {
                            return n2;
                        }
                        if (i != a3) {
                            if (a5 == -a3) {
                                break Block_6;
                            }
                            a.a(a4, a3);
                            y.add(a4);
                        }
                        j.g();
                        if (a2) {
                            break Label_0177;
                        }
                    }
                    continue Label_0177;
                }
                return 2;
            }
            return 1;
        }
        return 2;
    }
    
    static void a(final d d, final int n, final y y, final f f, final A a) {
        final boolean a2 = h.a;
        if (d == null) {
            return;
        }
        final y.c.h b = M.b();
        final y y2 = new y();
        y2.add(d.c());
        a.a(d.c(), 1);
        y2.add(d.d());
        a.a(d.d(), 1);
    Label_0235:
        while (true) {
            y2.isEmpty();
            int i = 0;
        Label_0073:
            while (i == 0) {
                final q d2 = y2.d();
                final int a3 = a.a(d2);
                y.add(d2);
                final e j = d2.j();
                while (j.f()) {
                    final d a4 = j.a();
                    final q a5 = a4.a(d2);
                    i = a3 + 1;
                    if (a2) {
                        continue Label_0073;
                    }
                    if (i <= n && a.a(a5) <= 0) {
                        a.a(a5, a3 + 1);
                        y2.add(a5);
                    }
                    if (a.a(a5) > 0 && !b.d(a4)) {
                        f.add(a4);
                        b.a(a4, true);
                    }
                    j.g();
                    if (a2) {
                        break Label_0235;
                    }
                }
                continue Label_0235;
            }
            break;
        }
    }
    
    ag() {
        this.c(2);
        this.b(Integer.MAX_VALUE);
        this.a(1);
        this.a = new D();
        this.c = S.a();
        this.b = 0;
        this.g = true;
        this.i = false;
        this.h = 1.0;
    }
    
    void a(final double n) {
        final boolean a = y.a.h.a;
        if (n < 0.0 || n > 1.0) {
            throw new IllegalArgumentException("Ratio must be within [0,1]");
        }
        this.b(true);
        this.c(2);
        this.b(Integer.MAX_VALUE);
        this.a(4);
        this.d(0);
        this.a(false);
        this.b(1.0);
        this.e(2);
        if (n > 0.84) {
            this.d(0);
            if (!a) {
                return;
            }
        }
        if (n > 0.69) {
            this.d(1);
            if (!a) {
                return;
            }
        }
        if (n > 0.29) {
            this.d(1);
            this.b(4.0);
            if (!a) {
                return;
            }
        }
        this.d(2);
        this.e(2);
    }
    
    void a(final int d) {
        if (d > 1) {
            this.d = d;
            if (!y.a.h.a) {
                return;
            }
        }
        this.d = 2;
    }
    
    void b(final int f) {
        if (f > 1) {
            this.f = f;
            if (!y.a.h.a) {
                return;
            }
        }
        this.f = Integer.MAX_VALUE;
    }
    
    void c(final int e) {
        if (e > 0) {
            this.e = e;
            if (!y.a.h.a) {
                return;
            }
        }
        this.e = 1;
    }
    
    void d(final int b) {
        this.b = b;
        this.a.a(b);
    }
    
    void b(final double h) {
        this.h = h;
    }
    
    void a(final boolean i) {
        this.i = i;
    }
    
    void e(final int n) {
        this.a.b(n);
    }
    
    void b(final boolean g) {
        this.g = g;
    }
    
    int a(final i i, final A a) {
        final boolean a2 = y.a.h.a;
        final I j = new I(i);
        final d[] n = i.n();
        ai ai = null;
        Label_0078: {
            if (this.b == 2) {
                ai = new ah(this, i);
                if (!a2) {
                    break Label_0078;
                }
            }
            if (this.i) {
                ai = new ak(this, i);
                if (!a2) {
                    break Label_0078;
                }
            }
            ai = new ai(this, i);
        }
        final y[] a3 = y.a.h.a(i);
        int k = 0;
        while (k < a3.length) {
            ai.b(a3[k]);
            ++k;
            if (a2) {
                break;
            }
        }
        aj a4 = aj.a(i, ai.e(), ai.d(), this.c.a(n, ai.e(), ai.d()));
        final A a5 = M.a(new int[i.e()]);
        int n2 = 1;
        while (ai.d() < this.f) {
            final int n3;
            final boolean b = (n3 = (ai.c() ? 1 : 0)) != 0;
            if (a2) {
                return n3;
            }
            if (b) {
                final d b2 = ai.b();
                j.a(b2);
                final y a6 = ai.a(b2.c());
                final int a7 = a(b2, a5, ++n2);
                if (a7 == 1) {
                    ai.c(a6);
                    if (!a2) {
                        continue;
                    }
                }
                if (a7 == 2) {
                    ai.a(a6, a5);
                    final aj a8 = aj.a(i, ai.e(), ai.d(), this.c.a(n, ai.e(), ai.d()));
                    if (a8.b() != this.e && a8.c() <= a4.c()) {
                        continue;
                    }
                    a4 = a8;
                    if (!a2) {
                        continue;
                    }
                }
                throw new IllegalStateException("There shouldn't be more than 2 components after an edge removal.");
            }
            break;
        }
        a(i.o(), a4.a(), (a)a);
        ai.a();
        j.h();
        return a4.b();
    }
    
    static D a(final ag ag) {
        return ag.a;
    }
    
    static double b(final ag ag) {
        return ag.h;
    }
    
    static int c(final ag ag) {
        return ag.d;
    }
    
    static boolean d(final ag ag) {
        return ag.g;
    }
}
