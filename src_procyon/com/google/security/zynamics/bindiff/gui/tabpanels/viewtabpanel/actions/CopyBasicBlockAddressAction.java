package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions;

import javax.swing.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.common.base.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.project.rawflowgraph.*;
import com.google.security.zynamics.zylib.general.*;

public class CopyBasicBlockAddressAction extends AbstractAction
{
    private final SingleDiffNode node;
    
    public CopyBasicBlockAddressAction(final CombinedDiffNode combinedDiffNode, final ESide eSide) {
        super((eSide == ESide.PRIMARY) ? "Copy Primary Basic Block Address" : "Copy Secondary Basic Block Address");
        Preconditions.checkNotNull(combinedDiffNode);
        Preconditions.checkNotNull(eSide);
        this.node = ((eSide == ESide.PRIMARY) ? combinedDiffNode.getPrimaryDiffNode() : combinedDiffNode.getSecondaryDiffNode());
        Preconditions.checkNotNull(combinedDiffNode);
    }
    
    public CopyBasicBlockAddressAction(final SingleDiffNode singleDiffNode) {
        super("Copy Basic Block Address");
        this.node = (SingleDiffNode)Preconditions.checkNotNull(singleDiffNode);
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        ClipboardHelpers.copyToClipboard(((RawBasicBlock)this.node.getRawNode()).getAddress().toHexString());
    }
}
