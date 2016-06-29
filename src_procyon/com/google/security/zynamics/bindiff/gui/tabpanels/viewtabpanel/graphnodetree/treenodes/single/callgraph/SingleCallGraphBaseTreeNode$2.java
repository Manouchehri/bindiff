package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.callgraph;

import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import javax.swing.tree.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.*;
import com.google.security.zynamics.bindiff.graph.filter.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.utils.*;

class SingleCallGraphBaseTreeNode$2 extends AbstractAction
{
    final /* synthetic */ ESide val$side;
    final /* synthetic */ SingleCallGraphBaseTreeNode this$0;
    
    SingleCallGraphBaseTreeNode$2(final SingleCallGraphBaseTreeNode this$0, final String s, final ESide val$side) {
        this.this$0 = this$0;
        this.val$side = val$side;
        super(s);
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        ClipboardHelpers.copyToClipboard(this.this$0.getDiff().getMetaData().getImageName(this.val$side));
    }
}
