package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels;

import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.project.helpers.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import javax.swing.border.*;
import java.awt.*;
import javax.swing.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import java.util.*;

class MatchedFunctionsTreeNodeContextPanel$InternalFilterCheckboxListener implements IViewsFilterCheckboxListener
{
    final /* synthetic */ MatchedFunctionsTreeNodeContextPanel this$0;
    
    private MatchedFunctionsTreeNodeContextPanel$InternalFilterCheckboxListener(final MatchedFunctionsTreeNodeContextPanel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void functionViewsFilterChanged(final boolean b, final boolean b2, final boolean b3) {
        final RawCallGraph callgraph = this.this$0.diff.getCallgraph(ESide.PRIMARY);
        final RawCallGraph callgraph2 = this.this$0.diff.getCallgraph(ESide.SECONDARY);
        final HashSet matchedFunctionPairs = new HashSet();
        if (!b && !b2 && !b3) {
            matchedFunctionPairs.addAll(GraphGetter.getMatchedFunctionPairs(callgraph, callgraph2));
        }
        else {
            if (b) {
                matchedFunctionPairs.addAll(GraphGetter.getStructuralChangedFunctionPairs(callgraph, callgraph2));
            }
            if (b2) {
                matchedFunctionPairs.addAll(GraphGetter.getInstructionOnlyChangedFunctionPairs(callgraph, callgraph2));
            }
            if (b3) {
                matchedFunctionPairs.addAll(GraphGetter.getIdenticalFunctionPairs(callgraph, callgraph2));
            }
        }
        ((MatchedFunctionsViewsTableModel)this.this$0.matchedFunctionsTable.getTableModel()).setMatchedFunctionPairs(matchedFunctionPairs);
    }
}
