package y.f.k;

import y.c.*;
import java.awt.geom.*;
import y.d.*;
import y.f.*;
import java.util.*;

public final class A
{
    private c[] c;
    double a;
    double b;
    private double d;
    private double e;
    private List f;
    private double g;
    private double h;
    private byte i;
    private q j;
    private am k;
    
    A(final q j, final am k) {
        final int g = y.f.k.d.g;
        this.c = new c[4];
        this.j = j;
        this.k = k;
        this.d = k.getX();
        this.e = k.getY();
        double width = k.getWidth();
        if (width <= 0.0) {
            width = 1.0;
            this.d -= 0.5;
        }
        double height = k.getHeight();
        if (height <= 0.0) {
            height = 1.0;
            this.e -= 0.5;
        }
        (this.c[0] = new c(0.0, width, 0.0)).b(this.d);
        this.c[0].a(this.e);
        (this.c[2] = new c(0.0, width, 0.0)).b(this.d);
        this.c[2].a(this.e + height);
        (this.c[1] = new c(0.0, height, 0.0)).b(this.e);
        this.c[1].a(this.d + width);
        (this.c[3] = new c(0.0, height, 0.0)).b(this.e);
        this.c[3].a(this.d);
        Label_0366: {
            if (j.b() > 0) {
                final t o = ((X)j.e()).o(j.g());
                this.g = o.a + width * 0.5;
                this.h = o.b + height * 0.5;
                if (g == 0) {
                    break Label_0366;
                }
                y.c.i.g = !y.c.i.g;
            }
            this.g = 0.0;
            this.h = 0.0;
        }
        this.i = 1;
    }
    
    public Rectangle2D a() {
        final double e = this.e();
        final double f = this.f();
        return new Rectangle2D.Double(e, f, this.g() - e, this.h() - f);
    }
    
    public double b() {
        if (this.f == null) {
            return this.g + this.d;
        }
        return this.f.get(this.f.size() - 1).a + this.d;
    }
    
    public double c() {
        if (this.f == null) {
            return this.h + this.e;
        }
        return this.f.get(this.f.size() - 1).b + this.e;
    }
    
    public void d() {
        final int g = y.f.k.d.g;
        if (this.f != null) {
            double n = this.g + this.d;
            double n2 = this.h + this.e;
            int i = 0;
            while (i < this.f.size()) {
                final t t = this.f.get(i);
                this.a(n, n2, t.a + this.d, t.b + this.e);
                n = t.a + this.d;
                n2 = t.b + this.e;
                ++i;
                if (g != 0) {
                    break;
                }
            }
        }
    }
    
    public void a(final double n, final double n2) {
        if (this.f == null) {
            this.f = new ArrayList(8);
        }
        this.f.add(new t(n - this.d, n2 - this.e));
    }
    
    public void a(final X x, final y.c.d d) {
        final int g = d.g;
        final I b = x.b((Object)d);
        final t p2 = x.p(d);
        double n = p2.a;
        double n2 = p2.b;
        int i = 0;
        while (true) {
            while (i < b.pointCount()) {
                final t point = b.getPoint(i);
                this.a(n, n2, point.a, point.b);
                n = point.a;
                final t t = point;
                if (g != 0) {
                    final t t2 = t;
                    this.a(n, n2, t2.a, t2.b);
                    return;
                }
                n2 = t.b;
                ++i;
                if (g != 0) {
                    break;
                }
            }
            x.q(d);
            continue;
        }
    }
    
    public void a(final I i) {
        final int g = y.f.k.d.g;
        if (this.f != null) {
            int j = this.f.size() - 1;
            while (j >= 0) {
                final t t = this.f.get(j);
                i.addPoint(t.a + this.d, t.b + this.e);
                --j;
                if (g != 0) {
                    break;
                }
            }
        }
    }
    
    public void a(final double n, final double n2, final double n3, final double n4) {
        int g = y.f.k.d.g;
        final double n5 = (n < n3) ? n : n3;
        final double n6 = (n < n3) ? n3 : n;
        final double n7 = (n < n3) ? n2 : n4;
        final double n8 = (n < n3) ? n4 : n2;
        final double n9 = (n2 < n4) ? n2 : n4;
        final double n10 = (n2 < n4) ? n4 : n2;
        final double n11 = (n2 < n4) ? n : n3;
        final double n12 = (n2 < n4) ? n3 : n;
        Label_0516: {
            if (Math.abs(n - n3) > 1.0) {
                if (Math.abs(n2 - n4) > 1.0) {
                    this.c[0].b(new c(n5, n6, n7, n8));
                    this.c[1].a(new c(n9, n10, n11, n12));
                    this.c[2].a(new c(n5, n6, n7, n8));
                    this.c[3].b(new c(n9, n10, n11, n12));
                    if (g == 0) {
                        break Label_0516;
                    }
                }
                this.c[0].a(n5, n6, n9);
                this.c[1].b(n9 - 0.5, n10 + 0.5, n6);
                this.c[2].b(n5, n6, n10);
                this.c[3].a(n9 - 0.5, n10 + 0.5, n5);
                if (g == 0) {
                    break Label_0516;
                }
            }
            if (Math.abs(n2 - n4) > 1.0) {
                this.c[0].a(n5 - 0.5, n6 + 0.5, n9);
                this.c[1].b(n9, n10, n6);
                this.c[2].b(n5 - 0.5, n6 + 0.5, n10);
                this.c[3].a(n9, n10, n5);
                if (g == 0) {
                    break Label_0516;
                }
            }
            this.c[0].a(n5 - 0.5, n6 + 0.5, n9);
            this.c[1].b(n9 - 0.5, n10 + 0.5, n6);
            this.c[2].b(n5 - 0.5, n6 + 0.5, n10);
            this.c[3].a(n9 - 0.5, n10 + 0.5, n5);
        }
        if (y.c.i.g) {
            y.f.k.d.g = ++g;
        }
    }
    
