package org.jfree.ui.tabbedui;

import javax.swing.*;
import javax.swing.event.*;

class AbstractTabbedUI$TabChangeHandler implements ChangeListener
{
    private final JTabbedPane pane;
    private final AbstractTabbedUI this$0;
    
    public AbstractTabbedUI$TabChangeHandler(final AbstractTabbedUI this$0, final JTabbedPane pane) {
        this.this$0 = this$0;
        this.pane = pane;
    }
    
    public void stateChanged(final ChangeEvent changeEvent) {
        this.this$0.setSelectedEditor(this.pane.getSelectedIndex());
    }
}
