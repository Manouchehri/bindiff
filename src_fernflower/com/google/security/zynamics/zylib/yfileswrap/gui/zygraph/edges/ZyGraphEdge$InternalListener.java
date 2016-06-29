package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.edges.CBend;
import com.google.security.zynamics.zylib.gui.zygraph.edges.CViewEdge;
import com.google.security.zynamics.zylib.gui.zygraph.edges.EdgeType;
import com.google.security.zynamics.zylib.gui.zygraph.edges.IBendListener;
import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdge;
import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdgeListener;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEdgeRealizerListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge$1;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyEdgeRealizer;
import java.awt.Color;
import java.util.Iterator;
import y.c.d;
import y.c.q;
import y.d.t;
import y.h.aB;
import y.h.x;
import y.h.a.v;

class ZyGraphEdge$InternalListener implements IBendListener, IViewEdgeListener, IZyEdgeRealizerListener {
   // $FF: synthetic field
   final ZyGraphEdge this$0;

   private ZyGraphEdge$InternalListener(ZyGraphEdge var1) {
      this.this$0 = var1;
   }

   public void addedBend(double var1, double var3) {
      ZyGraphEdge.access$100(this.this$0).addBend(var1, var3);
   }

   public void addedBend(IViewEdge var1, CBend var2) {
      var2.addListener(ZyGraphEdge.access$200(this.this$0));
      if(ZyGraphEdge.access$300(this.this$0).bendCount() != var1.getBendCount()) {
         ZyGraphEdge.access$300(this.this$0).appendBend(var2.getX(), var2.getY());
      }
   }

   public void bendChanged(int var1, double var2, double var4) {
      CBend var6 = (CBend)ZyGraphEdge.access$100(this.this$0).getBends().get(var1);
      var6.setX(var2);
      var6.setY(var4);
   }

   public void changedColor(CViewEdge var1, Color var2) {
      ZyGraphEdge.access$300(this.this$0).setLineColor(var2);
      ZyGraphEdge.access$400(this.this$0);
   }

   public void changedLocation(ZyEdgeRealizer var1) {
      t var2 = var1.getSourcePoint();
      ZyGraphEdge.access$100(this.this$0).setX1(var2.a);
      ZyGraphEdge.access$100(this.this$0).setY1(var2.b);
      t var3 = var1.getTargetPoint();
      ZyGraphEdge.access$100(this.this$0).setX2(var3.a);
      ZyGraphEdge.access$100(this.this$0).setY2(var3.b);
   }

   public void changedSelection(IViewEdge var1, boolean var2) {
      ZyGraphEdge.access$300(this.this$0).setSelected(var2);
      ZyGraphEdge.access$400(this.this$0);
   }

   public void changedSourceX(CViewEdge var1, double var2) {
      t var4 = ZyGraphEdge.access$300(this.this$0).getSourcePoint();
      ZyGraphEdge.access$300(this.this$0).setSourcePoint(new t(var2, var4.b));
      ZyGraphEdge.access$400(this.this$0);
   }

   public void changedSourceY(CViewEdge var1, double var2) {
      t var4 = ZyGraphEdge.access$300(this.this$0).getSourcePoint();
      ZyGraphEdge.access$300(this.this$0).setSourcePoint(new t(var4.a, var2));
      ZyGraphEdge.access$400(this.this$0);
   }

   public void changedTargetX(CViewEdge var1, double var2) {
      t var4 = ZyGraphEdge.access$300(this.this$0).getTargetPoint();
      ZyGraphEdge.access$300(this.this$0).setTargetPoint(new t(var2, var4.b));
      ZyGraphEdge.access$400(this.this$0);
   }

   public void changedTargetY(CViewEdge var1, double var2) {
      t var4 = ZyGraphEdge.access$300(this.this$0).getTargetPoint();
      ZyGraphEdge.access$300(this.this$0).setTargetPoint(new t(var4.a, var2));
      ZyGraphEdge.access$400(this.this$0);
   }

