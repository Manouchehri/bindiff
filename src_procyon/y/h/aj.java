package y.h;

import y.c.*;

final class aj implements am
{
    private final e a;
    private final ag b;
    
    aj(final ag b, final q q) {
        this.b = b;
        this.a = q.k();
    }
    
    public boolean a() {
        final boolean z = fj.z;
        boolean empty = false;
        while (this.a.f()) {
            empty = this.b.f.isEmpty();
            if (z) {
                return !empty;
            }
            if (!empty) {
                break;
            }
            final d a = this.a.a();
            final q n = this.b.a.n(a.c());
            if (n == ag.a(this.b) || this.b.b.get(n.d()) || a.e()) {
                this.b.a(a);
            }
            this.a.g();
            if (z) {
                break;
            }
        }
        this.a.f();
        return !empty;
    }
}
