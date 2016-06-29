/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.components.graphsearchfield;

import com.google.security.zynamics.bindiff.gui.components.graphsearchfield.GraphSearchField;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicComboBoxEditor;

class GraphSearchField$3
extends BasicComboBoxEditor {
    final /* synthetic */ GraphSearchField this$0;

    GraphSearchField$3(GraphSearchField graphSearchField) {
        this.this$0 = graphSearchField;
    }

    @Override
    protected JTextField createEditorComponent() {
        return GraphSearchField.access$700(this.this$0);
    }
}

