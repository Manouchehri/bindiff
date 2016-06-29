package y.f.f.d;

import y.g.*;
import y.f.*;
import y.c.*;
import y.d.*;

public class C
{
    private e a;
    private A b;
    
    public C() {
        this.a = null;
        this.b = null;
    }
    
    public void a(final X x, final int n) {
        final boolean p2 = o.p;
        this.a = new e(x, n);
        final c c = x.c(U.b);
        this.b = M.a();
        if (c != null) {
            final x o = x.o();
        Label_0043:
            while (o.f()) {
                final q e = o.e();
                y y = x.s(e);
                final S[] array = (S[])c.b(o.e());
                if (array != null && array.length > 0) {
                    int i = 0;
                    while (i < array.length) {
                        y = this.a(y, this.a(array[i].a().h(), x.l(e)));
                        ++i;
                        if (p2) {
                            continue Label_0043;
                        }
                        if (p2) {
                            break;
                        }
                    }
                }
                final y s = x.s(e);
                if (!s.equals(y)) {
                    this.b.a(e, this.a.a(e, s.d() - y.d(), y.d() + y.b() - s.d() - s.b(), s.c() - y.c(), y.c() + y.a() - s.c() - s.a()));
                }
                o.g();
                if (p2) {
                    break;
                }
            }
        }
    }
    
    public D a(final X x, final q q) {
        final boolean p2 = o.p;
        final D d = new D();
        final c c = x.c(U.b);
        final y s = x.s(q);
        final f f = (this.b != null) ? ((f)this.b.b(q)) : null;
        D d2 = null;
        if (c == null || f == null) {
            d.add(s);
            if (!p2) {
                return d2;
            }
        }
        final double n = f.a();
        final double n2 = f.b();
        final double n3 = f.c();
        final y y = new y(s.c() + n3, s.d() + n, s.a() - n3 - f.d(), s.b() - n - n2);
        d.add(y);
        final S[] array = (S[])c.b(q);
        if (array != null && array.length > 0) {
            int i = 0;
            while (i < array.length) {
                final y a = this.a(array[i].a().h(), this.a(y));
                d2 = d;
                if (p2) {
                    break;
                }
                d2.add(a);
                ++i;
                if (p2) {
                    break;
                }
            }
        }
        return d2;
    }
    
    private t a(final y y) {
        return new t(y.c() + y.a() * 0.5, y.d() + y.b() * 0.5);
    }
    
    private y a(final y y, final t t) {
        return new y(t.a + y.c, t.b + y.d, y.a(), y.b());
    }
    
    public void a() {
        if (this.a != null) {
            this.a.a();
        }
        this.a = null;
    }
    
    private y a(final y y, final y y2) {
        final double min = Math.min(y.c(), y2.c());
        final double max = Math.max(y.c() + y.a(), y2.c() + y2.a());
        final double min2 = Math.min(y.d(), y2.d());
        return new y(min, min2, max - min, Math.max(y.d() + y.b(), y2.d() + y2.b()) - min2);
    }
}
