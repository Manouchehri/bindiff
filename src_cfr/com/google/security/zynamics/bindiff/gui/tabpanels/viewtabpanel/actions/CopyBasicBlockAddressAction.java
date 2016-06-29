/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.ClipboardHelpers;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class CopyBasicBlockAddressAction
extends AbstractAction {
    private final SingleDiffNode node;

    public CopyBasicBlockAddressAction(CombinedDiffNode combinedDiffNode, ESide eSide) {
        super(eSide == ESide.PRIMARY ? "Copy Primary Basic Block Address" : "Copy Secondary Basic Block Address");
        Preconditions.checkNotNull(combinedDiffNode);
        Preconditions.checkNotNull((Object)eSide);
        this.node = eSide == ESide.PRIMARY ? combinedDiffNode.getPrimaryDiffNode() : combinedDiffNode.getSecondaryDiffNode();
        Preconditions.checkNotNull(combinedDiffNode);
    }

    public CopyBasicBlockAddressAction(SingleDiffNode singleDiffNode) {
        super("Copy Basic Block Address");
        this.node = (SingleDiffNode)Preconditions.checkNotNull(singleDiffNode);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        RawBasicBlock rawBasicBlock = (RawBasicBlock)this.node.getRawNode();
        ClipboardHelpers.copyToClipboard(rawBasicBlock.getAddress().toHexString());
    }
}

