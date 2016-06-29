/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.ClipboardHelpers;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class CopyFunctionAddressAction
extends AbstractAction {
    private final SingleDiffNode node;

    public CopyFunctionAddressAction(CombinedDiffNode combinedDiffNode, ESide eSide) {
        super(eSide == ESide.PRIMARY ? "Copy Primary Function Address" : "Copy Secondary Function Address");
        Preconditions.checkNotNull(combinedDiffNode);
        Preconditions.checkNotNull((Object)eSide);
        this.node = eSide == ESide.PRIMARY ? combinedDiffNode.getPrimaryDiffNode() : combinedDiffNode.getSecondaryDiffNode();
        Preconditions.checkNotNull(combinedDiffNode);
    }

    public CopyFunctionAddressAction(SingleDiffNode singleDiffNode) {
        super("Copy Function Address");
        this.node = (SingleDiffNode)Preconditions.checkNotNull(singleDiffNode);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ClipboardHelpers.copyToClipboard(((RawFunction)this.node.getRawNode()).getAddress().toHexString());
    }
}

