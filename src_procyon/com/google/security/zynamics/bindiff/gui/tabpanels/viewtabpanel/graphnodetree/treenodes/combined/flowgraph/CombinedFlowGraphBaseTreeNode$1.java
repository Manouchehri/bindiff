package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph;

import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import javax.swing.tree.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.*;
import com.google.security.zynamics.bindiff.graph.filter.*;
import java.util.*;
import com.google.security.zynamics.bindiff.project.helpers.*;
import com.google.security.zynamics.bindiff.project.rawflowgraph.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.project.userview.*;
import com.google.security.zynamics.bindiff.utils.*;

class CombinedFlowGraphBaseTreeNode$1 extends AbstractAction
{
    final /* synthetic */ CombinedFlowGraphBaseTreeNode this$0;
    
    CombinedFlowGraphBaseTreeNode$1(final CombinedFlowGraphBaseTreeNode this$0, final String s) {
        this.this$0 = this$0;
        super(s);
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        ClipboardHelpers.copyToClipboard(((FlowGraphViewData)this.this$0.getView()).getAddress(ESide.PRIMARY).toHexString());
    }
}
