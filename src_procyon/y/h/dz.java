package y.h;

import javax.swing.event.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import y.c.*;
import java.util.*;

public class dz extends gX
{
    private dx a;
    private ChangeListener b;
    private List c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    
    public dz() {
        this.b = new dA(this);
        this.c = new ArrayList();
        this.g = true;
    }
    
    private boolean a(final MouseEvent mouseEvent) {
        if (this.a == null) {
            this.a(this.a(this.view, this.view.toWorldCoordX(mouseEvent.getX()), this.view.toWorldCoordY(mouseEvent.getY()), null));
        }
        if (this.a != null) {
            if (this.a.c()) {
                if (this.a.b()) {
                    this.a.b(this.b(mouseEvent));
                }
                return true;
            }
            if (this.a.b()) {
                final dw b = this.b(mouseEvent);
                if (this.a.a(b) && this.a(this.a)) {
                    this.a.b(b);
                    return true;
                }
            }
        }
        return false;
    }
    
    public void a() {
        final dx a = this.a;
        if (a != null && a.c()) {
            a.e();
            a.b(this.b);
            this.setEditing(false);
        }
    }
    
    public boolean a(final dx a) {
        if (this.a != null && this.a != a) {
            this.a();
        }
        this.a = a;
        if (this.a != null) {
            if (!this.a.c()) {
                this.a.d();
            }
            final boolean c = this.a.c();
            if (c) {
                this.a.a(this.b);
                this.setEditing(true);
            }
            return c;
        }
        return false;
    }
    
    protected void c() {
        this.a = null;
        this.setEditing(false);
        if (this.g) {
            this.reactivateParent();
        }
    }
    
    private dw b(final MouseEvent mouseEvent) {
        return new dw(this.view, this, this.translateX(mouseEvent.getX()), this.translateY(mouseEvent.getY()), mouseEvent);
    }
    
    public void mousePressed(final MouseEvent lastPressEvent) {
        this.e();
        this.lastPressEvent = lastPressEvent;
        if (!this.a(lastPressEvent)) {
            super.mousePressed(lastPressEvent);
        }
    }
    
    protected void e() {
        if (this.isGrabFocusEnabled()) {
            final Component focusOwner = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
            if (focusOwner != null && !SwingUtilities.isDescendingFrom(focusOwner, this.view)) {
                this.view.getCanvasComponent().requestFocusInWindow();
            }
        }
    }
    
    public void mouseReleased(final MouseEvent lastReleaseEvent) {
        this.lastReleaseEvent = lastReleaseEvent;
        if (!this.a(lastReleaseEvent)) {
            super.mouseReleased(lastReleaseEvent);
        }
    }
    
    public void mouseClicked(final MouseEvent lastClickEvent) {
        this.lastClickEvent = lastClickEvent;
        if (!this.a(lastClickEvent)) {
            super.mouseClicked(lastClickEvent);
        }
    }
    
    public void mouseDragged(final MouseEvent lastDragEvent) {
        this.lastDragEvent = lastDragEvent;
        if (!this.a(lastDragEvent)) {
            super.mouseDragged(lastDragEvent);
        }
    }
    
    public void mouseMoved(final MouseEvent lastMoveEvent) {
        this.lastMoveEvent = lastMoveEvent;
        if (!this.a(lastMoveEvent)) {
            super.mouseMoved(lastMoveEvent);
        }
    }
    
    public void mouseEntered(final MouseEvent mouseEvent) {
        if (!this.a(mouseEvent)) {
            super.mouseEntered(mouseEvent);
        }
    }
    
    public void mouseExited(final MouseEvent mouseEvent) {
        if (!this.a(mouseEvent)) {
            super.mouseExited(mouseEvent);
        }
    }
    
    public dx a(final ch ch, final double n, final double n2, cW hitInfo) {
        final boolean z = fj.z;
        if (hitInfo == null) {
            hitInfo = this.getHitInfo(n, n2);
        }
        int i = 0;
        while (i < this.c.size()) {
            final dx a = this.c.get(i).a(ch, n, n2, hitInfo);
            if (z) {
                return null;
            }
            if (a != null) {
                return a;
            }
            ++i;
            if (z) {
                break;
            }
        }
        if (hitInfo == null) {
            return null;
        }
        if (this.e) {
            final q j = hitInfo.i();
            if (j != null) {
                final dy mouseInputEditorProvider = ch.getGraph2D().t(j).getMouseInputEditorProvider();
                if (mouseInputEditorProvider != null) {
                    final dx a2 = mouseInputEditorProvider.a(ch, n, n2, hitInfo);
                    if (a2 != null) {
                        return a2;
                    }
                }
            }
        }
        if (this.f) {
            final d k = hitInfo.k();
            if (k != null) {
                final dy mouseInputEditorProvider2 = ch.getGraph2D().i(k).getMouseInputEditorProvider();
                if (mouseInputEditorProvider2 != null) {
                    final dx a3 = mouseInputEditorProvider2.a(ch, n, n2, hitInfo);
                    if (a3 != null) {
                        return a3;
                    }
                }
            }
        }
        if (this.d) {
            final C r = ch.getGraph2D().R();
            while (r.f()) {
                final az az = (az)r.d();
                if (z) {
                    return null;
                }
                if (az instanceof dy) {
                    final dx a4 = ((dy)az).a(ch, n, n2, hitInfo);
                    if (a4 != null) {
                        return a4;
                    }
                }
                r.g();
                if (z) {
                    break;
                }
            }
            Iterator<az> iterator = (Iterator<az>)ch.getDrawables().iterator();
            while (true) {
                while (iterator.hasNext()) {
                    final az az2 = iterator.next();
                    if (az2 instanceof dy) {
                        final dx a5 = ((dy)az2).a(ch, n, n2, hitInfo);
                        Object next;
                        final dx dx = (dx)(next = a5);
                        if (!z) {
                            if (dx != null) {
                                return a5;
                            }
                            continue;
                        }
                        else {
                            while (true) {
                                final az az3 = (az)next;
                                if (az3 instanceof dy) {
                                    final dx a6 = ((dy)az3).a(ch, n, n2, hitInfo);
                                    if (a6 != null) {
                                        return a6;
                                    }
                                }
                                if (iterator.hasNext()) {
                                    next = iterator.next();
                                    continue;
                                }
                                break;
                            }
                            return null;
                        }
                    }
                }
                iterator = ch.getBackgroundDrawables().iterator();
                continue;
            }
        }
        return null;
    }
    
    static dx a(final dz dz) {
        return dz.a;
    }
}
