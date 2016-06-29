/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.ImageObserver;
import java.net.URL;
import javax.swing.ImageIcon;
import y.g.o;
import y.h.cV;
import y.h.ch;
import y.h.fj;
import y.h.hk;
import y.h.w;

public class M
implements w {
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
    private byte d = 4;
    private AffineTransform b;
    private Graphics2D e;

    public M(ch ch2) {
        this.view = ch2;
        this.g = Color.white;
        this.h = new Point(0, 0);
    }

    public URL getImageResource() {
        return this.c;
    }

    public ch getView() {
        return this.view;
    }

    public void setGraph2DView(ch ch2) {
        this.view = ch2;
    }

    public void setImageResource(URL uRL) {
        if (uRL == null) {
            throw new NullPointerException("Specified image url is null.");
        }
        if (this.c != null) {
            if (uRL.toExternalForm().equals(this.c.toExternalForm())) return;
        }
        this.c = uRL;
        this.f = new ImageIcon(uRL).getImage();
    }

    public void setImage(Image image) {
        this.f = image;
        this.c = null;
    }

    public Image getImage() {
        return this.f;
    }

    public void setColor(Color color) {
        this.g = color;
    }

    public Color getColor() {
        return this.g;
    }

    public void setImageOrigin(double d2, double d3) {
        this.h = new Point((int)d2, (int)d3);
    }

    public Point getImageOrigin() {
        return this.h;
    }

    public void setMode(byte by2) {
        this.d = by2;
    }

    public byte getMode() {
        return this.d;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void paint(Graphics2D var1_1, int var2_2, int var3_3, int var4_4, int var5_5) {
        var8_6 = fj.z;
        var6_7 = var1_1.getColor();
        var7_8 = var1_1.getTransform();
        this.h(var1_1);
        if (this.f == null) ** GOTO lbl26
        switch (this.d) {
            case 4: {
                this.b(var1_1);
                if (!var8_6) ** GOTO lbl26
            }
            case 3: {
                this.c(var1_1);
                if (!var8_6) ** GOTO lbl26
            }
            case 1: {
                this.d(var1_1);
                if (!var8_6) ** GOTO lbl26
            }
            case 2: {
                this.e(var1_1);
                if (!var8_6) ** GOTO lbl26
            }
            case 0: {
                this.f(var1_1);
                if (!var8_6) ** GOTO lbl26
            }
            case 5: {
                this.g(var1_1);
                if (!var8_6) ** GOTO lbl26
            }
        }
        o.a((Object)new StringBuffer().append("Unknown background rendering mode: ").append(this.d).toString());
lbl26: // 8 sources:
        var1_1.setColor(var6_7);
        var1_1.setTransform(var7_8);
    }

    void h(Graphics2D graphics2D) {
        if (this.g == null) return;
        Rectangle rectangle = graphics2D.getClipBounds();
        graphics2D.setColor(this.g);
        graphics2D.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

    void g(Graphics2D graphics2D) {
        int n2 = this.f.getWidth(null);
        int n3 = this.f.getHeight(null);
        graphics2D.drawImage(this.f, this.h.x, this.h.y, null);
    }

    void b(Graphics2D graphics2D) {
        this.undoWorldTransform(graphics2D);
        int n2 = this.f.getWidth(null);
        int n3 = this.f.getHeight(null);
        graphics2D.drawImage(this.f, this.h.x, this.h.y, null);
    }

    void c(Graphics2D graphics2D) {
        this.undoWorldTransform(graphics2D);
        int n2 = this.f.getWidth(null);
        int n3 = this.f.getHeight(null);
        int n4 = this.view.getWidth();
        int n5 = this.view.getHeight();
        graphics2D.drawImage(this.f, (n4 - n2) / 2, (n5 - n3) / 2, null);
    }

    void d(Graphics2D graphics2D) {
        boolean bl2 = fj.z;
        this.undoWorldTransform(graphics2D);
        Rectangle rectangle = graphics2D.getClipBounds();
        int n2 = this.f.getWidth(null);
        int n3 = this.f.getHeight(null);
        int n4 = - this.h.x + rectangle.x;
        int n5 = - this.h.y + rectangle.y;
        int n6 = n4 % n2;
        n4 = rectangle.x - n6;
        if (n6 != 0) {
            n4 -= n2;
        }
        n6 = n5 % n3;
        n5 = rectangle.y - n6;
        if (n6 != 0) {
            n5 -= n3;
        }
        int n7 = n5;
        block0 : do {
            if (n7 >= rectangle.y + rectangle.height) return;
            for (int i2 = n4; i2 < rectangle.x + rectangle.width; i2 += n2) {
                graphics2D.drawImage(this.f, i2, n7, null);
                if (bl2) continue block0;
                if (!bl2) continue;
            }
            n7 += n3;
        } while (!bl2);
    }

    /*
     * Unable to fully structure code
     */
    void e(Graphics2D var1_1) {
        var8_2 = fj.z;
        this.undoWorldTransform(var1_1);
        var2_3 = var1_1.getClipBounds();
        var3_4 = this.f.getWidth(null);
        var4_5 = this.f.getHeight(null);
        var5_6 = true;
        var6_7 = 0;
        do {
            if (var6_7 >= var2_3.y + var2_3.height) return;
            v0 = var7_8 = var5_6 != false ? 0 : (- var3_4) / 2;
            while (var7_8 < var2_3.x + var2_3.width) {
                var1_1.drawImage(this.f, var7_8, var6_7, null);
                var7_8 += var3_4;
                if (!var8_2) {
                    if (!var8_2) continue;
                }
                ** GOTO lbl-1000
            }
            if (!var5_6) {
                v1 = true;
            } else lbl-1000: // 2 sources:
            {
                v1 = false;
            }
            var5_6 = v1;
            var6_7 += var4_5;
        } while (!var8_2);
    }

    void f(Graphics2D graphics2D) {
        this.undoWorldTransform(graphics2D);
        int n2 = this.view.getWidth();
        int n3 = this.view.getHeight();
        graphics2D.drawImage(this.f, 0, 0, n2, n3, null);
    }

    protected void undoWorldTransform(Graphics2D graphics2D) {
        this.b = graphics2D.getTransform();
        this.e = graphics2D;
        cV cV2 = hk.a(graphics2D);
        if (cV2 != null && cV2.a() != null) {
            graphics2D.setTransform(cV2.a());
            if (!fj.z) return;
        }
        Point2D point2D = this.view.getViewPoint2D();
        double d2 = 1.0 / this.view.getZoom();
        graphics2D.translate(point2D.getX(), point2D.getY());
        graphics2D.scale(d2, d2);
    }

    protected void redoWorldTransform(Graphics2D graphics2D) {
        if (this.b != null && graphics2D == this.e) {
            graphics2D.setTransform(this.b);
            if (!fj.z) return;
        }
        Point point = this.view.getViewPoint();
        double d2 = this.view.getZoom();
        graphics2D.scale(d2, d2);
        graphics2D.translate(- point.getX(), - point.getY());
    }
}

