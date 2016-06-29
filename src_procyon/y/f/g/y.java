package y.f.g;

import y.c.*;
import y.d.*;

class y
{
    public y.d.y a;
    public D b;
    public boolean c;
    private D d;
    private y.d.y e;
    private boolean f;
    
    y() {
        this.a = null;
        this.b = new D();
        this.c = false;
        this.d = new D();
        this.e = null;
        this.f = true;
    }
    
    public boolean a() {
        return this.f;
    }
    
    public void a(final boolean f) {
        this.f = f;
    }
    
    void a(final y.d.y y, final double n) {
        final boolean d = y.f.g.d.d;
        final double n2 = y.a() / 2.0;
        final double n3 = y.b() / 2.0;
        Label_0296: {
            if (this.a != null) {
                if (y.a() <= this.a.a() && y.b() <= this.a.b()) {
                    this.e = a(new y.d.y(this.a.c() + n2, this.a.d() + n3, this.a.a() - y.a(), this.a.b() - y.b()), n, false);
                    if (!d) {
                        break Label_0296;
                    }
                }
                if (y.a() <= this.a.a()) {
                    this.e = a(new y.d.y(this.a.c() + n2, this.a.d() + this.a.b(), this.a.a() - y.a(), 0.0), n, false);
                    if (!d) {
                        break Label_0296;
                    }
                }
                if (y.b() <= this.a.b()) {
                    this.e = a(new y.d.y(this.a.c() + this.a.a() / 2.0, this.a.d() + n3, 0.0, this.a.b() - y.b()), n, false);
                    if (!d) {
                        break Label_0296;
                    }
                }
                this.e = null;
            }
        }
        if (this.b != null) {
            final C m = this.b.m();
            while (m.f()) {
                final y.d.y y2 = (y.d.y)m.d();
                this.d.add(a(new y.d.y(y2.c() - n2, y2.d() - n3, y2.a() + y.a(), y2.b() + y.b()), n, true));
                m.g();
                if (d) {
                    break;
                }
            }
        }
    }
    
    static y.d.y a(final y.d.y y, final double n, final boolean b) {
        if (y == null) {
            return null;
        }
        if (b) {
            return new y.d.y((int)Math.floor(y.c / n), (int)Math.floor(y.d / n), (int)Math.ceil(y.a / n) + 1, (int)Math.ceil(y.b / n) + 1);
        }
        return new y.d.y((int)Math.ceil(y.c / n), (int)Math.ceil(y.d / n), Math.max(1, (int)Math.floor(y.a / n) - 1), Math.max(1, (int)Math.floor(y.b / n) - 1));
    }
    
    boolean b() {
        return this.a != null && this.e == null;
    }
    
    int c() {
        if (this.e != null) {
            return (int)Math.ceil(Math.sqrt(this.e.a() * this.e.a() + this.e.b() * this.e.b()));
        }
        return Integer.MAX_VALUE;
    }
    
    boolean a(final t t) {
        final boolean d = y.f.g.d.d;
        boolean a = false;
        if (this.d != null) {
            final C m = this.d.m();
            while (m.f()) {
                a = a((y.d.y)m.d(), t);
                if (d) {
                    return !a || this.e == null || a(this.e, t);
                }
                if (a) {
                    return false;
                }
                m.g();
                if (d) {
                    break;
                }
            }
        }
        this.a();
        return !a || this.e == null || a(this.e, t);
    }
    
    private static boolean a(final y.d.y y, final t t) {
        return t.a >= y.c && t.a - y.c <= y.a && t.b >= y.d && t.b - y.d <= y.b;
    }
}
