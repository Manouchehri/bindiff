package y.h;

import java.awt.geom.*;

public class fK implements aT
{
    public byte a(final aB ab, final z z, final GeneralPath generalPath, final Point2D point2D, final Point2D point2D2) {
        int n = 0;
        if (ab.getEdge().e()) {
            if (z.isEmpty()) {
                final fj sourceRealizer = ab.getSourceRealizer();
                ab.appendBend(ab.getSourcePort().a(sourceRealizer), ab.getSourcePort().b(sourceRealizer) - 10.0 - sourceRealizer.getHeight());
            }
            n = ((z.size() == 1) ? 1 : 0);
        }
        if (n != 0) {
            return ij.b(ab, generalPath, point2D, point2D2);
        }
        return ij.a(ab, generalPath, point2D, point2D2);
    }
}
