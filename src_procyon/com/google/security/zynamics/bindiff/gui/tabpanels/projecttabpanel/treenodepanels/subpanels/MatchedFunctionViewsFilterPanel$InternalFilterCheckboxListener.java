package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels;

import javax.swing.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.*;
import com.google.security.zynamics.bindiff.gui.components.viewsearchfield.*;
import java.awt.event.*;
import java.util.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.bindiff.enums.*;
import javax.swing.border.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.utils.*;

class MatchedFunctionViewsFilterPanel$InternalFilterCheckboxListener implements ItemListener
{
    final /* synthetic */ MatchedFunctionViewsFilterPanel this$0;
    
    private MatchedFunctionViewsFilterPanel$InternalFilterCheckboxListener(final MatchedFunctionViewsFilterPanel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void itemStateChanged(final ItemEvent itemEvent) {
        final boolean selected = this.this$0.showStructuralChangedFunctions.isSelected();
        final boolean selected2 = this.this$0.showInstructionChangedOnlyFunctions.isSelected();
        final boolean selected3 = this.this$0.showIdenticalFunctions.isSelected();
        final Iterator iterator = this.this$0.checkBoxFilterListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().functionViewsFilterChanged(selected, selected2, selected3);
        }
        this.this$0.clearButton.setIcon(MatchedFunctionViewsFilterPanel.ICON_CLEAR_GRAY);
        this.this$0.updateUI();
    }
}
