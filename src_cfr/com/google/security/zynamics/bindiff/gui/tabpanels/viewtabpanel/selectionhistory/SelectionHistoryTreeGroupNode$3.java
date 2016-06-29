/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeGroupNode;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.ClipboardHelpers;
import java.awt.event.ActionEvent;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.AbstractAction;

class SelectionHistoryTreeGroupNode$3
extends AbstractAction {
    final /* synthetic */ SelectionHistoryTreeGroupNode this$0;

    SelectionHistoryTreeGroupNode$3(SelectionHistoryTreeGroupNode selectionHistoryTreeGroupNode, String string) {
        this.this$0 = selectionHistoryTreeGroupNode;
        super(string);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator iterator = SelectionHistoryTreeGroupNode.access$100(this.this$0).getSingleGraphSelection().iterator();
        do {
            if (!iterator.hasNext()) {
                ClipboardHelpers.copyToClipboard(stringBuilder.toString());
                return;
            }
            SingleDiffNode singleDiffNode = (SingleDiffNode)iterator.next();
            stringBuilder.append(((RawBasicBlock)singleDiffNode.getRawNode()).getAddress().toHexString());
            stringBuilder.append("\n");
        } while (true);
    }
}

