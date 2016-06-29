package y.f.g;

import y.g.a.*;
import y.f.*;
import y.g.*;
import java.util.*;
import y.c.*;

class l implements g
{
    private X a;
    private i b;
    private y c;
    private A d;
    private A e;
    private y f;
    private final d g;
    
    l(final d g, final X a, final i b, final A e, final y f) {
        this.g = g;
        this.a = a;
        this.b = b;
        this.e = e;
        this.c = new y();
        this.d = M.a();
        (this.f = f).sort(new m(b));
    }
    
    public boolean a() {
        return this.c.isEmpty();
    }
    
    public boolean a(final q q) {
        return this.c.contains(q);
    }
    
    public void a(final q q, final int n) {
        this.c.add(q);
        this.d.a(q, n);
    }
    
    public q b() {
        final boolean d = y.f.g.d.d;
        if (this.a()) {
            return null;
        }
        final x a = this.f.a();
        while (true) {
        Label_0217_Outer:
            while (a.f()) {
                final q e = a.e();
                final int b = e.b();
                if (d) {
                    int n = b;
                    q q = null;
                    double n2 = 0.0;
                    final x a2 = this.c.a();
                    while (true) {
                        while (a2.f()) {
                            final q e2 = a2.e();
                            final double n3 = this.a.p(e2) * this.a.q(e2);
                            final int b2 = this.b(e2);
                            final q q3;
                            final q q2 = q3 = (q)this.e.b(e2);
                            if (!d) {
                                if ((q3 == null || q2.b() == 0) && (n > b2 || (n == b2 && n3 > n2))) {
                                    n = b2;
                                    q = e2;
                                    n2 = n3;
                                }
                                a2.g();
                                if (d) {
                                    break;
                                }
                                continue Label_0217_Outer;
                            }
                            else {
                                if (q3 == null) {
                                    throw new RuntimeException("Found no valid element!");
                                }
                                return q;
                            }
                        }
                        continue;
                    }
                }
                if (b == 0) {
                    this.f.b(a);
                    this.b.a(e);
                }
                a.g();
                if (d) {
                    break;
                }
            }
            continue;
        }
    }
    
    public q c() {
        final q b = this.b();
        this.c.remove(b);
        this.b.a((q)this.e.b(b));
        return b;
    }
    
    public void b(final q q, final int n) {
        this.d.a(q, n);
    }
    
    public void d() {
        this.c.clear();
        this.d = M.a();
    }
    
    public int b(final q q) {
        return this.d.a(q);
    }
}
