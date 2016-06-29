package org.jfree.ui.about;

import java.awt.event.*;

final class SystemPropertiesPanel$1 implements ActionListener
{
    private final SystemPropertiesPanel this$0;
    
    SystemPropertiesPanel$1(final SystemPropertiesPanel this$0) {
        this.this$0 = this$0;
    }
    
    public void actionPerformed(final ActionEvent actionEvent) {
        this.this$0.copySystemPropertiesToClipboard();
    }
}
