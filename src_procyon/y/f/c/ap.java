package y.f.c;

import y.c.*;
import y.g.*;
import y.f.i.*;
import java.util.*;
import y.d.*;
import y.f.*;

class ap
{
    private Map b;
    private f c;
    private y d;
    private X e;
    private A f;
    private A g;
    private A h;
    private A i;
    private A j;
    private Map k;
    private as l;
    private D m;
    double a;
    private A n;
    private h o;
    private c p;
    private c q;
    private double r;
    private h s;
    private h t;
    private boolean u;
    
    ap(final X e, final A j, final A f, final D m, final A g, final h h, final h s, final h t) {
        this.b = new HashMap();
        this.a = 20.0;
        this.u = false;
        this.j = j;
        this.e = e;
        this.m = m;
        this.f = f;
        this.g = g;
        this.s = s;
        this.t = t;
    }
    
    public void a(final boolean u) {
        this.u = u;
    }
    
    public void a(final A n, final c p4, final h o, final c q) {
        this.n = n;
        this.o = o;
        this.p = p4;
        this.q = q;
    }
    
    public void a(final double a) {
        this.a = a;
    }
    
    public boolean a() {
        return this.c != null && this.c.size() > 0;
    }
    
    public void b() {
        final boolean i = y.f.c.a.i;
        this.c = new f();
        final e p = this.e.p();
        while (p.f()) {
            final d a = p.a();
            if (this.f.a(a.c()) == this.f.a(a.d())) {
                this.c.c(a);
                this.e.d(a);
            }
            p.g();
            if (i) {
                break;
            }
        }
    }
    
    public void c() {
        final boolean i = y.f.c.a.i;
        if (!this.a()) {
            return;
        }
        p p = this.c.k();
        while (p != null) {
            this.e.e((d)p.c());
            this.e.b(p.c()).clearPoints();
            p = p.a();
            if (i) {
                break;
            }
        }
    }
    
    public f d() {
        return this.c;
    }
    
    public int a(int n) {
        final boolean i = y.f.c.a.i;
        if (!this.a()) {
            return n;
        }
        this.d = new y();
        int min = 0;
        int max = n - 1;
        p p = this.c.k();
    Label_0510:
        while (true) {
        Label_0513:
            while (true) {
                while (p != null) {
                    final d d = (d)p.c();
                    final aE a = this.a(d);
                    final aE b = this.b(d);
                    final q c = d.c();
                    final q d2 = d.d();
                    this.a(a, b);
                    final q d3 = this.e.d();
                    if (i) {
                        int j = 1;
                        while (this.m.size() < n) {
                            this.m.b(am.a("LowerSameLayerEdgeLayer", new Integer(j++)));
                            if (i) {
                                break;
                            }
                        }
                        return n;
                    }
                    if (this.n != null) {
                        this.n.a(d3, am.a("LowerSameLayerEdgeSupport", this.q.b(d)));
                    }
                    this.j.a(d3, K.t);
                    this.e.b(d3, 1.0, 1.0);
                    final int a2 = this.f.a(c);
                    this.f.a(d3, a2 + 1);
                    this.e.a(c, d3);
                    this.e.a(d2, d3);
                    this.d.add(d3);
                    final q d4 = this.e.d();
                    this.j.a(d4, K.t);
                    if (this.n != null) {
                        this.n.a(d4, am.a("UpperSameLayerEdgeSupport", this.q.b(d)));
                    }
                    this.e.b(d4, 1.0, 1.0);
                    this.f.a(d4, a2 - 1);
                    this.e.a(d4, c);
                    this.e.a(d4, d2);
                    this.d.add(d4);
                    min = Math.min(min, a2 - 1);
                    max = Math.max(max, a2 + 1);
                    p = p.a();
                    if (i) {
                        break;
                    }
                }
                if (min < 0) {
                    int j = -1;
                    while (j >= min) {
                        this.m.a(am.a("UpperSameLayerEdgeLayer", new Integer(-j)));
                        --j;
                        if (i) {
                            continue Label_0513;
                        }
                        if (i) {
                            break;
                        }
                    }
                    final x o = this.e.o();
                    while (o.f()) {
                        this.f.a(o.e(), this.f.a(o.e()) - min);
                        o.g();
                        if (i) {
                            continue Label_0510;
                        }
                        if (i) {
                            break;
                        }
                    }
                    max -= min;
                }
                break;
            }
            n = max + 1;
            continue Label_0510;
        }
    }
    
