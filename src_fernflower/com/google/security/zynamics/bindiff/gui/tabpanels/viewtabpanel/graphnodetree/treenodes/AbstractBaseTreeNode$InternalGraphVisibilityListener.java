package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes;

import com.google.security.zynamics.bindiff.enums.ESortByCriterium;
import com.google.security.zynamics.bindiff.graph.filter.enums.EVisibilityFilter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractBaseTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractBaseTreeNode$1;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.gui.zygraph.IZyGraphVisibilityListener;
import java.util.Iterator;

class AbstractBaseTreeNode$InternalGraphVisibilityListener implements IZyGraphVisibilityListener {
   // $FF: synthetic field
   final AbstractBaseTreeNode this$0;

   private AbstractBaseTreeNode$InternalGraphVisibilityListener(AbstractBaseTreeNode var1) {
      this.this$0 = var1;
   }

   private void handleNotifcationAndUpdateTreeNodes() {
      boolean var1 = this.this$0.getFilter().getVisibilityFilterValue() != EVisibilityFilter.NONE;
      if(!var1) {
         Iterator var2 = this.this$0.getSorter().iterator();

         while(var2.hasNext()) {
            Pair var3 = (Pair)var2.next();
            var1 = var3.first() == ESortByCriterium.VISIBILITY;
            if(var1) {
               break;
            }
         }
      }

      if(var1) {
         this.this$0.updateTreeNodes(false);
      }

   }

   public void nodeDeleted() {
      this.handleNotifcationAndUpdateTreeNodes();
   }

   public void visibilityChanged() {
      this.handleNotifcationAndUpdateTreeNodes();
   }

   // $FF: synthetic method
   AbstractBaseTreeNode$InternalGraphVisibilityListener(AbstractBaseTreeNode var1, AbstractBaseTreeNode$1 var2) {
      this(var1);
   }
}
