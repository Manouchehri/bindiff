package y.f.i.a;

import y.f.c.a.*;
import y.c.*;
import java.util.*;

class aG extends ab
{
    private int b;
    private boolean c;
    private bk d;
    
    protected void c() {
        super.c();
        this.d = null;
    }
    
    protected void a(final Z z) {
        super.a(z);
        this.d = bk.c(z.a());
    }
    
    protected void b(final aa aa) {
        super.b(aa);
        this.b = this.b().d().f().n();
        this.c = (this.d != null && this.b > 0);
    }
    
    double[] a(final f f, final R r, final P[] array, final v[] array2, final double[] array3) {
        double n = 0.0;
        if (this.c && f.d() != null && this.a(f, r)) {
            n = this.b;
        }
        this.b("punish reentering partition grid cells", n, false);
        final double[] array4 = new double[array.length];
        if (n > 0.0) {
            Arrays.fill(array4, n);
        }
        return array4;
    }
    
    private boolean a(final f f, final R r) {
        final R a = this.b().a(0);
        final int a2 = this.a(a);
        final int b = this.b(a);
        final R b2 = this.b().b(0);
        final int a3 = this.a(b2);
        final int b3 = this.b(b2);
        final R a4 = f.a();
        return (a2 < a3 && this.a(r) < this.a(a4)) || (a2 > a3 && this.a(r) > this.a(a4)) || (a2 == a3 && this.a(a4) > a3 && this.a(a4) > this.a(r)) || (a2 == a3 && this.a(a4) < a3 && this.a(a4) < this.a(r)) || (b < b3 && this.b(r) < this.b(a4)) || (b > b3 && this.b(r) > this.b(a4)) || (b == b3 && this.b(a4) > b3 && this.b(a4) > this.b(r)) || (b == b3 && this.b(a4) < b3 && this.b(a4) < this.b(r));
    }
    
    private int a(final R r) {
        final Integer n = (Integer)r.a(T.f);
        return (n != null) ? n : -1;
    }
    
    private int b(final R r) {
        final Integer n = (Integer)r.a(T.g);
        return (n != null) ? n : -1;
    }
}
