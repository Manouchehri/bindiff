/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputListener;
import y.h.bu;
import y.h.bw;
import y.h.cW;
import y.h.cZ;
import y.h.ch;
import y.h.fj;
import y.h.gI;
import y.h.gU;
import y.h.gV;

public class gX
implements MouseInputListener {
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
    private int j = 1;
    protected MouseEvent lastPressEvent;
    protected MouseEvent lastDragEvent;
    protected MouseEvent lastMoveEvent;
    protected MouseEvent lastReleaseEvent;
    protected MouseEvent lastClickEvent;
    private cW c;
    private String o;
    private gX d = null;
    private gX f;
    private boolean l = false;
    private boolean e = true;
    private boolean i;
    private PropertyChangeSupport h;

    public gX() {
    }

    public gX(gU gU2) {
        this();
        if (gU2 == null) return;
        gI gI2 = gU2.getCurrentView();
        this.view = null;
        if (gI2 == null) return;
        if (!(gI2 instanceof ch)) return;
        this.view = (ch)gI2;
    }

    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        if (this.h == null) {
            this.h = new PropertyChangeSupport(this);
        }
        this.h.addPropertyChangeListener(propertyChangeListener);
    }

    public void addPropertyChangeListener(String string, PropertyChangeListener propertyChangeListener) {
        if (this.h == null) {
            this.h = new PropertyChangeSupport(this);
        }
        this.h.addPropertyChangeListener(string, propertyChangeListener);
    }

    public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        if (this.h == null) return;
        this.h.removePropertyChangeListener(propertyChangeListener);
    }

    public void removePropertyChangeListener(String string, PropertyChangeListener propertyChangeListener) {
        if (this.h == null) return;
        this.h.removePropertyChangeListener(string, propertyChangeListener);
    }

    protected void firePropertyChange(String string, Object object, Object object2) {
        if (this.h == null) return;
        this.h.firePropertyChange(string, object, object2);
    }

    protected void firePropertyChange(String string, boolean bl2, boolean bl3) {
        if (this.h == null) return;
        this.h.firePropertyChange(string, bl2, bl3);
    }

    protected void firePropertyChange(String string, int n2, int n3) {
        if (this.h == null) return;
        this.h.firePropertyChange(string, n2, n3);
    }

    public boolean isEditing() {
        return this.b;
    }

    protected void setEditing(boolean bl2) {
        if (this.b == bl2) return;
        this.b = bl2;
        this.firePropertyChange("editing", !bl2, bl2);
    }

    public void cancelEditing() {
        if (!this.isEditing()) return;
        this.setEditing(false);
    }

    public void setActiveView(ch ch2) {
        ch ch3 = this.view;
        if (ch3 == ch2) return;
        this.view = ch2;
        this.firePropertyChange("activeView", ch3, ch2);
    }

    public void activate(boolean bl2) {
        if (this.i == bl2) return;
        this.i = bl2;
        this.firePropertyChange("active", !bl2, bl2);
    }

    public boolean isActive() {
        return this.i;
    }

    public void setGridMode(boolean bl2) {
        this.d().e(bl2);
    }

    public boolean isGridMode() {
        return this.d().s();
    }

    public void setGrabFocusEnabled(boolean bl2) {
        if (this.e == bl2) return;
        this.e = bl2;
        this.firePropertyChange("grabFocusEnabled", !bl2, bl2);
    }

    public boolean isGrabFocusEnabled() {
        return this.e;
    }

    public void setChild(gX gX2, MouseEvent mouseEvent, MouseEvent mouseEvent2) {
        this.setChild(gX2, mouseEvent, mouseEvent2, null);
    }

    public void setChild(gX gX2, MouseEvent mouseEvent, MouseEvent mouseEvent2, MouseEvent mouseEvent3) {
        gX gX3 = this.d;
        if (gX2 != null) {
            if (gX3 != gX2 && gX3 != null) {
                this.deactivateChild(gX3);
            }
            gX2.setActiveView(this.view);
            gX2.setParent(this);
            gX2.setLastHitInfo(this.getLastHitInfo());
            this.d = gX2;
            if (gX3 != gX2) {
                this.firePropertyChange("child", gX3, gX2);
            }
            gX2.init();
            gX2.activate(true);
            if (mouseEvent != null) {
                gX2.mousePressed(mouseEvent);
            }
            if (mouseEvent2 != null) {
                gX2.mouseDragged(mouseEvent2);
            }
            if (mouseEvent3 == null) return;
            gX2.mouseReleased(mouseEvent3);
            if (!fj.z) return;
        }
        if (gX3 != null) {
            this.deactivateChild(gX3);
        }
        this.d = null;
        if (gX3 == gX2) return;
        this.firePropertyChange("child", gX3, gX2);
    }

    protected void deactivateChild(gX gX2) {
        if (gX2 == null) return;
        if (gX2.isEditing()) {
            gX2.cancelEditing();
        }
        gX2.activate(false);
        gX2.setParent(null);
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
            if (!fj.z) return;
        }
        if (this.f == null) {
            return;
        }
        this.f.setChild(null, null, null);
    }

    public void setParent(gX gX2) {
        if (this.f == gX2) return;
        gX gX3 = this.f;
        this.f = gX2;
        this.firePropertyChange("parent", gX3, this.f);
    }

    public gX getParent() {
        return this.f;
    }

    public gX getChild() {
        return this.d;
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        boolean bl2 = fj.z;
        if (this.d != null) {
            this.d.mousePressed(mouseEvent);
            if (!bl2) return;
        }
        if (this.isGrabFocusEnabled()) {
            this.view.requestFocus();
        }
        this.lastPressEvent = mouseEvent;
        this.k = this.originalX = mouseEvent.getX();
        this.m = this.originalY = mouseEvent.getY();
        this.g = true;
        bw bw2 = this.d();
        double d2 = bw2.c(mouseEvent.getX());
        double d3 = bw2.d(mouseEvent.getY());
        this.b(false);
        if (mouseEvent.isPopupTrigger() || SwingUtilities.isRightMouseButton(mouseEvent)) {
            this.b(true);
            if (this.isModifierPressed(mouseEvent)) {
                this.mouseShiftPressedRight(d2, d3);
                if (!bl2) return;
            }
            this.mousePressedRight(d2, d3);
            if (!bl2) return;
        }
        if (SwingUtilities.isLeftMouseButton(mouseEvent)) {
            if (this.isModifierPressed(mouseEvent)) {
                this.mouseShiftPressedLeft(d2, d3);
                if (!bl2) return;
            }
            this.mousePressedLeft(d2, d3);
            if (!bl2) return;
        }
        if (!SwingUtilities.isMiddleMouseButton(mouseEvent)) return;
        if (this.isModifierPressed(mouseEvent)) {
            this.mouseShiftPressedMiddle(d2, d3);
            if (!bl2) return;
        }
        this.mousePressedMiddle(d2, d3);
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        boolean bl2 = fj.z;
        this.lastReleaseEvent = mouseEvent;
        if (this.d != null) {
            this.d.mouseReleased(mouseEvent);
            if (!bl2) return;
        }
        this.originalX = mouseEvent.getX();
        this.originalY = mouseEvent.getY();
        bw bw2 = this.d();
        double d2 = bw2.c(mouseEvent.getX());
        double d3 = bw2.d(mouseEvent.getY());
        this.mouseReleased(d2, d3);
        if (mouseEvent.isPopupTrigger() || SwingUtilities.isRightMouseButton(mouseEvent) || this.c()) {
            block7 : {
                if (this.isModifierPressed(mouseEvent)) {
                    this.mouseShiftReleasedRight(d2, d3);
                    if (!bl2) break block7;
                }
                this.mouseReleasedRight(d2, d3);
            }
            this.b(false);
            if (!bl2) return;
        }
        if (SwingUtilities.isLeftMouseButton(mouseEvent)) {
            if (this.isModifierPressed(mouseEvent)) {
                this.mouseShiftReleasedLeft(d2, d3);
                if (!bl2) return;
            }
            this.mouseReleasedLeft(d2, d3);
            if (!bl2) return;
        }
        if (!SwingUtilities.isMiddleMouseButton(mouseEvent)) return;
        if (this.isModifierPressed(mouseEvent)) {
            this.mouseShiftReleasedMiddle(d2, d3);
            if (!bl2) return;
        }
        this.mouseReleasedMiddle(d2, d3);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (this.d != null) {
            this.d.mouseClicked(mouseEvent);
            if (!fj.z) return;
        }
        this.originalX = mouseEvent.getX();
        this.originalY = mouseEvent.getY();
        bw bw2 = this.d();
        double d2 = bw2.c(mouseEvent.getX());
        double d3 = bw2.d(mouseEvent.getY());
        this.lastClickEvent = mouseEvent;
        this.mouseClicked(d2, d3);
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        boolean bl2 = fj.z;
        this.lastDragEvent = mouseEvent;
        if (this.d != null) {
            this.d.mouseDragged(mouseEvent);
            if (!bl2) return;
        }
        if (this.b(mouseEvent.getX(), mouseEvent.getY())) return;
        this.g = false;
        this.originalX = mouseEvent.getX();
        this.originalY = mouseEvent.getY();
        bw bw2 = this.d();
        double d2 = bw2.c(mouseEvent.getX());
        double d3 = bw2.d(mouseEvent.getY());
        if (SwingUtilities.isRightMouseButton(mouseEvent)) {
            this.mouseDraggedRight(d2, d3);
            if (!bl2) return;
        }
        if (SwingUtilities.isLeftMouseButton(mouseEvent)) {
            this.mouseDraggedLeft(d2, d3);
            if (!bl2) return;
        }
        if (!SwingUtilities.isMiddleMouseButton(mouseEvent)) return;
        this.mouseDraggedMiddle(d2, d3);
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        if (this.d != null) {
            this.d.mouseMoved(mouseEvent);
            if (!fj.z) return;
        }
        this.originalX = mouseEvent.getX();
        this.originalY = mouseEvent.getY();
        bw bw2 = this.d();
        double d2 = bw2.c(mouseEvent.getX());
        double d3 = bw2.d(mouseEvent.getY());
        this.lastMoveEvent = mouseEvent;
        this.mouseMoved(d2, d3);
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        if (this.d == null) return;
        this.d.mouseEntered(mouseEvent);
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        if (this.d == null) return;
        this.d.mouseExited(mouseEvent);
    }

    protected double getGridX(double d2) {
        if (!this.isGridMode()) {
            return d2;
        }
        double d3 = this.d().u();
        return Math.floor(d2 / d3 + 0.5) * d3;
    }

    protected double getGridY(double d2) {
        if (!this.isGridMode()) {
            return d2;
        }
        double d3 = this.d().u();
        return Math.floor(d2 / d3 + 0.5) * d3;
    }

    bw d() {
        return this.view.r();
    }

    protected bu getGraph2D() {
        return this.view.getGraph2D();
    }

    protected double translateX(int n2) {
        return this.d().c(n2);
    }

    protected double translateY(int n2) {
        return this.d().d(n2);
    }

    public void setName(String string) {
        if (string == this.o) return;
        if (this.o != null) {
            if (this.o.equals(string)) return;
        }
        String string2 = this.o;
        this.o = string;
        this.firePropertyChange("name", string2, this.o);
    }

    public String getName() {
        return this.o;
    }

    cW b(double d2, double d3, boolean bl2) {
        return this.view.getHitInfoFactory().a(d2, d3, -1, bl2);
    }

    cW b(double d2, double d3, int n2, boolean bl2) {
        boolean bl3 = fj.z;
        switch (n2) {
            int n3;
            case 0: {
                n3 = 4;
                if (!bl3) return this.view.getHitInfoFactory().a(d2, d3, n3, bl2);
            }
            case 1: {
                n3 = 8;
                if (!bl3) return this.view.getHitInfoFactory().a(d2, d3, n3, bl2);
            }
            case 2: {
                n3 = 32;
                if (!bl3) return this.view.getHitInfoFactory().a(d2, d3, n3, bl2);
            }
            case 3: {
                n3 = 2;
                if (!bl3) return this.view.getHitInfoFactory().a(d2, d3, n3, bl2);
            }
            case 4: {
                n3 = 1;
                if (!bl3) return this.view.getHitInfoFactory().a(d2, d3, n3, bl2);
            }
            case 5: {
                n3 = 16;
                if (!bl3) return this.view.getHitInfoFactory().a(d2, d3, n3, bl2);
            }
            case 6: {
                n3 = 64;
                if (!bl3) return this.view.getHitInfoFactory().a(d2, d3, n3, bl2);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("unknown type: ").append(n2).toString());
    }

    protected cW getHitInfo(MouseEvent mouseEvent) {
        return this.getHitInfo(this.translateX(mouseEvent.getX()), this.translateY(mouseEvent.getY()));
    }

    protected cW getHitInfo(double d2, double d3) {
        this.c = this.b(d2, d3, true);
        return this.c;
    }

    protected cW getLastHitInfo() {
        return this.c;
    }

    public void setLastHitInfo(cW cW2) {
        this.c = cW2;
    }

    public void mousePressedLeft(double d2, double d3) {
    }

    public void mouseShiftPressedLeft(double d2, double d3) {
        this.mousePressedLeft(d2, d3);
    }

    public void mouseShiftPressedRight(double d2, double d3) {
        this.mousePressedRight(d2, d3);
    }

    public void mouseShiftPressedMiddle(double d2, double d3) {
        this.mousePressedMiddle(d2, d3);
    }

    public void mousePressedMiddle(double d2, double d3) {
    }

    public void mousePressedRight(double d2, double d3) {
    }

    public void mouseReleased(double d2, double d3) {
    }

    public void mouseReleasedLeft(double d2, double d3) {
    }

    public void mouseShiftReleasedLeft(double d2, double d3) {
        this.mouseReleasedLeft(d2, d3);
    }

    public void mouseShiftReleasedRight(double d2, double d3) {
        this.mouseReleasedRight(d2, d3);
    }

    public void mouseReleasedMiddle(double d2, double d3) {
    }

    public void mouseShiftReleasedMiddle(double d2, double d3) {
        this.mouseReleasedMiddle(d2, d3);
    }

    public void mouseReleasedRight(double d2, double d3) {
    }

    public void mouseDraggedLeft(double d2, double d3) {
    }

    public void mouseDraggedMiddle(double d2, double d3) {
    }

    public void mouseDraggedRight(double d2, double d3) {
    }

    public void mouseClicked(double d2, double d3) {
    }

    public void mouseMoved(double d2, double d3) {
    }

    private boolean b(int n2, int n3) {
        int n4 = n2 - this.k;
        int n5 = n3 - this.m;
        if (!this.g) return false;
        if (n4 * n4 + n5 * n5 >= 9) return false;
        return true;
    }

    protected boolean isModifierPressed(MouseEvent mouseEvent) {
        if ((mouseEvent.getModifiers() & this.j) == 0) return false;
        return true;
    }

    void c(boolean bl2) {
        this.l = bl2;
    }

    boolean b() {
        return this.l;
    }

    public int getModifierMask() {
        return this.j;
    }

    public void setModifierMask(int n2) {
        int n3 = this.j;
        if (n3 == n2) return;
        this.j = n2;
        this.firePropertyChange("modifierMask", n3, n2);
    }

    private void b(boolean bl2) {
        this.n = bl2;
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

