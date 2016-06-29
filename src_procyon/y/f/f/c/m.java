package y.f.f.c;

import y.f.h.*;
import y.f.f.b.*;
import y.f.f.d.*;
import y.c.*;

public class m implements f
{
    private h a;
    private p b;
    private p c;
    
    public void a(final h a, final p b, final p c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.a();
    }
    
    public void a() {
        final int a = g.a;
        final q c = this.a.c();
        while (c.f()) {
            this.b(this.a(c.a()));
            c.g();
            if (a != 0) {
                break;
            }
        }
    }
    
    private void b(final D d) {
        final int a = g.a;
        int n = d.size();
        int i = 0;
        while (i < n) {
            if (this.a(d)) {
                i = 0;
                n = d.size();
                if (a == 0) {
                    continue;
                }
            }
            d.add(d.g());
            ++i;
            if (a != 0) {
                break;
            }
        }
    }
    
    private D a(final y.f.h.p p) {
        final int a = g.a;
        final D d = new D();
        final e a2 = p.a();
        while (a2.f()) {
            final d a3 = a2.a();
            Label_0350: {
                if (this.a.d(a3) != 2) {
                    p p2 = null;
                    p p3 = null;
                    Label_0110: {
                        if (this.a.h(a3) == o.a || this.a.h(a3) == o.c) {
                            p2 = this.c;
                            p3 = this.b;
                            if (a == 0) {
                                break Label_0110;
                            }
                        }
                        p2 = this.b;
                        p3 = this.c;
                    }
                    final g a4 = p3.a(a3);
                    final y.c.q c = a3.c();
                    final y.f.f.d.p p4 = new y.f.f.d.p(a4);
                    final y.f.f.d.p p5 = new y.f.f.d.p(p2.a(c));
                    Label_0268: {
                        switch (this.a.d(a3)) {
                            case 1: {
                                d.add(new b(p5, p4, 0, this.a.h(a3), 2));
                                if (a != 0) {
                                    break Label_0268;
                                }
                                break Label_0350;
                            }
                            case 3: {
                                d.add(new b(p5, p4, 1, this.a.h(a3), 2));
                                if (a != 0) {
                                    break Label_0268;
                                }
                                break Label_0350;
                            }
                            case 4: {
                                d.add(new b(p4, p5, 1, this.a.h(a3).b(), 2));
                                d.add(new b(p5, p4, 1, this.a.h(a3), 2));
                                if (a != 0) {
                                    break;
                                }
                                break Label_0350;
                            }
                        }
                    }
                    System.err.println("Impossible Angle !");
                }
            }
            a2.g();
            if (a != 0) {
                break;
            }
        }
        return d;
    }
    
    public boolean a(final D d) {
        final int a = g.a;
        if (d.size() < 4) {
            return false;
        }
        final y.c.p l = d.l();
        final b b = (b)l.c();
        final y.c.p b2 = l.b();
        final b b3 = (b)b2.c();
        final y.c.p b4 = b2.b();
        final b b5 = (b)b4.c();
        final b b6 = (b)b4.b().c();
        if (b6.b() == 1 && b5.b() == 0 && b3.b() == 0) {
            d.j();
            d.j();
            d.j();
            d.j();
            d.add(new b(b6.d(), b3.e(), 0, b3.c(), 2));
            d.add(b);
            final y.f.f.d.p d2 = b6.d();
            final y.f.f.d.p e = b.e();
            if (b6.c().a(o.d)) {
                y.f.f.d.p.a(this.b, d2, e, 1);
                if (a == 0) {
                    return true;
                }
            }
            if (b6.c().a(o.b)) {
                y.f.f.d.p.a(this.b, e, d2, 1);
                if (a == 0) {
                    return true;
                }
            }
            if (b6.c().a(o.c)) {
                y.f.f.d.p.a(this.c, e, d2, 1);
                if (a == 0) {
                    return true;
                }
            }
            if (b6.c().a(o.a)) {
                y.f.f.d.p.a(this.c, d2, e, 1);
                if (a == 0) {
                    return true;
                }
            }
            y.g.o.a((Object)"Consistency Error in rect decomp.");
            return true;
        }
        return false;
    }
}
