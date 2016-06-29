package y.h;

import y.f.i.*;
import y.f.*;
import y.c.*;

class hX implements ah
{
    private final i a;
    
    hX(final i a) {
        this.a = a;
    }
    
    public void c(final X x) {
        final boolean z = fj.z;
        final c c = x.c(hV.d);
        x.a(hV.e, new hY(this, c));
        this.a.c(x);
        x.d_(hV.e);
        final e p = x.p();
        while (p.f()) {
            final d a = p.a();
            if (c.b(a) == hV.a) {
                ae.a(x, a);
            }
            p.g();
            if (z) {
                break;
            }
        }
    }
}
