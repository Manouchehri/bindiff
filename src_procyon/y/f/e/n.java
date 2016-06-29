package y.f.e;

import java.util.*;
import y.c.*;
import y.g.*;
import java.awt.*;

final class n implements Comparator, g
{
    private final l a;
    
    n(final l a) {
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        final q q = (q)o;
        final Rectangle rectangle = l.a(this.a)[q.d()];
        final q q2 = (q)o2;
        final Rectangle rectangle2 = l.a(this.a)[q2.d()];
        final boolean a = l.a(this.a, q);
        if (a == l.a(this.a, q2) || rectangle.x > rectangle2.x + rectangle2.width || rectangle.x + rectangle.width < rectangle2.x) {
            final int a2 = e.a(rectangle.y + rectangle.height * 0.5, rectangle2.y + rectangle2.height * 0.5);
            if (a2 != 0) {
                return a2;
            }
            return e.a(((q)o2).d(), ((q)o).d());
        }
        else {
            if (a) {
                return (rectangle2.y + rectangle2.height < rectangle.y) ? 1 : -1;
            }
            return (rectangle.y + rectangle.height < rectangle2.y) ? -1 : 1;
        }
    }
}
