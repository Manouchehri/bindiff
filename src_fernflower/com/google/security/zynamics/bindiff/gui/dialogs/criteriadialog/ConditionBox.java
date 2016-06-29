package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.CriteriumWrapper;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriteriumCreator;
import java.util.Iterator;
import java.util.List;
import javax.swing.JComboBox;

public class ConditionBox extends JComboBox {
   public ConditionBox(List var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         ICriteriumCreator var3 = (ICriteriumCreator)var2.next();
         this.addItem((new CriteriumWrapper(var3)).toString());
      }

   }
}
