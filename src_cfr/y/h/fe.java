/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Point2D;
import javax.swing.JComponent;
import y.h.ch;
import y.h.fD;
import y.h.fj;

class fE
implements KeyListener {
    private final fD a;

    fE(fD fD2) {
        this.a = fD2;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        boolean bl2 = fj.z;
        if (!Boolean.TRUE.equals(this.a.getClientProperty("Overview.AllowKeyboardNavigation"))) {
            return;
        }
        switch (keyEvent.getKeyCode()) {
            Point2D point2D;
            case 109: {
                this.a.tc.setZoom(this.a.tc.getZoom() / 1.25);
                this.a.tc.updateView();
                if (!bl2) return;
            }
            case 107: {
                this.a.tc.setZoom(this.a.tc.getZoom() * 1.25);
                this.a.tc.updateView();
                if (!bl2) return;
            }
            case 37: {
                point2D = this.a.tc.getCenter();
                this.a.b(point2D.getX() - (double)this.a.tc.getCanvasComponent().getWidth() * 0.5 / this.a.tc.getZoom(), point2D.getY(), 0.5);
                if (!bl2) return;
            }
            case 39: {
                point2D = this.a.tc.getCenter();
                this.a.b(point2D.getX() + (double)this.a.tc.getCanvasComponent().getWidth() * 0.5 / this.a.tc.getZoom(), point2D.getY(), 0.5);
                if (!bl2) return;
            }
            case 38: {
                point2D = this.a.tc.getCenter();
                this.a.b(point2D.getX(), point2D.getY() - (double)this.a.tc.getCanvasComponent().getHeight() * 0.5 / this.a.tc.getZoom(), 0.5);
                if (!bl2) return;
            }
            case 40: {
                point2D = this.a.tc.getCenter();
                this.a.b(point2D.getX(), point2D.getY() + (double)this.a.tc.getCanvasComponent().getHeight() * 0.5 / this.a.tc.getZoom(), 0.5);
            }
        }
    }
}

