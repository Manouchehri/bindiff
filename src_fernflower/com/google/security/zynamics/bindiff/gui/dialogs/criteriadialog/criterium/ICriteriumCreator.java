package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriterium;

public interface ICriteriumCreator {
   ICriterium createCriterium();

   String getCriteriumDescription();
}
