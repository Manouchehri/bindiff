package y.f.c.a;

import java.util.*;
import y.c.*;
import y.f.*;
import y.d.*;

class cd
{
    private f a;
    private double b;
    private double c;
    private Map d;
    
    public cd() {
        this.b = 15.0;
        this.c = 10.0;
        this.d = new HashMap();
        this.a = new f();
    }
    
    public void a(final X x) {
        final boolean x2 = N.x;
        final e p = x.p();
        while (p.f()) {
            final d a = p.a();
            if (a.e()) {
                this.a(x, a);
            }
            p.g();
            if (x2) {
                break;
            }
        }
    }
    
    public void a(final X x, final d d) {
        if (x.f(d)) {
            x.d(d);
        }
        this.a.add(d);
    }
    
    public void b(final X x, final d d) {
        if (!x.f(d)) {
            x.e(d);
        }
    }
    
    public void b(final X x) {
        final boolean x2 = N.x;
        p p = this.a.k();
        while (p != null) {
            this.b(x, (d)p.c());
            p = p.a();
            if (x2) {
                break;
            }
        }
    }
    
    public cD a(final X x, final q q) {
        cD cd = this.d.get(q);
        if (cd == null) {
            cd = new cD(new cb(x.a((Object)q)));
            this.d.put(q, cd);
        }
        return cd;
    }
    
    public boolean a(final q q) {
        return this.d.containsKey(q);
    }
    
    public void a(final X x, final aV av) {
        final boolean x2 = N.x;
        p p2 = this.a.k();
        while (p2 != null) {
            final d d = (d)p2.c();
            final boolean f = x.f(d);
            if (!f) {
                x.e(d);
            }
            final cD a = this.a(x, d.c());
            a.a(d);
            final aE a2 = a(x, av, d);
            final aE b = b(x, av, d);
            final boolean b2 = !a2.a();
            final boolean b3 = !b.a();
            final int a3 = bY.a(a2.b(), 2);
            final int a4 = bY.a(b.b(), 0);
            final int n = 4 + a4 - a3 & 0x3;
            if (b2 || b3) {
                if (b2) {
                    Label_0230: {
                        switch (n) {
                            case 0: {
                                a.b(a3).a(d);
                                if (x2) {
                                    break Label_0230;
                                }
                                break;
                            }
                            case 3: {
                                a.a(a3).a(d);
                                if (x2) {
                                    break Label_0230;
                                }
                                break;
                            }
                            case 1:
                            case 2: {
                                a.c(a3).a(d);
                                break;
                            }
                        }
                    }
                }
                if (b3) {
                    Label_0318: {
                        switch (n) {
                            case 0: {
                                a.b(a4).a(d);
                                if (x2) {
                                    break Label_0318;
                                }
                                break;
                            }
                            case 1:
                            case 2: {
                                a.a(a4).a(d);
                                if (x2) {
                                    break Label_0318;
                                }
                                break;
                            }
                            case 3: {
                                a.c(a4).a(d);
                                break;
                            }
                        }
                    }
                }
            }
            if (!f) {
                x.d(d);
            }
            p2 = p2.a();
            if (x2) {
                break;
            }
        }
    }
    
