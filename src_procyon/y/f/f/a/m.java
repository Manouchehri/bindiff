package y.f.f.a;

import y.f.f.a.a.*;
import y.c.*;
import y.f.*;
import y.d.*;

class m implements h
{
    private final k a;
    
    private m(final k a) {
        this.a = a;
    }
    
    public void a(final e e) {
        final boolean a = f.a;
        if (e.e()) {
            return;
        }
        if (e.d()) {
            return;
        }
        final q b_ = ((b)e).b_();
        k.a(this.a).d(b_);
        double n = Double.MAX_VALUE;
        double n2 = -1.7976931348623157E308;
        double n3 = Double.MAX_VALUE;
        double n4 = -1.7976931348623157E308;
        final y.c.e a2 = k.b(this.a).g(b_).a();
        while (true) {
            do {
                double f = 0.0;
                Label_0082: {
                    f = (a2.f() ? 1 : 0);
                }
                Label_0089:
                while (f != 0) {
                    final d a3 = a2.a();
                    final X a4 = k.a(this.a);
                    if (!a) {
                        final u b = a4.j(a3).b();
                        while (b.f()) {
                            final double a5 = b.a().a();
                            final double b2 = b.a().b();
                            final double n5 = f = dcmpg(a5, n);
                            if (a) {
                                continue Label_0089;
                            }
                            if (n5 < 0) {
                                n = a5;
                            }
                            if (a5 > n2) {
                                n2 = a5;
                            }
                            if (b2 < n3) {
                                n3 = b2;
                            }
                            if (b2 > n4) {
                                n4 = b2;
                            }
                            b.g();
                            if (a) {
                                break;
                            }
                        }
                        a2.g();
                        continue Label_0082;
                    }
                    a4.c(b_, n, n3);
                    return;
                }
                break;
            } while (!a);
            k.a(this.a).b(b_, n2 - n, n4 - n3);
            k.a(this.a);
            continue;
        }
    }
    
    m(final k k, final l l) {
        this(k);
    }
}
