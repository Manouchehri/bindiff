/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import javax.swing.JComponent;
import y.h.ch;
import y.h.fD;
import y.h.fF;
import y.h.fj;
import y.h.gU;
import y.h.gX;

class fG
extends gX {
    double a;
    double b;
    double c;
    double d;
    boolean e;
    double f;
    double g;
    boolean h;
    boolean i;
    private final fD j;

    public fG(fD fD2, gU gU2) {
        super(gU2);
        this.j = fD2;
    }

    @Override
    public void mouseClicked(double d2, double d3) {
        if (this.i) return;
        this.j.b(d2, d3, 0.5);
    }

    @Override
    public void mousePressedLeft(double d2, double d3) {
        if (!this.j.wc.a(d2, d3)) {
            return;
        }
        this.a = d2;
        this.b = d3;
        this.c = this.j.tc.getCenter().getX();
        this.d = this.j.tc.getCenter().getY();
        this.e = true;
    }

    @Override
    public void mouseDraggedLeft(double d2, double d3) {
        if (!this.e) return;
        this.j.b(this.c + (d2 - this.a), this.d + (d3 - this.b), 1.0);
    }

    @Override
    public void mouseReleasedLeft(double d2, double d3) {
        this.e = false;
        this.h = false;
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        boolean bl2 = fj.z;
        this.i = false;
        if (Boolean.TRUE.equals(this.j.getClientProperty("Overview.AllowZooming"))) {
            int n2 = this.j.toViewCoordX(fF.a(this.j.wc).getMaxX());
            int n3 = this.j.toViewCoordY(fF.a(this.j.wc).getMaxY());
            if (Math.abs(n2 - mouseEvent.getX()) < 3 && Math.abs(n3 - mouseEvent.getY()) < 3) {
                this.h = true;
                this.f = this.j.tc.getCenter().getX();
                this.g = this.j.tc.getCenter().getY();
                if (!bl2) return;
            }
            this.h = false;
            super.mousePressed(mouseEvent);
            if (!bl2) return;
        }
        super.mousePressed(mouseEvent);
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        this.i = true;
        if (this.h) {
            double d2;
            double d3 = this.j.toWorldCoordX(mouseEvent.getX());
            double d4 = this.j.toWorldCoordY(mouseEvent.getY());
            double d5 = Math.abs(this.f - d3) * 2.0;
            double d6 = Math.abs(this.g - d4) * 2.0;
            double d7 = (double)this.j.tc.getCanvasComponent().getWidth() / d5;
            double d8 = Math.min(d7, d2 = (double)this.j.tc.getCanvasComponent().getHeight() / d6);
            if (d8 == this.j.tc.getZoom()) return;
            this.j.tc.setZoom(d8);
            this.j.tc.setCenter(this.f, this.g);
            this.j.tc.updateView();
            if (!fj.z) return;
        }
        super.mouseDragged(mouseEvent);
    }
}

