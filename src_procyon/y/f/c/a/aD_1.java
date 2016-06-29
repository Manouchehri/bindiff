package y.f.c.a;

import y.f.b.*;
import y.f.*;
import y.f.c.*;
import java.util.*;
import y.c.*;

class aD
{
    private c b;
    c a;
    
    private aD() {
    }
    
    public void a(final X x, final aU au, final aV av) {
        final boolean x2 = N.x;
        final c c = x.c(N.w);
        if (c == null) {
            return;
        }
        this.a = new W(this);
        final E e = (E)c.b(x);
        e.c();
        if (!e.k() || y.f.b.c.c(x)) {
            e.b();
            return;
        }
        this.b = x.c("y.layout.hierarchic.incremental.LayerCompactor.KEEP_LAYERS_DPKEY");
        final A t = x.t();
        final A t2 = x.t();
        final A t3 = x.t();
        final h u = x.u();
        final h u2 = x.u();
        final y[] array = new y[au.b()];
        int i = 0;
    Label_0310_Outer:
        while (i < au.b()) {
            final y d = au.a(i).d();
            array[i] = d;
            final x a = d.a();
        Label_0165:
            while (true) {
            Label_0252_Outer:
                while (a.f()) {
                    final q e2 = a.e();
                    t3.a(e2, e2.d());
                    int n = 0;
                    if (!x2) {
                        d d2 = e2.f();
                        while (true) {
                            while (d2 != null) {
                                u.a(d2, n);
                                ++n;
                                d2 = d2.g();
                                if (x2) {
                                    d d3 = e2.g();
                                    while (true) {
                                        while (d3 != null) {
                                            u2.a(d3, n);
                                            ++n;
                                            d3 = d3.h();
                                            if (!x2) {
                                                if (x2) {
                                                    break;
                                                }
                                                continue Label_0252_Outer;
                                            }
                                            else {
                                                if (x2) {
                                                    break Label_0252_Outer;
                                                }
                                                continue Label_0165;
                                            }
                                        }
                                        a.g();
                                        continue Label_0310_Outer;
                                    }
                                }
                                if (x2) {
                                    break;
                                }
                            }
                            n = 0;
                            continue Label_0310_Outer;
                        }
                    }
                    if (x2) {
                        break Label_0310_Outer;
                    }
                    continue Label_0310_Outer;
                }
                ++i;
                continue;
            }
        }
        final r r = new r();
        final s a2 = y.f.c.r.a((i)x);
        final y y = new y();
        final A t4 = x.t();
        final c c2 = x.c(f.b);
        x.a(f.b, new y.f.c.a.X(this, c2));
        this.a(x, a2, av, null, t, t2, y, t4);
        this.a(x, a2, av);
        this.a(x, t, t2, av, a2, t4);
        final q[] a3 = this.a(x, t, t2, a2);
        this.a(x, t, t2, a2, av, au.b());
        x.a(f.b, c2);
        e.b();
        final A t5 = x.t();
        final y.c.f f = new y.c.f();
        r.a(true);
        final c c3 = x.c(ah.f_);
        x.a(ah.f_, this.a);
        try {
            r.a(x, t5, f);
        }
        finally {
            x.d_(ah.f_);
            if (c3 != null) {
                x.a(ah.f_, c3);
            }
        }
        final e a4 = f.a();
        X x3;
        A t6;
        int a5;
        int b;
        int j;
        x a6;
        x x4;
        q e3;
        x x5;
        q e4;
        x a7;
        int k;
        Label_0731:Label_0732_Outer:
        while (true) {
        Label_0732:
            while (true) {
                while (a4.f()) {
                    x.c(a4.a());
                    a4.g();
                    if (x2) {
                        x3 = x;
                        t6 = x3.t();
                        a5 = new D().a(x, t5, t6);
                        b = au.b();
                        j = 0;
                        while (true) {
                            while (j < b) {
                                au.b(0);
                                ++j;
                                if (x2) {
                                    while (true) {
                                    Label_0971_Outer:
                                        while (j < a5) {
                                            au.a((byte)0, 0);
                                            ++j;
                                            if (x2) {
                                                while (true) {
                                                Label_0928:
                                                    while (j < array.length) {
                                                        a6 = array[j].a();
                                                        if (!x2) {
                                                            x4 = a6;
                                                            while (true) {
                                                                while (x4.f()) {
                                                                    e3 = x4.e();
                                                                    au.a(t6.a(e3)).a(e3);
                                                                    x4.g();
                                                                    if (!x2) {
                                                                        if (x2) {
                                                                            break;
                                                                        }
                                                                        continue Label_0732_Outer;
                                                                    }
                                                                    else {
                                                                        if (x2) {
                                                                            break Label_0928;
                                                                        }
                                                                        continue Label_0827;
                                                                    }
                                                                }
                                                                ++j;
                                                                continue Label_0971_Outer;
                                                            }
                                                        }
                                                        x5 = a6;
                                                        while (x5.f()) {
                                                            e4 = x5.e();
                                                            e4.b(new P(this, u));
                                                            e4.a(new Q(this, u2));
                                                            x5.g();
                                                            if (x2) {
                                                                return;
                                                            }
                                                            if (x2) {
                                                                break;
                                                            }
                                                        }
                                                        x.a(t3);
                                                        x.a(u);
                                                        x.a(u2);
                                                        x.a(t2);
                                                        x.a(t);
                                                        return;
                                                    }
                                                    a2.a();
                                                    x.a(t5);
                                                    x.a(t6);
                                                    x.a(t4);
                                                    x.b(new Y(this, t3));
                                                    x.o();
                                                    continue;
                                                }
                                            }
                                            if (x2) {
                                                break;
                                            }
                                        }
                                        j = 0;
                                        continue;
                                    }
                                }
                                if (x2) {
                                    break;
                                }
                            }
                            j = 0;
                            continue;
                        }
                    }
                    if (x2) {
                        break;
                    }
                }
                a7 = y.a();
                while (a7.f()) {
                    x.a(a7.e());
                    a7.g();
                    if (x2) {
                        continue Label_0731;
                    }
                    if (x2) {
                        break;
                    }
                }
                if (a3 != null) {
                    k = 0;
                    while (k < a3.length) {
                        x3 = x;
                        if (x2) {
                            continue Label_0732;
                        }
                        x.a(a3[k]);
                        ++k;
                        if (x2) {
                            break;
                        }
                    }
                }
                break;
            }
            continue Label_0731;
        }
    }
    
