package y.h;

import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.*;

final class hy extends hx
{
    private final hz a;
    private final hw b;
    
    hy(final hw b, final hz a, final JComponent component) {
        super(b, component);
        this.b = b;
        this.a = a;
    }
    
    public void a(final MouseEvent mouseEvent, final int n) {
        this.a.a(new Rectangle2D.Double());
        final double translateX = this.b.translateX(mouseEvent.getX());
        final double translateY = this.b.translateY(mouseEvent.getY());
        final Point point = new Point();
        if (this.a.a(this.a(), translateX, translateY, point)) {
            super.a(this.a(), mouseEvent, point.x, point.y, n);
        }
    }
    
    public Cursor b() {
        return this.a().getCursor();
    }
}
