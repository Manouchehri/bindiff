package y.f.h;

import y.c.*;

public class y
{
    private f a;
    private h b;
    private i c;
    
    public y() {
        this.a = new f();
    }
    
    public void a(final i c) {
        final boolean d = N.d;
        this.c = c;
        this.b = this.c.u();
        final A t = this.c.t();
        final x o = this.c.o();
    Label_0236_Outer:
        while (o.f()) {
            final q e = o.e();
            if (!d) {
                e e2 = e.j();
                while (true) {
                    while (e2.f()) {
                        final d a = e2.a();
                        final q a2 = a.a(e);
                        final d d3;
                        final d d2 = d3 = (d)t.b(a2);
                        if (!d) {
                            Label_0217: {
                                if (d3 != a) {
                                    if (d2 == null) {
                                        t.a(a2, a);
                                        if (!d) {
                                            break Label_0217;
                                        }
                                    }
                                    if (this.b.b(d2) == null) {
                                        this.b.a(d2, new f());
                                    }
                                    ((f)this.b.b(d2)).add(a);
                                    this.a.c(a);
                                    this.c.d(a);
                                }
                            }
                            e2.g();
                            if (d) {
                                break;
                            }
                            continue Label_0236_Outer;
                        }
                        else {
                            while (true) {
                                t.a(d3.a(e), null);
                                e2.g();
                                if (!d) {
                                    if (!d) {
                                        if (e2.f()) {
                                            e2.a();
                                            continue Label_0236_Outer;
                                        }
                                    }
                                    o.g();
                                }
                                break;
                            }
                            if (d) {
                                break Label_0236_Outer;
                            }
                            continue Label_0236_Outer;
                        }
                    }
                    e2 = e.j();
                    continue;
                }
            }
            return;
        }
        this.c.a(t);
    }
    
    public void a(final D d, final f f) {
        final boolean d2 = N.d;
        final e a = this.a.a();
        while (a.f()) {
            f.add(a.a());
            a.g();
            if (d2) {
                break;
            }
        }
    }
    
    public void a() {
        this.c.a(this.b);
    }
}
