package y.f.i.a;

import java.util.*;

class aV extends ab
{
    private int b;
    private boolean c;
    
    protected void b(final aa aa) {
        super.b(aa);
        this.b = aa.d().f().l();
        this.c = (this.b > 0);
    }
    
    double[] a(final f f, final R r, final P[] array, final v[] array2, final double[] array3) {
        if (!this.c) {
            this.b("punish bends in node to edge distance", 0.0, false);
            return new double[array.length];
        }
        return super.a(f, r, array, array2, array3);
    }
    
    protected double a(final f f, final R r, final P p5, final v v, final double n) {
        final R a = f.a();
        double n2 = 0.0;
        if (a(a)) {
            n2 = this.b * a(v);
        }
        this.a("punish bends in node to edge distance", n2, false);
        return n2;
    }
    
    private static boolean a(final R r) {
        return !b(r).isEmpty();
    }
    
    private static int a(final v v) {
        if (v == null) {
            return 0;
        }
        switch (v.c()) {
            case 1:
            case 3: {
                return 2;
            }
            case 2: {
                return 1;
            }
            default: {
                return 0;
            }
        }
    }
    
    private static List b(final R r) {
        return (List)r.a(T.b);
    }
}
