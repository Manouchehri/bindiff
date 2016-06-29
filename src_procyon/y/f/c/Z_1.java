package y.f.c;

import y.g.*;
import y.c.*;

public class Z extends a
{
    private boolean C;
    private double D;
    private double E;
    private double F;
    private double G;
    protected A o;
    protected A p;
    private int H;
    al q;
    al r;
    al s;
    al t;
    al u;
    al v;
    al w;
    al x;
    al y;
    al z;
    al A;
    al B;
    
    public Z() {
        this.C = false;
        this.F = 10.0;
        this.G = 2.0;
        this.H = 1;
        this.q = new al(false);
        this.r = new al(false);
        this.s = new al(false);
        this.t = new al(false);
        this.u = new al(false);
        this.v = new al(false);
        this.w = new al(false);
        this.x = new al(false);
        this.y = new al(false);
        this.z = new al(false);
        this.A = new al(false);
        this.B = new al(false);
    }
    
    protected void f() {
        this.q.c();
        this.D = Math.max(this.b(), this.a());
        if (this.D < 1.0) {
            this.D = 1.0;
        }
        this.E = (int)(this.c() / this.D) * this.D;
        this.o = M.a(new Object[this.g.f()]);
        this.p = M.a(new Object[this.g.f()]);
        this.q.c();
    }
    
    protected void a(final y[] array, final c c) {
        final boolean i = y.f.c.a.i;
        this.r.c();
        this.f();
        this.b(array);
        double n = this.i();
        double n2 = Double.POSITIVE_INFINITY;
        int n3 = 0;
    Label_0106_Outer:
        while (n3 < this.H && n < n2) {
            y.a.a.a();
            ++n3;
            n2 = n;
            int j = 1;
            while (true) {
                while (j < array.length) {
                    this.a(this.a(array[j], -1), -1);
                    ++j;
                    if (i) {
                        while (true) {
                            while (j >= 0) {
                                this.a(this.a(array[j], 1), 1);
                                --j;
                                if (i) {
                                    while (true) {
                                        while (j < array.length - 1) {
                                            this.a(this.a(array[j], 0), 0);
                                            ++j;
                                            if (!i) {
                                                if (i) {
                                                    break;
                                                }
                                                continue Label_0106_Outer;
                                            }
                                            else {
                                                if (i) {
                                                    break Label_0106_Outer;
                                                }
                                                continue Label_0106_Outer;
                                            }
                                        }
                                        this.h();
                                        n = this.i();
                                        continue;
                                    }
                                }
                                if (i) {
                                    break;
                                }
                            }
                            j = 1;
                            continue;
                        }
                    }
                    if (i) {
                        break;
                    }
                }
                j = array.length - 2;
                continue;
            }
        }
        y.a.a.a();
        this.a(this.g());
        this.r.c();
    }
    
    protected boolean a(final D d) {
        final boolean i = y.f.c.a.i;
        this.s.c();
        int n = 0;
        final double[] array = new double[2];
        final double[] array2 = new double[2];
        final double[] array3 = new double[2];
        boolean b2 = false;
    Label_0028:
        while (true) {
        Label_0032_Outer:
            while (true) {
                boolean b = false;
                D d2 = d;
            Label_0032:
                while (true) {
                    while (true) {
                        final C m = d2.m();
                    Label_0037:
                        while (true) {
                            m.f();
                            do {
                                Label_0311: {
                                    if (b2) {
                                        final y y = (y)m.d();
                                        final q b3 = y.b();
                                        array[0] = this.a(b3, true);
                                        array[1] = this.a(b3, false);
                                        p k = y.k();
                                        final D d3 = d2 = y;
                                        if (!i) {
                                            p p = d3.k().a();
                                            while (true) {
                                                while (p != null) {
                                                    final q q = (q)p.c();
                                                    array2[0] = this.a(q, true);
                                                    array2[1] = this.a(q, false);
                                                    array3[0] = Math.max(array[0], array2[0]);
                                                    array3[1] = Math.min(array[1], array2[1]);
                                                    final double n2 = dcmpg(array3[1], array3[0]);
                                                    if (!i) {
                                                        Label_0265: {
                                                            if (n2 < 0) {
                                                                final p b4 = p.b();
                                                                if (b4 != null && b4 != k) {
                                                                    b |= this.a(k, b4, array);
                                                                    n |= (b ? 1 : 0);
                                                                }
                                                                k = p;
                                                                array[0] = array2[0];
                                                                array[1] = array2[1];
                                                                if (!i) {
                                                                    break Label_0265;
                                                                }
                                                            }
                                                            array[0] = array3[0];
                                                            array[1] = array3[1];
                                                        }
                                                        p = p.a();
                                                        if (i) {
                                                            break;
                                                        }
                                                        continue Label_0032_Outer;
                                                    }
                                                    else {
                                                        n = (int)n2;
                                                        m.g();
                                                        if (i) {
                                                            break Label_0311;
                                                        }
                                                        continue Label_0037;
                                                    }
                                                }
                                                b |= this.a(k, y.l(), array);
                                                continue;
                                            }
                                        }
                                        continue Label_0032;
                                    }
                                }
                                if (b) {
                                    continue Label_0028;
                                }
                                this.s.c();
                                b2 = (n != 0);
                            } while (i);
                            break Label_0028;
                        }
                    }
                    break;
                }
            }
            break;
        }
        return b2;
    }
    
