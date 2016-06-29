package y.f.a;

import y.a.*;
import y.f.*;
import java.awt.geom.*;
import y.d.*;
import y.c.*;

public class f extends c
{
    X n;
    private p v;
    double o;
    int p;
    boolean q;
    private double w;
    private double x;
    double r;
    private double[] y;
    double s;
    boolean t;
    private double z;
    private boolean A;
    private p B;
    private double C;
    public static int u;
    
    public void a(final double c) {
        this.C = c;
    }
    
    void b(final double z) {
        this.z = z;
    }
    
    public void g(final boolean t) {
        this.t = t;
        this.B = null;
    }
    
    public f() {
        this.t = false;
        this.z = 0.0;
        this.A = false;
        this.C = 0.0;
        this.o = 200.0;
        this.p = 30;
        this.q = true;
        this.x = 5.0;
    }
    
    public void a(final int p) {
        this.p = p;
    }
    
    public int a() {
        return this.p;
    }
    
    public void c(double o) {
        if (o < 0.0) {
            o = 0.0;
        }
        this.o = o;
    }
    
    public void h(final boolean q) {
        this.q = q;
    }
    
    public boolean n() {
        return this.q;
    }
    
    public p o() {
        if (this.A) {
            return this.v;
        }
        if (this.B == null) {
            if (this.t) {
                this.B = new g(this);
                if (f.u == 0) {
                    return this.B;
                }
            }
            this.B = new u();
        }
        return this.B;
    }
    
    public boolean b(final X x) {
        return true;
    }
    
    public void a(final X n) {
        ae.a(this.n = n);
        final p o = this.o();
        if (!this.A && this.t) {
            final Rectangle2D a = ae.a(n, n.o());
            ((g)o).a(new t(a.getCenterX(), a.getCenterY()));
        }
        final x a2 = o.a(n);
        if (this.n()) {
            this.a(a2);
            if (this.r < this.x) {
                this.r = this.x;
            }
            this.w = this.a(a2, this.r);
            if (f.u == 0) {
                return;
            }
        }
        this.w = this.o;
        this.b(a2, 0.0);
    }
    
    double a(final x x, final double n) {
        final int u = f.u;
        final int k = x.k();
        final double a = y.d.e.a(360.0 / k);
        this.a(x);
        final double n2 = this.s / k;
        double n3 = this.s / 6.283185307179586;
        if (n3 < n) {
            n3 = n;
        }
        x.i();
        double c = this.C;
        if (this.y.length > 0) {
            c -= a / n2 * this.y[0] / 2.0;
        }
        int i = 0;
        double n8 = 0.0;
        while (i < k) {
            final double n4 = a / n2 * this.y[i];
            final double n5 = c + n4 / 2.0;
            final double n6 = Math.cos(n5) * n3;
            final double n7 = Math.sin(n5) * n3;
            n8 = n5 + n4 / 2.0;
            if (u != 0) {
                return n8;
            }
            c = n8;
            this.n.a(x.e(), n6, n7);
            ++i;
            x.g();
            if (u != 0) {
                break;
            }
        }
        return n8;
    }
    
    void b(final x x, final double n) {
        final int u = f.u;
        final double a = y.d.e.a(360.0 / x.k());
        double c = this.C;
        x.i();
        while (x.f()) {
            final double n2 = Math.cos(c) * this.o;
            final double n3 = Math.sin(c) * this.o;
            if (this.n == null) {
                this.n = (X)x.e().e();
            }
            this.n.a(x.e(), n2, n3);
            c += a;
            x.g();
            if (u != 0) {
                break;
            }
        }
    }
    
    double a(final q q) {
        final double p = this.n.p(q);
        final double q2 = this.n.q(q);
        return (p > q2) ? p : q2;
    }
    
    void a(final x x) {
        final int u = f.u;
        this.s = 0.0;
        this.y = new double[x.k()];
        this.r = 0.0;
        x.i();
        int i = 0;
        while (i < this.y.length) {
            final double a = this.a(x.e());
            this.y[i] = a + this.p;
            this.r = Math.max(this.r, a);
            this.s += this.y[i];
            ++i;
            x.g();
            if (u != 0) {
                break;
            }
        }
    }
    
    static double a(final f f) {
        return f.z;
    }
}
