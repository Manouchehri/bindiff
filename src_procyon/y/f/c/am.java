package y.f.c;

import java.util.*;
import y.d.*;
import y.f.*;
import y.c.*;

class am
{
    private X a;
    private f b;
    private Map c;
    private x d;
    private double e;
    private Comparator f;
    private static final double[] g;
    private static final double[] h;
    private double i;
    
    public am(final X a, final x d) {
        final boolean i = y.f.c.a.i;
        this.e = 20.0;
        this.f = new an(this);
        this.d = d;
        this.a = a;
        this.b = new f();
        this.c = new HashMap();
        final e p2 = a.p();
        while (p2.f()) {
            if (p2.a().e()) {
                this.b.c(p2.a());
            }
            p2.g();
            if (i) {
                break;
            }
        }
    }
    
    public void a(final double e) {
        this.e = e;
    }
    
    public void a() {
        final boolean i = y.f.c.a.i;
        p p = this.b.k();
        while (p != null) {
            this.a.d((d)p.c());
            p = p.a();
            if (i) {
                break;
            }
        }
    }
    
    public void b() {
        final boolean i = y.f.c.a.i;
        p p = this.b.k();
        while (p != null) {
            this.a.e((d)p.c());
            this.a.b(p.c()).clearPoints();
            p = p.a();
            if (i) {
                break;
            }
        }
    }
    
