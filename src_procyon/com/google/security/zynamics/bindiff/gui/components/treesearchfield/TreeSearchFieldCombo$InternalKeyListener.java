package com.google.security.zynamics.bindiff.gui.components.treesearchfield;

import java.awt.event.*;
import java.util.*;
import com.google.security.zynamics.zylib.gui.comboboxes.memorybox.*;
import com.google.security.zynamics.zylib.general.*;
import javax.swing.*;

class TreeSearchFieldCombo$InternalKeyListener implements KeyListener
{
    final /* synthetic */ TreeSearchFieldCombo this$0;
    
    private TreeSearchFieldCombo$InternalKeyListener(final TreeSearchFieldCombo this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void keyPressed(final KeyEvent keyEvent) {
    }
    
    @Override
    public void keyReleased(final KeyEvent keyEvent) {
    }
    
    @Override
    public void keyTyped(final KeyEvent keyEvent) {
        if (keyEvent.getKeyChar() == '\n' && !this.this$0.getText().equals(this.this$0.lastSearchString)) {
            if (!this.this$0.getText().equals("")) {
                this.this$0.add(this.this$0.getText());
            }
            final Iterator iterator = this.this$0.listeners.iterator();
            while (iterator.hasNext()) {
                iterator.next().searchChanged(this.this$0.getText());
            }
            this.this$0.lastSearchString = this.this$0.getText();
        }
    }
}
