package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog;

import com.google.security.zynamics.bindiff.graph.AbstractGraphsContainer;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.indegrees.IndegreeCriteriumCreator;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.nodecolor.ColorCriteriumCreator;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.outdegree.OutdegreeCriteriumCreator;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.recursion.RecursionCriteriumCreator;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.selection.CSelectionCriteriumCreator;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.text.TextCriteriumCreator;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.visibillity.VisibilityCriteriumCreator;
import java.util.ArrayList;
import java.util.List;

public final class CriteriaFactory {
   private final AbstractGraphsContainer graphs;

   public CriteriaFactory(AbstractGraphsContainer var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Graph container can not be null");
      } else {
         this.graphs = var1;
      }
   }

   public List getConditions() {
      ArrayList var1 = new ArrayList();
      var1.add(new TextCriteriumCreator());
      var1.add(new ColorCriteriumCreator(this.graphs));
      var1.add(new IndegreeCriteriumCreator());
      var1.add(new OutdegreeCriteriumCreator());
      var1.add(new RecursionCriteriumCreator());
      var1.add(new VisibilityCriteriumCreator());
      var1.add(new CSelectionCriteriumCreator());
      return var1;
   }
}
