/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui.about;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.jfree.ui.about.SystemPropertiesPanel;

final class SystemPropertiesPanel$1
implements ActionListener {
    private final SystemPropertiesPanel this$0;

    SystemPropertiesPanel$1(SystemPropertiesPanel systemPropertiesPanel) {
        this.this$0 = systemPropertiesPanel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.this$0.copySystemPropertiesToClipboard();
    }
}