    public void a(final X x, final aU au, final aV av) {
        final boolean x2 = N.x;
        final ce ce = new ce(this, x, av);
        final cf cf = new cf(this, x, av);
        final cg cg = new cg(this, av);
        final ch ch = new ch(this, av);
        final ci ci = new ci(this, av);
        final cj cj = new cj(this, av);
        final ck ck = new ck(this, av);
        final cl cl = new cl(this, av);
        x.a(bu.f, ci);
        x.a(bu.e, ch);
        x.a(bu.a, cj);
        x.a(bu.d, cg);
        x.a(bu.b, ck);
        x.a(bu.c, cl);
        try {
            final y.d.c[] array = new y.d.c[4];
            final bu bu = new bu(this.b, this.c);
            final cm cm = new cm(x, av);
            int n = 0;
            do {
                int i = 0;
            Label_0188:
                while (i < au.b()) {
                    p p3 = au.a(n).d().k();
                    while (p3 != null) {
                        final q q = (q)p3.c();
                        final am a = x.a((Object)q);
                        i = (this.a(q) ? 1 : 0);
                        if (x2) {
                            continue Label_0188;
                        }
                        Label_0960: {
                            if (i != 0) {
                                final cD a2 = this.a(x, q);
                                a2.a().sort(cm);
                                if (a2.a().size() >= 1) {
                                    final double x3 = a.getX();
                                    final double y = a.getY();
                                    a.setLocation(0.0, 0.0);
                                    final aX a3 = av.a(q);
                                    Label_0403: {
                                        Label_0375: {
                                            if (a3.b() == 0) {
                                                int j = 0;
                                                while (j < 4) {
                                                    array[j] = a3.a(j, a);
                                                    ++j;
                                                    if (x2) {
                                                        break Label_0960;
                                                    }
                                                    if (x2) {
                                                        break Label_0375;
                                                    }
                                                }
                                                break Label_0403;
                                            }
                                        }
                                        int k = 0;
                                        while (k < 4) {
                                            array[k] = null;
                                            ++k;
                                            if (x2) {
                                                break Label_0960;
                                            }
                                            if (x2) {
                                                break;
                                            }
                                        }
                                    }
                                    p p4 = a2.b();
                                    while (p4 != null) {
                                        final d d = (d)p4.c();
                                        final boolean f = x.f(d);
                                        if (x2) {
                                            continue Label_0188;
                                        }
                                        if (!f) {
                                            x.e(d);
                                        }
                                        final aE a4 = a(x, av, d);
                                        final aE b = b(x, av, d);
                                        final int a5 = bY.a(a4.b(), 2);
                                        final int a6 = bY.a(b.b(), 0);
                                        t t = null;
                                        t t2 = null;
                                        final int n2 = 4 + a6 - a5 & 0x3;
                                        if (!a4.a()) {
                                            switch (n2) {
                                                case 1:
                                                case 2: {
                                                    final df c = a2.c(a5);
                                                    t = c.d(c.c(), 0.0);
                                                    break;
                                                }
                                                case 0: {
                                                    final df b2 = a2.b(a5);
                                                    t = b2.d(b2.c(), 0.0);
                                                    break;
                                                }
                                                case 3: {
                                                    final df a7 = a2.a(a5);
                                                    t = a7.d(a7.c(), 0.0);
                                                    break;
                                                }
                                            }
                                            x.c(d, t);
                                        }
                                        if (!b.a()) {
                                            switch (n2) {
                                                case 0: {
                                                    final df b3 = a2.b(a6);
                                                    t2 = b3.d(b3.c(), 0.0);
                                                    break;
                                                }
                                                case 1:
                                                case 2: {
                                                    final df a8 = a2.a(a6);
                                                    t2 = a8.d(a8.c(), 0.0);
                                                    break;
                                                }
                                                case 3: {
                                                    final df c2 = a2.c(a6);
                                                    t2 = c2.d(c2.c(), 0.0);
                                                    break;
                                                }
                                            }
                                            x.d(d, t2);
                                        }
                                        if (!f) {
                                            x.d(d);
                                        }
                                        p4 = p4.a();
                                        if (x2) {
                                            break;
                                        }
                                    }
                                    bu.a(x, q, a2.b(), ce, cf, array);
                                    p p5 = a2.b();
                                Label_0937_Outer:
                                    while (p5 != null) {
                                        final d d2 = (d)p5.c();
                                        final I b4 = x.b((Object)d2);
                                        t p6 = x.p(d2);
                                        final int n3 = 0;
                                        if (!x2) {
                                            int l = n3;
                                            while (true) {
                                                while (l < b4.pointCount()) {
                                                    final t point = b4.getPoint(l);
                                                    a(array, p6, point);
                                                    p6 = point;
                                                    ++l;
                                                    if (!x2) {
                                                        if (x2) {
                                                            break;
                                                        }
                                                        continue Label_0937_Outer;
                                                    }
                                                    else {
                                                        if (x2) {
                                                            break Label_0937_Outer;
                                                        }
                                                        continue Label_0937_Outer;
                                                    }
                                                }
                                                a(array, p6, x.q(d2));
                                                a(array, x, d2);
                                                p5 = p5.a();
                                                continue;
                                            }
                                        }
                                        continue Label_0188;
                                    }
                                    a.setLocation(x3, y);
                                }
                            }
                            p3 = p3.a();
                        }
                        if (x2) {
                            break;
                        }
                    }
                    ++n;
                }
                break;
            } while (!x2);
        }
        finally {
            x.d_(bu.f);
            x.d_(bu.e);
            x.d_(bu.a);
            x.d_(bu.d);
            x.d_(bu.b);
            x.d_(bu.c);
        }
    }
    
