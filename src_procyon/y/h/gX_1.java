package y.h;

import javax.swing.event.*;
import java.awt.event.*;
import java.beans.*;
import javax.swing.*;

public class gX implements MouseInputListener
{
    public static final String ACTIVE_PROPERTY = "active";
    public static final String CHILD_MODE_PROPERTY = "child";
    public static final String ACTIVE_VIEW_PROPERTY = "activeView";
    public static final String GRAB_FOCUS_ENABLED_PROPERTY = "grabFocusEnabled";
    public static final String PARENT_MODE_PROPERTY = "parent";
    public static final String NAME_PROPERTY = "name";
    public static final String MODIFIER_MASK_PROPERTY = "modifierMask";
    public static final String EDITING_PROPERTY = "editing";
    protected ch view;
    protected int originalX;
    protected int originalY;
    private int k;
    private int m;
    private boolean g;
    private boolean b;
    private boolean n;
    private int j;
    protected MouseEvent lastPressEvent;
    protected MouseEvent lastDragEvent;
    protected MouseEvent lastMoveEvent;
    protected MouseEvent lastReleaseEvent;
    protected MouseEvent lastClickEvent;
    private cW c;
    private String o;
    private gX d;
    private gX f;
    private boolean l;
    private boolean e;
    private boolean i;
    private PropertyChangeSupport h;
    
    public gX() {
        this.j = 1;
        this.e = true;
        this.d = null;
        this.l = false;
    }
    
    public gX(final gU gu) {
        this();
        if (gu != null) {
            final gI currentView = gu.getCurrentView();
            this.view = null;
            if (currentView != null && currentView instanceof ch) {
                this.view = (ch)currentView;
            }
        }
    }
    
    public void addPropertyChangeListener(final PropertyChangeListener propertyChangeListener) {
        if (this.h == null) {
            this.h = new PropertyChangeSupport(this);
        }
        this.h.addPropertyChangeListener(propertyChangeListener);
    }
    
    public void addPropertyChangeListener(final String s, final PropertyChangeListener propertyChangeListener) {
        if (this.h == null) {
            this.h = new PropertyChangeSupport(this);
        }
        this.h.addPropertyChangeListener(s, propertyChangeListener);
    }
    
    public void removePropertyChangeListener(final PropertyChangeListener propertyChangeListener) {
        if (this.h != null) {
            this.h.removePropertyChangeListener(propertyChangeListener);
        }
    }
    
    public void removePropertyChangeListener(final String s, final PropertyChangeListener propertyChangeListener) {
        if (this.h != null) {
            this.h.removePropertyChangeListener(s, propertyChangeListener);
        }
    }
    
    protected void firePropertyChange(final String s, final Object o, final Object o2) {
        if (this.h != null) {
            this.h.firePropertyChange(s, o, o2);
        }
    }
    
    protected void firePropertyChange(final String s, final boolean b, final boolean b2) {
        if (this.h != null) {
            this.h.firePropertyChange(s, b, b2);
        }
    }
    
    protected void firePropertyChange(final String s, final int n, final int n2) {
        if (this.h != null) {
            this.h.firePropertyChange(s, n, n2);
        }
    }
    
    public boolean isEditing() {
        return this.b;
    }
    
    protected void setEditing(final boolean b) {
        if (this.b != b) {
            this.b = b;
            this.firePropertyChange("editing", !b, b);
        }
    }
    
    public void cancelEditing() {
        if (this.isEditing()) {
            this.setEditing(false);
        }
    }
    
    public void setActiveView(final ch view) {
        final ch view2 = this.view;
        if (view2 != view) {
            this.firePropertyChange("activeView", view2, this.view = view);
        }
    }
    
    public void activate(final boolean i) {
        if (this.i != i) {
            this.i = i;
            this.firePropertyChange("active", !i, i);
        }
    }
    
    public boolean isActive() {
        return this.i;
    }
    
    public void setGridMode(final boolean b) {
        this.d().e(b);
    }
    
    public boolean isGridMode() {
        return this.d().s();
    }
    
    public void setGrabFocusEnabled(final boolean e) {
        if (this.e != e) {
            this.e = e;
            this.firePropertyChange("grabFocusEnabled", !e, e);
        }
    }
    
    public boolean isGrabFocusEnabled() {
        return this.e;
    }
    
    public void setChild(final gX gx, final MouseEvent mouseEvent, final MouseEvent mouseEvent2) {
        this.setChild(gx, mouseEvent, mouseEvent2, null);
    }
    
