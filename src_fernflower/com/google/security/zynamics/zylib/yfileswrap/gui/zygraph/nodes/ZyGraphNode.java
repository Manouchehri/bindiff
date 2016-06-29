package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.IRawNodeAccessible;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.ISelectableNode;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.IViewableNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyNodeRealizerListener;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.helpers.IYNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode$InternalListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.List;
import y.c.q;
import y.h.bu;

public abstract class ZyGraphNode implements IRawNodeAccessible, ISelectableNode, IViewableNode, IYNode {
   private IViewNode m_rawNode;
   private final q m_node;
   private final IZyNodeRealizer m_realizer;
   private final ZyGraphNode$InternalListener m_listener;

   public ZyGraphNode(q var1, IZyNodeRealizer var2, IViewNode var3) {
      this.m_node = (q)Preconditions.checkNotNull(var1, "Node argument cannot be null");
      this.m_realizer = (IZyNodeRealizer)Preconditions.checkNotNull(var2, "Node realizer argument cannot be null");
      this.m_rawNode = (IViewNode)Preconditions.checkNotNull(var3, "Raw node argument cannot be null");
      this.m_realizer.setX(this.m_rawNode.getX());
      this.m_realizer.setY(this.m_rawNode.getY());
      this.m_realizer.setFillColor(this.m_rawNode.getColor());
      this.m_realizer.setLineColor(this.m_rawNode.getBorderColor());
      this.m_realizer.setSelected(this.m_rawNode.isSelected());
      this.getGraph().a(this.m_node, var2.getRealizer());
      this.m_listener = new ZyGraphNode$InternalListener(this, this.getGraph());
      var2.addListener(this.m_listener);
      var3.addListener(this.m_listener);
   }

   private bu getGraph() {
      return (bu)this.m_node.e();
   }

   private void updateViews() {
      if(this.getGraph() != null) {
         this.getGraph().T();
      }
   }

   protected void onSelectionChanged() {
   }

   public void addNodeModifier(IZyNodeRealizerListener var1) {
      this.m_realizer.addListener(var1);
   }

   public void calcUnionRect(Rectangle2D var1) {
      this.m_realizer.calcUnionRect(var1);
   }

   public void clearHighlighting(int var1, int var2) {
      ZyLineContent var3 = this.m_realizer.getNodeContent().getLineContent(var2);
      if(var3.clearHighlighting(var1)) {
         this.updateViews();
      }

   }

   public Double getBoundingBox() {
      return this.m_realizer.getBoundingBox();
   }

   public abstract List getChildren();

   public q getNode() {
      return this.m_node;
   }

   public abstract List getParents();

   public IViewNode getRawNode() {
      return this.m_rawNode;
   }

   public IZyNodeRealizer getRealizer() {
      return this.m_realizer;
   }

   public double getX() {
      return this.m_realizer.getX();
   }

   public double getY() {
      return this.m_realizer.getY();
   }

   public int indegree() {
      return this.m_node.b();
   }

   public boolean isSelected() {
      return this.m_realizer.isSelected();
   }

   public boolean isVisible() {
      return this.getGraph() != null;
   }

   public int outdegree() {
      return this.m_node.c();
   }

   public int positionToRow(double var1) {
      return this.m_realizer.positionToRow(var1);
   }

   public void removeNodeModifier(IZyNodeRealizerListener var1) {
      this.m_realizer.removeListener(var1);
   }

   public void setBackgroundColor(int var1, Color var2) {
      ZyLineContent var3 = this.m_realizer.getNodeContent().getLineContent(var1);
      var3.setBackgroundColor(var2);
      this.updateViews();
   }

   public void setBackgroundColor(int var1, int var2, int var3, Color var4) {
      this.m_realizer.getNodeContent().getLineContent(var1).setBackgroundColor(var2, var3, var4);
      this.updateViews();
   }

   public void setColor(int var1, Color var2) {
      ZyLineContent var3 = this.m_realizer.getNodeContent().getLineContent(var1);
      var3.setTextColor(var2);
      this.updateViews();
   }

   public void setColor(int var1, int var2, int var3, Color var4) {
      ZyLineContent var5 = this.m_realizer.getNodeContent().getLineContent(var1);
      var5.setTextColor(var2, var3, var4);
      this.updateViews();
   }

   public void setHeight(double var1) {
      this.m_realizer.setHeight(var1);
      this.updateViews();
   }

   public void setHighlighting(int var1, int var2, Color var3) {
      ZyLineContent var4 = this.m_realizer.getNodeContent().getLineContent(var2);
      if(var4.setHighlighting(var1, var3)) {
         this.updateViews();
      }

   }

   public void setHighlighting(int var1, int var2, int var3, int var4, Color var5) {
      ZyLineContent var6 = this.m_realizer.getNodeContent().getLineContent(var2);
      var6.setHighlighting(var3, var4, var1, var5);
      this.updateViews();
   }

   public void setRawNode(IViewNode var1) {
      Preconditions.checkArgument(var1.getClass().equals(this.m_rawNode.getClass()), "Error: Old node and new node have different types");
      this.m_rawNode.removeListener(this.m_listener);
      this.m_rawNode = var1;
      this.m_rawNode.addListener(this.m_listener);
   }

   public void setWidth(double var1) {
      this.m_realizer.setWidth(var1);
      this.updateViews();
   }

   // $FF: synthetic method
   static q access$000(ZyGraphNode var0) {
      return var0.m_node;
   }

   // $FF: synthetic method
   static IZyNodeRealizer access$100(ZyGraphNode var0) {
      return var0.m_realizer;
   }

   // $FF: synthetic method
   static void access$200(ZyGraphNode var0) {
      var0.updateViews();
   }

   // $FF: synthetic method
   static IViewNode access$300(ZyGraphNode var0) {
      return var0.m_rawNode;
   }
}
