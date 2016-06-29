/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import org.jfree.ui.StrokeChooserPanel;

final class StrokeChooserPanel$1
implements ActionListener {
    private final StrokeChooserPanel this$0;

    StrokeChooserPanel$1(StrokeChooserPanel strokeChooserPanel) {
        this.this$0 = strokeChooserPanel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.this$0.getSelector().transferFocus();
    }
}

