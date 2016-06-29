package com.google.security.zynamics.zylib.general.comparators;

import java.io.Serializable;
import java.util.Comparator;
import javax.swing.JCheckBox;

public class JCheckBoxComparator implements Serializable, Comparator {
   private static final long serialVersionUID = -2526854370340524821L;

   public int compare(JCheckBox var1, JCheckBox var2) {
      return Boolean.valueOf(var1.isSelected()).compareTo(Boolean.valueOf(var2.isSelected()));
   }
}
