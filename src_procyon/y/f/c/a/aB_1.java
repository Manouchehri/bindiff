package y.f.c.a;

import y.f.*;
import y.g.*;
import y.c.*;
import java.util.*;

final class aB
{
    private final c a;
    private final A b;
    private final c c;
    private final y d;
    private final A e;
    
    private aB(final X x, final c a, final c c) {
        this.a = a;
        this.b = M.a();
        this.c = c;
        this.d = new y();
        this.e = x.t();
    }
    
    bK a(final q q) {
        return (bK)this.a.b(q);
    }
    
    void a(final q q, final bK bk) {
        this.b.a(q, bk);
    }
    
    x a() {
        return this.d.a();
    }
    
    x b(final q q) {
        return ((y)this.e.b(q)).a();
    }
    
    boolean c(final q q) {
        return this.c.d(q);
    }
    
    void a(final X x, final c c, final c c2) {
        final boolean x2 = N.x;
        final HashMap<Object, q> hashMap = new HashMap<Object, q>();
        x x3 = x.o();
        while (true) {
            while (x3.f()) {
                hashMap.put(c.b(x3.e()), x3.e());
                x3.g();
                if (x2) {
                    while (x3.f()) {
                        final q q = hashMap.get(c2.b(x3.e()));
                        Label_0215: {
                            if (q != null) {
                                y y = (y)this.e.b(q);
                                if (y == null) {
                                    y = new y();
                                    this.e.a(q, y);
                                }
                                y.add(x3.e());
                                if (!x2) {
                                    break Label_0215;
                                }
                            }
                            if (this.c(x3.e())) {
                                this.d.add(x3.e());
                            }
                        }
                        Label_0308: {
                            if (!this.c(x3.e())) {
                                this.b.a(x3.e(), this.a.b(x3.e()));
                                if (!x2) {
                                    break Label_0308;
                                }
                            }
                            if (this.e.b(x3.e()) == null) {
                                this.e.a(x3.e(), new y());
                            }
                        }
                        x3.g();
                        if (x2) {
                            break;
                        }
                    }
                    return;
                }
                if (x2) {
                    break;
                }
            }
            x3 = x.o();
            continue;
        }
    }
    
    void a(final X x) {
        x.a(this.e);
    }
    
    void b(final q q, final bK bk) {
        final boolean x = N.x;
        final x b = this.b(q);
        if (b.k() == 0) {
            this.a(q, bk);
            if (!x) {
                return;
            }
        }
        while (b.f()) {
            final q e = b.e();
            bK a = this.a(e);
            if (a == null) {
                a = bk;
            }
            Label_0094: {
                if (this.c(e)) {
                    this.b(e, a);
                    if (!x) {
                        break Label_0094;
                    }
                }
                this.a(e, a);
            }
            b.g();
            if (x) {
                break;
            }
        }
    }
    
    aB(final X x, final c c, final c c2, final O o) {
        this(x, c, c2);
    }
    
    static A a(final aB ab) {
        return ab.b;
    }
}
