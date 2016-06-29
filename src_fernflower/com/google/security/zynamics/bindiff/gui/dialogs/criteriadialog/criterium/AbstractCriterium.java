package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriteriumListener;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.Icon;

public abstract class AbstractCriterium implements ICriterium {
   private final ListenerProvider listeners = new ListenerProvider();

   protected void notifyListeners() {
      Iterator var1 = this.listeners.iterator();

      while(var1.hasNext()) {
         ICriteriumListener var2 = (ICriteriumListener)var1.next();
         var2.criteriumChanged();
      }

   }

   public void addListener(ICriteriumListener var1) {
      this.listeners.addListener(var1);
   }

   public Icon getIcon() {
      return null;
   }

   public void removeAllListener() {
      ArrayList var1 = new ArrayList();
      Iterator var2 = this.listeners.iterator();

      ICriteriumListener var3;
      while(var2.hasNext()) {
         var3 = (ICriteriumListener)var2.next();
         var1.add(var3);
      }

      var2 = var1.iterator();

      while(var2.hasNext()) {
         var3 = (ICriteriumListener)var2.next();
         this.removeListener(var3);
      }

   }

   public void removeListener(ICriteriumListener var1) {
      this.listeners.removeListener(var1);
   }
}
