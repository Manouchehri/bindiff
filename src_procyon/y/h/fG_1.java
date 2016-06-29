package y.h;

import java.awt.event.*;

class fG extends gX
{
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
    
    public fG(final fD j, final gU gu) {
        super(gu);
        this.j = j;
    }
    
    public void mouseClicked(final double n, final double n2) {
        if (!this.i) {
            this.j.b(n, n2, 0.5);
        }
    }
    
    public void mousePressedLeft(final double a, final double b) {
        if (!this.j.wc.a(a, b)) {
            return;
        }
        this.a = a;
        this.b = b;
        this.c = this.j.tc.getCenter().getX();
        this.d = this.j.tc.getCenter().getY();
        this.e = true;
    }
    
    public void mouseDraggedLeft(final double n, final double n2) {
        if (this.e) {
            this.j.b(this.c + (n - this.a), this.d + (n2 - this.b), 1.0);
        }
    }
    
    public void mouseReleasedLeft(final double n, final double n2) {
        this.e = false;
        this.h = false;
    }
    
    public void mousePressed(final MouseEvent mouseEvent) {
        final boolean z = fj.z;
        this.i = false;
        if (Boolean.TRUE.equals(this.j.getClientProperty("Overview.AllowZooming"))) {
            final int viewCoordX = this.j.toViewCoordX(fF.a(this.j.wc).getMaxX());
            final int viewCoordY = this.j.toViewCoordY(fF.a(this.j.wc).getMaxY());
            if (Math.abs(viewCoordX - mouseEvent.getX()) < 3 && Math.abs(viewCoordY - mouseEvent.getY()) < 3) {
                this.h = true;
                this.f = this.j.tc.getCenter().getX();
                this.g = this.j.tc.getCenter().getY();
                if (!z) {
                    return;
                }
            }
            this.h = false;
            super.mousePressed(mouseEvent);
            if (!z) {
                return;
            }
        }
        super.mousePressed(mouseEvent);
    }
    
    public void mouseDragged(final MouseEvent mouseEvent) {
        this.i = true;
        if (this.h) {
            final double min = Math.min(this.j.tc.getCanvasComponent().getWidth() / (Math.abs(this.f - this.j.toWorldCoordX(mouseEvent.getX())) * 2.0), this.j.tc.getCanvasComponent().getHeight() / (Math.abs(this.g - this.j.toWorldCoordY(mouseEvent.getY())) * 2.0));
            if (min == this.j.tc.getZoom()) {
                return;
            }
            this.j.tc.setZoom(min);
            this.j.tc.setCenter(this.f, this.g);
            this.j.tc.updateView();
            if (!fj.z) {
                return;
            }
        }
        super.mouseDragged(mouseEvent);
    }
}
