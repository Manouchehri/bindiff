package com.google.security.zynamics.bindiff.gui.components.viewsearchfield;

import com.google.security.zynamics.zylib.gui.comboboxes.memorybox.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.*;
import com.google.common.base.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.bindiff.enums.*;
import java.util.regex.*;
import com.google.security.zynamics.bindiff.resources.*;

class TableTextSearchComboBox$InternalKeyListener extends KeyAdapter
{
    final /* synthetic */ TableTextSearchComboBox this$0;
    
    private TableTextSearchComboBox$InternalKeyListener(final TableTextSearchComboBox this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void keyTyped(final KeyEvent keyEvent) {
        if (keyEvent.getKeyChar() == '\n') {
            if ("".equals(this.this$0.getText())) {
                final Iterator iterator = this.this$0.listeners.iterator();
                while (iterator.hasNext()) {
                    iterator.next().reset();
                }
                this.this$0.getEditor().getEditorComponent().setBackground(TableTextSearchComboBox.BACKGROUND_COLOR_SUCCESS);
            }
            else {
                this.this$0.search(keyEvent.getModifiersEx() == 128);
            }
        }
    }
}
