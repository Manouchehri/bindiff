package y.f.c.a;

import y.f.*;
import y.g.*;
import java.util.*;
import y.c.*;

class al implements aT
{
    private aT a;
    private aS b;
    private aT c;
    private c d;
    private A e;
    private Map f;
    private Map g;
    private boolean h;
    private final N i;
    
    public al(final N i, final aT a, final aT c, final c d, final A e, final boolean h) {
        this.i = i;
        this.a = a;
        this.c = c;
        this.d = d;
        this.e = e;
        this.h = h;
    }
    
    public void a(final X x, final aU au, final aV av) {
        final boolean x2 = N.x;
        final c c = x.c(N.w);
        if (c == null) {
            N.a(this.i, x, this.d, this.a, au, av, this.c, this.e, null);
            return;
        }
        final E e = (E)c.b(x);
        e.c();
        if (!e.k() || y.f.b.c.c(x)) {
            e.b();
            N.a(this.i, x, this.d, this.a, au, av, this.c, this.e, e);
            return;
        }
        final y.f.b.c c2 = new y.f.b.c(x);
        this.b = new x(N.a(this.i));
        final J j = new J(x, new V(this, c2));
        final f f = new f();
        if (this.h) {
            final y.f.b.c c3 = new y.f.b.c(x);
            try {
                final ArrayList<q> list = new ArrayList<q>();
                final ArrayList list2 = new ArrayList<q>();
                final e a = new f(x.p()).a();
                while (a.f()) {
                    final d a2 = a.a();
                    final y.f.b.c c4 = c3;
                    if (x2) {
                        break;
                    }
                    Label_0517: {
                        Label_0510: {
                            if (!c4.a(a2)) {
                                list.clear();
                                list2.clear();
                                final q c5 = a2.c();
                                final q d = a2.d();
                                q q = c3.a(c5);
                                while (true) {
                                    while (q != c3.b()) {
                                        list.add(q);
                                        q = c3.a(q);
                                        if (x2) {
                                            while (q != c3.b()) {
                                                list2.add(q);
                                                q = c3.a(q);
                                                if (x2) {
                                                    break Label_0517;
                                                }
                                                if (x2) {
                                                    break;
                                                }
                                            }
                                            int n = 0;
                                            do {
                                                Label_0387: {
                                                    list.size();
                                                }
                                                int i = 0;
                                                int size = 0;
                                                while (i < size) {
                                                    i = n;
                                                    size = list2.size();
                                                    if (!x2) {
                                                        if (i < size && list.get(n) == list2.get(n)) {
                                                            ++n;
                                                            continue Label_0387;
                                                        }
                                                        break;
                                                    }
                                                }
                                                break;
                                            } while (!x2);
                                            final q q2 = (n > 0) ? list.get(n - 1) : c3.b();
                                            f.add(x.a(c3.a(c5, q2), c3.a(d, q2)));
                                            break Label_0510;
                                        }
                                        if (x2) {
                                            break;
                                        }
                                    }
                                    q = c3.a(d);
                                    continue;
                                }
                            }
                        }
                        a.g();
                    }
                    if (x2) {
                        break;
                    }
                }
            }
            finally {
                c3.c();
            }
        }
        this.a(x, null, au, c2, j, av);
        final e a3 = f.a();
        while (a3.f()) {
            x.a(a3.a());
            a3.g();
            if (x2) {
                return;
            }
            if (x2) {
                break;
            }
        }
        c2.c();
        e.b();
    }
    
