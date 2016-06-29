package y.h;

import java.awt.geom.*;
import y.d.*;
import y.c.*;
import java.awt.*;

class dN implements az
{
    D a;
    Rectangle2D b;
    d c;
    q d;
    private final dI e;
    
    dN(final dI e, final D a, final Rectangle2D b, final q d, final d c) {
        this.e = e;
        this.a = a;
        this.b = b;
        this.d = d;
        this.c = c;
    }
    
    public void a(final Graphics2D graphics2D) {
        final boolean z = fj.z;
        final C m = this.a.m();
        while (m.f()) {
            this.e.a(graphics2D, (t)m.d(), this.d, this.c);
            m.g();
            if (z) {
                return;
            }
            if (z) {
                break;
            }
        }
        if (dI.d(this.e) && this.e.f != null) {
            this.e.a(graphics2D, this.e.f);
        }
    }
    
    public Rectangle getBounds() {
        if (dI.d(this.e) && this.e.f != null) {
            return this.b.getBounds().createUnion(dI.e(this.e)).getBounds();
        }
        return this.b.getBounds();
    }
}
