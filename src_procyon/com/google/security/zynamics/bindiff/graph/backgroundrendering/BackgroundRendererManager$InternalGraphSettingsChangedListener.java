package com.google.security.zynamics.bindiff.graph.backgroundrendering;

import java.awt.*;
import y.h.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.graph.settings.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.project.userview.*;
import com.google.security.zynamics.bindiff.resources.*;

class BackgroundRendererManager$InternalGraphSettingsChangedListener extends GraphSettingsChangedListenerAdapter
{
    final /* synthetic */ BackgroundRendererManager this$0;
    
    private BackgroundRendererManager$InternalGraphSettingsChangedListener(final BackgroundRendererManager this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void diffViewModeChanged(final GraphSettings graphSettings) {
        if (graphSettings.getDisplaySettings().getGradientBackground()) {
            this.this$0.gradientBackgroundRenderer.update();
        }
        else {
            this.this$0.imageBackgroundRenderer.update();
        }
    }
    
    @Override
    public void gradientBackgroundChanged(final GraphDisplaySettings graphDisplaySettings) {
        if (graphDisplaySettings.getGradientBackground()) {
            this.this$0.view.setBackgroundRenderer(this.this$0.gradientBackgroundRenderer);
            this.this$0.gradientBackgroundRenderer.update();
        }
        else {
            this.this$0.view.setBackgroundRenderer(this.this$0.imageBackgroundRenderer);
            this.this$0.imageBackgroundRenderer.update();
        }
    }
}
