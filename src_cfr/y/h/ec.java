/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Cursor;
import java.awt.geom.Point2D;
import y.h.ch;
import y.h.gX;

public class eC
extends gX {
    private int a;
    private int b;

    @Override
    public void mousePressedRight(double d2, double d3) {
        this.a = this.originalX;
        this.b = this.originalY;
        this.view.setViewCursor(Cursor.getPredefinedCursor(13));
    }

    @Override
    public void mouseReleasedRight(double d2, double d3) {
        this.view.setViewCursor(Cursor.getPredefinedCursor(0));
        this.reactivateParent();
    }

    @Override
    public void mouseDraggedRight(double d2, double d3) {
        double d4 = this.originalX - this.a;
        double d5 = this.originalY - this.b;
        Point2D point2D = this.view.getCenter();
        this.view.setCenter(point2D.getX() - d4 / this.view.getZoom(), point2D.getY() - d5 / this.view.getZoom());
        this.view.updateView();
        this.a = this.originalX;
        this.b = this.originalY;
    }
}

