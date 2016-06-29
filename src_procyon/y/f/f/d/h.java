package y.f.f.d;

import y.c.*;

class h implements k
{
    private n a;
    private l b;
    private final g c;
    
    h(final g c) {
        this.c = c;
        this.a = new n(this.c);
        this.b = new l(this.c);
    }
    
    public boolean a(final D d) {
        if (d.size() < 6) {
            return false;
        }
        final p l = d.l();
        final b b = (b)l.c();
        final p b2 = l.b();
        final b b3 = (b)b2.c();
        final p b4 = b2.b();
        final b b5 = (b)b4.c();
        final b b6 = (b)b4.b().c();
        if (b6.b() != 1 || b5.b() != 0 || b3.b() != 0 || b.b() != 1 || b6.a() != 2 || b5.a() != 1 || b3.a() != 1 || b.a() != 2) {
            return false;
        }
        if (b.g()) {
            return this.a.a(d);
        }
        if (b6.f()) {
            return this.b.a(d);
        }
        throw new RuntimeException("Cannot dispatch 1001 rule in KanCompactor !");
    }
}
