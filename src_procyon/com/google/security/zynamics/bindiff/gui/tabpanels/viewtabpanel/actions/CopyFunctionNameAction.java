package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions;

import javax.swing.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.common.base.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import com.google.security.zynamics.zylib.general.*;

public class CopyFunctionNameAction extends AbstractAction
{
    private final SingleDiffNode node;
    
    public CopyFunctionNameAction(final CombinedDiffNode combinedDiffNode, final ESide eSide) {
        super((eSide == ESide.PRIMARY) ? "Copy Primary Function Name" : "Copy Secondary Function Name");
        Preconditions.checkNotNull(combinedDiffNode);
        Preconditions.checkNotNull(eSide);
        this.node = ((eSide == ESide.PRIMARY) ? combinedDiffNode.getPrimaryDiffNode() : combinedDiffNode.getSecondaryDiffNode());
        Preconditions.checkNotNull(combinedDiffNode);
    }
    
    public CopyFunctionNameAction(final SingleDiffNode singleDiffNode) {
        super("Copy Function Name");
        this.node = (SingleDiffNode)Preconditions.checkNotNull(singleDiffNode);
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        ClipboardHelpers.copyToClipboard(((RawFunction)this.node.getRawNode()).getName());
    }
}
