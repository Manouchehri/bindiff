package y.h;

import java.awt.event.*;
import java.awt.geom.*;

class fE implements KeyListener
{
    private final fD a;
    
    fE(final fD a) {
        this.a = a;
    }
    
    public void keyTyped(final KeyEvent keyEvent) {
    }
    
    public void keyReleased(final KeyEvent keyEvent) {
    }
    
    public void keyPressed(final KeyEvent keyEvent) {
        final boolean z = fj.z;
        if (!Boolean.TRUE.equals(this.a.getClientProperty("Overview.AllowKeyboardNavigation"))) {
            return;
        }
        Label_0349: {
            switch (keyEvent.getKeyCode()) {
                case 109: {
                    this.a.tc.setZoom(this.a.tc.getZoom() / 1.25);
                    this.a.tc.updateView();
                    if (z) {
                        break Label_0349;
                    }
                    break;
                }
                case 107: {
                    this.a.tc.setZoom(this.a.tc.getZoom() * 1.25);
                    this.a.tc.updateView();
                    if (z) {
                        break Label_0349;
                    }
                    break;
                }
                case 37: {
                    final Point2D center = this.a.tc.getCenter();
                    this.a.b(center.getX() - this.a.tc.getCanvasComponent().getWidth() * 0.5 / this.a.tc.getZoom(), center.getY(), 0.5);
                    if (z) {
                        break Label_0349;
                    }
                    break;
                }
                case 39: {
                    final Point2D center2 = this.a.tc.getCenter();
                    this.a.b(center2.getX() + this.a.tc.getCanvasComponent().getWidth() * 0.5 / this.a.tc.getZoom(), center2.getY(), 0.5);
                    if (z) {
                        break Label_0349;
                    }
                    break;
                }
                case 38: {
                    final Point2D center3 = this.a.tc.getCenter();
                    this.a.b(center3.getX(), center3.getY() - this.a.tc.getCanvasComponent().getHeight() * 0.5 / this.a.tc.getZoom(), 0.5);
                    if (z) {
                        break Label_0349;
                    }
                    break;
                }
                case 40: {
                    final Point2D center4 = this.a.tc.getCenter();
                    this.a.b(center4.getX(), center4.getY() + this.a.tc.getCanvasComponent().getHeight() * 0.5 / this.a.tc.getZoom(), 0.5);
                    break;
                }
            }
        }
    }
}
