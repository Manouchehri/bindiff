package y.h;

import y.c.*;

final class ax implements am
{
    private final e a;
    private final as b;
    
    ax(final as b, final q q) {
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
            if (this.b.b.get(a.c().d()) || a.e()) {
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
