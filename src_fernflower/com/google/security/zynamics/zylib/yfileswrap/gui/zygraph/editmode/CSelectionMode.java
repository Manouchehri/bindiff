package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyProximityNode;
import java.awt.Rectangle;
import java.util.Iterator;
import y.c.d;
import y.c.e;
import y.c.q;
import y.c.x;
import y.c.y;
import y.h.gf;

public class CSelectionMode extends gf {
   private final AbstractZyGraph m_graph;

   public CSelectionMode(AbstractZyGraph var1) {
      this.m_graph = (AbstractZyGraph)Preconditions.checkNotNull(var1, "Error: Graph argument can not be null");
   }

   protected void selectionBoxAction(Rectangle var1, boolean var2) {
      this.m_graph.getGraph().r();
      y var3 = new y();

      for(x var4 = this.m_graph.getGraph().o(); var4.f(); var4.g()) {
         ZyGraphNode var5 = this.m_graph.getNode(var4.e());
         if(var5 != null && !(var5 instanceof ZyProximityNode) && this.belongsToSelection(var4.e(), var1)) {
            var3.add(var4.e());
         }
      }

      if((this.getLastDragEvent().getModifiersEx() & 128) == 0 && (this.getLastDragEvent().getModifiersEx() & 64) == 0) {
         this.m_graph.getGraph().N();
      }

      Iterator var8 = var3.iterator();

      q var6;
      while(var8.hasNext()) {
         Object var10 = var8.next();
         var6 = (q)var10;
         this.m_graph.getGraph().a(var6, true);
      }

      for(e var9 = this.m_graph.getGraph().K(); var9.f(); var9.g()) {
         d var11 = var9.a();
         var6 = var11.c();
         q var7 = var11.d();
         if(!this.m_graph.getGraph().t(var6).isSelected() && !this.m_graph.getGraph().t(var7).isSelected()) {
            this.m_graph.getGraph().i(var11).setSelected(false);
         }
      }

      this.m_graph.getGraph().s();
      this.m_graph.getGraph().T();
   }
}
