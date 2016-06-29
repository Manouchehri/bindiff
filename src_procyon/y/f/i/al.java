package y.f.i;

import y.c.*;

class al extends ao
{
    private int q;
    protected D a;
    public D b;
    public D c;
    protected boolean d;
    protected double e;
    protected double f;
    protected double g;
    protected double h;
    public D i;
    public D j;
    
    public al(final double n, final double n2, final double n3, final double n4, final boolean b) {
        super(n, n2, n3, n4, b);
        this.b = new D();
        this.c = new D();
    }
    
    public void d(final boolean d) {
        this.d = d;
    }
    
    public void a(final double e) {
        this.e = e;
    }
    
    public void b(final double f) {
        this.f = f;
    }
    
    public void a(final D i) {
        this.i = i;
    }
    
    public void b(final D j) {
        this.j = j;
    }
    
    public void c(final double g) {
        this.g = g;
    }
    
    public void d(final double h) {
        this.h = h;
    }
    
    public void a(final int q) {
        this.q = q;
    }
    
    public boolean f() {
        return this.d;
    }
    
    public double g() {
        return this.e;
    }
    
    public double h() {
        return this.f;
    }
    
    public double i() {
        return this.g;
    }
    
    public double j() {
        return this.h;
    }
    
    public int k() {
        return this.q;
    }
    
    public D l() {
        return this.a;
    }
    
    public boolean m() {
        return this.a != null;
    }
    
    public void a(final boolean b, final D d) {
        if (b) {
            this.b.a(d);
            if (v.f == 0) {
                return;
            }
        }
        this.c.a(d);
    }
    
    public void a(final boolean b, final al al) {
        if (b) {
            this.b.add(al);
            if (v.f == 0) {
                return;
            }
        }
        this.c.add(al);
    }
    
    public void b(final boolean b, final al al) {
        final int f = v.f;
        final D d = b ? this.b : this.c;
        final C m = d.m();
        while (m.f()) {
            if (al == m.d()) {
                d.b(m);
                if (f == 0) {
                    break;
                }
            }
            m.g();
            if (f != 0) {
                break;
            }
        }
    }
    
    public void e(final boolean b) {
        (b ? this.b : this.c).clear();
    }
    
    public void c(final boolean b, final al al) {
        final int f = v.f;
        final D d = b ? this.b : this.c;
        Label_0144: {
            if (al == null) {
                final C m = d.m();
                while (m.f()) {
                    al al2 = (al)m.d();
                Label_0051:
                    while (true) {
                        final al al3 = al2;
                        final D d2 = b ? al3.c : al3.b;
                        final C i = d2.m();
                        while (i.f()) {
                            final al al4 = (al)i.d();
                            al2 = this;
                            if (f != 0) {
                                continue Label_0051;
                            }
                            if (this == al4) {
                                d2.b(i);
                            }
                            i.g();
                            if (f != 0) {
                                break;
                            }
                        }
                        break;
                    }
                    m.g();
                    if (f != 0) {
                        break Label_0144;
                    }
                }
                return;
            }
        }
        final C j = d.m();
        while (j.f()) {
            al al5 = (al)j.d();
        Label_0170:
            while (true) {
                final al al6 = al5;
                final D d3 = b ? al6.c : al6.b;
                p p2 = d3.k();
                while (p2 != null) {
                    al5 = this;
                    if (f != 0) {
                        continue Label_0170;
                    }
                    if (this == p2.c()) {
                        d3.a(p2, al);
                    }
                    p2 = d3.c(p2);
                    if (f != 0) {
                        break;
                    }
                }
                break;
            }
            j.g();
            if (f != 0) {
                break;
            }
        }
    }
    
    public void a(final d d, final double n, final byte b, final boolean b2) {
        final int f = v.f;
        if (n < this.t() || n > this.u()) {
            return;
        }
        if (this.a == null) {
            (this.a = new D()).add(new am(d, n, b, b2));
        }
        else {
            int n2 = 0;
            p p4 = this.a.k();
            int n3 = 0;
            Label_0174: {
                while (p4 != null) {
                    n3 = n2;
                    if (f != 0 || n3 != 0) {
                        break Label_0174;
                    }
                    if (((am)p4.c()).b <= n) {
                        p4 = this.a.c(p4);
                        if (f == 0) {
                            continue;
                        }
                    }
                    p4 = this.a.a(new am(d, n, b, b2), p4);
                    n2 = 1;
                    if (f != 0) {
                        goto Label_0172;
                    }
                }
                goto Label_0172;
            }
            if (n3 == 0) {
                this.a.add(new am(d, n, b, b2));
            }
        }
    }
    
    public void a(final am am) {
        final int f = v.f;
        if (am.b < this.t() || am.b > this.u()) {
            return;
        }
        if (this.a == null) {
            (this.a = new D()).add(am);
            if (f == 0) {
                return;
            }
        }
        int n = 0;
        p p = this.a.k();
        int n2 = 0;
        Label_0203: {
            while (p != null) {
                n2 = n;
                if (f != 0 || n2 != 0) {
                    break Label_0203;
                }
                final double b = ((am)p.c()).b;
                if (b < am.b) {
                    p = this.a.c(p);
                    if (f == 0) {
                        continue;
                    }
                }
                if (b > am.b) {
                    p = this.a.a(am, p);
                    n = 1;
                    if (f == 0) {
                        continue;
                    }
                }
                final am am2 = (am)p.c();
                if (am2.a == am.a && am2.d == am.d) {
                    n = 1;
                    if (f == 0) {
                        continue;
                    }
                }
                p = this.a.c(p);
                if (f != 0) {
                    goto Label_0202;
                }
            }
            goto Label_0202;
        }
        if (n2 == 0) {
            this.a.add(am);
        }
    }
    
    public void a(final d d, final double n, final boolean b) {
        final int f = v.f;
        if (this.a == null) {
            return;
        }
        int n2 = 0;
        final C m = this.a.m();
        while (m.f() && n2 == 0) {
            final am am = (am)m.d();
            if (d == am.a && n == am.b && b == am.d) {
                this.a.b(m);
                n2 = 1;
            }
            m.g();
            if (f != 0) {
                break;
            }
        }
    }
    
    public void b(final am am) {
        final int f = v.f;
        if (this.a == null) {
            return;
        }
        int n = 0;
        final C m = this.a.m();
        while (m.f() && n == 0) {
            if (am == m.d()) {
                this.a.b(m);
                n = 1;
            }
            m.g();
            if (f != 0) {
                break;
            }
        }
    }
}
