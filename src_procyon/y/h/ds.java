package y.h;

import javax.swing.*;
import y.d.*;
import java.awt.geom.*;
import java.awt.event.*;

public class ds extends gX
{
    private dv a;
    private double b;
    private int c;
    private MouseWheelListener[] d;
    private MouseWheelListener e;
    private boolean f;
    private ch g;
    
    public ds() {
        this.b = 2.0;
        this.c = 100;
        this.f = true;
        this.setName("NAVIGATION_MAGNIFIER");
    }
    
    public void mouseMoved(final double n, final double n2) {
        this.a(n, n2);
    }
    
    public void mouseDraggedLeft(final double n, final double n2) {
        this.a(n, n2);
    }
    
    public void mouseDraggedRight(final double n, final double n2) {
        this.a(n, n2);
    }
    
    public void mouseExited(final MouseEvent mouseEvent) {
        super.mouseExited(mouseEvent);
        if (this.a != null) {
            this.view.removeDrawable(this.a);
            this.a = null;
            this.view.updateView();
        }
    }
    
    protected ch a() {
        final ch ch = new ch(this.getGraph2D());
        ch.setAntialiasedPainting(this.view.isAntialiasedPainting());
        ch.setGridVisible(this.view.isGridVisible());
        ch.setGridResolution(this.view.getGridResolution());
        ch.setGridColor(this.view.getGridColor());
        ch.setGridType(this.view.getGridType());
        ch.setGraph2DRenderer(this.view.getGraph2DRenderer());
        ch.setPaintDetailThreshold(0.0);
        ch.setBackgroundRenderer(new du(ch, this.view));
        return ch;
    }
    
    public void activate(final boolean b) {
        final boolean z = fj.z;
        if (b) {
            final JComponent canvasComponent = this.view.getCanvasComponent();
            Label_0086: {
                if (this.f) {
                    this.d = canvasComponent.getMouseWheelListeners();
                    int i = 0;
                    while (true) {
                        while (i < this.d.length) {
                            canvasComponent.removeMouseWheelListener(this.d[i]);
                            ++i;
                            if (z) {
                                canvasComponent.addMouseWheelListener(this.e);
                                break Label_0086;
                            }
                            if (z) {
                                break;
                            }
                        }
                        this.e = new dt(this);
                        continue;
                    }
                }
            }
            this.setEditing(true);
            if (!z) {
                return;
            }
        }
        this.setEditing(false);
        this.view.removeDrawable(this.a);
        this.a = null;
        this.getGraph2D().c(this.g);
        this.g = null;
        final JComponent canvasComponent2 = this.view.getCanvasComponent();
        if (this.f) {
            if (this.e != null) {
                canvasComponent2.removeMouseWheelListener(this.e);
                this.e = null;
            }
            int j = 0;
            while (j < this.d.length) {
                canvasComponent2.addMouseWheelListener(this.d[j]);
                ++j;
                if (z) {
                    return;
                }
                if (z) {
                    break;
                }
            }
        }
        this.view.updateView();
    }
    
    private void a(final double n, final double n2) {
        if (!this.isEditing()) {
            this.setEditing(true);
        }
        if (this.a == null) {
            this.g = this.a();
            (this.a = new dv(this, this.g)).a(this.b);
            this.a.a(this.c);
            this.view.addDrawable(this.a);
            this.a.a(new t(n, n2));
        }
        final Rectangle2D a = this.a.a();
        this.a.a(new t(n, n2));
        a.add(this.a.a());
        final double n3 = 5.0 / this.view.getZoom();
        a.setFrame(a.getX() - n3, a.getY() - n3, a.getWidth() + 2.0 * n3, a.getHeight() + 2.0 * n3);
        this.view.updateView(a);
    }
    
    public void a(final double b) {
        if (this.b != b) {
            this.b = b;
            if (this.a != null) {
                this.a.a(b);
                this.view.updateView();
            }
        }
    }
    
    public void a(final int c) {
        if (c != this.c) {
            this.c = c;
            if (this.a != null) {
                this.a.a(this.c);
                this.view.updateView();
            }
        }
    }
    
    public void a(final MouseWheelEvent mouseWheelEvent) {
        final boolean z = fj.z;
        int n = 0;
        Label_0037: {
            if (mouseWheelEvent.getScrollType() == 1) {
                n = mouseWheelEvent.getWheelRotation();
                if (!z) {
                    break Label_0037;
                }
            }
            if (mouseWheelEvent.getScrollType() == 0) {
                n = mouseWheelEvent.getUnitsToScroll();
            }
        }
        if (n != 0) {
            if ((mouseWheelEvent.getModifiers() & 0x2) == 0x0) {
                this.a(this.a(this.b, n));
                if (!z) {
                    return;
                }
            }
            this.a(this.a(this.c, n));
        }
    }
    
    protected int a(final int n, final int n2) {
        final int n3 = 10;
        if (n2 == 0) {
            return n;
        }
        return Math.max(n3, n + n2 * n3);
    }
    
    protected double a(final double n, final int n2) {
        if (n2 == 0) {
            return n;
        }
        return Math.max(1.0, (n2 > 0) ? (n / 1.25) : (n * 1.25));
    }
    
    static dv a(final ds ds) {
        return ds.a;
    }
}
