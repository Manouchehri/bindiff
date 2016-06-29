/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import y.c.d;
import y.h.aB;
import y.h.aT;
import y.h.fL;
import y.h.fj;
import y.h.ij;
import y.h.x;
import y.h.z;

public class fK
implements aT {
    @Override
    public byte a(aB aB2, z z2, GeneralPath generalPath, Point2D point2D, Point2D point2D2) {
        boolean bl2 = false;
        if (!aB2.getEdge().e()) return ij.a(aB2, generalPath, point2D, point2D2);
        if (z2.isEmpty()) {
            fj fj2 = aB2.getSourceRealizer();
            aB2.appendBend(aB2.getSourcePort().a(fj2), aB2.getSourcePort().b(fj2) - 10.0 - fj2.getHeight());
        }
        if (z2.size() != 1) return ij.a(aB2, generalPath, point2D, point2D2);
        return ij.b(aB2, generalPath, point2D, point2D2);
    }
}

