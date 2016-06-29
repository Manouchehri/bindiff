package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.operators;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.operators.AbstractOperatorPanel;

public class NotCriteriumPanel extends AbstractOperatorPanel {
   public String getBorderTitle() {
      return "NOT Operator";
   }

   public String getInvalidInfoString() {
      return "NOT operator requires exactly one child.";
   }

   public String getValidInfoString() {
      return "NOT Operator is valid.";
   }
}
