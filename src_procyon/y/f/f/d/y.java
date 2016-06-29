package y.f.f.d;

import y.f.f.b.*;
import y.c.*;
import y.d.*;
import y.f.*;

public class y
{
    private static int q;
    private static boolean r;
    protected i a;
    protected h b;
    protected M c;
    protected i d;
    protected v e;
    protected K f;
    protected boolean g;
    protected D h;
    protected int i;
    private boolean s;
    protected A j;
    protected y.c.h k;
    protected y.c.h l;
    protected y.c.h m;
    protected int n;
    protected int o;
    protected int p;
    
    public y(final h b, final short n, final int i) {
        this.g = true;
        this.s = false;
        this.n = -1;
        this.o = -1;
        this.a = b.a();
        this.b = b;
        this.i = i;
        if (this.i < 1) {
            throw new IllegalArgumentException("Invalid grid distance !");
        }
        this.c = this.a(n);
        if (this.c == null) {
            throw new IllegalArgumentException("Invalid node model !");
        }
        this.g = this.c.a();
    }
    
    protected M a(final short n) {
        switch (n) {
            case 3: {
                return new c();
            }
            case 2: {
                return new J(this.i);
            }
            case 1: {
                return new E(this.i);
            }
            case 4: {
                return new s();
            }
            case 0: {
                return new d(this.i);
            }
            default: {
                return null;
            }
        }
    }
    
    public static void a(final boolean b) {
        if (b) {
            y.q = 1;
            y.r = true;
            if (!o.p) {
                return;
            }
        }
        y.q = 0;
        y.r = false;
    }
    
    public void b(final boolean s) {
        this.s = s;
    }
    
    public K a() {
        return this.f;
    }
    
    public D b() {
        return this.h;
    }
    
    public void c() {
        final boolean p = y.f.f.d.o.p;
        this.c.a(this.b);
        final A t = this.a.t();
        final y.c.d a = this.b.d().a().a();
        final double n = 30.0;
        final y.c.h u = this.a.u();
        this.d = new i();
        if (y.r) {
            this.e = new v();
        }
        this.f = new K(this.d);
        this.j = this.a.t();
        this.h();
        this.k = this.a.u();
        this.l = this.a.u();
        this.i();
        this.a(this.b, this.f);
        final boolean[] p2 = this.b.p();
        y.g.o.a(this, 3, "-----> Create edges for nodes:");
        final x o = this.a.o();
        while (true) {
            while (o.f()) {
                e a2 = null;
                final q e = o.e();
                final q[] array = new q[4];
                final y.f.f.d.A a3 = (y.f.f.d.A)this.j.b(e);
                array[0] = a3.a();
                array[1] = a3.d();
                array[2] = a3.c();
                array[3] = a3.b();
                final y y = this;
                if (p) {
                    final e p3 = y.a.p();
                    while (true) {
                        while (p3.f()) {
                            final y.c.d a4 = p3.a();
                            final Object o2;
                            final q q = (q)(o2 = a4.d());
                            if (p) {
                                this.f.a(this.f.b((y.c.d)o2));
                                this.h = new D();
                                final x o3 = this.a.o();
                                while (true) {
                                Label_1092_Outer:
                                    while (o3.f()) {
                                        final q e2 = o3.e();
                                        final y y2 = this;
                                        if (p) {
                                            e e3 = y2.d.p();
                                            while (true) {
                                                while (e3.f()) {
                                                    final y.c.d a5 = e3.a();
                                                    final boolean g = this.f.g(a5.c());
                                                    if (p) {
                                                        Label_1157: {
                                                            while (true) {
                                                                if (g) {
                                                                    this.m.a(e3.a(), 0.0);
                                                                    e3.g();
                                                                    if (p) {
                                                                        break Label_1157;
                                                                    }
                                                                    if (!p) {
                                                                        e3.f();
                                                                        continue Label_1092_Outer;
                                                                    }
                                                                }
                                                                break;
                                                            }
                                                            this.d();
                                                            this.a.a(u);
                                                            this.a.a(t);
                                                        }
                                                        if (y.c.i.g) {
                                                            y.f.f.d.o.p = !p;
                                                        }
                                                        return;
                                                    }
                                                    if (g && this.f.g(a5.d()) && !this.f.j(a5)) {
                                                        this.f.b(a5, 0);
                                                    }
                                                    e3.g();
                                                    if (p) {
                                                        break;
                                                    }
                                                }
                                                y.g.o.a(this, 3, "-----> Center Edges:");
                                                this.m = this.a.u();
                                                e3 = this.a.p();
                                                continue;
                                            }
                                        }
                                        if (this.c.a(e2)) {
                                            this.h.add(this.f.b((y.c.d)t.b(e2)));
                                        }
                                        o3.g();
                                        if (p) {
                                            break;
                                        }
                                    }
                                    this.j();
                                    final y y2 = this;
                                    continue;
                                }
                            }
                            if (q.d() < a4.c().d()) {
                                this.f.a((y.c.d)u.b(a4), (y.c.d)u.b(this.b.a(a4)));
                            }
                            p3.g();
                            if (p) {
                                break;
                            }
                        }
                        y.g.o.a(this, 3, "Create Faces:");
                        this.f.f();
                        this.k();
                        Object o2 = u.b(a);
                        continue;
                    }
                }
                final y.c.d a6 = this.a(e);
                if (a6 != null) {
                    a2 = e.a(a6);
                }
            Label_0693:
                while (true) {
                    y.c.d d = null;
                    y.c.d a7 = d;
                    int i = 0;
                Label_0635_Outer:
                    while (i < 4) {
                        d = a6;
                        if (!p) {
                            int j = (d != null) ? 1 : 0;
                            q q2 = array[i];
                            final int q3 = y.f.f.d.y.q;
                            while (true) {
                                while (j != 0) {
                                    final int g2 = this.b.g(a7);
                                    final int n2 = i;
                                    if (!p) {
                                        if (g2 == n2) {
                                            final q q4 = (q)this.k.b(a7);
                                            final q q5 = (q)this.l.b(a7);
                                            t.a(e, this.a(e, q2, q4, i, n, q3));
                                            q2 = (q)this.k.b(a7);
                                            final y.c.d a8 = this.d.a(q4, q5);
                                            if (p2[a7.b()]) {
                                                this.f.s(a8);
                                            }
                                            this.f.a(a8, this.b.e(a7));
                                            this.f.b(a8, 1.0);
                                            Label_0546: {
                                                if (this.b.j(a7)) {
                                                    this.f.b(a8, Math.max(this.b.i(a7), 1));
                                                    if (!p) {
                                                        break Label_0546;
                                                    }
                                                }
                                                this.f.b(a8, 1);
                                            }
                                            this.f.c(a8, this.b.l(a7));
                                            this.f.d(a8, this.b.m(a7));
                                            u.a(a7, a8);
                                            a2.b();
                                            a7 = a2.a();
                                            if (a7 != a6) {
                                                continue Label_0635_Outer;
                                            }
                                            j = 0;
                                            if (!p) {
                                                continue Label_0635_Outer;
                                            }
                                        }
                                        j = 0;
                                        if (p) {
                                            break;
                                        }
                                        continue Label_0635_Outer;
                                    }
                                    else {
                                        Label_0685: {
                                            if (g2 == n2) {
                                                this.a(e, q2, array[0], 3, n, y.f.f.d.y.q);
                                                if (!p) {
                                                    break Label_0685;
                                                }
                                            }
                                            this.a(e, q2, array[i + 1], i, n, y.f.f.d.y.q);
                                        }
                                        ++i;
                                        if (p) {
                                            break Label_0693;
                                        }
                                        continue Label_0635_Outer;
                                    }
                                }
                                continue;
                            }
                        }
                        continue Label_0693;
                    }
                    break;
                }
                o.g();
                if (p) {
                    break;
                }
            }
            final y y = this;
            continue;
        }
    }
    
