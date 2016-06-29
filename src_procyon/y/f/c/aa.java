package y.f.c;

import y.g.*;
import y.d.*;
import y.c.*;

public class aa extends a
{
    double[] o;
    ab[] p;
    int[] q;
    int[] r;
    double[] s;
    int t;
    int u;
    double v;
    int w;
    int x;
    q[][] y;
    D z;
    
    public aa() {
        this.w = 5;
        this.x = 10;
    }
    
    protected void a(final y[] array, final c c) {
        final boolean i = y.f.c.a.i;
        y.g.o.a(this, "Polyline Drawer");
        this.y = new q[array.length][];
        this.q = new int[this.g.f()];
        this.o = new double[this.g.f()];
        this.p = new ab[this.g.f()];
        this.s = new double[this.g.f()];
        this.r = new int[this.g.f()];
        int j = 0;
    Label_0195_Outer:
        while (j < array.length) {
            final y y = array[j];
            final q[][] y2 = this.y;
            final int n = j;
            final q[] array2 = new q[y.size()];
            y2[n] = array2;
            final q[] array3 = array2;
            int n2 = 0;
            if (!i) {
                final C m = y.m();
                while (true) {
                    while (m.f()) {
                        final q q = (q)m.d();
                        array3[this.q[q.d()] = n2] = q;
                        m.g();
                        ++n2;
                        if (!i) {
                            if (i) {
                                break;
                            }
                            continue Label_0195_Outer;
                        }
                        else {
                            if (i) {
                                break Label_0195_Outer;
                            }
                            continue Label_0195_Outer;
                        }
                    }
                    ++j;
                    continue;
                }
            }
            return;
        }
        this.f();
        this.g();
        this.k();
    }
    
    void f() {
        final boolean i = y.f.c.a.i;
        double max = 0.0;
        final double[] array = new double[this.y.length];
        final double[] array2 = new double[this.y.length];
        int j = 0;
    Label_0027:
        while (true) {
        Label_0162_Outer:
            while (j < this.y.length) {
                double n = 0.0;
                final double n2 = 0.0;
                if (!i) {
                    double max2 = n2;
                    final q[] array3 = this.y[j];
                    int k = 0;
                    while (true) {
                        while (k < array3.length) {
                            n += this.g.r(array3[k]).a();
                            max2 = Math.max(max2, this.g.r(array3[k]).b());
                            ++k;
                            if (!i) {
                                if (i) {
                                    break;
                                }
                                continue Label_0162_Outer;
                            }
                            else {
                                if (i) {
                                    break Label_0162_Outer;
                                }
                                continue Label_0027;
                            }
                        }
                        final double n3 = n + (array3.length - 1) * this.a;
                        max = Math.max(max, n3);
                        array2[j] = max2;
                        array[j] = n3;
                        ++j;
                        continue;
                    }
                }
                double n4 = n2;
                int l = 0;
            Label_0322_Outer:
                while (l < this.y.length) {
                    double n5 = (max - array[l]) / 2.0;
                    final q[] array4 = this.y[l];
                    int n6 = 0;
                    while (true) {
                        while (n6 < array4.length) {
                            final q q = array4[n6];
                            this.g.b(q, new t(n5, n4 + (array2[l] - this.g.r(q).b()) / 2.0));
                            n5 += this.g.r(q).a() + this.a;
                            ++n6;
                            if (!i) {
                                if (i) {
                                    break;
                                }
                                continue Label_0322_Outer;
                            }
                            else {
                                if (i) {
                                    break Label_0322_Outer;
                                }
                                continue Label_0322_Outer;
                            }
                        }
                        n4 += array2[l] + this.b;
                        ++l;
                        continue;
                    }
                }
                return;
            }
            continue;
        }
    }
    
    void g() {
        final boolean i = y.f.c.a.i;
        double n = Double.MAX_VALUE;
        double n2 = this.h();
        if (n2 >= n) {
            n = n2 + 1.0;
        }
        int n3 = 0;
        while (n3 < this.w && n2 < n) {
            n = n2;
            this.i();
            this.j();
            n2 = this.h();
            ++n3;
            if (i) {
                break;
            }
        }
    }
    