    public void setChild(final gX d, final MouseEvent mouseEvent, final MouseEvent mouseEvent2, final MouseEvent mouseEvent3) {
        final gX d2 = this.d;
        if (d != null) {
            if (d2 != d && d2 != null) {
                this.deactivateChild(d2);
            }
            d.setActiveView(this.view);
            d.setParent(this);
            d.setLastHitInfo(this.getLastHitInfo());
            if (d2 != (this.d = d)) {
                this.firePropertyChange("child", d2, d);
            }
            d.init();
            d.activate(true);
            if (mouseEvent != null) {
                d.mousePressed(mouseEvent);
            }
            if (mouseEvent2 != null) {
                d.mouseDragged(mouseEvent2);
            }
            if (mouseEvent3 == null) {
                return;
            }
            d.mouseReleased(mouseEvent3);
            if (!fj.z) {
                return;
            }
        }
        if (d2 != null) {
            this.deactivateChild(d2);
        }
        this.d = null;
        if (d2 != d) {
            this.firePropertyChange("child", d2, d);
        }
    }
    
    protected void deactivateChild(final gX gx) {
        if (gx != null) {
            if (gx.isEditing()) {
                gx.cancelEditing();
            }
            gx.activate(false);
            gx.setParent(null);
        }
    }
    
    public void init() {
    }
    
    public void reactivateParent() {
        if (this.isEditing()) {
            this.cancelEditing();
        }
        if (this.b()) {
            this.c(false);
            this.view.getViewControl().b();
            if (!fj.z) {
                return;
            }
        }
        if (this.f == null) {
            return;
        }
        this.f.setChild(null, null, null);
    }
    
    public void setParent(final gX f) {
        if (this.f != f) {
            this.firePropertyChange("parent", this.f, this.f = f);
        }
    }
    
    public gX getParent() {
        return this.f;
    }
    
    public gX getChild() {
        return this.d;
    }
    
    public void mousePressed(final MouseEvent lastPressEvent) {
        final boolean z = fj.z;
        if (this.d != null) {
            this.d.mousePressed(lastPressEvent);
            if (!z) {
                return;
            }
        }
        if (this.isGrabFocusEnabled()) {
            this.view.requestFocus();
        }
        this.lastPressEvent = lastPressEvent;
        final int x = lastPressEvent.getX();
        this.originalX = x;
        this.k = x;
        final int y = lastPressEvent.getY();
        this.originalY = y;
        this.m = y;
        this.g = true;
        final bw d = this.d();
        final double c = d.c(lastPressEvent.getX());
        final double d2 = d.d(lastPressEvent.getY());
        this.b(false);
        if (lastPressEvent.isPopupTrigger() || SwingUtilities.isRightMouseButton(lastPressEvent)) {
            this.b(true);
            if (this.isModifierPressed(lastPressEvent)) {
                this.mouseShiftPressedRight(c, d2);
                if (!z) {
                    return;
                }
            }
            this.mousePressedRight(c, d2);
            if (!z) {
                return;
            }
        }
        if (SwingUtilities.isLeftMouseButton(lastPressEvent)) {
            if (this.isModifierPressed(lastPressEvent)) {
                this.mouseShiftPressedLeft(c, d2);
                if (!z) {
                    return;
                }
            }
            this.mousePressedLeft(c, d2);
            if (!z) {
                return;
            }
        }
        if (SwingUtilities.isMiddleMouseButton(lastPressEvent)) {
            if (this.isModifierPressed(lastPressEvent)) {
                this.mouseShiftPressedMiddle(c, d2);
                if (!z) {
                    return;
                }
            }
            this.mousePressedMiddle(c, d2);
        }
    }
    
    public void mouseReleased(final MouseEvent lastReleaseEvent) {
        final boolean z = fj.z;
        this.lastReleaseEvent = lastReleaseEvent;
        if (this.d != null) {
            this.d.mouseReleased(lastReleaseEvent);
            if (!z) {
                return;
            }
        }
        this.originalX = lastReleaseEvent.getX();
        this.originalY = lastReleaseEvent.getY();
        final bw d = this.d();
        final double c = d.c(lastReleaseEvent.getX());
        final double d2 = d.d(lastReleaseEvent.getY());
        this.mouseReleased(c, d2);
        if (lastReleaseEvent.isPopupTrigger() || SwingUtilities.isRightMouseButton(lastReleaseEvent) || this.c()) {
            Label_0127: {
                if (this.isModifierPressed(lastReleaseEvent)) {
                    this.mouseShiftReleasedRight(c, d2);
                    if (!z) {
                        break Label_0127;
                    }
                }
                this.mouseReleasedRight(c, d2);
            }
            this.b(false);
            if (!z) {
                return;
            }
        }
        if (SwingUtilities.isLeftMouseButton(lastReleaseEvent)) {
            if (this.isModifierPressed(lastReleaseEvent)) {
                this.mouseShiftReleasedLeft(c, d2);
                if (!z) {
                    return;
                }
            }
            this.mouseReleasedLeft(c, d2);
            if (!z) {
                return;
            }
        }
        if (SwingUtilities.isMiddleMouseButton(lastReleaseEvent)) {
            if (this.isModifierPressed(lastReleaseEvent)) {
                this.mouseShiftReleasedMiddle(c, d2);
                if (!z) {
                    return;
                }
            }
            this.mouseReleasedMiddle(c, d2);
        }
    }
    
