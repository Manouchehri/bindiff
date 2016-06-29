package y.f.g;

import y.g.*;
import y.c.*;
import y.f.*;

class w
{
    private y a;
    private D b;
    private boolean c;
    private Object d;
    private final n e;
    
    w(final n e, final Object d, final y a, final boolean c, final c c2) {
        final boolean d2 = y.f.g.d.d;
        this.e = e;
        this.d = d;
        this.a = a;
        this.c = c;
        final A a2 = M.a();
        final x a3 = a.a();
        while (a3.f()) {
            a2.a(a3.e(), true);
            a3.g();
            if (d2) {
                return;
            }
            if (d2) {
                break;
            }
        }
        this.a(a2, c2);
    }
    
    private void a(final c c, final c c2) {
        final boolean d = y.f.g.d.d;
        this.b = new D();
        final f f = new f();
        final h b = M.b();
        final x a = this.a.a();
        while (true) {
            do {
                Label_0038: {
                    a.f();
                }
                boolean d2 = false;
                Label_0045:
                while (d2) {
                    final q e = a.e();
                    final e j = e.j();
                    if (!d) {
                        final e e2 = j;
                        while (e2.f()) {
                            final y.c.d a2 = e2.a();
                            d2 = b.d(a2);
                            if (d) {
                                continue Label_0045;
                            }
                            if (!d2) {
                                f.add(a2);
                                b.a(a2, true);
                            }
                            e2.g();
                            if (d) {
                                break;
                            }
                        }
                        this.b.add(new t(this.e, e, e, (byte)0));
                        a.g();
                        continue Label_0038;
                    }
                    final e e3 = j;
                    while (e3.f()) {
                        final y.c.d a3 = e3.a();
                        Label_0350: {
                            if ((c2 == null || c2.d(a3)) && c.d(a3.c()) && c.d(a3.d())) {
                                this.b.add(new t(this.e, a3, a3, (byte)1));
                                final C[] d3 = n.b(this.e).d((Object)a3);
                                int i = 0;
                                while (i < d3.length) {
                                    this.b.add(new t(this.e, d3[i], a3, (byte)3));
                                    ++i;
                                    if (d) {
                                        break Label_0350;
                                    }
                                    if (d) {
                                        break;
                                    }
                                }
                            }
                            e3.g();
                        }
                        if (d) {
                            break;
                        }
                    }
                    return;
                }
                break;
            } while (!d);
            f.a();
            continue;
        }
    }
    
    public void a(final double n, final double n2) {
        final boolean d = y.f.g.d.d;
        if (n == 0.0 && n2 == 0.0) {
            return;
        }
        final y.c.C m = this.b.m();
        while (m.f()) {
            ((t)m.d()).a(n, n2);
            m.g();
            if (d) {
                break;
            }
        }
    }
    
    public y.d.y a() {
        final boolean d = y.f.g.d.d;
        double min = Double.MAX_VALUE;
        double min2 = Double.MAX_VALUE;
        double max = -1.7976931348623157E308;
        double max2 = -1.7976931348623157E308;
        final y.c.C m = this.b.m();
        y.d.y h = null;
        while (m.f()) {
            h = ((t)m.d()).h();
            if (d) {
                return h;
            }
            final y.d.y y = h;
            min = Math.min(min, y.c);
            min2 = Math.min(min2, y.d);
            max = Math.max(max, y.c + y.a);
            max2 = Math.max(max2, y.d + y.b);
            m.g();
            if (d) {
                break;
            }
        }
        final y.d.y y2 = new y.d.y(min, min2, max - min, max2 - min2);
        return h;
    }
    
    public boolean b() {
        return this.c;
    }
    
    public D c() {
        return this.b;
    }
}
