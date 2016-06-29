package org.jfree.ui.tabbedui;

import java.awt.event.*;

final class TabbedDialog$1 extends WindowAdapter
{
    private final TabbedDialog this$0;
    
    TabbedDialog$1(final TabbedDialog this$0) {
        this.this$0 = this$0;
    }
    
    public void windowClosing(final WindowEvent windowEvent) {
        this.this$0.getTabbedUI().getCloseAction().actionPerformed(new ActionEvent(this, 1001, null, 0));
    }
}
