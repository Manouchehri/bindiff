package com.google.security.zynamics.zylib.gui.zygraph.nodes;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdge;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNodeListener;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class CViewNode implements IViewNode {
   private int m_id;
   private double m_x;
   private double m_y;
   private Color m_color;
   private Color m_borderColor;
   private boolean m_selected;
   private boolean m_visible;
   private final List m_incomingEdges = new ArrayList();
   private final List m_outgoingEdges = new ArrayList();
   private final ListenerProvider m_listeners = new ListenerProvider();
   private double m_height;
   private double m_width;

   public CViewNode(int var1, double var2, double var4, double var6, double var8, Color var10, Color var11, boolean var12, boolean var13) {
      Preconditions.checkArgument(var1 >= -1, "Error: Node ID must be positive or -1 for unsaved nodes.");
      Preconditions.checkNotNull(var10, "Error: Color argument can\'t be null");
      Preconditions.checkNotNull(var11, "Error: Border color argument can\'t be null");
      this.m_id = var1;
      this.m_x = var2;
      this.m_y = var4;
      this.m_height = var8;
      this.m_width = var6;
      this.m_color = var10;
      this.m_borderColor = var11;
      this.m_selected = var12;
      this.m_visible = var13;
   }

   protected ListenerProvider getListeners() {
      return this.m_listeners;
   }

   public void addIncomingEdge(IViewEdge var1) {
      Preconditions.checkNotNull(var1, "Error: Edge argument can\'t be null");
      this.m_incomingEdges.add(var1);
   }

   public void addListener(IViewNodeListener var1) {
      this.m_listeners.addListener(var1);
   }

   public void addOutgoingEdge(IViewEdge var1) {
      Preconditions.checkNotNull(var1, "Error: Edge argument can not be null");
      Preconditions.checkArgument(!this.m_outgoingEdges.contains(var1), "Error: Outgoing edge was added before");
      this.m_outgoingEdges.add(var1);
   }

   public Color getBorderColor() {
      return new Color(this.m_borderColor.getRGB());
   }

   public Color getColor() {
      return new Color(this.m_color.getRGB());
   }

   public double getHeight() {
      return this.m_height;
   }

   public int getId() {
      return this.m_id;
   }

   public List getIncomingEdges() {
      return new ArrayList(this.m_incomingEdges);
   }

   public List getOutgoingEdges() {
      return new ArrayList(this.m_outgoingEdges);
   }

   public double getWidth() {
      return this.m_width;
   }

   public double getX() {
      return this.m_x;
   }

   public double getY() {
      return this.m_y;
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

      IViewNodeListener var3;
      while(var2.hasNext()) {
         var3 = (IViewNodeListener)var2.next();
         var1.add(var3);
      }

      var2 = var1.iterator();

      while(var2.hasNext()) {
         var3 = (IViewNodeListener)var2.next();
         this.m_listeners.removeListener(var3);
      }

   }

   public void removeIncomingEdge(IViewEdge var1) {
      Preconditions.checkNotNull(var1, "Error: Edge argument can not be null");
      this.m_incomingEdges.remove(var1);
   }

   public void removeListener(IViewNodeListener var1) {
      Preconditions.checkNotNull(var1, "Error: Listener argument can not be null");
      this.m_listeners.removeListener(var1);
   }

   public void removeOutgoingEdge(IViewEdge var1) {
      Preconditions.checkNotNull(var1, "Error: Edge argument can not be null");
      this.m_outgoingEdges.remove(var1);
   }

   public void setBorderColor(Color var1) {
      Preconditions.checkNotNull(var1, "Error: Color argument can not be null");
      if(!this.m_borderColor.equals(var1)) {
         this.m_borderColor = var1;
         Iterator var2 = this.m_listeners.iterator();

         while(var2.hasNext()) {
            IViewNodeListener var3 = (IViewNodeListener)var2.next();

            try {
               var3.changedBorderColor(this, var1);
            } catch (Exception var5) {
               var5.printStackTrace();
            }
         }

      }
   }

   public void setColor(Color var1) {
      Preconditions.checkNotNull(var1, "Error: Color argument can not be null");
      if(!this.m_color.equals(var1)) {
         this.m_color = var1;
         Iterator var2 = this.m_listeners.iterator();

         while(var2.hasNext()) {
            IViewNodeListener var3 = (IViewNodeListener)var2.next();

            try {
               var3.changedColor(this, var1);
            } catch (Exception var5) {
               var5.printStackTrace();
            }
         }

      }
   }

   public void setHeight(double var1) {
      if(this.m_height != var1) {
         this.m_height = var1;
         Iterator var3 = this.m_listeners.iterator();

         while(var3.hasNext()) {
            IViewNodeListener var4 = (IViewNodeListener)var3.next();

            try {
               var4.heightChanged(this, var1);
            } catch (Exception var6) {
               var6.printStackTrace();
            }
         }

      }
   }

   public void setId(int var1) {
      this.m_id = var1;
   }

   public void setSelected(boolean var1) {
      if(var1 != this.m_selected) {
         this.m_selected = var1;
         Iterator var2 = this.m_listeners.iterator();

         while(var2.hasNext()) {
            IViewNodeListener var3 = (IViewNodeListener)var2.next();

            try {
               var3.changedSelection(this, var1);
            } catch (Exception var5) {
               var5.printStackTrace();
            }
         }

      }
   }

   public void setVisible(boolean var1) {
      if(var1 != this.m_visible) {
         this.m_visible = var1;
         Iterator var2 = this.m_listeners.iterator();

         while(var2.hasNext()) {
            IViewNodeListener var3 = (IViewNodeListener)var2.next();

            try {
               var3.changedVisibility(this, this.isVisible());
            } catch (Exception var5) {
               var5.printStackTrace();
            }
         }

      }
   }

   public void setWidth(double var1) {
      if(this.m_width != var1) {
         this.m_width = var1;
         Iterator var3 = this.m_listeners.iterator();

         while(var3.hasNext()) {
            IViewNodeListener var4 = (IViewNodeListener)var3.next();

            try {
               var4.widthChanged(this, var1);
            } catch (Exception var6) {
               var6.printStackTrace();
            }
         }

      }
   }

   public void setX(double var1) {
      if(this.m_x != var1) {
         this.m_x = var1;
         Iterator var3 = this.m_listeners.iterator();

         while(var3.hasNext()) {
            IViewNodeListener var4 = (IViewNodeListener)var3.next();

            try {
               var4.xposChanged(this, var1);
            } catch (Exception var6) {
               var6.printStackTrace();
            }
         }

      }
   }

   public void setY(double var1) {
      if(this.m_y != var1) {
         this.m_y = var1;
         Iterator var3 = this.m_listeners.iterator();

         while(var3.hasNext()) {
            IViewNodeListener var4 = (IViewNodeListener)var3.next();

            try {
               var4.yposChanged(this, var1);
            } catch (Exception var6) {
               var6.printStackTrace();
            }
         }

      }
   }
}