    private void a(final h h, final h h2) {
        final boolean p2 = y.f.f.d.o.p;
        final C i = h.i();
        while (i.f()) {
            h2.a(this.a((n)i.d()));
            i.g();
            if (p2) {
                break;
            }
        }
    }
    
    private n a(final n n) {
        final boolean p = y.f.f.d.o.p;
        final q a = n.a();
        final q b = n.b();
        final y.f.f.d.A a2 = (y.f.f.d.A)this.j.b(a);
        final y.f.f.d.A a3 = (y.f.f.d.A)this.j.b(b);
        final y.f.f.b.o e = n.e();
        if (e == y.f.f.b.o.c) {
            final n n2 = new n(a2.b(), a3.a(), n.c(), n.d(), e);
            if (!p) {
                return n2;
            }
        }
        if (e == y.f.f.b.o.a) {
            final n n2 = new n(a2.a(), a3.b(), n.c(), n.d(), e);
            if (!p) {
                return n2;
            }
        }
        if (e == y.f.f.b.o.b) {
            final n n2 = new n(a2.d(), a3.a(), n.c(), n.d(), e);
            if (!p) {
                return n2;
            }
        }
        return new n(a2.a(), a3.d(), n.c(), n.d(), e);
    }
    
    protected void d() {
        if (this.c.c()) {
            this.m();
            if (!y.f.f.d.o.p) {
                return;
            }
        }
        this.l();
    }
    
