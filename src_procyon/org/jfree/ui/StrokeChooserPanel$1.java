package org.jfree.ui;

import java.awt.event.*;

final class StrokeChooserPanel$1 implements ActionListener
{
    private final StrokeChooserPanel this$0;
    
    StrokeChooserPanel$1(final StrokeChooserPanel this$0) {
        this.this$0 = this$0;
    }
    
    public void actionPerformed(final ActionEvent actionEvent) {
        this.this$0.getSelector().transferFocus();
    }
}
