package y.f.e;

import y.g.*;
import y.f.*;
import y.c.*;
import java.util.*;
import y.a.*;

public class a extends c
{
    private int n;
    private double[] o;
    private double[] p;
    private double[] q;
    private double[] r;
    private double[] s;
    private double[] t;
    private double[] u;
    private double[] v;
    private double[] w;
    private double[] x;
    private int y;
    private double z;
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int[] F;
    private q[] G;
    private y.f.e.c H;
    private int[] I;
    private q[] J;
    private int[] K;
    private X L;
    private q[] M;
    private double N;
    private int[] O;
    private b[][] P;
    private ar Q;
    private double R;
    private double S;
    private double T;
    private int[] U;
    private int[] V;
    private double[][] W;
    private int[] X;
    private double[] Y;
    private double[] Z;
    private y.g.c aa;
    private int ab;
    private boolean ac;
    private boolean ad;
    private boolean ae;
    
    public a() {
        this.y = 40;
        this.z = this.y * this.y;
        this.A = 15;
        this.B = 3;
        this.C = 10;
        this.D = 25;
        this.R = 2.0;
        this.W = new double[6][6];
        this.X = new int[3];
        this.Y = new double[6];
        this.Z = new double[6];
        this.ac = true;
        this.ad = false;
    }
    
    public boolean b(final X x) {
        return x != null;
    }
    
    public void a(final int c) {
        this.C = c;
    }
    
    public void b(final int d) {
        this.D = d;
    }
    
    public void c(final int y) {
        this.y = y;
    }
    
    public void d(final int a) {
        this.A = a;
    }
    
