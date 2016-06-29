package y.f.f.e;

import y.f.*;
import y.f.f.b.*;
import y.g.*;
import y.f.f.c.*;
import y.d.*;
import y.c.*;

public class n implements p
{
    private h b;
    private X c;
    private short d;
    private short e;
    private int f;
    public int a;
    private boolean g;
    private m h;
    
    public n() {
        this.d = 0;
        this.e = 0;
        this.f = 3;
        this.g = false;
    }
    
    public void a(final h b) {
        this.b = b;
        this.c = (X)this.b.a();
    }
    
    public void a(final int a) {
        this.a = a;
    }
    
    public void a(final m h) {
        this.h = h;
    }
    
    public void a(final short d) {
        this.d = d;
    }
    
    public void b(final short e) {
        this.e = e;
    }
    
    public void b(final int f) {
        this.f = f;
    }
    
    public void a() {
        final int i = y.f.f.e.a.a;
        o.a(this, "------->>> Entering Compaction Phase");
        final al al = new al();
        final d[] n = this.c.n();
        int j = 0;
        while (true) {
            while (j < n.length) {
                final d d = n[j];
                final h b = this.b;
                if (i != 0) {
                    final e p = b.a().p();
                    while (true) {
                        while (p.f()) {
                            this.b.b(p.a(), 1);
                            final n n2 = this;
                            if (i != 0) {
                                final c c = n2.c.c("y.layout.orthogonal.general.NodeSplitter.NODE_FACES");
                                Label_0375: {
                                    if (this.d == 1) {
                                        final y.f.h.q c2 = this.b.c();
                                        do {
                                            Label_0165: {
                                                c2.f();
                                            }
                                            int k = 0;
                                            Label_0172:
                                            while (k != 0) {
                                                final y.f.h.p p2 = (y.f.h.p)c2.d();
                                                if (i == 0) {
                                                    if (c.d(p2)) {
                                                        final q[] array = new q[4];
                                                        final e a = p2.a();
                                                        while (a.f()) {
                                                            final d a2 = a.a();
                                                            k = this.b.d(a2);
                                                            if (i != 0) {
                                                                continue Label_0172;
                                                            }
                                                            if (k == 1) {
                                                                array[this.b.h(a2).g()] = a2.c();
                                                            }
                                                            a.g();
                                                            if (i != 0) {
                                                                break;
                                                            }
                                                        }
                                                        this.b.a(new y.f.f.b.n(array[1], array[0], 2, 1, y.f.f.b.o.b));
                                                        this.b.a(new y.f.f.b.n(array[2], array[1], 2, 1, y.f.f.b.o.c));
                                                    }
                                                    c2.g();
                                                    continue Label_0165;
                                                }
                                                break Label_0375;
                                            }
                                            break;
                                        } while (i == 0);
                                    }
                                    this.h.h = (int)al.d();
                                    al.e();
                                }
                                final r r = new r();
                                r.a(this.f);
                                Label_0516: {
                                    Label_0482: {
                                        switch (this.e) {
                                            case 0: {
                                                r.a(new k());
                                                r.a(new y.f.f.c.m());
                                                if (i != 0) {
                                                    break Label_0482;
                                                }
                                                break Label_0516;
                                            }
                                            case 1: {
                                                r.a(new y.f.f.c.h());
                                                r.a(new y.f.f.c.m());
                                                if (i != 0) {
                                                    break Label_0482;
                                                }
                                                break Label_0516;
                                            }
                                            case 2: {
                                                r.a(new y.f.f.c.n());
                                                r.a(new y.f.f.c.m());
                                                if (i != 0) {
                                                    break;
                                                }
                                                break Label_0516;
                                            }
                                        }
                                    }
                                    o.a((Object)"Unknown Compactor !");
                                }
                                final A t = this.c.t();
                                r.a(this.b);
                                r.a(this.g);
                                r.a(t);
                                this.h.i = (int)al.d();
                                al.e();
                                final int a3 = this.a;
                                final int a4 = this.a;
                                final x o = this.c.o();
                                while (o.f()) {
                                    final q e = o.e();
                                    final t t2 = (t)t.b(e);
                                    final t t3 = new t(t2.a() * a3, t2.b() * a4);
                                    t.a(e, t3);
                                    this.c.a(e, t3.a(), t3.b());
                                    o.g();
                                    if (i != 0) {
                                        return;
                                    }
                                    if (i != 0) {
                                        break;
                                    }
                                }
                                this.c.a(t);
                                this.h.j = r.a();
                                this.h.k = r.b();
                                this.h.l = r.c();
                                this.h.m = r.d();
                                y.g.o.a(this, "Prof: -> Total running time of compaction Phase: " + al);
                                y.g.o.a(this, "<<<------- Leaving Compaction Phase");
                                return;
                            }
                            this.b.b(p.a(), 1.0);
                            p.g();
                            if (i != 0) {
                                break;
                            }
                        }
                        final n n2 = this;
                        continue;
                    }
                }
                if (!b.c(d)) {
                    this.b.n(d);
                }
                ++j;
                if (i != 0) {
                    break;
                }
            }
            final h b2 = this.b;
            continue;
        }
    }
}