   public void changedType(CViewEdge var1, EdgeType var2) {
   }

   public void changedVisibility(IViewEdge var1, boolean var2) {
      if(var2) {
         q var3 = ZyGraphEdge.access$500(this.this$0).getNode();
         q var4 = ZyGraphEdge.access$600(this.this$0).getNode();
         if(var3.e() == null || var4.e() == null) {
            return;
         }

         v var5 = ZyGraphEdge.access$700(this.this$0).C();
         d var6 = var5.a(var3, var4);
         ZyGraphEdge.access$700(this.this$0).a((d)var6, (aB)ZyGraphEdge.access$300(this.this$0));
         ZyGraphEdge.access$802(this.this$0, var6);
      } else if(ZyGraphEdge.access$800(this.this$0).a() == ZyGraphEdge.access$700(this.this$0)) {
         ZyGraphEdge.access$700(this.this$0).a((d)ZyGraphEdge.access$800(this.this$0));
      }

   }

   public void changedVisibility(ZyEdgeRealizer var1) {
      ZyGraphEdge.access$100(this.this$0).setVisible(var1.isVisible());
   }

   public void changedX(CBend var1, double var2) {
      int var4 = ZyGraphEdge.access$100(this.this$0).getBends().indexOf(var1);
      x var5 = ZyGraphEdge.access$300(this.this$0).getBend(var4);
      var5.a(var2, var5.c());
   }

   public void changedY(CBend var1, double var2) {
      int var4 = ZyGraphEdge.access$100(this.this$0).getBends().indexOf(var1);
      x var5 = ZyGraphEdge.access$300(this.this$0).getBend(var4);
      var5.a(var5.b(), var2);
   }

   public void clearedBends() {
      Iterator var1 = ZyGraphEdge.access$100(this.this$0).getBends().iterator();

      while(var1.hasNext()) {
         CBend var2 = (CBend)var1.next();
         var2.removeListener(this);
      }

      ZyGraphEdge.access$100(this.this$0).clearBends();
   }

   public void clearedBends(IViewEdge var1) {
      if(ZyGraphEdge.access$300(this.this$0).bendCount() != 0) {
         ZyGraphEdge.access$300(this.this$0).clearBends();
      }

   }

   public void insertedBend(int var1, double var2, double var4) {
      if(ZyGraphEdge.access$300(this.this$0).bendCount() != ZyGraphEdge.access$100(this.this$0).getBendCount()) {
         ZyGraphEdge.access$100(this.this$0).insertBend(var1, var2, var4);
      }
   }

   public void insertedBend(IViewEdge var1, int var2, CBend var3) {
      Preconditions.checkNotNull(var1, "Edge cannot be null");
      Preconditions.checkNotNull(var3, "Error: bend argument can not be null");
      var3.addListener(ZyGraphEdge.access$200(this.this$0));
      if(ZyGraphEdge.access$300(this.this$0).bendCount() != var1.getBendCount()) {
         if(var1 == this) {
            ZyGraphEdge.access$300(this.this$0).insertBend(var3.getX(), var3.getY());
         }

      }
   }

   public void regenerated(ZyEdgeRealizer var1) {
   }

   public void removedBend(CViewEdge var1, int var2, CBend var3) {
      var3.removeListener(ZyGraphEdge.access$200(this.this$0));
      if(ZyGraphEdge.access$300(this.this$0).bendCount() != ZyGraphEdge.access$100(this.this$0).getBendCount()) {
         ZyGraphEdge.access$300(this.this$0).removeBend(ZyGraphEdge.access$300(this.this$0).getBend(var2));
      }
   }

   public void removedBend(ZyEdgeRealizer var1, int var2) {
      ZyGraphEdge.access$100(this.this$0).removeBend(var2);
   }

   // $FF: synthetic method
   ZyGraphEdge$InternalListener(ZyGraphEdge var1, ZyGraphEdge$1 var2) {
      this(var1);
   }
}
