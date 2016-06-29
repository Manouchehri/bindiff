package y.h;

import java.awt.*;
import java.awt.geom.*;
import y.d.*;

public class gq implements eW, eX, eZ, fa, fc
{
    private q a;
    private t b;
    
    public gq() {
        this.a = new q(10.0, 10.0);
        this.b = new t(0.5, 0.5);
    }
    
    public q a() {
        return this.a;
    }
    
    public t b() {
        return this.b;
    }
    
    public boolean a(final eU eu, final double n, final double n2) {
        return eu.k().a(n, n2);
    }
    
    public boolean a(final eU eu, final double n, final double n2, final double n3, final double n4, final Point2D point2D) {
        final boolean z = fj.z;
        if (eu.a(n, n2)) {
            if (eu.a(n3, n4)) {
                point2D.setLocation(n3, n4);
                return false;
            }
        }
        else if (!eu.a(n3, n4)) {
            point2D.setLocation(n, n2);
            return false;
        }
        double sqrt = Math.sqrt((n3 - n) * (n3 - n) + (n4 - n2) * (n4 - n2));
        if (Double.isNaN(sqrt) || Double.isInfinite(sqrt)) {
            point2D.setLocation(n, n2);
            return true;
        }
        double n5 = (n3 - n) / 2.0;
        double n6 = (n4 - n2) / 2.0;
        double n7 = n + n5;
        double n8 = n2 + n6;
        boolean a = false;
        while (sqrt > 0.1) {
            sqrt /= 2.0;
            n5 /= 2.0;
            n6 /= 2.0;
            a = eu.a(n7, n8);
            if (z) {
                return a;
            }
            if (a) {
                n7 += n5;
                n8 += n6;
                if (!z) {
                    continue;
                }
            }
            n7 -= n5;
            n8 -= n6;
            if (z) {
                break;
            }
        }
        point2D.setLocation(n7, n8);
        return a;
    }
    
    public void a(final eU eu, final Graphics2D graphics2D) {
        final Stroke stroke = graphics2D.getStroke();
        final Paint paint = graphics2D.getPaint();
        final Color color = graphics2D.getColor();
        final fj b = eu.b();
        final Rectangle2D c = eU.c(eu);
        if (this.b(b, eu, graphics2D)) {
            graphics2D.fill(c);
        }
        if (this.c(b, eu, graphics2D)) {
            graphics2D.draw(c);
        }
        this.a(b, eu, graphics2D);
        graphics2D.setColor(color);
        graphics2D.setPaint(paint);
        graphics2D.setStroke(stroke);
    }
    
    protected void a(final fj fj, final eU eu, final Graphics2D graphics2D) {
        if (eU.a(eu, graphics2D)) {
            final y k = eu.k();
            final Rectangle2D.Double i = hC.a().k;
            i.setFrame(k.c() - 2.0, k.d() - 2.0, k.a() + 4.0, k.b() + 4.0);
            final Color c = this.c(fj, eu, true);
            graphics2D.setColor((c == null) ? Color.BLACK : c);
            graphics2D.setStroke(dr.a);
            graphics2D.draw(i);
        }
    }
    
    protected boolean b(final fj fj, final eU eu, final Graphics2D graphics2D) {
        final Paint a = this.a(fj, eu, eU.a(eu, graphics2D));
        if (a != null) {
            graphics2D.setPaint(a);
            return true;
        }
        return false;
    }
    
    protected Paint a(final fj fj, final eU eu, final boolean b) {
        return this.a(fj, b);
    }
    
    protected Paint a(final fj fj, final boolean b) {
        final Color fillColor = fj.getFillColor();
        if (fj.isSelected() && fillColor != null) {
            return fillColor.darker();
        }
        return fillColor;
    }
    
    protected boolean c(final fj fj, final eU eu, final Graphics2D graphics2D) {
        final boolean a = eU.a(eu, graphics2D);
        final Color c = this.c(fj, eu, a);
        if (c != null) {
            final Stroke b = this.b(fj, eu, a);
            if (b != null) {
                graphics2D.setColor(c);
                graphics2D.setStroke(b);
                return true;
            }
        }
        return false;
    }
    
    protected Stroke b(final fj fj, final eU eu, final boolean b) {
        return this.b(fj, b);
    }
    
    protected Stroke b(final fj fj, final boolean b) {
        return fj.getLineType();
    }
    
    protected Color c(final fj fj, final eU eu, final boolean b) {
        return this.c(fj, b);
    }
    
    protected Color c(final fj fj, final boolean b) {
        final Color lineColor = fj.getLineColor();
        return (lineColor == null) ? Color.BLACK : lineColor;
    }
    
    public y a(final eU eu) {
        final t h = eu.h();
        final q a = this.a();
        final double a2 = a.a();
        final double b = a.b();
        final t b2 = this.b();
        return new y(h.a() - a2 * b2.a(), h.b() - b * b2.b(), a2, b);
    }
    
    public void a(final eU eu, final Rectangle2D rectangle2D) {
        final y k = eu.k();
        if (rectangle2D.getWidth() <= 0.0) {
            rectangle2D.setFrame(k.c(), k.d(), k.a(), k.b());
            if (!fj.z) {
                return;
            }
        }
        rectangle2D.add(k.c(), k.d());
        rectangle2D.add(k.c() + k.a(), k.d() + k.b());
    }
}
