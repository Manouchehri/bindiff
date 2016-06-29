package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.ZyNodeData;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IRealizerUpdater;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyNodeRealizerListener;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Iterator;
import y.c.d;
import y.c.q;
import y.d.t;
import y.h.aB;
import y.h.bu;
import y.h.dr;
import y.h.fL;
import y.h.gn;

public abstract class ZyNodeRealizer extends gn implements IZyNodeRealizer {
   private ZyNodeData m_userData;
   private IRealizerUpdater m_updater;
   private final ListenerProvider m_listeners = new ListenerProvider();
   protected boolean m_isHighLighted = false;

   private void notifyLocationChanged(double var1, double var3) {
      Iterator var5 = this.m_listeners.iterator();

      while(var5.hasNext()) {
         IZyNodeRealizerListener var6 = (IZyNodeRealizerListener)var5.next();

         try {
            var6.changedLocation(this, var1, var3);
         } catch (Exception var8) {
            ;
         }
      }

   }

   protected void notifyHasRegenerated() {
      Iterator var1 = this.m_listeners.iterator();

      while(var1.hasNext()) {
         IZyNodeRealizerListener var2 = (IZyNodeRealizerListener)var1.next();

         try {
            var2.regenerated(this);
         } catch (Exception var4) {
            ;
         }
      }

   }

   protected void scalePortCoordinates(q var1, double var2, double var4, double var6, double var8) {
      bu var10 = (bu)var1.e();
      double var11 = var2 > 0.0D?var4 / var2:1.0D;
      double var13 = var6 > 0.0D?var8 / var6:1.0D;

      d var15;
      aB var16;
      fL var17;
      double var18;
      double var20;
      for(var15 = var1.f(); var15 != null; var15 = var15.g()) {
         var16 = var10.i(var15);
         var17 = var16.getSourcePort();
         var18 = var17.g() * var11;
         var20 = var17.h() * var13;
         var17.b(var18, var20);
         var10.a((d)var15, (t)(new t(var18, var20)));
      }

      for(var15 = var1.g(); var15 != null; var15 = var15.h()) {
         var16 = var10.i(var15);
         var17 = var16.getTargetPort();
         var18 = var17.g() * var11;
         var20 = var17.h() * var13;
         var17.b(var18, var20);
         var10.b(var15, new t(var18, var20));
      }

   }

   public void addListener(IZyNodeRealizerListener var1) {
      this.m_listeners.addListener(var1);
   }

   public abstract ZyLabelContent getNodeContent();

   public IRealizerUpdater getUpdater() {
      return this.m_updater;
   }

   public ZyNodeData getUserData() {
      return this.m_userData;
   }

   public void moveBy(double var1, double var3) {
      super.moveBy(var1, var3);
      this.notifyLocationChanged(this.getX(), this.getY());
   }

   public void paintSloppy(Graphics2D var1) {
      if(!this.isSelected() && !this.m_isHighLighted) {
         this.paintFilledShape(var1);
         this.paintShapeBorder(var1);
      } else {
         dr var2 = this.getLineType();
         this.setLineType(dr.e);
         this.paintFilledShape(var1);
         this.paintShapeBorder(var1);
         this.setLineType(var2);
      }

   }

   public int positionToRow(double var1) {
      ZyLabelContent var3 = this.getNodeContent();
      Rectangle2D var4 = this.getNodeContent().getBounds();
      double var5 = this.getHeight() / var4.getHeight();
      int var7 = (int)((var1 / var5 - (double)var3.getPaddingTop()) / var3.getLineHeight());
      return var7 >= var3.getLineCount()?-1:var7;
   }

   public void regenerate() {
      ZyLabelContent var1 = this.getNodeContent();
      double var2 = var1.getBounds().getWidth();
      double var4 = var1.getBounds().getHeight();
      if(this.m_updater != null) {
         this.m_updater.generateContent(this, var1);
      }

      Rectangle2D var6 = var1.getBounds();
      this.setSize(var6.getWidth(), var6.getHeight());
      this.scalePortCoordinates(this.getNode(), var2, var6.getWidth(), var4, var6.getHeight());
      this.notifyHasRegenerated();
      this.repaint();
   }

   public void removeListener(IZyNodeRealizerListener var1) {
      this.m_listeners.removeListener(var1);
   }

   public double rowToPosition(int var1) {
      ZyLabelContent var2 = this.getNodeContent();
      return (double)var2.getPaddingTop() + (double)var1 * var2.getLineHeight();
   }

   public void setCenter(double var1, double var3) {
      super.setCenter(var1, var3);
      this.notifyLocationChanged(this.getX(), this.getY());
   }

   public void setFillColor(Color var1) {
      if(super.getFillColor() != var1) {
         super.setFillColor(var1);
         this.updateContentSelectionColor();
      }

   }

   public void setLineType(dr var1) {
      this.m_isHighLighted = var1 == dr.e || var1 == dr.l || var1 == dr.q || var1 == dr.v;
      super.setLineType(var1);
   }

   public void setLocation(double var1, double var3) {
      super.setLocation(var1, var3);
      this.notifyLocationChanged(var1, var3);
   }

   public void setSelected(boolean var1) {
      if(super.isSelected() != var1) {
         super.setSelected(var1);
         this.updateContentSelectionColor();
         Iterator var2 = this.m_listeners.iterator();

         while(var2.hasNext()) {
            IZyNodeRealizerListener var3 = (IZyNodeRealizerListener)var2.next();

            try {
               var3.changedSelection(this);
            } catch (Exception var5) {
               ;
            }
         }
      }

   }

   public void setSize(double var1, double var3) {
      if(super.getX() != var1 || super.getY() != var3) {
         super.setSize(var1, var3);
         Iterator var5 = this.m_listeners.iterator();

         while(var5.hasNext()) {
            IZyNodeRealizerListener var6 = (IZyNodeRealizerListener)var5.next();

            try {
               var6.changedSize(this, var1, var3);
            } catch (Exception var8) {
               ;
            }
         }
      }

   }

   public void setUpdater(IRealizerUpdater var1) {
      this.m_updater = var1;
      if(var1 != null) {
         var1.setRealizer(this);
      }

   }

   public void setUserData(ZyNodeData var1) {
      Preconditions.checkNotNull(var1, "Error: Invalid node data");
      this.m_userData = var1;
   }

   public void setVisible(boolean var1) {
      if(super.isVisible() != var1) {
         super.setVisible(var1);
         this.updateContentSelectionColor();
         Iterator var2 = this.m_listeners.iterator();

         while(var2.hasNext()) {
            IZyNodeRealizerListener var3 = (IZyNodeRealizerListener)var2.next();

            try {
               var3.changedVisibility(this);
            } catch (Exception var5) {
               ;
            }
         }
      }

   }

   public void updateContentSelectionColor() {
      ZyLabelContent var1 = this.getNodeContent();
      if(var1.isSelectable()) {
         var1.updateContentSelectionColor(this.getFillColor(), this.isSelected());
      }

   }
}
