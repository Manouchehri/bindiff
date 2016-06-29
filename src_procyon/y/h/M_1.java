package y.h;

import java.net.*;
import javax.swing.*;
import y.g.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.geom.*;

public class M implements w
{
    public static final byte FULLSCREEN = 0;
    public static final byte TILED = 1;
    public static final byte BRICKED = 2;
    public static final byte CENTERED = 3;
    public static final byte PLAIN = 4;
    public static final byte DYNAMIC = 5;
    protected ch view;
    private Image f;
    private Color g;
    private Point h;
    private URL c;
    private byte d;
    private AffineTransform b;
    private Graphics2D e;
    
    public M(final ch view) {
        this.d = 4;
        this.view = view;
        this.g = Color.white;
        this.h = new Point(0, 0);
    }
    
    public URL getImageResource() {
        return this.c;
    }
    
    public ch getView() {
        return this.view;
    }
    
    public void setGraph2DView(final ch view) {
        this.view = view;
    }
    
    public void setImageResource(final URL c) {
        if (c == null) {
            throw new NullPointerException("Specified image url is null.");
        }
        if (this.c == null || !c.toExternalForm().equals(this.c.toExternalForm())) {
            this.c = c;
            this.f = new ImageIcon(c).getImage();
        }
    }
    
    public void setImage(final Image f) {
        this.f = f;
        this.c = null;
    }
    
    public Image getImage() {
        return this.f;
    }
    
    public void setColor(final Color g) {
        this.g = g;
    }
    
    public Color getColor() {
        return this.g;
    }
    
    public void setImageOrigin(final double n, final double n2) {
        this.h = new Point((int)n, (int)n2);
    }
    
    public Point getImageOrigin() {
        return this.h;
    }
    
    public void setMode(final byte d) {
        this.d = d;
    }
    
    public byte getMode() {
        return this.d;
    }
    
    public void paint(final Graphics2D graphics2D, final int n, final int n2, final int n3, final int n4) {
        final boolean z = fj.z;
        final Color color = graphics2D.getColor();
        final AffineTransform transform = graphics2D.getTransform();
        this.h(graphics2D);
        Label_0157: {
            if (this.f != null) {
                Label_0122: {
                    switch (this.d) {
                        case 4: {
                            this.b(graphics2D);
                            if (z) {
                                break Label_0122;
                            }
                            break Label_0157;
                        }
                        case 3: {
                            this.c(graphics2D);
                            if (z) {
                                break Label_0122;
                            }
                            break Label_0157;
                        }
                        case 1: {
                            this.d(graphics2D);
                            if (z) {
                                break Label_0122;
                            }
                            break Label_0157;
                        }
                        case 2: {
                            this.e(graphics2D);
                            if (z) {
                                break Label_0122;
                            }
                            break Label_0157;
                        }
                        case 0: {
                            this.f(graphics2D);
                            if (z) {
                                break Label_0122;
                            }
                            break Label_0157;
                        }
                        case 5: {
                            this.g(graphics2D);
                            if (z) {
                                break;
                            }
                            break Label_0157;
                        }
                    }
                }
                o.a((Object)("Unknown background rendering mode: " + this.d));
            }
        }
        graphics2D.setColor(color);
        graphics2D.setTransform(transform);
    }
    
    void h(final Graphics2D graphics2D) {
        if (this.g != null) {
            final Rectangle clipBounds = graphics2D.getClipBounds();
            graphics2D.setColor(this.g);
            graphics2D.fillRect(clipBounds.x, clipBounds.y, clipBounds.width, clipBounds.height);
        }
    }
    
    void g(final Graphics2D graphics2D) {
        this.f.getWidth(null);
        this.f.getHeight(null);
        graphics2D.drawImage(this.f, this.h.x, this.h.y, null);
    }
    
    void b(final Graphics2D graphics2D) {
        this.undoWorldTransform(graphics2D);
        this.f.getWidth(null);
        this.f.getHeight(null);
        graphics2D.drawImage(this.f, this.h.x, this.h.y, null);
    }
    