    private void h() {
        final boolean p = y.f.f.d.o.p;
        final x o = this.a.o();
        while (o.f()) {
            final q e = o.e();
            Label_0245: {
                if (!this.c.a(e)) {
                    final q d = this.d.d();
                    if (this.b.d(e)) {
                        this.f.c(d);
                    }
                    if (this.b.g(e)) {
                        this.f.f(d);
                    }
                    if (this.b.b(e)) {
                        this.f.c(d);
                    }
                    this.j.a(e, new z(d));
                    if (!p) {
                        break Label_0245;
                    }
                }
                final B b = new B();
                final q d2 = this.d.d();
                this.f.l(d2);
                b.a(d2);
                final q d3 = this.d.d();
                this.f.l(d3);
                b.d(d3);
                final q d4 = this.d.d();
                this.f.l(d4);
                b.c(d4);
                final q d5 = this.d.d();
                this.f.l(d5);
                b.b(d5);
                this.j.a(e, b);
            }
            o.g();
            if (p) {
                break;
            }
        }
    }
    
    protected y.c.d a(final q q) {
        final boolean p = y.f.f.d.o.p;
        if (q.c() == 0) {
            return null;
        }
        final short[] array = { 0, 0, 0, 0 };
        int n = 4;
        y.c.d d = null;
        final e l = q.l();
        while (true) {
        Label_0184_Outer:
            while (l.f()) {
                d = l.a();
                final int g = this.b.g(d);
                array[g] = 1;
                final int n2 = g;
                final int n3 = n;
                if (!p) {
                    if (n2 < n3) {
                        n = g;
                    }
                    l.g();
                    if (p) {
                        break;
                    }
                    continue;
                }
                else {
                    if (n2 != n3) {
                        final e i = q.l();
                        int j = 1;
                        while (true) {
                            while (j != 0) {
                                d = i.a();
                                final int g2 = this.b.g(d);
                                final int n4 = n;
                                if (p) {
                                    y.c.d a = null;
                                    while (true) {
                                        if (g2 == n4) {
                                            j = 0;
                                        }
                                        i.b();
                                        if (!p) {
                                            if (j != 0) {
                                                a = i.a();
                                                if (!p) {
                                                    d = a;
                                                    this.b.g(d);
                                                    continue Label_0184_Outer;
                                                }
                                            }
                                        }
                                        break;
                                    }
                                    return a;
                                }
                                if (g2 != n4) {
                                    j = 0;
                                }
                                i.b();
                                if (p) {
                                    break;
                                }
                            }
                            j = 1;
                            continue;
                        }
                    }
                    int k = 1;
                    final e m = q.l();
                    y.c.d a2 = null;
                    while (k != 0) {
                        a2 = m.a();
                        if (p) {
                            return a2;
                        }
                        d = a2;
                        if (this.b.d(d) == 4) {
                            k = 0;
                        }
                        m.b();
                        if (p) {
                            break;
                        }
                    }
                    return a2;
                }
            }
            final short n5 = (short)(array[0] + array[1] + array[2] + array[3]);
            continue;
        }
    }
    
    private y.c.d a(final q q, final q q2, final q q3, final int n, final double n2, final int n3) {
        if (q2.equals(q3)) {
            return null;
        }
        final y.f.f.b.o a = y.f.f.b.o.a(n).a();
        final y.f.f.b.o b = y.f.f.b.o.a(n).b();
        final y.c.d a2 = this.d.a(q2, q3);
        this.f.a(a2, a.toString());
        this.f.b(a2, n2);
        this.f.b(a2, n3);
        final e l = q3.l();
        y.c.d d = null;
        Label_0142: {
            if (!l.f()) {
                d = this.d.a(q3, q2);
                if (!y.f.f.d.o.p) {
                    break Label_0142;
                }
            }
            l.g();
            d = this.d.a(q3, l.a(), q2, null, 1, 0);
        }
        this.f.a(d, b.toString());
        this.f.b(d, n2);
        this.f.b(d, n3);
        this.f.a(a2, d);
        return d;
    }
    
    private void i() {
        final boolean p = y.f.f.d.o.p;
        final x o = this.a.o();
        while (true) {
            do {
                Label_0013: {
                    o.f();
                }
                int n = 0;
                Label_0019:
                while (n) {
                    final q e = o.e();
                    final int[] h = this.b.h(e);
                    final y y = this;
                    if (!p) {
                        y.c.d d = this.a(e);
                        int i = 0;
                        Label_0053:
                        Label_0132: {
                        Label_0127_Outer:
                            while (i < 4) {
                                n = 0;
                                if (!p) {
                                    int j = n;
                                    while (true) {
                                        while (j < h[i]) {
                                            this.k.a(d, this.a(d));
                                            d = this.b.b().j(d);
                                            ++j;
                                            if (!p) {
                                                if (p) {
                                                    break;
                                                }
                                                continue Label_0127_Outer;
                                            }
                                            else {
                                                if (p) {
                                                    break Label_0132;
                                                }
                                                continue Label_0053;
                                            }
                                        }
                                        ++i;
                                        continue;
                                    }
                                }
                                continue Label_0019;
                            }
                        }
                        o.g();
                        continue Label_0013;
                    }
                    final e p2 = y.a.p();
                    while (p2.f()) {
                        final y.c.d a = p2.a();
                        final y.c.d a2 = this.b.a(a);
                        this.l.a(a, this.k.b(a2));
                        this.l.a(a2, this.k.b(a));
                        p2.g();
                        if (p) {
                            break;
                        }
                    }
                    return;
                }
                break;
            } while (!p);
            final y y = this;
            continue;
        }
    }
    
