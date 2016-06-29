package y.h;

import y.c.*;

final class at implements am
{
    private final e a;
    private final q b;
    private final as c;
    
    at(final as c, final q b) {
        this.c = c;
        this.b = b;
        this.a = b.l();
    }
    
    public boolean a() {
        final boolean z = fj.z;
        while (true) {
            while (this.a.f()) {
                final boolean empty = this.c.f.isEmpty();
                if (z) {
                    if (!empty) {
                        this.c.b.set(this.b.d());
                    }
                    return !this.a.f();
                }
                if (!empty) {
                    break;
                }
                final d a = this.a.a();
                if (!a.e() && this.c.b.get(a.d().d())) {
                    this.c.a(a);
                }
                this.a.g();
                if (z) {
                    break;
                }
            }
            this.a.f();
            continue;
        }
    }
}