    protected void a(final X x, final A a, final A a2, final aV av, final s s, final A a3) {
        final boolean x2 = N.x;
        final y.f.b.c c = new y.f.b.c(x);
        final h u = x.u();
        final x o = x.o();
        while (true) {
            do {
                Label_0027: {
                    o.f();
                }
                boolean d = false;
                Label_0034:
                while (d) {
                    final q e = o.e();
                    final y.f.b.c c2 = c;
                    if (!x2) {
                        if (c2.d(e)) {
                            final q q = (q)a.b(e);
                            final q q2 = (q)a2.b(e);
                            if (q != null && q2 != null) {
                                final int a4 = a3.a(q);
                                final int a5 = a3.a(q2);
                                final e a6 = new y.c.f(e.j()).a();
                                while (a6.f()) {
                                    final d a7 = a6.a();
                                    d = u.d(a7);
                                    if (x2) {
                                        continue Label_0034;
                                    }
                                    Label_0677: {
                                        if (!d) {
                                            final q a8 = a7.a(e);
                                            final q b = c.b(e, a8);
                                            if (b == e || b == a8 || (this.a(c.a(e), x, c) && this.a(c.a(a8), x, c))) {
                                                u.a(a7, true);
                                                if (!x2) {
                                                    break Label_0677;
                                                }
                                            }
                                            q q3 = a8;
                                            q q4 = a8;
                                            int n = 0;
                                            int n2 = 0;
                                            Label_0425: {
                                                if (c.d(a8)) {
                                                    final q q5 = (q)a.b(a8);
                                                    Label_0334: {
                                                        if (q5 != null) {
                                                            q3 = q5;
                                                            n = a3.a(q3);
                                                            if (!x2) {
                                                                break Label_0334;
                                                            }
                                                        }
                                                        n = av.a(a8).j();
                                                    }
                                                    final q q6 = (q)a2.b(a8);
                                                    if (q6 != null) {
                                                        q4 = q6;
                                                        n2 = a3.a(q4);
                                                        if (!x2) {
                                                            break Label_0425;
                                                        }
                                                    }
                                                    n2 = av.a(a8).j();
                                                    if (!x2) {
                                                        break Label_0425;
                                                    }
                                                }
                                                n = av.a(q3).j();
                                                n2 = av.a(q4).j();
                                            }
                                            Label_0667: {
                                                if (a5 < n) {
                                                    s.a(this.a.b(q2), this.a.b(q3), 1);
                                                    if (!x2) {
                                                        break Label_0667;
                                                    }
                                                }
                                                if (n2 < a4) {
                                                    s.a(this.a.b(q4), this.a.b(q), 1);
                                                    if (!x2) {
                                                        break Label_0667;
                                                    }
                                                }
                                                Label_0588: {
                                                    if (a4 < n) {
                                                        s.a(this.a.b(q), this.a.b(q3), 0);
                                                        if (!x2) {
                                                            break Label_0588;
                                                        }
                                                    }
                                                    if (a4 > n) {
                                                        s.b(this.a.b(q), this.a.b(q3), 0);
                                                    }
                                                }
                                                if (a5 < n2) {
                                                    s.a(this.a.b(q2), this.a.b(q4), 0);
                                                    if (!x2) {
                                                        break Label_0667;
                                                    }
                                                }
                                                if (a5 > n2) {
                                                    s.b(this.a.b(q2), this.a.b(q4), 0);
                                                }
                                            }
                                            u.a(a7, true);
                                        }
                                    }
                                    a6.g();
                                    if (x2) {
                                        break;
                                    }
                                }
                            }
                        }
                        o.g();
                        continue Label_0027;
                    }
                    c2.c();
                    return;
                }
                break;
            } while (!x2);
            x.a(u);
            continue;
        }
    }
    
