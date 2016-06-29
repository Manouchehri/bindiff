package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.nodecolor;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.AbstractGraphsContainer;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.nodecolor.ColorCriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriteriumCreator;

public class ColorCriteriumCreator implements ICriteriumCreator {
   private final AbstractGraphsContainer graphs;

   public ColorCriteriumCreator(AbstractGraphsContainer var1) {
      Preconditions.checkNotNull(var1);
      this.graphs = var1;
   }

   public ICriterium createCriterium() {
      return new ColorCriterium(this.graphs);
   }

   public String getCriteriumDescription() {
      return "Select Nodes by Color";
   }
}
