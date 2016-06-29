package com.google.security.zynamics.bindiff.graph.nodes;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.CViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IGroupNode;
import com.google.security.zynamics.zylib.types.graphs.IGraphNode;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public abstract class SingleViewNode extends CViewNode implements IGraphNode {
   private final IAddress address;
   private final List children = new ArrayList();
   private final List parents = new ArrayList();

   public SingleViewNode(IAddress var1, int var2, double var3, double var5, Color var7, Color var8, boolean var9, boolean var10) {
      super(var2, var3, var5, 0.0D, 0.0D, var7, var8, var9, var10);
      Preconditions.checkNotNull(var1);
      this.address = var1;
   }

   public static void link(SingleViewNode var0, SingleViewNode var1) {
      var0.getChildren().add(var1);
      var1.getParents().add(var0);
   }

   public static void unlink(SingleViewNode var0, SingleViewNode var1) {
      var0.getChildren().remove(var1);
      var1.getParents().remove(var0);
   }

   public IAddress getAddress() {
      return this.address;
   }

   public List getChildren() {
      return this.children;
   }

   public List getIncomingEdges() {
      return super.getIncomingEdges();
   }

   public abstract EMatchState getMatchState();

   public List getOutgoingEdges() {
      return super.getOutgoingEdges();
   }

   public IGroupNode getParentGroup() {
      return null;
   }

   public List getParents() {
      return this.parents;
   }

   public abstract ESide getSide();
}
