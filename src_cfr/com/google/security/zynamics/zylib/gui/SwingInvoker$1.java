/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.gui.SwingInvoker;

class SwingInvoker$1
implements Runnable {
    final /* synthetic */ SwingInvoker this$0;

    SwingInvoker$1(SwingInvoker swingInvoker) {
        this.this$0 = swingInvoker;
    }

    @Override
    public void run() {
        this.this$0.operation();
    }
}

