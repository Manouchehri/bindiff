package y.f.i.a;

import y.f.*;
import y.f.b.*;
import y.g.*;
import y.c.*;

public class Z
{
    private final y a;
    private final X b;
    private final c c;
    private h d;
    private long e;
    
    public Z(final X b, final c c, final y a) {
        this.b = b;
        this.c = c;
        this.a = a;
    }
    
    public X a() {
        return this.b;
    }
    
    public c b() {
        return this.c;
    }
    
    public y c() {
        return this.a;
    }
    
    void a(final long e) {
        this.e = e;
    }
    
    public long d() {
        return Math.max(0L, this.a.b() - (System.currentTimeMillis() - this.e));
    }
    
    aU a(final d d) {
        return (aU)this.e().b(d);
    }
    
    private h e() {
        final int a = ab.a;
        h d = null;
        if (this.d == null) {
            this.d = M.b();
            final e p = this.b.p();
            while (p.f()) {
                final d a2 = p.a();
                d = this.d;
                if (a != 0) {
                    return d;
                }
                d.a(a2, new aU(a2));
                p.g();
                if (a != 0) {
                    break;
                }
            }
        }
        final h d2 = this.d;
        return d;
    }
}