    public void c() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
    }
    
    public y a(final q q) {
        y y = this.c.get(q);
        if (y == null) {
            y = new y(this.a.a((Object)q));
            this.c.put(q, y);
        }
        return y;
    }
    
    public boolean b(final q q) {
        return this.c.containsKey(q);
    }
    
    public void d() {
        final boolean i = y.f.c.a.i;
        p p = this.b.k();
        while (p != null) {
            final d d = (d)p.c();
            final y a = this.a(d.c());
            a.b.add(d);
            final aE a2 = this.a(d);
            final aE b = this.b(d);
            final boolean b2 = !a2.a();
            final boolean b3 = !b.a();
            final int a3 = x.a(a2.b(), 2);
            final int a4 = x.a(b.b(), 0);
            final int n = 4 + a4 - a3 & 0x3;
            if (b2 || b3) {
                if (b2) {
                    Label_0206: {
                        switch (n) {
                            case 0: {
                                a.c(a3).l.add(d);
                                if (i) {
                                    break Label_0206;
                                }
                                break;
                            }
                            case 3: {
                                a.a(a3).l.add(d);
                                if (i) {
                                    break Label_0206;
                                }
                                break;
                            }
                            case 1:
                            case 2: {
                                a.b(a3).l.add(d);
                                break;
                            }
                        }
                    }
                }
                if (b3) {
                    Label_0294: {
                        switch (n) {
                            case 0: {
                                a.c(a4).l.add(d);
                                if (i) {
                                    break Label_0294;
                                }
                                break;
                            }
                            case 1:
                            case 2: {
                                a.a(a4).l.add(d);
                                if (i) {
                                    break Label_0294;
                                }
                                break;
                            }
                            case 3: {
                                a.b(a4).l.add(d);
                                break;
                            }
                        }
                    }
                }
            }
            a.b.sort(this.f);
            p = p.a();
            if (i) {
                break;
            }
        }
    }
    
    public void c(final q q) {
        final boolean i = y.f.c.a.i;
        final y a = this.a(q);
        p p = a.b.k();
        while (p != null) {
            final d d = (d)p.c();
            final aE a2 = this.a(d);
            final aE b = this.b(d);
            final int a3 = x.a(a2.b(), 2);
            final int a4 = x.a(b.b(), 0);
            Label_0188: {
                switch (4 + a4 - a3 & 0x3) {
                    case 0: {
                        a.c(a3).b();
                        if (i) {
                            break Label_0188;
                        }
                        break;
                    }
                    case 1: {
                        a.b(a3).b();
                        a.a(a4).b();
                        if (i) {
                            break Label_0188;
                        }
                        break;
                    }
                    case 2: {
                        a.b(a3).b();
                        a.g(a3 + 1 & 0x3);
                        a.a(a4).b();
                        if (i) {
                            break Label_0188;
                        }
                        break;
                    }
                    case 3: {
                        a.a(a3).b();
                        a.b(a4).b();
                        break;
                    }
                }
            }
            p = p.a();
            if (i) {
                break;
            }
        }
    }
    
    public void e() {
        final boolean i = y.f.c.a.i;
        final y.c.x o = this.a.o();
        do {
            Label_0013: {
                o.f();
            }
            boolean a = false;
            Label_0019:
            while (a) {
                final q e = o.e();
                Label_1360: {
                    if (this.b(e)) {
                        final y a2 = this.a(e);
                        a2.a(this.a.a((Object)e));
                        a2.a();
                        final D d = new D();
                        p p = a2.b.k();
                        Label_0077:
                    Label_1355_Outer:
                        while (p != null) {
                            final d d2 = (d)p.c();
                            d.clear();
                            final aE a3 = this.a(d2);
                            final aE b = this.b(d2);
                            final int a4 = x.a(a3.b(), 2);
                            final int a5 = x.a(b.b(), 0);
                            t t = null;
                            t t2 = null;
                            t t3 = null;
                            t t4 = null;
                            final int n = 4 + a5 - a4 & 0x3;
                            a = a3.a();
                            if (!i) {
                                Label_0357: {
                                    if (!a) {
                                        switch (n) {
                                            case 1:
                                            case 2: {
                                                final z b2 = a2.b(a4);
                                                t = b2.c(b2.a(), 0.0);
                                                break;
                                            }
                                            case 0: {
                                                final z c = a2.c(a4);
                                                t = c.c(c.a(), 0.0);
                                                break;
                                            }
                                            case 3: {
                                                final z a6 = a2.a(a4);
                                                t = a6.c(a6.a(), 0.0);
                                                break;
                                            }
                                        }
                                        this.a.c(d2, t);
                                    }
                                    else {
                                        t = this.a.p(d2);
                                        if ((a4 & 0x1) == 0x1) {
                                            t = new t(a2.c(a4).d, t.b);
                                            if (!i) {
                                                break Label_0357;
                                            }
                                        }
                                        t = new t(t.a, a2.c(a4).c);
                                    }
                                }
                                Label_0549: {
                                    if (!b.a()) {
                                        switch (n) {
                                            case 0: {
                                                final z c2 = a2.c(a5);
                                                t2 = c2.c(c2.a(), 0.0);
                                                break;
                                            }
                                            case 1:
                                            case 2: {
                                                final z a7 = a2.a(a5);
                                                t2 = a7.c(a7.a(), 0.0);
                                                break;
                                            }
                                            case 3: {
                                                final z b3 = a2.b(a5);
                                                t2 = b3.c(b3.a(), 0.0);
                                                break;
                                            }
                                        }
                                        this.a.d(d2, t2);
                                    }
                                    else {
                                        t2 = this.a.q(d2);
                                        if ((a5 & 0x1) == 0x1) {
                                            t2 = new t(a2.c(a5).d, t2.b);
                                            if (!i) {
                                                break Label_0549;
                                            }
                                        }
                                        t2 = new t(t2.a, a2.c(a5).c);
                                    }
                                }
                                switch (n) {
                                    case 0: {
                                        final z c3 = a2.c(a4);
                                        final double b4 = c3.b();
                                        c3.b(b4);
                                        t3 = new t(t.a + am.g[a4] * b4, t.b + am.h[a4] * b4);
                                        t4 = new t(t2.a + am.g[a5] * b4, t2.b + am.h[a5] * b4);
                                        break;
                                    }
                                    case 1: {
                                        final double b5 = a2.b(a4).b();
                                        t3 = new t(t.a + am.g[a4] * b5, t.b + am.h[a4] * b5);
                                        final double b6 = a2.a(a5).b();
                                        t4 = new t(t2.a + am.g[a5] * b6, t2.b + am.h[a5] * b6);
                                        if ((a4 & 0x1) == 0x0) {
                                            d.add(new t(t4.a, t3.b));
                                            if (!i) {
                                                break;
                                            }
                                        }
                                        d.add(new t(t3.a, t4.b));
                                        break;
                                    }
                                    case 2: {
                                        final int n2 = a4 + 1 & 0x3;
                                        final double b7 = a2.b(a4).b();
                                        t3 = new t(t.a + am.g[a4] * b7, t.b + am.h[a4] * b7);
                                        final double b8 = a2.a(a5).b();
                                        t4 = new t(t2.a + am.g[a5] * b8, t2.b + am.h[a5] * b8);
                                        final z a8 = a2.a(n2);
                                        final double g = a2.g(n2);
                                        if ((n2 & 0x1) == 0x0) {
                                            final double e2 = a8.e(0.0, g);
                                            d.add(new t(t3.a, e2));
                                            d.add(new t(t4.a, e2));
                                            if (!i) {
                                                break;
                                            }
                                        }
                                        final double f = a8.f(0.0, g);
                                        d.add(new t(f, t3.b));
                                        d.add(new t(f, t4.b));
                                        break;
                                    }
                                    case 3: {
                                        final double b9 = a2.a(a4).b();
                                        t3 = new t(t.a + am.g[a4] * b9, t.b + am.h[a4] * b9);
                                        final double b10 = a2.b(a5).b();
                                        t4 = new t(t2.a + am.g[a5] * b10, t2.b + am.h[a5] * b10);
                                        if ((a4 & 0x1) == 0x0) {
                                            d.add(new t(t4.a, t3.b));
                                            if (!i) {
                                                break;
                                            }
                                        }
                                        d.add(new t(t3.a, t4.b));
                                        break;
                                    }
                                }
                                d.a(t3);
                                d.b(t4);
                                final I b11 = this.a.b((Object)d2);
                                p p2 = d.k();
                                while (true) {
                                    while (p2 != null) {
                                        final t t5 = (t)p2.c();
                                        b11.addPoint(t5.a, t5.b);
                                        p2 = p2.a();
                                        if (!i) {
                                            if (i) {
                                                break;
                                            }
                                            continue Label_1355_Outer;
                                        }
                                        else {
                                            if (i) {
                                                break Label_1360;
                                            }
                                            continue Label_0077;
                                        }
                                    }
                                    p = p.a();
                                    continue;
                                }
                            }
                            continue Label_0019;
                        }
                    }
                }
                o.g();
                continue Label_0013;
            }
            break;
        } while (!i);
    }
    
    aE a(final d d) {
        final c c = this.a.c(aF.a);
        aE ae = null;
        if (c != null) {
            ae = (aE)c.b(d);
        }
        if (ae == null || ae.g()) {
            final c c2 = this.a.c(aF.b);
            if (c2 == null) {
                return aE.a((byte)1);
            }
            final aE ae2 = (aE)c2.b(d);
            if (ae2 == null || ae2.g()) {
                return aE.a((byte)1);
            }
            if (ae2.c()) {
                return aE.a((byte)8);
            }
            if (ae2.f()) {
                return aE.a((byte)1);
            }
            if (ae2.d()) {
                return aE.a((byte)4);
            }
            if (ae2.e()) {
                return aE.a((byte)2);
            }
        }
        return ae;
    }
    
    aE b(final d d) {
        final c c = this.a.c(aF.b);
        aE ae = null;
        if (c != null) {
            ae = (aE)c.b(d);
        }
        if (ae == null || ae.g()) {
            final c c2 = this.a.c(aF.a);
            if (c2 == null) {
                return aE.a((byte)8);
            }
            final aE ae2 = (aE)c2.b(d);
            if (ae2 == null || ae2.g()) {
                return aE.a((byte)8);
            }
            if (ae2.c()) {
                return aE.a((byte)8);
            }
            if (ae2.f()) {
                return aE.a((byte)1);
            }
            if (ae2.d()) {
                return aE.a((byte)4);
            }
            if (ae2.e()) {
                return aE.a((byte)2);
            }
        }
        return ae;
    }
    
    public void b(final double i) {
        this.i = i;
    }
    
    static {
        g = new double[] { 0.0, 1.0, 0.0, -1.0 };
        h = new double[] { -1.0, 0.0, 1.0, 0.0 };
    }
}