    protected void a(final X x, final s s, final aV av, final q q, final A a, final A a2, final y y, final A a3) {
        final y.f.b.c c = new y.f.b.c(x);
        Label_0066: {
            if (this.a(q, x, c)) {
                this.a(x, s, c, av, q, a, a2, y, a3);
                if (!N.x) {
                    break Label_0066;
                }
            }
            this.a(c, q, x, s, av, a, a2, y, a3);
        }
        c.c();
    }
    
    private void a(final y.f.b.c c, final q q, final X x, final s s, final aV av, final A a, final A a2, final y y, final A a3) {
        final boolean x2 = N.x;
        final x a4 = c.b(q).a();
        while (a4.f()) {
            final q e = a4.e();
            if (x2) {
                return;
            }
            if (c.d(e)) {
                this.a(x, s, av, e, a, a2, y, a3);
            }
            a4.g();
            if (x2) {
                break;
            }
        }
        if (q != null) {
            final q d = x.d();
            x.b(d, 0.0, 0.0);
            final q d2 = x.d();
            x.b(d2, 0.0, 0.0);
            a.a(q, d);
            a2.a(q, d2);
            y.add(d);
            y.add(d2);
            int n = Integer.MAX_VALUE;
            int n2 = 0;
            final x a5 = c.b(q).a();
            while (true) {
                while (a5.f()) {
                    final q e2 = a5.e();
                    if (x2) {
                        a3.a(d2, n2);
                        return;
                    }
                    Label_0425: {
                        if (!c.d(e2)) {
                            s.a(this.a.b(d), this.a.b(e2), 0);
                            s.b(this.a.b(d2), this.a.b(e2), 0);
                            n = Math.min(n, av.a(e2).j());
                            n2 = Math.max(n2, av.a(e2).j());
                            if (!x2) {
                                break Label_0425;
                            }
                        }
                        final q q2 = (q)a.b(e2);
                        s.a(this.a.b(d), this.a.b(q2), 0);
                        final q q3 = (q)a2.b(e2);
                        s.b(this.a.b(d2), this.a.b(q3), 0);
                        n = Math.min(n, a3.a(q2));
                        n2 = Math.max(n2, a3.a(q3));
                    }
                    a5.g();
                    if (x2) {
                        break;
                    }
                }
                s.a(this.a.b(d), this.a.b(d2), 0, x.g() * 1000);
                a3.a(d, n);
                continue;
            }
        }
    }
    
