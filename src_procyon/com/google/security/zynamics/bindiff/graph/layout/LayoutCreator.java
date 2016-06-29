package com.google.security.zynamics.bindiff.graph.layout;

import com.google.security.zynamics.bindiff.graph.settings.*;
import y.f.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.layouters.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.gui.zygraph.layouters.*;

public final class LayoutCreator
{
    public static c getCircularLayout(final GraphLayoutSettings graphLayoutSettings) {
        Preconditions.checkNotNull(graphLayoutSettings, (Object)"Settings argument can not be null");
        return ZyGraphLayouter.createCircularLayouter(CircularStyle.parseInt(ECircularLayoutStyle.getOrdinal(graphLayoutSettings.getCircularLayoutStyle())), graphLayoutSettings.getMinimumCircularNodeDistance());
    }
    
    public static c getHierarchicalLayout(final GraphLayoutSettings graphLayoutSettings) {
        Preconditions.checkNotNull(graphLayoutSettings, (Object)"Settings argument can not be null");
        return ZyGraphLayouter.createIncrementalHierarchicalLayouter(graphLayoutSettings.getHierarchicalOrthogonalEdgeRouting(), graphLayoutSettings.getMinimumHierarchicLayerDistance(), graphLayoutSettings.getMinimumHierarchicNodeDistance(), HierarchicOrientation.parseInt(ELayoutOrientation.getOrdinal(graphLayoutSettings.getHierarchicOrientation())));
    }
    
    public static c getOrthogonalLayout(final GraphLayoutSettings graphLayoutSettings) {
        Preconditions.checkNotNull(graphLayoutSettings, (Object)"Settings argument can not be null");
        return ZyGraphLayouter.createOrthoLayouter(OrthogonalStyle.parseInt(EOrthogonalLayoutStyle.getOrdinal(graphLayoutSettings.getOrthogonalLayoutStyle())), graphLayoutSettings.getMinimumOrthogonalNodeDistance(), graphLayoutSettings.getOrthogonalLayoutOrientation() == ELayoutOrientation.VERTICAL);
    }
}