    private void a(final X x, final q q, final aU au, final y.f.b.c c, final J j, final aV av) {
        final boolean x2 = N.x;
        this.a(x, c, c.b(q));
        j.c(q);
        final cd cd = new cd();
        cd.a(x);
        final ah a = N.a(this.i, x, this.d);
        this.a.a(x, au, av);
        N.a(this.i, x, au);
        Label_0135: {
            if (c.d(q)) {
                N.a(this.i, this.c, x, au, av, a, this.e, c, q);
                if (!x2) {
                    break Label_0135;
                }
            }
            N.a(this.i, this.c, x, au, av, a, this.e, null);
        }
        cd.b(x);
        j.b();
        this.a(x);
        int i = 0;
    Label_0154:
        while (i < au.b()) {
            final y d = au.a(i).d();
            final aU a2 = au.a();
            final y y = new y();
            final y y2 = new y();
            d.a();
            Label_0629: {
                int b = 0;
            Label_0359_Outer:
                while (true) {
                    y.c.x a3 = null;
                    final y.c.x x3 = a3;
                    while (true) {
                        while (x3.f()) {
                            final q e = x3.e();
                            final int d2 = c.d(e) ? 1 : 0;
                            if (!x2) {
                                Label_0342: {
                                    if (d2 != 0) {
                                        y2.add(e);
                                        final aU a4 = au.a();
                                        this.a(x, e, a4, c, j, av);
                                        if (a4.b() > 0) {
                                            this.b.a(x, av, a4, a2);
                                            y2.add(e);
                                            if (!x2) {
                                                break Label_0342;
                                            }
                                        }
                                        y.add(e);
                                        if (!x2) {
                                            break Label_0342;
                                        }
                                    }
                                    y.add(e);
                                }
                                x3.g();
                                if (x2) {
                                    break;
                                }
                                continue Label_0359_Outer;
                            }
                            else {
                                if (d2 > 0) {
                                    b = a2.b();
                                    int n = 0;
                                    Label_0435: {
                                        switch (N.a(this.i)) {
                                            case 18: {
                                                n = 0;
                                                if (x2) {
                                                    break Label_0435;
                                                }
                                                break;
                                            }
                                            case 66: {
                                                n = b / 2;
                                                if (x2) {
                                                    break Label_0435;
                                                }
                                                break;
                                            }
                                            case 34: {
                                                n = b - 1;
                                                break;
                                            }
                                        }
                                    }
                                    final y.c.x a5 = y.a();
                                    while (a5.f()) {
                                        a2.a(n).a(a5.e());
                                        a5.g();
                                        if (x2) {
                                            continue Label_0154;
                                        }
                                        if (x2) {
                                            break;
                                        }
                                    }
                                    int k = 0;
                                Label_0503:
                                    while (k < b) {
                                        final aQ a6 = a2.a(k);
                                        final aQ a7 = au.a(a6.e(), i + k);
                                        a3 = a6.d().a();
                                        if (!x2) {
                                            final y.c.x x4 = a3;
                                            while (true) {
                                                while (x4.f()) {
                                                    a7.a(x4.e());
                                                    x4.g();
                                                    if (!x2) {
                                                        if (x2) {
                                                            break;
                                                        }
                                                        continue Label_0359_Outer;
                                                    }
                                                    else {
                                                        if (x2) {
                                                            break Label_0359_Outer;
                                                        }
                                                        continue Label_0503;
                                                    }
                                                }
                                                ++k;
                                                continue;
                                            }
                                        }
                                        continue Label_0629;
                                    }
                                    break Label_0359_Outer;
                                }
                                break Label_0629;
                            }
                        }
                        y2.size();
                        continue;
                    }
                }
                i += b;
                au.b(i);
                continue;
            }
            ++i;
            if (x2) {
                break;
            }
        }
    }
    
    private void a(final X x, final y.f.b.c c, final y y) {
        final boolean x2 = N.x;
        this.f = new HashMap();
        this.g = new HashMap();
        final y.c.x a = y.a();
        while (a.f()) {
            final q e = a.e();
            Label_0333: {
                if (c.d(e)) {
                    final y y2 = new y();
                    this.a(c, e, y2);
                    final f f = new f();
                    final f f2 = new f();
                    final y.c.x a2 = y2.a();
                    while (a2.f()) {
                        final q e2 = a2.e();
                        f2.a(e2.k());
                        f.a(e2.l());
                        a2.g();
                        if (x2) {
                            break Label_0333;
                        }
                        if (x2) {
                            break;
                        }
                    }
                    e e3 = f2.a();
                    d d = null;
                    q q2;
                    q q = null;
                    q q4;
                    q q3 = null;
                    Label_0198_Outer:Label_0250_Outer:
                    while (true) {
                        while (true) {
                            while (true) {
                                Label_0276: {
                                    Label_0243: {
                                        if (!e3.f()) {
                                            break Label_0243;
                                        }
                                        d = e3.a();
                                        q = (q2 = d.c());
                                        q3 = (q4 = e);
                                        if (x2) {
                                            break Label_0276;
                                        }
                                        if (q2 != q4) {
                                            this.f.put(d, d.d());
                                            x.a(d, d.c(), e);
                                        }
                                        e3.g();
                                        if (!x2) {
                                            continue Label_0198_Outer;
                                        }
                                    }
                                    e3 = f.a();
                                    if (!e3.f()) {
                                        break;
                                    }
                                    d = e3.a();
                                    q = (q2 = d.d());
                                    q3 = (q4 = e);
                                }
                                if (x2) {
                                    continue Label_0250_Outer;
                                }
                                break;
                            }
                            if (q != q3) {
                                this.g.put(d, d.c());
                                x.a(d, e, d.d());
                            }
                            e3.g();
                            if (x2) {
                                break;
                            }
                            continue;
                        }
                    }
                }
                a.g();
            }
            if (x2) {
                break;
            }
        }
    }
    
    private void a(final y.f.b.c c, final q q, final y y) {
        final boolean x = N.x;
        final y.c.x a = c.b(q).a();
        while (a.f()) {
            final q e = a.e();
            y.add(e);
            if (c.d(e)) {
                this.a(c, e, y);
            }
            a.g();
            if (x) {
                break;
            }
        }
    }
    
    private void a(final X x) {
        final boolean x2 = N.x;
        final f f = new f(x.p());
        e e = f.a();
        while (true) {
            while (e.f()) {
                d d = e.a();
                final q q2;
                q q = q2 = this.g.get(d);
                if (x2) {
                    while (true) {
                        if (q2 != null) {
                            x.a(d, d.c(), q);
                        }
                        e.g();
                        if (!x2) {
                            if (e.f()) {
                                d = e.a();
                                final q q3;
                                q = (q3 = this.f.get(d));
                                continue;
                            }
                        }
                        break;
                    }
                    return;
                }
                if (q2 != null) {
                    x.a(d, q, d.d());
                }
                e.g();
                if (x2) {
                    break;
                }
            }
            e = f.a();
            continue;
        }
    }
}
