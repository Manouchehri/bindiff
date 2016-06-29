package y.f.f.c;

import y.f.f.b.*;
import y.g.*;
import y.c.*;
import java.util.*;

public class b implements l
{
    private int a;
    
    public b() {
        this.a = 1;
    }
    
    public void a(final int a) {
        this.a = a;
    }
    
    public void a(final h h, final p p3, final p p4) {
        final int a = g.a;
        new q(p3, p4).a(h);
        int n = Integer.MAX_VALUE;
        int n2 = 0;
        int n3 = 1;
        int n4 = 0;
        int i = 1;
        while (i != 0) {
            o.a(this, "New Iteration: " + n3);
            i = 0;
            Label_0139: {
                switch (n3) {
                    case 0: {
                        n2 = 1;
                        this.a(h, p3, y.f.f.b.o.b);
                        n4 = q.a(h, p3, p4);
                        if (n4 < n) {
                            i = 1;
                        }
                        n = n4;
                        if (a != 0) {
                            break Label_0139;
                        }
                        break;
                    }
                    case 1: {
                        n2 = 0;
                        this.a(h, p4, y.f.f.b.o.c);
                        n4 = q.a(h, p3, p4);
                        if (n4 < n) {
                            i = 1;
                        }
                        n = n4;
                        break;
                    }
                }
            }
            n3 = n2;
            o.a(this, "Total Edge Length: " + n4);
            if (a != 0) {
                break;
            }
        }
    }
    
    public void a(final h h, final p p3, final y.f.f.b.o o) {
        final int a = g.a;
        p3.b();
        final C m = this.a(p3.e()).m();
        final e e = new e(p3);
        while (true) {
            while (m.f()) {
                final d d = (d)m.d();
                final int b = d.b();
                if (a != 0) {
                    Label_0300: {
                        switch (b) {
                            case 0: {
                                new k().a(p3);
                                if (a != 0) {
                                    break Label_0300;
                                }
                                break;
                            }
                            case 1: {
                                new y.f.f.c.h().a(p3);
                                if (a != 0) {
                                    break Label_0300;
                                }
                                break;
                            }
                            case 2: {
                                final n n = new n();
                                n.a(true);
                                n.a(p3);
                                break;
                            }
                        }
                    }
                    return;
                }
                Label_0207: {
                    switch (b) {
                        case 0: {
                            final g c = d.c();
                            final g[] a2 = e.a(c);
                            final g g = a2[0];
                            final g g2 = a2[1];
                            if (g != null && g.i() != c.i() && !a(h, g, c)) {
                                p3.a(g, c, 1);
                            }
                            if (g2 == null || c.i() == g2.i() || a(h, c, g2)) {
                                break;
                            }
                            p3.a(c, g2, 1);
                            if (a != 0) {
                                break Label_0207;
                            }
                            break;
                        }
                        case 1: {
                            e.b(d.c());
                            break;
                        }
                    }
                }
                m.g();
                if (a != 0) {
                    break;
                }
            }
            final int a3 = this.a;
            continue;
        }
    }
    
    protected D a(final C c) {
        final int a = g.a;
        final D d = new D();
        while (c.f()) {
            final g g = (g)c.d();
            final d d2 = new d(g.d().i(), 0, g);
            final d d3 = new d(g.e().i(), 1, g);
            d.add(d2);
            d.add(d3);
            c.g();
            if (a != 0) {
                return d;
            }
            if (a != 0) {
                break;
            }
        }
        d.sort(new c(this));
        return d;
    }
    
    protected static boolean a(final h h, final g g, final g g2) {
        if (g.e() == g2.d()) {
            return g.g().a(g2.f()) != null;
        }
        return g2.e() == g.d() && g2.g().a(g.f()) != null;
    }
}
