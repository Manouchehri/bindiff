package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.AbstractGraphNodeTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.AbstractGraphNodeTree$1;
import com.google.security.zynamics.zylib.gui.zygraph.IZyGraphSelectionListener;

class AbstractGraphNodeTree$InternalGraphSelectionListener implements IZyGraphSelectionListener {
   // $FF: synthetic field
   final AbstractGraphNodeTree this$0;

   private AbstractGraphNodeTree$InternalGraphSelectionListener(AbstractGraphNodeTree var1) {
      this.this$0 = var1;
   }

   public void selectionChanged() {
      this.this$0.updateUI();
   }

   // $FF: synthetic method
   AbstractGraphNodeTree$InternalGraphSelectionListener(AbstractGraphNodeTree var1, AbstractGraphNodeTree$1 var2) {
      this(var1);
   }
}
