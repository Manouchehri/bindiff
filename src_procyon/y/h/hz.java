package y.h;

import javax.swing.*;
import java.awt.geom.*;
import java.awt.*;

final class hz
{
    private JComponent a;
    private AffineTransform b;
    
    public hz(final JComponent a, final AffineTransform b) {
        (this.a = a).putClientProperty("FloatingJComponent.Instance", this);
        this.b = b;
    }
    
    public void a(final Rectangle2D.Double double1) {
        this.a(new Rectangle2D.Double(0.0, 0.0, this.a.getWidth(), this.a.getHeight()), double1);
    }
    
    public void a(final Rectangle2D rectangle2D, final Rectangle2D rectangle2D2) {
        final double[] array = new double[8];
        array[0] = (array[2] = rectangle2D.getX());
        array[1] = (array[5] = rectangle2D.getY());
        array[3] = (array[7] = rectangle2D.getMaxY());
        array[4] = (array[6] = rectangle2D.getMaxX());
        this.b.transform(array, 0, array, 0, 4);
        final double max = Math.max(Math.max(array[0], array[2]), Math.max(array[4], array[6]));
        final double min = Math.min(Math.min(array[0], array[2]), Math.min(array[4], array[6]));
        final double max2 = Math.max(Math.max(array[1], array[3]), Math.max(array[5], array[7]));
        final double min2 = Math.min(Math.min(array[1], array[3]), Math.min(array[5], array[7]));
        rectangle2D2.setFrame(min, min2, max - min, max2 - min2);
    }
    
    public JComponent a(final double n, final double n2) {
        final double[] array = { n, n2 };
        try {
            this.b.inverseTransform(array, 0, array, 0, 1);
        }
        catch (NoninvertibleTransformException ex) {
            return null;
        }
        final int n3 = (int)array[0];
        final int n4 = (int)array[1];
        if (n3 >= 0 && n4 >= 0 && n3 < this.a.getWidth() && n4 < this.a.getHeight()) {
            return hw.a(this.a, n3, n4);
        }
        return null;
    }
    
    public boolean a(final JComponent component, final double n, final double n2, final Point point) {
        final boolean z = fj.z;
        final double[] array = { n, n2 };
        try {
            this.b.inverseTransform(array, 0, array, 0, 1);
        }
        catch (NoninvertibleTransformException ex) {
            return false;
        }
        int x = (int)array[0];
        int y = (int)array[1];
        Container parent = component;
        JComponent component2 = null;
        Label_0110: {
            while (parent != this.a) {
                component2 = (JComponent)parent;
                if (z || component2 == null) {
                    break Label_0110;
                }
                x -= parent.getX();
                y -= parent.getY();
                parent = parent.getParent();
                if (z) {
                    goto Label_0108;
                }
            }
            goto Label_0108;
        }
        if (component2 == null) {
            return false;
        }
        point.x = x;
        point.y = y;
        return true;
    }
}
