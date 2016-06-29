package y.f.f.c;

import java.util.*;
import y.f.f.b.*;
import y.c.*;

public class q
{
    protected h a;
    protected p b;
    protected p c;
    
    public q(final p b, final p c) {
        this.b = b;
        this.c = c;
        this.a();
    }
    
    public void a(final h a) {
        this.a = a;
    }
    
    private void a() {
        this.a(this.b, this.c);
        this.a(this.c, this.b);
    }
    
    private void a(final p p2, final p p3) {
        final int a = g.a;
        final Iterator d = p2.d();
        while (d.hasNext()) {
            final g g = d.next();
            final C m = g.h().m();
            final y.c.q q = (y.c.q)m.d();
            m.j();
            g.a(p3.a(q), p3.a((y.c.q)m.d()));
            if (a != 0) {
                break;
            }
        }
    }
    
    public static int a(final h h, final p p3, final p p4) {
        final int a = g.a;
        int n = 0;
        final e p5 = h.a().p();
        while (p5.f()) {
            final d a2 = p5.a();
            final int a3;
            final boolean b = (a3 = (h.h(a2).a(o.b) ? 1 : 0)) != 0;
            if (a != 0) {
                return a3;
            }
            if (b) {
                n = n + p3.a(a2.d()).i() - p3.a(a2.c()).i();
            }
            if (h.h(a2).a(o.c)) {
                n = n + p4.a(a2.d()).i() - p4.a(a2.c()).i();
            }
            p5.g();
            if (a != 0) {
                break;
            }
        }
        return n;
    }
}
