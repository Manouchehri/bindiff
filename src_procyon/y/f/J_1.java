package y.f;

import y.d.*;
import y.c.*;

public class J implements al
{
    private X a;
    private q b;
    private boolean c;
    
    public J(final X a, final q b) {
        this.a = a;
        this.b = b;
    }
    
    public Object c() {
        return null;
    }
    
    public n a(final y.d.q q, final am am, final Object o) {
        final boolean j = X.j;
        final double n = am.getX() + (am.getWidth() - q.a()) / 2.0;
        final double n2 = am.getY() + (am.getHeight() - q.b()) / 2.0;
        final q b = this.b;
        if (!this.c && b != null && b.a() > 0) {
            this.c = true;
            try {
                double n3 = 0.0;
                double n4 = 0.0;
                final e i = b.j();
                while (true) {
                    while (i.f()) {
                        final q a = i.a().a(b);
                        n3 += this.a.j(b) - this.a.j(a);
                        n4 += this.a.k(b) - this.a.k(a);
                        i.g();
                        if (!j) {
                            if (j) {
                                break;
                            }
                            continue;
                        }
                        else {
                            if (n3 != 0.0 || n4 != 0.0) {
                                final double sqrt = Math.sqrt(n3 * n3 + n4 * n4);
                                final double sqrt2 = Math.sqrt(this.a.q(b) * this.a.q(b) + this.a.p(b) * this.a.p(b));
                                return new n(new t(n + n3 * (sqrt2 + 10.0) / sqrt, n2 + n4 * (sqrt2 + 10.0) / sqrt + q.b()), q);
                            }
                            return new n(new t(n, n2 + q.b()), q);
                        }
                    }
                    n3 /= b.a();
                    n4 /= b.a();
                    continue;
                }
            }
            finally {
                this.c = false;
            }
        }
        return new n(new t(n, n2 + q.b()), q);
    }
    
    public Object a(final n n, final am am) {
        return null;
    }
    
    public D a(final aj aj, final am am) {
        final D d = new D();
        d.add(new ai(this.a(aj.getOrientedBox().d(), am, null), null, aj, false));
        return d;
    }
}