    private boolean a(final aE ae, final aE ae2) {
        return ae.d() || ((ae.e() || ae.f() || ae.g()) && ae2.d());
    }
    
    aE a(final d d) {
        if (this.s != null) {
            final aE ae = (aE)this.s.b(d);
            return (ae == null) ? aE.a((byte)0, false) : ae;
        }
        final c c = this.e.c(aF.a);
        if (c == null) {
            return aE.a((byte)0, false);
        }
        final aE ae2 = (aE)c.b(d);
        return (ae2 == null) ? aE.a((byte)0, false) : ae2;
    }
    
    aE b(final d d) {
        if (this.t != null) {
            final aE ae = (aE)this.t.b(d);
            return (ae == null) ? aE.a((byte)0, false) : ae;
        }
        final c c = this.e.c(aF.b);
        if (c == null) {
            return aE.a((byte)0, false);
        }
        final aE ae2 = (aE)c.b(d);
        return (ae2 == null) ? aE.a((byte)0, false) : ae2;
    }
    
    public void a(final D d) {
        final boolean i = y.f.c.a.i;
        if (!this.a()) {
            return;
        }
        Label_0318: {
            if (this.d != null && !this.d.isEmpty()) {
                p p = this.d.k();
                while (true) {
                Label_0160_Outer:
                    while (p != null) {
                        this.e.a((q)p.c());
                        p = p.a();
                        if (i) {
                            while (true) {
                                while (p != null) {
                                    final y y = (y)p.c();
                                    final Object o;
                                    final p p2 = (p)(o = y.k());
                                    boolean f = false;
                                    Label_0166: {
                                        if (!i) {
                                            p a = p2;
                                            while (a != null) {
                                                f = this.e.f((q)a.c());
                                                if (i) {
                                                    break Label_0166;
                                                }
                                                if (!f) {
                                                    y.h(a);
                                                }
                                                a = a.a();
                                                if (i) {
                                                    break;
                                                }
                                            }
                                            p = p.a();
                                            if (i) {
                                                break;
                                            }
                                            continue Label_0160_Outer;
                                        }
                                        else {
                                            ((D)o).isEmpty();
                                        }
                                    }
                                    if (f) {
                                        d.h(d.l());
                                        this.m.h(this.m.l());
                                    }
                                    if (((D)d.f()).isEmpty()) {
                                        d.h(d.k());
                                        this.m.h(this.m.k());
                                        int n = 0;
                                        p p3 = d.k();
                                    Label_0237:
                                        while (p3 != null) {
                                            final y y2 = (y)p3.c();
                                            final Integer n2 = new Integer(n);
                                            p p4 = y2.k();
                                            while (true) {
                                                while (p4 != null) {
                                                    this.f.a(p4.c(), n2);
                                                    p4 = p4.a();
                                                    if (!i) {
                                                        if (i) {
                                                            break;
                                                        }
                                                        continue Label_0160_Outer;
                                                    }
                                                    else {
                                                        if (i) {
                                                            break Label_0318;
                                                        }
                                                        continue Label_0237;
                                                    }
                                                }
                                                p3 = p3.a();
                                                ++n;
                                                continue;
                                            }
                                        }
                                    }
                                    return;
                                }
                                Object o = d.i();
                                continue;
                            }
                        }
                        if (i) {
                            break;
                        }
                    }
                    p = d.k();
                    continue;
                }
            }
        }
    }
    
