/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.mainsettings.panels;

import com.google.security.zynamics.bindiff.gui.dialogs.mainsettings.panels.LoggingPanel;
import com.google.security.zynamics.bindiff.gui.dialogs.mainsettings.panels.LoggingPanel$1;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LoggingPanel$InternalLogFileDirectoryListener
implements ActionListener {
    final /* synthetic */ LoggingPanel this$0;

    private LoggingPanel$InternalLogFileDirectoryListener(LoggingPanel loggingPanel) {
        this.this$0 = loggingPanel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String string = LoggingPanel.access$100(this.this$0.getParent());
        if (string == null) return;
        LoggingPanel.access$200(this.this$0).setText(string);
    }

    /* synthetic */ LoggingPanel$InternalLogFileDirectoryListener(LoggingPanel loggingPanel, LoggingPanel$1 loggingPanel$1) {
        this(loggingPanel);
    }
}

