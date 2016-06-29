package y.h;

import java.awt.*;
import y.d.*;

class L extends bu implements az
{
    private final F a;
    
    L(final F a) {
        this.a = a;
    }
    
    public void a(final Graphics2D graphics2D) {
        this.i(this.l()).paint(graphics2D);
        if (F.g(this.a)) {
            if (this.a.e() && F.h(this.a) != null) {
                this.a.a(graphics2D, F.h(this.a));
                if (!fj.z) {
                    return;
                }
            }
            if (F.i(this.a) != null) {
                this.a.a(graphics2D, this.a.getGraph2D().t(F.i(this.a)));
            }
        }
    }
    
    public Rectangle getBounds() {
        Rectangle rectangle = this.a();
        if (F.g(this.a)) {
            if (F.i(this.a) != null) {
                rectangle = rectangle.union(this.a.b(this.a.getGraph2D().t(F.i(this.a))).getBounds()).getBounds();
            }
            if (this.a.e() && F.h(this.a) != null) {
                final y k = F.h(this.a).k();
                rectangle.add(k.c(), k.d());
                rectangle.add(k.c() + k.a(), k.d() + k.b());
            }
        }
        return rectangle;
    }
}