    public void mouseClicked(final MouseEvent lastClickEvent) {
        if (this.d != null) {
            this.d.mouseClicked(lastClickEvent);
            if (!fj.z) {
                return;
            }
        }
        this.originalX = lastClickEvent.getX();
        this.originalY = lastClickEvent.getY();
        final bw d = this.d();
        final double c = d.c(lastClickEvent.getX());
        final double d2 = d.d(lastClickEvent.getY());
        this.lastClickEvent = lastClickEvent;
        this.mouseClicked(c, d2);
    }
    
    public void mouseDragged(final MouseEvent lastDragEvent) {
        final boolean z = fj.z;
        this.lastDragEvent = lastDragEvent;
        if (this.d != null) {
            this.d.mouseDragged(lastDragEvent);
            if (!z) {
                return;
            }
        }
        if (!this.b(lastDragEvent.getX(), lastDragEvent.getY())) {
            this.g = false;
            this.originalX = lastDragEvent.getX();
            this.originalY = lastDragEvent.getY();
            final bw d = this.d();
            final double c = d.c(lastDragEvent.getX());
            final double d2 = d.d(lastDragEvent.getY());
            if (SwingUtilities.isRightMouseButton(lastDragEvent)) {
                this.mouseDraggedRight(c, d2);
                if (!z) {
                    return;
                }
            }
            if (SwingUtilities.isLeftMouseButton(lastDragEvent)) {
                this.mouseDraggedLeft(c, d2);
                if (!z) {
                    return;
                }
            }
            if (SwingUtilities.isMiddleMouseButton(lastDragEvent)) {
                this.mouseDraggedMiddle(c, d2);
            }
        }
    }
    
    public void mouseMoved(final MouseEvent lastMoveEvent) {
        if (this.d != null) {
            this.d.mouseMoved(lastMoveEvent);
            if (!fj.z) {
                return;
            }
        }
        this.originalX = lastMoveEvent.getX();
        this.originalY = lastMoveEvent.getY();
        final bw d = this.d();
        final double c = d.c(lastMoveEvent.getX());
        final double d2 = d.d(lastMoveEvent.getY());
        this.lastMoveEvent = lastMoveEvent;
        this.mouseMoved(c, d2);
    }
    
    public void mouseEntered(final MouseEvent mouseEvent) {
        if (this.d != null) {
            this.d.mouseEntered(mouseEvent);
        }
    }
    
    public void mouseExited(final MouseEvent mouseEvent) {
        if (this.d != null) {
            this.d.mouseExited(mouseEvent);
        }
    }
    
    protected double getGridX(final double n) {
        if (!this.isGridMode()) {
            return n;
        }
        final double u = this.d().u();
        return Math.floor(n / u + 0.5) * u;
    }
    
    protected double getGridY(final double n) {
        if (!this.isGridMode()) {
            return n;
        }
        final double u = this.d().u();
        return Math.floor(n / u + 0.5) * u;
    }
    
    bw d() {
        return this.view.r();
    }
    
    protected bu getGraph2D() {
        return this.view.getGraph2D();
    }
    
    protected double translateX(final int n) {
        return this.d().c(n);
    }
    
    protected double translateY(final int n) {
        return this.d().d(n);
    }
    
    public void setName(final String o) {
        if (o != this.o && (this.o == null || !this.o.equals(o))) {
            this.firePropertyChange("name", this.o, this.o = o);
        }
    }
    
    public String getName() {
        return this.o;
    }
    
    cW b(final double n, final double n2, final boolean b) {
        return this.view.getHitInfoFactory().a(n, n2, -1, b);
    }
    
