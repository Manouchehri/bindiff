package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.root;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.root.RootCriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriteriumCreator;

public class RootCriteriumCreator implements ICriteriumCreator {
   public ICriterium createCriterium() {
      return new RootCriterium();
   }

   public String getCriteriumDescription() {
      return "Root Node";
   }
}
