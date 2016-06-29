package y.h;

import y.d.*;
import java.awt.*;

class eb implements az
{
    private int a;
    private int b;
    private float c;
    private final t d;
    private final ep e;
    
    eb(final ep e, final t d) {
        this.e = e;
        this.d = d;
        this.a = 1;
        this.b = 3;
        this.c = 2.0f;
    }
    
    public void a(final Graphics2D graphics2D) {
        final boolean z = fj.z;
        final Stroke stroke = graphics2D.getStroke();
        graphics2D.setStroke(new BasicStroke(this.c));
        int n = 0;
        do {
            int i = 0;
        Label_0028:
            while (i < ep.a(this.e).size()) {
                final ew ew = ep.a(this.e).get(n);
                final t a = ew.a(this.d.a - ep.b(this.e).a, this.d.b - ep.b(this.e).b);
                final double a2 = a.a();
                final double b = a.b();
                final double n2 = ew.c() / 2.0 + 15.0;
                final double n3 = ew.d() / 2.0 + 15.0;
                if (z) {
                    return;
                }
                int j = -this.a;
            Label_0274_Outer:
                while (j <= this.a) {
                    final int n4 = (int)(a2 + j * n2);
                    i = -this.a;
                    if (!z) {
                        int k = i;
                        while (true) {
                            while (k <= this.a) {
                                final int n5 = (int)(b + k * n3);
                                graphics2D.drawLine(n4, n5 - this.b, n4, n5 + this.b);
                                graphics2D.drawLine(n4 - this.b, n5, n4 + this.b, n5);
                                ++k;
                                if (!z) {
                                    if (z) {
                                        break;
                                    }
                                    continue Label_0274_Outer;
                                }
                                else {
                                    if (z) {
                                        break Label_0274_Outer;
                                    }
                                    continue Label_0274_Outer;
                                }
                            }
                            ++j;
                            continue;
                        }
                    }
                    continue Label_0028;
                }
                ++n;
            }
            break;
        } while (!z);
        graphics2D.setStroke(stroke);
    }
    
    public Rectangle getBounds() {
        final boolean z = fj.z;
        Rectangle union = new Rectangle();
        int i = 0;
        Rectangle rectangle2 = null;
        while (i < ep.a(this.e).size()) {
            final ew ew = ep.a(this.e).get(i);
            final t a = ew.a(this.d.a - ep.b(this.e).a, this.d.b - ep.b(this.e).b);
            final Rectangle rectangle = new Rectangle((int)(a.a() - this.a * ew.c() / 2.0 - 15.0) - this.b, (int)(a.b() - this.a * ew.d() / 2.0 - 15.0) - this.b, (int)((this.a + 1) * ew.c() + 2 * this.b), (int)((this.a + 1) * ew.d() + 2 * this.b));
            rectangle.grow(this.b, this.b);
            rectangle2 = union;
            if (z) {
                return rectangle2;
            }
            Label_0259: {
                if (rectangle2.getWidth() < 0.0) {
                    union = rectangle;
                    if (!z) {
                        break Label_0259;
                    }
                }
                union = union.union(rectangle);
            }
            ++i;
            if (z) {
                break;
            }
        }
        return rectangle2;
    }
}
