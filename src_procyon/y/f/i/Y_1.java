package y.f.i;

import java.util.*;
import java.awt.geom.*;
import y.g.*;

class Y implements Comparator
{
    private final X a;
    
    Y(final X a) {
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        final Rectangle2D.Double double1 = (Rectangle2D.Double)o;
        final Rectangle2D.Double double2 = (Rectangle2D.Double)o2;
        final int a = e.a(double1.y, double2.y);
        if (a != 0) {
            return a;
        }
        return e.a(double1.x, double2.x);
    }
}
