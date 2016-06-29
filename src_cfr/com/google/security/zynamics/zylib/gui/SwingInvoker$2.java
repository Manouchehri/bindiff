/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.gui.SwingInvoker;

class SwingInvoker$2
implements Runnable {
    final /* synthetic */ SwingInvoker this$0;

    SwingInvoker$2(SwingInvoker swingInvoker) {
        this.this$0 = swingInvoker;
    }

    @Override
    public void run() {
        this.this$0.operation();
    }
}

