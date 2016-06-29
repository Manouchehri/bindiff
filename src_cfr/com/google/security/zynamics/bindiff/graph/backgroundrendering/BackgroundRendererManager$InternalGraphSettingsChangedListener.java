/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.backgroundrendering;

import com.google.security.zynamics.bindiff.graph.backgroundrendering.BackgroundRendererManager;
import com.google.security.zynamics.bindiff.graph.backgroundrendering.BackgroundRendererManager$1;
import com.google.security.zynamics.bindiff.graph.settings.GraphDisplaySettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettingsChangedListenerAdapter;
import y.h.w;

class BackgroundRendererManager$InternalGraphSettingsChangedListener
extends GraphSettingsChangedListenerAdapter {
    final /* synthetic */ BackgroundRendererManager this$0;

    private BackgroundRendererManager$InternalGraphSettingsChangedListener(BackgroundRendererManager backgroundRendererManager) {
        this.this$0 = backgroundRendererManager;
    }

    @Override
    public void diffViewModeChanged(GraphSettings graphSettings) {
        if (graphSettings.getDisplaySettings().getGradientBackground()) {
            BackgroundRendererManager.access$100(this.this$0).update();
            return;
        }
        BackgroundRendererManager.access$200(this.this$0).update();
    }

    @Override
    public void gradientBackgroundChanged(GraphDisplaySettings graphDisplaySettings) {
        if (graphDisplaySettings.getGradientBackground()) {
            BackgroundRendererManager.access$300(this.this$0).setBackgroundRenderer(BackgroundRendererManager.access$100(this.this$0));
            BackgroundRendererManager.access$100(this.this$0).update();
            return;
        }
        BackgroundRendererManager.access$300(this.this$0).setBackgroundRenderer(BackgroundRendererManager.access$200(this.this$0));
        BackgroundRendererManager.access$200(this.this$0).update();
    }

    /* synthetic */ BackgroundRendererManager$InternalGraphSettingsChangedListener(BackgroundRendererManager backgroundRendererManager, BackgroundRendererManager$1 backgroundRendererManager$1) {
        this(backgroundRendererManager);
    }
}

