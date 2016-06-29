package y.a;

import y.c.*;

class s extends e
{
    private final t[] a;
    
    s(final t[] a) {
        this.a = a;
    }
    
    protected void a(final d d, final q q) {
        final t t = this.a[d.a(q).d()];
        final t t2 = this.a[q.d()];
        if (t2.c + 1 > t.c) {
            t.d = t.c;
            t.b = t.a;
            t.c = t2.c + 1;
            t.a = d;
            if (!y.a.h.a) {
                return;
            }
        }
        if (t2.c + 1 > t.d) {
            t.d = t2.c + 1;
            t.b = d;
        }
    }
}
