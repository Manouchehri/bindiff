/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.applet.Applet;
import java.awt.Component;
import java.awt.Container;
import java.awt.KeyboardFocusManager;
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.beans.PropertyChangeListener;
import java.util.EventObject;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.event.CellEditorListener;
import y.c.b;
import y.c.c;
import y.c.q;
import y.h.E;
import y.h.az;
import y.h.bu;
import y.h.cW;
import y.h.ch;
import y.h.eQ;
import y.h.fj;
import y.h.gX;
import y.h.hw;
import y.h.ia;

public class D
extends gX {
    private final c a;
    private final b b;
    private eQ c;
    private fj d;
    private JComponent e;
    private final CellEditorListener f;
    private hw g;
    private ia h;
    private PropertyChangeListener i;

    public boolean a(q q2, EventObject eventObject) {
        if (!this.a(q2)) return false;
        if (this.a() && !this.e()) {
            return false;
        }
        fj fj2 = this.getGraph2D().t(q2);
        eQ eQ2 = this.c(q2);
        if (eQ2 == null) return false;
        if (eventObject != null) {
            if (!eQ2.isCellEditable(eventObject)) return false;
        }
        this.a(fj2, eQ2);
        if (!(eventObject instanceof MouseEvent)) return true;
        if (((MouseEvent)eventObject).getID() != 500) return true;
        if (this.g == null) return true;
        if (!this.a()) return true;
        this.g.mouseClicked((MouseEvent)eventObject);
        return true;
    }

    public boolean a(q q2) {
        if (this.c(q2) == null) return false;
        return true;
    }

    private void b(MouseEvent mouseEvent) {
        cW cW2;
        if (!this.a()) {
            if (!this.a(mouseEvent)) return;
            cW2 = this.getHitInfo(mouseEvent);
            if (cW2.i() == null) return;
            this.a(cW2.i(), mouseEvent);
            if (!fj.z) return;
        }
        this.a(KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner());
        if (!this.a()) return;
        if (mouseEvent.getID() != 501) return;
        cW2 = this.getHitInfo(mouseEvent);
        q q2 = cW2.i();
        if (q2 != null) {
            if (q2 == this.d.getNode()) return;
        }
        if (this.e()) return;
        this.c();
    }

    public Object b(q q2) {
        return this.b.b(this.d.getNode());
    }

    protected boolean a(MouseEvent mouseEvent) {
        if (mouseEvent.getID() != 500) return false;
        if (mouseEvent.getClickCount() != 2) return false;
        return true;
    }

    public eQ c(q q2) {
        Object object = this.a != null ? this.a.b(q2) : null;
        if (!(object instanceof eQ)) return null;
        eQ eQ2 = (eQ)object;
        return eQ2;
    }

    public boolean a() {
        if (this.c == null) return false;
        return true;
    }

    public void a(fj fj2, eQ eQ2) {
        if (this.a() && !this.e()) {
            this.c();
        }
        if (this.a()) return;
        this.c = eQ2;
        this.d = fj2;
        eQ2.addCellEditorListener(this.f);
        this.a(eQ2.a(this.view, fj2, this.b(fj2.getNode()), fj2.isSelected()), fj2);
    }

    public void c() {
        if (this.c == null) return;
        this.c.cancelCellEditing();
    }

    public boolean e() {
        if (this.c == null) return true;
        return this.c.stopCellEditing();
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        if (this.g == null) return;
        this.g.mouseMoved(mouseEvent);
    }

    private void c(MouseEvent mouseEvent) {
        if (mouseEvent.getID() != 501) return;
        q q2 = this.getHitInfo(mouseEvent).i();
        if (q2 != null) {
            if (q2 == this.d.getNode()) return;
        }
        if (this.e()) return;
        this.c();
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        if (this.g != null) {
            this.g.mouseReleased(mouseEvent);
            this.c(mouseEvent);
            if (!fj.z) return;
        }
        this.b(mouseEvent);
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        if (this.g != null) {
            this.g.mouseDragged(mouseEvent);
            this.c(mouseEvent);
            if (!fj.z) return;
        }
        this.b(mouseEvent);
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        if (this.g != null) {
            this.g.mousePressed(mouseEvent);
            this.c(mouseEvent);
            if (!fj.z) return;
        }
        this.b(mouseEvent);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (this.g != null) {
            this.g.mouseClicked(mouseEvent);
            this.c(mouseEvent);
            if (!fj.z) return;
        }
        this.b(mouseEvent);
    }

    protected void a(JComponent jComponent, fj fj2) {
        if (jComponent.getNextFocusableComponent() == null) {
            jComponent.setNextFocusableComponent(this.view.getCanvasComponent());
        }
        this.view.s().add(jComponent);
        this.e = jComponent;
        hw hw2 = new hw();
        this.setChild(hw2, null, null, null);
        this.g = hw2;
        AffineTransform affineTransform = AffineTransform.getTranslateInstance(fj2.getX(), fj2.getY());
        hw2.a(jComponent, affineTransform);
        this.h = new ia(this.view, jComponent, affineTransform);
        this.view.addDrawable(this.h);
        jComponent.setBounds(0, 0, (int)fj2.getWidth(), (int)fj2.getHeight());
        jComponent.validate();
        jComponent.requestFocusInWindow();
        jComponent.repaint();
        if (this.i != null) return;
        KeyboardFocusManager keyboardFocusManager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        this.i = new E(this, keyboardFocusManager);
        keyboardFocusManager.addPropertyChangeListener("permanentFocusOwner", this.i);
    }

    private void a(Component component) {
        boolean bl2 = fj.z;
        if (!this.a()) {
            return;
        }
        Component component2 = component;
        do {
            if (component2 == null) return;
            if (component2 == this.view.s()) {
                return;
            }
            if (component2 instanceof Window || component2 instanceof Applet && component2.getParent() == null) {
                if (component2 != SwingUtilities.getRoot(this.view)) return;
                if (this.e()) return;
                this.c();
                if (!bl2) return;
            }
            component2 = component2.getParent();
        } while (!bl2);
    }

    static void a(D d2, Component component) {
        d2.a(component);
    }
}

