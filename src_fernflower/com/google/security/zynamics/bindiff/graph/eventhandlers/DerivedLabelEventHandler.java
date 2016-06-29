package com.google.security.zynamics.bindiff.graph.eventhandlers;

import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.zylib.gui.zygraph.CDefaultLabelEventHandler;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyRegenerateableRealizer;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.ZyEditMode;

public class DerivedLabelEventHandler extends CDefaultLabelEventHandler {
   public DerivedLabelEventHandler(AbstractZyGraph var1) {
      super(var1);
   }

   public void activateLabelContent(ZyLabelContent var1, IZyRegenerateableRealizer var2) {
      SingleGraph var3 = ((BinDiffGraph)this.getGraph()).getPrimaryGraph();
      SingleGraph var4 = ((BinDiffGraph)this.getGraph()).getSecondaryGraph();
      CombinedGraph var5 = ((BinDiffGraph)this.getGraph()).getCombinedGraph();
      ZyEditMode var6 = var3.getEditMode();
      ZyEditMode var7 = var4.getEditMode();
      ZyEditMode var8 = var5.getEditMode();
      CDefaultLabelEventHandler var9 = var6.getLabelEventHandler();
      CDefaultLabelEventHandler var10 = var7.getLabelEventHandler();
      CDefaultLabelEventHandler var11 = var8.getLabelEventHandler();
      if(!var9.isActiveLabel(var1)) {
         var9.deactivateLabelContent();
      }

      if(!var10.isActiveLabel(var1)) {
         var10.deactivateLabelContent();
      }

      if(!var11.isActiveLabel(var1)) {
         var11.deactivateLabelContent();
      }

      super.activateLabelContent(var1, var2);
      var3.updateViews();
      var4.updateViews();
      ((BinDiffGraph)this.getGraph()).getCombinedGraph().updateViews();
   }
}