    private void a(final X x, final s s, final y.f.b.c c, final aV av, final q q, final A a, final A a2, final y y, final A a3) {
        final boolean x2 = N.x;
        this.a(x, q, c, av, a, a2, a3);
        final y c2 = c.c(q);
        final HashMap<Integer, q> hashMap = new HashMap<Integer, q>();
        final x a4 = c2.a();
        while (true) {
            while (a4.f()) {
                final q e = a4.e();
                final int d = c.d(e) ? 1 : 0;
                if (x2) {
                    if (d > 0) {
                        final Collection<q> values = hashMap.values();
                        final q[] array = values.toArray(new q[values.size()]);
                        y.g.e.a(array, new R(this, av));
                        if (array.length > 1) {
                            int i = 1;
                            while (i < array.length) {
                                s.a(this.a.b(array[i - 1]), this.a.b(array[i]), 1, Math.min(1000 * x.g(), 2147483646));
                                ++i;
                                if (x2) {
                                    break;
                                }
                            }
                        }
                    }
                    return;
                }
                Label_0161: {
                    if (d == 0) {
                        final Integer n = new Integer(av.a(e).j());
                        final q q2 = hashMap.get(n);
                        if (q2 != null) {
                            s.b(this.a.b(q2), this.a.b(e));
                            if (!x2) {
                                break Label_0161;
                            }
                        }
                        hashMap.put(n, e);
                    }
                }
                a4.g();
                if (x2) {
                    break;
                }
            }
            hashMap.size();
            continue;
        }
    }
    
    private void a(final X x, final q q, final y.f.b.c c, final aV av, final A a, final A a2, final A a3) {
        final boolean x2 = N.x;
        Object o = null;
        Object o2 = null;
        int n = Integer.MAX_VALUE;
        int n2 = -1;
        final x a4 = c.b(q).a();
        while (a4.f()) {
            final q e = a4.e();
            if (x2) {
                return;
            }
            q q2 = null;
            q q3 = null;
            int n3 = 0;
            int a5 = 0;
            Label_0159: {
                if (c.d(e)) {
                    this.a(x, e, c, av, a, a2, a3);
                    q2 = (q)a.b(e);
                    q3 = (q)a2.b(e);
                    n3 = a3.a(q2);
                    a5 = a3.a(q3);
                    if (!x2) {
                        break Label_0159;
                    }
                }
                q3 = (q2 = e);
                a5 = (n3 = av.a(e).j());
            }
            if (a5 > n2) {
                o2 = q3;
                n2 = a5;
            }
            if (n3 < n) {
                o = q2;
                n = n3;
            }
            a4.g();
            if (x2) {
                break;
            }
        }
        if (q != null) {
            a.a(q, o);
            a2.a(q, o2);
            a3.a(o, n);
            a3.a(o2, n2);
        }
    }
    
    private int a(final q q, final y.f.b.c c, final aV av) {
        final boolean x = N.x;
        q q2 = q;
        if (c != null && c.d(q)) {
            final x a = c.c(q).a();
            while (a.f()) {
                final q e = a.e();
                if (!c.d(e)) {
                    q2 = e;
                    if (!x) {
                        break;
                    }
                }
                a.g();
                if (x) {
                    break;
                }
            }
        }
        final aX a2 = av.a(q2);
        if (a2 != null) {
            return a2.j();
        }
        return -1;
    }
    
    private q[] a(final X x, final A a, final A a2, final s s) {
        final boolean x2 = N.x;
        final bk c = bk.c(x);
        if (c != null) {
            final y.f.b.c c2 = new y.f.b.c(x);
            final q[] m = x.m();
            final int size = c.e().size();
            final q[] array = new q[size - 1];
            int i = 0;
            while (i < array.length) {
                array[i] = x.d();
                if (i > 0) {
                    s.a(array[i - 1], array[i]);
                }
                ++i;
                if (x2) {
                    break;
                }
            }
            final c c3 = x.c(bk.b);
            if (c3 != null) {
                int j = 0;
                while (j < m.length) {
                    final q q = m[j];
                    final bh bh = (bh)c3.b(q);
                    if (x2) {
                        return array;
                    }
                    Label_0314: {
                        if (bh != null) {
                            final bt c4 = bh.c();
                            if (c4 != null) {
                                if (c2.d(q)) {
                                    if (c4.a() > 0) {
                                        s.b(a.b(q), array[c4.a() - 1], 1);
                                    }
                                    if (c4.a() >= size - 1) {
                                        break Label_0314;
                                    }
                                    s.a(a2.b(q), array[c4.a()], 1);
                                    if (!x2) {
                                        break Label_0314;
                                    }
                                }
                                if (c4.a() > 0) {
                                    s.b(q, array[c4.a() - 1], 1);
                                }
                                if (c4.a() < size - 1) {
                                    s.a(q, array[c4.a()], 1);
                                }
                            }
                        }
                    }
                    ++j;
                    if (x2) {
                        break;
                    }
                }
            }
            c2.c();
            return array;
        }
        return null;
    }
    
