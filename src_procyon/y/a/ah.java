package y.a;

import y.c.*;
import y.g.*;

class ah extends ai
{
    final y a;
    final f b;
    A c;
    final h d;
    private final ag j;
    
    ah(final ag j, final i i) {
        super(j, i);
        this.j = j;
        this.d = i.u();
        this.a = new y();
        this.b = new f();
    }
    
    void a() {
        this.e.a(this.d);
        this.a.clear();
        this.b.clear();
        this.c = null;
        super.a();
    }
    
    y[] a(final y y, final A a) {
        final boolean a2 = y.a.h.a;
        ag.a(this.j).a(this.e, y, this.c, this.d);
        ag.a(this.b.a(), this.f, this.d);
        final e a3 = this.b.a();
        while (a3.f()) {
            final ah ah = this;
            if (a2) {
                return ah.a(y, a);
            }
            super.a(a3.a());
            a3.g();
            if (a2) {
                break;
            }
        }
        final ah ah = this;
        return ah.a(y, a);
    }
    
    void a(final y y) {
    }
    
    d b() {
        final d b = super.b();
        this.a.clear();
        this.b.clear();
        this.c = M.a(new int[this.e.e()]);
        ag.a(b, ag.a(this.j).b(), this.a, this.b, this.c);
        ag.a(this.j).a(this.e, this.a, this.c, this.d);
        ag.b(this.b.a(), this.f, this.d);
        this.b.remove(b);
        return b;
    }
}
