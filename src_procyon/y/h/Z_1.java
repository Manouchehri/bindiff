package y.h;

import y.c.*;

final class Z implements am
{
    private final q a;
    private final e b;
    private final Y c;
    
    Z(final Y c, final q a, final q q) {
        this.c = c;
        this.a = a;
        (this.b = q.l()).j();
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
            if (!a.e() && (n == Y.a(this.c) || !this.c.b.get(n.d())) && n != this.a) {
                this.c.b(a);
            }
            this.b.h();
            if (z) {
                break;
            }
        }
        this.b.f();
        return !empty;
    }
}
