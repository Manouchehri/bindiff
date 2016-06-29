package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.visibillity;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.visibillity.VisibilityCriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriteriumCreator;

public class VisibilityCriteriumCreator implements ICriteriumCreator {
   public ICriterium createCriterium() {
      return new VisibilityCriterium();
   }

   public String getCriteriumDescription() {
      return "Select Nodes by Visibility";
   }
}
