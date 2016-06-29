package y.h;

import java.awt.*;
import java.awt.geom.*;

public class eC extends gX
{
    private int a;
    private int b;
    
    public void mousePressedRight(final double n, final double n2) {
        this.a = this.originalX;
        this.b = this.originalY;
        this.view.setViewCursor(Cursor.getPredefinedCursor(13));
    }
    
    public void mouseReleasedRight(final double n, final double n2) {
        this.view.setViewCursor(Cursor.getPredefinedCursor(0));
        this.reactivateParent();
    }
    
    public void mouseDraggedRight(final double n, final double n2) {
        final double n3 = this.originalX - this.a;
        final double n4 = this.originalY - this.b;
        final Point2D center = this.view.getCenter();
        this.view.setCenter(center.getX() - n3 / this.view.getZoom(), center.getY() - n4 / this.view.getZoom());
        this.view.updateView();
        this.a = this.originalX;
        this.b = this.originalY;
    }
}
