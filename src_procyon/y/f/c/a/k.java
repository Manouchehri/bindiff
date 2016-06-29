package y.f.c.a;

import y.f.b.*;
import y.c.*;
import y.g.*;
import y.d.*;

class k
{
    private double[][] a;
    private int b;
    private int c;
    private q d;
    private double e;
    private double f;
    private D g;
    private c h;
    private int i;
    private final f j;
    
    public k(final f j, final q d, final c h) {
        this.j = j;
        this.d = d;
        this.h = h;
        this.i = h.c(d).size();
        this.g = new D();
    }
    
    public void a(final i i) {
        this.g.add(i);
    }
    
    private void b(final A a, final A a2) {
        final boolean x = N.x;
        this.b = Integer.MAX_VALUE;
        this.c = 0;
        final x a3 = this.h.b(this.d).a();
        while (a3.f()) {
            final q e = a3.e();
            Label_0146: {
                if (this.h.d(e)) {
                    final k k = (k)a2.b(e);
                    this.b = Math.min(this.b, k.b);
                    this.c = Math.max(this.c, k.c);
                    if (!x) {
                        break Label_0146;
                    }
                }
                final int a4 = a.a(e);
                this.b = Math.min(this.b, a4);
                this.c = Math.max(this.c, a4);
            }
            a3.g();
            if (x) {
                break;
            }
        }
    }
    
    private void a(final A a, final A a2, final A a3) {
        final boolean x = N.x;
        this.a = new double[y.f.c.a.f.a(this.j).f() + 1][2];
        final x a4 = this.h.b(this.d).a();
        while (true) {
            do {
                double f = 0.0;
                Label_0046: {
                    f = (a4.f() ? 1 : 0);
                }
                Label_0053:
                while (f != 0) {
                    final q e = a4.e();
                    final int d;
                    final int n = d = (a2.d(e) ? 1 : 0);
                    if (!x) {
                        Label_0353: {
                            if (n == 0) {
                                Label_0249: {
                                    if (this.h.d(e)) {
                                        final k k = (k)a3.b(e);
                                        final int n2 = k.b - this.b;
                                        int i = 0;
                                        while (i < k.c + 1 - k.b) {
                                            final int n3 = i + n2;
                                            this.a[n3][0] = Math.max(this.a[n3][0], k.a[i][0]);
                                            final double n4 = f = dcmpl(this.a[n3][1], 0.0);
                                            if (x) {
                                                continue Label_0053;
                                            }
                                            final boolean b = n4 == 0;
                                            final double[] array = this.a[n3];
                                            final int n5 = 1;
                                            array[n5] += k.f + (b ? 0.0 : 30.0);
                                            ++i;
                                            if (x) {
                                                break Label_0249;
                                            }
                                        }
                                        break Label_0353;
                                    }
                                }
                                final int n6 = a.a(e) - this.b;
                                this.a[n6][0] = Math.max(this.a[n6][0], y.f.c.a.f.a(this.j, e));
                                final boolean b2 = this.a[n6][1] == 0.0;
                                final double[] array2 = this.a[n6];
                                final int n7 = 1;
                                array2[n7] += y.f.c.a.f.b(this.j, e) + (b2 ? 0.0 : 30.0);
                            }
                        }
                        a4.g();
                        continue Label_0046;
                    }
                    int j = d;
                    while (j < this.c + 1 - this.b) {
                        this.f = Math.max(this.f, this.a[j][1]);
                        this.e += this.a[j][0] + ((j == 0) ? 0.0 : 30.0);
                        ++j;
                        if (x) {
                            break;
                        }
                    }
                    return;
                }
                break;
            } while (!x);
            int d = 0;
            continue;
        }
    }
    
    private void a(final A a) {
        final boolean x = N.x;
        final C m = this.g.m();
    Label_0092_Outer:
        while (m.f()) {
            final x a2 = ((i)m.d()).c().a();
            while (true) {
                while (a2.f()) {
                    a.a(a2.e(), true);
                    a2.g();
                    if (!x) {
                        if (x) {
                            break;
                        }
                        continue Label_0092_Outer;
                    }
                    else {
                        if (x) {
                            break Label_0092_Outer;
                        }
                        continue Label_0092_Outer;
                    }
                }
                m.g();
                continue;
            }
        }
    }
    
