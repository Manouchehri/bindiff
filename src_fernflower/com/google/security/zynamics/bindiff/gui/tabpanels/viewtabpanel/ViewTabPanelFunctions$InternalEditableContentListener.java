package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions$1;
import com.google.security.zynamics.zylib.gui.zygraph.ILabelEditableContentListener;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;

class ViewTabPanelFunctions$InternalEditableContentListener implements ILabelEditableContentListener {
   // $FF: synthetic field
   final ViewTabPanelFunctions this$0;

   private ViewTabPanelFunctions$InternalEditableContentListener(ViewTabPanelFunctions var1) {
      this.this$0 = var1;
   }

   public void editableContentChanged(ZyLabelContent var1) {
      ViewTabPanelFunctions.access$100(this.this$0, true);
   }

   // $FF: synthetic method
   ViewTabPanelFunctions$InternalEditableContentListener(ViewTabPanelFunctions var1, ViewTabPanelFunctions$1 var2) {
      this(var1);
   }
}
