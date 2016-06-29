package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.zygraph.edges.ZyEdgeData;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IEdgeRealizerUpdater;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEdgeRealizer;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEdgeRealizerListener;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyEdgeLabel;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Iterator;
import y.d.t;
import y.h.dr;
import y.h.fJ;
import y.h.h;
import y.h.x;

public class ZyEdgeRealizer extends fJ implements IZyEdgeRealizer {
   private ZyEdgeData m_edgeData;
   private IEdgeRealizerUpdater m_updater;
   private boolean m_drawSloppyEdges = true;
   private boolean m_drawBends = false;
   private boolean m_isHighlighted = false;
   private boolean m_isSloppyPainting = false;
   private final ListenerProvider m_listeners = new ListenerProvider();
   private ZyLabelContent m_content;

   public ZyEdgeRealizer(ZyLabelContent var1, IEdgeRealizerUpdater var2) {
      Preconditions.checkNotNull(var1, "Internal Error: Content cannot be null");
      this.m_content = var1;
      this.setArrow(h.b);
      this.setSmoothedBends(true);
      if(var1.getLineCount() > 0) {
         this.addLabel(new ZyEdgeLabel(var1));
      }

      this.setUpdater(var2);
   }

   private void notifyLocationChanged() {
      Iterator var1 = this.m_listeners.iterator();

      while(var1.hasNext()) {
         IZyEdgeRealizerListener var2 = (IZyEdgeRealizerListener)var1.next();

         try {
            var2.changedLocation(this);
         } catch (Exception var4) {
            var4.printStackTrace();
         }
      }

   }

   protected void paintHighlightedBends(Graphics2D var1) {
      if(this.m_drawBends && !this.m_isSloppyPainting) {
         super.paintHighlightedBends(var1);
      }

   }

   public void addListener(IZyEdgeRealizerListener var1) {
      this.m_listeners.addListener(var1);
   }

   public void addSilent(double var1, double var3) {
      super.appendBend(var1, var3);
   }

   public x appendBend(double var1, double var3) {
      x var5 = super.appendBend(var1, var3);
      var5.a(this.isSelected());
      return var5;
   }

   public void bendChanged(x var1, double var2, double var4) {
      int var6 = this.bendPos(var1);
      super.bendChanged(var1, var2, var4);
      Iterator var7 = this.m_listeners.iterator();

      while(var7.hasNext()) {
         IZyEdgeRealizerListener var8 = (IZyEdgeRealizerListener)var7.next();

         try {
            var8.bendChanged(var6, var1.b(), var1.c());
         } catch (Exception var10) {
            var10.printStackTrace();
         }
      }

   }

   public void clearBends() {
      super.clearBends();
      Iterator var1 = this.m_listeners.iterator();

      while(var1.hasNext()) {
         IZyEdgeRealizerListener var2 = (IZyEdgeRealizerListener)var1.next();

         try {
            var2.clearedBends();
         } catch (Exception var4) {
            var4.printStackTrace();
         }
      }

   }

   public ZyLabelContent getEdgeLabelContent() {
      return this.m_content;
   }

   public ZyEdgeData getUserData() {
      return this.m_edgeData;
   }

   public void paint(Graphics2D var1) {
      this.m_content.setSloppy(false);
      this.m_isSloppyPainting = false;
      super.paint(var1);
   }

   public void paintBends(Graphics2D var1) {
   }

   public void paintPorts(Graphics2D var1) {
   }

   public void paintSloppy(Graphics2D var1) {
      this.m_isSloppyPainting = true;
      this.m_content.setSloppy(true);
      if(this.m_drawSloppyEdges) {
         if(!this.isSelected() && !this.m_isHighlighted) {
            super.paintSloppy(var1);
         } else {
            dr var2 = this.getLineType();
            Color var3 = getSelectionColor();
            this.setLineType(dr.e);
            setSelectionColor(this.getLineColor());
            super.paint(var1);
            this.setLineType(var2);
            setSelectionColor(var3);
         }

      }
   }

   public void regenerate() {
      this.m_content = this.m_updater.generateContent(this);
      this.removeLabel(this.getLabel());
      if(this.m_content.getLineCount() > 0) {
         this.addLabel(new ZyEdgeLabel(this.m_content));
      }

      Iterator var1 = this.m_listeners.iterator();

      while(var1.hasNext()) {
         IZyEdgeRealizerListener var2 = (IZyEdgeRealizerListener)var1.next();

         try {
            var2.regenerated(this);
         } catch (Exception var4) {
            var4.printStackTrace();
         }
      }

      this.getLabel().repaint();
      this.repaint();
   }

   public void reInsertBend(x var1, x var2, int var3) {
      int var4 = this.bendPos(var2) + var3 != 1 && var2 != null?1:0;
      super.reInsertBend(var1, var2, var3);
      Iterator var5 = this.m_listeners.iterator();

      while(var5.hasNext()) {
         IZyEdgeRealizerListener var6 = (IZyEdgeRealizerListener)var5.next();

         try {
            var6.insertedBend(var4, var1.b(), var1.c());
         } catch (Exception var8) {
            var8.printStackTrace();
         }
      }

   }

   public x removeBend(x var1) {
      int var2 = this.bendPos(var1);
      x var3 = super.removeBend(var1);
      Iterator var4 = this.m_listeners.iterator();

      while(var4.hasNext()) {
         IZyEdgeRealizerListener var5 = (IZyEdgeRealizerListener)var4.next();

         try {
            var5.removedBend(this, var2);
         } catch (Exception var7) {
            var7.printStackTrace();
         }
      }

      return var3;
   }

   public void removeListener(IZyEdgeRealizerListener var1) {
      this.m_listeners.removeListener(var1);
   }

   public void setDrawBends(boolean var1) {
      this.m_drawBends = var1;
   }

   public void setDrawSloppyEdges(boolean var1) {
      this.m_drawSloppyEdges = var1;
   }

   public void setLineType(dr var1) {
      this.m_isHighlighted = var1 == dr.e || var1 == dr.l || var1 == dr.q || var1 == dr.v;
      super.setLineType(var1);
   }

   public void setSelected(boolean var1) {
      super.setSelected(var1);

      for(int var2 = 0; var2 < this.bendCount(); ++var2) {
         this.getBend(var2).a(var1);
      }

   }

   public void setSourcePoint(t var1) {
      super.setSourcePoint(var1);
      this.notifyLocationChanged();
   }

   public void setTargetPoint(t var1) {
      super.setTargetPoint(var1);
      this.notifyLocationChanged();
   }

   public void setUpdater(IEdgeRealizerUpdater var1) {
      this.m_updater = var1;
      if(var1 != null) {
         var1.setRealizer(this);
      }

   }

   public void setUserData(ZyEdgeData var1) {
      this.m_edgeData = var1;
   }

   public void setVisible(boolean var1) {
      super.setVisible(var1);
      Iterator var2 = this.m_listeners.iterator();

      while(var2.hasNext()) {
         IZyEdgeRealizerListener var3 = (IZyEdgeRealizerListener)var2.next();

         try {
            var3.changedVisibility(this);
         } catch (Exception var5) {
            var5.printStackTrace();
         }
      }

   }
}
