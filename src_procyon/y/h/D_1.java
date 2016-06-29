package y.h;

import javax.swing.event.*;
import java.beans.*;
import y.c.*;
import java.util.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.*;
import java.applet.*;
import javax.swing.*;

public class D extends gX
{
    private final c a;
    private final b b;
    private eQ c;
    private fj d;
    private JComponent e;
    private final CellEditorListener f;
    private hw g;
    private ia h;
    private PropertyChangeListener i;
    
    public boolean a(final q q, final EventObject eventObject) {
        if (!this.a(q) || (this.a() && !this.e())) {
            return false;
        }
        final fj t = this.getGraph2D().t(q);
        final eQ c = this.c(q);
        if (c != null && (eventObject == null || c.isCellEditable(eventObject))) {
            this.a(t, c);
            if (eventObject instanceof MouseEvent && ((MouseEvent)eventObject).getID() == 500 && this.g != null && this.a()) {
                this.g.mouseClicked((MouseEvent)eventObject);
            }
            return true;
        }
        return false;
    }
    
    public boolean a(final q q) {
        return this.c(q) != null;
    }
    
    private void b(final MouseEvent mouseEvent) {
        if (!this.a()) {
            if (!this.a(mouseEvent)) {
                return;
            }
            final cW hitInfo = this.getHitInfo(mouseEvent);
            if (hitInfo.i() == null) {
                return;
            }
            this.a(hitInfo.i(), mouseEvent);
            if (!fj.z) {
                return;
            }
        }
        this.a(KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner());
        if (this.a() && mouseEvent.getID() == 501) {
            final q i = this.getHitInfo(mouseEvent).i();
            if ((i == null || i != this.d.getNode()) && !this.e()) {
                this.c();
            }
        }
    }
    
    public Object b(final q q) {
        return this.b.b(this.d.getNode());
    }
    
    protected boolean a(final MouseEvent mouseEvent) {
        return mouseEvent.getID() == 500 && mouseEvent.getClickCount() == 2;
    }
    
    public eQ c(final q q) {
        final Object o = (this.a != null) ? this.a.b(q) : null;
        return (o instanceof eQ) ? ((eQ)o) : null;
    }
    
    public boolean a() {
        return this.c != null;
    }
    
    public void a(final fj d, final eQ c) {
        if (this.a() && !this.e()) {
            this.c();
        }
        if (!this.a()) {
            this.c = c;
            this.d = d;
            c.addCellEditorListener(this.f);
            this.a(c.a(this.view, d, this.b(d.getNode()), d.isSelected()), d);
        }
    }
    
    public void c() {
        if (this.c != null) {
            this.c.cancelCellEditing();
        }
    }
    
    public boolean e() {
        return this.c == null || this.c.stopCellEditing();
    }
    
    public void mouseMoved(final MouseEvent mouseEvent) {
        if (this.g != null) {
            this.g.mouseMoved(mouseEvent);
        }
    }
    
    private void c(final MouseEvent mouseEvent) {
        if (mouseEvent.getID() == 501) {
            final q i = this.getHitInfo(mouseEvent).i();
            if ((i == null || i != this.d.getNode()) && !this.e()) {
                this.c();
            }
        }
    }
    
    public void mouseReleased(final MouseEvent mouseEvent) {
        if (this.g != null) {
            this.g.mouseReleased(mouseEvent);
            this.c(mouseEvent);
            if (!fj.z) {
                return;
            }
        }
        this.b(mouseEvent);
    }
    
    public void mouseDragged(final MouseEvent mouseEvent) {
        if (this.g != null) {
            this.g.mouseDragged(mouseEvent);
            this.c(mouseEvent);
            if (!fj.z) {
                return;
            }
        }
        this.b(mouseEvent);
    }
    
    public void mousePressed(final MouseEvent mouseEvent) {
        if (this.g != null) {
            this.g.mousePressed(mouseEvent);
            this.c(mouseEvent);
            if (!fj.z) {
                return;
            }
        }
        this.b(mouseEvent);
    }
    
    public void mouseClicked(final MouseEvent mouseEvent) {
        if (this.g != null) {
            this.g.mouseClicked(mouseEvent);
            this.c(mouseEvent);
            if (!fj.z) {
                return;
            }
        }
        this.b(mouseEvent);
    }
    
    protected void a(final JComponent e, final fj fj) {
        if (e.getNextFocusableComponent() == null) {
            e.setNextFocusableComponent(this.view.getCanvasComponent());
        }
        this.view.s().add(e);
        this.e = e;
        final hw g = new hw();
        this.setChild(g, null, null, null);
        this.g = g;
        final AffineTransform translateInstance = AffineTransform.getTranslateInstance(fj.getX(), fj.getY());
        g.a(e, translateInstance);
        this.h = new ia(this.view, e, translateInstance);
        this.view.addDrawable(this.h);
        e.setBounds(0, 0, (int)fj.getWidth(), (int)fj.getHeight());
        e.validate();
        e.requestFocusInWindow();
        e.repaint();
        if (this.i == null) {
            final KeyboardFocusManager currentKeyboardFocusManager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
            currentKeyboardFocusManager.addPropertyChangeListener("permanentFocusOwner", this.i = new E(this, currentKeyboardFocusManager));
        }
    }
    
    private void a(final Component component) {
        final boolean z = fj.z;
        if (!this.a()) {
            return;
        }
        Component parent = component;
        while (parent != null) {
            if (parent == this.view.s()) {
                return;
            }
            if (parent instanceof Window || (parent instanceof Applet && parent.getParent() == null)) {
                if (parent != SwingUtilities.getRoot(this.view) || this.e()) {
                    break;
                }
                this.c();
                if (!z) {
                    break;
                }
            }
            parent = parent.getParent();
            if (z) {
                break;
            }
        }
    }
    
    static void a(final D d, final Component component) {
        d.a(component);
    }
}
