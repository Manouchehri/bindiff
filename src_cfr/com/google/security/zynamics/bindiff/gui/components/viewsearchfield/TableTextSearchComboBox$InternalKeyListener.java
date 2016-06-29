/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.components.viewsearchfield;

import com.google.security.zynamics.bindiff.gui.components.viewsearchfield.IViewSearchFieldListener;
import com.google.security.zynamics.bindiff.gui.components.viewsearchfield.TableTextSearchComboBox;
import com.google.security.zynamics.bindiff.gui.components.viewsearchfield.TableTextSearchComboBox$1;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import javax.swing.ComboBoxEditor;

class TableTextSearchComboBox$InternalKeyListener
extends KeyAdapter {
    final /* synthetic */ TableTextSearchComboBox this$0;

    private TableTextSearchComboBox$InternalKeyListener(TableTextSearchComboBox tableTextSearchComboBox) {
        this.this$0 = tableTextSearchComboBox;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        if (keyEvent.getKeyChar() != '\n') return;
        if ("".equals(TableTextSearchComboBox.access$100(this.this$0))) {
            Iterator iterator = TableTextSearchComboBox.access$200(this.this$0).iterator();
            do {
                if (!iterator.hasNext()) {
                    this.this$0.getEditor().getEditorComponent().setBackground(TableTextSearchComboBox.access$300());
                    return;
                }
                IViewSearchFieldListener iViewSearchFieldListener = (IViewSearchFieldListener)iterator.next();
                iViewSearchFieldListener.reset();
            } while (true);
        }
        TableTextSearchComboBox.access$400(this.this$0, keyEvent.getModifiersEx() == 128);
    }

    /* synthetic */ TableTextSearchComboBox$InternalKeyListener(TableTextSearchComboBox tableTextSearchComboBox, TableTextSearchComboBox$1 tableTextSearchComboBox$1) {
        this(tableTextSearchComboBox);
    }
}

