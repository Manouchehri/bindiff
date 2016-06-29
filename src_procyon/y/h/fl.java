package y.h;

import y.c.*;
import java.awt.geom.*;
import y.f.*;
import y.d.*;

final class fl implements P
{
    private bu e;
    private boolean f;
    private boolean g;
    d c;
    Point2D.Double d;
    
    fl(final bu e, final boolean g, final boolean f) {
        this.d = new Point2D.Double();
        this.e = e;
        this.f = f;
        this.g = g;
    }
    
    public t a(final am am, final double n, final double n2, final double n3, final double n4) {
        final boolean z = fj.z;
        fj fj = null;
        Label_0049: {
            if (this.f) {
                fj = this.e.t(this.c.c());
                if (!z) {
                    break Label_0049;
                }
            }
            fj = this.e.t(this.c.d());
        }
        final double centerX = fj.getCenterX();
        final double centerY = fj.getCenterY();
        if (fj.contains(centerX + n, centerY + n2)) {
            return null;
        }
        if (fj.getWidth() != am.getWidth() || fj.getHeight() != am.getHeight()) {
            return null;
        }
        double n5 = centerX + n - n3 * 5.0;
        double n6 = centerY + n2 - n4 * 5.0;
        final double n7 = 10.0 + Math.max(fj.getWidth(), fj.getHeight());
        double n8 = centerX;
        double n9 = centerY;
        double n10 = 0.0;
        while (true) {
            while (n10 < n7 * 2.0) {
                final double n11 = n5 + n3 * n10;
                final double n12 = n6 + n4 * n10;
                final boolean contains = fj.contains(n11, n12);
                if (!z) {
                    if (contains) {
                        n8 = n11;
                        n9 = n12;
                        n5 = n8 - n3 * 2.0;
                        n6 = n9 - n4 * 2.0;
                        if (!z) {
                            break;
                        }
                    }
                    ++n10;
                    if (z) {
                        break;
                    }
                    continue;
                }
                else if (contains) {
                    if (fj.findIntersection(n8, n9, n5, n6, this.d)) {
                        return new t(this.d.x - centerX, this.d.y - centerY);
                    }
                    return new t(n, n2);
                }
                else {
                    if (!this.g) {
                        return null;
                    }
                    if (fj.findIntersection(centerX, centerY, centerX + n, centerY + n2, this.d)) {
                        return new t(this.d.x - centerX, this.d.y - centerY);
                    }
                    return new t(n, n2);
                }
            }
            continue;
        }
    }
}