    double h() {
        final boolean i = y.f.c.a.i;
        double n = 0.0;
        final x o = this.g.o();
        double n3 = 0.0;
    Label_0123_Outer:
        while (o.f()) {
            final q e = o.e();
            final double a = this.g.l(e).a();
            double n2 = 0.0;
            n3 = 0.0;
            if (!i) {
                double n4 = n3;
                x x = e.n();
                while (true) {
                    while (x.f()) {
                        n2 += this.g.l(x.e()).a() - a;
                        x.g();
                        if (i) {
                            while (true) {
                                while (x.f()) {
                                    n4 += this.g.l(x.e()).a() - a;
                                    x.g();
                                    if (!i) {
                                        if (i) {
                                            break;
                                        }
                                        continue Label_0123_Outer;
                                    }
                                    else {
                                        if (i) {
                                            break Label_0123_Outer;
                                        }
                                        continue Label_0123_Outer;
                                    }
                                }
                                n += Math.abs(n2 + n4);
                                o.g();
                                continue;
                            }
                        }
                        if (i) {
                            break;
                        }
                    }
                    x = e.o();
                    continue;
                }
            }
            return n3;
        }
        return n3;
    }
    
    void i() {
        final boolean i = y.f.c.a.i;
        int n = 1;
    Block_6:
        do {
            final int length = this.y.length;
        Label_0013:
            while (true) {
                int j = 0;
                int n2 = 0;
                while (j < n2) {
                    final q[] array = this.y[n];
                    this.b(array);
                    this.d(array);
                    while (true) {
                        boolean b = false;
                        final C m = this.z.m();
                        while (m.f()) {
                            j = (this.a((ab)m.d(), array) ? 1 : 0);
                            n2 = 1;
                            if (i) {
                                continue Label_0013;
                            }
                            if (j == n2) {
                                b = true;
                            }
                            m.g();
                            if (i) {
                                break;
                            }
                        }
                        while (!b) {
                            this.a(array);
                            ++n;
                            if (!i) {
                                continue Block_6;
                            }
                        }
                    }
                }
                break;
            }
            break;
        } while (!i);
    }
    
    void j() {
        final boolean i = y.f.c.a.i;
        int j = this.y.length - 2;
        while (j >= 0) {
            final q[] array = this.y[j];
            this.c(array);
            this.d(array);
        Label_0098_Outer:
            while (true) {
                final C m = this.z.m();
                while (true) {
                    while (m.f()) {
                        final boolean a = this.a((ab)m.d(), array);
                        if (!i) {
                            if (a) {}
                            m.g();
                            if (i) {
                                break;
                            }
                            continue Label_0098_Outer;
                        }
                        else {
                            if (a) {
                                continue Label_0098_Outer;
                            }
                            this.a(array);
                            --j;
                            if (!i) {
                                break Label_0098_Outer;
                            }
                            break;
                        }
                    }
                    continue;
                }
            }
            if (i) {
                break;
            }
        }
    }
    
    void a(final q[] array) {
        final boolean i = y.f.c.a.i;
        final C m = this.z.m();
        while (m.f()) {
            final ab ab = (ab)m.d();
            double n2;
            final double n = n2 = ab.a();
            Label_0202: {
                if (n < 0.0) {
                    final q q = (q)ab.a.f();
                    if (this.q[q.d()] <= 0) {
                        break Label_0202;
                    }
                    final q q2 = array[this.q[q.d()] - 1];
                    final ab ab2 = this.p[q2.d()];
                    n2 = Math.max(n, -(this.a(q2, q) - this.a));
                    if (!i) {
                        break Label_0202;
                    }
                }
                final q q3 = (q)ab.a.i();
                if (this.q[q3.d()] < array.length - 1) {
                    final q q4 = array[this.q[q3.d()] + 1];
                    final ab ab3 = this.p[q4.d()];
                    n2 = Math.min(n, this.a(q3, q4) - this.a);
                }
            }
            ab.a(n2);
            m.g();
            if (i) {
                break;
            }
        }
    }
    
    void b(final q[] array) {
        final boolean i = y.f.c.a.i;
        int j = 0;
        while (j < array.length) {
            final q q = array[j];
            Label_0133: {
                Label_0130: {
                    if (q.b() == 0) {
                        this.o[q.d()] = 0.0;
                        if (!i) {
                            break Label_0130;
                        }
                    }
                    final double a = this.g.l(q).a();
                    double n = 0.0;
                    final x n2 = q.n();
                    while (n2.f()) {
                        n += this.g.l(n2.e()).a() - a;
                        n2.g();
                        if (i) {
                            break Label_0133;
                        }
                        if (i) {
                            break;
                        }
                    }
                    this.o[q.d()] = n / q.b();
                }
                ++j;
            }
            if (i) {
                break;
            }
        }
    }
    
    void c(final q[] array) {
        final boolean i = y.f.c.a.i;
        int j = 0;
        while (j < array.length) {
            final q q = array[j];
            Label_0133: {
                Label_0130: {
                    if (q.c() == 0) {
                        this.o[q.d()] = 0.0;
                        if (!i) {
                            break Label_0130;
                        }
                    }
                    final double a = this.g.l(q).a();
                    double n = 0.0;
                    final x o = q.o();
                    while (o.f()) {
                        n += this.g.l(o.e()).a() - a;
                        o.g();
                        if (i) {
                            break Label_0133;
                        }
                        if (i) {
                            break;
                        }
                    }
                    this.o[q.d()] = n / q.c();
                }
                ++j;
            }
            if (i) {
                break;
            }
        }
    }
    
