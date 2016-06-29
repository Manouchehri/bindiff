package y.f.e;

import y.d.*;
import java.awt.*;

class m implements g
{
    private final l a;
    
    m(final l a) {
        this.a = a;
    }
    
    public void a(final Object o, final Object o2) {
        final boolean b = i.b;
        final Rectangle a = ((o)o).a;
        final Rectangle a2 = ((o)o2).a;
        final Rectangle intersection = a.intersection(a2);
        if (intersection.width != 0 && intersection.height != 0) {
            boolean b2 = false;
            Label_0379: {
                if (l.b(this.a) == 0) {
                    b2 = (intersection.width < intersection.height);
                    if (!b) {
                        break Label_0379;
                    }
                }
                if (l.b(this.a) == 1) {
                    b2 = (Math.abs(a.x - a2.x + (a.width - a2.width) / 2) > Math.abs(a.y - a2.y + (a.height - a2.height) / 2));
                    if (!b) {
                        break Label_0379;
                    }
                }
                if (l.a(a, a2)) {
                    b2 = (Math.min(a2.x + a2.width - a.x, a.x + a.width - a2.x) < Math.min(a2.y + a2.height - a.y, a.y + a.height - a2.y));
                    if (!b) {
                        break Label_0379;
                    }
                }
                if (l.a(a2, a)) {
                    b2 = (Math.min(a.x + a.width - a2.x, a2.x + a2.width - a.x) < Math.min(a.y + a.height - a2.y, a2.y + a2.height - a.y));
                    if (!b) {
                        break Label_0379;
                    }
                }
                b2 = (intersection.width < intersection.height);
            }
            if (b2) {
                if (a2.x >= a.x && a2.x < a.x + a.width) {
                    final int n = (1 + a.x + a.width - a2.x) / 2;
                    if (n >= a.width || n >= a2.width) {
                        return;
                    }
                    final Rectangle rectangle = a;
                    rectangle.width -= n;
                    final Rectangle rectangle2 = a2;
                    rectangle2.x += n;
                    final Rectangle rectangle3 = a2;
                    rectangle3.width -= n;
                    if (!b) {
                        return;
                    }
                }
                if (a.x >= a2.x && a.x < a2.x + a2.width) {
                    final int n2 = (1 + a2.x + a2.width - a.x) / 2;
                    if (n2 < a.width && n2 < a2.width) {
                        final Rectangle rectangle4 = a2;
                        rectangle4.width -= n2;
                        final Rectangle rectangle5 = a;
                        rectangle5.x += n2;
                        final Rectangle rectangle6 = a;
                        rectangle6.width -= n2;
                    }
                }
            }
        }
    }
}
