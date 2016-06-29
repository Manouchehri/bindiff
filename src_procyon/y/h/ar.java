package y.h;

import y.c.*;

final class ar implements am
{
    private final e a;
    private final an b;
    
    ar(final an b, final q q) {
        this.b = b;
        (this.a = q.k()).j();
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
            if (!this.b.b.get(a.c().d()) || a.e()) {
                this.b.b(a);
            }
            this.a.h();
            if (z) {
                break;
            }
        }
        this.a.f();
        return !empty;
    }
}