    public void b(final double n, final double n2, final double n3, final double n4) {
        final c a = this.a(0);
        final c a2 = this.a(1);
        final c a3 = this.a(2);
        final c a4 = this.a(3);
        if (n3 > 0.0) {
            a.a(n, n + n3, n2);
            a3.b(n, n + n3, n2 + n4);
        }
        if (n4 > 0.0) {
            a2.b(n2, n2 + n4, n + n3);
            a4.a(n2, n2 + n4, n);
        }
    }
    
    void a(final n n) {
        final int g = y.f.k.d.g;
        if (b(n)) {
            final y h = n.h();
            this.b(h.c(), h.d(), h.a(), h.b());
            if (g == 0) {
                return;
            }
        }
        final t[] a = n.a(n);
        int i = 0;
        while (i < a.length) {
            final t t = a[i];
            final t t2 = a[(i + 1) % a.length];
            this.a(t.a, t.b, t2.a, t2.b);
            ++i;
            if (g != 0) {
                break;
            }
        }
    }
    
    private static boolean b(final n n) {
        return Math.abs(n.g()) < 1.0E-4 || Math.abs(n.i()) < 1.0E-4;
    }
    
    public void a(final A a) {
        this.c[0].b(a.c[0]);
        this.c[1].a(a.c[1]);
        this.c[2].a(a.c[2]);
        this.c[3].b(a.c[3]);
    }
    
    public double e() {
        return Math.min(this.c[0].a(), Math.min(this.c[2].a(), this.c[3].c()));
    }
    
    public double f() {
        return Math.min(this.c[0].c(), Math.min(this.c[1].a(), this.c[3].a()));
    }
    
    public double g() {
        return Math.max(this.c[0].b(), Math.max(this.c[2].b(), this.c[1].d()));
    }
    
    public double h() {
        return Math.max(this.c[1].b(), Math.max(this.c[2].d(), this.c[3].b()));
    }
    
    public c a(final int n) {
        if (n < 0 || n > 3) {
            throw new IllegalArgumentException("Unknown border line index" + n);
        }
        return this.c[n];
    }
    
    public void b(final double n, final double n2) {
        this.c[0].b(n);
        this.c[0].a(n2);
        this.c[1].b(n2);
        this.c[1].a(n);
        this.c[2].b(n);
        this.c[2].a(n2);
        this.c[3].b(n2);
        this.c[3].a(n);
        this.d += n;
        this.e += n2;
        this.k.setLocation(this.k.getX() + n, this.k.getY() + n2);
    }
    
    public double i() {
        return this.d;
    }
    
    public double j() {
        return this.e;
    }
    
    public A a(final l l) {
        final A a = new A(this.j, new x());
        a.i = this.i;
        this.a(a, l);
        return a;
    }
    
    public void a(final A a, final l l) {
        final int g = y.f.k.d.g;
        final y.f.k.n a2 = y.f.k.n.a(this.k.getWidth(), this.k.getHeight()).a(l);
        a.k.setSize(a2.a(0), a2.a(1));
        final y.f.k.n a3 = y.f.k.n.a(this.d, this.e).a(l);
        a.d = a3.a(0);
        a.e = a3.a(1);
        a.k.setLocation(a3.a(0), a3.a(1));
        final y.f.k.n a4 = y.f.k.n.a(this.g, this.h).a(l);
        a.g = a4.a(0);
        a.h = a4.a(1);
        final c[] c = new c[4];
        int i = 0;
        while (true) {
            while (i < this.c.length) {
                final c c2 = this.c[i];
                final l a5 = l.a();
                if (g != 0) {
                    if (this.f != null) {
                        final ArrayList<t> f = new ArrayList<t>();
                        final Iterator<t> iterator = (Iterator<t>)this.f.iterator();
                        while (iterator.hasNext()) {
                            final y.f.k.n a6 = y.f.k.n.a(iterator.next()).a(l);
                            f.add(new t(a6.a(0), a6.a(1)));
                            if (g != 0) {
                                return;
                            }
                            if (g != 0) {
                                break;
                            }
                        }
                        a.f = f;
                    }
                    return;
                }
                c c3 = null;
                Label_0319: {
                    if (i == 0 || i == 2) {
                        c3 = c2.a(a5.a(1).a() < 0.0, a5.a(0).a() < 0.0);
                        if (g == 0) {
                            break Label_0319;
                        }
                    }
                    c3 = c2.a(a5.a(0).a() < 0.0, a5.a(1).a() < 0.0);
                }
                c[y.f.k.n.b(i).a(l).b()] = c3;
                ++i;
                if (g != 0) {
                    break;
                }
            }
            a.c = c;
            continue;
        }
    }
    
    q k() {
        return this.j;
    }
    
    public String toString() {
        return "SubtreeShape{x=" + this.d + ", y=" + this.e + ", dx=" + this.a + ", dy=" + this.b + ", borderLines=" + ((this.c == null) ? null : Arrays.asList(this.c)) + "}";
    }
}
