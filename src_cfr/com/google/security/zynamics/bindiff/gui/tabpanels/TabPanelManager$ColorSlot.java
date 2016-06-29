/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.diff.IDiffListener;
import java.awt.Color;

final class TabPanelManager$ColorSlot {
    protected final Color color;
    protected Diff diff;
    protected IDiffListener diffListener;

    private TabPanelManager$ColorSlot(Color color) {
        this.color = (Color)Preconditions.checkNotNull(color);
        this.diff = null;
        this.diffListener = null;
    }

    protected static TabPanelManager$ColorSlot make(Color color) {
        return new TabPanelManager$ColorSlot(color);
    }
}

