package y.f.i;

import java.awt.geom.*;
import y.d.*;
import y.f.*;
import java.util.*;
import y.g.*;
import y.c.*;

class av
{
    private X a;
    private byte b;
    private double c;
    private boolean d;
    private boolean e;
    private Rectangle2D f;
    private boolean g;
    private double h;
    private boolean i;
    private long j;
    private ax k;
    private ax l;
    private D m;
    private D n;
    private aC o;
    private D p;
    private y q;
    private f r;
    private D s;
    private D t;
    private aF u;
    private aF v;
    private au w;
    private an x;
    private int y;
    private int z;
    private boolean A;
    
    public av(final X a, final f r) {
        this.y = 0;
        this.z = 0;
        this.a = a;
        this.q = new y(a.o());
        this.r = r;
        this.i();
    }
    
    private void i() {
        this.j = 0L;
        this.b = 2;
        this.c = 3.0;
        this.g = false;
        this.i = false;
        this.d = false;
        this.e = false;
    }
    
    private ao a(final double n, final double n2, final double n3, final double n4) {
        final int f = y.f.i.v.f;
        ao ao = null;
        if (this.A) {
            Label_0096: {
                if (this.e) {
                    ao = new ai(n, n2, n + n3, n2 + n4, true);
                    if (f == 0) {
                        break Label_0096;
                    }
                }
                if (this.d) {
                    ao = new al(n, n2, n + n3, n2 + n4, true);
                    if (f == 0) {
                        break Label_0096;
                    }
                }
                ao = new ao(n, n2, n + n3, n2 + n4, true);
            }
            this.s.add(ao);
            if (f == 0) {
                return ao;
            }
        }
        Label_0195: {
            if (this.e) {
                ao = new ai(n2, n, n2 + n4, n + n3, false);
                if (f == 0) {
                    break Label_0195;
                }
            }
            if (this.d) {
                ao = new al(n2, n, n2 + n4, n + n3, false);
                if (f == 0) {
                    break Label_0195;
                }
            }
            ao = new ao(n2, n, n2 + n4, n + n3, false);
        }
        this.t.add(ao);
        return ao;
    }
    
    private void a(final ag ag, final ag ag2, final byte b) {
        final int f = y.f.i.v.f;
        final q q = (q)ag.f();
        final aJ aj = (aJ)this.x.b(ag2);
        final aJ aj2 = (aJ)this.w.b(q);
        if (this.A) {
            Label_0094: {
                switch (b) {
                    case 1: {
                        aj2.b(ag2);
                        aj.d(q);
                        if (f != 0) {
                            break Label_0094;
                        }
                        break;
                    }
                    case 2: {
                        aj2.d(ag2);
                        aj.b(q);
                        break;
                    }
                }
            }
            if (f == 0) {
                return;
            }
        }
        Label_0158: {
            switch (b) {
                case 1: {
                    aj2.f(ag2);
                    aj.h(q);
                    if (f != 0) {
                        break Label_0158;
                    }
                    break;
                }
                case 2: {
                    aj2.h(ag2);
                    aj.f(q);
                    break;
                }
            }
        }
    }
    
    private void b(final ag ag, final ag ag2, final byte b) {
        final int f = y.f.i.v.f;
        final q q = (q)ag.f();
        final aJ aj = (aJ)this.x.b(ag2);
        final aJ aj2 = (aJ)this.w.b(q);
        if (this.A) {
            Label_0107: {
                switch (b) {
                    case 1: {
                        if (aj.b() == q) {
                            break;
                        }
                        aj2.a(ag2);
                        aj.c(q);
                        if (f != 0) {
                            break Label_0107;
                        }
                        break;
                    }
                    case 2: {
                        if (aj.a() != q) {
                            aj2.c(ag2);
                            aj.a(q);
                            break;
                        }
                        break;
                    }
                }
            }
            if (f == 0) {
                return;
            }
        }
        Label_0195: {
            switch (b) {
                case 1: {
                    if (aj.d() == q) {
                        break;
                    }
                    aj2.e(ag2);
                    aj.g(q);
                    if (f != 0) {
                        break Label_0195;
                    }
                    break;
                }
                case 2: {
                    if (aj.c() != q) {
                        aj2.g(ag2);
                        aj.e(q);
                        break;
                    }
                    break;
                }
            }
        }
    }
    
