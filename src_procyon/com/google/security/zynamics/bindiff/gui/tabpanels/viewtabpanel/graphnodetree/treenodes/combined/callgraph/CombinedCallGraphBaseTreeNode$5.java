package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.callgraph;

import java.awt.event.*;
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
import java.awt.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.utils.*;

class CombinedCallGraphBaseTreeNode$5 extends AbstractAction
{
    final /* synthetic */ CombinedCallGraphBaseTreeNode this$0;
    
    CombinedCallGraphBaseTreeNode$5(final CombinedCallGraphBaseTreeNode this$0, final String s) {
        this.this$0 = this$0;
        super(s);
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        ClipboardHelpers.copyToClipboard(this.this$0.getDiff().getMetaData().getIdbName(ESide.PRIMARY));
    }
}
