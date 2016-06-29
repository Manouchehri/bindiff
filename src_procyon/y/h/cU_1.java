package y.h;

import java.util.*;
import java.awt.geom.*;
import y.b.*;
import y.c.*;

public class cU implements c
{
    private im a;
    private List b;
    private List c;
    private Rectangle2D.Double d;
    private boolean e;
    private final ch f;
    
    public void animationPerformed(final a a) {
        final boolean z = fj.z;
        Label_0143: {
            switch (a.a()) {
                case 0: {
                    final Object source = a.getSource();
                    final boolean b = source instanceof e && ((e)source).b() && ((e)source).a();
                    final boolean b2 = this.f.r().B();
                    if (b) {
                        this.f.r().f(true);
                    }
                    this.b();
                    if (!b) {
                        break;
                    }
                    this.f.r().f(b2);
                    if (z) {
                        break Label_0143;
                    }
                    break;
                }
                case 3: {
                    this.a();
                    if (z) {
                        break Label_0143;
                    }
                    break;
                }
                case 4: {
                    this.a();
                    break;
                }
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
            if (!fj.z) {
                return;
            }
        }
        final Rectangle2D.Double c = this.c();
        if (c.width > 0.0 && c.height > 0.0) {
            this.f.updateView(c.x, c.y, c.width, c.height);
        }
    }
    
    private Rectangle2D.Double c() {
        final boolean z = fj.z;
        final double worldCoordX = this.f.toWorldCoordX(0);
        final double worldCoordY = this.f.toWorldCoordY(0);
        final Rectangle2D.Double d = new Rectangle2D.Double(worldCoordX, worldCoordY, this.f.toWorldCoordX(this.f.getWidth()) - worldCoordX, this.f.toWorldCoordY(this.f.getHeight()) - worldCoordY);
        final Rectangle2D.Double double1 = new Rectangle2D.Double();
        final Rectangle2D.Double d2 = new Rectangle2D.Double();
        d2.setRect(0.0, 0.0, -1.0, -1.0);
        final C m = this.a.m();
        while (true) {
            while (m.f()) {
                double1.setRect(0.0, 0.0, -1.0, -1.0);
                this.a((az)m.d(), double1);
                final int intersects;
                final int n = intersects = (d.intersects(double1) ? 1 : 0);
                if (z) {
                    int i = intersects;
                    while (true) {
                        while (i < this.b.size()) {
                            final fj fj = this.b.get(i);
                            double1.setRect(0.0, 0.0, -1.0, -1.0);
                            this.a(fj, double1);
                            final int n3;
                            final int n2 = n3 = (d.intersects(double1) ? 1 : 0);
                            if (z) {
                                while (true) {
                                    while (i < n3) {
                                        final aB ab = this.c.get(i);
                                        double1.setRect(0.0, 0.0, -1.0, -1.0);
                                        this.a(ab, double1);
                                        final double intersects2;
                                        final int n4 = (int)(intersects2 = (d.intersects(double1) ? 1 : 0));
                                        if (z) {
                                            if (intersects2 >= 0 && double1.height >= 0.0) {
                                                final Rectangle2D.Double double2 = double1;
                                                double2.x -= 10.0;
                                                final Rectangle2D.Double double3 = double1;
                                                double3.y -= 10.0;
                                                final Rectangle2D.Double double4 = double1;
                                                double4.width += 20.0;
                                                final Rectangle2D.Double double5 = double1;
                                                double5.height += 20.0;
                                            }
                                            this.d = d2;
                                            return double1;
                                        }
                                        if (n4 != 0) {
                                            y.d.e.a(d2, double1, d2);
                                        }
                                        ++i;
                                        if (z) {
                                            break;
                                        }
                                    }
                                    if (this.d == null) {
                                        this.d = d;
                                    }
                                    y.d.e.a(this.d, d2, double1);
                                    y.d.e.b(d, double1, double1);
                                    double intersects2 = dcmpl(double1.width, 0.0);
                                    continue;
                                }
                            }
                            if (n2 != 0) {
                                y.d.e.a(d2, double1, d2);
                            }
                            ++i;
                            if (z) {
                                break;
                            }
                        }
                        i = 0;
                        int n3 = this.c.size();
                        continue;
                    }
                }
                if (n != 0) {
                    y.d.e.a(d2, double1, d2);
                }
                m.g();
                if (z) {
                    break;
                }
            }
            int intersects = 0;
            continue;
        }
    }
    
    protected void a(final az az, final Rectangle2D rectangle2D) {
        y.d.e.a(az.getBounds(), rectangle2D, rectangle2D);
    }
    
    protected void a(final aB ab, final Rectangle2D rectangle2D) {
        ab.calcUnionRect(rectangle2D);
    }
    
    protected void a(final fj fj, final Rectangle2D rectangle2D) {
        fj.calcUnionRect(rectangle2D);
    }
}
