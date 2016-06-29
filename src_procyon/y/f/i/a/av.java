package y.f.i.a;

import java.util.*;

class av extends ab
{
    private int b;
    private boolean c;
    
    protected void b(final aa aa) {
        super.b(aa);
        this.b = this.b().d().f().f();
        this.c = (this.b > 0);
    }
    
    double[] a(final f f, final R r, final P[] array, final v[] array2, final double[] array3) {
        final double n = (this.c && this.a(r)) ? this.b : 0.0;
        this.b("punish edge label crossing", n, false);
        final double[] array4 = new double[array.length];
        if (n > 0.0) {
            Arrays.fill(array4, n);
        }
        return array4;
    }
    
    private boolean a(final R r) {
        final List list = (List)r.a(T.d);
        return list != null && list.size() > 0;
    }
}