    void b(final D d) {
        final boolean i = y.f.c.a.i;
        if (!this.a()) {
            return;
        }
        this.i = this.e.t();
        final A a = M.a(new q[this.e.e()]);
        final A a2 = M.a(new int[this.e.e()]);
        p p = d.k();
    Label_0057:
        while (true) {
            y y;
            int n;
            p k;
            p a3;
            p p2;
            x a4;
            int f;
            int n2;
            q q;
            Object b;
            q e;
            Object b2;
            d d2;
            aE a5;
            aE b3;
            boolean a6;
            ar ar;
            ar ar2;
            boolean b4;
            boolean b5;
            boolean b6;
            int n3;
            int n4;
            q q2;
            q q3;
            boolean b7;
            int n5;
            int n6;
            int[] c;
            int n7;
            int[] d3;
            int n8;
            int[] c2;
            int n9;
            int[] d4;
            int n10;
            int n11;
            p p3;
            Object c3;
            y y2;
            p p4;
            q q4;
            q q5;
            ar b8;
            y y3;
            f l;
            q d5;
            int size;
            Label_0132_Outer:Label_0353_Outer:
            while (p != null) {
                y = (y)p.c();
                n = 0;
                k = y.k();
                if (!i) {
                    a3 = k;
                    while (true) {
                        while (a3 != null) {
                            a2.a(a3.c(), n);
                            a3 = a3.a();
                            ++n;
                            if (!i) {
                                if (i) {
                                    break;
                                }
                                continue Label_0132_Outer;
                            }
                            else {
                                if (i) {
                                    break Label_0132_Outer;
                                }
                                continue Label_0057;
                            }
                        }
                        p = p.a();
                        continue Label_0353_Outer;
                    }
                }
                p2 = k;
                while (true) {
                Label_0363_Outer:
                    while (p2 != null) {
                        a4 = ((y)p2.c()).a();
                        n2 = (f = (a4.f() ? 1 : 0));
                        Label_1530: {
                            if (!i) {
                                Label_0332: {
                                    if (n2 != 0) {
                                        q = a4.e();
                                    Label_0363:
                                        while (true) {
                                            while (a4.f()) {
                                                q = a4.e();
                                                b = this.g.b(q);
                                                if (i) {
                                                    break Label_0363;
                                                }
                                                if (b == null) {
                                                    break;
                                                }
                                                a4.g();
                                                if (i) {
                                                    break;
                                                }
                                            }
                                            if (!a4.f()) {
                                                break Label_0332;
                                            }
                                            a4.g();
                                            while (a4.f()) {
                                                e = a4.e();
                                                b2 = this.g.b(e);
                                                if (i) {
                                                    break Label_0363;
                                                }
                                                if (b2 == null) {
                                                    a.a(e, q);
                                                    q = e;
                                                }
                                                a4.g();
                                                if (i) {
                                                    break;
                                                }
                                            }
                                            break Label_0332;
                                            d2 = (d)b;
                                            a5 = this.a(d2);
                                            b3 = this.b(d2);
                                            a6 = this.a(a5, b3);
                                            ar = (ar)this.i.b(d2.c());
                                            if (!i) {
                                                if (ar == null) {
                                                    ar = new ar(this.e.a((Object)d2.c()));
                                                    this.i.a(d2.c(), ar);
                                                }
                                                ar2 = (ar)this.i.b(d2.d());
                                                if (ar2 == null) {
                                                    ar2 = new ar(this.e.a((Object)d2.d()));
                                                    this.i.a(d2.d(), ar2);
                                                }
                                                b4 = (a.b(d2.c()) == d2.d() || a.b(d2.d()) == d2.c());
                                                b5 = (a2.a(d2.c()) < a2.a(d2.d()));
                                                Label_0702: {
                                                    if (b5) {
                                                        b6 = (b4 && (a5.b() == 0 || a5.b() == 4) && (b3.b() == 0 || b3.b() == 8));
                                                        if (!i) {
                                                            break Label_0702;
                                                        }
                                                    }
                                                    b6 = (b4 && (a5.b() == 0 || a5.b() == 8) && (b3.b() == 0 || b3.b() == 4));
                                                }
                                                Label_1319: {
                                                    Label_1243: {
                                                        if ((this.u && !b4 && this.s != null && this.t != null && (a5.b() == 0 || b3.b() == 0)) || ((a5.b() == 4 || a5.b() == 8) && (b3.b() == 4 || b3.b() == 8))) {
                                                            n3 = 0;
                                                            n4 = 0;
                                                            while (true) {
                                                                Label_0873: {
                                                                    if (!b5) {
                                                                        break Label_0873;
                                                                    }
                                                                    Label_0830: {
                                                                        if (b3.b() == 4) {
                                                                            q2 = d2.d();
                                                                            if (!i) {
                                                                                break Label_0830;
                                                                            }
                                                                        }
                                                                        q2 = (q)a.b(d2.d());
                                                                    }
                                                                    if (a5.b() == 8) {
                                                                        q3 = (q)a.b(d2.c());
                                                                        if (!i) {
                                                                            break Label_0948;
                                                                        }
                                                                    }
                                                                    q3 = d2.c();
                                                                    if (i) {
                                                                        break Label_0873;
                                                                    }
                                                                Label_1010_Outer:
                                                                    while (true) {
                                                                        while (true) {
                                                                            while (q2 != q3) {
                                                                                n3 += q2.b();
                                                                                n4 += q2.c();
                                                                                q2 = (q)a.b(q2);
                                                                                if (!i) {
                                                                                    if (i) {
                                                                                        break;
                                                                                    }
                                                                                    continue Label_0363_Outer;
                                                                                }
                                                                                else {
                                                                                    b7 = false;
                                                                                    a6 = b7;
                                                                                    Label_1122: {
                                                                                        if (a5.b() == 0) {
                                                                                            if (n4 == n3) {
                                                                                                a6 = (b3.b() == 2);
                                                                                            }
                                                                                            n5 = (a6 ? 2 : 0);
                                                                                            this.s.a(d2, aE.a((byte)(a6 ? 2 : 1)));
                                                                                            if (!i) {
                                                                                                break Label_1122;
                                                                                            }
                                                                                        }
                                                                                        n5 = y.f.c.x.a(a5.b(), b6 ? (b5 ? 1 : 3) : (a6 ? 2 : 0));
                                                                                    }
                                                                                    if (b3.b() == 0) {
                                                                                        Label_1159: {
                                                                                            if (a5.b() == 1) {
                                                                                                a6 = false;
                                                                                                if (!i) {
                                                                                                    break Label_1159;
                                                                                                }
                                                                                            }
                                                                                            if (a5.b() == 2) {
                                                                                                a6 = true;
                                                                                            }
                                                                                        }
                                                                                        n6 = (a6 ? 2 : 0);
                                                                                        this.t.a(d2, aE.a((byte)(a6 ? 2 : 1)));
                                                                                        if (!i) {
                                                                                            break Label_1319;
                                                                                        }
                                                                                    }
                                                                                    n6 = y.f.c.x.a(b3.b(), b6 ? (b5 ? 3 : 1) : (a6 ? 2 : 0));
                                                                                    if (i) {
                                                                                        break Label_1243;
                                                                                    }
                                                                                    break Label_1319;
                                                                                }
                                                                            }
                                                                            if (n4 < n3) {
                                                                                b7 = true;
                                                                                continue Label_0353_Outer;
                                                                            }
                                                                            break;
                                                                        }
                                                                        continue Label_1010_Outer;
                                                                    }
                                                                }
                                                                Label_0910: {
                                                                    if (a5.b() == 4) {
                                                                        q2 = d2.c();
                                                                        if (!i) {
                                                                            break Label_0910;
                                                                        }
                                                                    }
                                                                    q2 = (q)a.b(d2.c());
                                                                }
                                                                if (b3.b() == 8) {
                                                                    q3 = (q)a.b(d2.d());
                                                                    if (!i) {
                                                                        continue Label_0353_Outer;
                                                                    }
                                                                }
                                                                q3 = d2.d();
                                                                continue Label_0353_Outer;
                                                            }
                                                        }
                                                    }
                                                    n5 = y.f.c.x.a(a5.b(), b6 ? (b5 ? 1 : 3) : (a6 ? 2 : 0));
                                                    n6 = y.f.c.x.a(b3.b(), b6 ? (b5 ? 3 : 1) : (a6 ? 2 : 0));
                                                }
                                                Label_1421: {
                                                    if ((n5 ^ n6) == 0x2 && (n5 | n6) == 0x2) {
                                                        if (b5) {
                                                            c = ar2.c;
                                                            n7 = 1;
                                                            ++c[n7];
                                                            d3 = ar2.d;
                                                            n8 = ((n6 == 0) ? 0 : 3);
                                                            ++d3[n8];
                                                            if (!i) {
                                                                break Label_1421;
                                                            }
                                                        }
                                                        c2 = ar2.c;
                                                        n9 = 0;
                                                        ++c2[n9];
                                                        d4 = ar2.d;
                                                        n10 = ((n6 == 0) ? 1 : 2);
                                                        ++d4[n10];
                                                    }
                                                }
                                                this.a(ar, d2, n5, b6 && (n5 & 0x1) == 0x1, a6, !b5);
                                                this.a(ar2, d2, n6, b6 && (n6 & 0x1) == 0x1, a6, b5);
                                                p2 = p2.a();
                                                if (!i) {
                                                    if (p2 != null) {
                                                        p2.c();
                                                        continue Label_0363;
                                                    }
                                                }
                                                this.l = new as(this, a2);
                                                this.h = this.e.t();
                                            }
                                            break;
                                        }
                                        f = 0;
                                        break Label_1530;
                                    }
                                }
                                p2 = p2.a();
                                if (i) {
                                    break;
                                }
                                continue Label_0353_Outer;
                            }
                        }
                        n11 = f;
                        p3 = d.k();
                        while (p3 != null) {
                            c3 = p3.c();
                        Label_1548:
                            while (true) {
                                y2 = (y)c3;
                                p4 = y2.k().a();
                                while (p4 != null) {
                                    q4 = (q)p4.c();
                                    q5 = (q)p4.b().c();
                                    b8 = this.b(q4);
                                    this.b(q5);
                                    y3 = (y)(c3 = b8);
                                    if (i) {
                                        continue Label_1548;
                                    }
                                    if (y3 != null) {
                                        l = b8.c(3).l;
                                        if (l.size() > 0) {
                                            d5 = this.e.d();
                                            b8.e[1] = d5;
                                            size = l.size();
                                            this.f.a(d5, n11);
                                            y2.a(d5, p4);
                                            this.e.b(d5, 2.0 * this.a + this.a * (size - 1) + this.a(l), 0.5);
                                            this.h.a(d5, true);
                                        }
                                    }
                                    p4 = p4.a();
                                    if (i) {
                                        break;
                                    }
                                }
                                break;
                            }
                            p3 = p3.a();
                            ++n11;
                            if (i) {
                                break;
                            }
                        }
                        return;
                    }
                    p2 = this.c.k();
                    continue;
                }
            }
            d.k();
            continue;
        }
    }
    
