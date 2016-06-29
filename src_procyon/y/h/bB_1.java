package y.h;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

final class bB extends JComponent
{
    final bC a;
    
    public bB() {
        this.addContainerListener(this.a = new bC(this));
        this.setSize(0, 0);
        this.setLayout(null);
        this.setVisible(true);
        this.setOpaque(true);
        this.setDoubleBuffered(false);
        this.putClientProperty("JCOMPONENT_PARENT_KEY", this);
    }
    
    public boolean isValidateRoot() {
        return true;
    }
    
    public Rectangle getBounds() {
        return new Rectangle(0, 0, this.getParent().getWidth(), this.getParent().getHeight());
    }
    
    public void paint(final Graphics graphics) {
    }
    
    final void a(final Component component) {
        final boolean z = fj.z;
        if (component instanceof JComponent) {
            final JComponent component2 = (JComponent)component;
            if (component2.getClientProperty("JCOMPONENT_PARENT_KEY") != this) {
                component2.addContainerListener(this.a);
                if (component2.isDoubleBuffered()) {
                    component2.putClientProperty("Graph2DView.WAS_DOUBLE_BUFFERED", Boolean.TRUE);
                    component2.setDoubleBuffered(false);
                }
                component2.putClientProperty("JCOMPONENT_PARENT_KEY", this);
                int i = component2.getComponentCount() - 1;
                while (i >= 0) {
                    this.a(component2.getComponent(i));
                    --i;
                    if (z) {
                        break;
                    }
                }
            }
        }
    }
    
    final void b(final Component component) {
        final boolean z = fj.z;
        if (component instanceof JComponent) {
            final JComponent component2 = (JComponent)component;
            if (component2.getClientProperty("JCOMPONENT_PARENT_KEY") == this) {
                component2.removeContainerListener(this.a);
                if (component2.getClientProperty("Graph2DView.WAS_DOUBLE_BUFFERED") == Boolean.TRUE) {
                    component2.setDoubleBuffered(true);
                    component2.putClientProperty("Graph2DView.WAS_DOUBLE_BUFFERED", null);
                }
                component2.putClientProperty("JCOMPONENT_PARENT_KEY", null);
            }
            int i = component2.getComponentCount() - 1;
            while (i >= 0) {
                this.b(component2.getComponent(i));
                --i;
                if (z) {
                    break;
                }
            }
        }
    }
    
    public void paintImmediately(final Rectangle rectangle) {
    }
    
    protected void printComponent(final Graphics graphics) {
    }
    
    protected void printChildren(final Graphics graphics) {
    }
    
    protected void printBorder(final Graphics graphics) {
    }
    
    public void printAll(final Graphics graphics) {
    }
    
    public void print(final Graphics graphics) {
    }
    
    public void paintImmediately(final int n, final int n2, final int n3, final int n4) {
    }
    
    protected void paintComponent(final Graphics graphics) {
    }
    
    protected void paintChildren(final Graphics graphics) {
    }
    
    protected void paintBorder(final Graphics graphics) {
    }
    
    public Cursor getCursor() {
        return Cursor.getDefaultCursor();
    }
}
