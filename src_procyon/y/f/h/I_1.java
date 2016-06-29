package y.f.h;

import y.c.*;

public class I
{
    private f a;
    private D b;
    
    public I(final D b) {
        this.a = new f();
        this.b = b;
    }
    
    public void a() {
        final boolean d = N.d;
        final i g = this.b.g();
        final e p = g.p();
        while (p.f()) {
            if (p.a().e()) {
                this.a.c(p.a());
                g.d(p.a());
            }
            p.g();
            if (d) {
                break;
            }
        }
    }
    
    public void b() {
        final boolean d = N.d;
        final i g = this.b.g();
        final e a = this.a.a();
        while (a.f()) {
            final d a2;
            final d d2 = a2 = a.a();
            Label_0202: {
                d d4;
                while (true) {
                    d d3 = null;
                    if (d3.c().a() == 0) {
                        g.e(d2);
                        this.b.g(d2);
                        this.b.l();
                        this.b.b(this.b.h().a());
                        if (!d) {
                            break Label_0202;
                        }
                    }
                    d4 = null;
                    final e l = d2.c().l();
                    while (l.f()) {
                        d3 = d4;
                        if (d) {
                            continue Label_0202;
                        }
                        if (d3 == null) {
                            d4 = l.a();
                        }
                        if (this.b.i(l.a()).a().k() == 1) {
                            d4 = l.a();
                        }
                        l.g();
                        if (d) {
                            break;
                        }
                    }
                    break;
                }
                g.e(d2);
                this.b.a(d4, d2);
                this.b.k();
            }
            a.g();
            if (d) {
                break;
            }
        }
    }
}
