/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.utils;

import javax.swing.JComponent;

final class GuiUtils$1
implements Runnable {
    final /* synthetic */ JComponent val$component;

    GuiUtils$1(JComponent jComponent) {
        this.val$component = jComponent;
    }

    @Override
    public void run() {
        this.val$component.updateUI();
    }
}

