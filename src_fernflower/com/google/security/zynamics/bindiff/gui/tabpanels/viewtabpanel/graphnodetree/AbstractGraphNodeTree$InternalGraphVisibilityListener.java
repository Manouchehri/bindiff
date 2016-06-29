package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.AbstractGraphNodeTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.AbstractGraphNodeTree$1;
import com.google.security.zynamics.zylib.gui.zygraph.IZyGraphVisibilityListener;

class AbstractGraphNodeTree$InternalGraphVisibilityListener implements IZyGraphVisibilityListener {
   // $FF: synthetic field
   final AbstractGraphNodeTree this$0;

   private AbstractGraphNodeTree$InternalGraphVisibilityListener(AbstractGraphNodeTree var1) {
      this.this$0 = var1;
   }

   public void nodeDeleted() {
      this.this$0.updateUI();
   }

   public void visibilityChanged() {
      this.this$0.updateUI();
   }

   // $FF: synthetic method
   AbstractGraphNodeTree$InternalGraphVisibilityListener(AbstractGraphNodeTree var1, AbstractGraphNodeTree$1 var2) {
      this(var1);
   }
}
