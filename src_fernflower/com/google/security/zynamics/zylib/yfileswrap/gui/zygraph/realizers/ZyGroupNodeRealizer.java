package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IGroupNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.ZyNodeData;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IRealizerUpdater;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyNodeRealizerListener;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Iterator;
import y.c.q;
import y.c.x;
import y.c.y;
import y.h.bu;
import y.h.dr;
import y.h.fj;
import y.h.a.p;
import y.h.a.v;

public class ZyGroupNodeRealizer extends p implements IZyNodeRealizer {
   private static final byte SHADOW_SIZE = 8;
   private static final Color SHADOW_COLOR;
   private final ZyLabelContent m_content;
   private ZyNodeData m_userData;
   private IRealizerUpdater m_updater;
   private final ListenerProvider m_listeners = new ListenerProvider();

   public ZyGroupNodeRealizer(ZyLabelContent var1, boolean var2) {
      this.setShapeType((byte)1);
      this.setLineType(dr.b);
      this.setDropShadowOffsetX((byte)8);
      this.setDropShadowOffsetY((byte)8);
      this.setDropShadowColor(SHADOW_COLOR);
      this.m_content = var1;
      Rectangle2D var3 = this.getNodeContent().getBounds();
      this.setSize(var3.getWidth(), var3.getHeight());
      this.setGroupClosed(var2);
   }

   private void addChildren(v var1, q var2, y var3) {
      for(x var4 = var1.p(var2); var4.f(); var4.g()) {
         q var5 = var4.e();
         if(var1.k(var5)) {
            this.addChildren(var1, var5, var3);
         } else {
            var3.add(var5);
         }
      }

   }

   private void moveContent(double var1, double var3) {
      bu var5 = (bu)this.m_userData.getNode().getNode().e();
      v var6 = var5.C();
      y var7 = new y();
      this.addChildren(var6, this.getNode(), var7);
      this.moveNodes(var5, var7.a(), var1, var3);
   }

   private void moveNodes(bu var1, x var2, double var3, double var5) {
      for(; var2.f(); var2.g()) {
         fj var7 = var1.t(var2.e());
         if(var7.getAutoBoundsFeature() == null || !var7.getAutoBoundsFeature().isAutoBoundsEnabled()) {
            var7.moveBy(var3, var5);
         }
      }

   }

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

   public void addListener(IZyNodeRealizerListener var1) {
      this.m_listeners.addListener(var1);
   }

   public ZyLabelContent getNodeContent() {
      return this.m_content;
   }

   public fj getRealizer() {
      return this;
   }

   public IRealizerUpdater getUpdater() {
      return this.m_updater;
   }

   public ZyNodeData getUserData() {
      return this.m_userData;
   }

   public void moveBy(double var1, double var3) {
      this.moveContent(var1, var3);
      super.moveBy(var1, var3);
      this.notifyLocationChanged(this.getX(), this.getY());
   }

   public void paintHotSpots(Graphics2D var1) {
   }

   public void paintNode(Graphics2D var1) {
      super.paintNode(var1);
      IGroupNode var2 = (IGroupNode)this.m_userData.getNode().getRawNode();
      if(var2.isCollapsed()) {
         this.getNodeContent().draw(var1, this.getX(), this.getY() + 8.0D);
      }

   }

   public int positionToRow(double var1) {
      return 0;
   }

   public void regenerate() {
      this.m_updater.generateContent(this, this.m_content);
      Rectangle2D var1 = this.m_content.getBounds();
      double var2 = this.getX();
      double var4 = this.getY();
      this.setSize(var1.getWidth(), var1.getHeight());
      this.setX(var2);
      this.setY(var4);
      Iterator var6 = this.m_listeners.iterator();

      while(var6.hasNext()) {
         IZyNodeRealizerListener var7 = (IZyNodeRealizerListener)var6.next();

         try {
            var7.regenerated(this);
         } catch (Exception var9) {
            ;
         }
      }

      this.repaint();
   }

   public void removeListener(IZyNodeRealizerListener var1) {
      this.m_listeners.removeListener(var1);
   }

   public double rowToPosition(int var1) {
      return (double)this.m_content.getPaddingTop() + (double)var1 * this.m_content.getLineHeight();
   }

   public void setCenter(double var1, double var3) {
      super.setCenter(var1, var3);
      this.notifyLocationChanged(var1, var3);
   }

   public void setCenterX(double var1) {
      super.setCenterX(var1);
      this.notifyLocationChanged(var1, this.y);
   }

   public void setFillColor(Color var1) {
      super.setFillColor(var1);
      this.updateContentSelectionColor();
   }

   public void setGroupClosed(boolean var1) {
      super.setGroupClosed(var1);
      if(var1) {
         Rectangle2D var2 = this.m_content.getBounds();
         this.setSize(var2.getWidth(), var2.getHeight());
      }

   }

   public void setLocation(double var1, double var3) {
      super.setLocation(var1, var3);
      this.notifyLocationChanged(var1, var3);
   }

   public void setSelected(boolean var1) {
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

   public void setUpdater(IRealizerUpdater var1) {
      this.m_updater = var1;
      if(var1 != null) {
         var1.setRealizer(this);
      }

   }

   public void setUserData(ZyNodeData var1) {
      Preconditions.checkNotNull(var1, "Error: Invalid node data");
      Preconditions.checkArgument(var1.getNode().getRawNode() instanceof IGroupNode, "Error: User data does not contain a group node");
      this.m_userData = var1;
   }

   public void setVisible(boolean var1) {
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

   public void updateContentSelectionColor() {
      if(this.m_content.isSelectable()) {
         this.m_content.updateContentSelectionColor(this.getFillColor(), this.isSelected());
      }

   }

   static {
      SHADOW_COLOR = Color.GRAY;
   }
}
