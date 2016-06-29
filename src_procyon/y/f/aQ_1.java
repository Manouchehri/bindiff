package y.f;

import y.c.*;

public class aQ extends a
{
    Object a;
    f b;
    y c;
    
    public aQ() {
        this.a = ah.g_;
        this.b = new f();
        this.c = new y();
    }
    
    public Object b() {
        return this.a;
    }
    
    public void c(final X x) {
        if (this.a() != null) {
            this.a((i)x);
            this.a(x);
            this.b(x);
        }
    }
    
    private void a(final i i) {
        final boolean j = X.j;
        final c c = i.c(this.b());
        if (c != null) {
            final e p = i.p();
            while (p.f()) {
                final d a = p.a();
                if (j) {
                    return;
                }
                if (!c.d(a.c()) || !c.d(a.d())) {
                    this.b.c(a);
                    i.d(a);
                }
                p.g();
                if (j) {
                    break;
                }
            }
            final x o = i.o();
            while (o.f()) {
                if (!c.d(o.e())) {
                    this.c.c(o.e());
                    i.c(o.e());
                }
                o.g();
                if (j) {
                    break;
                }
            }
        }
    }
    
    private void b(final i i) {
        final boolean j = X.j;
        while (!this.c.isEmpty()) {
            i.d(this.c.d());
            if (j) {
                return;
            }
            if (j) {
                break;
            }
        }
        while (!this.b.isEmpty()) {
            i.e(this.b.d());
            if (j) {
                break;
            }
        }
    }
}
