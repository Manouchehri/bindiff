package y.h;

import javax.swing.*;
import java.awt.geom.*;
import java.awt.event.*;

final class fH implements ActionListener
{
    private final Timer a;
    private Point2D.Double b;
    private long c;
    private double d;
    private final fD e;
    
    public fH(final fD e) {
        this.e = e;
        this.b = new Point2D.Double(0.0, 0.0);
        (this.a = new Timer(20, this)).setRepeats(true);
        this.a.setDelay(20);
    }
    
    public void actionPerformed(final ActionEvent actionEvent) {
        final Point2D center = this.e.tc.getCenter();
        final double zoom = this.e.tc.getZoom();
        final double n = this.b.x - center.getX();
        final double n2 = this.b.y - center.getY();
        double x = center.getX() + n * this.d;
        double y = center.getY() + n2 * this.d;
        final double n3 = this.b.x - x;
        final double n4 = this.b.y - y;
        if (this.d >= 1.0 || System.currentTimeMillis() > this.c || Math.max(Math.abs(n3), Math.abs(n4)) * zoom < 5.0) {
            this.a.stop();
            x = this.b.x;
            y = this.b.y;
        }
        this.e.tc.setCenter(x, y);
        this.e.tc.updateView();
    }
    
    public void a(final double x, final double y, final double d) {
        this.b.x = x;
        this.b.y = y;
        this.d = d;
        this.c = System.currentTimeMillis() + 500L;
        if (!this.a.isRunning()) {
            this.a.start();
        }
    }
}
