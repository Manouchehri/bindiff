/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.callgraph;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.callgraph.SingleCallGraphBaseTreeNode;
import com.google.security.zynamics.bindiff.project.matches.DiffMetaData;
import com.google.security.zynamics.zylib.general.ClipboardHelpers;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class SingleCallGraphBaseTreeNode$1
extends AbstractAction {
    final /* synthetic */ ESide val$side;
    final /* synthetic */ SingleCallGraphBaseTreeNode this$0;

    SingleCallGraphBaseTreeNode$1(SingleCallGraphBaseTreeNode singleCallGraphBaseTreeNode, String string, ESide eSide) {
        this.this$0 = singleCallGraphBaseTreeNode;
        this.val$side = eSide;
        super(string);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String string = SingleCallGraphBaseTreeNode.access$000(this.this$0).getMetaData().getImageName(this.val$side);
        ClipboardHelpers.copyToClipboard(string);
    }
}

