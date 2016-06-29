package y.a;

import java.util.*;
import y.c.*;
import y.g.a.*;

class F
{
    private i a;
    private int[] b;
    private int[] c;
    private int[] d;
    private q e;
    private int[] f;
    private int[] g;
    private d[] h;
    private int[] i;
    private I[] j;
    private H k;
    private boolean[] l;
    private I m;
    private int[] n;
    private int[] o;
    private int p;
    private int q;
    private boolean[] r;
    private int[] s;
    private int[] t;
    private int[] u;
    private d[] v;
    private int[] w;
    private int[] x;
    private ArrayList y;
    private ArrayList z;
    private H[] A;
    private H[] B;
    
    public int a(final i i, final A a, final c c, final c c2, final c c3, final q q, final boolean b) {
        return this.a(i, a, c, c2, c3, q, b, Long.MAX_VALUE);
    }
    
    public int a(final i a, final A a2, final c c, final c c2, final c c3, final q q, final boolean b, final long n) {
        final boolean a3 = y.a.h.a;
        if (a.f() < 1) {
            return 0;
        }
        if (a.f() == 1) {
            a2.a(a.k(), 0);
            return 1;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        this.a = a;
        this.a(a2, c, c2, b, q, c3, n, currentTimeMillis);
        while (true) {
            while (System.currentTimeMillis() - currentTimeMillis < n) {
                final F f = this;
                if (a3) {
                    final int f2 = f.f();
                    final x o = a.o();
                    while (o.f()) {
                        a2.a(o.e(), this.d[o.e().d()]);
                        o.g();
                        if (a3) {
                            break;
                        }
                    }
                    return f2;
                }
                final d e;
                if ((e = this.e()) == null) {
                    break;
                }
                this.b(e, this.a(e));
                if (a3) {
                    break;
                }
            }
            final F f = this;
            continue;
        }
    }
    
    private void a(final A a, final c c, final c c2, final boolean b, final q e, final c c3, final long n, final long n2) {
        final boolean a2 = y.a.h.a;
        this.p = this.a.f();
        this.q = this.a.h();
        this.b = new int[this.q];
        Label_0148: {
            Label_0138: {
                Label_0104: {
                    if (c != null) {
                        final e p8 = this.a.p();
                        while (p8.f()) {
                            final d a3 = p8.a();
                            this.b[a3.b()] = c.a(a3);
                            p8.g();
                            if (a2) {
                                break Label_0148;
                            }
                            if (a2) {
                                break Label_0104;
                            }
                        }
                        break Label_0138;
                    }
                }
                int i = 0;
                while (i < this.b.length) {
                    this.b[i] = 1;
                    ++i;
                    if (a2) {
                        break Label_0148;
                    }
                    if (a2) {
                        break;
                    }
                }
            }
            this.c = new int[this.q];
        }
        Label_0259: {
            Label_0249: {
                Label_0215: {
                    if (c2 != null) {
                        final e p9 = this.a.p();
                        while (p9.f()) {
                            final d a4 = p9.a();
                            this.c[a4.b()] = c2.a(a4);
                            p9.g();
                            if (a2) {
                                break Label_0259;
                            }
                            if (a2) {
                                break Label_0215;
                            }
                        }
                        break Label_0249;
                    }
                }
                int j = 0;
                while (j < this.b.length) {
                    this.c[j] = 1;
                    ++j;
                    if (a2) {
                        break Label_0259;
                    }
                    if (a2) {
                        break;
                    }
                }
            }
            this.d = new int[this.p];
        }
        Label_0382: {
            Label_0331: {
                Label_0327: {
                    if (b) {
                        final x o = this.a.o();
                        while (o.f()) {
                            final q e2 = o.e();
                            this.d[e2.d()] = a.a(e2);
                            o.g();
                            if (a2) {
                                break Label_0382;
                            }
                            if (a2) {
                                break Label_0327;
                            }
                        }
                        break Label_0331;
                    }
                }
                this.b();
            }
            this.f = new int[this.p];
            this.g = new int[this.p];
            this.i = new int[this.p];
            this.h = new d[this.p];
            this.n = new int[this.q];
        }
        this.o = (int[])(this.a() ? new int[this.q] : null);
        this.m = new I();
        Label_0446: {
            if (e == null) {
                this.e = this.a.o().e();
                if (!a2) {
                    break Label_0446;
                }
            }
            this.e = e;
        }
        this.A = new H[this.q];
        this.B = new H[this.q];
        final e p10 = this.a.p();
        while (true) {
            while (p10.f()) {
                final d a5 = p10.a();
                final int b2 = a5.b();
                this.A[b2] = new H(b2, a5);
                this.B[b2] = new H(b2, a5);
                p10.g();
                if (a2) {
                    int k = 0;
                    while (true) {
                        while (k < this.j.length) {
                            this.j[k] = new I();
                            ++k;
                            if (a2) {
                                int d = 0;
                                Label_0771: {
                                    if (c3 != null) {
                                        final e p11 = this.a.p();
                                        while (p11.f()) {
                                            final d a6 = p11.a();
                                            final int n3 = d = (c3.d(a6) ? 1 : 0);
                                            if (a2) {
                                                break Label_0771;
                                            }
                                            if (n3 != 0) {
                                                this.l[a6.b()] = true;
                                            }
                                            p11.g();
                                        }
                                    }
                                    else {
                                        this.a(n);
                                    }
                                    this.c();
                                    this.k = this.m.a;
                                    this.r = new boolean[this.q];
                                    this.s = new int[this.p];
                                    this.u = new int[this.p];
                                    this.w = new int[this.q];
                                    this.x = new int[this.q];
                                    this.v = this.a.n();
                                    d = 0;
                                }
                                int l = d;
                                while (true) {
                                    while (l < this.q) {
                                        final d d2 = this.v[l];
                                        this.w[l] = d2.c().d();
                                        this.x[l] = d2.d().d();
                                        ++l;
                                        if (a2) {
                                            if (n - System.currentTimeMillis() + n2 > 0L) {
                                                this.d();
                                            }
                                            return;
                                        }
                                        if (a2) {
                                            break;
                                        }
                                    }
                                    this.y = new ArrayList(this.p);
                                    this.z = new ArrayList(this.p);
                                    this.t = new int[this.p];
                                    continue;
                                }
                            }
                            if (a2) {
                                break;
                            }
                        }
                        this.l = new boolean[this.q];
                        continue;
                    }
                }
                if (a2) {
                    break;
                }
            }
            this.j = new I[this.p];
            continue;
        }
    }
    
    private boolean a() {
        final boolean a = y.a.h.a;
        int n = 0;
        int i = 0;
        int n2 = 0;
        while (i < this.b.length) {
            n = (n2 = n + this.b[i]);
            if (a) {
                return n2 != 0;
            }
            if (n2 < 0) {
                return true;
            }
            ++i;
            if (a) {
                break;
            }
        }
        return n2 != 0;
    }
    
    private void b() {
        final boolean a = y.a.h.a;
        final x a2 = y.a.m.a(this.a).a();
        do {
            Label_0018: {
                a2.f();
            }
            int i = 0;
            Label_0024:
            while (i != 0) {
                final q e = a2.e();
                final int n = this.d[e.d()];
                final e l = e.l();
                while (l.f()) {
                    final d a3 = l.a();
                    i = n + this.c[a3.b()];
                    if (a) {
                        continue Label_0024;
                    }
                    if (i > this.d[a3.d().d()]) {
                        this.d[a3.d().d()] = n + this.c[a3.b()];
                    }
                    l.g();
                    if (a) {
                        break;
                    }
                }
                a2.g();
                continue Label_0018;
            }
            break;
        } while (!a);
    }
    
    private void a(final long n) {
        final boolean a = y.a.h.a;
        new ab().a(this.a, this.d, this.c, n);
        final ArrayList list = new ArrayList<q>();
        list.add(this.e);
        final boolean[] array = new boolean[this.p];
        final e[] array2 = new e[this.p];
        final x o = this.a.o();
        while (o.f()) {
            array2[o.e().d()] = o.e().j();
            o.g();
            if (a) {
                return;
            }
            if (a) {
                break;
            }
        }
    Label_0126:
        while (true) {
            list.isEmpty();
            boolean b = false;
        Label_0131:
            while (!b) {
                final q q = list.get(list.size() - 1);
                array[q.d()] = true;
                final e e = array2[q.d()];
                while (e.f()) {
                    final d a2 = e.a();
                    final q a3 = a2.a(q);
                    b = array[a3.d()];
                    if (a) {
                        continue Label_0131;
                    }
                    if (!b && this.d[a2.d().d()] - this.d[a2.c().d()] - this.c[a2.b()] == 0) {
                        this.l[a2.b()] = true;
                        list.add(a3);
                        if (!a) {
                            break;
                        }
                    }
                    e.g();
                    if (a) {
                        break;
                    }
                }
                if (list.get(list.size() - 1) != q) {
                    continue Label_0126;
                }
                list.remove(list.size() - 1);
                if (a) {
                    break;
                }
                continue Label_0126;
            }
        }
    }
    
    private void c() {
        final boolean a = y.a.h.a;
        final ArrayList list = new ArrayList<q>();
        list.add(this.e);
        final boolean[] array = new boolean[this.p];
        final e[] array2 = new e[this.p];
        final x o = this.a.o();
        while (o.f()) {
            array2[o.e().d()] = o.e().j();
            o.g();
            if (a) {
                return;
            }
            if (a) {
                break;
            }
        }
    Label_0095:
        while (true) {
            list.isEmpty();
            boolean b = false;
        Label_0099:
            while (!b) {
                final q q = list.get(list.size() - 1);
                array[q.d()] = true;
                final e e = array2[q.d()];
                while (e.f()) {
                    final d a2 = e.a();
                    final q a3 = a2.a(q);
                    b = array[a3.d()];
                    if (a) {
                        continue Label_0099;
                    }
                    if (!b && this.l[a2.b()]) {
                        final H h = this.A[a2.b()];
                        h.d = a3.d();
                        this.j[q.d()].a(h);
                        this.h[a3.d()] = a2;
                        this.m.a(this.B[a2.b()]);
                        list.add(a3);
                        if (!a) {
                            break;
                        }
                    }
                    e.g();
                    if (a) {
                        break;
                    }
                }
                if (list.get(list.size() - 1) != q) {
                    continue Label_0095;
                }
                list.remove(list.size() - 1);
                if (a) {
                    break;
                }
                continue Label_0095;
            }
        }
    }
    
    private void d() {
        final boolean a = y.a.h.a;
        this.a(this.e, null, 1, 0);
        final int f = this.a.f();
        final a a2 = new a(this.a, f + 1);
        final x o = this.a.o();
        while (o.f()) {
            final q e = o.e();
            a2.a(e, f - this.i[e.d()]);
            o.g();
            if (a) {
                return;
            }
            if (a) {
                break;
            }
        }
        while (!a2.a()) {
            this.a(a2.c());
            if (a) {
                return;
            }
            if (a) {
                break;
            }
        }
        a2.b();
    }
    
    private void a(final q q) {
        final boolean a = y.a.h.a;
        if (q == this.e) {
            return;
        }
        final d d = this.h[q.d()];
        int n = this.b[d.b()];
        int n2 = 0;
        final J j = new J(null);
        F f = null;
        Label_0469: {
            Label_0458: {
                Label_0210: {
                    if (this.o == null) {
                        final e i = q.j();
                        while (i.f()) {
                            final d a2 = i.a();
                            final int b = a2.b();
                            f = this;
                            if (a) {
                                break Label_0469;
                            }
                            Label_0198: {
                                if (this.l[b]) {
                                    if (a2 == d) {
                                        break Label_0198;
                                    }
                                    if (this.a(a2, d)) {
                                        n += this.n[b] - this.b[b];
                                        if (!a) {
                                            break Label_0198;
                                        }
                                    }
                                    n += this.b[b] - this.n[b];
                                    if (!a) {
                                        break Label_0198;
                                    }
                                }
                                if (this.a(d, a2)) {
                                    n -= this.b[b];
                                    if (!a) {
                                        break Label_0198;
                                    }
                                }
                                n += this.b[b];
                            }
                            i.g();
                            if (a) {
                                break Label_0210;
                            }
                        }
                        break Label_0458;
                    }
                }
                final e k = q.j();
                while (k.f()) {
                    final d a3 = k.a();
                    final int b2 = a3.b();
                    f = this;
                    if (a) {
                        break Label_0469;
                    }
                    Label_0446: {
                        if (this.l[b2]) {
                            if (a3 == d) {
                                break Label_0446;
                            }
                            Label_0368: {
                                if (this.a(a3, d)) {
                                    b(this.o[b2], this.n[b2], 0, this.b[b2], j);
                                    a(n2, n, j.a, j.b, j);
                                    if (!a) {
                                        break Label_0368;
                                    }
                                }
                                b(0, this.b[b2], this.o[b2], this.n[b2], j);
                                a(n2, n, j.a, j.b, j);
                            }
                            n2 = j.a;
                            n = j.b;
                            if (!a) {
                                break Label_0446;
                            }
                        }
                        Label_0433: {
                            if (this.a(a3, d)) {
                                b(n2, n, 0, this.b[b2], j);
                                if (!a) {
                                    break Label_0433;
                                }
                            }
                            a(n2, n, 0, this.b[b2], j);
                        }
                        n2 = j.a;
                        n = j.b;
                    }
                    k.g();
                    if (a) {
                        break;
                    }
                }
            }
            this.n[d.b()] = n;
            f = this;
        }
        if (f.o != null) {
            this.o[d.b()] = n2;
        }
    }
    
    private boolean a(final d d, final d d2) {
        return d.c() == d2.d() || d.d() == d2.c();
    }
    
    private void a(final q q, final q q2, final int n, final int n2) {
        this.b(q, q2, n, n2);
    }
    
    private void b(final q q, final q q2, final int n, int n2) {
        final boolean a = y.a.h.a;
        int i = 0;
        final int n3 = (q2 == null) ? -1 : q2.d();
        final int d = q.d();
        final int[] t = this.t;
        t[0] = d;
        final int[] u = this.u;
        u[d] = 0;
        final int[] c = this.c;
        final I[] j = this.j;
        final int[] d2 = this.d;
        final d[] h = this.h;
        final int[] s = this.s;
        final int[] g = this.g;
        final int[] k = this.i;
        final int[] f = this.f;
        final int[] w = this.w;
        final int[] x = this.x;
        int n4 = n;
    Label_0347:
        while (i >= 0) {
            final int n5 = t[i];
            Label_0317: {
                if (s[n5] % 2 == 0) {
                    int n6 = u[n5];
                    final int[] array = s;
                    final int n7 = n5;
                    ++array[n7];
                    g[n5] = n4;
                    k[n5] = n2;
                    if (n5 == n3) {
                        final int b = h[n3].b();
                        final int n8 = w[b];
                        final int n9 = x[b];
                        n6 = ((n8 == n3) ? (-c[b] - d2[n8] + d2[n9]) : (c[b] + d2[n8] - d2[n9]));
                    }
                    final int[] array2 = d2;
                    final int n10 = n5;
                    array2[n10] += n6;
                    ++n2;
                    H h2 = j[n5].a;
                    while (h2 != null) {
                        final int d3;
                        u[d3 = h2.d] = n6;
                        t[++i] = d3;
                        h2 = h2.a;
                        if (a) {
                            break Label_0347;
                        }
                        if (a) {
                            break Label_0317;
                        }
                    }
                    continue;
                }
            }
            final int[] array3 = s;
            final int n11 = n5;
            ++array3[n11];
            f[n5] = n4++;
            --i;
            --n2;
            if (a) {
                break;
            }
        }
    }
    
    private boolean a(final d d, final q q) {
        return !this.a(d, q, this.e);
    }
    
    private boolean a(final d d, final q q, final q q2) {
        return this.a(d.d().d(), d.c().d(), q.d(), q2.d());
    }
    
    private boolean a(final int n, final int n2, final int n3, final int n4) {
        int n5 = 0;
        int n6 = 0;
        Label_0053: {
            if (this.f[n] > this.f[n2]) {
                n5 = this.f[n2];
                n6 = this.g[n2];
                if (!y.a.h.a) {
                    break Label_0053;
                }
            }
            n5 = this.f[n];
            n6 = this.g[n];
        }
        final int n7 = this.f[n3];
        final int n8 = this.f[n4];
        return (n6 > n7 || n6 > n8 || n5 < n7 || n5 < n8) && ((n6 <= n7 && n5 >= n7) || (n6 <= n8 && n5 >= n8));
    }
    
    private q a(q q, q q2, final ArrayList list, final boolean[] array) {
        final boolean a = y.a.h.a;
        int n = q.d();
        int n2 = q2.d();
        this.z.clear();
    Label_0183:
        while (true) {
        Label_0222:
            while (true) {
                while (this.i[n] < this.i[n2]) {
                    final d d = this.h[n2];
                    this.z.add(d);
                    if (a) {
                        int add = 0;
                        Label_0312: {
                            if (q != q2) {
                                final d d2 = this.h[n];
                                add = (list.add(d2) ? 1 : 0);
                                if (a) {
                                    break Label_0312;
                                }
                                final boolean[] array2 = array;
                                d2.b();
                                d2.c();
                                final int b;
                                final q c;
                                final q q3;
                                array2[b] = (c != q3);
                                q = d2.a(q);
                                n = q.d();
                                final d d3 = this.h[n2];
                                this.z.add(d3);
                                array[d3.b()] = (d3.d() != q2);
                                q2 = d3.a(q2);
                                n2 = q2.d();
                                if (!a) {
                                    continue Label_0183;
                                }
                            }
                            add = this.z.size() - 1;
                        }
                        int i = add;
                        while (i >= 0) {
                            list.add(this.z.get(i));
                            --i;
                            if (a) {
                                break;
                            }
                        }
                        return q;
                    }
                    array[d.b()] = (d.d() != q2);
                    q2 = d.a(q2);
                    n2 = q2.d();
                    if (a) {
                        break;
                    }
                }
                while (this.i[n] > this.i[n2]) {
                    final d d2 = this.h[n];
                    list.add(d2);
                    final boolean[] array2 = array;
                    final int b = d2.b();
                    final q c = d2.c();
                    final q q3 = q;
                    if (a) {
                        continue Label_0222;
                    }
                    array[b] = (c != q3);
                    q = d2.a(q);
                    n = q.d();
                    if (a) {
                        break;
                    }
                }
                break;
            }
            continue Label_0183;
        }
    }
    
    private d e() {
        final boolean a = y.a.h.a;
        final int[] n = this.n;
        final int[] o = this.o;
        H k = this.k;
        int n2 = 0;
        while (n2++ < this.p) {
            if (k == null) {
                k = this.m.a;
            }
            if ((o == null && n[k.c] < 0) || (o != null && o[k.c] < 0)) {
                final d e = k.e;
                this.k = k.a;
                return e;
            }
            k = k.a;
            if (a) {
                break;
            }
        }
        this.k = k;
        return null;
    }
    
    private d a(final d d) {
        final boolean a = y.a.h.a;
        int n = -1;
        int n2 = Integer.MAX_VALUE;
        final int d2 = d.c().d();
        final int d3 = d.d().d();
        final int[] f = this.f;
        final int n3 = f[d3];
        int n4 = 0;
        int n5 = 0;
        Label_0092: {
            if (f[d2] > f[d3]) {
                n4 = f[d3];
                n5 = this.g[d3];
                if (!a) {
                    break Label_0092;
                }
            }
            n4 = f[d2];
            n5 = this.g[d2];
        }
        final int[] w = this.w;
        final int[] x = this.x;
        final int[] d4 = this.d;
        final int[] c = this.c;
        int i = this.q - 1;
        while (i >= 0) {
            final int n6 = w[i];
            final int n7 = x[i];
            final int n8 = d4[n7] - d4[n6] - c[i];
            Label_0275: {
                if (n2 > n8) {
                    final int n9 = f[n6];
                    final int n10 = f[n7];
                    if (n5 > n10 || n4 < n10 || ((n5 > n9 || n4 < n9) && (n5 > n3 || n4 < n3))) {
                        if (n5 > n10 || n4 < n10) {
                            if (n5 > n9 || n4 < n9 || n5 > n3) {
                                break Label_0275;
                            }
                            if (n4 < n3) {
                                break Label_0275;
                            }
                        }
                        n2 = n8;
                        n = i;
                    }
                }
            }
            --i;
            if (a) {
                break;
            }
        }
        return this.v[n];
    }
    
    private void b(final d d, final d d2) {
        final boolean a = y.a.h.a;
        this.y.clear();
        final int b = d.b();
        final int b2 = d2.b();
        final q c = d2.c();
        final q d3 = d2.d();
        q q = null;
        q q2 = null;
        Label_0109: {
            if (this.a(d, d3)) {
                q = c;
                this.r[b2] = true;
                q2 = this.a(c, d3, this.y, this.r);
                if (!a) {
                    break Label_0109;
                }
            }
            q = d3;
            this.r[b2] = false;
            q2 = this.a(d3, c, this.y, this.r);
        }
        d d4 = d2;
        int n = 1;
        final int n2 = this.n[b];
        final int n3 = (this.o == null) ? 0 : this.o[b];
        final boolean b3 = this.r[b];
        int n4 = q.d();
        final J j = new J(null);
        Label_0697: {
            boolean b5 = false;
            boolean b6 = false;
            Label_0638: {
                Label_0580: {
                    Label_0355: {
                        if (this.o == null) {
                            int i = 0;
                            while (i < this.y.size()) {
                                final d d5 = this.y.get(i);
                                final int b4 = d5.b();
                                b5 = this.r[b4];
                                b6 = b3;
                                if (a) {
                                    break Label_0638;
                                }
                                Label_0258: {
                                    if (b5 == b6) {
                                        final int[] n5 = this.n;
                                        final int n6 = b4;
                                        n5[n6] -= n2;
                                        if (!a) {
                                            break Label_0258;
                                        }
                                    }
                                    final int[] n7 = this.n;
                                    final int n8 = b4;
                                    n7[n8] += n2;
                                }
                                Label_0347: {
                                    if (n != 0) {
                                        this.h[n4] = d4;
                                        final int n9 = n4;
                                        q = d5.a(q);
                                        n4 = q.d();
                                        final H h = this.A[b4];
                                        this.j[n4].b(h);
                                        if (d5 != d) {
                                            this.j[n9].a(h);
                                            h.d = n4;
                                            d4 = d5;
                                            if (!a) {
                                                break Label_0347;
                                            }
                                        }
                                        n = 0;
                                    }
                                }
                                ++i;
                                if (a) {
                                    break Label_0355;
                                }
                            }
                            break Label_0580;
                        }
                    }
                    int k = 0;
                    while (k < this.y.size()) {
                        final d d6 = this.y.get(k);
                        final int b7 = d6.b();
                        final boolean b8 = this.r[b7];
                        final boolean b9 = b3;
                        if (a) {
                            break Label_0638;
                        }
                        Label_0459: {
                            if (b8 == b9) {
                                b(this.o[b7], this.n[b7], n3, n2, j);
                                if (!a) {
                                    break Label_0459;
                                }
                            }
                            a(this.o[b7], this.n[b7], n3, n2, j);
                        }
                        this.o[b7] = j.a;
                        this.n[b7] = j.b;
                        Label_0572: {
                            if (n != 0) {
                                this.h[n4] = d4;
                                final int n10 = n4;
                                q = d6.a(q);
                                n4 = q.d();
                                final H h2 = this.A[b7];
                                this.j[n4].b(h2);
                                if (d6 != d) {
                                    this.j[n10].a(h2);
                                    h2.d = n4;
                                    d4 = d6;
                                    if (!a) {
                                        break Label_0572;
                                    }
                                }
                                n = 0;
                            }
                        }
                        ++k;
                        if (a) {
                            break;
                        }
                    }
                }
                if (this.o == null) {
                    this.n[b2] = ((this.r[b] == this.r[b2]) ? (-n2) : n2);
                    if (!a) {
                        break Label_0697;
                    }
                }
                final boolean b10 = this.r[b];
                final boolean b11 = this.r[b2];
            }
            if (b5 == b6) {
                a(n3, n2, j);
                this.o[b2] = j.a;
                this.n[b2] = j.b;
                if (!a) {
                    break Label_0697;
                }
            }
            this.o[b2] = n3;
            this.n[b2] = n2;
        }
        this.l[b] = false;
        this.l[b2] = true;
        this.m.b(this.B[b]);
        this.m.a(this.B[b2]);
        final int d7 = q2.d();
        final H h3 = this.A[b2];
        if (this.a(d, c)) {
            h3.d = d3.d();
            this.j[c.d()].a(h3);
            this.a(q2, d3, this.g[d7], this.i[d7]);
            if (!a) {
                return;
            }
        }
        h3.d = c.d();
        this.j[d3.d()].a(h3);
        this.a(q2, c, this.g[d7], this.i[d7]);
    }
    
    private int f() {
        final boolean a = y.a.h.a;
        int n = Integer.MAX_VALUE;
        int n2 = -2147483647;
        int i = 0;
        int n4 = 0;
        int n5 = 0;
        while (i < this.d.length) {
            final int n3 = n4 = this.d[i];
            n5 = n;
            if (a) {
                return n4 + n5;
            }
            if (n4 < n5) {
                n = n3;
            }
            if (n3 > n2) {
                n2 = n3;
            }
            ++i;
            if (a) {
                break;
            }
        }
        if (n != 0) {
            int j = 0;
            while (j < this.d.length) {
                final int[] d = this.d;
                final int n6 = j;
                d[n6] -= n;
                ++j;
                if (a) {
                    return n4 + n5;
                }
                if (a) {
                    break;
                }
            }
            n2 -= n;
        }
        return n4 + n5;
    }
    
    private static void a(final int n, final int n2, final int n3, final int n4, final J j) {
        final int b = n2 + n4;
        j.a = n + n3 + (((n2 & n4) | ((n2 | n4) & ~b)) >>> 31);
        j.b = b;
    }
    
    private static void b(final int n, final int n2, final int n3, final int n4, final J j) {
        final int b = n2 - n4;
        j.a = n - n3 - (((~n2 & n4) | (~(n2 ^ n4) & b)) >>> 31);
        j.b = b;
    }
    
    private static void a(final int n, final int n2, final J j) {
        final int b = ~n2 + 1;
        j.a = ~n + ((~n2 & ~b) >>> 31);
        j.b = b;
    }
}
