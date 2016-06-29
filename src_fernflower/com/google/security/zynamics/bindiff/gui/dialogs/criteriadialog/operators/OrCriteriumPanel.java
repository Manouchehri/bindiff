package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.operators;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.operators.AbstractOperatorPanel;

public class OrCriteriumPanel extends AbstractOperatorPanel {
   public String getBorderTitle() {
      return "OR Operator";
   }

   public String getInvalidInfoString() {
      return "OR operator needs at least two child conditions or operators.";
   }

   public String getValidInfoString() {
      return "OR Operator is valid.";
   }
}