    void a(final q q, final ar ar) {
        this.l.a(q, 0);
        ar.a(0).l.sort(this.l);
        this.l.a(q, 2);
        ar.b(0).l.sort(this.l);
        this.l.a(q, 3);
        ar.a(1).l.sort(this.l);
        this.l.a(q, 5);
        ar.b(1).l.sort(this.l);
        this.l.a(q, 6);
        ar.a(2).l.sort(this.l);
        this.l.a(q, 8);
        ar.b(2).l.sort(this.l);
        this.l.a(q, 9);
        ar.a(3).l.sort(this.l);
        this.l.a(q, 11);
        ar.b(3).l.sort(this.l);
        ar.c(3).l.n();
    }
    
    private void a(final ar ar, final d d, final int n, final boolean b, final boolean b2, final boolean b3) {
        final boolean i = y.f.c.a.i;
        if (b) {
            ar.c(n).l.add(d);
            if (!i) {
                return;
            }
        }
        Label_0183: {
            switch (n) {
                case 0: {
                    if (b3) {
                        ar.a(0).l.add(d);
                        if (!i) {
                            break;
                        }
                    }
                    ar.b(0).l.add(d);
                    if (i) {
                        break Label_0183;
                    }
                    break;
                }
                case 1: {
                    if (b2) {
                        ar.b(1).l.add(d);
                        if (!i) {
                            break;
                        }
                    }
                    ar.a(1).l.add(d);
                    if (i) {
                        break Label_0183;
                    }
                    break;
                }
                case 2: {
                    if (b3) {
                        ar.b(2).l.add(d);
                        if (!i) {
                            break;
                        }
                    }
                    ar.a(2).l.add(d);
                    if (i) {
                        break Label_0183;
                    }
                    break;
                }
                case 3: {
                    if (b2) {
                        ar.a(3).l.add(d);
                        if (!i) {
                            break;
                        }
                    }
                    ar.b(3).l.add(d);
                    break;
                }
            }
        }
    }
    
