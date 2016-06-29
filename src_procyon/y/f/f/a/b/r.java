package y.f.f.a.b;

import y.f.f.a.a.*;
import java.util.*;
import y.c.*;

public class r
{
    private a a;
    private i b;
    private p c;
    
    public r(final a a) {
        this.a = a;
        this.b = this.a.d();
        this.c = this.a.b();
    }
    
    public static void a(final a a) {
        new r(a).a();
    }
    
    public void a() {
        this.a.g();
        m.b(new t(this, null), this.c);
    }
    
    public void a(final q q) {
        final boolean c = y.f.f.a.b.a.c;
        final f b = this.a.b(q);
        final f f = new f();
        final d d = (d)b.f();
        d d2 = this.a.l(d);
        f.a(d);
        while (d != d2) {
            if (d2.d() == q) {
                d2 = this.a.c(d2);
                if (!c) {
                    continue;
                }
            }
            if (d2.c() == q) {
                f.a(d2);
            }
            d2 = this.a.l(d2);
            if (c) {
                break;
            }
        }
        this.a.b(q, f);
    }
    
    public void b(final q q) {
        final boolean c = y.f.f.a.b.a.c;
        final f b = this.a.b(q);
        final f a = this.a.a(q);
        final f f = new f();
        final e a2 = b.a();
        while (a2.f()) {
            d d = this.a.i(a2.a());
            if (c) {
                return;
            }
            if (q == d.d()) {
                d = this.a.c(d);
            }
            f.a(d);
            a.remove(d);
            a2.g();
            if (c) {
                break;
            }
        }
        f.addAll(a);
        this.a.a(q, f);
    }
    
    static a a(final r r) {
        return r.a;
    }
}
