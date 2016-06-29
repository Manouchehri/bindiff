package y.h;

import y.c.*;
import java.awt.*;

class dQ implements az
{
    private final dP a;
    
    dQ(final dP a) {
        this.a = a;
    }
    
    public void a(final Graphics2D graphics2D) {
        final q a = this.a();
        if (a != null) {
            this.a.a(graphics2D, this.a.getGraph2D().t(a));
        }
    }
    
    public Rectangle getBounds() {
        final q a = this.a();
        if (a != null) {
            return this.a.a(this.a.getGraph2D().t(a)).getBounds();
        }
        return new Rectangle(0, 0, -1, -1);
    }
    
    private q a() {
        final Object b = this.a.b(dP.a(this.a), dP.b(this.a));
        if (b instanceof q) {
            return (q)b;
        }
        return null;
    }
}
