package com.google.security.zynamics.bindiff.utils;

import javax.swing.*;

final class GuiUtils$1 implements Runnable
{
    final /* synthetic */ JComponent val$component;
    
    GuiUtils$1(final JComponent val$component) {
        this.val$component = val$component;
    }
    
    @Override
    public void run() {
        this.val$component.updateUI();
    }
}
