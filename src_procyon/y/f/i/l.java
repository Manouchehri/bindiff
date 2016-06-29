package y.f.i;

import y.f.*;
import java.util.*;
import y.g.*;
import y.c.*;

class l
{
    X a;
    c b;
    c c;
    f d;
    h e;
    h f;
    
    l(final X a) {
        this.a = a;
    }
    
    void a() {
        final int f = v.f;
        this.d = new f();
        this.c = this.a.c(aF.d);
        this.b = this.a.c(aF.c);
        this.e = this.a.u();
        this.f = this.a.u();
        this.a.a(aF.d, this.e);
        this.a.a(aF.c, this.f);
        final HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        int n = 0;
        final e p = this.a.p();
        while (p.f()) {
            final d a = p.a();
            Label_0320: {
                if (this.c != null && this.c.b(a) != null) {
                    this.e.a(a, this.c.b(a));
                    if (f == 0) {
                        break Label_0320;
                    }
                }
                final Object o = (this.b == null) ? null : this.b.b(a);
                if (o != null) {
                    Object o2 = hashMap.get(o);
                    if (o2 == null) {
                        o2 = am.a(o, "" + n);
                        ++n;
                        hashMap.put(o, o2);
                    }
                    this.e.a(a, o2);
                    final D m = this.a.m(a);
                    m.n();
                    this.a.c(a);
                    this.a.a(a, m);
                    this.d.add(a);
                }
            }
            p.g();
            if (f != 0) {
                break;
            }
        }
    }
    
    void b() {
        final int f = v.f;
        final e a = this.d.a();
        while (true) {
            while (a.f()) {
                final d a2 = a.a();
                final D m = this.a.m(a2);
                m.n();
                this.a.c(a2);
                this.a.a(a2, m);
                a.g();
                if (f != 0) {
                    if (this.b != null) {
                        this.a.a(aF.c, this.b);
                    }
                    if (this.c != null) {
                        this.a.a(aF.d, this.c);
                    }
                    this.a.a(this.f);
                    this.a.a(this.e);
                    return;
                }
                if (f != 0) {
                    break;
                }
            }
            this.a.d_(aF.c);
            this.a.d_(aF.d);
            continue;
        }
    }
    
    public void a(final h h, final h h2) {
        final int f = v.f;
        final e a = this.d.a();
        while (a.f()) {
            final d a2 = a.a();
            final Object b = h.b(a2);
            h.a(a2, h2.b(a2));
            h2.a(a2, b);
            a.g();
            if (f != 0) {
                break;
            }
        }
    }
}
