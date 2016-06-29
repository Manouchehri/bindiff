package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.indegrees;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.indegrees.IndegreeCriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriteriumCreator;

public class IndegreeCriteriumCreator implements ICriteriumCreator {
   public ICriterium createCriterium() {
      return new IndegreeCriterium();
   }

   public String getCriteriumDescription() {
      return "Select Nodes by Indegree";
   }
}
