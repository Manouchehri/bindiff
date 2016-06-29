package y.f.k;

import y.c.*;
import y.d.*;
import y.f.*;

public class B extends d
{
    public static final Object h;
    private m i;
    private double j;
    private double k;
    private boolean l;
    private boolean m;
    private Object n;
    private double o;
    private int p;
    
    public B(final l l, final Object n) {
        super(l);
        this.i = y.f.k.m.g;
        this.j = 0.5;
        this.k = 0.3;
        this.m = false;
        this.o = 40.0;
        this.n = n;
    }
    
    public B() {
        this(y.f.k.l.a, "TheDefaultKey");
    }
    
    public boolean b() {
        return this.m;
    }
    
    protected byte d(final q q) {
        return 0;
    }
    
    protected P a(final q q, final byte b) {
        final int g = y.f.k.d.g;
        final P a = this.a(q);
        if (q.c() == 0) {
            this.a(q, b, a);
            return a;
        }
        final y.c.c c = this.b.c(B.h);
        if (c == null) {
            throw new IllegalStateException("distances not set!");
        }
        final F f = (F)c.b(q);
        final T t = new T(this.a().a(), this.b.h(q));
        final double n = t.d() + t.a() * this.j;
        final Y y = new Y(new t(0.0, n + f.a() + this.o * this.k));
        P p2 = null;
        boolean b2 = false;
        y.c.d d = q.f();
        while (true) {
            while (d != null) {
                final q d2 = d.d();
                final P b3 = this.b(d2);
                final F f2 = (F)c.b(d2);
                final double n2 = n + this.a(f, f2);
                final T t2 = new T(this.a().a(), this.b.h(d2));
                b3.a(n2 - (t2.d() + t2.a() * this.j));
                final P p3 = p2;
                if (g != 0) {
                    p3.j();
                    y.c.d d3 = q.f();
                    while (true) {
                        while (d3 != null) {
                            final q d4 = d3.d();
                            final B b4 = this;
                            if (g != 0) {
                                b4.a(q, b, a);
                                return a;
                            }
                            Label_0557: {
                                if (this.e() || this.d() || this.b()) {
                                    final W a2 = this.a(d3, this.b(d4));
                                    if (this.e() || this.b()) {
                                        a2.a(y);
                                        a2.d(1);
                                        if (this.e()) {
                                            a2.c(0);
                                        }
                                    }
                                    a2.e();
                                    if (g == 0) {
                                        break Label_0557;
                                    }
                                }
                                this.b.b((Object)d3).clearPoints();
                            }
                            d3 = d3.g();
                            if (g != 0) {
                                break;
                            }
                        }
                        a.a(this.f);
                        final B b4 = this;
                        continue;
                    }
                }
                if (p3 != null) {
                    c a3 = p2.a(1);
                    if (b2 || f.c() - f2.c() < -1) {
                        b2 = (f.c() - f2.c() < -1);
                        a3 = new c(a3.a(), a3.b(), a3.d());
                    }
                    b3.a(a3, this.a);
                }
                b3.h();
                b3.j();
                Label_0399: {
                    if (p2 == null) {
                        p2 = b3;
                        if (g == 0) {
                            break Label_0399;
                        }
                    }
                    p2.a(b3);
                }
                d = d.g();
                if (g != 0) {
                    break;
                }
            }
            this.i.a(a, this.f, this.a);
            continue;
        }
    }
    
    private double a(final F f, final F f2) {
        final int g = y.f.k.d.g;
        double n = f.a() + f2.b() + (f2.c() - f.c()) * this.o;
        final E d = f.d();
        int i = f.c() + 1;
        double n2 = 0.0;
        while (i < f2.c()) {
            final F b = d.b(i);
            n2 = n + (b.a() + b.b());
            if (g != 0) {
                return n2;
            }
            n = n2;
            ++i;
            if (g != 0) {
                break;
            }
        }
        return n2;
    }
    
