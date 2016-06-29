package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.outdegree;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.outdegree.OutdegreeCriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriteriumCreator;

public class OutdegreeCriteriumCreator implements ICriteriumCreator {
   public ICriterium createCriterium() {
      return new OutdegreeCriterium();
   }

   public String getCriteriumDescription() {
      return "Select Nodes by Outdegree";
   }
}
