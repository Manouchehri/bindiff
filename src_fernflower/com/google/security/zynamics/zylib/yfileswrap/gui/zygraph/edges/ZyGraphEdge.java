package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.gui.zygraph.edges.CBend;
import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge$1;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge$InternalListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyEdgeRealizer;
import java.util.ArrayList;
import java.util.Iterator;
import y.c.d;
import y.d.t;
import y.h.aB;
import y.h.bu;

public class ZyGraphEdge {
   private d m_edge;
   private IViewEdge m_rawEdge;
   private final ZyGraphEdge$InternalListener m_listener = new ZyGraphEdge$InternalListener(this, (ZyGraphEdge$1)null);
   private final ZyEdgeRealizer m_realizer;
   private final bu m_graph;
   private final ZyGraphNode m_targetNode;
   private final ZyGraphNode m_sourceNode;

   public ZyGraphEdge(ZyGraphNode var1, ZyGraphNode var2, d var3, ZyEdgeRealizer var4, IViewEdge var5) {
      Preconditions.checkNotNull(var1, "Source node cannot be null");
      Preconditions.checkNotNull(var2, "Target node cannot be null");
      Preconditions.checkNotNull(var3, "Edge argument cannot be null");
      Preconditions.checkNotNull(var5, "Raw edge argument cannot be null");
      this.m_sourceNode = var1;
      this.m_targetNode = var2;
      this.m_edge = var3;
      this.m_rawEdge = var5;
      this.m_realizer = var4;
      this.m_realizer.setSelected(var5.isSelected());
      this.m_realizer.setSourcePoint(new t(var5.getX1(), var5.getY1()));
      this.m_realizer.setTargetPoint(new t(var5.getX2(), var5.getY2()));
      this.m_graph = (bu)var3.a();
      this.m_graph.a((d)var3, (aB)var4);
      Iterator var6 = this.m_rawEdge.getBends().iterator();

      while(var6.hasNext()) {
         CBend var7 = (CBend)var6.next();
         this.m_realizer.addPoint(var7.getX(), var7.getY());
         var7.addListener(this.m_listener);
      }

      var4.addListener(this.m_listener);
      var5.addListener(this.m_listener);
   }

   private static bu getGraph(d var0) {
      return (bu)var0.a();
   }

   private ZyEdgeRealizer getRealizer(d var1) {
      ZyEdgeRealizer var2 = (ZyEdgeRealizer)getGraph(var1).i(var1);
      Preconditions.checkState(var2 != null, "Node does not have a realizer");
      return var2;
   }

   private void updateViews() {
      if(getGraph(this.m_edge) != null) {
         getGraph(this.m_edge).T();
      }

   }

   public void addPath(double var1, double var3) {
      this.getRealizer(this.m_edge).addPoint(var1, var3);
   }

   public void dispose() {
      Iterator var1 = this.m_rawEdge.getBends().iterator();

      while(var1.hasNext()) {
         CBend var2 = (CBend)var1.next();
         var2.removeListener(this.m_listener);
      }

      this.m_realizer.removeListener(this.m_listener);
      this.m_rawEdge.removeListener(this.m_listener);
   }

   public d getEdge() {
      return this.m_edge;
   }

   public ArrayList getPaths() {
      int var1 = this.getRealizer(this.m_edge).pointCount();
      ArrayList var2 = new ArrayList();

      for(int var3 = 0; var3 < var1; ++var3) {
         t var4 = this.getRealizer(this.m_edge).getPoint(var3);
         var2.add(new Pair(Double.valueOf(var4.a), Double.valueOf(var4.b)));
      }

      return var2;
   }

   public IViewEdge getRawEdge() {
      return this.m_rawEdge;
   }

   public ZyEdgeRealizer getRealizer() {
      return this.m_realizer;
   }

   public ZyGraphNode getSource() {
      return this.m_sourceNode;
   }

   public ZyGraphNode getTarget() {
      return this.m_targetNode;
   }

   public double getX1() {
      return this.getRealizer(this.m_edge).getSourcePoint().a;
   }

   public double getX2() {
      return this.getRealizer(this.m_edge).getTargetPoint().a;
   }

   public double getY1() {
      return this.getRealizer(this.m_edge).getSourcePoint().b;
   }

   public double getY2() {
      return this.getRealizer(this.m_edge).getTargetPoint().b;
   }

   public boolean isSelected() {
      return this.m_realizer.isSelected();
   }

   public boolean isVisible() {
      return this.m_edge.a() != null;
   }

   public void setRawEdge(IViewEdge var1) {
      this.m_rawEdge.removeListener(this.m_listener);
      this.m_rawEdge = var1;
      this.m_rawEdge.addListener(this.m_listener);
   }

   public void setX1(double var1) {
      this.getRealizer(this.m_edge).setSourcePoint(new t(var1, this.getY1()));
   }

   public void setX2(double var1) {
      this.getRealizer(this.m_edge).setTargetPoint(new t(var1, this.getY2()));
   }

   public void setY1(double var1) {
      this.getRealizer(this.m_edge).setSourcePoint(new t(this.getX1(), var1));
   }

   public void setY2(double var1) {
      this.getRealizer(this.m_edge).setTargetPoint(new t(this.getX2(), var1));
   }

   // $FF: synthetic method
   static IViewEdge access$100(ZyGraphEdge var0) {
      return var0.m_rawEdge;
   }

   // $FF: synthetic method
   static ZyGraphEdge$InternalListener access$200(ZyGraphEdge var0) {
      return var0.m_listener;
   }

   // $FF: synthetic method
   static ZyEdgeRealizer access$300(ZyGraphEdge var0) {
      return var0.m_realizer;
   }

   // $FF: synthetic method
   static void access$400(ZyGraphEdge var0) {
      var0.updateViews();
   }

   // $FF: synthetic method
   static ZyGraphNode access$500(ZyGraphEdge var0) {
      return var0.m_sourceNode;
   }

   // $FF: synthetic method
   static ZyGraphNode access$600(ZyGraphEdge var0) {
      return var0.m_targetNode;
   }

   // $FF: synthetic method
   static bu access$700(ZyGraphEdge var0) {
      return var0.m_graph;
   }

   // $FF: synthetic method
   static d access$802(ZyGraphEdge var0, d var1) {
      return var0.m_edge = var1;
   }

   // $FF: synthetic method
   static d access$800(ZyGraphEdge var0) {
      return var0.m_edge;
   }
}