    void c(final Graphics2D graphics2D) {
        this.undoWorldTransform(graphics2D);
        graphics2D.drawImage(this.f, (this.view.getWidth() - this.f.getWidth(null)) / 2, (this.view.getHeight() - this.f.getHeight(null)) / 2, null);
    }
    
    void d(final Graphics2D graphics2D) {
        final boolean z = fj.z;
        this.undoWorldTransform(graphics2D);
        final Rectangle clipBounds = graphics2D.getClipBounds();
        final int width = this.f.getWidth(null);
        final int height = this.f.getHeight(null);
        final int n = -this.h.x + clipBounds.x;
        final int n2 = -this.h.y + clipBounds.y;
        final int n3 = n % width;
        int n4 = clipBounds.x - n3;
        if (n3 != 0) {
            n4 -= width;
        }
        final int n5 = n2 % height;
        int n6 = clipBounds.y - n5;
        if (n5 != 0) {
            n6 -= height;
        }
        int i = n6;
    Label_0191_Outer:
        while (i < clipBounds.y + clipBounds.height) {
            int j = n4;
            while (true) {
                while (j < clipBounds.x + clipBounds.width) {
                    graphics2D.drawImage(this.f, j, i, null);
                    j += width;
                    if (!z) {
                        if (z) {
                            break;
                        }
                        continue Label_0191_Outer;
                    }
                    else {
                        if (z) {
                            break Label_0191_Outer;
                        }
                        continue Label_0191_Outer;
                    }
                }
                i += height;
                continue;
            }
        }
    }
    
    void e(final Graphics2D graphics2D) {
        final boolean z = fj.z;
        this.undoWorldTransform(graphics2D);
        final Rectangle clipBounds = graphics2D.getClipBounds();
        final int width = this.f.getWidth(null);
        final int height = this.f.getHeight(null);
        int n = 1;
        int i = 0;
    Label_0122_Outer:
        while (i < clipBounds.y + clipBounds.height) {
            int j = (n != 0) ? 0 : (-width / 2);
        Label_0123_Outer:
            while (true) {
                while (true) {
                    while (j < clipBounds.x + clipBounds.width) {
                        graphics2D.drawImage(this.f, j, i, null);
                        j += width;
                        if (!z) {
                            if (z) {
                                break;
                            }
                            continue Label_0122_Outer;
                        }
                        else {
                            final int n2 = 0;
                            n = n2;
                            i += height;
                            if (z) {
                                break Label_0122_Outer;
                            }
                            continue Label_0122_Outer;
                        }
                    }
                    if (n == 0) {
                        final int n2 = 1;
                        continue;
                    }
                    break;
                }
                continue Label_0123_Outer;
            }
        }
    }
    
    void f(final Graphics2D graphics2D) {
        this.undoWorldTransform(graphics2D);
        graphics2D.drawImage(this.f, 0, 0, this.view.getWidth(), this.view.getHeight(), null);
    }
    
    protected void undoWorldTransform(final Graphics2D e) {
        this.b = e.getTransform();
        this.e = e;
        final cV a = hk.a(e);
        if (a != null && a.a() != null) {
            e.setTransform(a.a());
            if (!fj.z) {
                return;
            }
        }
        final Point2D viewPoint2D = this.view.getViewPoint2D();
        final double n = 1.0 / this.view.getZoom();
        e.translate(viewPoint2D.getX(), viewPoint2D.getY());
        e.scale(n, n);
    }
    
    protected void redoWorldTransform(final Graphics2D graphics2D) {
        if (this.b != null && graphics2D == this.e) {
            graphics2D.setTransform(this.b);
            if (!fj.z) {
                return;
            }
        }
        final Point viewPoint = this.view.getViewPoint();
        final double zoom = this.view.getZoom();
        graphics2D.scale(zoom, zoom);
        graphics2D.translate(-viewPoint.getX(), -viewPoint.getY());
    }
}
