package y.f.f.d;

import y.f.f.c.*;
import y.f.f.b.*;
import y.f.h.*;
import y.c.*;

class g implements f
{
    private K a;
    private p b;
    private p c;
    private D d;
    
    public void a(final D d) {
        this.d = d;
    }
    
    public void a(final h h, final p b, final p c) {
        final boolean p3 = o.p;
        this.a = (K)h;
        this.b = b;
        this.c = c;
        final q c2 = this.a.c();
        while (c2.f()) {
            Label_0093: {
                if (this.d == null) {
                    this.a(c2.a());
                    if (!p3) {
                        break Label_0093;
                    }
                }
                if (!this.d.contains(c2.a())) {
                    this.a(c2.a());
                }
            }
            c2.g();
            if (p3) {
                break;
            }
        }
    }
    
    private void a(final y.f.h.p p) {
        final D b = this.b(p);
        final D d = new D();
        d.add(new j(this));
        d.add(new i(this));
        d.add(new y.f.f.d.h(this));
        this.a(b, d);
        if (b.size() != 4) {
            final D b2 = this.b(b);
            final D d2 = new D();
            d2.add(new m(this));
            this.a(b2, d2);
        }
    }
    
    private D b(final y.f.h.p p) {
        final boolean p2 = o.p;
        final D d = new D();
        final e a = p.a();
        while (a.f()) {
            final d a2 = a.a();
            Label_0483: {
                if (this.a.d(a2) != 2) {
                    p p3 = null;
                    p p4 = null;
                    Label_0110: {
                        if (this.a.h(a2) == y.f.f.b.o.a || this.a.h(a2) == y.f.f.b.o.c) {
                            p3 = this.c;
                            p4 = this.b;
                            if (!p2) {
                                break Label_0110;
                            }
                        }
                        p3 = this.b;
                        p4 = this.c;
                    }
                    final y.f.f.c.g a3 = p4.a(a2);
                    final y.c.q c = a2.c();
                    final y.f.f.d.p p5 = new y.f.f.d.p(a3);
                    final y.f.f.d.p p6 = new y.f.f.d.p(p3.a(c));
                    int n = 2;
                    if (this.a.d(c)) {
                        n = 1;
                    }
                    if (this.a.k(c)) {
                        n = 0;
                    }
                    Label_0374: {
                        switch (this.a.d(a2)) {
                            case 1: {
                                d.add(new b(p6, p5, 0, this.a.h(a2), n));
                                if (p2) {
                                    break Label_0374;
                                }
                                break Label_0483;
                            }
                            case 3: {
                                final b b = new b(p6, p5, 1, this.a.h(a2), n);
                                if (this.a.g(c)) {
                                    if (this.a.r(this.a.a(a2))) {
                                        b.a(true);
                                    }
                                    if (this.a.r(this.a.a(this.a.b().j(a2)))) {
                                        b.b(true);
                                    }
                                }
                                d.add(b);
                                if (p2) {
                                    break Label_0374;
                                }
                                break Label_0483;
                            }
                            case 4: {
                                d.add(new b(p5, p6, 1, this.a.h(a2).b(), n));
                                d.add(new b(p6, p5, 1, this.a.h(a2), n));
                                if (p2) {
                                    break;
                                }
                                break Label_0483;
                            }
                        }
                    }
                    System.err.println("Impossible Angle :" + this.a.d(a2));
                }
            }
            a.g();
            if (p2) {
                break;
            }
        }
        return d;
    }
    
