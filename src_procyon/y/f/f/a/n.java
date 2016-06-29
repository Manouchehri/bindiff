package y.f.f.a;

import y.f.f.d.*;
import y.d.*;
import y.f.f.b.*;
import y.c.*;

public class n extends t
{
    public void a() {
        final boolean a = y.f.f.a.f.a;
        final c c = this.c.c("y.layout.orthogonal.cluster.NodeSplitter.INSETS_KEY");
        n n = null;
        Label_0263: {
            if (c != null) {
                final e p = this.c.p();
                while (p.f()) {
                    final d a2 = p.a();
                    n = this;
                    if (a) {
                        break Label_0263;
                    }
                    if (!this.b.c(a2)) {
                        final r a3 = r.a(c.b(a2));
                        final o h = this.b.h(a2);
                        if (a3 != null) {
                            double n2 = 0.0;
                            double n3 = 0.0;
                            if (h.a(o.a)) {
                                n2 = a3.b;
                            }
                            if (h.a(o.b)) {
                                n2 = a3.a;
                            }
                            if (h.a(o.c)) {
                                n3 = a3.d;
                            }
                            if (h.a(o.d)) {
                                n3 = a3.c;
                            }
                            final double ceil = Math.ceil(n3 / this.f);
                            final double ceil2 = Math.ceil(n2 / this.f);
                            this.b.c(a2, (int)ceil);
                            this.b.c(this.b.a(a2), (int)ceil);
                            this.b.d(a2, (int)ceil2);
                            this.b.d(this.b.a(a2), (int)ceil2);
                        }
                    }
                    p.g();
                    if (a) {
                        break;
                    }
                }
            }
            n = this;
        }
        final c c2 = n.c.c(y.f.b.f.f);
        final c c3 = this.c.c("y.layout.orthogonal.cluster.NodeSplitter.BORDER_INFO_KEY");
        n n4 = null;
        Label_0633: {
            if (c2 != null && c3 != null) {
                final y y = new y();
                final A t = this.c.t();
                final e p2 = this.c.p();
                while (p2.f()) {
                    final d a4 = p2.a();
                    final q q = (q)c3.b(a4);
                    n4 = this;
                    if (a) {
                        break Label_0633;
                    }
                    Label_0434: {
                        if (!this.b.c(a4) && q != null) {
                            final y.c.f f = (y.c.f)t.b(q);
                            if (f != null) {
                                f.add(a4);
                                if (!a) {
                                    break Label_0434;
                                }
                            }
                            t.a(q, new y.c.f(a4));
                            y.add(q);
                        }
                    }
                    p2.g();
                    if (a) {
                        break;
                    }
                }
                final x a5 = y.a();
                while (a5.f()) {
                    final q e = a5.e();
                    final y.c.f f2 = (y.c.f)t.b(e);
                    final y.d.q q2 = (y.d.q)c2.b(e);
                    if (a) {
                        return;
                    }
                    if (q2 != null) {
                        final int n5 = (int)Math.ceil(q2.a() / this.f);
                        final int n6 = (int)Math.ceil(q2.b() / this.f);
                        final y.f.f.a.o a6 = this.a(f2);
                        this.b.a(new y.f.f.b.n(a6.a, a6.c, n5, 1, o.b));
                        this.b.a(new y.f.f.b.n(a6.a, a6.c, n6, 1, o.c));
                    }
                    a5.g();
                    if (a) {
                        break;
                    }
                }
                this.c.a(t);
            }
            n4 = this;
        }
        n4.a();
    }
    
    private y.f.f.a.o a(final y.c.f f) {
        final boolean a = f.a;
        final y.f.f.a.o o = new y.f.f.a.o();
        final e a2 = f.a();
        q c;
        String string;
        e l;
        Label_0148_Outer:Label_0153_Outer:
        while (a2.f()) {
            c = a2.a().c();
            string = "";
            l = c.l();
            while (true) {
                while (true) {
                    while (l.f()) {
                        string += this.b.h(l.a());
                        l.g();
                        if (!a) {
                            if (a) {
                                break;
                            }
                            continue Label_0148_Outer;
                        }
                        else {
                            Label_0241: {
                                if (a) {
                                    if (string.equals("<_") || string.equals("_<")) {
                                        o.b = c;
                                        if (!a) {
                                            break Label_0241;
                                        }
                                    }
                                    if (string.equals(">^") || string.equals("^>")) {
                                        o.d = c;
                                        if (!a) {
                                            break Label_0241;
                                        }
                                    }
                                    if (string.equals("<^") || string.equals("^<")) {
                                        o.c = c;
                                    }
                                }
                            }
                            a2.g();
                            if (a) {
                                break Label_0148_Outer;
                            }
                            continue Label_0148_Outer;
                        }
                    }
                    if (string.equals(">_") || string.equals("_>")) {
                        o.a = c;
                        continue Label_0153_Outer;
                    }
                    break;
                }
                continue;
            }
        }
        return o;
    }
}