    protected D g() {
        final boolean i = y.f.c.a.i;
        this.t.c();
        final A a = M.a(new Object[this.g.f()]);
        final D d = new D();
        final x o = this.g.o();
        do {
            Label_0042: {
                o.f();
            }
            boolean h = false;
            Label_0048:
        Label_0225_Outer:
            while (h) {
                q q = o.e();
                if (!i) {
                    Label_0236: {
                        if (a.b(q) == null) {
                            if (this.h(q)) {
                                while (q.b() == 1) {
                                    h = this.h(q.n().e());
                                    if (i) {
                                        continue Label_0048;
                                    }
                                    if (!h) {
                                        break;
                                    }
                                    q = q.n().e();
                                    if (i) {
                                        break;
                                    }
                                }
                                final y y = new y();
                                y.add(q);
                                a.a(q, y);
                                while (true) {
                                    while (q.c() == 1) {
                                        q = q.o().e();
                                        final int h2 = this.h(q) ? 1 : 0;
                                        if (!i) {
                                            if (h2 == 0) {
                                                break;
                                            }
                                            y.add(q);
                                            a.a(q, y);
                                            if (i) {
                                                break;
                                            }
                                            continue Label_0225_Outer;
                                        }
                                        else {
                                            if (h2 > 1) {
                                                d.add(y);
                                            }
                                            break Label_0236;
                                        }
                                    }
                                    y.size();
                                    continue;
                                }
                            }
                        }
                    }
                    o.g();
                    continue Label_0042;
                }
                return d;
            }
            break;
        } while (!i);
        this.t.c();
        return d;
    }
    
    protected boolean a(p a, final p p3, final double[] array) {
        final boolean i = a.i;
        this.u.c();
        boolean b = false;
        if (a == p3) {
            this.u.c();
            return false;
        }
        final q q = (q)a.c();
        final q q2 = (q)p3.c();
        double n = (array[0] + array[1]) / 2.0;
        if (array[0] <= -1.7976931348623157E308) {
            array[0] = Math.min(this.g.j(q), this.g.j(q2));
            double n2 = array[0];
            if (q.b() == 1) {
                n2 = Math.min(n2, this.g.j(q.n().e()));
            }
            if (q2.c() == 1) {
                n2 = Math.min(n2, this.g.j(q2.o().e()));
            }
            array[0] = n2;
            if (array[0] > array[1]) {
                array[0] = array[1];
            }
            n = array[0];
        }
        if (array[1] >= Double.MAX_VALUE) {
            array[1] = Math.max(this.g.j(q), this.g.j(q2));
            double n3 = array[1];
            if (q.b() == 1) {
                n3 = Math.max(n3, this.g.j(q.n().e()));
            }
            if (q2.c() == 1) {
                n3 = Math.max(n3, this.g.j(q2.o().e()));
            }
            array[1] = n3;
            if (array[1] < array[0]) {
                array[1] = array[0];
            }
            n = array[1];
        }
    Block_13:
        while (true) {
            final q q3 = (q)a.c();
            if (!b && Math.abs(this.g.j(q3) - n) > 5.0) {
                b = true;
            }
            this.g.a(q3, n, this.g.k(q3));
            a = a.a();
            while (a == p3.a()) {
                this.u.c();
                if (!i) {
                    break Block_13;
                }
            }
        }
        return b;
    }
    
    protected boolean h(final q q) {
        if (q.b() == 1) {
            return q.c() < 2;
        }
        return q.c() == 1 && q.b() < 2;
    }
    
    protected void h() {
        final boolean i = y.f.c.a.i;
        this.v.c();
        final y y = new y(this.g.o());
        final boolean[] array = new boolean[this.g.f()];
        int n = 0;
    Label_0204:
        while (true) {
            y.isEmpty();
            boolean b = false;
        Label_0043:
            while (!b && n < this.g.f() * this.g.f()) {
                ++n;
                final q d = y.d();
                array[d.d()] = true;
                final double a = this.a(d, this.a(d, d.j()));
                if (Math.abs(a) <= 1.0E-5) {
                    continue Label_0204;
                }
                this.b(d, a);
                if (!i) {
                    final x m = d.m();
                    while (m.f()) {
                        b = array[m.e().d()];
                        if (i) {
                            continue Label_0043;
                        }
                        if (b) {
                            array[m.e().d()] = false;
                            y.b(m.e());
                        }
                        m.g();
                        if (i) {
                            break Label_0204;
                        }
                    }
                    continue Label_0204;
                }
                return;
            }
            break;
        }
        this.v.c();
    }
    
