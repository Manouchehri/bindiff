package y.f.e;

import y.f.*;
import y.f.b.*;
import y.g.*;
import y.a.*;
import y.c.*;

class y
{
    private X a;
    private r b;
    private q[] c;
    private final y.f.e.q d;
    
    public y(final y.f.e.q d, final X a) {
        this.d = d;
        this.b = null;
        this.c = null;
        this.a = a;
    }
    
    public void a(final A a) {
        final boolean b = i.b;
        final y.c.y y = new y.c.y();
        final y.c.y y2 = new y.c.y();
        final A a2 = M.a();
        final A a3 = M.a();
        final A a4 = M.a();
        final c c = new c(this.a);
        final x o = this.a.o();
        while (o.f()) {
            final q e = o.e();
            a3.a(e, -1);
            if (a == null || a.d(e)) {
                y.add(e);
            }
            a2.a(e, c.d(e));
            a4.a(e, c.a(e));
            if (c.d(e) && c.a(e) == c.b()) {
                y2.add(e);
            }
            o.g();
            if (b) {
                y.c.i.g = !y.c.i.g;
                break;
            }
        }
        final f f = new f();
        final x a5 = y2.a();
    Label_0344:
        while (true) {
        Label_0534_Outer:
            while (a5.f()) {
                a5.e();
            Label_0231:
                while (true) {
                    q d = null;
                    final q q = d;
                    final c c2 = c;
                    if (!b) {
                        final e a6 = c2.f(q).a();
                        while (a6.f()) {
                            final d a7 = a6.a();
                            d = a7.d();
                            if (b) {
                                continue Label_0231;
                            }
                            if (d != q) {
                                f.add(this.a.a(a7.c(), q));
                            }
                            a6.g();
                            if (b) {
                                break;
                            }
                        }
                        break;
                    }
                    break Label_0344;
                }
                a5.g();
                if (b) {
                    break;
                }
                continue Label_0534_Outer;
                c c2 = null;
                final c c3 = c2;
                final x a8 = y2.a();
                while (a8.f()) {
                    a8.e();
                    Label_0369:
                    while (true) {
                        q c4 = null;
                        final q q2 = c4;
                        final e a9 = c3.g(q2).a();
                        while (a9.f()) {
                            final d a10 = a9.a();
                            c4 = a10.c();
                            if (b) {
                                continue Label_0369;
                            }
                            if (c4 != q2) {
                                f.add(this.a.a(q2, a10.d()));
                            }
                            a9.g();
                            if (b) {
                                break;
                            }
                        }
                        break;
                    }
                    a8.g();
                    if (b) {
                        break;
                    }
                }
                final I i = new I(this.a);
                final x a11 = y2.a();
                while (true) {
                    while (a11.f()) {
                        i.a(c3.c(a11.e()));
                        a11.g();
                        if (b) {
                            final int a12 = j.a(this.a, a3, y.f.e.q.a(this.d), 0, Integer.MAX_VALUE, false);
                            i.f();
                            final e a13 = f.a();
                            while (true) {
                                while (a13.f()) {
                                    this.a.a(a13.a());
                                    a13.g();
                                    if (b) {
                                        int j = 0;
                                        while (true) {
                                            while (j < this.c.length) {
                                                this.c[j] = this.a.d();
                                                this.a.b(this.c[j], 1.0, 1.0);
                                                a2.a(this.c[j], true);
                                                a.a(this.c[j], true);
                                                ++j;
                                                if (b) {
                                                    final x a14 = y.a();
                                                    while (a14.f()) {
                                                        final q e2 = a14.e();
                                                        final int a15 = a3.a(e2);
                                                        if (b) {
                                                            return;
                                                        }
                                                        if (a15 >= 0) {
                                                            a4.a(e2, this.c[a15]);
                                                        }
                                                        a14.g();
                                                        if (b) {
                                                            break;
                                                        }
                                                    }
                                                    this.b.a(y.f.b.f.c, a4);
                                                    this.b.a(y.f.b.f.b, new s(this));
                                                    this.b.a(y.f.e.q.n, a);
                                                    return;
                                                }
                                                if (b) {
                                                    break;
                                                }
                                            }
                                            this.b.a(y.f.b.f.d, a2);
                                            continue;
                                        }
                                    }
                                    if (b) {
                                        break;
                                    }
                                }
                                this.c = new q[a12];
                                this.b = new r(this.a);
                                continue;
                            }
                        }
                        if (b) {
                            break;
                        }
                    }
                    c3.c();
                    i.d();
                    continue;
                }
            }
            c.c();
            final c c5 = new c(this.a);
            continue Label_0344;
        }
    }
    
    public void a() {
        final boolean b = i.b;
        if (this.c != null) {
            int i = 0;
            while (i < this.c.length) {
                this.a.a(this.c[i]);
                ++i;
                if (b) {
                    return;
                }
                if (b) {
                    break;
                }
            }
        }
        if (this.b != null) {
            this.b.a();
        }
    }
}
