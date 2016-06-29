/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.window;

import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.gui.window.MainWindow$InternalWindowListener;

class MainWindow$InternalWindowListener$1
implements Runnable {
    final /* synthetic */ MainWindow$InternalWindowListener this$1;

    MainWindow$InternalWindowListener$1(MainWindow$InternalWindowListener internalWindowListener) {
        this.this$1 = internalWindowListener;
    }

    @Override
    public void run() {
        MainWindow.access$400(this.this$1.this$0).exitBinDiff();
    }
}

