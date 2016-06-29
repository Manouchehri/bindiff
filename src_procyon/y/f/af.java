package y.f;

import java.util.*;
import java.awt.geom.*;
import y.g.*;

class af implements Comparator
{
    public int compare(final Object o, final Object o2) {
        final Rectangle2D rectangle2D = (Rectangle2D)o;
        final Rectangle2D rectangle2D2 = (Rectangle2D)o2;
        final int a = e.a((int)rectangle2D2.getHeight(), (int)rectangle2D.getHeight());
        if (a == 0) {
            return e.a((int)rectangle2D2.getWidth(), (int)rectangle2D.getWidth());
        }
        return a;
    }
}
