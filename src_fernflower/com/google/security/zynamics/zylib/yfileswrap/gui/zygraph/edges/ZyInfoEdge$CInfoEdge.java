package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges;

import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.zygraph.edges.CBend;
import com.google.security.zynamics.zylib.gui.zygraph.edges.EdgeType;
import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdge;
import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdgeListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyInfoEdge$1;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ZyInfoEdge$CInfoEdge implements IViewEdge {
   private final List m_bends;
   private final ListenerProvider m_listeners;

   private ZyInfoEdge$CInfoEdge() {
      this.m_bends = new ArrayList();
      this.m_listeners = new ListenerProvider();
   }

   public void addBend(double var1, double var3) {
      CBend var5 = new CBend(var1, var3);
      this.m_bends.add(var5);
      Iterator var6 = this.m_listeners.iterator();

      while(var6.hasNext()) {
         IViewEdgeListener var7 = (IViewEdgeListener)var6.next();

         try {
            var7.addedBend(this, var5);
         } catch (Exception var9) {
            var9.printStackTrace();
         }
      }

   }

   public void addListener(IViewEdgeListener var1) {
      this.m_listeners.addListener(var1);
   }

   public void clearBends() {
      this.m_bends.clear();
      Iterator var1 = this.m_listeners.iterator();

      while(var1.hasNext()) {
         IViewEdgeListener var2 = (IViewEdgeListener)var1.next();

         try {
            var2.clearedBends(this);
         } catch (Exception var4) {
            var4.printStackTrace();
         }
      }

   }

   public int getBendCount() {
      return this.m_bends.size();
   }

   public List getBends() {
      return new ArrayList(this.m_bends);
   }

   public Color getColor() {
      return Color.BLACK;
   }

   public int getId() {
      return 0;
   }

   public Object getSource() {
      return null;
   }

   public Object getTarget() {
      return null;
   }

   public EdgeType getType() {
      return EdgeType.TEXTNODE_EDGE;
   }

   public double getX1() {
      return 0.0D;
   }

   public double getX2() {
      return 0.0D;
   }

   public double getY1() {
      return 0.0D;
   }

   public double getY2() {
      return 0.0D;
   }

   public void insertBend(int var1, double var2, double var4) {
      CBend var6 = new CBend(var2, var4);
      this.m_bends.add(var1, var6);
      Iterator var7 = this.m_listeners.iterator();

      while(var7.hasNext()) {
         IViewEdgeListener var8 = (IViewEdgeListener)var7.next();

         try {
            var8.insertedBend(this, var1, var6);
         } catch (Exception var10) {
            var10.printStackTrace();
         }
      }

   }

   public boolean isSelected() {
      return false;
   }

   public boolean isVisible() {
      return true;
   }

   public void removeBend(int var1) {
      this.m_bends.remove(var1);
   }

   public void removeListener(IViewEdgeListener var1) {
      this.m_listeners.removeListener(var1);
   }

   public void setColor(Color var1) {
   }

   public void setEdgeType(EdgeType var1) {
   }

   public void setId(int var1) {
   }

   public void setSelected(boolean var1) {
   }

   public void setVisible(boolean var1) {
   }

   public void setX1(double var1) {
   }

   public void setX2(double var1) {
   }

   public void setY1(double var1) {
   }

   public void setY2(double var1) {
   }

   // $FF: synthetic method
   ZyInfoEdge$CInfoEdge(ZyInfoEdge$1 var1) {
      this();
   }
}