    private double a(final f f) {
        final boolean i = y.f.c.a.i;
        double n = 0.0;
        final e a = f.a();
        double max = 0.0;
        while (a.f()) {
            max = Math.max(n, this.c(a.a()));
            if (i) {
                return max;
            }
            n = max;
            a.g();
            if (i) {
                break;
            }
        }
        return max;
    }
    
    private double c(final d d) {
        final boolean i = y.f.c.a.i;
        final S[] d2 = this.d(d);
        if (d2 == null || d2.length == 0) {
            return 0.0;
        }
        double n = 0.0;
        int j = 0;
        while (j < d2.length) {
            n += d2[j].a().e();
            ++j;
            if (i) {
                return n;
            }
            if (i) {
                break;
            }
        }
        n += 10 * (d2.length - 1);
        return n;
    }
    
    private S[] d(final d d) {
        final c c = this.e.c(U.a);
        if (c == null) {
            return null;
        }
        return (S[])c.b(d);
    }
    
    boolean a(final q q) {
        return this.i != null && this.i.b(q) != null;
    }
    
    ar b(final q q) {
        return (this.i != null) ? ((ar)this.i.b(q)) : null;
    }
    
    private aq e(final d d) {
        aq aq = this.k.get(d);
        if (aq == null) {
            aq = new aq();
            this.k.put(d, aq);
        }
        return aq;
    }
    