    public void a(final X x) {
        final boolean b = y.f.e.i.b;
        if (x == null || x.e() < 2) {
            if (x != null) {
                y.f.ae.a(x, true);
            }
            return;
        }
        if (x.e() == 2) {
            y.f.ae.a(x, true);
            final x o = x.o();
            final q e = o.e();
            x.a(e, 0.0, 0.0);
            o.g();
            if (this.ae) {
                x.a(o.e(), 0.0, this.y + x.q(o.e()) / 2.0 + x.q(e) / 2.0);
                if (!b) {
                    return;
                }
            }
            x.a(o.e(), 0.0, this.y);
            return;
        }
        this.M = x.m();
        Label_0245: {
            if (this.ae) {
                this.N = 0.0;
                int i = this.M.length - 1;
                while (true) {
                    while (i >= 0) {
                        final q q = this.M[i];
                        this.N += (x.p(q) + x.q(q)) / 4.0;
                        --i;
                        if (b) {
                            this.y += (int)(2.0 * this.N);
                            break Label_0245;
                        }
                        if (b) {
                            break;
                        }
                    }
                    this.N /= this.M.length;
                    continue;
                }
            }
        }
        this.d(x);
        int j = this.E - 1;
        this.n();
        int k = this.C - 1;
        while (true) {
        Label_0878_Outer:
            while (k > 0) {
                this.a(j, false);
                --k;
                if (b) {
                    while (true) {
                    Label_0874:
                        while (j >= 0) {
                            final int n = this.F[j];
                            final int n2 = j;
                            if (!b) {
                                double n3 = 0.0;
                                Label_0370: {
                                    if (n2 > 0) {
                                        n3 = this.A * (1 << (j - 1) * 2) * (1 + this.y / 80);
                                        if (!b) {
                                            break Label_0370;
                                        }
                                    }
                                    n3 = this.A * 0.5f * (1 + this.y / 80);
                                }
                                int l = n - 1;
                                while (true) {
                                    while (l >= 0) {
                                        this.o[this.G[l].d()] = n3;
                                        --l;
                                        if (b) {
                                            while (true) {
                                                do {
                                                    double n4 = l;
                                                Label_0422:
                                                    while (n4 < n) {
                                                        final q q2 = this.G[l];
                                                        final int d = q2.d();
                                                        this.b(q2);
                                                        final int d2 = this.J[0].d();
                                                        final int d3 = this.J[1].d();
                                                        final int d4 = this.J[2].d();
                                                        final int ac = this.ac ? 1 : 0;
                                                        if (!b) {
                                                            Label_0593: {
                                                                if (ac != 0) {
                                                                    this.a(0, 1, 0);
                                                                    this.a(0, 2, 2);
                                                                    this.a(1, 2, 4);
                                                                    this.e(d);
                                                                    if (!b) {
                                                                        break Label_0593;
                                                                    }
                                                                }
                                                                this.w[d] = (this.w[d2] + this.w[d3] + this.w[d4]) / 3.0;
                                                                this.x[d] = (this.x[d2] + this.x[d3] + this.x[d4]) / 3.0;
                                                            }
                                                            int n5 = 2;
                                                            while (n5 > 0) {
                                                                this.a(q2, 3);
                                                                this.a(q2);
                                                                this.t[d] = this.r[d];
                                                                this.u[d] = this.s[d];
                                                                this.p[d] = this.q[d];
                                                                final double[] r = this.r;
                                                                final int n6 = d;
                                                                r[n6] *= this.o[d];
                                                                final double[] s = this.s;
                                                                final int n7 = d;
                                                                s[n7] *= this.o[d];
                                                                final double n8 = n4 = dcmpl(this.q[d], 0.0);
                                                                if (b) {
                                                                    continue Label_0422;
                                                                }
                                                                if (n8 != 0) {
                                                                    final double[] r2 = this.r;
                                                                    final int n9 = d;
                                                                    r2[n9] /= this.q[d];
                                                                    final double[] s2 = this.s;
                                                                    final int n10 = d;
                                                                    s2[n10] /= this.q[d];
                                                                }
                                                                final double[] w = this.w;
                                                                final int n11 = d;
                                                                w[n11] += this.r[d];
                                                                final double[] x2 = this.x;
                                                                final int n12 = d;
                                                                x2[n12] += this.s[d];
                                                                --n5;
                                                                if (b) {
                                                                    break;
                                                                }
                                                            }
                                                            ++l;
                                                            continue Label_0420;
                                                        }
                                                        Label_0869: {
                                                            Label_0866: {
                                                                Label_0828: {
                                                                    if (ac < 1) {
                                                                        int n13 = this.D - 1;
                                                                        while (n13 > 0) {
                                                                            this.a(j, true);
                                                                            --n13;
                                                                            if (b) {
                                                                                break Label_0869;
                                                                            }
                                                                            if (b) {
                                                                                break Label_0828;
                                                                            }
                                                                        }
                                                                        break Label_0866;
                                                                    }
                                                                }
                                                                int n14 = (this.C - 1) * (1 + j * j);
                                                                while (n14 > 0) {
                                                                    this.a(j, false);
                                                                    --n14;
                                                                    if (b) {
                                                                        break Label_0869;
                                                                    }
                                                                    if (b) {
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                            --j;
                                                        }
                                                        if (b) {
                                                            break Label_0874;
                                                        }
                                                        continue Label_0298;
                                                    }
                                                    break;
                                                } while (!b);
                                                continue Label_0878_Outer;
                                            }
                                        }
                                        if (b) {
                                            break;
                                        }
                                    }
                                    l = this.F[j + 1];
                                    continue Label_0878_Outer;
                                }
                            }
                            if (n2 != 0) {
                                this.y -= (int)(2.0 * this.N);
                            }
                            int n15 = this.n - 1;
                            while (n15 >= 0) {
                                x.a(this.M[n15], this.w[n15], this.x[n15]);
                                --n15;
                                if (b) {
                                    return;
                                }
                                if (b) {
                                    break;
                                }
                            }
                            this.a();
                            return;
                        }
                        final boolean ae = this.ae;
                        continue;
                    }
                }
                if (b) {
                    break;
                }
            }
            j = this.E - 2;
            continue;
        }
    }
    
    private void a() {
        this.M = null;
        this.aa = null;
        this.U = null;
        this.V = null;
        this.r = null;
        this.s = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.O = null;
        this.P = null;
        this.J = null;
        this.K = null;
        this.F = null;
        this.G = null;
        this.I = null;
    }
    
    private void e(final int n) {
        final boolean b = y.f.e.i.b;
        int i = 0;
    Label_0136_Outer:
        while (i < 6) {
            int j = i + 1;
            while (true) {
                while (j < 6) {
                    this.W[i][j] = (this.W[j][i] = Math.sqrt((this.Y[i] - this.Y[j]) * (this.Y[i] - this.Y[j]) + (this.Z[i] - this.Z[j]) * (this.Z[i] - this.Z[j])));
                    ++j;
                    if (!b) {
                        if (b) {
                            break;
                        }
                        continue Label_0136_Outer;
                    }
                    else {
                        if (b) {
                            break Label_0136_Outer;
                        }
                        continue Label_0136_Outer;
                    }
                }
                ++i;
                continue;
            }
        }
        double n2 = Double.MAX_VALUE;
        int n3 = 0;
        do {
            int k = 0;
        Label_0151:
            while (k < 6) {
                int n4 = n3 + 1;
                do {
                    double n5 = 0.0;
                    Label_0162: {
                        n5 = n4;
                    }
                    Label_0164:
                    while (n5 < 6) {
                        k = n4 + 1;
                        if (!b) {
                            int l = k;
                            while (l < 6) {
                                final double n6 = this.W[n3][n4] + this.W[n3][l] + this.W[n4][l];
                                final double n7 = n5 = dcmpg(n6, n2);
                                if (b) {
                                    continue Label_0164;
                                }
                                if (n7 < 0) {
                                    n2 = n6;
                                    this.X[0] = n3;
                                    this.X[1] = n4;
                                    this.X[2] = l;
                                }
                                ++l;
                                if (b) {
                                    break;
                                }
                            }
                            ++n4;
                            continue Label_0162;
                        }
                        continue Label_0151;
                    }
                    break;
                } while (!b);
                ++n3;
            }
            break;
        } while (!b);
        this.w[n] = (this.Y[this.X[0]] + this.Y[this.X[1]] + this.Y[this.X[2]]) / 3.0;
        this.x[n] = (this.Z[this.X[0]] + this.Z[this.X[1]] + this.Z[this.X[2]]) / 3.0;
    }
    
    private void a(final int n, final int n2, int n3) {
        final boolean b = y.f.e.i.b;
        final int d = this.J[n].d();
        final int d2 = this.J[n2].d();
        final double n4 = this.w[d2] - this.w[d];
        final double n5 = this.x[d2] - this.x[d];
        final double n6 = this.K[n] * this.y * 0.5f;
        final double n7 = this.K[n2] * this.y * 0.5f;
        final double sqrt = Math.sqrt(n4 * n4 + n5 * n5);
        if (sqrt > 0.0) {
            final double n8 = (n7 * n7 - n6 * n6 - sqrt * sqrt) / (-2.0 * sqrt);
            final double n9 = n6 * n6 - n8 * n8;
            if (n9 > 0.0) {
                final double sqrt2 = Math.sqrt(n9);
                this.Y[n3] = this.w[d] + (n4 * n8 + n5 * sqrt2) / sqrt;
                this.Z[n3] = this.x[d] + (n5 * n8 - n4 * sqrt2) / sqrt;
                this.Y[++n3] = this.w[d] + (n4 * n8 - n5 * sqrt2) / sqrt;
                this.Z[n3] = this.x[d] + (n5 * n8 + n4 * sqrt2) / sqrt;
                if (!b) {
                    return;
                }
            }
            double n10 = 0.0;
            Label_0377: {
                if (n6 > n7 + sqrt) {
                    n10 = (n6 + n7 + sqrt) / (2.0 * sqrt);
                    if (!b) {
                        break Label_0377;
                    }
                }
                if (n7 > n6 + sqrt) {
                    n10 = (-n6 + (sqrt - n7)) / (2.0 * sqrt);
                    if (!b) {
                        break Label_0377;
                    }
                }
                n10 = (n6 + (sqrt - n7)) / (2.0 * sqrt);
            }
            this.Y[n3] = (this.Y[1 + n3] = this.w[d] + n4 * n10);
            this.Z[n3] = (this.Z[1 + n3] = this.x[d] + n5 * n10);
            if (!b) {
                return;
            }
        }
        this.Y[n3] = (this.Y[1 + n3] = this.w[d]);
        this.Z[n3] = (this.Z[1 + n3] = this.x[d]);
    }
    
    private void a(final int n, final boolean b) {
        final boolean b2 = y.f.e.i.b;
        final int n2 = this.F[n];
        int i = 0;
        while (true) {
            while (i < n2) {
                final int n3 = b ? 1 : 0;
                if (b2) {
                    int j = n3;
                    while (j < n2) {
                        final int d = this.G[j].d();
                        final double[] w = this.w;
                        final int n4 = d;
                        w[n4] += this.r[d];
                        final double[] x = this.x;
                        final int n5 = d;
                        x[n5] += this.s[d];
                        ++j;
                        if (b2) {
                            break;
                        }
                    }
                    return;
                }
                Label_0059: {
                    if (b) {
                        this.c(this.G[i], n);
                        if (!b2) {
                            break Label_0059;
                        }
                    }
                    this.b(this.G[i], n);
                }
                this.a(this.G[i]);
                final int d2 = this.G[i].d();
                this.t[d2] = this.r[d2];
                this.u[d2] = this.s[d2];
                this.p[d2] = this.q[d2];
                final double[] r = this.r;
                final int n6 = d2;
                r[n6] *= this.o[d2];
                final double[] s = this.s;
                final int n7 = d2;
                s[n7] *= this.o[d2];
                if (this.q[d2] != 0.0) {
                    this.r[d2] /= this.q[d2];
                    this.s[d2] /= this.q[d2];
                }
                ++i;
                if (b2) {
                    break;
                }
            }
            final int n3 = 0;
            continue;
        }
    }
    
    private void n() {
        final boolean b = y.f.e.i.b;
        final int n = this.F[this.E - 1];
        double n2 = 0.0;
        double n3 = 0.0;
        final double n4 = (1 << this.E) * (this.y / 4);
        int i = 0;
        while (true) {
            while (i < this.B) {
                final q q = this.G[i];
                this.w[q.d()] = Math.sin(i * 3.141592653589793 * 2.0 / this.B) * n4;
                this.x[q.d()] = Math.cos(i * 3.141592653589793 * 2.0 / this.B) * n4;
                this.b(q);
                ++i;
                if (b) {
                    while (true) {
                        while (i < n) {
                            n2 += this.w[this.G[i].d()];
                            n3 += this.x[this.G[i].d()];
                            ++i;
                            if (b) {
                                int j = 0;
                                while (j < n) {
                                    this.w[this.G[j].d()] -= n2;
                                    this.x[this.G[j].d()] -= n3;
                                    ++j;
                                    if (b) {
                                        break;
                                    }
                                }
                                return;
                            }
                            if (b) {
                                break;
                            }
                        }
                        n2 /= n;
                        n3 /= n;
                        continue;
                    }
                }
                if (b) {
                    break;
                }
            }
            i = 0;
            continue;
        }
    }
    
    private void d(final X l) {
        final boolean b = y.f.e.i.b;
        this.L = l;
        Label_0045: {
            if (this.ad) {
                this.Q = new ar(42L);
                if (!b) {
                    break Label_0045;
                }
            }
            this.Q = new ar();
        }
        y.f.ae.a(l, true);
        this.n = l.f();
        this.ab = 0;
        this.aa = new y.g.c(this.n + 1);
        this.U = new int[this.n];
        this.V = new int[this.n];
        this.J = new q[3];
        this.K = new int[3];
        this.z = this.y * this.y;
        this.S = this.z * this.y / (2.0 * this.R);
        this.T = 1.0 / (2.0 * this.R * this.y);
        this.B = Math.min(this.n, this.B);
        this.H = a(l, this.B);
        this.E = this.H.a;
        this.F = this.H.b;
        this.G = this.H.c;
        this.I = this.H.d;
        this.o = new double[this.n];
        this.p = new double[this.n];
        this.q = new double[this.n];
        this.r = new double[this.n];
        this.s = new double[this.n];
        this.t = new double[this.n];
        this.u = new double[this.n];
        this.v = new double[this.n];
        this.w = new double[this.n];
        this.x = new double[this.n];
        this.o();
        this.P = new b[this.n][this.E];
        int i = 0;
        while (i < this.n) {
            this.o[i] = this.A;
            this.v[i] = 1.0;
            this.t[i] = 0.0;
            this.u[i] = 0.0;
            this.r[i] = 0.0;
            this.s[i] = 0.0;
            this.w[i] = l.j(this.M[i]);
            this.x[i] = l.k(this.M[i]);
            ++i;
            if (b) {
                break;
            }
        }
    }
    
    private void a(final q q, final int n) {
        final boolean b = y.f.e.i.b;
        final int d = q.d();
        final double n2 = this.w[d];
        final double n3 = this.x[d];
        double n4 = 0.0;
        double n5 = 0.0;
        int i = n - 1;
        while (i >= 0) {
            final int d2;
            final double n6 = this.w[d2 = this.J[i].d()] - n2;
            final double n7 = this.x[d2] - n3;
            final double n8 = n6 * n6 + n7 * n7;
            if (b) {
                return;
            }
            if (n8 > 0.0) {
                final int n9 = this.K[i];
                final double n10 = (n8 / (n9 * n9 * this.z) - 1.0) / (Math.sqrt(n8) * n9);
                n4 += n10 * n6;
                n5 += n10 * n7;
            }
            --i;
            if (b) {
                break;
            }
        }
        this.r[d] = n4;
        this.s[d] = n5;
        this.q[d] = Math.sqrt(n4 * n4 + n5 * n5);
    }
    
    private void b(final q q, final int n) {
        final boolean b = y.f.e.i.b;
        final int d = q.d();
        final q[] a = this.P[d][n].a;
        final int[] b2 = this.P[d][n].b;
        double n2 = 0.0;
        double n3 = 0.0;
        int i = this.O[n] - 1;
        while (i >= 0) {
            final int d2 = a[i].d();
            final int n4 = b2[i];
            if (b) {
                return;
            }
            if (n4 != 0) {
                double a2 = this.w[d2] - this.w[d];
                double a3 = this.x[d2] - this.x[d];
                double n5 = a2 * a2 + a3 * a3;
                if (n5 == 0.0) {
                    a2 = this.Q.a(-0.5, 0.5);
                    a3 = this.Q.a(-0.5, 0.5);
                    n5 = 0.01;
                }
                final double n6 = (n5 / (n4 * n4 * this.z) - 1.0) / (Math.sqrt(n5) * n4);
                n2 += a2 * n6;
                n3 += a3 * n6;
            }
            --i;
            if (b) {
                break;
            }
        }
        this.r[d] = n2;
        this.s[d] = n3;
        this.q[d] = Math.sqrt(n2 * n2 + n3 * n3);
    }
    
    private void c(final q q, final int n) {
        final boolean b = y.f.e.i.b;
        final int d = q.d();
        final q[] a = this.P[d][n].a;
        double n3;
        double n2 = n3 = 0.0;
        d d2 = q.g();
        while (true) {
            while (d2 != null) {
                final int d3;
                final double n4 = this.w[d3 = d2.c().d()] - this.w[d];
                final double n5 = this.x[d3] - this.x[d];
                final double n6 = Math.sqrt(n4 * n4 + n5 * n5) * this.T;
                n3 += n4 * n6;
                n2 += n5 * n6;
                d2 = d2.h();
                if (b) {
                    while (true) {
                        while (d2 != null) {
                            final int d4;
                            final double n7 = this.w[d4 = d2.d().d()] - this.w[d];
                            final a a2 = this;
                            if (b) {
                                int i = a2.O[n] - 1;
                                while (i >= 0) {
                                    final int d5;
                                    double a3 = this.w[d] - this.w[d5 = a[i].d()];
                                    double a4 = this.x[d] - this.x[d5];
                                    double n8 = a3 * a3 + a4 * a4;
                                    if (b) {
                                        return;
                                    }
                                    if (n8 == 0.0) {
                                        a3 = this.Q.a(-0.5, 0.5);
                                        a4 = this.Q.a(-0.5, 0.5);
                                        n8 = 0.01;
                                    }
                                    final double n9 = this.S / (n8 * Math.sqrt(n8));
                                    n3 += a3 * n9;
                                    n2 += a4 * n9;
                                    --i;
                                    if (b) {
                                        break;
                                    }
                                }
                                this.r[d] = n3;
                                this.s[d] = n2;
                                this.q[d] = Math.sqrt(n3 * n3 + n2 * n2);
                                return;
                            }
                            final double n10 = this.x[d4] - this.x[d];
                            final double n11 = Math.sqrt(n7 * n7 + n10 * n10) * this.T;
                            n3 += n7 * n11;
                            n2 += n10 * n11;
                            d2 = d2.g();
                            if (b) {
                                break;
                            }
                        }
                        final a a2 = this;
                        continue;
                    }
                }
                if (b) {
                    break;
                }
            }
            d2 = q.f();
            continue;
        }
    }
    
    private void a(final q q) {
        final int d = q.d();
        double n = this.o[d];
        final double n2 = this.p[d];
        final double n3 = this.q[d];
        if (n3 != 0.0 && n2 != 0.0) {
            final double n4 = (this.r[d] * this.t[d] + this.s[d] * this.u[d]) / (n3 * n2);
            Label_0119: {
                if (this.v[d] * n4 > 0.0) {
                    n += n4 * 0.45;
                    if (!y.f.e.i.b) {
                        break Label_0119;
                    }
                }
                n += n4 * 0.15;
            }
            this.v[d] = n4;
            this.o[d] = n;
        }
    }
    
    private void o() {
        final boolean b = y.f.e.i.b;
        final double n = 10000.0;
        int n2 = 0;
        double n3 = this.L.g() * 2;
        if (n3 < n) {
            n3 = n;
        }
        int i = 0;
        while (true) {
            while (i < this.E) {
                final double n4 = dcmpg(this.F[i] * this.F[i] - n, 0.0);
                if (b) {
                    double n5 = n4;
                    while (n5 < this.E) {
                        Label_0200: {
                            if (n5 >= n2) {
                                this.O[n5] = Math.max(this.F[n5] - 1, this.B - 1);
                                if (!b) {
                                    break Label_0200;
                                }
                            }
                            this.O[n5] = Math.max(this.B - 1, Math.min((int)(a((int)n5, 0, 2, 10000, 1) * n3 / this.F[n5]), this.F[n5] - 1));
                        }
                        ++n5;
                        if (b) {
                            break;
                        }
                    }
                    this.O[0] = Math.min(2 * this.O[0], this.n - 1);
                    return;
                }
                if (n4 <= 0) {
                    n2 = i;
                    if (!b) {
                        break;
                    }
                }
                ++i;
                if (b) {
                    break;
                }
            }
            this.O = new int[this.E];
            continue;
        }
    }
    
    private static final double a(final int n, final int n2, final int n3, final int n4, final int n5) {
        if (n <= n2) {
            return n3;
        }
        if (n2 <= n && n <= n4) {
            return (n5 - n3) / (n4 - n2) * (n - n2) + n3;
        }
        return n5;
    }
    
    private void b(final q q) {
        final boolean b = y.f.e.i.b;
        final int n = ++this.ab;
        final int d = q.d();
        this.aa.c();
        int n2 = 0;
        int n3 = 0;
        final int n4 = 3;
        int n5 = 0;
        final int[] array = new int[this.I[d] + 1];
        int i = this.I[d];
        while (i >= 0) {
            this.P[d][i] = new b();
            this.P[d][i].a = new q[this.O[i]];
            this.P[d][i].b = new int[this.O[i]];
            --i;
            if (b) {
                break;
            }
        }
        int n6 = 1;
        q q2 = q;
    Label_0476_Outer:
        while (true) {
            this.U[q2.d()] = n;
            int n7 = 1;
            d d2 = q2.g();
            if (d2 == null) {
                d2 = q2.f();
                n7 = 0;
            }
            while (true) {
                while (d2 != null) {
                    final int n8 = n7;
                    Label_0531: {
                        int n9 = 0;
                        int n10 = 0;
                        Label_0502: {
                            if (!b) {
                                final q q3 = (n8 != 0) ? d2.c() : d2.d();
                                final int d3 = q3.d();
                                if (this.U[d3] != n) {
                                    this.U[d3] = n;
                                    this.aa.b(q3);
                                    this.V[d3] = n6;
                                    final int min = Math.min(this.I[d3], this.I[d]);
                                    int j = n5;
                                    while (j <= min) {
                                        n9 = array[j];
                                        n10 = this.O[j];
                                        if (b) {
                                            break Label_0502;
                                        }
                                        Label_0358: {
                                            if (n9 < n10) {
                                                this.P[d][j].a[array[j]] = q3;
                                                this.P[d][j].b[array[j]++] = n6;
                                                if (!b) {
                                                    break Label_0358;
                                                }
                                            }
                                            if (j == n5) {
                                                ++n5;
                                            }
                                        }
                                        ++j;
                                        if (b) {
                                            break;
                                        }
                                    }
                                    if (n2 == 0 && n3 < n4 && this.I[d3] > this.I[d]) {
                                        this.K[n3] = n6;
                                        this.J[n3++] = q3;
                                        if (n3 == n4) {
                                            n2 = 1;
                                        }
                                    }
                                }
                                if (n7 != 0) {
                                    d2 = d2.h();
                                    if (d2 != null) {
                                        continue Label_0476_Outer;
                                    }
                                    n7 = 0;
                                    d2 = q2.f();
                                    if (!b) {
                                        continue Label_0476_Outer;
                                    }
                                }
                                d2 = d2.g();
                                if (b) {
                                    break;
                                }
                                continue Label_0476_Outer;
                            }
                            else {
                                if (n8 != 0) {
                                    break Label_0531;
                                }
                                q2 = (q)this.aa.a();
                                final int n11 = this.V[q2.d()];
                            }
                        }
                        n6 = n9 + n10;
                        if ((n2 == 0 || n5 <= this.I[d]) && this.aa.d() >= 0) {
                            continue Label_0476_Outer;
                        }
                    }
                    if (!b) {
                        break Label_0476_Outer;
                    }
                    break;
                }
                this.aa.e();
                continue;
            }
        }
    }
    
    public void g(final boolean ac) {
        this.ac = ac;
    }
    
    public void h(final boolean ad) {
        this.ad = ad;
    }
    
    public void i(final boolean ae) {
        this.ae = ae;
    }
    
    static int[] a(final X x, final q[] array, final int n, final int n2) {
        final boolean b = i.b;
        final int n3 = 1 << n2;
        int n4 = 0;
        final int[] array2 = new int[n + 1];
        Arrays.fill(array2, -1);
        final y.g.c c = new y.g.c(x.e());
        final y.g.c c2 = new y.g.c(x.e() + n3 + 1);
        final int[] array3 = new int[x.e()];
        int i = 0;
        while (true) {
        Label_0232_Outer:
            while (i < array.length) {
                final int[] array4 = array3;
                if (b) {
                    final int[] array5 = array4;
                    int j = 0;
                    while (true) {
                        while (j < n) {
                            final int[] array6 = array2;
                            final int n5 = j + 1;
                            if (b) {
                                array6[n5] = n4;
                                return array2;
                            }
                            Label_0224: {
                                if (array6[n5] == -1) {
                                    a(x, array[j], n3, j + 1, c2, array5, c);
                                    ++n4;
                                    array2[j + 1] = 1;
                                    c.a();
                                    while (!c.e()) {
                                        final int n6 = array3[((q)c.a()).d()];
                                        if (n6 < n) {
                                            array2[n6 + 1] = 0;
                                            if (b) {
                                                break Label_0224;
                                            }
                                            if (b) {
                                                break;
                                            }
                                            continue Label_0232_Outer;
                                        }
                                    }
                                }
                                ++j;
                            }
                            if (b) {
                                break;
                            }
                        }
                        continue;
                    }
                }
                array4[array[i].d()] = i;
                ++i;
                if (b) {
                    break;
                }
            }
            final int[] array7 = new int[x.e()];
            continue;
        }
    }
    
    static void a(final X x, q q, int n, final int n2, final y.g.c c, final int[] array, final y.g.c c2) {
        final boolean b = i.b;
        c.c();
        c.a(q);
        c.a(null);
    Label_0255:
        while (!c.e()) {
            q = (q)c.a();
            if (q == null) {
                if (--n == 0) {
                    break;
                }
                if (c.e()) {
                    break;
                }
                if (!c.e()) {
                    c.a(null);
                    q = (q)c.a();
                    if (q == null) {
                        break;
                    }
                }
            }
            c2.a(q);
            array[q.d()] = n2;
            d d = q.f();
            q q2 = null;
            int n3 = 0;
            int n5;
            int n4 = 0;
            int n6 = 0;
            int n7;
            Label_0136_Outer:Label_0186_Outer:
            while (true) {
                while (true) {
                Label_0216:
                    while (true) {
                        Label_0180: {
                            if (d == null) {
                                break Label_0180;
                            }
                            q2 = d.d();
                            n3 = q2.d();
                            n4 = (n5 = array[n3]);
                            n6 = n2;
                            n7 = n2;
                            if (b) {
                                break Label_0216;
                            }
                            if (n5 != n7 && array[n3] != -n2) {
                                c.a(q2);
                                array[n3] = -n2;
                            }
                            d = d.g();
                            if (!b) {
                                continue Label_0136_Outer;
                            }
                        }
                        d = q.g();
                        if (d == null) {
                            break;
                        }
                        q2 = d.c();
                        n3 = q2.d();
                        n4 = (n5 = array[n3]);
                        n6 = n2;
                        n7 = n2;
                        if (b) {
                            continue Label_0186_Outer;
                        }
                        break;
                    }
                    if (n4 != n6 && array[n3] != -n2) {
                        c.a(q2);
                        array[n3] = -n2;
                    }
                    d = d.h();
                    if (b) {
                        break Label_0255;
                    }
                    continue;
                }
            }
        }
    }
    
    private static final y.f.e.c a(final X x, final int n) {
        final boolean b = i.b;
        final int f = x.f();
        int a = (int)(Math.log(f) / Math.log(10.0)) + 2;
        final int[] b2 = new int[a];
        final int[] d = new int[f];
        final y.f.e.c c = new y.f.e.c();
        final q[] a2 = w.a(x);
        int i = 0;
        while (true) {
        Label_0272_Outer:
            while (i < f) {
                d[i] = 0;
                ++i;
                if (b) {
                    int j = 1;
                Label_0087:
                    while (true) {
                    Label_0205_Outer:
                        while (j < a) {
                            final int[] a3 = a(x, a2, b2[j - 1], j);
                            b2[j] = a3[0];
                            int n2 = 0;
                            final int n3 = 1;
                            if (!b) {
                                int k = n3;
                                while (true) {
                                    while (k <= b2[j - 1]) {
                                        final int n4 = a3[k];
                                        final int n5 = 1;
                                        if (!b) {
                                            if (n4 == n5) {
                                                d[a2[k - 1].d()] = j;
                                                a(a2, n2++, k - 1);
                                            }
                                            ++k;
                                            if (b) {
                                                break;
                                            }
                                            continue Label_0205_Outer;
                                        }
                                        else {
                                            Label_0258: {
                                                if (n4 < n5) {
                                                    int l = b2[j];
                                                    while (true) {
                                                        while (l < n) {
                                                            d[a2[l].d()] = j;
                                                            ++l;
                                                            if (b) {
                                                                a = j + 1;
                                                                break Label_0258;
                                                            }
                                                            if (b) {
                                                                break;
                                                            }
                                                        }
                                                        b2[j] = n;
                                                        continue Label_0272_Outer;
                                                    }
                                                }
                                            }
                                            ++j;
                                            if (b) {
                                                break Label_0205_Outer;
                                            }
                                            continue Label_0087;
                                        }
                                    }
                                    final int n6 = b2[j];
                                    continue Label_0272_Outer;
                                }
                            }
                            if (n3 > n) {
                                int n7 = n;
                                while (n7 < b2[a - 1]) {
                                    d[a2[n7].d()] = a - 2;
                                    ++n7;
                                    if (b) {
                                        return c;
                                    }
                                    if (b) {
                                        break;
                                    }
                                }
                                b2[a - 1] = n;
                            }
                            c.a = a;
                            c.b = b2;
                            c.c = a2;
                            c.d = d;
                            return c;
                        }
                        final int n8 = b2[a - 1];
                        continue;
                    }
                }
                if (b) {
                    break;
                }
            }
            b2[0] = f;
            continue;
        }
    }
    
    private static void a(final q[] array, final int n, final int n2) {
        final q q = array[n];
        array[n] = array[n2];
        array[n2] = q;
    }
}
