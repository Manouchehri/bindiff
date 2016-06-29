package y.f.i.a;

import y.c.*;
import y.f.*;
import java.util.*;

public class ah
{
    private List a;
    private M b;
    private ai c;
    private int d;
    
    public ah(final M b, final List a) {
        this.b = b;
        this.a = a;
    }
    
    public M a() {
        return this.b;
    }
    
    void a(final M b) {
        this.b = b;
    }
    
    public List b() {
        return this.a;
    }
    
    public ai c() {
        return this.c;
    }
    
    void d() {
        final int a = ab.a;
        final ai ai = this.a.get(0);
        final int j = ai.j();
        final y h = ai.h();
        final byte d = ai.d();
        boolean b = true;
        double a2 = Double.MAX_VALUE;
        double b2 = -1.7976931348623157E308;
        double a3 = Double.MAX_VALUE;
        double b3 = -1.7976931348623157E308;
        while (true) {
            for (final ai ai2 : this.a) {
                b &= (d == ai2.d());
                final M a4 = ai2.a();
                if (a4 != null && a2 > a4.a()) {
                    a2 = a4.a();
                }
                if (a4 != null && b2 < a4.b()) {
                    b2 = a4.b();
                }
                final M b4 = ai2.b();
                if (a3 > b4.a()) {
                    a3 = b4.a();
                }
                if (b3 < b4.b()) {
                    b3 = b4.b();
                    if (a != 0) {
                        if (b) {
                            this.c.a(d);
                        }
                        this.d = super.hashCode();
                        return;
                    }
                    if (a != 0) {
                        break;
                    }
                    continue;
                }
            }
            (this.c = new ai(null, j, h, this.b, (a2 < b2) ? new M(a2, b2) : null, new M(a3, b3), Collections.EMPTY_LIST)).a(ai.k());
            continue;
        }
    }
    
    public int hashCode() {
        return this.d;
    }
}