    public void a(final A a, final A a2) {
        final boolean x = N.x;
        final A a3 = M.a();
        this.a(a3);
        this.b(a, a2);
        this.a(a, a3, a2);
        Label_0235: {
            if (!this.g.isEmpty()) {
                final C m = this.g.m();
                while (m.f()) {
                    Object d = m.d();
                    i i = null;
                    int n = 0;
                Label_0063:
                    while (true) {
                        i = (i)d;
                        n = 0;
                        double n2 = 0.0;
                        final int n3 = this.c + 2 - this.b;
                        if (!x) {
                            int j = 0;
                            while (j < n3) {
                                final y.d.q a4 = this.a(i, j);
                                final i k = (i)(d = a4);
                                if (x) {
                                    continue Label_0063;
                                }
                                if (k == null) {
                                    break;
                                }
                                if (a4.a <= this.f && a4.b <= this.e) {
                                    n = j;
                                    if (!x) {
                                        break;
                                    }
                                }
                                final double n4 = a4.a / a4.b;
                                if (j == 0 || y.f.c.a.f.a(this.j, n4, n2)) {
                                    n = j;
                                    n2 = n4;
                                }
                                ++j;
                                if (x) {
                                    break;
                                }
                            }
                            break;
                        }
                        break Label_0235;
                    }
                    this.a(i, n, a);
                    m.g();
                    if (x) {
                        break;
                    }
                }
                this.b(a, a2);
            }
        }
        final r c = y.f.c.a.f.c(this.j, this.d);
        this.f += c.b + c.d;
        this.e += c.a + c.c;
        final double[] array = this.a[0];
        final int n5 = 0;
        array[n5] += c.a;
        final double[] array2 = this.a[this.c - this.b];
        final int n6 = 0;
        array2[n6] += c.c;
    }
    
    private void a(final i i, final int n, final A a) {
        final boolean x = N.x;
        int n2 = this.c - this.b;
        final double[][] e = i.e();
        int j = 0;
        while (j < e.length) {
            final int n3 = j + n;
            final boolean b = this.a[n3][1] == 0.0;
            final double[] array = this.a[n3];
            final int n4 = 1;
            array[n4] += e[j][1] + (b ? 0.0 : 30.0);
            this.f = Math.max(this.f, this.a[n3][1]);
            final double n5 = e[j][0] - this.a[n3][0];
            if (n5 > 0.0) {
                this.e += n5;
                final double[] array2 = this.a[n3];
                final int n6 = 0;
                array2[n6] += n5;
            }
            if (n3 > n2) {
                this.e += 30.0;
                ++this.c;
                ++n2;
            }
            ++j;
            if (x) {
                break;
            }
        }
        final aU b2 = i.b();
        int k = 0;
    Label_0299_Outer:
        while (k < b2.b()) {
            final x a2 = b2.a(k).d().a();
            while (true) {
                while (a2.f()) {
                    a.a(a2.e(), this.b + n + k);
                    a2.g();
                    if (!x) {
                        if (x) {
                            break;
                        }
                        continue Label_0299_Outer;
                    }
                    else {
                        if (x) {
                            break Label_0299_Outer;
                        }
                        continue Label_0299_Outer;
                    }
                }
                ++k;
                continue;
            }
        }
    }
    
    private y.d.q a(final i i, final int n) {
        final boolean x = N.x;
        int n2 = this.c - this.b;
        double e = this.e;
        double n3 = this.f;
        final double[][] e2 = i.e();
        int j = 0;
        while (j < e2.length) {
            final int n4 = j + n;
            if (n4 >= this.a.length) {
                return null;
            }
            n3 = Math.max(n3, this.a[n4][1] + e2[j][1] + ((this.a[n4][1] == 0.0) ? 0.0 : 30.0));
            final double n5 = e2[j][0] - this.a[n4][0];
            if (n5 > 0.0) {
                e += n5;
            }
            if (n4 > n2) {
                e += 30.0;
                ++n2;
            }
            ++j;
            if (x) {
                break;
            }
        }
        return new y.d.q(n3, e);
    }
}
