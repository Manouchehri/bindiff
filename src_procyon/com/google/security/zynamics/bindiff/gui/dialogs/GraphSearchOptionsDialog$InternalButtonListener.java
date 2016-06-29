package com.google.security.zynamics.bindiff.gui.dialogs;

import java.awt.event.*;
import com.google.security.zynamics.bindiff.graph.searchers.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.gui.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

class GraphSearchOptionsDialog$InternalButtonListener implements ActionListener
{
    final /* synthetic */ GraphSearchOptionsDialog this$0;
    
    private GraphSearchOptionsDialog$InternalButtonListener(final GraphSearchOptionsDialog this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(this.this$0.setDefaultsButton)) {
            this.this$0.searcher.setRegEx(false);
            this.this$0.searcher.setCaseSensitive(false);
            this.this$0.searcher.setOnlySelected(false);
            this.this$0.searcher.setOnlyVisible(false);
            this.this$0.regEx.setSelected(false);
            this.this$0.caseSensitive.setSelected(false);
            this.this$0.selectedOnly.setSelected(false);
            this.this$0.visibleOnly.setSelected(false);
            return;
        }
        if (actionEvent.getSource().equals(this.this$0.okButton)) {
            this.this$0.searcher.setRegEx(this.this$0.regEx.isSelected());
            this.this$0.searcher.setCaseSensitive(this.this$0.caseSensitive.isSelected());
            this.this$0.searcher.setOnlySelected(this.this$0.selectedOnly.isSelected());
            this.this$0.searcher.setOnlyVisible(this.this$0.visibleOnly.isSelected());
        }
        if (actionEvent.getSource().equals(this.this$0.cancelButton)) {
            this.this$0.regEx.setSelected(this.this$0.originalRegEx);
            this.this$0.caseSensitive.setSelected(this.this$0.originalCaseSensitive);
            this.this$0.visibleOnly.setSelected(this.this$0.originalVisibleOnly);
            this.this$0.selectedOnly.setSelected(this.this$0.originalSelectedOnly);
        }
        this.this$0.setVisible(false);
    }
}
