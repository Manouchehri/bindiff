package y.h;

import y.c.*;
import java.awt.*;
import y.d.*;
import java.awt.geom.*;

class im extends D implements az
{
    public void a(final Graphics2D graphics2D) {
        final boolean z = fj.z;
        final C m = this.m();
        while (m.f()) {
            ((az)m.d()).a(graphics2D);
            m.g();
            if (z) {
                break;
            }
        }
    }
    
    public Rectangle getBounds() {
        final boolean z = fj.z;
        if (this.isEmpty()) {
            return new Rectangle(0, 0, -1, -1);
        }
        final C m = this.m();
        final Rectangle bounds = ((az)m.d()).getBounds().getBounds();
        m.g();
        Rectangle bounds2 = null;
        while (m.f()) {
            bounds2 = ((az)m.d()).getBounds();
            if (z) {
                return bounds2;
            }
            y.d.e.a(bounds2, bounds, bounds);
            m.g();
            if (z) {
                break;
            }
        }
        return bounds2;
    }
}
