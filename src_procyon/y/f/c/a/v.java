package y.f.c.a;

import y.a.*;
import y.c.*;

class v extends e
{
    private final p[] a;
    private final int[] f;
    private final D[] g;
    private final r h;
    
    v(final r h, final p[] a, final int[] f, final D[] g) {
        this.h = h;
        this.a = a;
        this.f = f;
        this.g = g;
    }
    
    protected void a(final q q, final int n) {
        final p p2 = this.a[q.d()];
        final int n2 = this.f[q.d()] - 1;
        if (n2 >= 0) {
            final D d = this.g[n2];
            d.h(p2);
            d.a(p2);
        }
    }
}
