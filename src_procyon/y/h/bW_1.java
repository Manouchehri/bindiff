package y.h;

import java.util.*;
import java.awt.print.*;
import java.awt.font.*;
import java.awt.*;
import java.awt.geom.*;

public class bW implements Printable
{
    private ch e;
    private int f;
    private int g;
    private byte h;
    private boolean i;
    private double j;
    private byte k;
    private RenderingHints l;
    private boolean m;
    cc a;
    ca b;
    byte c;
    Rectangle2D d;
    
    public bW(final ch e) {
        this.f = 1;
        this.g = 1;
        this.h = 1;
        this.i = false;
        this.j = 1.0;
        this.k = 0;
        this.m = true;
        this.e = e;
        this.a = new bZ();
        (this.l = new RenderingHints(new HashMap<RenderingHints.Key, Object>())).put(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        this.c = 0;
    }
    
    public void a(final boolean i) {
        this.i = i;
    }
    
    public boolean a() {
        return this.i;
    }
    
    public void a(final int f) {
        this.f = f;
    }
    
    public void b(final int g) {
        this.g = g;
    }
    
    public int b() {
        return this.f;
    }
    
    public int c() {
        return this.g;
    }
    
    public void a(final byte h) {
        this.h = h;
    }
    
    public byte d() {
        return this.h;
    }
    
    public byte e() {
        return this.c;
    }
    
    public int print(final Graphics graphics, final PageFormat a, final int c) {
        final boolean z = fj.z;
        final Graphics2D b = (Graphics2D)graphics.create();
        b.addRenderingHints(this.l);
        try {
            final AffineTransform transform = b.getTransform();
            final Shape clip = b.getClip();
            if (clip == null) {
                throw new IllegalArgumentException("Graphics.getClip() must be non-null!");
            }
            final double imageableX = a.getImageableX();
            final double imageableY = a.getImageableY();
            final double imageableWidth = a.getImageableWidth();
            final double imageableHeight = a.getImageableHeight();
            final Rectangle f = this.f();
            final double width = f.getWidth();
            final double height = f.getHeight();
            final double x = f.getX();
            final double y = f.getY();
            double height2 = 0.0;
            double height3 = 0.0;
            if (this.a != null) {
                final cb cb = new cb();
                cb.b = b;
                cb.c = c;
                cb.a = a;
                cb.g = this.g;
                cb.f = this.f;
                cb.d = c % this.g;
                cb.e = c / this.g;
                this.a.a(cb);
                height2 = this.a.getBounds().getHeight();
            }
            if (this.b != null) {
                final cb cb2 = new cb();
                cb2.b = b;
                cb2.c = c;
                cb2.a = a;
                cb2.g = this.g;
                cb2.f = this.f;
                cb2.d = c % this.g;
                cb2.e = c / this.g;
                this.b.a(cb2);
                height3 = this.b.getBounds().getHeight();
            }
            int g = 0;
            int f2 = 0;
            double j = 0.0;
            double n3 = 0.0;
            double n4 = 0.0;
            Label_0601: {
                Label_0464: {
                    switch (this.k) {
                        case 1: {
                            final double n = width * this.j;
                            final double n2 = height * this.j;
                            g = (int)Math.ceil(n / imageableWidth - 0.01);
                            f2 = (int)Math.ceil(n2 / imageableHeight - 0.01);
                            j = this.j;
                            n3 = imageableWidth * g;
                            if (this.e() == 1) {
                                n4 = imageableHeight * f2 - height2 * f2 - height3 * f2;
                                if (!z) {
                                    break Label_0601;
                                }
                            }
                            n4 = imageableHeight * f2 - height2 - height3;
                            if (z) {
                                break Label_0464;
                            }
                            break Label_0601;
                        }
                        case 0: {
                            g = this.g;
                            f2 = this.f;
                            n3 = imageableWidth * g;
                            Label_0533: {
                                if (this.e() == 1) {
                                    n4 = imageableHeight * f2 - height2 * f2 - height3 * f2;
                                    if (!z) {
                                        break Label_0533;
                                    }
                                }
                                n4 = imageableHeight * f2 - height2 - height3;
                            }
                            if (n3 / n4 > width / height) {
                                j = n4 / height;
                                if (!z) {
                                    break Label_0601;
                                }
                            }
                            j = n3 / width;
                            if (z) {
                                break;
                            }
                            break Label_0601;
                        }
                    }
                }
                throw new RuntimeException("Undefined ScalingType: " + this.k);
            }
            if (c >= f2 * g) {
                return 1;
            }
            final int n5 = c % g;
            final int n6 = c / g;
            double max = 0.0;
            double max2 = 0.0;
            if (this.m) {
                max = Math.max(0.0, (n3 - width * j) / 2.0);
                max2 = Math.max(0.0, (n4 - height * j) / 2.0);
            }
            Label_0859: {
                if (this.e() == 1) {
                    final int n7 = (int)Math.ceil(imageableX);
                    final int n8 = (int)Math.ceil(imageableY + height2);
                    b.clipRect(n7, n8, (int)Math.floor(imageableX + imageableWidth) - n7, (int)Math.floor(imageableY + imageableHeight - height3) - n8);
                    b.translate(imageableX + max - x * j - imageableWidth * n5, imageableY + max2 - y * j - imageableHeight * n6 + height2 * (n6 + 1) + height3 * n6);
                    if (!z) {
                        break Label_0859;
                    }
                }
                b.translate(imageableX + max - x * j - imageableWidth * n5, imageableY + max2 - y * j - imageableHeight * n6 + height2);
            }
            b.scale(j, j);
            final Rectangle intersection = b.getClipBounds().intersection(new Rectangle(f));
            b.clip(intersection);
            final cV a2 = this.a(this.e, b);
            if (a2 != null) {
                b.setRenderingHint(hk.z, a2);
            }
            this.e.getBackgroundRenderer().paint(b, intersection.x, intersection.y, intersection.width, intersection.height);
            this.e.k(b);
            this.e.getGraph2DRenderer().paint(b, this.e.getGraph2D());
            this.e.j(b);
            b.setTransform(transform);
            b.setClip(clip);
            b.setColor(Color.black);
            if (this.a()) {
                final cb cb3 = new cb();
                cb3.b = b;
                cb3.c = c;
                cb3.a = a;
                cb3.g = g;
                cb3.f = f2;
                cb3.d = c % g;
                cb3.e = c / g;
                this.a(b, cb3);
            }
            if (this.a != null) {
                this.a.a(b);
            }
            if (this.b != null) {
                this.b.a(b);
            }
            return 0;
        }
        finally {
            b.dispose();
        }
    }
    
    protected void a(final Graphics2D graphics2D, final cb cb) {
        final Color color = graphics2D.getColor();
        final Font font = graphics2D.getFont();
        this.b(graphics2D, cb);
        final PageFormat c = cb.c();
        final int n = (int)c.getImageableX() + 15;
        final int n2 = (int)c.getImageableY() + 15;
        final TextLayout textLayout = new TextLayout("[" + (cb.a() + 1) + ',' + (cb.b() + 1) + "]", graphics2D.getFont(), graphics2D.getFontRenderContext());
        graphics2D.setColor(Color.white);
        final Rectangle2D bounds = textLayout.getBounds();
        bounds.setRect(bounds.getX() + n - 2.0, bounds.getY() + n2 - 2.0, bounds.getWidth() + 4.0, bounds.getHeight() + 4.0);
        graphics2D.fill(bounds);
        graphics2D.setColor(Color.black);
        textLayout.draw(graphics2D, n, n2);
        graphics2D.setFont(font);
        graphics2D.setColor(color);
    }
    
    protected void b(final Graphics2D graphics2D, final cb cb) {
        final Font font = graphics2D.getFont();
        if (font.getSize() != 11) {
            graphics2D.setFont(font.deriveFont(11.0f));
        }
    }
    
    Rectangle f() {
        Rectangle rectangle = null;
        switch (this.d()) {
            case 0: {
                rectangle = this.e.getVisibleRect();
                break;
            }
            case 2: {
                if (this.d == null) {
                    throw new IllegalArgumentException("custom clip not set");
                }
                rectangle = this.d.getBounds();
                break;
            }
            default: {
                rectangle = this.e.getGraph2D().a();
                rectangle.setFrame(rectangle.x - 2, rectangle.y - 2, rectangle.width + 4, rectangle.height + 4);
                break;
            }
        }
        return rectangle;
    }
    
    protected cV a(final ch ch, final Graphics2D graphics2D) {
        if (graphics2D.getRenderingHint(hk.z) == null) {
            final cV cv = new cV();
            cv.a(true);
            cv.a(ch);
            final Point2D viewPoint2D = ch.getViewPoint2D();
            final AffineTransform transform = graphics2D.getTransform();
            transform.translate(viewPoint2D.getX(), viewPoint2D.getY());
            final double n = 1.0 / ch.getZoom();
            transform.scale(n, n);
            cv.a(transform);
            return cv;
        }
        return null;
    }
    
    public void a(final cc a) {
        this.a = a;
    }
}
