package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels;

import javax.swing.event.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.util.*;

class FunctionDiffViewsNodeContextPanel$InternalTableModelListener implements TableModelListener
{
    final /* synthetic */ FunctionDiffViewsNodeContextPanel this$0;
    
    private FunctionDiffViewsNodeContextPanel$InternalTableModelListener(final FunctionDiffViewsNodeContextPanel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void tableChanged(final TableModelEvent tableModelEvent) {
        this.this$0.updateBorderTitle();
    }
}
