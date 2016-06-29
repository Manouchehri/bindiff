package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.zylib.general.ClipboardHelpers;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class CopyBasicBlockAddressAction extends AbstractAction {
   private final SingleDiffNode node;

   public CopyBasicBlockAddressAction(CombinedDiffNode var1, ESide var2) {
      super(var2 == ESide.PRIMARY?"Copy Primary Basic Block Address":"Copy Secondary Basic Block Address");
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var2);
      this.node = var2 == ESide.PRIMARY?var1.getPrimaryDiffNode():var1.getSecondaryDiffNode();
      Preconditions.checkNotNull(var1);
   }

   public CopyBasicBlockAddressAction(SingleDiffNode var1) {
      super("Copy Basic Block Address");
      this.node = (SingleDiffNode)Preconditions.checkNotNull(var1);
   }

   public void actionPerformed(ActionEvent var1) {
      RawBasicBlock var2 = (RawBasicBlock)this.node.getRawNode();
      ClipboardHelpers.copyToClipboard(var2.getAddress().toHexString());
   }
}