    private void j() {
        final int f = y.f.i.v.f;
        final e p = this.a.p();
    Label_0013:
        while (true) {
        Label_0142_Outer:
            while (p.f()) {
                final d a = p.a();
                this.a.a(a, y.d.t.b(this.a.n(a)));
                this.a.b(a, y.d.t.b(this.a.o(a)));
                final X a2 = this.a;
                if (f == 0) {
                    final I g = a2.g(a);
                    int i = 0;
                    while (true) {
                        while (i < g.pointCount()) {
                            final t point = g.getPoint(i);
                            g.setPoint(i, point.b, point.a);
                            ++i;
                            if (f == 0) {
                                if (f != 0) {
                                    break;
                                }
                                continue Label_0142_Outer;
                            }
                            else {
                                if (f != 0) {
                                    break Label_0142_Outer;
                                }
                                continue Label_0013;
                            }
                        }
                        p.g();
                        continue;
                    }
                }
                final x o = a2.o();
                while (o.f()) {
                    final q e = o.e();
                    final double m = this.a.m(e);
                    final double n = this.a.n(e);
                    this.a.b(e, this.a.q(e), this.a.p(e));
                    this.a.c(e, n, m);
                    o.g();
                    if (f != 0) {
                        break;
                    }
                }
                return;
            }
            final X a3 = this.a;
            continue;
        }
    }
    
    private void k() {
        this.f.setFrame(this.f.getY(), this.f.getX(), this.f.getHeight(), this.f.getWidth());
    }
    
    public void a(final byte b) {
        this.b = b;
    }
    
    public void a(final double h) {
        this.h = h;
        this.i = true;
    }
    
    public void b(final double n) {
        if (Math.abs(n) > 0.0) {
            this.c = Math.abs(n);
            if (y.f.i.v.f == 0) {
                return;
            }
        }
        this.c = 0.5;
    }
    
    public void a(final boolean d) {
        this.d = d;
    }
    
    public void b(final boolean e) {
        this.e = e;
    }
    
    public D a() {
        return this.s;
    }
    
    public D b() {
        return this.t;
    }
    
    public c c() {
        return this.v;
    }
    
    public c d() {
        return this.w;
    }
    
    public c e() {
        return this.u;
    }
    
    public String f() {
        return "\n===Orthogonal Sweepline===\nNumber of obstacles (nodes) = " + this.a.f() + "\n" + "Number of additional obstacles (edge segments) = " + this.y + "\n" + "BoundingBox = " + this.f + "\n" + "Halo = " + this.c + "\n" + "Number of vertical sight patches = " + this.s.size() + "\n" + "Number of horizontal sight patches = " + this.t.size() + "\n" + "Number of sight patch intersections = " + this.z + "\n" + "===Orthogonal Sweepline===\n";
    }
    
    private void l() {
        if (this.g) {
            return;
        }
        this.f = this.m();
        int n = 0;
        Label_0045: {
            if (this.i) {
                n = (int)this.h;
                if (y.f.i.v.f == 0) {
                    break Label_0045;
                }
            }
            n = (int)(10.0 * this.c);
        }
        this.f.setFrame(this.f.getX() - n, this.f.getY() - n, this.f.getWidth() + 2 * n, this.f.getHeight() + 2 * n);
    }
    
    private Rectangle2D m() {
        if (this.a.i()) {
            return new Rectangle2D.Double(0.0, 0.0, 0.0, 0.0);
        }
        final Rectangle2D a = ae.a(this.a, this.q.a(), this.r.a());
        return new Rectangle2D.Double((int)a.getX(), (int)a.getY(), (int)a.getWidth(), (int)a.getHeight());
    }
    
    private void n() {
        this.o = new aC();
        this.p = new D();
        this.k = new ax(this, this.o);
        this.l = new ax(this, this.o);
        this.m = new D();
        this.n = new D();
    }
    
    private void o() {
        final int f = y.f.i.v.f;
        this.x = new an();
        this.v = new aF();
        this.w = new au();
        final x a = this.q.a();
        while (a.f()) {
            this.w.a((q)a.d(), new aJ());
            a.g();
            if (f != 0) {
                break;
            }
        }
    }
    
    private void p() {
        final int f = y.f.i.v.f;
        this.u = new aF();
        C c = this.t.m();
        while (true) {
            while (c.f()) {
                this.u.a((ao)c.d(), new D());
                c.g();
                if (f != 0) {
                    while (c.f()) {
                        this.u.a((ao)c.d(), new D());
                        c.g();
                        if (f != 0) {
                            break;
                        }
                    }
                    return;
                }
                if (f != 0) {
                    break;
                }
            }
            c = this.s.m();
            continue;
        }
    }
    
    private void q() {
        final int f = y.f.i.v.f;
        D d = null;
        Label_0027: {
            if (this.A) {
                d = this.s;
                if (f == 0) {
                    break Label_0027;
                }
            }
            d = this.t;
        }
        final C m = d.m();
    Label_0212:
        while (true) {
            while (m.f()) {
                final ao ao = (ao)m.d();
                this.v.a(ao, this.x.b(ao.o()));
                m.g();
                if (f != 0) {
                    final x a = this.q.a();
                    while (a.f()) {
                        final aJ aj = (aJ)this.w.b(a.d());
                        aj.e = this.a(aj.e);
                        aj.f = this.a(aj.f);
                        aj.g = this.a(aj.g);
                        aj.h = this.a(aj.h);
                        a.g();
                        if (f != 0) {
                            break;
                        }
                    }
                    return;
                }
                if (f != 0) {
                    break;
                }
            }
            if (this.A) {
                final x a2 = this.q.a();
                while (a2.f()) {
                    final aJ aj2 = (aJ)this.w.b(a2.d());
                    aj2.a = this.a(aj2.a);
                    aj2.b = this.a(aj2.b);
                    aj2.c = this.a(aj2.c);
                    aj2.d = this.a(aj2.d);
                    a2.g();
                    if (f != 0) {
                        continue Label_0212;
                    }
                }
                return;
            }
            continue Label_0212;
        }
    }
    
