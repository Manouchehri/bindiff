package y.h;

import y.c.*;
import java.awt.*;
import java.awt.geom.*;
import y.d.*;
import y.f.*;

class dG implements az
{
    private final BasicStroke a;
    private final BasicStroke b;
    private boolean c;
    private boolean d;
    private Rectangle e;
    private Q f;
    private boolean g;
    private Object h;
    private final dB i;
    
    private dG(final dB i) {
        this.i = i;
        this.b = new BasicStroke(3.0f, 2, 0);
        this.a = new BasicStroke(1.0f, 2, 0);
        this.c = true;
        this.d = false;
        this.d();
    }
    
    public Rectangle getBounds() {
        if (!this.a()) {
            return this.e;
        }
        if (this.i.e instanceof eR) {
            return this.a(this.a(dB.a(this.i)));
        }
        if (this.i.e instanceof aA) {
            return this.a(this.a(dB.b(this.i)));
        }
        return new Rectangle(0, 0, -1, -1);
    }
    
    private Rectangle a(final n n) {
        final y h = n.h();
        return new Rectangle((int)Math.floor(h.c()), (int)Math.floor(h.d()), (int)Math.ceil(h.a()), (int)Math.ceil(h.b()));
    }
    
    public void a(final Graphics2D graphics2D) {
        if (this.a()) {
            this.c(graphics2D);
            if (!fj.z) {
                return;
            }
        }
        this.b(graphics2D);
    }
    
    private void b(final Graphics2D graphics2D) {
        final boolean z = fj.z;
        final Stroke stroke = graphics2D.getStroke();
        final Color color = graphics2D.getColor();
        graphics2D.setColor(dB.h());
        Q q2 = null;
        Label_0110: {
            if (dB.c(this.i) != null) {
                final C m = dB.c(this.i).m();
                while (m.f()) {
                    final Q q = q2 = (Q)m.d();
                    if (z) {
                        break Label_0110;
                    }
                    if (!q2.equals(this.f)) {
                        this.a(graphics2D, q, this.a);
                    }
                    m.g();
                    if (z) {
                        break;
                    }
                }
            }
            final Q f = this.f;
        }
        if (q2 != null) {
            this.a(graphics2D, this.f, this.b);
        }
        graphics2D.setStroke(stroke);
        graphics2D.setColor(color);
    }
    
    private void a(final Graphics2D graphics2D, final Q q, final Stroke stroke) {
        final boolean z = fj.z;
        if (q == null) {
            return;
        }
        graphics2D.setStroke(stroke);
        final Line2D.Double l = hC.a().l;
        t[] array = null;
        Label_0097: {
            if ((this.i.e instanceof eR && this.b()) || (this.i.e instanceof aA && this.c())) {
                array = n.a(new n(q.h()));
                if (!z) {
                    break Label_0097;
                }
            }
            array = n.a(q.d());
        }
        int i = 0;
        while (i < array.length) {
            final int n = (i == 0) ? (array.length - 1) : (i - 1);
            l.setLine(array[i].a(), array[i].b(), array[n].a(), array[n].b());
            graphics2D.draw(l);
            ++i;
            if (z) {
                break;
            }
        }
    }
    
    private void c(final Graphics2D graphics2D) {
        if (this.i.e instanceof aA) {
            this.a(graphics2D, this.a(dB.b(this.i)));
            if (!fj.z) {
                return;
            }
        }
        if (this.i.e instanceof eR) {
            this.a(graphics2D, this.a(dB.a(this.i)));
        }
    }
    
    private n a(final aA aa) {
        final aB realizer = aa.getRealizer();
        return dB.d(this.i).a(aa.getOrientedBox().d(), realizer, realizer.getSourceRealizer(), realizer.getTargetRealizer(), this.h);
    }
    
    private n a(final eR er) {
        return dB.e(this.i).a(er.getOrientedBox().d(), er.g(), this.h);
    }
    
    private void a(final Graphics2D graphics2D, final n n) {
        final boolean z = fj.z;
        final Color color = graphics2D.getColor();
        final Stroke stroke = graphics2D.getStroke();
        graphics2D.setColor(dB.h());
        graphics2D.setStroke(new BasicStroke(3.0f, 2, 0));
        final Line2D.Double l = hC.a().l;
        t[] array = null;
        Label_0117: {
            if ((this.i.e instanceof eR && this.b()) || (this.i.e instanceof aA && this.c())) {
                array = n.a(new n(n.h()));
                if (!z) {
                    break Label_0117;
                }
            }
            array = n.a(n);
        }
        int i = 0;
        while (i < array.length) {
            final int n2 = (i == 0) ? (array.length - 1) : (i - 1);
            l.setLine(array[i].a(), array[i].b(), array[n2].a(), array[n2].b());
            graphics2D.draw(l);
            ++i;
            if (z) {
                break;
            }
        }
        graphics2D.setColor(color);
        graphics2D.setStroke(stroke);
    }
    
    private void a(final Object h) {
        this.h = h;
    }
    
    private void a(final Q f) {
        this.f = f;
    }
    
    private void d() {
        final boolean z = fj.z;
        if (dB.c(this.i) == null || dB.c(this.i).isEmpty()) {
            this.e = null;
            if (!z) {
                return;
            }
        }
        double min = Double.MAX_VALUE;
        double min2 = Double.MAX_VALUE;
        double max = -1.7976931348623157E308;
        double max2 = -1.7976931348623157E308;
        final C m = dB.c(this.i).m();
        while (m.f()) {
            final y h = ((Q)m.d()).h();
            min = Math.min(min, h.c());
            min2 = Math.min(min2, h.d());
            max = Math.max(max, h.c() + h.a());
            max2 = Math.max(max2, h.d() + h.b());
            m.g();
            if (z) {
                return;
            }
            if (z) {
                break;
            }
        }
        final double n = this.b.getLineWidth();
        this.e = new Rectangle((int)Math.floor(min - n), (int)Math.floor(min2 - n), (int)Math.ceil(max - min + 2.0 * n), (int)Math.ceil(max2 - min2 + 2.0 * n));
    }
    
    public boolean a() {
        return this.g;
    }
    
    public void a(final boolean g) {
        this.g = g;
    }
    
    public boolean b() {
        return this.c;
    }
    
    public boolean c() {
        return this.d;
    }
    
    dG(final dB db, final dC dc) {
        this(db);
    }
    
    static void a(final dG dg, final Q q) {
        dg.a(q);
    }
    
    static void a(final dG dg, final Object o) {
        dg.a(o);
    }
}
