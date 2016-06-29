/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.gui.SwingInvoker$1;
import com.google.security.zynamics.zylib.gui.SwingInvoker$2;
import javax.swing.SwingUtilities;

public abstract class SwingInvoker {
    protected abstract void operation();

    public void invokeAndWait() {
        if (SwingUtilities.isEventDispatchThread()) {
            this.operation();
            return;
        }
        try {
            SwingUtilities.invokeAndWait(new SwingInvoker$1(this));
            return;
        }
        catch (Exception var1_1) {
            return;
        }
    }

    public void invokeLater() {
        if (SwingUtilities.isEventDispatchThread()) {
            this.operation();
            return;
        }
        try {
            SwingUtilities.invokeLater(new SwingInvoker$2(this));
            return;
        }
        catch (Exception var1_1) {
            return;
        }
    }
}

