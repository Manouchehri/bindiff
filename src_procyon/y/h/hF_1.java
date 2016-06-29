package y.h;

import java.awt.event.*;
import java.awt.geom.*;

class hF implements MouseWheelListener
{
    fD a;
    
    public hF(final fD a) {
        this.a = a;
        a.getCanvasComponent().addMouseWheelListener(this);
    }
    
    public void mouseWheelMoved(final MouseWheelEvent mouseWheelEvent) {
        final boolean z = fj.z;
        final ch tc = this.a.tc;
        final Object source = mouseWheelEvent.getSource();
        if (source instanceof bw) {
            final bw bw = (bw)source;
            if (Boolean.TRUE.equals(((ch)bw.getParent()).getClientProperty("Overview.AllowZooming"))) {
                final double c = bw.c(mouseWheelEvent.getX());
                final double d = bw.d(mouseWheelEvent.getY());
                final double zoom = tc.getZoom();
                int n = 0;
                Label_0122: {
                    if (mouseWheelEvent.getScrollType() == 1) {
                        n = mouseWheelEvent.getWheelRotation();
                        if (!z) {
                            break Label_0122;
                        }
                    }
                    if (mouseWheelEvent.getScrollType() == 0) {
                        n = mouseWheelEvent.getUnitsToScroll();
                    }
                }
                if (n != 0) {
                    final Point2D center = tc.getCenter();
                    Label_0163: {
                        if (n > 0) {
                            tc.setZoom(zoom / 1.25);
                            if (!z) {
                                break Label_0163;
                            }
                        }
                        tc.setZoom(zoom * 1.25);
                    }
                    tc.setCenter(center.getX() + c - bw.c(mouseWheelEvent.getX()), center.getY() + d - bw.d(mouseWheelEvent.getY()));
                    this.a.adjustWorldRect(tc);
                    tc.updateView();
                }
            }
        }
    }
}
