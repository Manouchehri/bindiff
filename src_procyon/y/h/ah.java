package y.h;

import y.c.*;

final class ah implements am
{
    private final q a;
    private final x b;
    private final ag c;
    
    ah(final ag c, final q a) {
        this.c = c;
        this.a = a;
        this.b = c.a.p(a);
    }
    
    public boolean a() {
        final boolean z = fj.z;
        boolean b = false;
        boolean empty = false;
        while (this.b.f()) {
            empty = this.c.f.isEmpty();
            if (z) {
                return !empty && !b;
            }
            if (!empty) {
                break;
            }
            final q e = this.b.e();
            final ak ak = new ak(this.c, this.a, e);
            this.c.c.add(ak);
            b = true;
            final aj aj = new aj(this.c, e);
            final int size = this.c.c.size();
            this.c.c.add(aj);
            if (aj.a()) {
                this.c.c.remove(size);
                if (this.c.f.isEmpty() && ak.a()) {
                    this.c.c.remove(this.c.c.size() - 1);
                    b = false;
                }
            }
            this.b.g();
            if (z) {
                break;
            }
        }
        this.b.f();
        return !empty && !b;
    }
}
