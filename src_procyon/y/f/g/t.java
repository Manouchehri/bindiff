package y.f.g;

import y.c.*;
import y.f.*;
import y.d.*;

class t implements o
{
    Object a;
    Object b;
    byte c;
    private final n d;
    
    t(final n d, final Object a, final Object b, final byte c) {
        this.d = d;
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public boolean a() {
        return this.c == 2 || this.c == 3;
    }
    
    public void a(final double n, final double n2) {
        final boolean d = y.f.g.d.d;
        Label_0135: {
            if (this.c == 1) {
                final v j = n.b(this.d).j((y.c.d)this.a);
                final D d2 = new D();
                final u b = j.b();
                while (true) {
                    while (b.f()) {
                        final y.d.t a = b.a();
                        d2.add(new y.d.t(a.a + n, a.b + n2));
                        b.g();
                        if (!d) {
                            if (d) {
                                break;
                            }
                            continue;
                        }
                        else {
                            if (d) {
                                break Label_0135;
                            }
                            return;
                        }
                    }
                    n.b(this.d).b((y.c.d)this.a, d2);
                    continue;
                }
            }
        }
        if (this.c == 0) {
            final y.d.t o = n.b(this.d).o((q)this.a);
            n.b(this.d).b((q)this.a, new y.d.t(o.a + n, o.b + n2));
        }
    }
    
    public y h() {
        final boolean d = y.f.g.d.d;
        if (this.c == 1) {
            double min = Double.MAX_VALUE;
            double min2 = Double.MAX_VALUE;
            double max = -1.7976931348623157E308;
            double max2 = -1.7976931348623157E308;
            final u b = n.b(this.d).l((y.c.d)this.a).b();
            while (b.f()) {
                final y.d.t a = b.a();
                min = Math.min(min, a.a);
                min2 = Math.min(min2, a.b);
                max = Math.max(max, a.a);
                max2 = Math.max(max2, a.b);
                b.g();
                if (d) {
                    break;
                }
            }
            return new y(min, min2, max - min, max2 - min2);
        }
        if (this.c == 3) {
            final y.c.d d2 = (y.c.d)this.b;
            final C c = (C)this.a;
            return c.getLabelModel().a(c.getOrientedBox().d(), n.b(this.d).b((Object)d2), n.b(this.d).a((Object)d2.c()), n.b(this.d).a((Object)d2.d()), c.getModelParameter()).h();
        }
        if (this.c == 2) {
            final q q = (q)this.b;
            final aj aj = (aj)this.a;
            return aj.a().a(aj.getOrientedBox().d(), n.b(this.d).a((Object)q), aj.getModelParameter()).h();
        }
        final am a2 = n.b(this.d).a(this.a);
        return new y(a2.getX(), a2.getY(), a2.getWidth(), a2.getHeight());
    }
    
    public boolean a(final y y) {
        final boolean d = y.f.g.d.d;
        if (this.c == 1) {
            final s j = n.b(this.d).l((y.c.d)this.a).j();
            boolean a = false;
            while (j.f()) {
                a = j.a().a(y);
                if (d) {
                    return a;
                }
                if (a) {
                    return true;
                }
                j.g();
                if (d) {
                    break;
                }
            }
            return a;
        }
        return y.a(y, this.h());
    }
}
