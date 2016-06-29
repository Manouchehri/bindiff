/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.backgroundrendering;

import com.google.security.zynamics.bindiff.graph.backgroundrendering.ImageBackgroundRenderer;
import y.h.bu;

class ImageBackgroundRenderer$1
implements Runnable {
    final /* synthetic */ ImageBackgroundRenderer this$0;

    ImageBackgroundRenderer$1(ImageBackgroundRenderer imageBackgroundRenderer) {
        this.this$0 = imageBackgroundRenderer;
    }

    @Override
    public void run() {
        ImageBackgroundRenderer.access$000(this.this$0).getGraph2D().T();
    }
}

