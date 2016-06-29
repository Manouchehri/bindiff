package com.google.security.zynamics.bindiff.graph.backgroundrendering;

import com.google.security.zynamics.bindiff.graph.backgroundrendering.BackgroundRendererManager;
import com.google.security.zynamics.bindiff.graph.backgroundrendering.BackgroundRendererManager$1;
import com.google.security.zynamics.bindiff.graph.settings.GraphDisplaySettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettingsChangedListenerAdapter;

class BackgroundRendererManager$InternalGraphSettingsChangedListener extends GraphSettingsChangedListenerAdapter {
   // $FF: synthetic field
   final BackgroundRendererManager this$0;

   private BackgroundRendererManager$InternalGraphSettingsChangedListener(BackgroundRendererManager var1) {
      this.this$0 = var1;
   }

   public void diffViewModeChanged(GraphSettings var1) {
      if(var1.getDisplaySettings().getGradientBackground()) {
         BackgroundRendererManager.access$100(this.this$0).update();
      } else {
         BackgroundRendererManager.access$200(this.this$0).update();
      }

   }

   public void gradientBackgroundChanged(GraphDisplaySettings var1) {
      if(var1.getGradientBackground()) {
         BackgroundRendererManager.access$300(this.this$0).setBackgroundRenderer(BackgroundRendererManager.access$100(this.this$0));
         BackgroundRendererManager.access$100(this.this$0).update();
      } else {
         BackgroundRendererManager.access$300(this.this$0).setBackgroundRenderer(BackgroundRendererManager.access$200(this.this$0));
         BackgroundRendererManager.access$200(this.this$0).update();
      }

   }

   // $FF: synthetic method
   BackgroundRendererManager$InternalGraphSettingsChangedListener(BackgroundRendererManager var1, BackgroundRendererManager$1 var2) {
      this(var1);
   }
}
