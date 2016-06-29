/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.components.graphsearchfield;

import com.google.security.zynamics.bindiff.gui.components.graphsearchfield.GraphSearchField;
import com.google.security.zynamics.bindiff.gui.components.graphsearchfield.GraphSearchField$1;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.JMenuItem;

final class GraphSearchField$CPopupChooserAction
extends AbstractAction {
    final /* synthetic */ GraphSearchField this$0;

    private GraphSearchField$CPopupChooserAction(GraphSearchField graphSearchField) {
        this.this$0 = graphSearchField;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JMenuItem jMenuItem = (JMenuItem)actionEvent.getSource();
        GraphSearchField.access$1000(this.this$0, jMenuItem.getIcon());
    }

    /* synthetic */ GraphSearchField$CPopupChooserAction(GraphSearchField graphSearchField, GraphSearchField$1 graphSearchField$1) {
        this(graphSearchField);
    }
}

