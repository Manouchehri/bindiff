package y.h;

import y.c.*;

final class ac implements am
{
    private final q a;
    private final x b;
    private final Y c;
    
    ac(final Y c, final q a) {
        this.c = c;
        this.a = a;
        (this.b = c.a.p(a)).j();
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
            final ae ae = new ae(this.c, e);
            this.c.c.add(ae);
            b = true;
            final Z z2 = new Z(this.c, this.a, e);
            final int size = this.c.c.size();
            this.c.c.add(z2);
            if (z2.a()) {
                this.c.c.remove(size);
                if (this.c.f.isEmpty() && ae.a()) {
                    this.c.c.remove(this.c.c.size() - 1);
                    b = false;
                }
            }
            this.b.h();
            if (z) {
                break;
            }
        }
        this.b.f();
        return !empty && !b;
    }
}
