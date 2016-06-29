package y.h;

import y.d.*;
import y.c.*;
import java.awt.image.*;
import java.awt.geom.*;
import java.util.*;
import java.awt.*;

class dv implements az
{
    private t b;
    private int c;
    private double d;
    private ch e;
    private BufferedImage f;
    private boolean g;
    D a;
    private final ds h;
    
    dv(final ds h, final ch e) {
        this.h = h;
        this.g = true;
        this.a = new D();
        this.d = 2.0;
        this.c = 100;
        this.b = t.c;
        this.e = e;
    }
    
    public void a(final Graphics2D graphics2D) {
        if (this.g) {
            this.h.view.addDrawable(this);
            this.h.view.removeDrawable(this);
            this.g = false;
            return;
        }
        this.g = true;
        final Graphics2D graphics2D2 = (Graphics2D)graphics2D.create();
        final Rectangle2D a = this.a();
        final Ellipse2D.Double double1 = new Ellipse2D.Double();
        double1.setFrame(a);
        if (this.d != 1.0) {
            final Shape clip = graphics2D2.getClip();
            final AffineTransform transform = graphics2D2.getTransform();
            graphics2D2.clip(double1);
            graphics2D2.translate(a.getX(), a.getY());
            Label_0249: {
                if (this.h.view.getClientProperty("MagnifierViewMode.noDoubleBuffering") == null) {
                    final int n = (int)Math.ceil(a.getWidth());
                    final int n2 = (int)Math.ceil(a.getHeight());
                    if (this.f == null || this.f.getWidth() < n || this.f.getHeight() < n2) {
                        this.f = this.a(graphics2D2, n, n2);
                    }
                    final Graphics2D graphics = this.f.createGraphics();
                    graphics.addRenderingHints(graphics2D2.getRenderingHints());
                    graphics.setClip(0, 0, n, n2);
                    this.b(graphics);
                    graphics.dispose();
                    graphics2D2.drawImage(this.f, 0, 0, null);
                    if (!fj.z) {
                        break Label_0249;
                    }
                }
                this.b(graphics2D2);
            }
            graphics2D2.setTransform(transform);
            graphics2D2.setClip(clip);
        }
        graphics2D2.setColor(Color.BLACK);
        graphics2D2.setStroke(new BasicStroke(1.5f / (float)this.h.view.getZoom()));
        graphics2D2.draw(double1);
        graphics2D2.dispose();
    }
    
    private void b(final Graphics2D graphics2D) {
        this.b();
        this.e.setGraph2D(this.h.getGraph2D());
        final double n = 20.0 / this.h.view.getZoom();
        this.e.setSize((int)(2 * this.c / this.h.view.getZoom()), (int)(2 * this.c / this.h.view.getZoom()));
        this.e.setZoom(this.d);
        this.e.setCenter(this.b.a, this.b.b);
        this.e.setSize((int)(2 * this.c / this.h.view.getZoom()), (int)(2 * this.c / this.h.view.getZoom() + n));
        this.e.paintVisibleContent(graphics2D);
        this.h.getGraph2D().c(this.e);
        this.c();
    }
    
    public Rectangle2D a() {
        final Rectangle2D.Double double1 = new Rectangle2D.Double();
        final double n = this.c / this.h.view.getZoom();
        double1.setFrame(this.b.a - n, this.b.b - n, 2.0 * n, 2.0 * n);
        return double1;
    }
    
    public void b() {
        final boolean z = fj.z;
        for (final az az : this.h.view.getDrawables()) {
            if (az != ds.a(this.h)) {
                this.a.c(az);
                this.e.addDrawable(az);
                if (z) {
                    break;
                }
                continue;
            }
        }
    }
    
    public void c() {
        final boolean z = fj.z;
        while (!this.a.isEmpty()) {
            this.e.removeDrawable((az)this.a.g());
            if (z) {
                break;
            }
        }
    }
    
    public Rectangle getBounds() {
        final Rectangle rectangle = new Rectangle();
        rectangle.setFrame(this.a());
        return rectangle;
    }
    
    public void a(final t b) {
        this.b = b;
    }
    
    public void a(final int c) {
        this.c = c;
    }
    
    public void a(final double d) {
        this.d = d;
    }
    
    private BufferedImage a(final Graphics2D graphics2D, final int n, final int n2) {
        final GraphicsConfiguration deviceConfiguration = graphics2D.getDeviceConfiguration();
        if (deviceConfiguration != null) {
            return deviceConfiguration.createCompatibleImage(n, n2, 3);
        }
        return new BufferedImage(n, n2, 2);
    }
}
