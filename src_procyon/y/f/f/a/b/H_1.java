package y.f.f.a.b;

import y.c.*;
import y.f.f.a.a.*;

class H implements h
{
    n a;
    f b;
    private final E c;
    
    private H(final E c) {
        this.c = c;
    }
    
    public void a(final e e) {
        final boolean c = y.f.f.a.b.a.c;
        this.a = (n)e;
        if (this.a.d()) {
            return;
        }
        this.a.b(E.a(this.c));
        Label_0104: {
            if (E.b(this.c) == 0) {
                this.b = y.a.h.b(E.a(this.c));
                if (!c) {
                    break Label_0104;
                }
            }
            if (E.b(this.c) == 1) {
                this.b = y.a.h.e(E.a(this.c));
                if (!c) {
                    break Label_0104;
                }
            }
            throw new RuntimeException("Bad connection mode!");
        }
        final y.c.e a = this.b.a();
        while (a.f()) {
            E.c(this.c).add(a.a());
            this.a.a(a.a());
            a.g();
            if (c) {
                return;
            }
            if (c) {
                break;
            }
        }
        this.a.a(E.a(this.c));
    }
    
    H(final E e, final F f) {
        this(e);
    }
}