    public void c(final D d) {
        final boolean i = y.f.c.a.i;
        if (!this.a()) {
            return;
        }
        this.k = new HashMap();
        final b b = new b(0.0, 0.0);
        final b b2 = new b(0.0, 0.0);
        p p = d.k();
    Label_0713_Outer:
        while (p != null) {
            Object c = p.c();
            C c2 = null;
        Label_0060:
            while (true) {
                c2 = (C)c;
                final y a = c2.a;
                b.a(c2.b - 100000.0, c2.b - 90000.0, (byte)1);
                b2.a(c2.c + 90000.0, c2.c + 100000.0, (byte)1);
                final HashMap hashMap = new HashMap();
                p p2 = a.k();
                while (p2 != null) {
                    final q q = (q)p2.c();
                    final ar b3 = this.b(q);
                    final C c3 = (C)(c = b3);
                    if (i) {
                        continue Label_0060;
                    }
                    if (c3 != null) {
                        b3.a(this.e.a((Object)q));
                        this.b(q, b3.a(1), hashMap);
                        this.b(q, b3.b(1), hashMap);
                        this.b(q, b3.a(3), hashMap);
                        this.b(q, b3.b(3), hashMap);
                        this.a(q, b3.a(0), hashMap);
                        this.a(q, b3.c(0), hashMap);
                        this.a(q, b3.b(0), hashMap);
                        this.a(q, b3.a(2), hashMap);
                        this.a(q, b3.c(2), hashMap);
                        this.a(q, b3.b(2), hashMap);
                    }
                    p2 = p2.a();
                    if (i) {
                        break;
                    }
                }
                p p3 = a.k();
                while (p3 != null) {
                    final q q2 = (q)p3.c();
                    final ar b4 = this.b(q2);
                    final C c4 = (C)(c = b4);
                    if (i) {
                        continue Label_0060;
                    }
                    if (c4 != null) {
                        final y.f.am a2 = this.e.a((Object)q2);
                        this.a(q2, b4.a(1), hashMap, b);
                        this.a(q2, b4.b(1), hashMap, b2);
                        this.a(q2, b4.a(3), hashMap, b2);
                        this.a(q2, b4.b(3), hashMap, b);
                        this.a(q2, b4, b4.a(0), hashMap, b, b2, (byte)2, 3, a2);
                        this.a(q2, b4, b4.c(0), hashMap, b, b2, (byte)2, 1, a2);
                        this.a(q2, b4, b4.b(0), hashMap, b, b2, (byte)2, 1, a2);
                        this.a(q2, b4, b4.a(2), hashMap, b2, b, (byte)1, 1, a2);
                        this.a(q2, b4, b4.c(2), hashMap, b2, b, (byte)1, 1, a2);
                        this.a(q2, b4, b4.b(2), hashMap, b2, b, (byte)1, 3, a2);
                    }
                    p3 = p3.a();
                    if (i) {
                        break;
                    }
                }
                break;
            }
            b.b();
            b2.b();
            if (b.c() > 0) {
                c2.d = this.a * b.c();
            }
            if (b2.c() > 0) {
                c2.e = this.a * b2.c();
            }
            Iterator iterator = b.a();
            while (true) {
                while (iterator.hasNext()) {
                    final d d2 = iterator.next();
                    ((aq)this.k.get(d2)).a[0] = b.c(d2);
                    if (i) {
                        while (true) {
                            while (iterator.hasNext()) {
                                final d d3 = iterator.next();
                                ((aq)this.k.get(d3)).a[1] = b2.c(d3);
                                if (!i) {
                                    if (i) {
                                        break;
                                    }
                                    continue Label_0713_Outer;
                                }
                                else {
                                    if (i) {
                                        break Label_0713_Outer;
                                    }
                                    continue Label_0713_Outer;
                                }
                            }
                            p = p.a();
                            continue;
                        }
                    }
                    if (i) {
                        break;
                    }
                }
                iterator = b2.a();
                continue;
            }
        }
    }
    
    private void a(final q q, final z z, final Map map) {
        final boolean i = y.f.c.a.i;
        p p3 = z.l.k();
        while (p3 != null) {
            final d d = (d)p3.c();
            this.e(d);
            if (q != d.d()) {
                map.put(d, this.e.p(d));
            }
            p3 = p3.a();
            if (i) {
                break;
            }
        }
    }
    
