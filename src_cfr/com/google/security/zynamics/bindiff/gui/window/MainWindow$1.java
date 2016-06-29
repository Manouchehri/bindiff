/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.window;

import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

class MainWindow$1
extends ComponentAdapter {
    final /* synthetic */ MainWindow this$0;

    MainWindow$1(MainWindow mainWindow) {
        this.this$0 = mainWindow;
    }

    @Override
    public void componentResized(ComponentEvent componentEvent) {
        MainWindow.access$200(this.this$0);
    }
}

