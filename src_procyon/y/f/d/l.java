package y.f.d;

import y.c.*;
import y.d.*;
import y.f.*;

class l implements g
{
    private final i a;
    
    l(final i a) {
        this.a = a;
    }
    
    public void a(final Object o, final Object o2) {
        final int f = y.f.d.a.f;
        final j j = (j)o;
        final j i = (j)o2;
        j k = null;
        j l = null;
        if (j.c() == 2) {
            k = j;
            l = i;
        }
        else if (i.c() == 2) {
            k = i;
            l = j;
        }
        if (k != null) {
            final Q d = k.d();
            if (l.c() == 0) {
                if (k.a() == null || k.a() == l.a()) {
                    return;
                }
                this.a.a(d, (q)l.a(), l.h());
                if (f == 0) {
                    return;
                }
            }
            if (l.c() == 2) {
                final Q d2 = l.d();
                this.a.a(d, d2, this.a.i.a(this.a.o.get(d), (q)this.a.o.get(d2)));
                if (f == 0) {
                    return;
                }
            }
            this.a.a(d, (d)l.a(), (m)l.b());
        }
    }
}
