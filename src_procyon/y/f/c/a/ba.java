package y.f.c.a;

import y.f.c.*;
import y.f.*;
import y.c.*;

public class ba implements aT
{
    private R a;
    
    public ba(final R a) {
        if (a == null) {
            throw new NullPointerException();
        }
        this.a = a;
    }
    
    public void a(final X x, final aU au, final aV av) {
        final boolean x2 = N.x;
        final f f = new f();
        final A t = x.t();
        final int a = this.a.a(x, t, f);
        int i = 0;
        while (i < a) {
            au.a((byte)0, i);
            ++i;
            if (x2) {
                break;
            }
        }
        final x o = x.o();
        while (o.f()) {
            final q e = o.e();
            au.a(t.a(e)).a(e);
            o.g();
            if (x2) {
                break;
            }
        }
        p p3 = f.k();
        while (p3 != null) {
            x.c((d)p3.c());
            p3 = p3.a();
            if (x2) {
                return;
            }
            if (x2) {
                break;
            }
        }
        x.a(t);
    }
    
    public R a() {
        return this.a;
    }
}
