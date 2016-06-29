package y.h;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

final class hA extends RepaintManager
{
    private final RepaintManager a;
    
    protected hA(final RepaintManager a) {
        this.a = a;
    }
    
    public static hA a(final JComponent component) {
        final RepaintManager currentManager = RepaintManager.currentManager(component);
        if (((hA)currentManager).getClass() != ((hw.a == null) ? (hw.a = hw.a("y.h.hA")) : hw.a)) {
            final hA currentManager2 = new hA(currentManager);
            component.putClientProperty("CustomRepaintManager.Instance", currentManager2);
            RepaintManager.setCurrentManager(currentManager2);
            return currentManager2;
        }
        return (hA)currentManager;
    }
    
    public void b(final JComponent component) {
        if (RepaintManager.currentManager(component) == this) {
            component.putClientProperty("CustomRepaintManager.Instance", null);
            RepaintManager.setCurrentManager(this.a);
        }
    }
    
    public Image getOffscreenBuffer(final Component component, final int n, final int n2) {
        return this.a.getOffscreenBuffer(component, n, n2);
    }
    
    public Image getVolatileOffscreenBuffer(final Component component, final int n, final int n2) {
        return this.a.getVolatileOffscreenBuffer(component, n, n2);
    }
    
    public void setDoubleBufferingEnabled(final boolean doubleBufferingEnabled) {
        this.a.setDoubleBufferingEnabled(doubleBufferingEnabled);
    }
    
    public void setDoubleBufferMaximumSize(final Dimension doubleBufferMaximumSize) {
        this.a.setDoubleBufferMaximumSize(doubleBufferMaximumSize);
    }
    
    public void removeInvalidComponent(final JComponent component) {
        this.a.removeInvalidComponent(component);
    }
    
    public void markCompletelyDirty(final JComponent component) {
        if (component.getClientProperty("JCOMPONENT_PARENT_KEY") != null) {
            this.addDirtyRegion(component, 0, 0, component.getWidth(), component.getHeight());
            if (!fj.z) {
                return;
            }
        }
        this.a.markCompletelyDirty(component);
    }
    
    public void addInvalidComponent(JComponent component) {
        final boolean z = fj.z;
        final bB bb = (bB)component.getClientProperty("JCOMPONENT_PARENT_KEY");
        if (bb != null) {
            while (component.getParent() != bb && !component.isValidateRoot()) {
                component = (JComponent)component.getParent();
                if (z) {
                    break;
                }
            }
            this.a.addInvalidComponent(bb);
            if (!z) {
                return;
            }
        }
        this.a.addInvalidComponent(component);
    }
    
    public Rectangle getDirtyRegion(final JComponent component) {
        if (component.getClientProperty("JCOMPONENT_PARENT_KEY") != null) {
            return new Rectangle();
        }
        return this.a.getDirtyRegion(component);
    }
    
    public boolean isCompletelyDirty(final JComponent component) {
        if (component.getClientProperty("JCOMPONENT_PARENT_KEY") != null) {
            final boolean completelyDirty = false;
            if (!fj.z) {
                return completelyDirty;
            }
        }
        return this.a.isCompletelyDirty(component);
    }
    
    public void markCompletelyClean(final JComponent component) {
        if (component.getClientProperty("JCOMPONENT_PARENT_KEY") == null) {
            this.a.markCompletelyClean(component);
        }
    }
    
    public void addDirtyRegion(JComponent component, int viewCoordX, int viewCoordY, int n, int n2) {
        final boolean z = fj.z;
        if (n < 1 || n2 < 1) {
            return;
        }
        if (component instanceof bB) {
            return;
        }
        final bB bb = (bB)component.getClientProperty("JCOMPONENT_PARENT_KEY");
        if (bb != null) {
            hz hz = (hz)component.getClientProperty("FloatingJComponent.Instance");
            while (hz == null && component != bb) {
                viewCoordX += component.getX();
                viewCoordY += component.getY();
                component = (JComponent)component.getParent();
                hz = (hz)component.getClientProperty("FloatingJComponent.Instance");
                if (z) {
                    break;
                }
            }
            if (hz == null) {
                return;
            }
            final Rectangle2D.Double double1 = new Rectangle2D.Double();
            hz.a(new Rectangle(viewCoordX, viewCoordY, n, n2), double1);
            final JComponent component2 = (JComponent)bb.getParent();
            final ch ch = (ch)component2.getParent();
            viewCoordX = ch.toViewCoordX(double1.x);
            viewCoordY = ch.toViewCoordY(double1.y);
            n = (int)Math.ceil(double1.width * ch.getZoom());
            n2 = (int)Math.ceil(double1.height * ch.getZoom());
            if (viewCoordX < 1) {
                n += viewCoordX;
                viewCoordX = 1;
            }
            if (viewCoordY < 1) {
                n2 += viewCoordY;
                viewCoordY = 1;
            }
            this.a.addDirtyRegion(component2, viewCoordX - 1, viewCoordY - 1, n + 2, n2 + 2);
            if (!z) {
                return;
            }
        }
        this.a.addDirtyRegion(component, viewCoordX, viewCoordY, n, n2);
    }
    
    public void validateInvalidComponents() {
        this.a.validateInvalidComponents();
    }
    
    public String toString() {
        return "Wrapped : " + this.a.toString();
    }
    
    public void paintDirtyRegions() {
        this.a.paintDirtyRegions();
    }
    
    public Dimension getDoubleBufferMaximumSize() {
        return this.a.getDoubleBufferMaximumSize();
    }
    
    public boolean isDoubleBufferingEnabled() {
        return this.a.isDoubleBufferingEnabled();
    }
}