    private void a(final X x, final A a, final A a2, final s s, final aV av, final int n) {
        final boolean x2 = N.x;
        final c c = x.c(aR.a);
        if (c == null) {
            return;
        }
        final c c2 = (c)c.b(x);
        if (c2 == null) {
            return;
        }
        final c c3 = x.c(ah.f_);
        final HashMap<q, q> hashMap = new HashMap<q, q>();
        Label_0184: {
            Label_0137: {
                if (c3 != null) {
                    final x o = x.o();
                    while (o.f()) {
                        final q e = o.e();
                        hashMap.put((q)((c3.b(e) != null) ? c3.b(e) : e), e);
                        o.g();
                        if (x2) {
                            break Label_0137;
                        }
                    }
                    break Label_0184;
                }
            }
            final x o2 = x.o();
            while (o2.f()) {
                final q e2 = o2.e();
                hashMap.put(e2, e2);
                o2.g();
                if (x2) {
                    break;
                }
            }
        }
        final y.f.b.c c4 = new y.f.b.c(x);
        final x o3 = x.o();
        do {
            Label_0200: {
                o3.f();
            }
            boolean b = false;
            Label_0207:
            while (b) {
                final q e3 = o3.e();
                if (!x2) {
                    final y.c.D d = (y.c.D)c2.b((c3 != null && c3.b(e3) != null) ? c3.b(e3) : e3);
                    if (d != null) {
                        final int a3 = this.a(e3, c4, av);
                        final C m = d.m();
                        while (m.f()) {
                            final Object d2 = m.d();
                            b = (d2 instanceof co);
                            if (x2) {
                                continue Label_0207;
                            }
                            Label_1192: {
                                if (b) {
                                    final co co = (co)d2;
                                    final q q = hashMap.get(co.d());
                                    final byte c5 = co.c();
                                    if (c5 == 0) {
                                        if (a3 != this.a(q, c4, av)) {
                                            break Label_1192;
                                        }
                                        if (c4.d(e3) && c4.d(q)) {
                                            final q q2 = (q)a.b(e3);
                                            final q q3 = (q)a.b(q);
                                            if (q2 == null || q3 == null) {
                                                break Label_1192;
                                            }
                                            s.b(q3, q2);
                                            if (!x2) {
                                                break Label_1192;
                                            }
                                        }
                                        if (c4.d(e3)) {
                                            final q q4 = (q)a.b(e3);
                                            if (q4 == null) {
                                                break Label_1192;
                                            }
                                            s.b(q, q4);
                                            if (!x2) {
                                                break Label_1192;
                                            }
                                        }
                                        if (c4.d(q)) {
                                            final q q5 = (q)a.b(q);
                                            if (q5 == null) {
                                                break Label_1192;
                                            }
                                            s.b(q5, e3);
                                            if (!x2) {
                                                break Label_1192;
                                            }
                                        }
                                        s.b(q, e3);
                                        if (!x2) {
                                            break Label_1192;
                                        }
                                    }
                                    if (c5 == -1) {
                                        final int a4 = this.a(q, c4, av);
                                        if (a4 < a3) {
                                            break Label_1192;
                                        }
                                        final int min = Math.min(co.e(), a4 - a3);
                                        if (c4.d(e3) && c4.d(q)) {
                                            final q q6 = (q)a2.b(e3);
                                            final q q7 = (q)a.b(q);
                                            if (q6 == null || q7 == null) {
                                                break Label_1192;
                                            }
                                            s.b(q7, q6, min, co.a());
                                            if (!x2) {
                                                break Label_1192;
                                            }
                                        }
                                        if (c4.d(e3)) {
                                            final q q8 = (q)a2.b(e3);
                                            if (q8 == null) {
                                                break Label_1192;
                                            }
                                            s.b(q, q8, min, co.a());
                                            if (!x2) {
                                                break Label_1192;
                                            }
                                        }
                                        if (c4.d(q)) {
                                            final q q9 = (q)a.b(q);
                                            if (q9 == null) {
                                                break Label_1192;
                                            }
                                            s.b(q9, e3, min, co.a());
                                            if (!x2) {
                                                break Label_1192;
                                            }
                                        }
                                        s.b(q, e3, min, co.a());
                                        if (!x2) {
                                            break Label_1192;
                                        }
                                    }
                                    if (c5 == 1) {
                                        final int a5 = this.a(q, c4, av);
                                        if (a5 > a3) {
                                            break Label_1192;
                                        }
                                        final int min2 = Math.min(co.e(), a3 - a5);
                                        if (c4.d(e3) && c4.d(q)) {
                                            final q q10 = (q)a.b(e3);
                                            final q q11 = (q)a2.b(q);
                                            if (q10 == null || q11 == null) {
                                                break Label_1192;
                                            }
                                            s.a(q11, q10, min2, co.a());
                                            if (!x2) {
                                                break Label_1192;
                                            }
                                        }
                                        if (c4.d(e3)) {
                                            final q q12 = (q)a.b(e3);
                                            if (q12 == null) {
                                                break Label_1192;
                                            }
                                            s.a(q, q12, min2, co.a());
                                            if (!x2) {
                                                break Label_1192;
                                            }
                                        }
                                        if (c4.d(q)) {
                                            final q q13 = (q)a2.b(q);
                                            if (q13 == null) {
                                                break Label_1192;
                                            }
                                            s.a(q13, e3, min2, co.a());
                                            if (!x2) {
                                                break Label_1192;
                                            }
                                        }
                                        s.a(q, e3, min2, co.a());
                                        if (!x2) {
                                            break Label_1192;
                                        }
                                    }
                                    if (c5 == 2) {
                                        if (a3 != 0 || c4.a(e3) != null) {
                                            break Label_1192;
                                        }
                                        if (c4.d(e3)) {
                                            s.a(a.b(e3));
                                            if (!x2) {
                                                break Label_1192;
                                            }
                                        }
                                        s.a(e3);
                                        if (!x2) {
                                            break Label_1192;
                                        }
                                    }
                                    if (c5 == -2 && a3 == n - 1 && c4.a(e3) == null) {
                                        if (c4.d(e3)) {
                                            s.b(a.b(e3));
                                            if (!x2) {
                                                break Label_1192;
                                            }
                                        }
                                        s.b(e3);
                                    }
                                }
                            }
                            m.g();
                            if (x2) {
                                break;
                            }
                        }
                    }
                    o3.g();
                    continue Label_0200;
                }
                return;
            }
            break;
        } while (!x2);
        c4.c();
    }
    
