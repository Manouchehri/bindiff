package com.google.security.zynamics.bindiff.graph.nodes;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedViewNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperViewNode;
import com.google.security.zynamics.zylib.types.graphs.IGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import java.util.ArrayList;
import java.util.List;
import y.c.q;

public class SuperDiffNode extends ZyGraphNode implements IGraphNode {
   private final SingleDiffNode primaryDiffNode;
   private final SingleDiffNode secondaryDiffNode;
   private CombinedDiffNode combinedDiffNode;
   private final List parents = new ArrayList();
   private final List children = new ArrayList();

   public SuperDiffNode(q var1, IZyNodeRealizer var2, SuperViewNode var3, SingleDiffNode var4, SingleDiffNode var5) {
      super(var1, var2, var3);
      Preconditions.checkArgument(var4 != null || var5 != null, "Primary diff node and secondary diff node cannot be both be null.");
      this.primaryDiffNode = var4;
      this.secondaryDiffNode = var5;
   }

   public static void link(SuperDiffNode var0, SuperDiffNode var1) {
      var0.children.add(var1);
      var1.parents.add(var0);
   }

   public static void unlink(SuperDiffNode var0, SuperDiffNode var1) {
      var0.children.remove(var1);
      var1.parents.remove(var0);
   }

   public SuperViewNode getRawNode() {
      return (SuperViewNode)super.getRawNode();
   }

   public List getChildren() {
      return new ArrayList(this.children);
   }

   public CombinedDiffNode getCombinedDiffNode() {
      return this.combinedDiffNode;
   }

   public CombinedViewNode getCombinedRawNode() {
      return this.combinedDiffNode != null?this.combinedDiffNode.getRawNode():null;
   }

   public List getParents() {
      return new ArrayList(this.parents);
   }

   public SingleDiffNode getPrimaryDiffNode() {
      return this.primaryDiffNode;
   }

   public SingleViewNode getPrimaryRawNode() {
      return this.primaryDiffNode != null?this.primaryDiffNode.getRawNode():null;
   }

   public SingleDiffNode getSecondaryDiffNode() {
      return this.secondaryDiffNode;
   }

   public SingleViewNode getSecondaryRawNode() {
      return this.secondaryDiffNode != null?this.secondaryDiffNode.getRawNode():null;
   }

   public void setCombinedDiffNode(CombinedDiffNode var1) {
      Preconditions.checkNotNull(var1);
      this.combinedDiffNode = var1;
   }
}