    private q a(final y.c.d d) {
        if (!this.c.a(d.c())) {
            final q q = ((y.f.f.d.A)this.j.b(d.c())).a();
            if (!y.f.f.d.o.p) {
                return q;
            }
        }
        final q q = this.d.d();
        this.f.e(q);
        return q;
    }
    
    private void j() {
        final boolean p = y.f.f.d.o.p;
        final x o = this.a.o();
        while (o.f()) {
            final q e = o.e();
            if (this.c.a(e)) {
                final y.f.f.d.A a = (y.f.f.d.A)this.j.b(e);
                final q a2 = a.a();
                final q c = a.c();
                final boolean b = !this.c.d(e);
                this.f.a(new n(a2, c, this.c.b(e), (int)(b ? 1 : 0), y.f.f.b.o.b));
                this.f.a(new n(a2, c, this.c.c(e), (int)(b ? 1 : 0), y.f.f.b.o.c));
            }
            o.g();
            if (p) {
                break;
            }
        }
    }
    
    private void k() {
        final boolean p = y.f.f.d.o.p;
        final y.f.h.q c = this.f.c();
        while (c.f()) {
            final e a = c.a().a();
            y.c.d a2 = a.a();
            a.g();
            final y.c.d a3 = a.a();
        Block_3:
            while (true) {
                final y.c.d a4 = a.a();
                this.f.a(a4, y.f.f.b.o.a(this.f.g(a4) - this.f.h(a2).c().f()).f());
                a2 = a4;
                a.b();
                while (a.a() == a3) {
                    c.g();
                    if (!p) {
                        break Block_3;
                    }
                }
            }
            if (p) {
                break;
            }
        }
    }
    