    protected void a(final X x, final s s, final aV av) {
        final boolean x2 = N.x;
        final y.f.b.c c = new y.f.b.c(x);
        final e p3 = x.p();
        while (p3.f()) {
            final d a = p3.a();
            final q c2 = a.c();
            final q d = a.d();
            final aX a2 = av.a(c2);
            final aX a3 = av.a(d);
            if (x2) {
                return;
            }
            Label_0345: {
                if (a2 != null && a3 != null && !c.d(c2) && !c.d(d)) {
                    final int j = a2.j();
                    final int i = a3.j();
                    final q a4 = c.a(c2);
                    final q a5 = c.a(d);
                    final Object b = this.a.b(c2);
                    final Object b2 = this.a.b(d);
                    if (a4 == a5 && !this.a(a4, x, c)) {
                        if (j < i) {
                            s.a(b, b2, 1, 100 * x.g());
                            if (!x2) {
                                break Label_0345;
                            }
                        }
                        if (i < j) {
                            s.a(b2, b, 1);
                            if (!x2) {
                                break Label_0345;
                            }
                        }
                        s.b(b, b2);
                        if (!x2) {
                            break Label_0345;
                        }
                    }
                    if (a4 != a5 && (!this.a(a4, x, c) || !this.a(a5, x, c))) {
                        if (j < i) {
                            s.a(b, b2, 1);
                            if (!x2) {
                                break Label_0345;
                            }
                        }
                        if (i < j) {
                            s.a(b2, b, 1);
                            if (!x2) {
                                break Label_0345;
                            }
                        }
                        s.b(b, b2);
                    }
                }
            }
            p3.g();
            if (x2) {
                break;
            }
        }
        c.c();
    }
    
    private boolean a(final q q, final i i, final y.f.b.c c) {
        if (this.b == null) {
            return false;
        }
        if (q == null) {
            return this.b.d(i);
        }
        return this.b.d(q) || this.a(c.a(q), i, c);
    }
    
    aD(final O o) {
        this();
    }
}
