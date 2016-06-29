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

class MatchedFunctionViewsFilterPanel$InternalClearButtonLister implements ActionListener
{
    final /* synthetic */ MatchedFunctionViewsFilterPanel this$0;
    
    private MatchedFunctionViewsFilterPanel$InternalClearButtonLister(final MatchedFunctionViewsFilterPanel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.this$0.searchCombobox.reset();
        this.this$0.clearButton.setIcon(MatchedFunctionViewsFilterPanel.ICON_CLEAR_GRAY);
    }
}
