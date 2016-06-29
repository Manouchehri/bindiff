package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.utils.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.*;
import javax.swing.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.project.diff.*;

class ViewMenu$InternalViewListener implements ISavableListener
{
    final /* synthetic */ ViewMenu this$0;
    
    private ViewMenu$InternalViewListener(final ViewMenu this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void isSavable(final boolean enabled) {
        if (!this.this$0.viewTabPanelController.getGraphs().getDiff().isFunctionDiff()) {
            if (this.this$0.saveView.isEnabled() != enabled) {
                this.this$0.saveView.setEnabled(enabled);
            }
        }
        else {
            this.this$0.saveView.setEnabled(true);
        }
    }
}
