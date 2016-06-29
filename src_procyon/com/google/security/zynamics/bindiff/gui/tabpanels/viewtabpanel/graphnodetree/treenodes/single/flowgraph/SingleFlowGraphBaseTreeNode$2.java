package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.flowgraph;

import java.awt.event.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import java.util.*;
import javax.swing.tree.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.*;
import com.google.security.zynamics.bindiff.graph.filter.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.project.userview.*;
import com.google.security.zynamics.bindiff.utils.*;

class SingleFlowGraphBaseTreeNode$2 extends AbstractAction
{
    final /* synthetic */ ESide val$side;
    final /* synthetic */ SingleFlowGraphBaseTreeNode this$0;
    
    SingleFlowGraphBaseTreeNode$2(final SingleFlowGraphBaseTreeNode this$0, final String s, final ESide val$side) {
        this.this$0 = this$0;
        this.val$side = val$side;
        super(s);
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        ClipboardHelpers.copyToClipboard(((FlowGraphViewData)this.this$0.getView()).getFunctionName(this.val$side));
    }
}