    private void b(final q q, final z z, final Map map) {
        final boolean i = y.f.c.a.i;
        p p3 = z.l.k();
        while (p3 != null) {
            final d d = (d)p3.c();
            final aq e = this.e(d);
            Label_0111: {
                if (q == d.d()) {
                    e.c = z.b();
                    if (!i) {
                        break Label_0111;
                    }
                }
                final double n = 0.0;
                final aq aq = e;
                final double b = z.b();
                aq.b = b;
                map.put(d, new t(z.f(n, b), this.e.p(d).b));
            }
            p3 = p3.a();
            if (i) {
                break;
            }
        }
    }
    
    private void a(final q q, final z z, final Map map, final b b) {
        final boolean i = y.f.c.a.i;
        p p4 = z.l.k();
        while (p4 != null) {
            final d d = (d)p4.c();
            if (q != d.c()) {
                final aq aq = this.k.get(d);
                this.e.q(d);
                final t t = map.get(d);
                this.a(d);
                b.a(d, t, new t(z.f(0.0, aq.c), this.e.a((Object)d.d()).getY()));
            }
            p4 = p4.a();
            if (i) {
                break;
            }
        }
    }
    
    private void a(final q q, final ar ar, final z z, final Map map, final b b, final b b2, final byte b3, final int n, final y.f.am am) {
        final boolean i = y.f.c.a.i;
        p p9 = z.l.k();
        while (p9 != null) {
            final d d = (d)p9.c();
            Label_0186: {
                if (q != d.c()) {
                    final aq aq = this.k.get(d);
                    final t q2 = this.e.q(d);
                    final t t = map.get(d);
                    if (this.a(d).b() == b3) {
                        final t t2 = new t(ar.c(n).f(0.0, ar.g(n)), am.getY());
                        aq.d = t2.a - am.getX();
                        aq.c = z.b();
                        b2.a(d, t, t2);
                        if (!i) {
                            break Label_0186;
                        }
                    }
                    b.a(d, t, q2);
                }
            }
            p9 = p9.a();
            if (i) {
                break;
            }
        }
    }
    
    private D f(final d d) {
        D d2 = this.b.get(d);
        if (d2 == null) {
            d2 = new D();
            this.b.put(d, d2);
        }
        return d2;
    }
    
    void d(final D d) {
        final boolean i = y.f.c.a.i;
        if (!this.a()) {
            return;
        }
        final b b = new b(0.0, 0.0);
        p p = d.k();
    Label_0031:
        while (p != null) {
            Object c = p.c();
        Label_0041:
            while (true) {
                final C c2 = (C)c;
                final y a = c2.a;
                final double n = c2.b - c2.d;
                final double n2 = c2.c + this.a;
                this.b.clear();
                if (!i) {
                    p p2 = a.k();
                    while (p2 != null) {
                        final q q = (q)p2.c();
                        final ar b2 = this.b(q);
                        final C c3 = (C)(c = b2);
                        if (i) {
                            continue Label_0041;
                        }
                        if (c3 != null) {
                            b2.a(this.e.a((Object)q));
                            this.a(q, b2.a(1), n, 0);
                            this.a(q, b2.b(1), n2, 1);
                            this.a(q, b2.a(3), n2, 1);
                            this.a(q, b2.b(3), n, 0);
                            this.a(q, b2.a(0), (byte)2, n, 0);
                            this.a(q, b2.c(0), (byte)2, n, 0);
                            this.a(q, b2.b(0), (byte)2, n, 0);
                            this.a(q, b2.a(2), (byte)1, n2, 1);
                            this.a(q, b2.c(2), (byte)1, n2, 1);
                            this.a(q, b2.b(2), (byte)1, n2, 1);
                        }
                        p2 = p2.a();
                        if (i) {
                            break;
                        }
                    }
                Label_0444:
                    for (final Map.Entry<Object, V> entry : this.b.entrySet()) {
                        final I b3 = this.e.b(entry.getKey());
                        b3.clearPoints();
                        p p3 = entry.getValue().k();
                        while (p3 != null) {
                            final t t = (t)p3.c();
                            b3.addPoint(t.a, t.b);
                            p3 = p3.a();
                            if (i) {
                                break Label_0444;
                            }
                            if (i) {
                                continue Label_0031;
                            }
                            if (i) {
                                break Label_0444;
                            }
                        }
                    }
                    p p4 = a.k();
                    while (p4 != null) {
                        final ar b4 = this.b((q)p4.c());
                        final C c4 = (C)(c = b4);
                        if (i) {
                            continue Label_0041;
                        }
                        if (c4 != null && b4.e[1] != null) {
                            final double n3 = this.e.m(b4.e[1]) + this.a;
                            b.a(n3, n3 + (this.e.p(b4.e[1]) - 2.0 * this.a), (byte)0);
                            p p5 = b4.c(3).l.k();
                            d d2 = null;
                            t t2 = null;
                            t t3 = null;
                            double n5;
                            double n4 = 0.0;
                            double b5;
                            Label_0619_Outer:Label_0662_Outer:
                            while (true) {
                                while (true) {
                                    while (true) {
                                        Label_0710: {
                                            Label_0644: {
                                                if (p5 == null) {
                                                    break Label_0644;
                                                }
                                                d2 = (d)p5.c();
                                                t2 = this.e.p(d2);
                                                t3 = this.e.q(d2);
                                                n4 = (n5 = dcmpl(t2.b(), t3.b()));
                                                if (i) {
                                                    break Label_0710;
                                                }
                                                if (n5 != 0) {
                                                    b.a(d2, t2, t3);
                                                }
                                                p5 = p5.a();
                                                if (!i) {
                                                    continue Label_0619_Outer;
                                                }
                                            }
                                            b.b();
                                            p5 = b4.c(3).l.k();
                                            if (p5 == null) {
                                                break;
                                            }
                                            d2 = (d)p5.c();
                                            t2 = this.e.p(d2);
                                            t3 = this.e.q(d2);
                                            n4 = (n5 = dcmpl(t2.b(), t3.b()));
                                        }
                                        if (i) {
                                            continue Label_0662_Outer;
                                        }
                                        break;
                                    }
                                    if (n4 != 0) {
                                        b5 = b.b(d2);
                                        this.e.b((Object)d2).addPoint(b5, t2.b());
                                        this.e.b((Object)d2).addPoint(b5, t3.b());
                                    }
                                    p5 = p5.a();
                                    if (i) {
                                        break;
                                    }
                                    continue;
                                }
                            }
                            this.e.a(b4.e[1]);
                            a.h(p4.b());
                        }
                        p4 = p4.a();
                        if (i) {
                            break;
                        }
                    }
                    break;
                }
                return;
            }
            p = p.a();
            if (i) {
                break;
            }
        }
        this.b.clear();
    }
    
