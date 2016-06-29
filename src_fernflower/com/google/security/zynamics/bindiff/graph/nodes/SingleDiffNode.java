package com.google.security.zynamics.bindiff.graph.nodes;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedViewNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperViewNode;
import com.google.security.zynamics.zylib.types.graphs.IGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import java.util.ArrayList;
import java.util.List;
import y.c.q;

public class SingleDiffNode extends ZyGraphNode implements IGraphNode {
   private CombinedDiffNode combinedDiffNode;
   private SuperDiffNode superDiffNode;
   private SingleDiffNode otherSideDiffNode;
   private final ESide side;
   private final List parents = new ArrayList();
   private final List children = new ArrayList();

   public SingleDiffNode(q var1, IZyNodeRealizer var2, SingleViewNode var3, ESide var4) {
      super(var1, var2, var3);
      this.side = (ESide)Preconditions.checkNotNull(var4);
   }

   public static void link(SingleDiffNode var0, SingleDiffNode var1) {
      var0.children.add(var1);
      var1.parents.add(var0);
   }

   public static void unlink(SingleDiffNode var0, SingleDiffNode var1) {
      var0.children.remove(var1);
      var1.parents.remove(var0);
   }

   public List getChildren() {
      return new ArrayList(this.children);
   }

   public CombinedDiffNode getCombinedDiffNode() {
      return this.combinedDiffNode;
   }

   public CombinedViewNode getCombinedRawNode() {
      return this.combinedDiffNode.getRawNode();
   }

   public SingleDiffNode getOtherSideDiffNode() {
      return this.otherSideDiffNode;
   }

   public SingleViewNode getOtherSideRawNode() {
      return this.otherSideDiffNode != null?this.otherSideDiffNode.getRawNode():null;
   }

   public List getParents() {
      return new ArrayList(this.parents);
   }

   public SingleViewNode getRawNode() {
      return (SingleViewNode)super.getRawNode();
   }

   public ESide getSide() {
      return this.side;
   }

   public SuperDiffNode getSuperDiffNode() {
      return this.superDiffNode;
   }

   public SuperViewNode getSuperRawNode() {
      return this.superDiffNode.getRawNode();
   }

   public void setCombinedDiffNode(CombinedDiffNode var1) {
      Preconditions.checkNotNull(var1);
      this.combinedDiffNode = var1;
      this.superDiffNode = var1.getSuperDiffNode();
      this.otherSideDiffNode = this.side == ESide.PRIMARY?var1.getSecondaryDiffNode():var1.getPrimaryDiffNode();
   }
}