    private boolean e() {
        return this.p == 1;
    }
    
    private void a(final q q, final byte b, final P p3) {
        final int g = y.f.k.d.g;
        if (this.p == 0) {
            return;
        }
        if (q.g() == null) {
            return;
        }
        final aE c = this.c(q);
        final X a = this.a(q, p3);
        Label_0382: {
            switch (b) {
                case 0: {
                    Label_0156: {
                        switch (c.b()) {
                            default: {
                                if (g != 0) {
                                    break Label_0156;
                                }
                                break Label_0382;
                            }
                            case 4: {
                                a.a(0, true);
                                if (g != 0) {
                                    break Label_0156;
                                }
                                break Label_0382;
                            }
                            case 2: {
                                a.d(0, true);
                                a.b(0, true);
                                if (g != 0) {
                                    break Label_0156;
                                }
                                break Label_0382;
                            }
                            case 8: {
                                a.b(0, true);
                                if (g != 0) {
                                    break Label_0382;
                                }
                                break Label_0382;
                            }
                        }
                    }
                    break;
                }
                case 1: {
                    while (true) {
                        Label_0249: {
                            switch (c.b()) {
                                case 1: {
                                    a.c(1, true);
                                    if (g != 0) {
                                        break;
                                    }
                                    break Label_0382;
                                }
                                case 2: {
                                    a.d(0, true);
                                    if (g != 0) {
                                        break Label_0249;
                                    }
                                    break Label_0382;
                                }
                                case 8: {
                                    a.b(0, true);
                                    a.c(1, true);
                                    if (g != 0) {
                                        break Label_0382;
                                    }
                                    break Label_0382;
                                }
                            }
                        }
                        if (g != 0) {
                            continue;
                        }
                        break;
                    }
                    break;
                }
                case 2: {
                    Label_0351: {
                        switch (c.b()) {
                            case 1: {
                                a.c(0, true);
                                a.b(1, true);
                                if (g != 0) {
                                    break Label_0351;
                                }
                                break Label_0382;
                            }
                            case 4: {
                                a.a(1, true);
                                if (g != 0) {
                                    break Label_0351;
                                }
                                break Label_0382;
                            }
                            case 2: {
                                a.d(0, true);
                                a.b(1, true);
                                if (g != 0) {
                                    break;
                                }
                                break Label_0382;
                            }
                        }
                    }
                    a.b(1, true);
                    if (g != 0) {
                        break Label_0382;
                    }
                    break;
                }
                case 3: {
                    Label_0463: {
                        switch (c.b()) {
                            case 1: {
                                a.c(0, true);
                                if (g != 0) {
                                    break Label_0463;
                                }
                                break;
                            }
                            case 4: {
                                a.a(0, true);
                                a.c(1, true);
                                if (g != 0) {
                                    break Label_0463;
                                }
                                break;
                            }
                            case 2: {
                                a.d(0, true);
                                if (g != 0) {
                                    break;
                                }
                                break;
                            }
                        }
                    }
                    break;
                }
            }
        }
        p3.h();
    }
    
    public K a(final x x, final y.f.X x2, final q q) {
        final y.c.c c = x2.c(B.h);
        if (c != null && c.b(q) != null) {
            return null;
        }
        if (this.m) {
            final K k = new D(this, x, x2, q);
            ((D)k).a(this.a);
            if (y.f.k.d.g == 0) {
                return k;
            }
        }
        final K k = new G(this, x, x2, q);
        ((G)k).a(this.a);
        return k;
    }
    
    public Object c() {
        return this.n;
    }
    
    public boolean d() {
        return this.l;
    }
    
    static double a(final B b) {
        return b.o;
    }
    
    static double b(final B b) {
        return b.j;
    }
    
    static {
        h = "LayeredNodePlacer.DP_KEY_DISTANCE_TO_PARENT_MAP";
    }
}
