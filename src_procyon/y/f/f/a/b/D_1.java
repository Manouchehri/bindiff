package y.f.f.a.b;

import y.f.f.a.a.*;
import y.g.*;
import java.util.*;
import y.c.*;

public class D
{
    protected a a;
    protected i b;
    protected i c;
    protected p d;
    private h e;
    private h f;
    private Map g;
    private A h;
    
    public D(final a a) {
        this.a = a;
        this.b = this.a.d();
        this.d = this.a.b();
        this.c = new i();
        this.e = this.c.u();
        this.f = M.b();
        this.g = new HashMap();
        this.h = this.c.t();
    }
    
    public void a() {
        this.c.a(this.e);
        this.b.a(this.f);
        this.g.clear();
        this.c.a(this.h);
        this.c.j();
    }
    
    public d d(final d d) {
        return (d)this.e.b(d);
    }
    
    public d e(final d d) {
        return (d)this.f.b(d);
    }
    
    public q a(final y.f.h.p p) {
        return this.g.get(p);
    }
    
    public y.f.h.p a(final q q) {
        return (y.f.h.p)this.h.b(q);
    }
    
    protected void a(final d d, final d d2) {
        this.e.a(d2, d);
        this.f.a(d, d2);
    }
    
    protected void a(final y.f.h.p p2, final q q) {
        this.g.put(p2, q);
        this.h.a(q, p2);
    }
    
    public void b() {
        final boolean c = y.f.f.a.b.a.c;
        this.c.j();
        this.g.clear();
        this.a.f();
        y.f.h.q q = this.a.e();
        while (true) {
            while (q.f()) {
                this.a(q.a(), this.c.d());
                q.g();
                if (c) {
                Label_0206_Outer:
                    while (q.f()) {
                        final y.f.h.p a = q.a();
                        final q a2 = this.a(a);
                        final e a3 = a.a();
                        while (true) {
                            while (a3.f()) {
                                final d a4 = a3.a();
                                this.a(a4, this.c.a(a2, this.a(this.a.b(this.a.c(a4)))));
                                a3.g();
                                if (!c) {
                                    if (c) {
                                        break;
                                    }
                                    continue Label_0206_Outer;
                                }
                                else {
                                    if (c) {
                                        break Label_0206_Outer;
                                    }
                                    continue Label_0090;
                                }
                            }
                            q.g();
                            continue;
                        }
                    }
                    return;
                }
                if (c) {
                    break;
                }
            }
            q = this.a.e();
            continue;
        }
    }
}
