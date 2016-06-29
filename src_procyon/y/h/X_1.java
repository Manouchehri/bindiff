package y.h;

import y.c.*;

final class X extends hO
{
    private final e a;
    private final boolean b;
    
    X(final bu bu, final int n, final boolean b) {
        super(bu, n);
        this.a = bu.p();
        if (!(this.b = b)) {
            this.a.j();
        }
    }
    
    void a() {
        final boolean z = fj.z;
        while (this.f.isEmpty() && this.a.f()) {
            final d a = this.a.a();
            if (this.b) {
                this.a.g();
                this.a(a);
                if (!z) {
                    continue;
                }
            }
            this.a.h();
            this.b(a);
            if (z) {
                break;
            }
        }
    }
}
