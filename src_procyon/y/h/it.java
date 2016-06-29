package y.h;

import y.d.*;
import y.c.*;
import java.util.*;
import y.f.*;

final class it
{
    final aA a;
    final gu b;
    final gv c;
    final dh d;
    n e;
    gv f;
    
    it(final in in, final dD dd) {
        final double n = dd.c() - in.a(in);
        final double n2 = dd.d() - in.b(in);
        final t c = in.c(in);
        this.a = (aA)dd.b();
        this.b = in.d(in);
        this.f = in.e(in);
        this.c = in.f(in);
        this.d = in.g(in);
        this.e = new n(in.h(in));
        if (this.b.b()) {
            this.e.a(6.283185307179586 - this.c.f());
        }
        this.e.e(c.a() + n, c.b() + n2);
    }
    
    double a() {
        return this.d.e() / this.b();
    }
    
    double b() {
        return this.d.c().getZoom();
    }
    
    t a(final D d) {
        return this.d.b(d, this.e.k());
    }
    
    n c() {
        final aB realizer = this.a.getRealizer();
        return this.b.a(this.e.d(), realizer, realizer.getSourceRealizer(), realizer.getTargetRealizer(), this.f);
    }
    
    void d() {
        this.f = this.b.a(this.e, this.a.getRealizer(), this.f, (byte)2);
    }
}
