package y.f.k;

import y.d.*;
import y.c.*;
import y.f.*;

class O implements I
{
    private I a;
    private r b;
    private q c;
    private y d;
    private A e;
    private A f;
    private I g;
    
    public O(final I i, final q c, final y d, final A e, final A f, final r b) {
        final int g = y.f.k.d.g;
        this.a = i;
        this.c = c;
        this.e = e;
        this.d = d;
        this.f = f;
        Label_0064: {
            if (i instanceof O) {
                this.g = ((O)i).a();
                if (g == 0) {
                    break Label_0064;
                }
            }
            this.g = i;
        }
        if (b == null) {
            this.b = new r(0.0, 0.0, 0.0, 0.0);
            if (g == 0) {
                return;
            }
        }
        this.b = b;
    }
    
    public I a() {
        return this.g;
    }
    
    public void a(final q q, final b b) {
        this.a.a(q, b);
    }
    
    public y.f.k.A a(final c c, final c c2, final X x, final q q, final byte b) {
        final y.f.k.A a = this.a.a(c, c2, x, q, b);
        final y.d.y a2 = this.a(x, q, a);
        a.b(a2.c(), a2.d(), a2.a(), a2.b());
        this.f.a(this.c, q);
        x.b(this.c, a2.a, a2.b);
        x.c(this.c, a2.c - a.i(), a2.d - a.j());
        return a;
    }
    
    private y.d.y a(final X x, final q q, final y.f.k.A a) {
        final int g = y.f.k.d.g;
        y.d.y a2 = null;
        final x a3 = this.d.a();
        while (a3.f()) {
            final q e = a3.e();
            if (g != 0) {
                return a2;
            }
            if (e != this.c) {
                t t = null;
                Label_0130: {
                    if (e.e() == null) {
                        t = y.d.t.b(this.a((q)this.f.b(e), q, x, a), x.o(e));
                        if (g == 0) {
                            break Label_0130;
                        }
                    }
                    t = this.a(e, q, x, a);
                }
                a2 = this.a(a2, new y.d.y(t, x.r(e)));
            }
            a3.g();
            if (g != 0) {
                break;
            }
        }
        a2 = new y.d.y(a2.c() - this.b.b, a2.d() - this.b.a, a2.a() + this.b.b + this.b.d, a2.b() + this.b.a + this.b.c);
        return a2;
    }
    
    private t a(final q q, final q q2, final X x, final y.f.k.A a) {
        final int g = y.f.k.d.g;
        if (q == q2) {
            final t t = new t(a.i(), a.j());
            if (g == 0) {
                return t;
            }
        }
        double n = 0.0;
        double n2 = 0.0;
        q c = q.g().c();
        while (c != q2) {
            final q c2 = c.g().c();
            final y.f.k.A a2 = this.a(c);
            Label_0136: {
                if (c2 == q2) {
                    n += a2.i() - a2.a;
                    n2 += a2.j() - a2.b;
                    if (g == 0) {
                        break Label_0136;
                    }
                }
                n += a2.a;
                n2 += a2.b;
            }
            c = c2;
            if (g != 0) {
                break;
            }
        }
        final am a3 = x.a((Object)q);
        return new t(a3.getX() + n, a3.getY() + n2);
    }
    
    private y.f.k.A a(final q q) {
        return (y.f.k.A)this.e.b(q);
    }
    
    private y.d.y a(final y.d.y y, final y.d.y y2) {
        if (y == null) {
            return y2;
        }
        if (y2 == null) {
            return y;
        }
        final double min = Math.min(y.c(), y2.c());
        final double max = Math.max(y.c() + y.a(), y2.c() + y2.a());
        final double min2 = Math.min(y.d(), y2.d());
        return new y.d.y(min, min2, max - min, Math.max(y.d() + y.b(), y2.d() + y2.b()) - min2);
    }
    
    public K a(final y.f.k.x x, final X x2, final q q) {
        return this.a.a(x, x2, q);
    }
}
