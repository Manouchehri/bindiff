package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.selection;

public enum SelectionState {
   SELECTED,
   UNSELECTED;

   public String toString() {
      return this == SELECTED?"selected":"unselected";
   }
}
