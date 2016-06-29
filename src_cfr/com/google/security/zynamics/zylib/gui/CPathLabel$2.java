/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.gui.CPathLabel;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

class CPathLabel$2
extends ComponentAdapter {
    final /* synthetic */ CPathLabel this$0;

    CPathLabel$2(CPathLabel cPathLabel) {
        this.this$0 = cPathLabel;
    }

    @Override
    public void componentResized(ComponentEvent componentEvent) {
        this.this$0.updatePathEllipsis();
    }
}

