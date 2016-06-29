package y.f.k;

import y.d.*;
import y.f.*;
import y.c.*;

class W extends V
{
    private t c;
    private I d;
    private boolean e;
    
    W(final l l, final X x, final d d, final P p4) {
        super(p4);
        (this.d = x.b((Object)d)).clearPoints();
        this.c = y.f.k.d.a(l, x.p(d));
        final Y y = new Y();
        y.a(new t(this.c.a(), this.c.b()));
        this.a(y);
    }
    
    void c() {
        if (this.e) {
            throw new IllegalStateException("TargetPoints already have beend appended");
        }
        this.b.j();
        this.b.i().a(this.d);
        this.e = true;
    }
    
    public void d() {
        this.b.a(this.c.a(), this.c.b());
    }
    
    public void e() {
        this.d();
        this.c();
        this.b.h();
        this.b.j();
    }
}
