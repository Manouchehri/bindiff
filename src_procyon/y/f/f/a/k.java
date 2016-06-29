package y.f.f.a;

import y.f.f.a.b.*;
import y.f.*;
import java.util.*;
import y.d.*;
import y.c.*;
import y.f.f.a.a.*;

public class k
{
    private a a;
    private X b;
    private p c;
    private f d;
    
    public k(final a a, final f d) {
        this.a = a;
        this.b = (X)this.a.d();
        this.c = this.a.b();
        this.d = d;
    }
    
    public static void a(final a a, final f f) {
        new k(a, f).a();
    }
    
    public void a() {
        this.c();
        this.b();
    }
    
    private void b() {
        final boolean a = y.f.f.a.f.a;
        final e a2 = this.d.a();
        while (a2.f()) {
            final f f = new f();
            final d a3 = a2.a();
            if (!this.b.f(a3)) {
                this.b.e(a3);
            }
            final f x = this.a.x(a3);
            D d;
            if (x != null) {
                d = this.a(x.b());
                d.addAll(this.a(x.c()));
            }
            else {
                d = this.a(a3);
            }
            this.b.c(a3, (t)d.f());
            this.b.d(a3, (t)d.i());
            d.h(d.k());
            d.h(d.l());
            this.b.b(a3, d);
            a2.g();
            if (a) {
                break;
            }
        }
    }
    
    private D a(final d d) {
        final boolean a = y.f.f.a.f.a;
        final D d2 = new D();
        final d w = this.a.w(d);
        e e = null;
        Label_0152: {
            f f;
            if (w != null) {
                f = this.a.d(w);
                e = f.a();
                while (e.f()) {
                    final d a2 = e.a();
                    final boolean p = this.a.p(a2);
                    if (a) {
                        break Label_0152;
                    }
                    if (p) {
                        f.remove(a2);
                    }
                    e.g();
                }
            }
            else {
                f = this.a.d(d);
            }
            if (f == null) {
                f = new f(d);
            }
            e = f.a();
            e.i();
            d2.add(this.b.p(e.a()));
        }
        while (e.f()) {
            d2.addAll(this.b.k(e.a()));
            e.g();
            if (a) {
                return d2;
            }
            if (a) {
                break;
            }
        }
        e.j();
        d2.b(this.b.q(e.a()));
        return d2;
    }
    
    private void c() {
        y.f.f.a.a.m.a(new m(this, null), this.c);
    }
    
    static X a(final k k) {
        return k.b;
    }
    
    static a b(final k k) {
        return k.a;
    }
}
