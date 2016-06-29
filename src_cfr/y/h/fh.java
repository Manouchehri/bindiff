/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import javax.swing.Timer;
import y.h.ch;
import y.h.fD;

final class fH
implements ActionListener {
    private final Timer a;
    private Point2D.Double b;
    private long c;
    private double d;
    private final fD e;

    public fH(fD fD2) {
        this.e = fD2;
        this.b = new Point2D.Double(0.0, 0.0);
        this.a = new Timer(20, this);
        this.a.setRepeats(true);
        this.a.setDelay(20);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Point2D point2D = this.e.tc.getCenter();
        double d2 = this.e.tc.getZoom();
        double d3 = this.b.x - point2D.getX();
        double d4 = this.b.y - point2D.getY();
        double d5 = point2D.getX() + d3 * this.d;
        double d6 = point2D.getY() + d4 * this.d;
        d3 = this.b.x - d5;
        d4 = this.b.y - d6;
        if (this.d >= 1.0 || System.currentTimeMillis() > this.c || Math.max(Math.abs(d3), Math.abs(d4)) * d2 < 5.0) {
            this.a.stop();
            d5 = this.b.x;
            d6 = this.b.y;
        }
        this.e.tc.setCenter(d5, d6);
        this.e.tc.updateView();
    }

    public void a(double d2, double d3, double d4) {
        this.b.x = d2;
        this.b.y = d3;
        this.d = d4;
        this.c = System.currentTimeMillis() + 500;
        if (this.a.isRunning()) return;
        this.a.start();
    }
}

