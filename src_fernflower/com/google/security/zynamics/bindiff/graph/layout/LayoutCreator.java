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
   public static c getCircularLayout(GraphLayoutSettings var0) {
      Preconditions.checkNotNull(var0, "Settings argument can not be null");
      ECircularLayoutStyle var1 = var0.getCircularLayoutStyle();
      long var2 = var0.getMinimumCircularNodeDistance();
      return ZyGraphLayouter.createCircularLayouter(CircularStyle.parseInt(ECircularLayoutStyle.getOrdinal(var1)), var2);
   }

   public static c getHierarchicalLayout(GraphLayoutSettings var0) {
      Preconditions.checkNotNull(var0, "Settings argument can not be null");
      boolean var1 = var0.getHierarchicalOrthogonalEdgeRouting();
      long var2 = var0.getMinimumHierarchicLayerDistance();
      long var4 = var0.getMinimumHierarchicNodeDistance();
      ELayoutOrientation var6 = var0.getHierarchicOrientation();
      HierarchicOrientation var7 = HierarchicOrientation.parseInt(ELayoutOrientation.getOrdinal(var6));
      return ZyGraphLayouter.createIncrementalHierarchicalLayouter(var1, var2, var4, var7);
   }

   public static c getOrthogonalLayout(GraphLayoutSettings var0) {
      Preconditions.checkNotNull(var0, "Settings argument can not be null");
      EOrthogonalLayoutStyle var1 = var0.getOrthogonalLayoutStyle();
      long var2 = var0.getMinimumOrthogonalNodeDistance();
      boolean var4 = var0.getOrthogonalLayoutOrientation() == ELayoutOrientation.VERTICAL;
      OrthogonalStyle var5 = OrthogonalStyle.parseInt(EOrthogonalLayoutStyle.getOrdinal(var1));
      return ZyGraphLayouter.createOrthoLayouter(var5, var2, var4);
   }
}
