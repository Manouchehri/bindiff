package com.google.security.zynamics.bindiff.graph.backgroundrendering;

import com.google.security.zynamics.bindiff.graph.backgroundrendering.ImageBackgroundRenderer;

class ImageBackgroundRenderer$1 implements Runnable {
   // $FF: synthetic field
   final ImageBackgroundRenderer this$0;

   ImageBackgroundRenderer$1(ImageBackgroundRenderer var1) {
      this.this$0 = var1;
   }

   public void run() {
      ImageBackgroundRenderer.access$000(this.this$0).getGraph2D().T();
   }
}
