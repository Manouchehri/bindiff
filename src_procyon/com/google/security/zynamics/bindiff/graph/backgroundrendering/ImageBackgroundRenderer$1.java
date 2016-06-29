package com.google.security.zynamics.bindiff.graph.backgroundrendering;

import y.h.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.project.userview.*;
import com.google.security.zynamics.bindiff.utils.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.*;

class ImageBackgroundRenderer$1 implements Runnable
{
    final /* synthetic */ ImageBackgroundRenderer this$0;
    
    ImageBackgroundRenderer$1(final ImageBackgroundRenderer this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void run() {
        this.this$0.graphView.getGraph2D().T();
    }
}
