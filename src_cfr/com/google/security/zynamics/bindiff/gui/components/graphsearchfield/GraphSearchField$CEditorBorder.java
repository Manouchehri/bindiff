/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.components.graphsearchfield;

import com.google.security.zynamics.bindiff.gui.components.graphsearchfield.GraphSearchField;
import com.google.security.zynamics.bindiff.gui.components.graphsearchfield.GraphSearchField$1;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.border.AbstractBorder;
import javax.swing.plaf.metal.MetalLookAndFeel;

final class GraphSearchField$CEditorBorder
extends AbstractBorder {
    final /* synthetic */ GraphSearchField this$0;

    private GraphSearchField$CEditorBorder(GraphSearchField graphSearchField) {
        this.this$0 = graphSearchField;
    }

    @Override
    public Insets getBorderInsets(Component component) {
        return GraphSearchField.access$800();
    }

    @Override
    public void paintBorder(Component component, Graphics graphics, int n2, int n3, int n4, int n5) {
        graphics.translate(n2, n3);
        GraphSearchField.access$900(this.this$0).paintIcon(component, graphics, n2 + 4, n3 + 5);
        graphics.setColor(MetalLookAndFeel.getControlDarkShadow());
        graphics.drawRect(0, 0, n4, n5 - 1);
        graphics.setColor(MetalLookAndFeel.getControlShadow());
        graphics.drawRect(1, 1, n4 - 2, n5 - 3);
        graphics.translate(- n2, - n3);
    }

    /* synthetic */ GraphSearchField$CEditorBorder(GraphSearchField graphSearchField, GraphSearchField$1 graphSearchField$1) {
        this(graphSearchField);
    }
}

