package y.f.h;

import y.a.*;
import y.g.*;
import y.c.*;

class V extends e implements x
{
    private f a;
    private i f;
    
    V() {
        this.a = new f();
        this.f = null;
    }
    
    public void a(final D d) {
        final boolean d2 = N.d;
        this.a(this.f = d.g());
        o.a(0, "  Create reversed edges ...");
        final y.c.e p = this.f.p();
        p.j();
        while (p.f()) {
            d.g(p.a());
            p.h();
            if (d2) {
                return;
            }
            if (d2) {
                break;
            }
        }
        d.l();
        d.b(d.i(p.a()));
    }
    
    public f c_() {
        return this.a;
    }
    
    protected void a(final d d, final q q, final boolean b) {
        if (!b) {
            this.a.add(d);
            q.e().d(d);
        }
    }
}
