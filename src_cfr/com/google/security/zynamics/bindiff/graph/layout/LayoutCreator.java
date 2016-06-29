/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.layout;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ECircularLayoutStyle;
import com.google.security.zynamics.bindiff.enums.ELayoutOrientation;
import com.google.security.zynamics.bindiff.enums.EOrthogonalLayoutStyle;
import com.google.security.zynamics.bindiff.graph.settings.GraphLayoutSettings;
import com.google.security.zynamics.zylib.gui.zygraph.layouters.CircularStyle;
import com.google.security.zynamics.zylib.gui.zygraph.layouters.HierarchicOrientation;
import com.google.security.zynamics.zylib.gui.zygraph.layouters.OrthogonalStyle;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.layouters.ZyGraphLayouter;
import y.f.c;

public final class LayoutCreator {
    public static c getCircularLayout(GraphLayoutSettings graphLayoutSettings) {
        Preconditions.checkNotNull(graphLayoutSettings, "Settings argument can not be null");
        ECircularLayoutStyle eCircularLayoutStyle = graphLayoutSettings.getCircularLayoutStyle();
        long l2 = graphLayoutSettings.getMinimumCircularNodeDistance();
        return ZyGraphLayouter.createCircularLayouter(CircularStyle.parseInt(ECircularLayoutStyle.getOrdinal(eCircularLayoutStyle)), l2);
    }

    public static c getHierarchicalLayout(GraphLayoutSettings graphLayoutSettings) {
        Preconditions.checkNotNull(graphLayoutSettings, "Settings argument can not be null");
        boolean bl2 = graphLayoutSettings.getHierarchicalOrthogonalEdgeRouting();
        long l2 = graphLayoutSettings.getMinimumHierarchicLayerDistance();
        long l3 = graphLayoutSettings.getMinimumHierarchicNodeDistance();
        ELayoutOrientation eLayoutOrientation = graphLayoutSettings.getHierarchicOrientation();
        HierarchicOrientation hierarchicOrientation = HierarchicOrientation.parseInt(ELayoutOrientation.getOrdinal(eLayoutOrientation));
        return ZyGraphLayouter.createIncrementalHierarchicalLayouter(bl2, l2, l3, hierarchicOrientation);
    }

    public static c getOrthogonalLayout(GraphLayoutSettings graphLayoutSettings) {
        Preconditions.checkNotNull(graphLayoutSettings, "Settings argument can not be null");
        EOrthogonalLayoutStyle eOrthogonalLayoutStyle = graphLayoutSettings.getOrthogonalLayoutStyle();
        long l2 = graphLayoutSettings.getMinimumOrthogonalNodeDistance();
        boolean bl2 = graphLayoutSettings.getOrthogonalLayoutOrientation() == ELayoutOrientation.VERTICAL;
        OrthogonalStyle orthogonalStyle = OrthogonalStyle.parseInt(EOrthogonalLayoutStyle.getOrdinal(eOrthogonalLayoutStyle));
        return ZyGraphLayouter.createOrthoLayouter(orthogonalStyle, l2, bl2);
    }
}

