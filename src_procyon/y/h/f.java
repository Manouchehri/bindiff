package y.h;

import y.d.*;
import java.awt.*;
import java.awt.geom.*;

class f implements az
{
    private final e a;
    
    f(final e a) {
        this.a = a;
    }
    
    public void a(final Graphics2D graphics2D) {
        final boolean z = fj.z;
        graphics2D.setColor(e.a(this.a));
        if (e.b(this.a) != null && e.c(this.a)) {
            final t t = new t(e.d(this.a).a + e.e(this.a), e.d(this.a).b + e.f(this.a));
            int i = 0;
            while (i < e.b(this.a).size()) {
                ((gz)e.b(this.a).get(i)).a(this.a, t).a(graphics2D);
                ++i;
                if (z) {
                    break;
                }
            }
        }
    }
    
    public Rectangle getBounds() {
        final boolean z = fj.z;
        final Rectangle rectangle = new Rectangle(0, 0, -1, -1);
        Rectangle bounds = null;
        if (e.b(this.a) != null && e.c(this.a)) {
            final t t = new t(e.d(this.a).a + e.e(this.a), e.d(this.a).b + e.f(this.a));
            int i = 0;
            while (i < e.b(this.a).size()) {
                bounds = e.b(this.a).get(i).a(this.a, t).getBounds();
                if (z) {
                    break;
                }
                y.d.e.a(bounds, rectangle, rectangle);
                ++i;
                if (z) {
                    break;
                }
            }
        }
        return bounds;
    }
}
