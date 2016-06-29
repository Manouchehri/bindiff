/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;
import javax.swing.RepaintManager;
import y.h.bB;
import y.h.ch;
import y.h.fj;
import y.h.hw;
import y.h.hz;

final class hA
extends RepaintManager {
    private final RepaintManager a;

    protected hA(RepaintManager repaintManager) {
        this.a = repaintManager;
    }

    public static hA a(JComponent jComponent) {
        RepaintManager repaintManager = RepaintManager.currentManager(jComponent);
        Class class_ = hw.a == null ? (hw.a = hw.a("y.h.hA")) : hw.a;
        if (repaintManager.getClass() == class_) return (hA)repaintManager;
        hA hA2 = new hA(repaintManager);
        jComponent.putClientProperty("CustomRepaintManager.Instance", hA2);
        RepaintManager.setCurrentManager(hA2);
        return hA2;
    }

    public void b(JComponent jComponent) {
        if (RepaintManager.currentManager(jComponent) != this) return;
        jComponent.putClientProperty("CustomRepaintManager.Instance", null);
        RepaintManager.setCurrentManager(this.a);
    }

    @Override
    public Image getOffscreenBuffer(Component component, int n2, int n3) {
        return this.a.getOffscreenBuffer(component, n2, n3);
    }

    @Override
    public Image getVolatileOffscreenBuffer(Component component, int n2, int n3) {
        return this.a.getVolatileOffscreenBuffer(component, n2, n3);
    }

    @Override
    public void setDoubleBufferingEnabled(boolean bl2) {
        this.a.setDoubleBufferingEnabled(bl2);
    }

    @Override
    public void setDoubleBufferMaximumSize(Dimension dimension) {
        this.a.setDoubleBufferMaximumSize(dimension);
    }

    @Override
    public void removeInvalidComponent(JComponent jComponent) {
        this.a.removeInvalidComponent(jComponent);
    }

    @Override
    public void markCompletelyDirty(JComponent jComponent) {
        bB bB2 = (bB)jComponent.getClientProperty("JCOMPONENT_PARENT_KEY");
        if (bB2 != null) {
            this.addDirtyRegion(jComponent, 0, 0, jComponent.getWidth(), jComponent.getHeight());
            if (!fj.z) return;
        }
        this.a.markCompletelyDirty(jComponent);
    }

    @Override
    public void addInvalidComponent(JComponent jComponent) {
        boolean bl2 = fj.z;
        bB bB2 = (bB)jComponent.getClientProperty("JCOMPONENT_PARENT_KEY");
        if (bB2 != null) {
            while (jComponent.getParent() != bB2 && !jComponent.isValidateRoot()) {
                jComponent = (JComponent)jComponent.getParent();
                if (!bl2) continue;
            }
            this.a.addInvalidComponent(bB2);
            if (!bl2) return;
        }
        this.a.addInvalidComponent(jComponent);
    }

    @Override
    public Rectangle getDirtyRegion(JComponent jComponent) {
        bB bB2 = (bB)jComponent.getClientProperty("JCOMPONENT_PARENT_KEY");
        if (bB2 == null) return this.a.getDirtyRegion(jComponent);
        return new Rectangle();
    }

    @Override
    public boolean isCompletelyDirty(JComponent jComponent) {
        bB bB2 = (bB)jComponent.getClientProperty("JCOMPONENT_PARENT_KEY");
        if (bB2 == null) return this.a.isCompletelyDirty(jComponent);
        boolean bl2 = false;
        if (!fj.z) return bl2;
        return this.a.isCompletelyDirty(jComponent);
    }

    @Override
    public void markCompletelyClean(JComponent jComponent) {
        bB bB2 = (bB)jComponent.getClientProperty("JCOMPONENT_PARENT_KEY");
        if (bB2 != null) {
            return;
        }
        this.a.markCompletelyClean(jComponent);
    }

    @Override
    public void addDirtyRegion(JComponent jComponent, int n2, int n3, int n4, int n5) {
        boolean bl2 = fj.z;
        if (n4 < 1) return;
        if (n5 < 1) {
            return;
        }
        if (jComponent instanceof bB) {
            return;
        }
        bB bB2 = (bB)jComponent.getClientProperty("JCOMPONENT_PARENT_KEY");
        if (bB2 != null) {
            hz hz2 = (hz)jComponent.getClientProperty("FloatingJComponent.Instance");
            while (hz2 == null && jComponent != bB2) {
                n2 += jComponent.getX();
                n3 += jComponent.getY();
                jComponent = (JComponent)jComponent.getParent();
                hz2 = (hz)jComponent.getClientProperty("FloatingJComponent.Instance");
                if (!bl2) continue;
            }
            if (hz2 == null) return;
            Rectangle2D.Double double_ = new Rectangle2D.Double();
            hz2.a(new Rectangle(n2, n3, n4, n5), double_);
            JComponent jComponent2 = (JComponent)bB2.getParent();
            ch ch2 = (ch)jComponent2.getParent();
            n2 = ch2.toViewCoordX(double_.x);
            n3 = ch2.toViewCoordY(double_.y);
            n4 = (int)Math.ceil(double_.width * ch2.getZoom());
            n5 = (int)Math.ceil(double_.height * ch2.getZoom());
            if (n2 < 1) {
                n4 += n2;
                n2 = 1;
            }
            if (n3 < 1) {
                n5 += n3;
                n3 = 1;
            }
            this.a.addDirtyRegion(jComponent2, n2 - 1, n3 - 1, n4 + 2, n5 + 2);
            if (!bl2) return;
        }
        this.a.addDirtyRegion(jComponent, n2, n3, n4, n5);
    }

    @Override
    public void validateInvalidComponents() {
        this.a.validateInvalidComponents();
    }

    @Override
    public String toString() {
        return new StringBuffer().append("Wrapped : ").append(this.a.toString()).toString();
    }

    @Override
    public void paintDirtyRegions() {
        this.a.paintDirtyRegions();
    }

    @Override
    public Dimension getDoubleBufferMaximumSize() {
        return this.a.getDoubleBufferMaximumSize();
    }

    @Override
    public boolean isDoubleBufferingEnabled() {
        return this.a.isDoubleBufferingEnabled();
    }
}

