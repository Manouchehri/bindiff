package y.f.f.d;

import y.c.*;

class j implements k
{
    private final g a;
    
    j(final g a) {
        this.a = a;
    }
    
    public boolean a(final D d) {
        final boolean p = o.p;
        if (d.size() < 4) {
            return false;
        }
        final y.c.p l = d.l();
        final b b = (b)l.c();
        final y.c.p b2 = l.b();
        final b b3 = (b)b2.c();
        final y.c.p b4 = b2.b();
        final b b5 = (b)b4.c();
        final b b6 = (b)b4.b().c();
        if (b6.b() == 0 && b5.b() == 0 && b3.b() == 0 && b.b() == 1 && b.a() == 2 && b5.a() == 1 && b3.a() == 1) {
            d.j();
            d.j();
            d.j();
            d.add(new b(b6.e(), b.e(), 0, b.c(), 2));
            final p d2 = b6.d();
            final p e = b.e();
            if (b3.c().a(y.f.f.b.o.d)) {
                y.f.f.d.p.a(g.a(this.a), d2, e, 1);
                if (!p) {
                    return true;
                }
            }
            if (b3.c().a(y.f.f.b.o.b)) {
                y.f.f.d.p.a(g.a(this.a), e, d2, 1);
                if (!p) {
                    return true;
                }
            }
            if (b3.c().a(y.f.f.b.o.c)) {
                y.f.f.d.p.a(g.b(this.a), e, d2, 1);
                if (!p) {
                    return true;
                }
            }
            if (b3.c().a(y.f.f.b.o.a)) {
                y.f.f.d.p.a(g.b(this.a), d2, e, 1);
                if (!p) {
                    return true;
                }
            }
            y.g.o.a((Object)"Consistency Error in rect decomp.");
            return true;
        }
        return false;
    }
}
