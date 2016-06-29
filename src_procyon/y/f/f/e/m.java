package y.f.f.e;

import y.f.*;
import y.f.h.*;
import y.g.*;
import java.awt.*;
import y.f.f.b.*;
import y.f.f.c.*;
import y.d.*;
import y.c.*;

public class m implements p
{
    private h c;
    private X d;
    D a;
    private short e;
    private int f;
    public int b;
    private boolean g;
    private y.f.f.b.m h;
    
    public m() {
        this.e = 0;
        this.f = 3;
        this.g = false;
    }
    
    public void a(final h c) {
        this.c = c;
        this.d = (X)this.c.a();
    }
    
    public void a(final int b) {
        this.b = b;
    }
    
    public void a(final y.f.f.b.m h) {
        this.h = h;
    }
    
    public void a(final short e) {
        this.e = e;
    }
    
    public void b(final int f) {
        this.f = f;
    }
    
    public void a() {
        int i = y.f.f.e.a.a;
        o.a(this, "------->>> Entering Compaction Phase");
        final al al = new al();
        final d[] n = this.d.n();
        int j = 0;
        while (true) {
        Label_0153_Outer:
            while (j < n.length) {
                final d d = n[j];
                final m m = this;
                if (i != 0) {
                    final c c = m.d.c("y.layout.orthogonal.general.NodeSplitter.NODE_FACES");
                    this.a = (D)this.c.b();
                    final e p = this.c.a().p();
                    while (true) {
                    Label_0922_Outer:
                        while (p.f()) {
                            final m k = this;
                            if (i != 0) {
                                final c c2 = k.d.c("y.layout.orthogonal.ring.FixedSizeNodeSplitter#NODE_SIZE");
                                i i3 = null;
                                Label_3554: {
                                    Label_3547: {
                                        if (c2 != null) {
                                            y.f.h.q q = this.c.c();
                                        Label_0922:
                                            while (true) {
                                                do {
                                                    Label_0177: {
                                                        q.f();
                                                    }
                                                    int l = 0;
                                                    Label_0184:
                                                Label_0929_Outer:
                                                    while (l != 0) {
                                                        final y.f.h.p p2 = (y.f.h.p)q.d();
                                                        boolean b2;
                                                        final boolean b = b2 = c.d(p2);
                                                        if (i == 0) {
                                                            Label_0901: {
                                                                if (b) {
                                                                    final e a = p2.a();
                                                                    while (true) {
                                                                        while (a.f()) {
                                                                            final d a2 = a.a();
                                                                            final int d2 = this.c.d(a2);
                                                                            if (i == 0) {
                                                                                if (d2 == 1 && a2.c().c() > 2) {
                                                                                    final d a3 = this.a(a2);
                                                                                    final y.f.f.b.o h = this.c.h(a3);
                                                                                    this.c.h(a2);
                                                                                    d c3 = a2;
                                                                                    if (this.c.h(a2).e() != h.e()) {
                                                                                        c3 = this.c(this.b(a2));
                                                                                    }
                                                                                    this.a.e(c3);
                                                                                    final q b3 = this.a.b(c3);
                                                                                    final d b4 = b3.b(c3.c());
                                                                                    final d a4 = b3.a(c3.d());
                                                                                    final y.f.f.b.o h2 = this.c.h(c3);
                                                                                    final int d3 = this.c.d(c3);
                                                                                    final int d4 = this.c.d(this.c(c3));
                                                                                    Label_0634: {
                                                                                        if (c3 == a2) {
                                                                                            this.c.a(b4, h2.a());
                                                                                            this.c.a(a4, h2);
                                                                                            this.c.f(b4);
                                                                                            this.c.f(a4);
                                                                                            this.c.a(a4, 1);
                                                                                            this.c.a(b4, 2);
                                                                                            this.c.a(this.c(b4), 3);
                                                                                            this.c.a(this.c(a4), d4);
                                                                                            this.c.a(a3, 1);
                                                                                            if (i == 0) {
                                                                                                break Label_0634;
                                                                                            }
                                                                                        }
                                                                                        this.c.a(b4, h2);
                                                                                        this.c.a(a4, h2.b());
                                                                                        this.c.f(b4);
                                                                                        this.c.f(a4);
                                                                                        this.c.a(a4, 1);
                                                                                        this.c.a(b4, d3);
                                                                                        this.c.a(this.c(b4), 3);
                                                                                        this.c.a(this.c(a4), 1);
                                                                                        this.c.a(a2, 2);
                                                                                    }
                                                                                    this.c.b(b4, 1);
                                                                                    this.c.b(a4, 1);
                                                                                    this.c.b(this.c(b4), 1);
                                                                                    this.c.b(this.c(a4), 1);
                                                                                }
                                                                                a.g();
                                                                                if (i != 0) {
                                                                                    break;
                                                                                }
                                                                                continue Label_0153_Outer;
                                                                            }
                                                                            else {
                                                                                final q[] array = new q[d2];
                                                                                final e a5 = p2.a();
                                                                                while (a5.f()) {
                                                                                    final d a6 = a5.a();
                                                                                    l = this.c.d(a6);
                                                                                    if (i != 0) {
                                                                                        continue Label_0184;
                                                                                    }
                                                                                    if (l == 1) {
                                                                                        array[this.c.h(a6).g()] = a6.c();
                                                                                    }
                                                                                    a5.g();
                                                                                    if (i != 0) {
                                                                                        break;
                                                                                    }
                                                                                }
                                                                                final Dimension dimension = (Dimension)c2.b(p2);
                                                                                if (dimension != null) {
                                                                                    final int n2 = (int)Math.floor(dimension.width / this.b) + 1;
                                                                                    final int n3 = (int)Math.floor(dimension.height / this.b) + 1;
                                                                                    this.c.a(new n(array[1], array[0], n2, 1, y.f.f.b.o.b));
                                                                                    this.c.a(new n(array[2], array[1], n3, 1, y.f.f.b.o.c));
                                                                                }
                                                                                break Label_0901;
                                                                            }
                                                                        }
                                                                        continue Label_0929_Outer;
                                                                    }
                                                                }
                                                            }
                                                            q.g();
                                                            continue Label_0177;
                                                        }
                                                    Label_1390:
                                                        while (true) {
                                                            int d5 = 0;
                                                            while (d5 != 0) {
                                                                final y.f.h.p p3 = (y.f.h.p)q.d();
                                                                if (i != 0) {
                                                                    break Label_3547;
                                                                }
                                                                if (c.d(p3)) {
                                                                    final e a7 = p3.a();
                                                                    final int k2 = a7.k();
                                                                    while (a7.f()) {
                                                                        d5 = this.c.d(a7.a());
                                                                        if (i != 0) {
                                                                            continue Label_0929;
                                                                        }
                                                                        if (d5 == 1) {
                                                                            break;
                                                                        }
                                                                        a7.g();
                                                                        if (i != 0) {
                                                                            break;
                                                                        }
                                                                    }
                                                                    d c4 = null;
                                                                    int n4 = 0;
                                                                    while (n4 < k2) {
                                                                        final d a8 = a7.a();
                                                                        final d c5 = this.c(this.b(this.a.h(a8)));
                                                                        final d a9 = this.a(a8);
                                                                        final boolean b5 = b2 = this.c.h(c5).c().a(this.c.h(a9));
                                                                        if (i != 0) {
                                                                            continue Label_0929;
                                                                        }
                                                                        Label_1363: {
                                                                            if (b5) {
                                                                                final y.f.h.p i2 = this.a.i(c5);
                                                                                if (((c4 != null || a9.d().a() != 2) && c4 != a9) || c5.c().a() != 2) {
                                                                                    break Label_1363;
                                                                                }
                                                                                c4 = this.c(c5);
                                                                                final d a10 = this.d.a(a9.d(), c5.c());
                                                                                this.a.e(a10);
                                                                                this.a.a(i2, a10);
                                                                                this.c.a(a10, 1);
                                                                                this.c.a(this.c(a10), 3);
                                                                                this.c.a(c5, 1);
                                                                                this.c.a(this.a(a10), this.c.d(this.a(a10)) - 1);
                                                                                this.c.a(a10, this.c.h(a8));
                                                                                this.c.a(this.c(a10), this.c.h(this.c(a8)));
                                                                                this.c.b(a10, 1);
                                                                                this.c.b(this.c(a10), 1);
                                                                                this.c.n();
                                                                                this.c.o();
                                                                                this.c.l();
                                                                                if (i == 0) {
                                                                                    break Label_1363;
                                                                                }
                                                                            }
                                                                            c4 = null;
                                                                        }
                                                                        a7.b();
                                                                        ++n4;
                                                                        if (i != 0) {
                                                                            break;
                                                                        }
                                                                    }
                                                                }
                                                                q.g();
                                                                if (i != 0) {
                                                                    break;
                                                                }
                                                                break Label_0922;
                                                            }
                                                            break Label_1390;
                                                            q.f();
                                                            continue Label_0922_Outer;
                                                        }
                                                        final x o = this.d.o();
                                                        do {
                                                            Label_1399:
                                                            o.f();
                                                            int n5 = 0;
                                                            Label_1406:
                                                            while (n5 != 0) {
                                                                final q e = o.e();
                                                                final X x = (X)(i3 = this.d);
                                                                if (i == 0) {
                                                                    Object o2 = x.c("y.layout.orthogonal.ring.FixedSizeNodeSplitter#NODE_SIZE").b(e);
                                                                    Label_1443:
                                                                    Label_3535: {
                                                                        y.d.q q2;
                                                                        while (true) {
                                                                            q2 = (y.d.q)o2;
                                                                            if (q2 != null) {
                                                                                final e a11 = new f(e.l()).a();
                                                                                while (a11.f()) {
                                                                                    final d a12 = a11.a();
                                                                                    final y.f.f.b.o h3 = this.c.h(a12);
                                                                                    final int d6 = this.c.d(a12);
                                                                                    final int d7 = this.c.d(this.c(a12));
                                                                                    final String e2 = this.c.e(a12);
                                                                                    final D d8 = (D)(o2 = this.a);
                                                                                    if (i != 0) {
                                                                                        continue Label_1443;
                                                                                    }
                                                                                    final q b6 = d8.b(this.a.n(a12) ? this.a.h(a12) : a12);
                                                                                    final d b7 = b6.b(a12.c());
                                                                                    final d a13 = b6.a(a12.d());
                                                                                    this.c.a(b7, h3.toString());
                                                                                    this.c.f(b7);
                                                                                    this.c.a(a13, e2);
                                                                                    this.c.f(a13);
                                                                                    this.c.a(this.a.h(a13), d7);
                                                                                    this.c.a(b7, d6);
                                                                                    this.c.a(a13, 2);
                                                                                    this.c.a(this.a.h(b7), 2);
                                                                                    this.c.b(b7, 1.0);
                                                                                    this.c.b(this.a.h(b7), 1.0);
                                                                                    this.c.b(a13, 1.0);
                                                                                    this.c.b(this.a.h(a13), 1.0);
                                                                                    double n6 = 0.0;
                                                                                    Label_1820: {
                                                                                        if (h3.d()) {
                                                                                            n6 = Math.floor(0.5 * q2.a / this.b) + 1.0;
                                                                                            if (i == 0) {
                                                                                                break Label_1820;
                                                                                            }
                                                                                        }
                                                                                        n6 = Math.floor(0.5 * q2.b / this.b) + 1.0;
                                                                                    }
                                                                                    this.c.b(b7, (int)n6);
                                                                                    this.c.b(this.a.h(b7), (int)n6);
                                                                                    this.c.b(a13, 1);
                                                                                    this.c.b(this.a.h(a13), 1);
                                                                                    a11.g();
                                                                                    if (i != 0) {
                                                                                        break;
                                                                                    }
                                                                                }
                                                                                break;
                                                                            }
                                                                            break Label_3535;
                                                                        }
                                                                        Label_2142: {
                                                                            if (e.c() == 1) {
                                                                                final d f = e.f();
                                                                                final y.f.h.p i4 = this.a.i(f);
                                                                                final y.f.f.b.o h4 = this.c.h(f);
                                                                                final q d9 = this.d.d();
                                                                                final d a14 = this.d.a(e, d9);
                                                                                this.a.e(a14);
                                                                                this.a.a(a14, d9, i4);
                                                                                this.c.a(a14, 2);
                                                                                this.c.a(this.c(a14), 4);
                                                                                this.c.a(f, 2);
                                                                                this.c.a(a14, h4.c());
                                                                                this.c.f(a14);
                                                                                final int n7 = (int)Math.floor(0.5 * q2.a / this.b) + 1;
                                                                                final int n8 = (int)Math.floor(0.5 * q2.b / this.b) + 1;
                                                                                if (h4.e()) {
                                                                                    this.c.b(a14, n8);
                                                                                    this.c.b(this.c(a14), n8);
                                                                                    if (i == 0) {
                                                                                        break Label_2142;
                                                                                    }
                                                                                }
                                                                                this.c.b(a14, n7);
                                                                                this.c.b(this.c(a14), n7);
                                                                            }
                                                                        }
                                                                        d h5 = e.h();
                                                                        final e a15 = new f(e.l()).a();
                                                                        while (a15.f()) {
                                                                            final d a16 = a15.a();
                                                                            final y.f.f.b.o h6 = this.c.h(a16);
                                                                            final int d10 = this.c.d(a16);
                                                                            this.c.e(a16);
                                                                            final q d11 = a16.d();
                                                                            final q d12 = h5.d();
                                                                            final y.f.h.p i5 = this.a.i(a16);
                                                                            this.a.h(h5);
                                                                            final d c6 = this.c(this.b(this.c(h5)));
                                                                            final d d13 = a16;
                                                                            final d a17 = this.a(this.c(a16));
                                                                            final int d14 = this.c.d(a17);
                                                                            final int d15 = this.c.d(this.c(h5));
                                                                            final d a18 = this.d.a(d12, d11);
                                                                            this.a.e(a18);
                                                                            this.a.a(i5, a18, c6, d13);
                                                                            n5 = d10;
                                                                            if (i != 0) {
                                                                                continue Label_1406;
                                                                            }
                                                                            Label_3519: {
                                                                                if (n5 == 1) {
                                                                                    final q b8 = this.a.b(a18);
                                                                                    final d b9 = b8.b(a18.c());
                                                                                    final d a19 = b8.a(a18.d());
                                                                                    this.c.a(b9, h6.toString());
                                                                                    this.c.f(b9);
                                                                                    this.c.a(a19, h6.a().toString());
                                                                                    this.c.f(a19);
                                                                                    this.c.a(a17, 1);
                                                                                    this.c.a(b9, 1);
                                                                                    this.c.a(this.c(b9), 1);
                                                                                    this.c.a(a19, 3);
                                                                                    this.c.a(this.c(a19), 1);
                                                                                    this.c.a(this.c(h5), 1);
                                                                                    this.c.b(b9, this.c.i(h5));
                                                                                    this.c.b(this.a.h(b9), this.c.i(b9));
                                                                                    this.c.b(a19, this.c.i(a16));
                                                                                    this.c.b(this.a.h(a19), this.c.i(a19));
                                                                                    if (i == 0) {
                                                                                        break Label_3519;
                                                                                    }
                                                                                }
                                                                                if (d10 == 2) {
                                                                                    final f a20 = this.a.a(a18, 2);
                                                                                    final d d16 = a20.d();
                                                                                    final d d17 = a20.d();
                                                                                    final d d18 = a20.d();
                                                                                    this.c.a(d16, h6.b().toString());
                                                                                    this.c.f(d16);
                                                                                    this.c.a(d17, h6.toString());
                                                                                    this.c.f(d17);
                                                                                    this.c.a(d18, h6.a().toString());
                                                                                    this.c.f(d18);
                                                                                    this.c.a(a17, d14 - 1);
                                                                                    this.c.a(d16, d15 - 1);
                                                                                    this.c.a(this.a.h(d16), 1);
                                                                                    this.c.a(d17, 3);
                                                                                    this.c.a(this.a.h(d17), 1);
                                                                                    this.c.a(d18, 3);
                                                                                    this.c.a(this.a.h(d18), 1);
                                                                                    this.c.a(this.a.h(h5), 1);
                                                                                    int n9 = (int)Math.floor(q2.a / this.b) + 1;
                                                                                    int n10 = (int)Math.floor(q2.b / this.b) + 1;
                                                                                    if (h6.d()) {
                                                                                        final int n11 = n9;
                                                                                        n9 = n10;
                                                                                        n10 = n11;
                                                                                    }
                                                                                    this.c.b(d16, n9 / 2 + 1);
                                                                                    this.c.b(this.a.h(d16), this.c.i(d16));
                                                                                    this.c.b(d17, n10);
                                                                                    this.c.b(this.a.h(d17), this.c.i(d17));
                                                                                    this.c.b(d18, n9 / 2 + 1);
                                                                                    this.c.b(this.a.h(d18), this.c.i(d18));
                                                                                    if (i == 0) {
                                                                                        break Label_3519;
                                                                                    }
                                                                                }
                                                                                if (d10 == 3) {
                                                                                    final f a21 = this.a.a(a18, 3);
                                                                                    final d d19 = a21.d();
                                                                                    final d d20 = a21.d();
                                                                                    final d d21 = a21.d();
                                                                                    final d d22 = a21.d();
                                                                                    this.c.a(d19, h6.c().toString());
                                                                                    this.c.f(d19);
                                                                                    this.c.a(d20, h6.b().toString());
                                                                                    this.c.f(d20);
                                                                                    this.c.a(d21, h6.toString());
                                                                                    this.c.f(d21);
                                                                                    this.c.a(d22, h6.a());
                                                                                    this.c.f(d22);
                                                                                    this.c.a(a17, 1);
                                                                                    this.c.a(d19, 1);
                                                                                    this.c.a(this.a.h(d19), 1);
                                                                                    this.c.a(d20, 3);
                                                                                    this.c.a(this.a.h(d20), 1);
                                                                                    this.c.a(d21, 3);
                                                                                    this.c.a(this.a.h(d21), 1);
                                                                                    this.c.a(d22, 3);
                                                                                    this.c.a(this.a.h(d22), 1);
                                                                                    this.c.a(this.a.h(h5), 1);
                                                                                    int n12 = (int)Math.floor(q2.a / this.b) + 1;
                                                                                    int n13 = (int)Math.floor(q2.b / this.b) + 1;
                                                                                    if (h6.d()) {
                                                                                        final int n14 = n12;
                                                                                        n12 = n13;
                                                                                        n13 = n14;
                                                                                    }
                                                                                    this.c.b(d19, n13 / 2 + 1);
                                                                                    this.c.b(this.a.h(d19), this.c.i(d19));
                                                                                    this.c.b(d20, n12 + 1);
                                                                                    this.c.b(this.a.h(d20), this.c.i(d20));
                                                                                    this.c.b(d21, n13 + 1);
                                                                                    this.c.b(this.a.h(d21), this.c.i(d21));
                                                                                    this.c.b(d22, n12 / 2 + 1);
                                                                                    this.c.b(this.a.h(d22), this.c.i(d22));
                                                                                }
                                                                            }
                                                                            h5 = a16;
                                                                            a15.g();
                                                                            if (i != 0) {
                                                                                break;
                                                                            }
                                                                        }
                                                                    }
                                                                    o.g();
                                                                    continue Label_1399;
                                                                }
                                                                break Label_3554;
                                                            }
                                                            break;
                                                        } while (i == 0);
                                                        break Label_3547;
                                                    }
                                                    break;
                                                } while (i == 0);
                                                q = this.c.c();
                                                continue Label_0922;
                                            }
                                        }
                                    }
                                    i3 = this.c.a();
                                }
                                final e p4 = i3.p();
                                while (true) {
                                    while (p4.f()) {
                                        this.c.b(p4.a(), 1.0);
                                        p4.g();
                                        if (i != 0) {
                                            final r r = new r();
                                            r.a(this.f);
                                            Label_3757: {
                                                Label_3722: {
                                                    switch (this.e) {
                                                        case 0: {
                                                            r.a(new k());
                                                            r.a(new y.f.f.c.m());
                                                            if (i != 0) {
                                                                break Label_3722;
                                                            }
                                                            break Label_3757;
                                                        }
                                                        case 1: {
                                                            r.a(new y.f.f.c.h());
                                                            r.a(new y.f.f.c.m());
                                                            if (i != 0) {
                                                                break Label_3722;
                                                            }
                                                            break Label_3757;
                                                        }
                                                        case 2: {
                                                            r.a(new y.f.f.c.n());
                                                            r.a(new y.f.f.c.m());
                                                            if (i != 0) {
                                                                break;
                                                            }
                                                            break Label_3757;
                                                        }
                                                    }
                                                }
                                                o.a((Object)"Unknown Compactor !");
                                            }
                                            final A t = this.d.t();
                                            r.a(this.c);
                                            r.a(this.g);
                                            r.a(t);
                                            this.h.i = (int)al.d();
                                            al.e();
                                            final int b10 = this.b;
                                            final int b11 = this.b;
                                            final x o3 = this.d.o();
                                            while (true) {
                                                while (o3.f()) {
                                                    final q e3 = o3.e();
                                                    final t t2 = (t)t.b(e3);
                                                    final t t3 = new t(t2.a() * b10, t2.b() * b11);
                                                    t.a(e3, t3);
                                                    this.d.a(e3, t3.a(), t3.b());
                                                    o3.g();
                                                    if (i != 0) {
                                                        if (y.c.i.g) {
                                                            y.f.f.e.a.a = ++i;
                                                        }
                                                        return;
                                                    }
                                                    if (i != 0) {
                                                        break;
                                                    }
                                                }
                                                this.d.a(t);
                                                this.h.j = r.a();
                                                this.h.k = r.b();
                                                this.h.l = r.c();
                                                this.h.m = r.d();
                                                continue;
                                            }
                                        }
                                        if (i != 0) {
                                            break;
                                        }
                                    }
                                    this.h.h = (int)al.d();
                                    al.e();
                                    continue;
                                }
                            }
                            this.c.b(p.a(), 1);
                            p.g();
                            if (i != 0) {
                                break;
                            }
                        }
                        final m k = this;
                        continue;
                    }
                }
                if (!this.c.c(d)) {
                    this.c.n(d);
                }
                ++j;
                if (i != 0) {
                    break;
                }
            }
            final m m = this;
            continue;
        }
    }
    
    d a(final d d) {
        final d g = d.g();
        return (g == null) ? d.c().f() : g;
    }
    
    d b(final d d) {
        final d i = d.i();
        return (i == null) ? d.c().h() : i;
    }
    
    d c(final d d) {
        return this.a.h(d);
    }
}
