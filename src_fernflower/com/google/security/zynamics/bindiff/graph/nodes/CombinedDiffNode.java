package com.google.security.zynamics.bindiff.graph.nodes;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedViewNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperViewNode;
import com.google.security.zynamics.zylib.types.graphs.IGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import java.util.ArrayList;
import java.util.List;
import y.c.q;

public class CombinedDiffNode extends ZyGraphNode implements IGraphNode {
   private final SuperDiffNode superDiffNode;
   private final SingleDiffNode primaryDiffNode;
   private final SingleDiffNode secondaryDiffNode;
   private final List parents = new ArrayList();
   private final List children = new ArrayList();

   public CombinedDiffNode(q var1, IZyNodeRealizer var2, CombinedViewNode var3, SuperDiffNode var4) {
      super(var1, var2, var3);
      Preconditions.checkNotNull(var4);
      this.superDiffNode = var4;
      this.primaryDiffNode = var4.getPrimaryDiffNode();
      this.secondaryDiffNode = var4.getSecondaryDiffNode();
   }

   public static void link(CombinedDiffNode var0, CombinedDiffNode var1) {
      var0.children.add(var1);
      var1.parents.add(var0);
   }

   public static void unlink(CombinedDiffNode var0, CombinedDiffNode var1) {
      var0.children.remove(var1);
      var1.parents.remove(var0);
   }

   public List getChildren() {
      return new ArrayList(this.children);
   }

   public List getParents() {
      return new ArrayList(this.parents);
   }

   public CombinedViewNode getRawNode() {
      return (CombinedViewNode)super.getRawNode();
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

   public SuperDiffNode getSuperDiffNode() {
      return this.superDiffNode;
   }

   public SuperViewNode getSuperRawNode() {
      return this.superDiffNode.getRawNode();
   }
}
