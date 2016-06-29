package y.f.f.a;

import y.f.f.b.*;
import y.f.h.*;
import y.f.f.a.b.*;
import y.f.f.a.a.*;
import y.c.*;

public class f implements d
{
    private a b;
    private i c;
    private p d;
    private y.c.f e;
    private D f;
    private c g;
    private h h;
    private h i;
    private Q j;
    public static boolean a;
    
    public f(final a b, final y.c.f e) {
        this.b = b;
        this.e = e;
        this.c = b.d();
        this.g = this.c.c(y.f.b.f.e);
        if (this.g != null) {
            this.h = this.c.u();
            this.c.a("y.layout.orthogonal.cluster.NodeSplitter.INSETS_KEY", this.h);
        }
        this.i = this.c.u();
        this.c.a("y.layout.orthogonal.cluster.NodeSplitter.BORDER_INFO_KEY", this.i);
        this.d = b.b();
    }
    
    public void a(final D d) {
    }
    
    public void a(final int n) {
    }
    
    public void a() {
        final boolean a = y.f.f.a.f.a;
        z.a(this.b, this.e);
        this.b.g();
        m.a(new j(this, null), this.d);
        this.b.h();
        this.f = new D(this.b.d());
        final e p = this.b.d().p();
        while (true) {
            while (p.f()) {
                final y.c.d a2 = p.a();
                this.f.b(a2, this.b.c(a2));
                final f f = this;
                if (a) {
                    final x o = f.c.o();
                    while (true) {
                        while (o.f()) {
                            final q e = o.e();
                            final Object o2;
                            final a a3 = (a)(o2 = this.b);
                            if (a) {
                                this.f.b(this.f.i(this.b.a(((b)o2).b_()).a().a()));
                                if (y.c.i.g) {
                                    y.f.f.a.f.a = !a;
                                }
                                return;
                            }
                            if (a3.f(e) || this.b.d(e)) {
                                this.f.c(e);
                            }
                            o.g();
                            if (a) {
                                break;
                            }
                        }
                        this.f.l();
                        if (this.h != null) {
                            this.j = new y.f.f.a.i(this.h);
                            this.f.a(this.j);
                        }
                        this.f.a(new y.f.f.a.h(this.i));
                        Object o2 = this.d.a().a().d();
                        continue;
                    }
                }
                if (this.b.a(a2)) {
                    this.f.m(a2);
                }
                p.g();
                if (a) {
                    break;
                }
            }
            final f f = this;
            continue;
        }
    }
    
    public D b() {
        return this.f;
    }
    
    public void c() {
        if (this.h != null) {
            this.c.a(this.h);
        }
        if (this.j != null) {
            this.f.b(this.j);
        }
        this.c.a(this.i);
        this.f.b();
        k.a(this.b, this.e);
    }
    
    static a a(final f f) {
        return f.b;
    }
    
    static i b(final f f) {
        return f.c;
    }
    
    static c c(final f f) {
        return f.g;
    }
    
    static h d(final f f) {
        return f.h;
    }
    
    static h e(final f f) {
        return f.i;
    }
}
