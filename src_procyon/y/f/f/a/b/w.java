package y.f.f.a.b;

import y.f.f.a.a.*;
import y.f.h.*;
import y.a.*;
import y.c.*;
import y.f.f.*;

public class w implements o
{
    private i a;
    private p b;
    private D c;
    private a d;
    private f e;
    private f f;
    private int g;
    private boolean h;
    private boolean i;
    
    public w(final a a, final f e) {
        this.g = 0;
        this.h = true;
        this.i = false;
        this.a(a);
        this.e = e;
    }
    
    public void a() {
    }
    
    public void a(final a d) {
        this.d = d;
        this.a = this.d.d();
        this.b = this.d.b();
    }
    
    public void a(final D c) {
        this.c = c;
    }
    
    public a b() {
        return this.d;
    }
    
    public void a(final int g) {
        this.g = g;
    }
    
    public void a(final boolean h) {
        this.h = h;
    }
    
    public void b(final boolean i) {
        this.i = i;
    }
    
    private f d() {
        final boolean c = y.f.f.a.b.a.c;
        final f f = new f();
        final f[] d = y.a.h.d(this.a);
        int i = 0;
        f f3 = null;
        while (i < d.length) {
            final f f2 = f3 = d[i];
            if (c) {
                return f3;
            }
            if (f3.size() > 1) {
                f.a(f2);
            }
            ++i;
            if (c) {
                break;
            }
        }
        return f3;
    }
    
    public void c() {
        final boolean c = y.f.f.a.b.a.c;
        final d[] n = this.c.g().n();
        this.d.a(this.c);
        final f d = this.d();
        final l e = this.e();
        e.a(this.d);
        this.f = e.a();
        if (this.g == 1) {
            this.b(this.f);
        }
        m.a(this.d);
        r.a(this.d);
        this.d.g();
        final y y = new y(this.d);
        y.a(this.h);
        y.a(this.f);
        y.a();
        if (this.i) {
            new u(this.d).a(d);
        }
        this.d.h();
        z.a(this.d, this.e);
        int i = 0;
        while (i < n.length) {
            this.a(n[i], this.d.d(n[i]));
            ++i;
            if (c) {
                y.c.i.g = !y.c.i.g;
                break;
            }
        }
    }
    
    private f a(final f f) {
        final boolean c = y.f.f.a.b.a.c;
        if (f == null) {
            return null;
        }
        final f f2 = new f();
        final e a = f.a();
        while (a.f()) {
            final d a2 = a.a();
            if (!this.d.p(a2)) {
                f2.add(a2);
            }
            a.g();
            if (c) {
                break;
            }
        }
        return f2;
    }
    
    private void a(final d d, final f f) {
        final boolean c = y.f.f.a.b.a.c;
        final y.c.h h = (y.c.h)this.a.c(y.f.f.b.n);
        final y.f.f.a a = (y.f.f.a)h.b(d);
        final f a2 = this.a(f);
        if (a != null && a2 != null) {
            int n = 0;
            final e a3 = a2.a();
            while (a3.f()) {
                final y.f.f.a d2 = a.d();
                if (n > 0) {
                    d2.a(0.0);
                }
                if (n < a2.size() - 1) {
                    d2.b(0.0);
                }
                h.a(a3.a(), d2);
                a3.g();
                ++n;
                if (c) {
                    break;
                }
            }
        }
    }
    
    private l e() {
        switch (this.g) {
            case 0: {
                return new x();
            }
            case 1: {
                return new g();
            }
            default: {
                throw new RuntimeException("Bad subgraph algorithm!");
            }
        }
    }
    
    private void b(final f f) {
        final boolean c = y.f.f.a.b.a.c;
        this.d.g();
        if (E.b(this.a, this.b)) {
            this.d.h();
            return;
        }
        final d[] n = this.a.n();
        int i = 0;
        while (true) {
            while (i < n.length) {
                final d d = n[i];
                final w w = this;
                if (c) {
                    final e a = w.f.a();
                    while (true) {
                        while (a.f()) {
                            this.a.e(a.a());
                            a.g();
                            if (c) {
                                final l e = this.e();
                                e.a(this.d);
                                this.f = e.a();
                                return;
                            }
                            if (c) {
                                break;
                            }
                        }
                        this.f = null;
                        this.a(0);
                        continue;
                    }
                }
                if (this.d.a(d)) {
                    this.a.a(d);
                }
                ++i;
                if (c) {
                    break;
                }
            }
            final w w = this;
            continue;
        }
    }
}
