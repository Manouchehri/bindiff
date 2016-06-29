package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriteriumCreator;
import com.google.security.zynamics.zylib.gui.DefaultWrapper;

public class CriteriumWrapper extends DefaultWrapper {
   public CriteriumWrapper(ICriteriumCreator var1) {
      super(var1);
   }

   public String toString() {
      return ((ICriteriumCreator)this.getObject()).getCriteriumDescription();
   }
}
