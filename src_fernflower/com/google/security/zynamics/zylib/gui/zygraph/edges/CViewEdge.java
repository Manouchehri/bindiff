package com.google.security.zynamics.zylib.gui.zygraph.edges;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.zygraph.edges.CBend;
import com.google.security.zynamics.zylib.gui.zygraph.edges.EdgeType;
import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdge;
import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdgeListener;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CViewEdge implements IViewEdge {
   private final Object m_sourceNode;
   private final Object m_targetNode;
   private EdgeType m_type;
   private double m_x1;
   private double m_y1;
   private double m_x2;
   private double m_y2;
   private Color m_color;
   private boolean m_visible;
   private boolean m_selected;
   private int m_id;
   private final List m_paths;
   protected final ListenerProvider m_listeners = new ListenerProvider();

   public CViewEdge(int var1, Object var2, Object var3, EdgeType var4, double var5, double var7, double var9, double var11, Color var13, boolean var14, boolean var15, List var16) {
      this.m_sourceNode = Preconditions.checkNotNull(var2, "Error: Source node argument can\'t be null");
      this.m_targetNode = Preconditions.checkNotNull(var3, "Error: Target node argument can\'t be null");
      this.m_id = var1;
      this.m_type = var4;
      this.m_x1 = var5;
      this.m_y1 = var7;
      this.m_x2 = var9;
      this.m_y2 = var11;
      this.m_color = var13;
      this.m_visible = var15;
      this.m_selected = var14;
      this.m_paths = var16;
   }

   public void addBend(double var1, double var3) {
      CBend var5 = new CBend(var1, var3);
      this.m_paths.add(var5);
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
      this.m_paths.clear();
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
      return this.m_paths.size();
   }

   public List getBends() {
      return new ArrayList(this.m_paths);
   }

   public Color getColor() {
      return this.m_color;
   }

   public int getId() {
      return this.m_id;
   }

   public Object getSource() {
      return this.m_sourceNode;
   }

   public Object getTarget() {
      return this.m_targetNode;
   }

   public EdgeType getType() {
      return this.m_type;
   }

   public double getX1() {
      return this.m_x1;
   }

   public double getX2() {
      return this.m_x2;
   }

   public double getY1() {
      return this.m_y1;
   }

   public double getY2() {
      return this.m_y2;
   }

   public void insertBend(int var1, double var2, double var4) {
      CBend var6 = new CBend(var2, var4);
      this.m_paths.add(var1, var6);
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
      return this.m_selected;
   }

   public boolean isVisible() {
      return this.m_visible;
   }

   public void removeAllListeners() {
      ArrayList var1 = new ArrayList();
      Iterator var2 = this.m_listeners.iterator();

      IViewEdgeListener var3;
      while(var2.hasNext()) {
         var3 = (IViewEdgeListener)var2.next();
         var1.add(var3);
      }

      var2 = var1.iterator();

      while(var2.hasNext()) {
         var3 = (IViewEdgeListener)var2.next();
         this.removeListener(var3);
      }

   }

   public void removeBend(int var1) {
      CBend var2 = (CBend)this.m_paths.get(var1);
      this.m_paths.remove(var1);
      Iterator var3 = this.m_listeners.iterator();

      while(var3.hasNext()) {
         IViewEdgeListener var4 = (IViewEdgeListener)var3.next();
         var4.removedBend(this, var1, var2);
      }

   }

   public void removeListener(IViewEdgeListener var1) {
      this.m_listeners.removeListener(var1);
   }

   public void setColor(Color var1) {
      Preconditions.checkNotNull(var1, "Error: Color argument can not be null");
      if(!this.m_color.equals(var1)) {
         this.m_color = var1;
         Iterator var2 = this.m_listeners.iterator();

         while(var2.hasNext()) {
            IViewEdgeListener var3 = (IViewEdgeListener)var2.next();
            var3.changedColor(this, var1);
         }

      }
   }

   public void setEdgeType(EdgeType var1) {
      Preconditions.checkNotNull(var1, "Error: Type argument can\'t be null");
      if(var1 != this.m_type) {
         this.m_type = var1;
         Iterator var2 = this.m_listeners.iterator();

         while(var2.hasNext()) {
            IViewEdgeListener var3 = (IViewEdgeListener)var2.next();
            var3.changedType(this, var1);
         }

      }
   }

   public void setId(int var1) {
      this.m_id = var1;
   }

   public void setSelected(boolean var1) {
      if(this.m_selected != var1) {
         this.m_selected = var1;
         Iterator var2 = this.m_listeners.iterator();

         while(var2.hasNext()) {
            IViewEdgeListener var3 = (IViewEdgeListener)var2.next();
            var3.changedSelection(this, var1);
         }

      }
   }

   public void setVisible(boolean var1) {
      if(this.m_visible != var1) {
         this.m_visible = var1;
         Iterator var2 = this.m_listeners.iterator();

         while(var2.hasNext()) {
            IViewEdgeListener var3 = (IViewEdgeListener)var2.next();
            var3.changedVisibility(this, this.m_visible);
         }

      }
   }

   public void setX1(double var1) {
      if(Double.compare(this.m_x1, var1) != 0) {
         this.m_x1 = var1;
         Iterator var3 = this.m_listeners.iterator();

         while(var3.hasNext()) {
            IViewEdgeListener var4 = (IViewEdgeListener)var3.next();
            var4.changedSourceX(this, var1);
         }

      }
   }

   public void setX2(double var1) {
      if(Double.compare(this.m_x2, var1) != 0) {
         this.m_x2 = var1;
         Iterator var3 = this.m_listeners.iterator();

         while(var3.hasNext()) {
            IViewEdgeListener var4 = (IViewEdgeListener)var3.next();
            var4.changedTargetX(this, var1);
         }

      }
   }

   public void setY1(double var1) {
      if(Double.compare(this.m_y1, var1) != 0) {
         this.m_y1 = var1;
         Iterator var3 = this.m_listeners.iterator();

         while(var3.hasNext()) {
            IViewEdgeListener var4 = (IViewEdgeListener)var3.next();
            var4.changedSourceY(this, var1);
         }

      }
   }

   public void setY2(double var1) {
      if(Double.compare(this.m_y2, var1) != 0) {
         this.m_y2 = var1;
         Iterator var3 = this.m_listeners.iterator();

         while(var3.hasNext()) {
            IViewEdgeListener var4 = (IViewEdgeListener)var3.next();
            var4.changedTargetY(this, var1);
         }

      }
   }
}
