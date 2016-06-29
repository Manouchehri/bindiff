package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.gui.CDecFormatter$1;
import com.google.security.zynamics.zylib.gui.CDecFormatter$DecFilter;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.text.DocumentFilter;

public class CDecFormatter extends AbstractFormatter {
   private static final long serialVersionUID = 8368311921001233300L;
   private final CDecFormatter$DecFilter filter;
   private final int m_maxChar;
   private final int m_minNumber;
   private final int m_maxNumber;

   public CDecFormatter() {
      this(Integer.MAX_VALUE);
   }

   public CDecFormatter(int var1) {
      this.filter = new CDecFormatter$DecFilter(this, (CDecFormatter$1)null);
      this.m_maxChar = var1;
      this.m_minNumber = -1;
      this.m_maxNumber = -1;
   }

   public CDecFormatter(int var1, int var2, int var3) {
      this.filter = new CDecFormatter$DecFilter(this, (CDecFormatter$1)null);
      this.m_maxChar = var1;
      this.m_minNumber = var2;
      this.m_maxNumber = var3;
   }

   private boolean isValid(String var1, int var2) {
      // $FF: Couldn't be decompiled
   }

   protected DocumentFilter getDocumentFilter() {
      return this.filter;
   }

   public Object stringToValue(String var1) {
      return Long.valueOf(var1.equals("")?0L:Long.parseLong(var1));
   }

   public String valueToString(Object var1) {
      return var1 == null?null:Long.toString(((Long)var1).longValue());
   }

   // $FF: synthetic method
   static boolean access$100(CDecFormatter var0, String var1, int var2) {
      return var0.isValid(var1, var2);
   }
}