    private D a(final D d) {
        final int f = y.f.i.v.f;
        final D d2 = new D();
        ao ao = null;
        final C m = d.m();
        while (m.f()) {
            final ao ao2 = (ao)((ag)m.d()).f();
            if (ao2 != ao) {
                if (ao2 != null) {
                    d2.add(ao2);
                }
            }
            ao = ao2;
            m.g();
            if (f != 0) {
                break;
            }
        }
        return d2;
    }
    
    private void r() {
        final int f = y.f.i.v.f;
        Label_0111: {
            if (this.A) {
                final C m = this.s.m();
            Label_0106_Outer:
                while (m.f()) {
                    final ao ao = (ao)m.d();
                    final C i = ((al)ao).b.m();
                    while (true) {
                        while (i.f()) {
                            ((al)i.d()).a(false, (al)ao);
                            i.g();
                            if (f == 0) {
                                if (f != 0) {
                                    break;
                                }
                                continue Label_0106_Outer;
                            }
                            else {
                                if (f != 0) {
                                    break Label_0111;
                                }
                                continue Label_0106_Outer;
                            }
                        }
                        m.g();
                        continue;
                    }
                }
                return;
            }
        }
        final C j = this.t.m();
    Label_0205_Outer:
        while (j.f()) {
            final ao ao2 = (ao)j.d();
            final C k = ((al)ao2).b.m();
            while (true) {
                while (k.f()) {
                    ((al)k.d()).a(false, (al)ao2);
                    k.g();
                    if (f == 0) {
                        if (f != 0) {
                            break;
                        }
                        continue Label_0205_Outer;
                    }
                    else {
                        if (f != 0) {
                            break Label_0205_Outer;
                        }
                        continue Label_0205_Outer;
                    }
                }
                j.g();
                continue;
            }
        }
    }
    
    private void s() {
        this.o = null;
        this.p = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
    }
    
    public void g() {
        final int f = y.f.i.v.f;
        this.l();
        this.o();
        if (this.e) {
            this.d = true;
        }
        if (this.b == 8) {
            this.t();
            this.u();
            this.p();
            this.h();
            if (f == 0) {
                return;
            }
        }
        if (this.b == 4) {
            this.u();
            if (f == 0) {
                return;
            }
        }
        this.t();
    }
    
    void h() {
        final int f = y.f.i.v.f;
        final D d = new D();
        C c = this.t.m();
        while (true) {
            while (c.f()) {
                d.add(new aA((ao)c.d()));
                c.g();
                if (f != 0) {
                    while (c.f()) {
                        d.add(new aA((ao)c.d()));
                        c.g();
                        if (f != 0) {
                            break;
                        }
                    }
                    y.d.f.a(d, new aw(this, new Rectangle2D.Double(), new Rectangle2D.Double(), new Rectangle2D.Double()));
                    return;
                }
                if (f != 0) {
                    break;
                }
            }
            c = this.s.m();
            continue;
        }
    }
    
    private void t() {
        this.A = true;
        this.s = new D();
        this.x();
    }
    
    private void u() {
        this.A = false;
        this.t = new D();
        this.k();
        this.j();
        this.x();
        this.j();
        this.k();
    }
    
    private void v() {
        ++this.j;
        this.k.a(this.f.getY(), new ag(this.f.getX(), this.f.getY(), this.f.getY() + this.f.getHeight(), (byte)8, this.j));
    }
    
    private void w() {
        final int f = y.f.i.v.f;
        final C m = this.k.a().m();
        while (m.f()) {
            final ag ag = (ag)m.d();
            final double a = ag.a();
            final double b = ag.b();
            final ag ag2 = (ag)this.k.b(b, ag);
            final ao a2 = this.a(a, b, this.f.getX() + this.f.getWidth() - a, this.f.getY() + this.f.getHeight() - b);
            ag2.a(a2);
            ag.a(a2);
            a2.a(ag2, ag);
            if (this.d) {
                ((al)a2).a(true, ag2.a);
            }
            m.g();
            if (f != 0) {
                break;
            }
        }
    }
    
