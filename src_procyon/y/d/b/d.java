package y.d.b;

import java.util.*;

public class d extends c
{
    private static d i;
    public static int b;
    public static int c;
    public static int d;
    public static int e;
    protected boolean f;
    protected boolean g;
    protected static final double h;
    private Comparator j;
    private Comparator k;
    private Comparator l;
    private Comparator m;
    private Comparator n;
    private Comparator o;
    private Comparator p;
    
    public d() {
        this.f = true;
        this.g = true;
        this.j = new h(this);
        this.k = new g(this);
        this.l = new e(this);
        this.m = new j(this);
        this.n = new f(this);
        this.o = new k(this);
        this.p = new i(this);
    }
    
    public static d a() {
        return y.d.b.d.i;
    }
    
    public Object c(final Object o, final Object o2) {
        return new m((b)o, (b)o2, this);
    }
    
    public boolean d(final Object o, final Object o2) {
        return ((a)o).b(o2) > 0;
    }
    
    public boolean b(final Object o, final Object o2) {
        return ((m)o).b((b)o2);
    }
    
    public boolean e(final Object o, final Object o2) {
        return ((m)o).a((b)o2);
    }
    
    public Object f(final Object o, final Object o2) {
        return ((m)o).b((m)o2);
    }
    
    public Object g(final Object o, final Object o2) {
        return ((m)o).a((m)o2);
    }
    
    public Object c(final Object o) {
        return ((m)o).a();
    }
    
    public Object d(final Object o) {
        return ((m)o).b();
    }
    
    public z e(final Object o) {
        return ((b)o).a();
    }
    
    public z f(final Object o) {
        return ((b)o).b();
    }
    
    public z g(final Object o) {
        return ((b)o).c();
    }
    
    public double h(final Object o) {
        return ((b)o).d();
    }
    
    public double i(final Object o) {
        return ((b)o).e();
    }
    
    public double j(final Object o) {
        return ((b)o).f();
    }
    
    public z k(final Object o) {
        return new y(this.h(o) / this.j(o));
    }
    
    public z l(final Object o) {
        return new y(this.i(o) / this.j(o));
    }
    
    public Comparator b() {
        return this.p;
    }
    
    public double h(final Object o, final Object o2) {
        return ((t)o).a((t)o2);
    }
    
    public Object i(final Object o, final Object o2) {
        return ((b)o2).a((b)o);
    }
    
    public Comparator c() {
        if (this.f) {
            return this.j;
        }
        return this.k;
    }
    
    public Comparator d() {
        if (this.f) {
            return this.l;
        }
        return this.m;
    }
    
    public Comparator e() {
        if (this.f) {
            return this.n;
        }
        return this.o;
    }
    
    public int c(final Object o, final Object o2, final Object o3) {
        if (this.g) {
            ++y.d.b.d.e;
            final double h = this.h(o);
            final double i = this.i(o);
            final double j = this.j(o);
            final double h2 = this.h(o2);
            final double k = this.i(o2);
            final double l = this.j(o2);
            final double h3 = this.h(o3);
            final double m = this.i(o3);
            final double j2 = this.j(o3);
            final double n = i * l;
            final double n2 = k * j;
            final double n3 = h * j2;
            final double n4 = h3 * j;
            final double n5 = h * l;
            final double n6 = h2 * j;
            final double n7 = i * j2;
            final double n8 = m * j;
            final double n9 = (n5 - n6) * (n7 - n8) - (n - n2) * (n3 - n4);
            final double n10 = 40.0 * ((Math.abs(n) + Math.abs(n2)) * (Math.abs(n3) + Math.abs(n4)) + (Math.abs(n5) + Math.abs(n6)) * (Math.abs(n7) + Math.abs(n8))) * y.d.b.d.h;
            if (n9 > n10) {
                return 1;
            }
            if (n9 < -n10) {
                return -1;
            }
            if (n10 < 1.0) {
                return 0;
            }
            --y.d.b.d.e;
        }
        return this.d(o, o2, o3);
    }
    
    protected int j(final Object o, final Object o2) {
        final m m = (m)o;
        final m i = (m)o2;
        final z c = m.c();
        final z c2 = i.c();
        final z d = m.d();
        final z d2 = i.d();
        final z a = c.a();
        final boolean equals = m.equals(a);
        final boolean equals2 = i.equals(a);
        if (!equals2 && !equals) {
            final int c3 = d.c(c2).b(d2.c(c)).c();
            return (c.c() * c2.c() < 0) ? (-c3) : c3;
        }
        if (equals2 && equals) {
            return 0;
        }
        if (equals2) {
            return -1;
        }
        return 1;
    }
    
    protected int d(final Object o, final Object o2, final Object o3) {
        ++y.d.b.d.d;
        final z e = this.e(o);
        final z f = this.f(o);
        final z g = this.g(o);
        final z e2 = this.e(o2);
        final z f2 = this.f(o2);
        final z g2 = this.g(o2);
        final z e3 = this.e(o3);
        final z f3 = this.f(o3);
        final z g3 = this.g(o3);
        return b(a(b(a(f2, g), a(f, g2)), b(a(e, g3), a(e3, g))), a(b(a(e2, g), a(e, g2)), b(a(f, g3), a(f3, g)))).c();
    }
    
    protected int k(final Object o, final Object o2) {
        ++y.d.b.d.b;
        final z a = a(this.e(o), this.g(o2));
        final z a2 = a(this.e(o2), this.g(o));
        if (a.f(a2) < 0) {
            return -1;
        }
        if (a.f(a2) > 0) {
            return 1;
        }
        return 0;
    }
    
    protected int l(final Object o, final Object o2) {
        ++y.d.b.d.b;
        final z a = a(this.f(o), this.g(o2));
        final z a2 = a(this.f(o2), this.g(o));
        if (a.f(a2) < 0) {
            return -1;
        }
        if (a.f(a2) > 0) {
            return 1;
        }
        return 0;
    }
    
    protected int m(final Object o, final Object o2) {
        ++y.d.b.d.b;
        final z a = a(this.e(o), this.g(o2));
        final z a2 = a(this.e(o2), this.g(o));
        if (a.f(a2) < 0) {
            return -1;
        }
        if (a.f(a2) > 0) {
            return 1;
        }
        final z a3 = a(this.f(o), this.g(o2));
        final z a4 = a(this.f(o2), this.g(o));
        if (a3.f(a4) < 0) {
            return -1;
        }
        if (a3.f(a4) > 0) {
            return 1;
        }
        return 0;
    }
    
    private static z a(final z z, final z z2) {
        return z.c(z2);
    }
    
    private static z b(final z z, final z z2) {
        return z.b(z2);
    }
    
    static {
        y.d.b.d.i = new d();
        y.d.b.d.b = 0;
        y.d.b.d.c = 0;
        y.d.b.d.d = 0;
        y.d.b.d.e = 0;
        h = Math.pow(0.5, 52.0);
    }
}
