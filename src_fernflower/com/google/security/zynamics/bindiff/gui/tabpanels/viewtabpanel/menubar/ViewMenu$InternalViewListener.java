package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ISavableListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar.ViewMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar.ViewMenu$1;

class ViewMenu$InternalViewListener implements ISavableListener {
   // $FF: synthetic field
   final ViewMenu this$0;

   private ViewMenu$InternalViewListener(ViewMenu var1) {
      this.this$0 = var1;
   }

   public void isSavable(boolean var1) {
      if(!ViewMenu.access$100(this.this$0).getGraphs().getDiff().isFunctionDiff()) {
         if(ViewMenu.access$200(this.this$0).isEnabled() != var1) {
            ViewMenu.access$200(this.this$0).setEnabled(var1);
         }
      } else {
         ViewMenu.access$200(this.this$0).setEnabled(true);
      }

   }

   // $FF: synthetic method
   ViewMenu$InternalViewListener(ViewMenu var1, ViewMenu$1 var2) {
      this(var1);
   }
}