    private static final void a(final y.d.c[] array, final t t, final t t2) {
        final double min = Math.min(t.a, t2.a);
        final double max = Math.max(t.a, t2.a);
        final double min2 = Math.min(t.b, t2.b);
        final double max2 = Math.max(t.b, t2.b);
        if (max - min > max2 - min2) {
            if (array[0] != null) {
                array[0].a(min, max, min2);
            }
            if (array[2] == null) {
                return;
            }
            array[2].b(min, max, max2);
            if (!N.x) {
                return;
            }
        }
        if (array[3] != null) {
            array[3].a(min2, max2, min);
        }
        if (array[1] != null) {
            array[1].b(min2, max2, max);
        }
    }
    
    private static void a(final y.d.c[] array, final X x, final d d) {
        final boolean x2 = N.x;
        final v l = x.l(d);
        final cB b = cB.b((i)x);
        final S[] a = b.a(x, d);
        if (a != null) {
            int n = 0;
            do {
                int i = 0;
            Label_0036:
                while (i < a.length) {
                    final S s = a[n];
                    final aG f = s.f();
                    final boolean a2 = b.a(d, l);
                    if (f.i() || f.j()) {
                        for (int j = 1; j < l.i() - 1; ++j) {
                            final m a3 = l.a(j);
                            i = (a3.b() ? 1 : 0);
                            if (x2) {
                                continue Label_0036;
                            }
                            if ((i != 0 && a2) || (a3.a() && !a2)) {
                                a(array, s, f, a3);
                                if (!x2) {
                                    break;
                                }
                            }
                        }
                    }
                    else {
                        int k = l.i() - 2;
                        while (k > 0) {
                            final m a4 = l.a(k);
                            final boolean b2 = a4.b();
                            if (x2) {
                                continue Label_0036;
                            }
                            if ((b2 && a2) || (a4.a() && !a2)) {
                                a(array, s, f, a4);
                                if (!x2) {
                                    break;
                                }
                            }
                            --k;
                            if (x2) {
                                break;
                            }
                        }
                    }
                    ++n;
                }
                break;
            } while (!x2);
        }
    }
    
