package y.h.b;

import y.h.*;
import java.awt.geom.*;

class b implements br
{
    public void a(final fj fj, final Rectangle2D rectangle2D) {
        final int h = a.H;
        double n = fj.getX();
        double n2 = fj.getY();
        double width = fj.getWidth();
        double height = fj.getHeight();
        if (fj instanceof a) {
            final a a = (a)fj;
            final double a2 = y.h.b.a.a(a);
            if (width < a2) {
                width = a2;
            }
            final double b = y.h.b.a.b(a);
            if (height < b) {
                height = b;
            }
        }
        if (rectangle2D.getWidth() > 0.0 && rectangle2D.getHeight() > 0.0) {
            final double n3 = n + width;
            final double n4 = n2 + height;
            n = Math.min(n, rectangle2D.getX());
            n2 = Math.min(n2, rectangle2D.getY());
            width = Math.max(n3, rectangle2D.getMaxX()) - n;
            height = Math.max(n4, rectangle2D.getMaxY()) - n2;
        }
        rectangle2D.setFrame(n, n2, width, height);
        if (fj.labelCount() > 0) {
            int i = 0;
            while (i < fj.labelCount()) {
                fj.getLabel(i).calcUnionRect(rectangle2D);
                ++i;
                if (h != 0) {
                    return;
                }
                if (h != 0) {
                    break;
                }
            }
        }
        if (fj.portCount() > 0) {
            int j = 0;
            while (j < fj.portCount()) {
                fj.getPort(j).a(rectangle2D);
                ++j;
                if (h != 0) {
                    break;
                }
            }
        }
    }
}
