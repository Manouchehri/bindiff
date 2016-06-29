/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.components.graphsearchfield;

import com.google.security.zynamics.bindiff.gui.components.graphsearchfield.GraphSearchField;
import com.google.security.zynamics.bindiff.gui.components.graphsearchfield.GraphSearchField$1;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import javax.swing.JPopupMenu;

final class GraphSearchField$InternalMouseListener
extends MouseAdapter {
    private final JPopupMenu popupMenu;
    final /* synthetic */ GraphSearchField this$0;

    private GraphSearchField$InternalMouseListener(GraphSearchField graphSearchField) {
        this.this$0 = graphSearchField;
        this.popupMenu = GraphSearchField.access$2200(this.this$0);
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        if (mouseEvent.getX() < 0) return;
        if (mouseEvent.getX() > 38) return;
        if (this.popupMenu.isVisible()) return;
        this.popupMenu.show(this.this$0, this.this$0.getX() - 1, this.this$0.getY() + this.this$0.getHeight() - 2);
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        if (!this.popupMenu.isVisible()) return;
        if (mouseEvent.getX() <= 38) return;
        if (!(mouseEvent.getSource() instanceof JComponent)) return;
        if (mouseEvent.getY() < 0) return;
        if (mouseEvent.getY() > ((JComponent)mouseEvent.getSource()).getHeight()) return;
        this.popupMenu.setVisible(false);
    }

    /* synthetic */ GraphSearchField$InternalMouseListener(GraphSearchField graphSearchField, GraphSearchField$1 graphSearchField$1) {
        this(graphSearchField);
    }
}