    D b(final D d) {
        final boolean p = o.p;
        int i = 0;
        b b = null;
        b b2 = null;
        while (true) {
        Label_0809_Outer:
            while (i != -4) {
                b2 = b;
                b = (b)d.a(0);
                d.g();
                d.add(b);
                final b b3 = b;
                if (p) {
                    final b b4 = b3;
                    y.f.f.d.p p2 = null;
                    y.f.f.d.p p3 = null;
                    y.f.f.b.o o = null;
                    y.f.f.d.p p4 = new y.f.f.d.p();
                    if (i != 0) {
                        p4.a(b2.d().b());
                    }
                    p4.a(b.e().b());
                    final D d2 = new D();
                    int b5 = -1;
                    b b6 = null;
                    y.f.f.d.p p5 = null;
                    while (true) {
                        while (b6 != b4) {
                            int n = 0;
                            final boolean b7 = true;
                            y.f.f.d.p e = null;
                            while (b7) {
                                b2 = b6;
                                b6 = (b)d.a(0);
                                d.g();
                                if (e == null) {
                                    e = b6.e();
                                }
                                if (b6.a() == 2) {
                                    n = -1;
                                    if (!p) {
                                        break;
                                    }
                                }
                                final int n2;
                                Label_0415: {
                                    if ((n2 = n) == 0 && b6.b() == 0) {
                                        n = 1;
                                        if (!p) {
                                            break Label_0415;
                                        }
                                    }
                                    if (n == 1 && b6.b() == 1) {
                                        p4.a(b6.e().b());
                                        n = 2;
                                        if (!p) {
                                            break Label_0415;
                                        }
                                    }
                                    if (n == 2 && b6.b() == 1) {
                                        n = 3;
                                        if (!p) {
                                            break Label_0415;
                                        }
                                    }
                                    if (n == 3 && b6.b() == 0) {
                                        p4.a(b6.e().b());
                                        n = 0;
                                    }
                                }
                                if (n2 == n) {
                                    break;
                                }
                            }
                            Label_0487: {
                                if (p2 == null) {
                                    p2 = p4;
                                    p5 = e;
                                    if (!p) {
                                        break Label_0487;
                                    }
                                }
                                d2.add(new b(p3, p4, b5, o, 2));
                                if (e != b6.e()) {
                                    this.a(o, p3, e);
                                }
                            }
                            p3 = p4;
                            p4 = new y.f.f.d.p();
                            if (n == -1) {
                                p4.a(b6.e().b());
                                o = b6.c();
                                b5 = b6.b();
                                if (!p) {
                                    continue Label_0809_Outer;
                                }
                            }
                            if (n == 0 || n == 1) {
                                throw new RuntimeException("Consistency error: State == " + n);
                            }
                            if (n == 2) {
                                p4.a(b2.d().b());
                                p4.a(b6.e().b());
                                o = b6.c();
                                b5 = 0;
                                if (!p) {
                                    continue Label_0809_Outer;
                                }
                            }
                            if (n != 3) {
                                continue Label_0809_Outer;
                            }
                            p4.a(b6.d().b());
                            final b b8 = (b)d.a(0);
                            d.g();
                            final int b9 = b8.b();
                            if (p) {
                                this.a(o, p3, p5);
                                return d2;
                            }
                            if (b9 == 0) {
                                p4.a(b8.e().b());
                                b5 = 1;
                                o = b8.c();
                                b6 = b8;
                                if (!p) {
                                    continue Label_0809_Outer;
                                }
                            }
                            b5 = 1;
                            o = b6.c();
                            d2.add(new b(p3, p4, 1, o.b(), 2));
                            p3 = p4;
                            p4 = new y.f.f.d.p();
                            p4.a(b6.e().b());
                            final b b10 = (b)d.a(0);
                            d.g();
                            p4.a(b10.e().b());
                            b6 = b10;
                            if (p) {
                                break;
                            }
                        }
                        d2.add(new b(p3, p2, b5, o, 2));
                        continue;
                    }
                }
                if (b3.a() == 2) {
                    i = 0;
                    if (!p) {
                        break;
                    }
                }
                if (b.b() == 0) {
                    if (i == 2 || i == 4) {
                        break;
                    }
                    if (i == 5) {
                        break;
                    }
                }
                if (b.b() == 1 && i == 4) {
                    i = 5;
                    if (!p) {
                        continue;
                    }
                }
                if (b.b() == 1 && i == 3) {
                    i = 4;
                    if (!p) {
                        continue;
                    }
                }
                if (b.b() == 1 && i == 2) {
                    i = 3;
                    if (!p) {
                        continue;
                    }
                }
                if (b.b() == 1 && i == 1) {
                    i = 2;
                    if (!p) {
                        continue;
                    }
                }
                if (b.b() == 0) {
                    i = 1;
                    if (!p) {
                        continue;
                    }
                }
                i = 0;
                if (p) {
                    break;
                }
            }
            continue;
        }
    }
    
    private void a(final y.f.f.b.o o, final y.f.f.d.p p3, final y.f.f.d.p p4) {
        if (o == null) {
            y.g.o.a((Object)"Error: Corner separate: direction == null");
            return;
        }
        final y.f.f.b.o b = o.b();
        if (b.a(y.f.f.b.o.a)) {
            y.f.f.d.p.a(this.b, p3, p4, 1);
        }
        if (b.a(y.f.f.b.o.c)) {
            y.f.f.d.p.a(this.b, p4, p3, 1);
        }
        if (b.a(y.f.f.b.o.d)) {
            y.f.f.d.p.a(this.c, p4, p3, 1);
        }
        if (b.a(y.f.f.b.o.b)) {
            y.f.f.d.p.a(this.c, p3, p4, 1);
        }
    }
    
    private void a(final D d, final D d2) {
        final boolean p2 = o.p;
        int i = 0;
        int n = d.size();
        while (true) {
            while (i < n) {
                boolean a = false;
                final D d3 = d2;
                if (p2) {
                    if (d3.size() == 4) {
                        final b[] array = { (b)d.a(0), (b)d.a(1), (b)d.a(2), (b)d.a(3) };
                        if (array[0].b() == 0 && array[1].b() == 0 && array[2].b() == 0 && array[3].b() == 0) {
                            int j = 0;
                            while (j < 4) {
                                if (array[j].c().a(y.f.f.b.o.a)) {
                                    break;
                                }
                                ++j;
                                if (p2) {
                                    break;
                                }
                            }
                            y.f.f.d.p.a(this.c, array[(j + 1) % 4].e(), array[j].d(), 1);
                            y.f.f.d.p.a(this.b, array[(j + 3) % 4].d(), array[j].e(), 1);
                        }
                    }
                    return;
                }
                final C m = d2.m();
                boolean b = false;
                Label_0089: {
                    while (m.f()) {
                        b = a;
                        if (p2 || b) {
                            break Label_0089;
                        }
                        a = ((k)m.d()).a(d);
                        m.g();
                        if (p2) {
                            goto Label_0087;
                        }
                    }
                    goto Label_0087;
                }
                if (b) {
                    i = 0;
                    n = d.size();
                    if (!p2) {
                        continue;
                    }
                }
                d.add(d.g());
                ++i;
                if (p2) {
                    break;
                }
            }
            final D d3 = d;
            continue;
        }
    }
    
    static p a(final g g) {
        return g.b;
    }
    
    static p b(final g g) {
        return g.c;
    }
}
