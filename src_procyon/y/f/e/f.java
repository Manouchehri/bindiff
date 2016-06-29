package y.f.e;

import y.f.*;
import y.f.b.*;
import y.c.*;

final class f extends a
{
    private final d a;
    
    private f(final d a) {
        this.a = a;
    }
    
    public void c(final X x) {
        final boolean b = i.b;
        if (this.a() != null) {
            if (c.b(x)) {
                Label_0206: {
                    switch (this.a.o()) {
                        default: {
                            this.a().c(x);
                            if (b) {
                                break Label_0206;
                            }
                            return;
                        }
                        case 1: {
                            y.c.A t = null;
                            Label_0183: {
                                if (x.c(d.o) == null) {
                                    t = x.t();
                                    x.a(d.o, t);
                                    final c c = new c(x);
                                    p p = c.b(c.b()).k();
                                    while (p != null) {
                                        final q q = (q)p.c();
                                        t.a(q, c.d(q));
                                        p = p.a();
                                        if (b) {
                                            break Label_0183;
                                        }
                                        if (b) {
                                            break;
                                        }
                                    }
                                    c.c();
                                }
                                this.a().c(x);
                            }
                            if (t == null) {
                                return;
                            }
                            x.d_(d.o);
                            x.a(t);
                            if (b) {
                                break Label_0206;
                            }
                            return;
                        }
                        case 2: {
                            final b b2 = new b(this.a());
                            b2.a(new A(this.a.a()));
                            b2.c(x);
                            if (b) {
                                break;
                            }
                            return;
                        }
                    }
                }
            }
            this.a().c(x);
        }
    }
    
    f(final d d, final e e) {
        this(d);
    }
}
