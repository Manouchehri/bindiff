package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium;

public enum CriteriumType {
   CONDITION,
   AND,
   OR,
   NOT;

   public boolean isOperator() {
      return this != CONDITION;
   }
}