    protected void a(final D d, final int n) {
        final boolean i = y.f.c.a.i;
        this.w.c();
        final C m = d.m();
        while (m.f()) {
            final y y = (y)m.d();
            double n2 = this.a(y.m(), n);
            if (i) {
                return;
            }
            Label_0117: {
                if (n2 < 0.0) {
                    n2 = this.a(y.b(), n2);
                    this.a(y.m(), n2);
                    if (!i) {
                        break Label_0117;
                    }
                }
                this.a(y.m(), this.a((q)y.i(), n2));
            }
            m.g();
            if (i) {
                break;
            }
        }
        this.w.c();
    }
    
    protected D a(final y y, final int n) {
        final boolean i = y.f.c.a.i;
        this.x.c();
        final D d = new D();
        final x a = y.a();
        while (true) {
            while (a.f()) {
                final y y2 = new y();
                y2.add(a.e());
                d.add(y2);
                if (i) {
                    y y5 = null;
                Block_9:
                    while (true) {
                        p p2 = d.k();
                    Label_0104_Outer:
                        while (true) {
                            while (true) {
                                final boolean a2;
                                Label_0224: {
                                    if (p2 == null) {
                                        break Label_0224;
                                    }
                                    final Object c = p2.c();
                                    final y y3 = (y)c;
                                    p2 = p2.a();
                                    if (p2 == null) {
                                        continue Label_0104_Outer;
                                    }
                                    final y y4 = (y)p2.c();
                                    a2 = this.a((q)y3.i(), y4.b());
                                    if (!i) {
                                        if (!a2 || this.a(y3.m(), n) < this.a(y4.m(), n)) {
                                            continue Label_0104_Outer;
                                        }
                                        y3.a(y4.m());
                                        d.h(p2);
                                        p2 = p2.a();
                                        if (!i) {
                                            continue Label_0104_Outer;
                                        }
                                    }
                                }
                                if (a2) {
                                    break;
                                }
                                this.x.c();
                                Object c;
                                y5 = (y)(c = d);
                                if (!i) {
                                    break Block_9;
                                }
                                continue;
                            }
                        }
                    }
                    return y5;
                }
                a.g();
                if (i) {
                    break;
                }
            }
            continue;
        }
    }
    
    protected double a(final q q, final e e) {
        final boolean i = y.f.c.a.i;
        double n = 0.0;
        double n2 = 0.0;
        e.i();
        while (e.f()) {
            final d a = e.a();
            final double a2 = this.a(a);
            n2 += a2;
            n += a2 * (this.g.j(a.a(q)) - this.g.j(q));
            e.g();
            if (i) {
                return n / n2;
            }
            if (i) {
                break;
            }
        }
        if (n == 0.0) {
            return 0.0;
        }
        return n / n2;
    }
    
    protected boolean a(final q q, final q q2) {
        if (this.o.b(q) == q2) {
            return this.a(q2) - this.b(q) - 1.0E-5 < this.b(q, false);
        }
        return this.p.b(q) == q2 && this.a(q) - this.b(q2) - 1.0E-5 < this.b(q, true);
    }
    
    protected double a(final q q, double n) {
        this.z.c();
        Label_0113: {
            if (n != 0.0) {
                if (n < 0.0) {
                    final q q2 = (q)this.p.b(q);
                    if (q2 == null) {
                        break Label_0113;
                    }
                    n = Math.max(n, this.b(q2) - this.a(q) + this.b(q, true));
                    if (!y.f.c.a.i) {
                        break Label_0113;
                    }
                }
                final q q3 = (q)this.o.b(q);
                if (q3 != null) {
                    n = Math.min(n, this.a(q3) - this.b(q) - this.b(q, false));
                }
            }
        }
        this.z.c();
        return n;
    }
    
    protected double a(final C c, final int n) {
        final boolean i = y.f.c.a.i;
        this.y.c();
        int n2 = 0;
        double n3 = 0.0;
        c.i();
        while (c.f()) {
            ++n2;
            final q q = (q)c.d();
            if (i) {
                return n3 / n2;
            }
            Label_0118: {
                if (n == -1) {
                    n3 += this.a(q, q.k());
                    if (!i) {
                        break Label_0118;
                    }
                }
                if (n == 0) {
                    n3 += this.a(q, q.j());
                    if (!i) {
                        break Label_0118;
                    }
                }
                n3 += this.a(q, q.l());
            }
            c.g();
            if (i) {
                break;
            }
        }
        this.y.c();
        return n3 / n2;
    }
    
