package y.f.f.e;

import y.g.*;
import y.f.f.b.*;
import y.f.h.*;
import y.c.*;

public class k implements b
{
    protected i a;
    protected h b;
    private y.c.h c;
    private y.c.h d;
    private static double e;
    private int f;
    private static final Integer g;
    private static final Integer h;
    private static final Integer i;
    private boolean j;
    
    public k() {
        this.f = 0;
        this.j = false;
    }
    
    public int b() {
        return this.f;
    }
    
    public void a(final h b) {
        this.b = b;
        this.a = this.b.a();
    }
    
    public void a() {
        o.a(this, 1, "------->>> Entering Layout Phase");
        final al al = new al();
        final al al2 = new al();
        final i i = new i();
        final A t = i.t();
        final y.c.h u = i.u();
        final y.c.h u2 = i.u();
        this.a(i, t, u, u2);
        o.a(this, 3, "Prof: ---> Constructing network took " + al2);
        final y.c.h u3 = this.a.u();
        this.a(i, t, u, u2, u3);
        if (this.j) {
            new l().a(this.b, new y.f.f.e.l(this, u3, this.a.c("y.layout.orthogonal.general.NodeSplitter.NODE_FACES"), this.b.b()));
        }
        this.b.a(u3, this.a.p().a(), y.f.f.b.o.a);
        this.a.a(u3);
        i.a(t);
        i.a(u);
        i.a(u2);
        o.a(this, 1, "Prof: -> Total running time of layout Phase: " + al);
        o.a(this, 1, "<<<------- Leaving Layout Phase");
    }
    
    private void a(final i i, final A a, final y.c.h h, final y.c.h h2) {
        final int a2 = a.a;
        final Integer n = new Integer(4 * this.a.h());
        final q d = i.d();
        final q d2 = i.d();
        this.d = this.a.u();
        this.c = this.a.u();
        final A t = i.t();
        final r g = this.b.g();
        final c c = this.a.c("y.layout.orthogonal.general.NodeSplitter.NODE_FACES");
        final x o = this.a.o();
        while (o.f()) {
            final q e = o.e();
            if (e.b() < 4) {
                final q d3 = i.d();
                a.a(d3, k.g);
                final d a3 = i.a(d, d3);
                h.a(a3, k.g);
                h2.a(a3, 4 - e.b());
                t.a(e, d3);
            }
            o.g();
            if (a2 != 0) {
                break;
            }
        }
        y.f.h.q q = this.b.c();
    Label_0469:
        while (true) {
            while (q.f()) {
                final p a4 = q.a();
                final q d4 = i.d();
                a.a(d4, k.g);
                final int j = a4.a().k();
                if (a2 != 0) {
                Label_0731:
                    while (true) {
                        while (j != 0) {
                            final p a5 = q.a();
                            final q q2 = (q)g.b(a5);
                            final e a6 = a5.a();
                            while (a6.f()) {
                                final d a7 = a6.a();
                                final p b = this.b.b(this.b.a(a7));
                                final d a8 = i.a(q2, (q)g.b(b));
                                h.a(a8, k.h);
                                this.c.a(a7, a8);
                                final boolean d5;
                                final boolean b2 = d5 = c.d(b);
                                if (a2 != 0) {
                                    continue Label_0476;
                                }
                                Label_0639: {
                                    if (b2) {
                                        h2.a(a8, k.g);
                                        if (a2 == 0) {
                                            break Label_0639;
                                        }
                                    }
                                    h2.a(a8, n);
                                }
                                final q q3 = (q)t.b(a7.c());
                                if (q3 != null) {
                                    final d a9 = i.a(q3, q2);
                                    h.a(a9, k.g);
                                    h2.a(a9, k.i);
                                    this.d.a(a7, a9);
                                }
                                a6.g();
                                if (a2 != 0) {
                                    break;
                                }
                            }
                            q.g();
                            if (a2 != 0) {
                                break;
                            }
                            break Label_0469;
                        }
                        break Label_0731;
                        q.f();
                        continue;
                    }
                    int n2 = 0;
                    final e l = d.l();
                    while (l.f()) {
                        n2 += h2.a(l.a());
                        l.g();
                        if (a2 != 0) {
                            return;
                        }
                        if (a2 != 0) {
                            break;
                        }
                    }
                    a.a(d, n2);
                    a.a(d2, -n2);
                    return;
                }
                if (j < 4 && this.b.d() != a4) {
                    final d a10 = i.a(d, d4);
                    h.a(a10, k.g);
                    h2.a(a10, 4 - a4.a().k());
                }
                if (a4.a().k() > 4 && this.b.d() != a4) {
                    final d a11 = i.a(d4, d2);
                    h.a(a11, k.g);
                    h2.a(a11, a4.a().k() - 4);
                }
                if (this.b.d() == a4) {
                    final d a12 = i.a(d4, d2);
                    h.a(a12, k.g);
                    h2.a(a12, a4.a().k() + 4);
                }
                g.a(a4, d4);
                q.g();
                if (a2 != 0) {
                    break;
                }
            }
            q = this.b.c();
            continue Label_0469;
        }
    }
    
    protected void a(final i i, final A a, final y.c.h h, final y.c.h h2, final y.c.h h3) {
        final int a2 = a.a;
        final al al = new al();
        this.f = 0;
        final y.c.h u = i.u();
        new y.f.f.e.e().a(i, null, h2, h, a, u, null);
        o.a(this, 3, "Prof: ---> Solving Network took " + al);
        al.e();
        o.a(this, 5, "Bends of edges: ");
        final e p5 = this.a.p();
        while (p5.f()) {
            final d a3 = p5.a();
            final StringBuffer sb = new StringBuffer();
            final int a4 = u.a(this.c.b(a3));
            a(sb, u.a(this.c.b(this.b.a(a3))), '>');
            a(sb, a4, '<');
            this.f += sb.length();
            h3.a(a3, sb.toString());
            if (a2 != 0) {
                return;
            }
            Label_0283: {
                if (a3.c().b() < 4) {
                    this.b.a(a3, u.a(this.d.b(a3)) + 1);
                    if (a2 == 0) {
                        break Label_0283;
                    }
                }
                this.b.a(a3, 1);
            }
            p5.g();
            if (a2 != 0) {
                break;
            }
        }
        this.f /= 2;
        o.a(this, 1, "Stat: Number of bends: " + this.f);
        o.a(this, 3, "Prof: ---> Parsing ILP solution took " + al);
    }
    
    private static void a(final StringBuffer sb, final double n, final char c) {
        final int a = y.f.f.e.a.a;
        final int n2 = (int)Math.floor(n + k.e);
        int i = 0;
        while (i < n2) {
            sb.append(c);
            ++i;
            if (a != 0) {
                break;
            }
        }
    }
    
    public void a(final boolean j) {
        this.j = j;
    }
    
    static {
        k.e = 0.001;
        g = new Integer(0);
        h = new Integer(1);
        i = new Integer(3);
    }
}
