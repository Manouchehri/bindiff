package org.jfree.chart.needle;

import java.io.*;
import java.awt.geom.*;
import java.awt.*;

public class ShipNeedle extends MeterNeedle implements Serializable, Cloneable
{
    private static final long serialVersionUID = 149554868169435612L;
    
    protected void drawNeedle(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final Point2D point2D, final double n) {
        final GeneralPath generalPath = new GeneralPath();
        generalPath.append(new Arc2D.Double(-9.0, -7.0, 10.0, 14.0, 0.0, 25.5, 0), true);
        generalPath.append(new Arc2D.Double(0.0, -7.0, 10.0, 14.0, 154.5, 25.5, 0), true);
        generalPath.closePath();
        this.getTransform().setToTranslation(rectangle2D.getMinX(), rectangle2D.getMaxY());
        this.getTransform().scale(rectangle2D.getWidth(), rectangle2D.getHeight() / 3.0);
        generalPath.transform(this.getTransform());
        if (point2D != null && n != 0.0) {
            this.getTransform().setToRotation(n, point2D.getX(), point2D.getY());
            generalPath.transform(this.getTransform());
        }
        this.defaultDisplay(graphics2D, generalPath);
    }
    
    public boolean equals(final Object o) {
        return o != null && (o == this || (super.equals(o) && o instanceof ShipNeedle));
    }
    
    public Object clone() {
        return super.clone();
    }
}