    private static void a(final y.d.c[] array, final S s, final aG ag, final m m) {
        final boolean x = N.x;
        if (m == null) {
            return;
        }
        final t c = m.c();
        final t d = m.d();
        final boolean b = c.a() < d.a();
        final boolean b2 = c.b() < d.b();
        if (ag.m()) {
            if (m.b()) {
                final double c2 = s.c();
                final double abs = Math.abs(m.j());
                if (b) {
                    a(array, c.a(), c.b() - c2 * 0.5, abs, c2);
                    if (!x) {
                        return;
                    }
                }
                a(array, d.a(), d.b() - c2 * 0.5, abs, abs);
                if (!x) {
                    return;
                }
            }
            final double b3 = s.b();
            final double abs2 = Math.abs(m.k());
            if (b2) {
                a(array, c.a() - b3 * 0.5, c.b(), b3, abs2);
                if (!x) {
                    return;
                }
            }
            a(array, d.a() - b3 * 0.5, d.b(), b3, abs2);
            if (!x) {
                return;
            }
        }
        final double max = Math.max(0.0, ag.h());
        if (m.b()) {
            final double n = s.c() + max;
            final double abs3 = Math.abs(m.j());
            if (ag.l()) {
                if (b) {
                    a(array, c.a(), c.b() - n, abs3, n);
                    if (!x) {
                        return;
                    }
                }
                a(array, d.a(), d.b(), abs3, n);
                if (!x) {
                    return;
                }
            }
            if (b) {
                a(array, c.a(), c.b(), abs3, n);
                if (!x) {
                    return;
                }
            }
            a(array, d.a(), d.b() - n, abs3, n);
            if (!x) {
                return;
            }
        }
        final double abs4 = Math.abs(m.k());
        final double n2 = s.b() + max;
        if (ag.l()) {
            if (b2) {
                a(array, c.a(), c.b(), n2, abs4);
                if (!x) {
                    return;
                }
            }
            a(array, d.a() - n2, d.b(), n2, abs4);
            if (!x) {
                return;
            }
        }
        if (ag.n()) {
            if (b2) {
                a(array, c.a() - n2, c.b(), n2, abs4);
                if (!x) {
                    return;
                }
            }
            a(array, d.a(), d.b(), n2, abs4);
        }
    }
    
    private static void a(final y.d.c[] array, final double n, final double n2, final double n3, final double n4) {
        if (array[0] != null) {
            array[0].a(n, n + n3, n2);
        }
        if (array[1] != null) {
            array[1].b(n2, n2 + n4, n + n3);
        }
        if (array[2] != null) {
            array[2].b(n, n + n3, n2 + n4);
        }
        if (array[3] != null) {
            array[3].a(n2, n2 + n4, n);
        }
    }
    
    public void b(final X x, final aU au, final aV av) {
        final boolean x2 = N.x;
        p p3 = this.a.k();
        while (p3 != null) {
            final d d = (d)p3.c();
            Label_0146: {
                if (x.f(d)) {
                    final I b = x.b((Object)d);
                    final am a = x.a((Object)d.c());
                    final double x3 = a.getX();
                    final double y = a.getY();
                    int i = 0;
                    while (i < b.pointCount()) {
                        final t point = b.getPoint(i);
                        b.setPoint(i, point.a + x3, point.b + y);
                        ++i;
                        if (x2) {
                            break Label_0146;
                        }
                        if (x2) {
                            break;
                        }
                    }
                }
                p3 = p3.a();
            }
            if (x2) {
                break;
            }
        }
    }
    
    static final aE a(final X x, final aV av, final d d) {
        final aE c = av.a(d).c();
        if (c == null || c.g()) {
            final aE e = av.a(d).e();
            if (e == null || e.g()) {
                return aE.a((byte)1);
            }
            if (e.c()) {
                return aE.a((byte)8);
            }
            if (e.f()) {
                return aE.a((byte)1);
            }
            if (e.d()) {
                return aE.a((byte)4);
            }
            if (e.e()) {
                return aE.a((byte)2);
            }
        }
        return c;
    }
    
    static final aE b(final X x, final aV av, final d d) {
        final aE e = av.a(d).e();
        if (e == null || e.g()) {
            final aE c = av.a(d).c();
            if (c == null || c.g()) {
                return aE.a((byte)8);
            }
            if (c.c()) {
                return aE.a((byte)8);
            }
            if (c.f()) {
                return aE.a((byte)1);
            }
            if (c.d()) {
                return aE.a((byte)4);
            }
            if (c.e()) {
                return aE.a((byte)2);
            }
        }
        return e;
    }
    
    static double a(final cd cd) {
        return cd.b;
    }
    
    static double b(final cd cd) {
        return cd.c;
    }
}