    protected void b(final q q, final double n) {
        double n2 = this.g.j(q) + n;
        Label_0088: {
            if (this.C) {
                if (this.e.b(q) == null) {
                    n2 = (int)((n2 + this.E / 2.0) / this.E) * this.E;
                    if (!y.f.c.a.i) {
                        break Label_0088;
                    }
                }
                n2 = (int)((n2 + this.D / 2.0) / this.D) * this.D;
            }
        }
        this.g.a(q, n2, this.g.k(q));
    }
    
    protected void a(final C c, final double n) {
        final boolean i = y.f.c.a.i;
        c.i();
        while (c.f()) {
            this.b((q)c.d(), n);
            c.g();
            if (i) {
                break;
            }
        }
    }
    
    protected double i() {
        final boolean i = y.f.c.a.i;
        this.A.c();
        double n = 0.0;
        final x o = this.g.o();
    Label_0122_Outer:
        while (o.f()) {
            final e j = o.e().j();
            while (true) {
                while (j.f()) {
                    final d a = j.a();
                    n += this.a(a) * Math.abs(this.g.j(a.c()) - this.g.j(a.d()));
                    j.g();
                    if (!i) {
                        if (i) {
                            break;
                        }
                        continue Label_0122_Outer;
                    }
                    else {
                        if (i) {
                            break Label_0122_Outer;
                        }
                        continue Label_0122_Outer;
                    }
                }
                o.g();
                continue;
            }
        }
        this.A.c();
        return n;
    }
    
    protected double a(final d d) {
        if (this.e.b(d.c()) == null) {
            if (this.e.b(d.d()) == null) {
                return 1.0;
            }
            return this.G * 1.0;
        }
        else {
            if (this.e.b(d.d()) == null) {
                return this.G * 1.0;
            }
            return this.F * 1.0;
        }
    }
    
    protected double a(final q q, final boolean b) {
        if (b) {
            final q q2 = (q)this.p.b(q);
            if (q2 == null) {
                return -1.7976931348623157E308;
            }
            return this.b(q2) + this.b(q, true) + this.e(q);
        }
        else {
            final q q3 = (q)this.o.b(q);
            if (q3 == null) {
                return Double.MAX_VALUE;
            }
            return this.a(q3) - this.b(q, false) - this.f(q);
        }
    }
    
    protected double b(final q q, final boolean b) {
        q q2 = null;
        Label_0068: {
            if (b) {
                if (this.p.b(q) == null) {
                    return 0.0;
                }
                q2 = (q)this.p.b(q);
                if (!y.f.c.a.i) {
                    break Label_0068;
                }
            }
            if (this.o.b(q) == null) {
                return 0.0;
            }
            q2 = (q)this.o.b(q);
        }
        final d d = (d)this.e.b(q);
        final d d2 = (d)this.e.b(q2);
        if (d == null || d2 == null) {
            return this.c();
        }
        if (d.d() == d2.c() || d.d() == d2.d()) {
            return this.b();
        }
        return this.a();
    }
    
    protected void b(final y[] array) {
        final boolean i = y.f.c.a.i;
        this.B.c();
        this.a(this.g, array);
        int j = 0;
    Label_0276_Outer:
        while (j < array.length) {
            double n = 0.0;
            Object o = null;
            if (!i) {
                final x a = array[j].a();
                while (true) {
                    while (a.f()) {
                        final q e = a.e();
                        if (!i) {
                            if (o != null) {
                                this.o.a(o, e);
                                this.p.a(e, o);
                            }
                            o = e;
                            double n2 = n + (this.g.a((Object)e).getWidth() / 2.0 + this.c(e) + this.b(e, true));
                            Label_0214: {
                                if (this.C) {
                                    if (this.e.b(e) == null) {
                                        n2 = (int)((n2 + this.E / 2.0) / this.E) * this.E;
                                        if (!i) {
                                            break Label_0214;
                                        }
                                    }
                                    n2 = (int)((n2 + this.D / 2.0) / this.D) * this.D;
                                }
                            }
                            this.g.a(e, n2, this.g.k(e));
                            n = n2 + (this.g.a((Object)e).getWidth() / 2.0 + this.d(e));
                            a.g();
                            if (i) {
                                break;
                            }
                            continue Label_0276_Outer;
                        }
                        else {
                            if (i) {
                                break Label_0276_Outer;
                            }
                            continue Label_0276_Outer;
                        }
                    }
                    ++j;
                    continue;
                }
            }
            return;
        }
        this.B.c();
    }
}
