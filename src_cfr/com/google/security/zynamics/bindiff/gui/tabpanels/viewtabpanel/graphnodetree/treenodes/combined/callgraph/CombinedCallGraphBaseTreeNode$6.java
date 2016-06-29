/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.callgraph;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.callgraph.CombinedCallGraphBaseTreeNode;
import com.google.security.zynamics.bindiff.project.matches.DiffMetaData;
import com.google.security.zynamics.zylib.general.ClipboardHelpers;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class CombinedCallGraphBaseTreeNode$6
extends AbstractAction {
    final /* synthetic */ CombinedCallGraphBaseTreeNode this$0;

    CombinedCallGraphBaseTreeNode$6(CombinedCallGraphBaseTreeNode combinedCallGraphBaseTreeNode, String string) {
        this.this$0 = combinedCallGraphBaseTreeNode;
        super(string);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String string = CombinedCallGraphBaseTreeNode.access$500(this.this$0).getMetaData().getIdbName(ESide.SECONDARY);
        ClipboardHelpers.copyToClipboard(string);
    }
}

