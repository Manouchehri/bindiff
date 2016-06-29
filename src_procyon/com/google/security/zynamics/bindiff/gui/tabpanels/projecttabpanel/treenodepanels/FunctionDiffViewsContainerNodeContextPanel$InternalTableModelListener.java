package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels;

import javax.swing.event.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.util.*;

class FunctionDiffViewsContainerNodeContextPanel$InternalTableModelListener implements TableModelListener
{
    final /* synthetic */ FunctionDiffViewsContainerNodeContextPanel this$0;
    
    private FunctionDiffViewsContainerNodeContextPanel$InternalTableModelListener(final FunctionDiffViewsContainerNodeContextPanel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void tableChanged(final TableModelEvent tableModelEvent) {
        this.this$0.updateBorderTitle();
    }
}
