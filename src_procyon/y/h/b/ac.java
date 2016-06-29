package y.h.b;

import java.awt.*;

class ac extends ab
{
    private double e;
    private boolean f;
    private Color g;
    private Stroke h;
    
    ac() {
        this.g = new Color(0, 222, 0, 192);
        this.h = new BasicStroke(2.0f);
    }
    
    public void a(final Graphics2D graphics2D) {
        graphics2D.setColor(this.g);
        graphics2D.setStroke(this.h);
        final int n = (int)this.a;
        final int n2 = (int)this.b;
        final int n3 = (int)this.c;
        final int n4 = (int)this.d;
        final int n5 = (int)this.a();
        graphics2D.drawRect(n, n2, n3, n4);
        if (this.b()) {
            graphics2D.drawLine(n + n5, n2, n + n5, n2 + n4);
            if (y.h.b.a.H == 0) {
                return;
            }
        }
        graphics2D.drawLine(n, n2 + n5, n + n3, n2 + n5);
    }
    
    public double a() {
        return this.e;
    }
    
    public void a(final double e) {
        this.e = e;
    }
    
    public boolean b() {
        return this.f;
    }
    
    public void a(final boolean f) {
        this.f = f;
    }
}