    private void x() {
        final int f = y.f.i.v.f;
        this.n();
        this.B();
        this.C();
        this.p.sort(new aB());
        final D p = this.p;
        this.v();
        final C m = p.m();
        double n = ((ag)m.d()).a();
        while (true) {
            while (m.f()) {
                final ag ag = (ag)m.d();
                final double n2 = dcmpl(ag.a(), n);
                if (f != 0) {
                    if (n2 != 0) {
                        this.r();
                    }
                    this.s();
                    return;
                }
                if (n2 > 0) {
                    n = ag.a();
                    this.y();
                    this.z();
                    this.m.clear();
                    this.n.clear();
                }
                if (ag.d() == 8) {
                    this.m.add(ag);
                }
                if (ag.d() == -8) {
                    this.n.add(ag);
                }
                m.g();
                if (f != 0) {
                    break;
                }
            }
            this.y();
            this.z();
            this.m.clear();
            this.n.clear();
            this.w();
            this.q();
            final boolean d = this.d;
            continue;
        }
    }
    
    private void y() {
        final int i = y.f.i.v.f;
        if (this.n.isEmpty()) {
            return;
        }
        ag ag = null;
        D d = null;
        if (this.d) {
            d = new D();
        }
        final C m = this.n.m();
        while (true) {
            do {
                Label_0045: {
                    m.f();
                }
                int j = 0;
                Label_0051:
            Label_1238_Outer:
                while (j != 0) {
                    ag = (ag)m.d();
                    final double b = ag.b();
                    final double c = ag.c();
                    if (i == 0) {
                        final double n = c;
                        final C k = this.k.a().m();
                        int n2 = 0;
                        while (k.f()) {
                            j = n2;
                            if (i != 0) {
                                continue Label_0051;
                            }
                            if (j != 0) {
                                break;
                            }
                            final ag ag2 = (ag)k.d();
                            final double b2 = ag2.b();
                            final double c2 = ag2.c();
                            Label_0291: {
                                if (c2 >= b) {
                                    if (b2 > n) {
                                        n2 = 1;
                                        if (i == 0) {
                                            break Label_0291;
                                        }
                                    }
                                    final ag ag3 = (ag)this.k.b(b2, ag2);
                                    if (ag.a() > ag2.a()) {
                                        final ao a = this.a(ag2.a(), b2, ag.a() - ag2.a(), c2 - b2);
                                        if (ag3.f() instanceof d) {
                                            a.n();
                                        }
                                        ag3.a(a);
                                        ag2.a(a);
                                        a.a(ag3, ag2);
                                        if (this.d) {
                                            d.add(a);
                                            ((al)a).a(true, ag3.a);
                                        }
                                    }
                                }
                            }
                            k.g();
                            if (i != 0) {
                                break;
                            }
                        }
                        this.l.b(ag.b(), ag);
                        m.g();
                        continue Label_0045;
                    }
                    double n3 = c;
                    double n4 = 0.0;
                    final double a2 = ag.a();
                    double y = this.f.getY();
                    final C l = this.l.a().m();
                    final C m2 = this.k.a().m();
                    if (l.k() == 0) {
                        ++this.j;
                        final ag ag4 = new ag(a2, this.f.getY(), this.f.getY() + this.f.getHeight(), (byte)8, this.j);
                        this.k.a(this.f.getY(), ag4);
                        if (this.d) {
                            final C m3 = d.m();
                            while (m3.f()) {
                                ag4.a(true, (ao)m3.d());
                                m3.g();
                                if (i != 0) {
                                    return;
                                }
                                if (i != 0) {
                                    break;
                                }
                            }
                        }
                        this.A();
                        return;
                    }
                    if (m2.k() == 0) {
                        double c3 = 0.0;
                        while (true) {
                            while (l.f()) {
                                final ag ag5 = (ag)l.d();
                                final double b3 = ag5.b();
                                c3 = ag5.c();
                                if (i != 0) {
                                    final ag ag6 = new ag(a2, c3, this.f.getY() + this.f.getHeight(), (byte)8, this.j);
                                    this.k.a(c3, ag6);
                                    if (this.d) {
                                        final C m4 = d.m();
                                        while (m4.f()) {
                                            ag6.a(true, (ao)m4.d());
                                            m4.g();
                                            if (i != 0) {
                                                return;
                                            }
                                            if (i != 0) {
                                                break;
                                            }
                                        }
                                    }
                                    this.A();
                                    return;
                                }
                                Label_0689: {
                                    Label_0683: {
                                        if (b3 <= y) {
                                            if (c3 <= y) {
                                                break Label_0683;
                                            }
                                            y = c3;
                                            if (i == 0) {
                                                break Label_0683;
                                            }
                                        }
                                        ++this.j;
                                        final ag ag7 = new ag(a2, y, b3, (byte)8, this.j);
                                        this.k.a(y, ag7);
                                        if (this.d) {
                                            final C m5 = d.m();
                                            while (m5.f()) {
                                                ag7.a(true, (ao)m5.d());
                                                m5.g();
                                                if (i != 0) {
                                                    break Label_0689;
                                                }
                                                if (i != 0) {
                                                    break;
                                                }
                                            }
                                        }
                                        y = c3;
                                    }
                                    l.g();
                                }
                                if (i != 0) {
                                    break;
                                }
                            }
                            ++this.j;
                            continue Label_1238_Outer;
                        }
                    }
                    while (true) {
                    Label_1237:
                        while (y < this.f.getY() + this.f.getHeight()) {
                            int n5 = 0;
                            int n6 = 0;
                            Label_0930: {
                                while (l.f()) {
                                    n6 = n5;
                                    if (i != 0 || n6 != 0) {
                                        break Label_0930;
                                    }
                                    final ag ag8 = (ag)l.d();
                                    final double b4 = ag8.b();
                                    final double c4 = ag8.c();
                                    Label_0917: {
                                        if (b4 <= y) {
                                            if (c4 <= y) {
                                                break Label_0917;
                                            }
                                            y = c4;
                                            if (i == 0) {
                                                break Label_0917;
                                            }
                                        }
                                        n5 = 1;
                                        n3 = y;
                                        n4 = b4;
                                        y = c4;
                                    }
                                    l.g();
                                    if (i != 0) {
                                        goto Label_0928;
                                    }
                                }
                                goto Label_0928;
                            }
                            if (n6 == 0) {
                                n3 = y;
                                n4 = (y = this.f.getY() + this.f.getHeight());
                            }
                            int n7 = 0;
                            int n8 = 0;
                            Label_1129: {
                                while (m2.f()) {
                                    n8 = n7;
                                    if (i != 0 || n8 != 0) {
                                        break Label_1129;
                                    }
                                    final ag ag9 = (ag)m2.d();
                                    final double b5 = ag9.b();
                                    ag9.c();
                                    Label_1122: {
                                        Label_1119: {
                                            Label_1113: {
                                                if (b5 > n4) {
                                                    ++this.j;
                                                    final ag ag10 = new ag(a2, n3, n4, (byte)8, this.j);
                                                    this.k.a(n3, ag10);
                                                    if (this.d) {
                                                        final C m6 = d.m();
                                                        while (m6.f()) {
                                                            ag10.a(true, (ao)m6.d());
                                                            m6.g();
                                                            if (i != 0) {
                                                                break Label_1122;
                                                            }
                                                            if (i != 0) {
                                                                break Label_1113;
                                                            }
                                                        }
                                                    }
                                                    break Label_1119;
                                                }
                                            }
                                            m2.g();
                                        }
                                        n7 = 1;
                                    }
                                    if (i != 0) {
                                        goto Label_1127;
                                    }
                                }
                                goto Label_1127;
                            }
                            if (n8 == 0) {
                                ++this.j;
                                final ag ag11 = new ag(a2, n3, n4, (byte)8, this.j);
                                this.k.a(n3, ag11);
                                final av av = this;
                                if (i == 0) {
                                    if (this.d) {
                                        final C m7 = d.m();
                                        while (m7.f()) {
                                            ag11.a(true, (ao)m7.d());
                                            m7.g();
                                            if (i != 0) {
                                                return;
                                            }
                                            if (i != 0) {
                                                break Label_1237;
                                            }
                                        }
                                        continue Label_1238_Outer;
                                    }
                                    continue Label_1238_Outer;
                                }
                                else {
                                    av.A();
                                }
                                return;
                            }
                        }
                        final av av = this;
                        continue;
                    }
                }
                break;
            } while (i == 0);
            continue;
        }
    }
    
