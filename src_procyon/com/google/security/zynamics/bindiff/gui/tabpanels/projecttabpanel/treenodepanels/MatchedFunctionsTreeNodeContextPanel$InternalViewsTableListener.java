package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import javax.swing.border.*;
import java.awt.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import java.util.*;

class MatchedFunctionsTreeNodeContextPanel$InternalViewsTableListener implements IMatchedFunctionsViewsTableListener
{
    final /* synthetic */ MatchedFunctionsTreeNodeContextPanel this$0;
    
    private MatchedFunctionsTreeNodeContextPanel$InternalViewsTableListener(final MatchedFunctionsTreeNodeContextPanel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void rowSelectionChanged(final MatchedFunctionViewsTable matchedFunctionViewsTable) {
        this.this$0.updateCharts(this.this$0.matchedFunctionsTable);
    }
    
    @Override
    public void tableDataChanged(final MatchedFunctionsViewsTableModel matchedFunctionsViewsTableModel) {
        this.this$0.updateCharts(this.this$0.matchedFunctionsTable);
        this.this$0.updateBorderTitle();
    }
}
