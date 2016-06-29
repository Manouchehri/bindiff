package com.google.security.zynamics.bindiff.gui.tabpanels;

import java.awt.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.common.base.*;

final class TabPanelManager$ColorSlot
{
    protected final Color color;
    protected Diff diff;
    protected IDiffListener diffListener;
    
    private TabPanelManager$ColorSlot(final Color color) {
        this.color = (Color)Preconditions.checkNotNull(color);
        this.diff = null;
        this.diffListener = null;
    }
    
    protected static TabPanelManager$ColorSlot make(final Color color) {
        return new TabPanelManager$ColorSlot(color);
    }
}