    void d(final q[] array) {
        final boolean i = y.f.c.a.i;
        this.z = new D();
        int j = 0;
        while (j < array.length) {
            final q q = array[j];
            final ab ab = new ab(this, q);
            this.p[q.d()] = ab;
            this.z.b(ab);
            ++j;
            if (i) {
                break;
            }
        }
    }
    
    boolean a(final ab ab, final q[] array) {
        final boolean i = y.f.c.a.i;
        final q q = (q)ab.a.i();
        boolean b = false;
        if (this.q[q.d()] < array.length - 1) {
            final q q2 = array[this.q[q.d()] + 1];
            final ab ab2 = this.p[q2.d()];
            if (this.a(q, q2) < this.a && ab.a() >= ab2.a()) {
                b = true;
                final C m = ab2.a.m();
                while (m.f()) {
                    final q q3 = (q)m.d();
                    ab.a.b(q3);
                    this.p[q3.d()] = ab;
                    m.g();
                    if (i) {
                        return b;
                    }
                    if (i) {
                        break;
                    }
                }
                this.z.remove(ab2);
            }
        }
        return b;
    }
    
    double a(final q q, final q q2) {
        return this.g.o(q2).a() - (this.g.o(q).a() + this.g.r(q).a());
    }
    
    void k() {
        final boolean i = y.f.c.a.i;
        this.l();
        if (this.h() >= Double.MAX_VALUE) {}
        int j = 0;
        while (j < this.x) {
            this.m();
            this.h();
            ++j;
            if (i) {
                break;
            }
        }
    }
    
    void l() {
        final boolean i = y.f.c.a.i;
        this.t = 50;
        this.u = 10;
        this.v = 0.5;
        int j = this.g.f() - 1;
        while (j >= 0) {
            this.r[j] = this.t;
            this.s[j] = 0.0;
            --j;
            if (i) {
                break;
            }
        }
    }
    
    void m() {
        final boolean i = y.f.c.a.i;
        int n = 0;
        do {
            double n2 = 0.0;
            Label_0007: {
                n2 = n;
            }
            Label_0008:
            while (n2 < this.y.length) {
                final q[] array = this.y[n];
                int j = 0;
                while (j < array.length) {
                    final q q = array[j];
                    double n4;
                    final double n3 = n4 = this.h(q);
                    final int n5 = this.r[q.d()];
                    final double n6 = n2 = dcmpg(n3, 0.0);
                    if (i) {
                        continue Label_0008;
                    }
                    Label_0180: {
                        if (n6 < 0) {
                            if (this.q[q.d()] <= 0) {
                                break Label_0180;
                            }
                            n4 = Math.max(n3, -(this.a(array[this.q[q.d()] - 1], q) - this.a));
                            if (!i) {
                                break Label_0180;
                            }
                        }
                        if (this.q[q.d()] < array.length - 1) {
                            n4 = Math.min(n3, this.a(q, array[this.q[q.d()] + 1]) - this.a);
                        }
                    }
                    int n7 = 0;
                    Label_0236: {
                        if (n4 == 0.0 || n4 * this.s[q.d()] < 0.0) {
                            n7 = (int)((1.0 - this.v) * n5);
                            if (!i) {
                                break Label_0236;
                            }
                        }
                        n7 = (int)((1.0 + this.v) * n5);
                    }
                    Label_0260: {
                        if (n7 < 0) {
                            n7 = 0;
                            if (!i) {
                                break Label_0260;
                            }
                        }
                        if (n7 > 100) {
                            n7 = 100;
                        }
                    }
                    this.t += (n7 - n5) / this.g.f();
                    this.g.b(q, this.g.o(q).b(n4, 0.0));
                    this.s[q.d()] = n4;
                    this.r[q.d()] = n7;
                    ++j;
                    if (i) {
                        break;
                    }
                }
                ++n;
                continue Label_0007;
            }
            break;
        } while (!i);
    }
    
    double h(final q q) {
        final boolean i = y.f.c.a.i;
        double n = 0.0;
        final double a = this.g.l(q).a();
        if (q.a() > 0) {
            final x m = q.m();
            while (m.f()) {
                n += this.g.l(m.e()).a() - a;
                m.g();
                if (i) {
                    return n;
                }
                if (i) {
                    break;
                }
            }
            n /= q.a();
        }
        return n;
    }
}
