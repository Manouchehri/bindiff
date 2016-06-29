package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity;

import com.google.security.zynamics.zylib.gui.zygraph.IZyGraphVisibilityListener;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.GraphHelpers;
import com.google.security.zynamics.zylib.gui.zygraph.wrappers.ViewableGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyDefaultProximityBrowser;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyDefaultProximityBrowser$1;
import java.util.Set;

class ZyDefaultProximityBrowser$InternalVisibilityListener implements IZyGraphVisibilityListener {
   // $FF: synthetic field
   final ZyDefaultProximityBrowser this$0;

   private ZyDefaultProximityBrowser$InternalVisibilityListener(ZyDefaultProximityBrowser var1) {
      this.this$0 = var1;
   }

   public void nodeDeleted() {
      ZyDefaultProximityBrowser.access$700(this.this$0).clear();
      Set var1 = GraphHelpers.getVisibleNodes(ViewableGraph.wrap(ZyDefaultProximityBrowser.access$500(this.this$0)));
      ZyDefaultProximityBrowser.access$800(this.this$0, var1);
   }

   public void visibilityChanged() {
      if(ZyDefaultProximityBrowser.access$300(this.this$0)) {
         ZyDefaultProximityBrowser.access$902(this.this$0, false);
      }

      Set var1 = GraphHelpers.getVisibleNodes(ViewableGraph.wrap(ZyDefaultProximityBrowser.access$500(this.this$0)));
      ZyDefaultProximityBrowser.access$800(this.this$0, var1);
      ZyDefaultProximityBrowser.access$902(this.this$0, true);
   }

   // $FF: synthetic method
   ZyDefaultProximityBrowser$InternalVisibilityListener(ZyDefaultProximityBrowser var1, ZyDefaultProximityBrowser$1 var2) {
      this(var1);
   }
}
