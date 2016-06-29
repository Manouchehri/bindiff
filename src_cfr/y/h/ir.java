/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import y.d.t;
import y.d.z;
import y.h.az;
import y.h.dh;
import y.h.fj;
import y.h.io;
import y.h.ip;
import y.h.is;

class ir
implements az {
    private final double a;
    private final double b;
    private final double c;
    private final double d;
    private dh e;
    private boolean f;
    private final List g;

    ir(double d2, double d3, double d4, double d5) {
        this.a = d2;
        this.b = d3;
        this.c = d4;
        this.d = d5;
        this.g = new ArrayList(3);
        this.f = true;
    }

    ir() {
        this.a = 0.0;
        this.b = 0.0;
        this.c = 0.0;
        this.d = 0.0;
        this.g = new ArrayList(1);
        this.f = false;
    }

    @Override
    public void a(Graphics2D graphics2D) {
        Color color = graphics2D.getColor();
        Stroke stroke = graphics2D.getStroke();
        graphics2D.setColor(this.a());
        graphics2D.setStroke(new BasicStroke());
        this.a(new io(this, graphics2D));
        graphics2D.setColor(color);
        graphics2D.setStroke(stroke);
    }

    @Override
    public Rectangle getBounds() {
        Rectangle2D.Double double_ = new Rectangle2D.Double(0.0, 0.0, -1.0, -1.0);
        this.a(new ip(this, double_));
        if (double_.getWidth() < 0.0) return double_.getBounds();
        if (double_.getHeight() < 0.0) return double_.getBounds();
        double_.setFrame(double_.getX() - 2.0, double_.getY() - 2.0, double_.getWidth() + 4.0, double_.getHeight() + 4.0);
        return double_.getBounds();
    }

    void a(t t2) {
        this.g.add(t2);
    }

    void a(dh dh2) {
        this.e = dh2;
    }

    Color a() {
        if (this.e != null) return this.e.a();
        return Color.LIGHT_GRAY;
    }

    void a(is is2) {
        z z2;
        double d2;
        Line2D.Double double_;
        boolean bl2;
        double d3;
        block3 : {
            bl2 = fj.z;
            double_ = new Line2D.Double();
            if (this.f) {
                z2 = new z(this.c - this.a, this.d - this.b);
                z2.c();
                d3 = 10.0 * z2.a();
                d2 = 10.0 * z2.b();
                double_.setLine(this.a - d3, this.b - d2, this.c + d3, this.d + d2);
                is2.a(double_);
                if (!bl2) break block3;
            }
            z2 = new z(0.0, -1.0);
        }
        d3 = z2.a();
        d2 = z2.b();
        if (this.g.isEmpty()) return;
        Iterator iterator = this.g.iterator();
        do {
            if (!iterator.hasNext()) return;
            t t2 = (t)iterator.next();
            double d4 = t2.a() - 3.0 * (d3 - d2);
            double d5 = t2.b() - 3.0 * (d3 + d2);
            double d6 = d4 + d3 * 6.0;
            double d7 = d5 + d2 * 6.0;
            double d8 = d4 + d3 * 6.0 - d2 * 6.0;
            double d9 = d5 + d2 * 6.0 + d3 * 6.0;
            double d10 = d4 - d2 * 6.0;
            double d11 = d5 + d3 * 6.0;
            double_.setLine(d4, d5, d8, d9);
            is2.a(double_);
            double_.setLine(d6, d7, d10, d11);
            is2.a(double_);
        } while (!bl2);
    }
}

