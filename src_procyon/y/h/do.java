package y.h;

import y.d.*;

final class do
{
    final n a;
    private final n b;
    private final n c;
    private final double d;
    private final double e;
    
    do(final n b, final n c) {
        this.b = b;
        this.d = b.j();
        this.c = c;
        double e = c.j() - this.d;
        if (e != 0.0) {
            final boolean b2 = e < 0.0;
            if (b2) {
                e = -e;
            }
            if (e > 6.283185307179586) {
                e -= 6.283185307179586 * Math.floor(e / 6.283185307179586);
            }
            final boolean b3 = e > 3.141592653589793;
            if (b3) {
                e = 6.283185307179586 - e;
            }
            if (b3 ^ b2) {
                e = -e;
            }
        }
        this.e = e;
        this.a = new n(b);
    }
    
    void a(final double n, final double n2) {
        final boolean z = fj.z;
        final boolean b = 0.0 < n2;
        if (b && n2 < 1.0) {
            this.a.a(n * this.b.b() + n2 * this.c.b(), n * this.b.c() + n2 * this.c.c());
            this.a.a(this.d + n2 * this.e);
            if (!z) {
                return;
            }
        }
        if (b) {
            this.a.a(this.c.b(), this.c.c());
            this.a.c(this.c.g(), this.c.i());
            if (!z) {
                return;
            }
        }
        this.a.a(this.b.b(), this.b.c());
        this.a.c(this.b.g(), this.b.i());
    }
}
