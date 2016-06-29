package y.f.a;

import y.a.*;
import y.d.*;
import y.f.*;
import y.g.*;
import y.c.*;

class g implements p
{
    private t a;
    private final f b;
    
    g(final f b) {
        this.b = b;
        this.a = new t();
    }
    
    public t a() {
        return this.a;
    }
    
    public void a(final t a) {
        this.a = a;
    }
    
    public x a(final i i) {
        final int u = f.u;
        if (!(i instanceof X)) {
            throw new IllegalArgumentException("This sequencer only works for LayoutGraphs");
        }
        final X x = (X)i;
        final y y = new y(x.o());
        final A t = x.t();
        final double a = this.a.a();
        final double b = this.a.b();
        final x o = x.o();
        while (o.f()) {
            final q e = o.e();
            t.a(e, y.f.a.a.a(Math.atan2(x.k(e) - b, x.j(e) - a) - f.a(this.b)));
            o.g();
            if (u != 0) {
                return y.a();
            }
            if (u != 0) {
                break;
            }
        }
        y.sort(e.c(t));
        x.a(t);
        return y.a();
    }
}