    cW b(final double n, final double n2, final int n3, final boolean b) {
        final boolean z = fj.z;
        Label_0099: {
            switch (n3) {
                case 0: {
                    final int n4 = 4;
                    if (z) {
                        break Label_0099;
                    }
                    return this.view.getHitInfoFactory().a(n, n2, n4, b);
                }
                case 1: {
                    final int n4 = 8;
                    if (z) {
                        break Label_0099;
                    }
                    return this.view.getHitInfoFactory().a(n, n2, n4, b);
                }
                case 2: {
                    final int n4 = 32;
                    if (z) {
                        break Label_0099;
                    }
                    return this.view.getHitInfoFactory().a(n, n2, n4, b);
                }
                case 3: {
                    final int n4 = 2;
                    if (z) {
                        break Label_0099;
                    }
                    return this.view.getHitInfoFactory().a(n, n2, n4, b);
                }
                case 4: {
                    final int n4 = 1;
                    if (z) {
                        break Label_0099;
                    }
                    return this.view.getHitInfoFactory().a(n, n2, n4, b);
                }
                case 5: {
                    final int n4 = 16;
                    if (z) {
                        break Label_0099;
                    }
                    return this.view.getHitInfoFactory().a(n, n2, n4, b);
                }
                case 6: {
                    final int n4 = 64;
                    if (z) {
                        break;
                    }
                    return this.view.getHitInfoFactory().a(n, n2, n4, b);
                }
            }
        }
        throw new IllegalArgumentException("unknown type: " + n3);
    }
    
    protected cW getHitInfo(final MouseEvent mouseEvent) {
        return this.getHitInfo(this.translateX(mouseEvent.getX()), this.translateY(mouseEvent.getY()));
    }
    
    protected cW getHitInfo(final double n, final double n2) {
        return this.c = this.b(n, n2, true);
    }
    
    protected cW getLastHitInfo() {
        return this.c;
    }
    
    public void setLastHitInfo(final cW c) {
        this.c = c;
    }
    
    public void mousePressedLeft(final double n, final double n2) {
    }
    
    public void mouseShiftPressedLeft(final double n, final double n2) {
        this.mousePressedLeft(n, n2);
    }
    
    public void mouseShiftPressedRight(final double n, final double n2) {
        this.mousePressedRight(n, n2);
    }
    
    public void mouseShiftPressedMiddle(final double n, final double n2) {
        this.mousePressedMiddle(n, n2);
    }
    
    public void mousePressedMiddle(final double n, final double n2) {
    }
    
    public void mousePressedRight(final double n, final double n2) {
    }
    
    public void mouseReleased(final double n, final double n2) {
    }
    
    public void mouseReleasedLeft(final double n, final double n2) {
    }
    
    public void mouseShiftReleasedLeft(final double n, final double n2) {
        this.mouseReleasedLeft(n, n2);
    }
    
    public void mouseShiftReleasedRight(final double n, final double n2) {
        this.mouseReleasedRight(n, n2);
    }
    
    public void mouseReleasedMiddle(final double n, final double n2) {
    }
    
    public void mouseShiftReleasedMiddle(final double n, final double n2) {
        this.mouseReleasedMiddle(n, n2);
    }
    
    public void mouseReleasedRight(final double n, final double n2) {
    }
    
    public void mouseDraggedLeft(final double n, final double n2) {
    }
    
    public void mouseDraggedMiddle(final double n, final double n2) {
    }
    
    public void mouseDraggedRight(final double n, final double n2) {
    }
    
    public void mouseClicked(final double n, final double n2) {
    }
    
    public void mouseMoved(final double n, final double n2) {
    }
    
    private boolean b(final int n, final int n2) {
        final int n3 = n - this.k;
        final int n4 = n2 - this.m;
        return this.g && n3 * n3 + n4 * n4 < 9;
    }
    
    protected boolean isModifierPressed(final MouseEvent mouseEvent) {
        return (mouseEvent.getModifiers() & this.j) != 0x0;
    }
    
    void c(final boolean l) {
        this.l = l;
    }
    
    boolean b() {
        return this.l;
    }
    
    public int getModifierMask() {
        return this.j;
    }
    
    public void setModifierMask(final int j) {
        final int i = this.j;
        if (i != j) {
            this.firePropertyChange("modifierMask", i, this.j = j);
        }
    }
    
    private void b(final boolean n) {
        this.n = n;
    }
    
    private boolean c() {
        return this.n;
    }
    
    public MouseEvent getLastPressEvent() {
        return this.lastPressEvent;
    }
    
    public MouseEvent getLastDragEvent() {
        return this.lastDragEvent;
    }
    
    public MouseEvent getLastMoveEvent() {
        return this.lastMoveEvent;
    }
    
    public MouseEvent getLastReleaseEvent() {
        return this.lastReleaseEvent;
    }
    
    public MouseEvent getLastClickEvent() {
        return this.lastClickEvent;
    }
}
