package y.h;

import y.c.*;

final class ak implements am
{
    private final q a;
    private final e b;
    private final ag c;
    
    ak(final ag c, final q a, final q q) {
        this.c = c;
        this.a = a;
        this.b = q.l();
    }
    
    public boolean a() {
        final boolean z = fj.z;
        boolean empty = false;
        while (this.b.f()) {
            empty = this.c.f.isEmpty();
            if (z) {
                return !empty;
            }
            if (!empty) {
                break;
            }
            final d a = this.b.a();
            final q n = this.c.a.n(a.d());
            if (!a.e() && (n == ag.a(this.c) || this.c.b.get(n.d())) && n != this.a) {
                this.c.a(a);
            }
            this.b.g();
            if (z) {
                break;
            }
        }
        this.b.f();
        return !empty;
    }
}