    private void l() {
        final boolean p = y.f.f.d.o.p;
        y.g.o.a(this, 1, "Do not center edges !");
        final x o = this.a.o();
        do {
            Label_0021: {
                o.f();
            }
            int i = 0;
            Label_0027:
            while (i != 0) {
                final q e = o.e();
                if (this.c.a(e)) {
                    final int[][] j = this.b.i(e);
                    int k = 0;
                    while (k < 4) {
                        final y.f.f.b.o a = y.f.f.b.o.a(k);
                        final int[] array = j[k];
                        i = array[0] + array[1] + array[2];
                        if (p) {
                            continue Label_0027;
                        }
                        if (i != 0) {
                            final f f = new f();
                            final f f2 = new f();
                            this.a(e, a, f, f2, array);
                            Label_0144:
                            while (true) {
                                y.c.d d2 = null;
                                final y.c.d d = d2;
                                final f f3 = new f();
                                f3.a(f.a());
                                f3.add(d);
                                f3.a(f2.a());
                                final int n = a.e() ? 62 : 95;
                                y.c.d a2 = null;
                                final e a3 = f3.a();
                                while (a3.f()) {
                                    final y.c.d d3 = a2;
                                    a2 = a3.a();
                                    d2 = d3;
                                    if (p) {
                                        continue Label_0144;
                                    }
                                    if (d2 != null) {
                                        this.f.a(new n((q)this.k.b(d3), (q)this.k.b(a2), 1, 1, y.f.f.b.o.a((char)n)));
                                    }
                                    a3.g();
                                    if (p) {
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                        ++k;
                        if (p) {
                            break;
                        }
                    }
                }
                o.g();
                continue Label_0021;
            }
            break;
        } while (!p);
    }
    
    private void m() {
        final boolean p = y.f.f.d.o.p;
        final y.c.c c = this.b.a().c(y.f.f.b.e.a);
        final y.c.c c2 = this.b.a().c("MIN_DIST_DP_KEY");
        final boolean b = this.c instanceof d && c != null;
        final x o = this.a.o();
        do {
            Label_0062: {
                o.f();
            }
            int i = 0;
            Label_0069:
            while (i != 0) {
                final q e = o.e();
                if (this.c.a(e)) {
                    final y.f.f.d.A a = (y.f.f.d.A)this.j.b(e);
                    final int[][] j = this.b.i(e);
                    int k = 0;
                    while (k < 4) {
                        final y.f.f.b.o a2 = y.f.f.b.o.a(k);
                        final int[] array = j[k];
                        i = array[0] + array[1] + array[2];
                        if (p) {
                            continue Label_0069;
                        }
                        if (i != 0) {
                            final f f = new f();
                            final f f2 = new f();
                            final y.c.d a3 = this.a(e, a2, f, f2, array);
                            f2.n();
                            int n = 0;
                            int n2 = 0;
                            if (a2.e()) {
                                n2 = this.c.e(e);
                                n = this.c.b(e);
                            }
                            if (a2.d()) {
                                n2 = this.c.f(e);
                                n = this.c.c(e);
                            }
                            final int n3 = (int)this.c.b();
                            final int n4 = (int)Math.ceil(n2 / n3);
                            int n5 = n2;
                            int n6 = n2;
                            int n7 = n4;
                            int n8 = n4;
                            if (c2 != null && this.b.d(e)) {
                                final y.f.f.d.f f3 = (y.f.f.d.f)c2.b(e);
                                Label_0469: {
                                    if (f3 != null) {
                                        final double n9 = this.i / n3;
                                        if (a2.e()) {
                                            n5 += (int)Math.floor(f3.c() / n9);
                                            n6 += (int)Math.floor(f3.d() / n9);
                                            if (!p) {
                                                break Label_0469;
                                            }
                                        }
                                        if (a2.d()) {
                                            n5 += (int)Math.floor(f3.a() / n9);
                                            n6 += (int)Math.floor(f3.b() / n9);
                                        }
                                    }
                                }
                                n7 = (int)Math.ceil(n5 / n3);
                                n8 = (int)Math.ceil(n6 / n3);
                            }
                            final int n10 = (int)Math.floor((n - n7 - n8) * 0.5);
                            this.a(f, a, n, n10, n3, n6 + n5, n7, true);
                            Label_0761: {
                                if (a3 != null) {
                                    if (b && c.b(e) != null) {
                                        final aG f4 = ((S)c.b(e)).f();
                                        final y.f.f.b.o o2 = this.b.c(a3) ? a2.c() : a2;
                                        final boolean b2 = o2 == y.f.f.b.o.a || o2 == y.f.f.b.o.b;
                                        int n11 = n10 + n4;
                                        int n12 = n10 + n4;
                                        Label_0726: {
                                            if (!f4.l() && !f4.m()) {
                                                n11 = (b2 ? 0 : (2 * n11));
                                                n12 = (b2 ? (2 * n12) : 0);
                                                if (!p) {
                                                    break Label_0726;
                                                }
                                            }
                                            if (f4.l()) {
                                                n11 = (b2 ? (2 * n11) : 0);
                                                n12 = (b2 ? 0 : (2 * n12));
                                            }
                                        }
                                        this.a(a3, a, n11, n12);
                                        if (!p) {
                                            break Label_0761;
                                        }
                                    }
                                    this.a(a3, a, n10 + n7, n10 + n8);
                                }
                            }
                            this.a(f2, a, n, n10, n3, n6 + n5, n7, false);
                        }
                        ++k;
                        if (p) {
                            break;
                        }
                    }
                }
                o.g();
                continue Label_0062;
            }
            break;
        } while (!p);
    }
    
    private void a(final f f, final y.f.f.d.A a, final int n, final int n2, final int n3, final int n4, final int n5, final boolean b) {
        final boolean p8 = y.f.f.d.o.p;
        final int size = f.size();
        if (size == 0) {
            return;
        }
        final int n6 = b ? 1 : -1;
        final int[] array = new int[n2 + 1];
        double n7 = 1.0;
        Label_0211: {
            Label_0175: {
                if (n2 > 0) {
                    final int n8 = (int)Math.ceil(size / n2);
                    final int n9 = n8 * n2 - size;
                    array[0] = (int)Math.ceil(n8 * 0.5);
                    array[n2] = (int)Math.floor(n8 * 0.5);
                    int i = 1;
                    while (true) {
                    Label_0170_Outer:
                        while (i < n2) {
                            array[i] = n8;
                            ++i;
                            if (p8) {
                                while (true) {
                                    while (i < n9) {
                                        final int[] array2 = array;
                                        final int n10 = i;
                                        --array2[n10];
                                        ++i;
                                        if (!p8) {
                                            if (p8) {
                                                break;
                                            }
                                            continue Label_0170_Outer;
                                        }
                                        else {
                                            if (p8) {
                                                break Label_0175;
                                            }
                                            break Label_0211;
                                        }
                                    }
                                    n7 = n3 / n8;
                                    continue;
                                }
                            }
                            if (p8) {
                                break;
                            }
                        }
                        i = 0;
                        continue;
                    }
                }
            }
            array[0] = size;
            if (n == 0) {
                n7 = 0.0;
                if (!p8) {
                    break Label_0211;
                }
            }
            n7 = (n * n3 - n4) / (size * 2.0);
        }
        final e a2 = f.a();
        final int n11 = n5 + n2;
        int j = 0;
    Label_0407_Outer:
        while (j < array.length) {
            double n12 = 0.0;
            if (j > 0) {
                n12 = -(int)Math.ceil((array[j] - 1) / 2.0) * n7;
            }
            if (j == array.length - 1) {
                n12 = -array[j] * n7;
            }
            int k = 0;
            while (true) {
                while (k < array[j]) {
                    final y.c.d a3 = a2.a();
                    final int n13 = n11 - n6 * (n2 - j);
                    this.a(a3, a, n13, n - n13);
                    a2.g();
                    this.m.a(a3, n6 * n12);
                    this.m.a(this.b.a(a3), n6 * n12);
                    n12 += n7;
                    ++k;
                    if (!p8) {
                        if (p8) {
                            break;
                        }
                        continue Label_0407_Outer;
                    }
                    else {
                        if (p8) {
                            break Label_0407_Outer;
                        }
                        continue Label_0407_Outer;
                    }
                }
                ++j;
                continue;
            }
        }
    }
    
    private void a(final y.c.d d, final y.f.f.d.A a, final int n, final int n2) {
        n n3 = null;
        n n4 = null;
        final q q = (q)this.k.b(d);
        final y.f.f.b.o h = this.b.h(d);
        if (h.a(y.f.f.b.o.d)) {
            n3 = new n(a.a(), q, n, 1, y.f.f.b.o.c);
            n4 = new n(q, a.b(), n2, 1, y.f.f.b.o.c);
        }
        if (h.a(y.f.f.b.o.b)) {
            n3 = new n(a.d(), q, n, 1, y.f.f.b.o.c);
            n4 = new n(q, a.c(), n2, 1, y.f.f.b.o.c);
        }
        if (h.a(y.f.f.b.o.a)) {
            n3 = new n(a.a(), q, n, 1, y.f.f.b.o.b);
            n4 = new n(q, a.d(), n2, 1, y.f.f.b.o.b);
        }
        if (h.a(y.f.f.b.o.c)) {
            n3 = new n(a.b(), q, n, 1, y.f.f.b.o.b);
            n4 = new n(q, a.c(), n2, 1, y.f.f.b.o.b);
        }
        this.f.a(n3);
        this.f.a(n4);
    }
    
    protected y.c.d a(final q q, final y.f.f.b.o o, final f f, final f f2, final int[] array) {
        final boolean p5 = o.p;
        f.clear();
        f2.clear();
        y.c.d d = null;
        final e a = q.a(this.a(q));
        int i = 0;
        final int n = array[0] + array[1] + array[2];
        if (n == 0) {
            return null;
        }
        final f f3 = new f();
        final f f4 = new f();
        while (true) {
            while (i < n) {
                final y.c.d a2 = a.a();
                final boolean a3 = this.b.h(a2).a(o);
                if (p5) {
                    Label_0253: {
                        if (a3 || o.a(y.f.f.b.o.c)) {
                            f3.n();
                            f4.n();
                            f.a(f4.a());
                            f2.a(f3.a());
                            if (!p5) {
                                break Label_0253;
                            }
                        }
                        f.a(f3.a());
                        f2.a(f4.a());
                    }
                    if (d == null) {
                        if (f.size() > f2.size()) {
                            d = f.c();
                            f.h(f.l());
                            if (!p5) {
                                return d;
                            }
                        }
                        d = f2.b();
                        f2.h(f2.k());
                    }
                    return d;
                }
                if (a3) {
                    Label_0165: {
                        if (i < array[2]) {
                            f3.add(a2);
                            if (!p5) {
                                break Label_0165;
                            }
                        }
                        if (i == array[2] && array[1] == 1) {
                            d = a2;
                            if (!p5) {
                                break Label_0165;
                            }
                        }
                        f4.add(a2);
                    }
                    ++i;
                }
                a.b();
                if (p5) {
                    break;
                }
            }
            o.a(y.f.f.b.o.d);
            continue;
        }
    }
    
    public void a(final A a, final X x) {
        final boolean p2 = y.f.f.d.o.p;
        y.g.o.a(this, "Grid: " + this.i);
        final double n = this.i;
        final double n2 = this.i;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max2 = Integer.MIN_VALUE;
        final x o = this.d.o();
        while (true) {
            while (o.f()) {
                final t t = (t)a.b(o.e());
                min = Math.min(min, (int)t.a());
                max = Math.max(max, (int)t.a());
                min2 = Math.min(min2, (int)t.b());
                max2 = Math.max(max2, (int)t.b());
                o.g();
                if (p2) {
                    final e p3 = this.a.p();
                    while (true) {
                        while (p3.f()) {
                            final y.c.d a2 = p3.a();
                            final t t2 = (t)a.b(this.k.b(a2));
                            final t t3 = (t)a.b(this.l.b(a2));
                            final boolean a3 = this.b.h(a2).a(y.f.f.b.o.b);
                            if (p2) {
                                Label_0560: {
                                    if (a3) {
                                        final A t4 = this.d.t();
                                        final x o2 = this.d.o();
                                        while (o2.f()) {
                                            final q e = o2.e();
                                            final t t5 = (t)a.b(e);
                                            final t t6 = new t(t5.a() * n, t5.b() * n2);
                                            final y.f.x x2 = new y.f.x();
                                            x2.setSize(20.0, 20.0);
                                            x2.a(t6.a(), t6.b());
                                            this.e.a(e, x2);
                                            t4.a(e, "" + e.d());
                                            o2.g();
                                            if (p2) {
                                                break Label_0560;
                                            }
                                            if (p2) {
                                                break;
                                            }
                                        }
                                        this.d.a(t4);
                                    }
                                    y.g.o.a(this, 3, "Merging nodes:");
                                }
                                final x o3 = this.a.o();
                                while (true) {
                                    while (o3.f()) {
                                        final q e2 = o3.e();
                                        final y.f.f.d.A a4 = (y.f.f.d.A)this.j.b(e2);
                                        final t t7 = (t)a.b(a4.a());
                                        final t t8 = (t)a.b(a4.c());
                                        final double n3 = (t8.a() - t7.a()) * n;
                                        final double n4 = (t8.b() - t7.b()) * n2;
                                        final boolean d = this.b.d(e2);
                                        if (p2) {
                                            if (d) {
                                                this.a(x);
                                            }
                                            final e p4 = this.a.p();
                                            while (true) {
                                                while (p4.f()) {
                                                    final y.c.d a5 = p4.a();
                                                    final q c = a5.c();
                                                    final q d2 = a5.d();
                                                    double n5 = 0.0;
                                                    double n6 = 0.0;
                                                    final y y = this;
                                                    if (p2) {
                                                        y.c.d();
                                                        return;
                                                    }
                                                    Label_0966: {
                                                        if (this.b.h(a5).e()) {
                                                            n5 = this.m.c(a5) * this.i / this.c.b();
                                                            if (!p2) {
                                                                break Label_0966;
                                                            }
                                                        }
                                                        n6 = this.m.c(a5) * this.i / this.c.b();
                                                    }
                                                    final t t9 = (t)a.b(this.k.b(a5));
                                                    t t10 = new t(t9.a() * n + n5, t9.b() * n2 + n6);
                                                    final t t11 = (t)a.b(this.l.b(a5));
                                                    t t12 = new t(t11.a() * n + n5, t11.b() * n2 + n6);
                                                    if (!this.g) {
                                                        if (this.b.h(a5).a(y.f.f.b.o.d)) {
                                                            t10 = new t(x.m(c), t10.b());
                                                            t12 = new t(x.m(d2) + x.p(d2), t12.b());
                                                        }
                                                        if (this.b.h(a5).a(y.f.f.b.o.b)) {
                                                            t10 = new t(x.m(c) + x.p(c), t10.b());
                                                            t12 = new t(x.m(d2), t12.b());
                                                        }
                                                        if (this.b.h(a5).a(y.f.f.b.o.a)) {
                                                            t10 = new t(t10.a(), x.n(c));
                                                            t12 = new t(t12.a(), x.n(d2) + x.q(d2));
                                                        }
                                                        if (this.b.h(a5).a(y.f.f.b.o.c)) {
                                                            t10 = new t(t10.a(), x.n(c) + x.q(c));
                                                            t12 = new t(t12.a(), x.n(d2));
                                                        }
                                                    }
                                                    Label_1370: {
                                                        if (this.b.d(c)) {
                                                            x.c(a5, t10);
                                                            if (!p2) {
                                                                break Label_1370;
                                                            }
                                                        }
                                                        x.a(c, t10);
                                                    }
                                                    Label_1403: {
                                                        if (this.b.d(d2)) {
                                                            x.d(a5, t12);
                                                            if (!p2) {
                                                                break Label_1403;
                                                            }
                                                        }
                                                        x.a(d2, t12);
                                                    }
                                                    p4.g();
                                                    if (p2) {
                                                        break;
                                                    }
                                                }
                                                this.a.a(this.j);
                                                this.a.a(this.m);
                                                this.a.a(this.k);
                                                this.a.a(this.l);
                                                final y y = this;
                                                continue;
                                            }
                                        }
                                        if (!d) {
                                            x.b(e2, 0.0, 0.0);
                                        }
                                        if (this.g) {
                                            x.a(e2, new y.d.q(n3 + n / 2.0, n4 + n2 / 2.0));
                                        }
                                        final y.d.q r = x.r(e2);
                                        x.b(e2, new t(t7.a() * n + (n3 - r.a()) / 2.0, t7.b() * n2 + (n4 - r.b()) / 2.0));
                                        o3.g();
                                        if (p2) {
                                            break;
                                        }
                                    }
                                    final boolean s = this.s;
                                    continue;
                                }
                            }
                            if (a3) {
                                this.p += (int)(t3.a() - t2.a());
                            }
                            if (this.b.h(a2).a(y.f.f.b.o.c)) {
                                this.p += (int)(t3.b() - t2.b());
                            }
                            p3.g();
                            if (p2) {
                                break;
                            }
                        }
                        final boolean r2 = y.r;
                        continue;
                    }
                }
                if (p2) {
                    break;
                }
            }
            this.n = max - min;
            this.o = max2 - min2;
            this.p = 0;
            continue;
        }
    }
    
    private void a(final X x) {
        final boolean p = y.f.f.d.o.p;
        final f f = new f();
        final y.f.h.D d = (y.f.h.D)this.b.b();
        e e = this.a.p();
    Label_0125:
        while (true) {
            while (e.f()) {
                final y.c.d a = e.a();
                final boolean n = d.n(a);
                if (p) {
                Label_0857_Outer:
                    while (true) {
                        if (n) {
                            final y.c.d a2 = e.a();
                            e e2 = a2.c().k();
                            e2.a();
                        Label_0857:
                            while (true) {
                                y.c.d a3 = null;
                                while (a3 != null) {
                                    if (d.n(e2.a())) {
                                        e2.b();
                                    }
                                    y.c.d a4 = e2.a();
                                    y.c.d h = d.h(a4);
                                    e2 = a2.d().l();
                                    if (e2.a() != null) {
                                        if (d.n(e2.a())) {
                                            e2.b();
                                        }
                                        final y.c.d a5 = e2.a();
                                        final y.c.d h2 = d.h(a5);
                                        if (!d.f(a4.c()) || !d.f(a5.d())) {
                                            if (d.f(a4.c()) || d.f(a5.d())) {
                                                if (!d.f(a4.c())) {
                                                    a4 = a5;
                                                    h = h2;
                                                }
                                                d.h(a2.c());
                                                final y.c.d h3 = d.h(a2.d());
                                                d.e(h3);
                                                final y.c.d h4 = d.h(h3);
                                                this.m.a(h3, this.m.c(a4));
                                                this.m.a(h4, this.m.c(a4));
                                                this.b.a(h3, this.b.e(a4));
                                                this.b.a(h4, this.b.e(h));
                                                this.k.a(h3, this.k.b(a4));
                                                this.l.a(h3, this.l.b(a4));
                                                this.l.a(h4, this.k.b(a4));
                                                this.k.a(h4, this.l.b(a4));
                                                y.c.d d2 = h3;
                                            Label_0547:
                                                while (true) {
                                                    while (d.b(d2.c())) {
                                                        final y.c.d d3 = d.d(d2);
                                                        final e a6 = d2.c().a(d2);
                                                        a6.b();
                                                        final y.c.d a7 = a6.a();
                                                        if (p) {
                                                            y.c.d d4 = a7;
                                                        Label_0706:
                                                            while (d.b(d4.d())) {
                                                                final y.c.d d5 = d.d(d4);
                                                                final e a8 = d4.d().a(d4);
                                                                a8.b();
                                                                a3 = a8.a();
                                                                if (p) {
                                                                    continue Label_0857;
                                                                }
                                                                y.c.d a9 = a3;
                                                                while (d.d(a9) != d5) {
                                                                    a8.b();
                                                                    a9 = a8.a();
                                                                    if (p) {
                                                                        continue Label_0706;
                                                                    }
                                                                    if (p) {
                                                                        break;
                                                                    }
                                                                }
                                                                final y.c.d h5 = d.h(a9);
                                                                this.m.a(a9, this.m.c(a4));
                                                                this.m.a(h5, this.m.c(a4));
                                                                d4 = a9;
                                                                if (p) {
                                                                    break;
                                                                }
                                                            }
                                                            break Label_0857;
                                                        }
                                                        y.c.d a10 = a7;
                                                        while (d.d(d.h(a10)) != d3) {
                                                            a6.b();
                                                            a10 = a6.a();
                                                            if (p) {
                                                                continue Label_0547;
                                                            }
                                                            if (p) {
                                                                break;
                                                            }
                                                        }
                                                        final y.c.d h6 = d.h(a10);
                                                        this.m.a(h6, this.m.c(a4));
                                                        this.m.a(a10, this.m.c(a4));
                                                        d2 = h6;
                                                        if (p) {
                                                            break;
                                                        }
                                                    }
                                                    continue Label_0857_Outer;
                                                }
                                            }
                                        }
                                    }
                                    e.g();
                                    if (p) {
                                        return;
                                    }
                                    break Label_0125;
                                }
                                Block_8: {
                                    break Block_8;
                                    e.f();
                                    continue Label_0857_Outer;
                                }
                                continue Label_0857;
                            }
                        }
                        break;
                    }
                    return;
                }
                if (!n && this.a(a, x) && d.e(a.c()) && d.e(a.d())) {
                    f.add(a);
                }
                e.g();
                if (p) {
                    break;
                }
            }
            e = f.a();
            continue Label_0125;
        }
    }
    
    private boolean a(final y.c.d d, final X x) {
        return x.m(d.c()) == x.m(d.d()) && x.n(d.c()) == x.n(d.d());
    }
    
    public int e() {
        return this.n;
    }
    
    public int f() {
        return this.o;
    }
    
    public int g() {
        return this.p;
    }
    
    static {
        y.q = 0;
        y.r = false;
    }
}
