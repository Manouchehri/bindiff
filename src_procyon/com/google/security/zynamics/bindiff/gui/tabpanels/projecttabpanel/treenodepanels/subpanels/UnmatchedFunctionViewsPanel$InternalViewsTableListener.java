package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.common.base.*;
import javax.swing.border.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

class UnmatchedFunctionViewsPanel$InternalViewsTableListener implements IUnmatchedFunctionsViewsTableListener
{
    final /* synthetic */ UnmatchedFunctionViewsPanel this$0;
    
    private UnmatchedFunctionViewsPanel$InternalViewsTableListener(final UnmatchedFunctionViewsPanel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void rowSelectionChanged(final UnmatchedFunctionViewsTable unmatchedFunctionViewsTable) {
    }
    
    @Override
    public void tableDataChanged(final UnmatchedFunctionViewsTableModel unmatchedFunctionViewsTableModel) {
        this.this$0.updateBorderTitle();
    }
}
