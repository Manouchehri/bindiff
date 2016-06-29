package y.f.a;

import y.f.*;
import y.c.*;

class i extends a
{
    private final h a;
    private final ah b;
    private final y.f.a.h c;
    
    i(final y.f.a.h c, final h a, final ah b) {
        this.c = c;
        this.a = a;
        this.b = b;
    }
    
    public void c(final X x) {
        final int u = f.u;
        final y.c.f f = new y.c.f();
        boolean d = false;
        Label_0105: {
            if (y.f.a.h.a(this.c)) {
                final e p = x.p();
                while (p.f()) {
                    final d a = p.a();
                    d = this.a.d(a);
                    if (u != 0) {
                        break Label_0105;
                    }
                    if (d) {
                        f.add(a);
                        x.d(a);
                    }
                    p.g();
                    if (u != 0) {
                        break;
                    }
                }
            }
            this.b.c(x);
            y.f.a.h.a(this.c);
        }
        if (d) {
            final e a2 = f.a();
            while (a2.f()) {
                x.e(a2.a());
                a2.g();
                if (u != 0) {
                    break;
                }
            }
        }
    }
}
