/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.List;
import y.b.a;
import y.b.c;
import y.c.C;
import y.d.e;
import y.h.aB;
import y.h.az;
import y.h.bw;
import y.h.ch;
import y.h.fj;
import y.h.im;

public class cU
implements c {
    private im a;
    private List b;
    private List c;
    private Rectangle2D.Double d;
    private boolean e;
    private final ch f;

    @Override
    public void animationPerformed(a a2) {
        boolean bl2 = fj.z;
        switch (a2.a()) {
            case 0: {
                Object object = a2.getSource();
                boolean bl3 = object instanceof y.b.e && ((y.b.e)object).b() && ((y.b.e)object).a();
                boolean bl4 = this.f.r().B();
                if (bl3) {
                    this.f.r().f(true);
                }
                this.b();
                if (!bl3) return;
                this.f.r().f(bl4);
                if (!bl2) return;
            }
            case 3: {
                this.a();
                if (!bl2) return;
            }
            case 4: {
                this.a();
            }
        }
    }

    public void a() {
        this.d = null;
    }

    public void b() {
        if (this.e) {
            this.f.updateView();
            this.a();
            return;
        }
        if (this.d == null) {
            this.c();
            this.f.updateView();
            if (!fj.z) return;
        }
        Rectangle2D.Double double_ = this.c();
        if (double_.width <= 0.0) return;
        if (double_.height <= 0.0) return;
        this.f.updateView(double_.x, double_.y, double_.width, double_.height);
    }

    private Rectangle2D.Double c() {
        Rectangle2D.Double double_;
        double d2;
        Rectangle2D.Double double_2;
        block12 : {
            int n2;
            Rectangle2D.Double double_3;
            Object object;
            int n3;
            boolean bl2;
            block11 : {
                int n4;
                block10 : {
                    int n5;
                    bl2 = fj.z;
                    double d3 = this.f.toWorldCoordX(0);
                    double d4 = this.f.toWorldCoordY(0);
                    double_3 = new Rectangle2D.Double(d3, d4, this.f.toWorldCoordX(this.f.getWidth()) - d3, this.f.toWorldCoordY(this.f.getHeight()) - d4);
                    double_ = new Rectangle2D.Double();
                    double_2 = new Rectangle2D.Double();
                    double_2.setRect(0.0, 0.0, -1.0, -1.0);
                    C c2 = this.a.m();
                    while (c2.f()) {
                        double_.setRect(0.0, 0.0, -1.0, -1.0);
                        this.a((az)c2.d(), (Rectangle2D)double_);
                        n5 = (int)double_3.intersects(double_) ? 1 : 0;
                        if (!bl2) {
                            if (n5 != 0) {
                                e.a(double_2, double_, double_2);
                            }
                            c2.g();
                            if (!bl2) continue;
                        }
                        break block10;
                    }
                    n5 = 0;
                }
                n3 = this.b.size();
                for (n2 = v2128320; n2 < n3; ++n2) {
                    object = (fj)this.b.get(n2);
                    double_.setRect(0.0, 0.0, -1.0, -1.0);
                    this.a((fj)object, (Rectangle2D)double_);
                    n4 = (int)double_3.intersects(double_) ? 1 : 0;
                    if (!bl2) {
                        if (n4 == 0) continue;
                        e.a(double_2, double_, double_2);
                        if (!bl2) continue;
                    }
                    break block11;
                }
                n2 = 0;
                n4 = n3 = this.c.size();
            }
            while (n2 < n3) {
                object = (aB)this.c.get(n2);
                double_.setRect(0.0, 0.0, -1.0, -1.0);
                this.a((aB)object, (Rectangle2D)double_);
                d2 = (double)double_3.intersects(double_) ? 1 : 0;
                if (!bl2) {
                    if (d2 != false) {
                        e.a(double_2, double_, double_2);
                    }
                    ++n2;
                    if (!bl2) continue;
                }
                break block12;
            }
            if (this.d == null) {
                this.d = double_3;
            }
            e.a(this.d, double_2, double_);
            e.b(double_3, double_, double_);
            d2 = double_.width DCMPL 0.0;
        }
        if (d2 >= 0 && double_.height >= 0.0) {
            double_.x -= 10.0;
            double_.y -= 10.0;
            double_.width += 20.0;
            double_.height += 20.0;
        }
        this.d = double_2;
        return double_;
    }

    protected void a(az az2, Rectangle2D rectangle2D) {
        e.a(az2.getBounds(), rectangle2D, rectangle2D);
    }

    protected void a(aB aB2, Rectangle2D rectangle2D) {
        aB2.calcUnionRect(rectangle2D);
    }

    protected void a(fj fj2, Rectangle2D rectangle2D) {
        fj2.calcUnionRect(rectangle2D);
    }
}

