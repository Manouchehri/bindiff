package y.h;

import java.util.*;
import y.d.*;
import java.awt.geom.*;

class cr implements Comparator
{
    private final AffineTransform a;
    private final double[] b;
    private final double[] c;
    private final t d;
    private final cm e;
    
    cr(final cm e, final AffineTransform a, final double[] b, final double[] c, final t d) {
        this.e = e;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public int compare(final Object o, final Object o2) {
        final boolean z = fj.z;
        final GeneralPath generalPath = (GeneralPath)o;
        final GeneralPath generalPath2 = (GeneralPath)o2;
        final PathIterator pathIterator = generalPath.getPathIterator(this.a, 1.0);
        final PathIterator pathIterator2 = generalPath2.getPathIterator(this.a, 1.0);
        while (true) {
            while (!pathIterator.isDone()) {
                final boolean done = pathIterator2.isDone();
                if (!z) {
                    if (done) {
                        return -1;
                    }
                    pathIterator.currentSegment(this.b);
                    pathIterator2.currentSegment(this.c);
                    final double a = cm.a(this.e, this.b[0], this.b[1], this.d.a, this.d.b);
                    final double a2 = cm.a(this.e, this.c[0], this.c[1], this.d.a, this.d.b);
                    if (a < a2) {
                        return -1;
                    }
                    if (a > a2) {
                        return 1;
                    }
                    pathIterator.next();
                    pathIterator2.next();
                    if (z) {
                        break;
                    }
                    continue;
                }
                else {
                    if (!done) {
                        return 1;
                    }
                    return 0;
                }
            }
            pathIterator2.isDone();
            continue;
        }
    }
}
