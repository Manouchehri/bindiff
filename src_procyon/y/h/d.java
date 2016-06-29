package y.h;

import java.awt.geom.*;
import java.awt.*;

public abstract class d extends gX
{
    private Point2D.Double lm;
    private Rectangle2D.Double mm;
    
    public d(final gU gu) {
        super(gu);
        this.lm = new Point2D.Double();
        this.mm = new Rectangle2D.Double();
    }
    
    public d() {
        this.lm = new Point2D.Double();
        this.mm = new Rectangle2D.Double();
    }
    
    public void mousePressedLeft(final double n, final double n2) {
        this.n(n, n2);
    }
    
    void n(final double n, final double n2) {
        this.lm = new Point2D.Double(n, n2);
        this.mm = new Rectangle2D.Double(n, n2, 0.0, 0.0);
        this.view.setDrawingMode(2);
        this.view.setSelectionBoxBounds2D(this.mm);
        this.setEditing(true);
    }
    
    public void cancelEditing() {
        if (this.isEditing()) {
            this.view.setDrawingMode(0);
            this.view.updateView();
            this.setEditing(false);
            this.reactivateParent();
        }
    }
    
    public void mouseShiftPressedLeft(final double n, final double n2) {
        this.n(n, n2);
    }
    
    public void mouseDraggedLeft(final double n, final double n2) {
        this.updateDoubleSelectionBox(n, n2);
        this.view.setSelectionBoxBounds2D(this.mm);
        this.view.updateView();
    }
    
    public void mouseReleasedLeft(final double n, final double n2) {
        this.view.setDrawingMode(0);
        this.selectionBoxAction(new Rectangle2D.Double(this.mm.x, this.mm.y, this.mm.width, this.mm.height), false);
        this.setEditing(false);
        this.reactivateParent();
    }
    
    public void mouseShiftReleasedLeft(final double n, final double n2) {
        this.view.setDrawingMode(0);
        this.selectionBoxAction(new Rectangle2D.Double(this.mm.x, this.mm.y, this.mm.width, this.mm.height), true);
        this.setEditing(false);
        this.reactivateParent();
    }
    
    public void mouseReleasedRight(final double n, final double n2) {
        this.mouseReleasedLeft(n, n2);
    }
    
    protected Rectangle2D.Double updateDoubleSelectionBox(final double x, final double y) {
        final boolean z = fj.z;
        final Rectangle2D.Double mm = this.mm;
        Label_0090: {
            if (x < this.lm.x) {
                mm.width = this.lm.x - x;
                mm.x = x;
                if (!z) {
                    break Label_0090;
                }
            }
            if (mm.x < this.lm.x) {
                mm.x = this.lm.x;
            }
            mm.width = x - this.lm.x;
        }
        if (y < this.lm.y) {
            mm.height = this.lm.y - y;
            mm.y = y;
            if (!z) {
                return mm;
            }
        }
        if (mm.y < this.lm.y) {
            mm.y = this.lm.y;
        }
        mm.height = y - this.lm.y;
        return mm;
    }
    
    protected abstract void selectionBoxAction(final Rectangle p0, final boolean p1);
    
    protected void selectionBoxAction(final Rectangle2D.Double double1, final boolean b) {
        this.selectionBoxAction(new Rectangle((int)double1.x, (int)double1.y, (int)double1.width, (int)double1.height), b);
    }
}
