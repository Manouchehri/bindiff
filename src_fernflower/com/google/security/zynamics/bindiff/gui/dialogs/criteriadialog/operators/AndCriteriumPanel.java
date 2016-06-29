package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.operators;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.operators.AbstractOperatorPanel;

public class AndCriteriumPanel extends AbstractOperatorPanel {
   public String getBorderTitle() {
      return "AND Operator";
   }

   public String getInvalidInfoString() {
      return "AND operator needs at least two children.";
   }

   public String getValidInfoString() {
      return "AND Operator is valid.";
   }
}
