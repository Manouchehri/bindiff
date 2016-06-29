package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes;

import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdge;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IGroupNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNodeListener;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.NodeHelpers;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyNodeRealizerListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode$InternalListener$1;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import java.awt.Color;
import java.util.Iterator;
import y.c.q;
import y.h.bu;

class ZyGraphNode$InternalListener implements IViewNodeListener, IZyNodeRealizerListener {
   private final bu m_graph;
   private q m_pnode;
   // $FF: synthetic field
   final ZyGraphNode this$0;

   public ZyGraphNode$InternalListener(ZyGraphNode var1, bu var2) {
      this.this$0 = var1;
      this.m_graph = var2;
   }

   private void showNode(IViewNode var1, boolean var2) {
      IGroupNode var3;
      Iterator var4;
      IViewNode var5;
      if(var2) {
         this.m_graph.b((q)ZyGraphNode.access$000(this.this$0));
         if(var1.getParentGroup() != null && !var1.getParentGroup().isVisible()) {
            var1.getParentGroup().setVisible(true);
         }

         if(var1 instanceof IGroupNode) {
            var3 = (IGroupNode)var1;
            if(var3.isCollapsed()) {
               this.m_graph.C().d(ZyGraphNode.access$000(this.this$0));
            } else {
               this.m_graph.C().c(ZyGraphNode.access$000(this.this$0));
            }

            if(var3.isCollapsed()) {
               var4 = var3.getElements().iterator();

               while(var4.hasNext()) {
                  var5 = (IViewNode)var4.next();
                  var5.setVisible(true);
               }
            }
         }

         if(this.m_pnode != null) {
            this.m_graph.C().c(ZyGraphNode.access$000(this.this$0), this.m_pnode);
         }
      } else {
         this.m_pnode = this.m_graph.C().n(ZyGraphNode.access$000(this.this$0));
         if(this.m_pnode == null && var1.getParentGroup() != null) {
            throw new IllegalStateException("Error");
         }

         if(var1 instanceof IGroupNode) {
            var3 = (IGroupNode)var1;
            if(var3.isCollapsed()) {
               var4 = var3.getElements().iterator();

               while(var4.hasNext()) {
                  var5 = (IViewNode)var4.next();
                  var5.setVisible(false);
               }
            }
         }

         if(var1.getParentGroup() == null || !var1.getParentGroup().isCollapsed()) {
            this.m_graph.a((q)ZyGraphNode.access$000(this.this$0));
         }
      }

      Iterator var6 = var1.getIncomingEdges().iterator();

      while(true) {
         IViewEdge var7;
         while(var6.hasNext()) {
            var7 = (IViewEdge)var6.next();
            if(var1.getParentGroup() == null) {
               var7.setVisible(((IViewNode)var7.getSource()).isVisible() && ((IViewNode)var7.getTarget()).isVisible() && NodeHelpers.getVisibleNode((IViewNode)var7.getTarget()).isVisible() && NodeHelpers.getVisibleNode((IViewNode)var7.getSource()).isVisible());
            } else if(var1.getParentGroup().isCollapsed()) {
               var7.setVisible(var1.getParentGroup().isVisible() && ((IViewNode)var7.getSource()).isVisible());
            } else {
               var7.setVisible(((IViewNode)var7.getSource()).isVisible() && ((IViewNode)var7.getTarget()).isVisible() && NodeHelpers.getVisibleNode((IViewNode)var7.getTarget()).isVisible() && NodeHelpers.getVisibleNode((IViewNode)var7.getSource()).isVisible());
            }
         }

         var6 = var1.getOutgoingEdges().iterator();

         while(true) {
            while(var6.hasNext()) {
               var7 = (IViewEdge)var6.next();
               if(var1.getParentGroup() == null) {
                  var7.setVisible(((IViewNode)var7.getSource()).isVisible() && ((IViewNode)var7.getTarget()).isVisible() && NodeHelpers.getVisibleNode((IViewNode)var7.getTarget()).isVisible() && NodeHelpers.getVisibleNode((IViewNode)var7.getSource()).isVisible());
               } else if(var1.getParentGroup().isCollapsed()) {
                  var7.setVisible(var1.getParentGroup().isVisible() && ((IViewNode)var7.getTarget()).isVisible());
               } else {
                  var7.setVisible(((IViewNode)var7.getSource()).isVisible() && ((IViewNode)var7.getTarget()).isVisible() && NodeHelpers.getVisibleNode((IViewNode)var7.getTarget()).isVisible() && NodeHelpers.getVisibleNode((IViewNode)var7.getSource()).isVisible());
               }
            }

            return;
         }
      }
   }

   public void changedBorderColor(IViewNode var1, Color var2) {
      ZyGraphNode.access$100(this.this$0).setLineColor(var2);
      ZyGraphNode.access$200(this.this$0);
   }

   public void changedColor(IViewNode var1, Color var2) {
      ZyGraphNode.access$100(this.this$0).setFillColor(var2);
      ZyGraphNode.access$200(this.this$0);
   }

   public void changedLocation(IZyNodeRealizer var1, double var2, double var4) {
      ZyGraphNode.access$300(this.this$0).setX(var2);
      ZyGraphNode.access$300(this.this$0).setY(var4);
   }

   public void changedSelection(IViewNode var1, boolean var2) {
      ZyGraphNode.access$100(this.this$0).setSelected(var2);
      this.this$0.onSelectionChanged();
      ZyGraphNode.access$200(this.this$0);
   }

   public void changedSelection(IZyNodeRealizer var1) {
      ZyGraphNode.access$300(this.this$0).setSelected(var1.isSelected());
   }

   public void changedSize(IZyNodeRealizer var1, double var2, double var4) {
      ZyGraphNode.access$300(this.this$0).setWidth(var2);
      ZyGraphNode.access$300(this.this$0).setHeight(var4);
   }

   public void changedVisibility(IViewNode var1, boolean var2) {
      (new ZyGraphNode$InternalListener$1(this, var1, var2)).invokeAndWait();
   }

   public void changedVisibility(IZyNodeRealizer var1) {
      ZyGraphNode.access$300(this.this$0).setVisible(var1.isVisible());
   }

   public void heightChanged(IViewNode var1, double var2) {
      if(ZyGraphNode.access$100(this.this$0).getHeight() != var2 && var2 != 0.0D) {
         ZyGraphNode.access$100(this.this$0).setHeight(var2);
         ZyGraphNode.access$200(this.this$0);
      }

   }

   public void regenerated(IZyNodeRealizer var1) {
   }

   public void widthChanged(IViewNode var1, double var2) {
      if(ZyGraphNode.access$100(this.this$0).getWidth() != var2 && var2 != 0.0D) {
         ZyGraphNode.access$100(this.this$0).setWidth(var2);
         ZyGraphNode.access$200(this.this$0);
      }

   }

   public void xposChanged(IViewNode var1, double var2) {
      if(ZyGraphNode.access$100(this.this$0).getX() != var2) {
         ZyGraphNode.access$100(this.this$0).setX(var2);
         ZyGraphNode.access$200(this.this$0);
      }

   }

   public void yposChanged(IViewNode var1, double var2) {
      if(ZyGraphNode.access$100(this.this$0).getY() != var2) {
         ZyGraphNode.access$100(this.this$0).setY(var2);
         ZyGraphNode.access$200(this.this$0);
      }

   }

   // $FF: synthetic method
   static void access$400(ZyGraphNode$InternalListener var0, IViewNode var1, boolean var2) {
      var0.showNode(var1, var2);
   }
}
