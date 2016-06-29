package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.text;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.text.TextCriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriteriumCreator;

public class TextCriteriumCreator implements ICriteriumCreator {
   public ICriterium createCriterium() {
      return new TextCriterium();
   }

   public String getCriteriumDescription() {
      return "Select Nodes by Text";
   }
}
