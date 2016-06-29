package y.f.d;

import y.f.*;
import y.c.*;

class k
{
    private y a;
    private f b;
    private D c;
    private final i d;
    
    public k(final i d) {
        this.d = d;
        this.a = new y();
        this.b = new f();
        this.c = new D();
    }
    
    public void a(final q q) {
        this.a.add(q);
    }
    
    public void a(final d d) {
        this.b.add(d);
    }
    
    public void a(final r r) {
        this.c.add(r);
    }
    
    public String toString() {
        final int f = y.f.d.a.f;
        final r[] a = this.a();
        final StringBuffer sb = new StringBuffer();
        int i = 0;
        while (i < a.length) {
            final StringBuffer append = sb.append(a[i].toString() + "\n");
            if (f != 0) {
                return append.toString();
            }
            ++i;
            if (f != 0) {
                break;
            }
        }
        final StringBuffer append = sb;
        return append.toString();
    }
    
    public r[] a() {
        final int f = y.f.d.a.f;
        final r[] array = new r[this.c.size()];
        int n = 0;
        final C m = this.c.m();
        r[] array2 = null;
        while (m.f()) {
            array2 = array;
            if (f != 0) {
                return array2;
            }
            array2[n++] = (r)m.d();
            m.g();
            if (f != 0) {
                break;
            }
        }
        return array2;
    }
    
    public void b() {
        final int f = y.f.d.a.f;
        int n = 0;
        final C m = this.c.m();
    Label_0125_Outer:
        while (m.f()) {
            final C i = ((r)m.d()).b().m();
            while (true) {
                while (i.f()) {
                    this.d.p.a(this.d.o.get(i.d()), n);
                    i.g();
                    if (f == 0) {
                        if (f != 0) {
                            break;
                        }
                        continue Label_0125_Outer;
                    }
                    else {
                        if (f != 0) {
                            break Label_0125_Outer;
                        }
                        continue Label_0125_Outer;
                    }
                }
                ++n;
                m.g();
                continue;
            }
        }
    }
    
    public void c() {
        final int f = y.f.d.a.f;
        x x = this.d.i.o();
        while (true) {
            while (x.f()) {
                this.d.i.c(x.e());
                x.g();
                if (f != 0) {
                    while (true) {
                        while (x.f()) {
                            final k k = this;
                            if (f != 0) {
                                final e a = k.b.a();
                                while (a.f()) {
                                    this.d.i.e(a.a());
                                    a.g();
                                    if (f != 0) {
                                        break;
                                    }
                                }
                                return;
                            }
                            this.d.i.d(x.e());
                            x.g();
                            if (f != 0) {
                                break;
                            }
                        }
                        final k k = this;
                        continue;
                    }
                }
                if (f != 0) {
                    break;
                }
            }
            x = this.a.a();
            continue;
        }
    }
}