    private void z() {
        final int f = y.f.i.v.f;
        if (this.m.isEmpty()) {
            return;
        }
        final C m = this.m.m();
    Label_0573_Outer:
        while (m.f()) {
            final ag ag = (ag)m.d();
            final double b = ag.b();
            final double c = ag.c();
            final C i = this.k.a().m();
            if (f == 0) {
                boolean b2 = false;
                while (true) {
                    while (i.f()) {
                        final boolean b3 = b2;
                        if (f == 0) {
                            if (b3) {
                                break;
                            }
                            final ag ag2 = (ag)i.d();
                            final double b4 = ag2.b();
                            final double c2 = ag2.c();
                            Label_0554: {
                                Label_0548: {
                                    if (c2 >= b) {
                                        if (b4 > c) {
                                            b2 = true;
                                            if (f == 0) {
                                                break Label_0548;
                                            }
                                        }
                                        final ag ag3 = (ag)this.k.b(b4, ag2);
                                        ag ag4 = null;
                                        if (b4 < b) {
                                            ++this.j;
                                            ag4 = new ag(ag.a(), b4, b, (byte)8, this.j);
                                            this.k.a(b4, ag4);
                                        }
                                        ag ag5 = null;
                                        if (c2 > c) {
                                            ++this.j;
                                            ag5 = new ag(ag.a(), c, c2, (byte)8, this.j);
                                            this.k.a(c, ag5);
                                        }
                                        final ag ag6 = null;
                                        if (ag.a() > ag2.a()) {
                                            final ao a = this.a(ag2.a(), b4, ag.a() - ag2.a(), c2 - b4);
                                            if (ag3.f() instanceof d) {
                                                a.n();
                                            }
                                            ag3.a(a);
                                            ag2.a(a);
                                            a.a(ag3, ag2);
                                            if (!this.d) {
                                                break Label_0548;
                                            }
                                            if (ag4 != null) {
                                                ag4.a(true, a);
                                            }
                                            if (ag5 != null) {
                                                ag5.a(true, a);
                                            }
                                            if (ag6 != null) {
                                                ag6.a(true, a);
                                            }
                                            ((al)a).a(true, ag3.a);
                                            if (f == 0) {
                                                break Label_0548;
                                            }
                                        }
                                        if (this.d) {
                                            if (ag4 != null) {
                                                final C j = ag2.a.m();
                                                while (j.f()) {
                                                    ag4.a(true, (ao)j.d());
                                                    j.g();
                                                    if (f != 0) {
                                                        break Label_0554;
                                                    }
                                                    if (f != 0) {
                                                        break;
                                                    }
                                                }
                                            }
                                            if (ag5 != null) {
                                                final C k = ag2.a.m();
                                                while (k.f()) {
                                                    ag5.a(true, (ao)k.d());
                                                    k.g();
                                                    if (f != 0) {
                                                        break Label_0554;
                                                    }
                                                    if (f != 0) {
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                i.g();
                            }
                            if (f != 0) {
                                break;
                            }
                            continue Label_0573_Outer;
                        }
                        else {
                            m.g();
                            if (f != 0) {
                                break Label_0573_Outer;
                            }
                            continue Label_0573_Outer;
                        }
                    }
                    this.l.a(ag.b(), ag);
                    continue;
                }
            }
            return;
        }
        this.A();
    }
    
    private void A() {
        final int i = y.f.i.v.f;
        final C m = this.l.a().m();
        final C j = this.k.a().m();
        if (m.k() == 0) {
            return;
        }
        if (j.k() == 0) {
            return;
        }
        final D d = new D();
        m.i();
        while (true) {
        Label_0507_Outer:
            while (m.f()) {
                final ag ag = (ag)m.d();
                final Object f = ag.f();
                if (i == 0) {
                    if (f instanceof d) {
                        d.add(ag);
                    }
                    m.g();
                    if (i != 0) {
                        break;
                    }
                    continue;
                }
                else {
                    ag ag2 = (ag)f;
                    double b = ag2.b();
                    double c = ag2.c();
                    if (this.x.b(ag2) == null) {
                        this.x.a(ag2, new aJ());
                    }
                    j.g();
                    while (true) {
                        do {
                            Label_0182: {
                                j.f();
                            }
                            int k = 0;
                            Label_0188:
                            while (k != 0) {
                                final ag ag3 = (ag)j.d();
                                final double b2 = ag3.b();
                                final double c2 = ag3.c();
                                final Object b3 = this.x.b(ag3);
                                if (i == 0) {
                                    if (b3 == null) {
                                        this.x.a(ag3, new aJ());
                                    }
                                    int n = 0;
                                    while (m.f()) {
                                        k = n;
                                        if (i != 0) {
                                            continue Label_0188;
                                        }
                                        if (k != 0) {
                                            break;
                                        }
                                        final ag ag4 = (ag)m.d();
                                        final double b4 = ag4.b();
                                        final double c3 = ag4.c();
                                        if (ag4.f() instanceof d) {
                                            m.g();
                                            if (i == 0) {
                                                continue Label_0507_Outer;
                                            }
                                        }
                                        if (c3 <= b) {
                                            Label_0354: {
                                                if (c3 == b) {
                                                    this.b(ag4, ag2, (byte)2);
                                                    if (i == 0) {
                                                        break Label_0354;
                                                    }
                                                }
                                                this.a(d, ag4, ag2, (byte)2);
                                            }
                                            m.g();
                                            if (i == 0) {
                                                continue Label_0507_Outer;
                                            }
                                        }
                                        if (b4 >= c && c3 <= b2) {
                                            if (b4 == c) {
                                                this.b(ag4, ag2, (byte)1);
                                            }
                                            if (b4 > c) {
                                                this.a(d, ag4, ag2, (byte)1);
                                            }
                                            if (c3 == b2) {
                                                this.b(ag4, ag3, (byte)2);
                                            }
                                            if (c3 < b2) {
                                                this.a(d, ag4, ag3, (byte)2);
                                            }
                                            m.g();
                                            if (i == 0) {
                                                continue Label_0507_Outer;
                                            }
                                        }
                                        n = 1;
                                        if (i != 0) {
                                            break;
                                        }
                                    }
                                    ag2 = ag3;
                                    b = b2;
                                    c = c2;
                                    j.g();
                                    continue Label_0182;
                                }
                                final ag ag5 = (ag)b3;
                                final double b5 = ag5.b();
                                final double c4 = ag5.c();
                                Label_0622: {
                                    if (!(ag5.f() instanceof d)) {
                                        Label_0581: {
                                            if (b5 >= c) {
                                                if (b5 == c) {
                                                    this.b(ag5, ag2, (byte)1);
                                                    if (i == 0) {
                                                        break Label_0581;
                                                    }
                                                }
                                                this.a(d, ag5, ag2, (byte)1);
                                            }
                                        }
                                        if (c4 <= b) {
                                            if (c4 == b) {
                                                this.b(ag5, ag2, (byte)2);
                                                if (i == 0) {
                                                    break Label_0622;
                                                }
                                            }
                                            this.a(d, ag5, ag2, (byte)2);
                                        }
                                    }
                                }
                                m.g();
                                if (i != 0) {
                                    return;
                                }
                                break;
                            }
                            break;
                        } while (i == 0);
                        if (m.f()) {
                            m.d();
                            continue;
                        }
                        break;
                    }
                    return;
                }
            }
            m.i();
            j.d();
            continue;
        }
    }
    
    private void a(final D d, final ag ag, final ag ag2, final byte b) {
        final int f = y.f.i.v.f;
        boolean b2 = false;
        final double b3 = ag.b();
        final double c = ag.c();
        final double b4 = ag2.b();
        final double c2 = ag2.c();
        boolean b5 = false;
        Label_0204: {
            Label_0121: {
                if (b == 2) {
                    final C m = d.m();
                    while (m.f()) {
                        b5 = b2;
                        if (f != 0) {
                            break;
                        }
                        if (b5) {
                            break;
                        }
                        final ag ag3 = (ag)m.d();
                        ag3.b();
                        final double c3 = ag3.c();
                        if (c3 >= c && c3 <= b4) {
                            b2 = true;
                        }
                        m.g();
                        if (f != 0) {
                            break Label_0121;
                        }
                    }
                    break Label_0204;
                }
            }
            final C i = d.m();
            while (i.f()) {
                final boolean b6 = b2;
                if (f != 0) {
                    break;
                }
                if (b6) {
                    break;
                }
                final ag ag4 = (ag)i.d();
                final double b7 = ag4.b();
                ag4.c();
                if (b7 <= b3 && b7 >= c2) {
                    b2 = true;
                }
                i.g();
                if (f != 0) {
                    break;
                }
            }
        }
        if (!b5) {
            this.a(ag, ag2, b);
        }
    }
    
    private void B() {
        final int f = y.f.i.v.f;
        final c c = this.a.c(y.f.i.n.b);
        final x a = this.q.a();
        while (a.f()) {
            final q e = a.e();
            y.d.y s = this.a.s(e);
            if (c != null && c.d(e)) {
                s = new y.d.y(this.a.j(e) - 0.5, this.a.k(e) - 0.5, 1.0, 1.0);
            }
            final double c2 = s.c();
            final double n = c2 + s.a();
            final double d = s.d();
            final double n2 = d + s.b();
            ++this.j;
            this.x.a(this.a(this.p, c2, d, n2, this.j, e), new aJ());
            this.b(this.p, n, d, n2, this.j, e);
            a.g();
            if (f != 0) {
                break;
            }
        }
    }
    
    boolean a(final q q, final t t, final t t2, final c c) {
        final int f = y.f.i.v.f;
        byte b = 0;
        Label_0268: {
            if (this.A) {
                if (t.a == t2.a && t.b < t2.b) {
                    b = 2;
                    if (f == 0) {
                        break Label_0268;
                    }
                }
                if (t.a == t2.a && t.b > t2.b) {
                    b = 1;
                    if (f == 0) {
                        break Label_0268;
                    }
                }
                if (t.b == t2.b && t.a < t2.a) {
                    b = 4;
                    if (f == 0) {
                        break Label_0268;
                    }
                }
                if (t.b != t2.b || t.a <= t2.a) {
                    break Label_0268;
                }
                b = 8;
                if (f == 0) {
                    break Label_0268;
                }
            }
            if (t.a == t2.a && t.b < t2.b) {
                b = 4;
                if (f == 0) {
                    break Label_0268;
                }
            }
            if (t.a == t2.a && t.b > t2.b) {
                b = 8;
                if (f == 0) {
                    break Label_0268;
                }
            }
            if (t.b == t2.b && t.a < t2.a) {
                b = 2;
                if (f == 0) {
                    break Label_0268;
                }
            }
            if (t.b == t2.b && t.a > t2.a) {
                b = 1;
            }
        }
        final int a = y.f.ax.a(aE.a(b)).a();
        this.a.c(y.f.aF.a);
        this.a.c(y.f.aF.b);
        final e j = q.j();
        boolean d = false;
        while (j.f()) {
            final d a2 = j.a();
            d = c.d(a2);
            if (f != 0) {
                return d;
            }
            if (!d) {
                if (a2.c() == q) {
                    final aE d2 = aE.d(this.a, a2);
                    if (d2 != null && d2.a() && (d2.g() || d2.b() == b)) {
                        final t p4 = this.a.p(a2);
                        if (t.a == t2.a && Math.abs(t.a - p4.a) < 1.0) {
                            return true;
                        }
                        if (t.b == t2.b && Math.abs(t.b - p4.b) < 1.0) {
                            return true;
                        }
                    }
                }
                if (a2.d() == q) {
                    final aE e = aE.e(this.a, a2);
                    if (e != null && e.a() && (e.g() || e.b() == b)) {
                        final t q2 = this.a.q(a2);
                        if (t.a == t2.a && Math.abs(t.a - q2.a) < 1.0) {
                            return true;
                        }
                        if (t.b == t2.b && Math.abs(t.b - q2.b) < 1.0) {
                            return true;
                        }
                    }
                }
                if (this.a(a2, true, a, q, t, t2)) {
                    return true;
                }
                if (this.a(a2, false, a, q, t, t2)) {
                    return true;
                }
            }
            j.g();
            if (f != 0) {
                break;
            }
        }
        return d;
    }
    
    private boolean a(final d d, final boolean b, final int n, final q q, final t t, final t t2) {
        final int f = y.f.i.v.f;
        final Collection a = ad.a(this.a, d, b);
        boolean a2 = false;
        if (a != null && !a.isEmpty()) {
            for (final y.f.ax ax : a) {
                if (ax.b()) {
                    a2 = ax.a(n);
                    if (f != 0) {
                        break;
                    }
                    if (!a2) {
                        continue;
                    }
                    final t b2 = t.b(this.a.l(q), new t(ax.c(), ax.d()));
                    if (t.a == t2.a && Math.abs(t.a - b2.a) < 1.0) {
                        return true;
                    }
                    if (t.b == t2.b && Math.abs(t.b - b2.b) < 1.0) {
                        return true;
                    }
                    continue;
                }
            }
        }
        return a2;
    }
    
    private void C() {
        final int i = y.f.i.v.f;
        final h b = M.b(new boolean[this.a.g()]);
        final e a = this.r.a();
        while (true) {
            while (a.f()) {
                final c c;
                final h h = (h)(c = b);
                if (i != 0) {
                    final c c2 = c;
                    final e a2 = this.r.a();
                    do {
                        double f = 0.0;
                        Label_0083: {
                            f = (a2.f() ? 1 : 0);
                        }
                        Label_0089:
                        while (f != 0) {
                            final d a3 = a2.a();
                            double n = this.c;
                            double c3 = this.c;
                            if (c2 != null && c2.d(a3.c())) {
                                c3 = (n = 1.0);
                            }
                            final D m = this.a.m(a3);
                            if (!m.isEmpty()) {
                                final p k = m.k();
                                t t = (t)k.c();
                                int n2 = 0;
                                p p = k.a();
                                while (p != null) {
                                    final t t2 = (t)p.c();
                                    final double n3 = f = dcmpg(Math.abs(t.a - t2.a), 0.01);
                                    if (i != 0) {
                                        continue Label_0089;
                                    }
                                    Label_0492: {
                                        if (n3 < 0) {
                                            if (n2 == 0 && this.a(a3.c(), t, t2, b)) {
                                                t = t2;
                                                if (i == 0) {
                                                    break Label_0492;
                                                }
                                            }
                                            if (n2 == m.size() - 2 && this.a(a3.d(), t2, t, b)) {
                                                t = t2;
                                                if (i == 0) {
                                                    break Label_0492;
                                                }
                                            }
                                            final double min = Math.min(t.b, t2.b);
                                            final double max = Math.max(t.b, t2.b);
                                            if (n2 == m.size() - 3 && this.a(a3.d(), (t)p.a().c(), t2, b)) {
                                                n = Math.max(-n, 0.5 * (min - max));
                                            }
                                            ++this.j;
                                            this.a(this.p, t.a - c3, min - n, max + n, this.j, a3);
                                            this.b(this.p, t.a + c3, min - n, max + n, this.j, a3);
                                            ++this.y;
                                        }
                                        t = t2;
                                    }
                                    p = p.a();
                                    ++n2;
                                    if (i != 0) {
                                        break;
                                    }
                                }
                            }
                            a2.g();
                            continue Label_0083;
                        }
                        break;
                    } while (i == 0);
                    return;
                }
                h.a(a.a(), true);
                a.g();
                if (i != 0) {
                    break;
                }
            }
            c c = this.a.c(y.f.i.n.b);
            continue;
        }
    }
    
    private ag a(final D d, final double n, final double n2, final double n3, final long n4, final Object o) {
        final ag ag = new ag(n, n2, n3, (byte)8, n4);
        ag.a(o);
        d.add(ag);
        return ag;
    }
    
    private ag b(final D d, final double n, final double n2, final double n3, final long n4, final Object o) {
        final ag ag = new ag(n, n2, n3, (byte)(-8), n4);
        ag.a(o);
        d.add(ag);
        return ag;
    }
    
    static aF a(final av av) {
        return av.u;
    }
    
    static int b(final av av) {
        return av.z++;
    }
}
