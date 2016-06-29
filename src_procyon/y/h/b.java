package y.h;

import java.awt.*;

public abstract class b implements bo
{
    private Color a;
    private Stroke b;
    private Paint c;
    
    public void a(final fj fj, final Graphics2D graphics2D) {
        this.b(fj, graphics2D, false);
    }
    
    protected void a(final Graphics2D graphics2D) {
        this.a = graphics2D.getColor();
        this.b = graphics2D.getStroke();
        this.c = graphics2D.getPaint();
    }
    
    protected void b(final fj fj, final Graphics2D graphics2D) {
        if (g(fj, graphics2D)) {
            fj.paintHotSpots(graphics2D);
        }
    }
    
    protected void c(final fj fj, final Graphics2D graphics2D) {
        if (fj.labelCount() > 0) {
            fj.paintText(graphics2D);
        }
    }
    
    protected void d(final fj fj, final Graphics2D graphics2D) {
        fj.paintPorts(graphics2D);
    }
    
    protected void b(final Graphics2D graphics2D) {
        graphics2D.setColor(this.a);
        graphics2D.setStroke(this.b);
        graphics2D.setPaint(this.c);
    }
    
    protected Color a(final fj fj, final boolean b) {
        return fj.getLineColor();
    }
    
    protected Color a(final Color color) {
        return new Color(Math.max((int)(color.getRed() * 0.7), 0), Math.max((int)(color.getGreen() * 0.7), 0), Math.max((int)(color.getBlue() * 0.7), 0), color.getAlpha());
    }
    
    protected Color b(final fj fj, final boolean b) {
        final Color fillColor = fj.getFillColor();
        if (fillColor != null) {
            return b ? this.a(fillColor) : fillColor;
        }
        return null;
    }
    
    protected Paint c(final fj fj, final boolean b) {
        final Color b2 = this.b(fj, b);
        if (b2 == null) {
            return null;
        }
        final Color d = this.d(fj, b);
        if (d != null) {
            return new GradientPaint((float)(fj.getX() + fj.getWidth() * 0.33), (float)fj.getY(), b2, (float)(fj.getX() + fj.getWidth()), (float)fj.getY(), d, true);
        }
        return b2;
    }
    
    protected Color d(final fj fj, final boolean b) {
        final Color fillColor2 = fj.getFillColor2();
        if (fillColor2 != null) {
            return b ? this.a(fillColor2) : fillColor2;
        }
        return null;
    }
    
    protected abstract void a(final fj p0, final Graphics2D p1, final boolean p2);
    
    public void e(final fj fj, final Graphics2D graphics2D) {
        this.b(fj, graphics2D, true);
    }
    
    private void b(final fj fj, final Graphics2D graphics2D, final boolean b) {
        if (!fj.isVisible()) {
            return;
        }
        this.a(graphics2D);
        try {
            if (!b) {
                this.b(fj, graphics2D);
            }
            this.a(fj, graphics2D, b);
        }
        finally {
            this.b(graphics2D);
        }
        if (b(graphics2D, b)) {
            this.d(fj, graphics2D);
        }
        if (a(graphics2D, b)) {
            this.c(fj, graphics2D);
        }
    }
    
    Paint f(final fj fj, final Graphics2D graphics2D) {
        final boolean g = g(fj, graphics2D);
        return c(graphics2D) ? this.c(fj, g) : this.b(fj, g);
    }
    
    static boolean c(final Graphics2D graphics2D) {
        return hk.c(graphics2D);
    }
    
    static boolean g(final fj fj, final Graphics2D graphics2D) {
        return fj.b(fj, graphics2D);
    }
    
    static boolean a(final Graphics2D graphics2D, final boolean b) {
        return fj.c(graphics2D, b);
    }
    
    static boolean b(final Graphics2D graphics2D, final boolean b) {
        return fj.b(graphics2D, b);
    }
}
