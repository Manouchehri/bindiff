package y.h;

import java.util.*;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.awt.*;

final class hw extends gX implements MouseWheelListener
{
    private int b;
    private Cursor c;
    private hx d;
    private hx e;
    private gX f;
    private hA g;
    private List h;
    private boolean i;
    static Class a;
    
    public hw() {
        this((gX)null);
    }
    
    public hw(final gX f) {
        this.h = new ArrayList();
        this.f = f;
        if (this.f != null) {
            this.f.setGrabFocusEnabled(false);
        }
        this.setGrabFocusEnabled(false);
    }
    
    public void a(final JComponent component, final AffineTransform affineTransform) {
        this.h.add(new hz(component, affineTransform));
    }
    
    public void activate(final boolean b) {
        super.activate(b);
        if (b) {
            this.g = hA.a(this.view.getCanvasComponent());
            if (!fj.z) {
                return;
            }
        }
        this.d = null;
        this.e = null;
        this.c = null;
        this.b = 0;
        if (this.g != null) {
            this.g.b(this.view.getCanvasComponent());
            this.g = null;
        }
    }
    
    public void mouseMoved(final MouseEvent mouseEvent) {
        this.a(mouseEvent);
        if (this.d != null) {
            this.d.a(mouseEvent);
        }
        this.a();
        if (this.f != null && !mouseEvent.isConsumed()) {
            this.f.mouseMoved(mouseEvent);
        }
    }
    
    public void mouseReleased(final MouseEvent mouseEvent) {
        this.a(mouseEvent);
        if (this.b > 0) {
            if (this.e != null) {
                this.e.a(mouseEvent);
            }
            --this.b;
            if (this.b == 0) {
                this.e = null;
            }
        }
        this.a();
        if (this.f != null && !mouseEvent.isConsumed()) {
            this.f.mouseReleased(mouseEvent);
        }
    }
    
    public void mouseDragged(final MouseEvent mouseEvent) {
        this.a(mouseEvent);
        if (this.e != null) {
            this.e.a(mouseEvent);
        }
        this.a();
        if (this.f != null && !mouseEvent.isConsumed()) {
            this.f.mouseDragged(mouseEvent);
        }
    }
    
    public void mousePressed(final MouseEvent mouseEvent) {
        this.a(mouseEvent);
        if (this.d != null) {
            if (this.b == 0) {
                this.e = this.d;
            }
            ++this.b;
            this.e.a(mouseEvent);
        }
        this.a();
        if (this.f != null && !mouseEvent.isConsumed()) {
            this.f.mousePressed(mouseEvent);
        }
    }
    
    public void mouseClicked(final MouseEvent mouseEvent) {
        this.a(mouseEvent);
        Label_0041: {
            if (this.e != null) {
                this.e.a(mouseEvent);
                if (!fj.z) {
                    break Label_0041;
                }
            }
            if (this.d != null) {
                this.d.a(mouseEvent);
            }
        }
        this.a();
        if (this.f != null && !mouseEvent.isConsumed()) {
            this.f.mouseClicked(mouseEvent);
        }
    }
    
    public void mouseEntered(final MouseEvent mouseEvent) {
        this.a(mouseEvent);
        this.a();
        if (this.f != null) {
            this.f.mouseEntered(mouseEvent);
        }
    }
    
    public void mouseExited(final MouseEvent mouseEvent) {
        if (!this.i) {
            if (this.d != null) {
                this.d.a(mouseEvent);
                this.view.setToolTipText(null);
                this.d = null;
            }
            this.a();
            if (this.f != null) {
                this.f.mouseExited(mouseEvent);
            }
        }
    }
    
    private void a() {
        final boolean z = fj.z;
        Cursor cursor = null;
        Label_0044: {
            if (this.e != null) {
                cursor = this.e.b();
                if (!z) {
                    break Label_0044;
                }
            }
            if (this.d != null) {
                cursor = this.d.b();
                if (!z) {
                    break Label_0044;
                }
            }
            cursor = null;
        }
        if (cursor != this.c) {
            this.view.setViewCursor(cursor);
            this.c = cursor;
        }
    }
    
    private hx a(final MouseEvent mouseEvent, final hx hx) {
        final boolean z = fj.z;
        if (!this.h.isEmpty()) {
            int i = 0;
            while (i < this.h.size()) {
                final hz hz = this.h.get(i);
                final JComponent a = hz.a(this.translateX(mouseEvent.getX()), this.translateY(mouseEvent.getY()));
                if (a != null) {
                    if (hx instanceof hy && hx.a() == a) {
                        return hx;
                    }
                    return new hy(this, hz, a);
                }
                else {
                    ++i;
                    if (z) {
                        break;
                    }
                    continue;
                }
            }
        }
        return null;
    }
    
    static final JComponent a(final JComponent component, int n, int n2) {
        final boolean z = fj.z;
        JComponent component2 = component;
        while (true) {
            final Component component3 = component2.getComponentAt(n, n2);
            int n3;
            if (component2 == component3) {
                final boolean b = (n3 = ((component2 instanceof JComponent) ? 1 : 0)) != 0;
                if (!z) {
                    if (b) {
                        return component2;
                    }
                    return null;
                }
            }
            else {
                if (component3 == null) {
                    return null;
                }
                n -= component3.getX();
                n3 = n2 - component3.getY();
            }
            n2 = n3;
            component2 = (JComponent)component3;
        }
    }
    
    private void a(final MouseEvent mouseEvent) {
        final hx a = this.a(mouseEvent, this.d);
        if (a != this.d) {
            if (this.d != null) {
                this.d.a(mouseEvent, 505);
            }
            this.view.setToolTipText(null);
            this.d = a;
            if (this.d != null) {
                this.d.a(mouseEvent, 504);
            }
        }
    }
    
    public void mouseWheelMoved(final MouseWheelEvent mouseWheelEvent) {
        if (!this.i && this.d != null) {
            this.d.a(mouseWheelEvent);
        }
    }
    
    public void setActiveView(final ch ch) {
        super.setActiveView(ch);
        if (this.f != null) {
            this.f.setActiveView(ch);
        }
    }
    
    protected void a(final Component component, final MouseEvent mouseEvent, final int n, final int n2, final int n3) {
        final boolean i = this.i;
        this.i = true;
        try {
            MouseEvent mouseEvent2 = null;
            Label_0107: {
                if (mouseEvent instanceof MouseWheelEvent) {
                    final MouseWheelEvent mouseWheelEvent = (MouseWheelEvent)mouseEvent;
                    mouseEvent2 = new MouseWheelEvent(component, n3, mouseEvent.getWhen(), mouseEvent.getModifiers(), n, n2, mouseEvent.getClickCount(), mouseEvent.isPopupTrigger(), mouseWheelEvent.getScrollType(), mouseWheelEvent.getScrollAmount(), mouseWheelEvent.getWheelRotation());
                    if (!fj.z) {
                        break Label_0107;
                    }
                }
                mouseEvent2 = new MouseEvent(component, n3, mouseEvent.getWhen(), mouseEvent.getModifiers(), n, n2, mouseEvent.getClickCount(), mouseEvent.isPopupTrigger());
            }
            component.dispatchEvent(mouseEvent2);
            if ((n3 == 503 || n3 == 504) && component instanceof JComponent) {
                this.view.setToolTipText(((JComponent)component).getToolTipText(mouseEvent2));
            }
            if (mouseEvent2.isConsumed() && !mouseEvent.isConsumed()) {
                mouseEvent.consume();
            }
        }
        finally {
            this.i = i;
        }
    }
    
    static Class a(final String s) {
        try {
            return Class.forName(s);
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
}
