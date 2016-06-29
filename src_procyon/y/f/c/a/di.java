package y.f.c.a;

import y.f.c.*;
import y.f.*;
import y.g.*;
import y.c.*;

class di implements R
{
    private aT a;
    
    public di(final aT a) {
        if (a == null) {
            throw new NullPointerException();
        }
        this.a = a;
    }
    
    public int a(final X x, final A a, final f f) {
        final boolean x2 = N.x;
        final A a2 = M.a();
        final dl dl = new dl(a2, M.b());
        final x o = x.o();
        while (o.f()) {
            a2.a(o.e(), new dj(null, null, null));
            o.g();
            if (x2) {
                break;
            }
        }
        final dn dn = new dn(dl);
        this.a.a(x, dn, dl);
        int i = 0;
    Label_0116:
        while (true) {
        Label_0205_Outer:
            while (i < dn.b()) {
                final aQ a3 = dn.a(i);
                if (!x2) {
                    final x a4 = a3.d().a();
                    while (true) {
                        while (a4.f()) {
                            a.a(a4.e(), i);
                            a4.g();
                            if (!x2) {
                                if (x2) {
                                    break;
                                }
                                continue Label_0205_Outer;
                            }
                            else {
                                if (x2) {
                                    break Label_0205_Outer;
                                }
                                continue Label_0116;
                            }
                        }
                        ++i;
                        continue;
                    }
                }
                final e p3 = x.p();
                int a6 = 0;
                while (p3.f()) {
                    final d a5 = p3.a();
                    a6 = a.a(a5.c());
                    if (x2) {
                        return a6;
                    }
                    if (a6 > a.a(a5.d())) {
                        x.c(a5);
                        f.add(a5);
                    }
                    p3.g();
                    if (x2) {
                        break;
                    }
                }
                dn.b();
                return a6;
            }
            f.clear();
            continue;
        }
    }
}
