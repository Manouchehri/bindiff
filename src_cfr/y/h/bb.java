/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.event.ContainerListener;
import javax.swing.JComponent;
import y.h.bC;
import y.h.fj;

final class bB
extends JComponent {
    final bC a;

    public bB() {
        this.a = new bC(this);
        this.addContainerListener(this.a);
        this.setSize(0, 0);
        this.setLayout(null);
        this.setVisible(true);
        this.setOpaque(true);
        this.setDoubleBuffered(false);
        this.putClientProperty("JCOMPONENT_PARENT_KEY", this);
    }

    @Override
    public boolean isValidateRoot() {
        return true;
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(0, 0, this.getParent().getWidth(), this.getParent().getHeight());
    }

    @Override
    public void paint(Graphics graphics) {
    }

    final void a(Component component) {
        boolean bl2 = fj.z;
        if (!(component instanceof JComponent)) return;
        JComponent jComponent = (JComponent)component;
        if (jComponent.getClientProperty("JCOMPONENT_PARENT_KEY") == this) return;
        jComponent.addContainerListener(this.a);
        if (jComponent.isDoubleBuffered()) {
            jComponent.putClientProperty("Graph2DView.WAS_DOUBLE_BUFFERED", Boolean.TRUE);
            jComponent.setDoubleBuffered(false);
        }
        jComponent.putClientProperty("JCOMPONENT_PARENT_KEY", this);
        int n2 = jComponent.getComponentCount() - 1;
        do {
            if (n2 < 0) return;
            this.a(jComponent.getComponent(n2));
            --n2;
        } while (!bl2);
    }

    final void b(Component component) {
        boolean bl2 = fj.z;
        if (!(component instanceof JComponent)) return;
        JComponent jComponent = (JComponent)component;
        if (jComponent.getClientProperty("JCOMPONENT_PARENT_KEY") == this) {
            jComponent.removeContainerListener(this.a);
            if (jComponent.getClientProperty("Graph2DView.WAS_DOUBLE_BUFFERED") == Boolean.TRUE) {
                jComponent.setDoubleBuffered(true);
                jComponent.putClientProperty("Graph2DView.WAS_DOUBLE_BUFFERED", null);
            }
            jComponent.putClientProperty("JCOMPONENT_PARENT_KEY", null);
        }
        int n2 = jComponent.getComponentCount() - 1;
        do {
            if (n2 < 0) return;
            this.b(jComponent.getComponent(n2));
            --n2;
        } while (!bl2);
    }

    @Override
    public void paintImmediately(Rectangle rectangle) {
    }

    @Override
    protected void printComponent(Graphics graphics) {
    }

    @Override
    protected void printChildren(Graphics graphics) {
    }

    @Override
    protected void printBorder(Graphics graphics) {
    }

    @Override
    public void printAll(Graphics graphics) {
    }

    @Override
    public void print(Graphics graphics) {
    }

    @Override
    public void paintImmediately(int n2, int n3, int n4, int n5) {
    }

    @Override
    protected void paintComponent(Graphics graphics) {
    }

    @Override
    protected void paintChildren(Graphics graphics) {
    }

    @Override
    protected void paintBorder(Graphics graphics) {
    }

    @Override
    public Cursor getCursor() {
        return Cursor.getDefaultCursor();
    }
}

