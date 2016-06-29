/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.components.graphsearchfield;

import com.google.security.zynamics.bindiff.gui.components.graphsearchfield.GraphSearchField;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicComboBoxEditor;

class GraphSearchField$1
extends BasicComboBoxEditor {
    final /* synthetic */ GraphSearchField this$0;

    GraphSearchField$1(GraphSearchField graphSearchField) {
        this.this$0 = graphSearchField;
    }

    @Override
    protected JTextField createEditorComponent() {
        return GraphSearchField.access$500(this.this$0);
    }
}

