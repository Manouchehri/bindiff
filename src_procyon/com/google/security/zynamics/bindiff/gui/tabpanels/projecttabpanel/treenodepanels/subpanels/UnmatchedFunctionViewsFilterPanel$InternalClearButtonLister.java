package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels;

import java.awt.event.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.*;
import com.google.security.zynamics.bindiff.gui.components.viewsearchfield.*;
import java.util.*;
import com.google.security.zynamics.zylib.general.*;
import java.awt.*;
import javax.swing.border.*;
import com.google.security.zynamics.bindiff.utils.*;

class UnmatchedFunctionViewsFilterPanel$InternalClearButtonLister implements ActionListener
{
    final /* synthetic */ UnmatchedFunctionViewsFilterPanel this$0;
    
    private UnmatchedFunctionViewsFilterPanel$InternalClearButtonLister(final UnmatchedFunctionViewsFilterPanel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.this$0.searchCombobox.reset();
        this.this$0.clearButton.setIcon(UnmatchedFunctionViewsFilterPanel.ICON_CLEAR_GRAY);
    }
}
