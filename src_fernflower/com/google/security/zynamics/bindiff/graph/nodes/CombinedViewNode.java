package com.google.security.zynamics.bindiff.graph.nodes;

import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.CViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IGroupNode;
import com.google.security.zynamics.zylib.types.graphs.IGraphNode;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public abstract class CombinedViewNode extends CViewNode implements IGraphNode {
   private final List children = new ArrayList();
   private final List parents = new ArrayList();

   public CombinedViewNode() {
      super(-1, 0.0D, 0.0D, 0.0D, 0.0D, Color.WHITE, Color.BLACK, false, true);
   }

   public static void link(CombinedViewNode var0, CombinedViewNode var1) {
      var0.getChildren().add(var1);
      var1.getParents().add(var0);
   }

   public static void unlink(CombinedViewNode var0, CombinedViewNode var1) {
      var0.getChildren().remove(var1);
      var1.getParents().remove(var0);
   }

   public abstract IAddress getAddress(ESide var1);

   public List getChildren() {
      return this.children;
   }

   public List getIncomingEdges() {
      return super.getIncomingEdges();
   }

   public EMatchState getMatchState() {
      return this.getRawNode(ESide.PRIMARY) == null?EMatchState.SECONDRAY_UNMATCHED:(this.getRawNode(ESide.SECONDARY) == null?EMatchState.PRIMARY_UNMATCHED:EMatchState.MATCHED);
   }

   public List getOutgoingEdges() {
      return super.getOutgoingEdges();
   }

   public IGroupNode getParentGroup() {
      return null;
   }

   public List getParents() {
      return this.parents;
   }

   public abstract SingleViewNode getRawNode(ESide var1);
}
