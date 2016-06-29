package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.AbstractGraphNodeTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.AbstractGraphNodeTree$1;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class AbstractGraphNodeTree$InternalMouseListener extends MouseAdapter {
   // $FF: synthetic field
   final AbstractGraphNodeTree this$0;

   private AbstractGraphNodeTree$InternalMouseListener(AbstractGraphNodeTree var1) {
      this.this$0 = var1;
   }

   public void mousePressed(MouseEvent var1) {
      AbstractGraphNodeTree.access$300(this.this$0, var1);
   }

   public void mouseReleased(MouseEvent var1) {
      AbstractGraphNodeTree.access$300(this.this$0, var1);
   }

   // $FF: synthetic method
   AbstractGraphNodeTree$InternalMouseListener(AbstractGraphNodeTree var1, AbstractGraphNodeTree$1 var2) {
      this(var1);
   }
}
