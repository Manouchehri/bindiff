package y.h;

import y.d.*;
import java.awt.*;
import java.awt.geom.*;

public abstract class a implements hd
{
    final BasicStroke a;
    final BasicStroke b;
    boolean c;
    
    public a() {
        this.a = a(1);
        this.b = a(3);
    }
    
    public boolean a() {
        return this.c;
    }
    
    public void a(final boolean c) {
        this.c = c;
    }
    
    public void a(final gZ gz, final Graphics2D graphics2D) {
        final boolean z = fj.z;
        if (!gz.w) {
            return;
        }
        final n contentBox = gz.getContentBox();
        if (contentBox.i() == -1.0) {
            final double f = contentBox.f();
            gz.paintImpl(graphics2D, contentBox.b(), contentBox.c() - f, contentBox.e(), f);
            if (!z) {
                return;
            }
        }
        final Graphics2D graphics2D2 = (Graphics2D)graphics2D.create();
        final double e = contentBox.e();
        final double f2 = contentBox.f();
        final double g = contentBox.g();
        final double i = contentBox.i();
        Label_0198: {
            if (this.a() && i > 0.0) {
                graphics2D2.transform(new AffineTransform(i, -g, g, i, contentBox.b() - i * e, contentBox.c() + g * e));
                if (!z) {
                    break Label_0198;
                }
            }
            graphics2D2.transform(new AffineTransform(-i, g, -g, -i, contentBox.b() + g * f2, contentBox.c() + i * f2));
        }
        gz.paintImpl(graphics2D2, 0.0, 0.0, e, f2);
        graphics2D2.dispose();
    }
    
    public void a(final gZ gz, final Graphics2D graphics2D, final double n, final double n2, final double n3, final double n4) {
        final Color color = graphics2D.getColor();
        final Paint paint = graphics2D.getPaint();
        final Stroke stroke = graphics2D.getStroke();
        if (this.b(gz, graphics2D)) {
            final Rectangle2D.Double k = hC.a().k;
            k.setFrame(n, n2, n3, n4);
            graphics2D.fill(k);
        }
        if (this.c(gz, graphics2D)) {
            final Rectangle2D.Double i = hC.a().k;
            i.setFrame(n, n2, n3, n4);
            graphics2D.draw(i);
        }
        this.a_(gz, graphics2D, n, n2, n3, n4);
        graphics2D.setStroke(stroke);
        graphics2D.setPaint(paint);
        graphics2D.setColor(color);
    }
    
    protected void a_(final gZ gz, final Graphics2D graphics2D, final double n, final double n2, final double n3, final double n4) {
        if (d(gz, graphics2D)) {
            final Rectangle2D.Double k = hC.a().k;
            k.setFrame(n - 2.0, n2 - 2.0, n3 + 4.0, n4 + 4.0);
            graphics2D.setColor(Color.BLACK);
            graphics2D.setStroke(this.b);
            graphics2D.draw(k);
            graphics2D.setStroke(this.a);
            graphics2D.setColor(Color.WHITE);
            graphics2D.draw(k);
        }
    }
    
    protected boolean b(final gZ gz, final Graphics2D graphics2D) {
        final Paint a = this.a(gz, d(gz, graphics2D));
        if (a != null) {
            graphics2D.setPaint(a);
            return true;
        }
        return false;
    }
    
    protected Paint a(final gZ gz, final boolean b) {
        return this.b(gz, b);
    }
    
    protected Color b(final gZ gz, final boolean b) {
        return gz.k;
    }
    
    protected boolean c(final gZ gz, final Graphics2D graphics2D) {
        final boolean d = d(gz, graphics2D);
        final Paint d2 = this.d(gz, d);
        if (d2 != null) {
            graphics2D.setStroke(this.c(gz, d));
            graphics2D.setPaint(d2);
            return true;
        }
        return false;
    }
    
    protected Stroke c(final gZ gz, final boolean b) {
        return this.a;
    }
    
    protected Paint d(final gZ gz, final boolean b) {
        return this.e(gz, b);
    }
    
    protected Color e(final gZ gz, final boolean b) {
        return gz.gb;
    }
    
    n a(final gZ gz, final n n) {
        final n contentBox = gz.getContentBox();
        if (contentBox.i() > 0.0) {
            return new n(contentBox.e() - n.b(), -contentBox.f() - n.c(), n.e(), n.f(), -n.g(), -n.i());
        }
        return n;
    }
    
    private static BasicStroke a(final int n) {
        return new BasicStroke(n, 2, 0, 1.6f);
    }
    
    private static boolean d(final gZ gz, final Graphics2D graphics2D) {
        return gZ.b(gz, graphics2D);
    }
}