    private void a(final q q, final z z, final byte b, final double n, final int n2) {
        final boolean i = y.f.c.a.i;
        p p5 = z.l.k();
        while (p5 != null) {
            final d d = (d)p5.c();
            final aq aq = this.k.get(d);
            final D f = this.f(d);
            double e = n + aq.a[n2] * this.a;
            Label_0266: {
                if (d.c() == q) {
                    final t p6 = this.e.p(d);
                    if (!Double.isNaN(aq.d)) {
                        f.a(new t(this.e.a((Object)d.d()).getX() + aq.d, e));
                    }
                    f.a(new t(p6.a, e));
                    if (!i) {
                        break Label_0266;
                    }
                }
                final t q2 = this.e.q(d);
                if (!Double.isNaN(aq.d)) {
                    final double n3 = this.e.a((Object)d.d()).getX() + aq.d;
                    e = z.e(0.0, aq.c);
                    f.add(new t(n3, e));
                }
                f.add(new t(q2.a, e));
            }
            p5 = p5.a();
            if (i) {
                break;
            }
        }
    }
    
    private void a(final q q, final z z, final double n, final int n2) {
        final boolean i = y.f.c.a.i;
        p p4 = z.l.k();
        while (p4 != null) {
            final d d = (d)p4.c();
            final aq aq = this.k.get(d);
            final D f = this.f(d);
            final double n3 = n + aq.a[n2] * this.a;
            Label_0205: {
                if (d.c() == q) {
                    final double f2 = z.f(0.0, aq.b);
                    final t p5 = this.e.p(d);
                    f.a(new t(f2, n3));
                    f.a(new t(f2, p5.b));
                    if (!i) {
                        break Label_0205;
                    }
                }
                final double f3 = z.f(0.0, aq.c);
                final t q2 = this.e.q(d);
                f.b(new t(f3, n3));
                f.b(new t(f3, q2.b));
            }
            p4 = p4.a();
            if (i) {
                break;
            }
        }
    }
    
    void e() {
        this.l = null;
        this.k = null;
        this.q = null;
        this.p = null;
        this.n = null;
        this.o = null;
        this.s = null;
        this.t = null;
        if (this.i != null) {
            this.e.a(this.i);
            this.i = null;
        }
        if (this.h != null) {
            this.e.a(this.h);
            this.h = null;
        }
    }
    
    public void b(final double r) {
        this.r = r;
    }
    
    static X a(final ap ap) {
        return ap.e;
    }
}
