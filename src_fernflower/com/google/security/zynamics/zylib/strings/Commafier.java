package com.google.security.zynamics.zylib.strings;

import java.util.Iterator;

public final class Commafier {
   private static String DEFAULT_SEPARATOR = ", ";
   private final String m_separator;
   private final StringBuilder sb;
   private boolean needsComma;

   public Commafier() {
      this.sb = new StringBuilder();
      this.needsComma = false;
      this.m_separator = DEFAULT_SEPARATOR;
   }

   public Commafier(Iterable var1) {
      this(var1, DEFAULT_SEPARATOR);
   }

   public Commafier(Iterable var1, String var2) {
      this.sb = new StringBuilder();
      this.needsComma = false;
      this.m_separator = var2;
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         Object var4 = var3.next();
         this.append(var4);
      }

   }

   public Commafier(String var1) {
      this.sb = new StringBuilder();
      this.needsComma = false;
      this.m_separator = DEFAULT_SEPARATOR;
      this.sb.append(var1);
   }

   public static String commafy(Iterable var0) {
      return (new Commafier(var0)).toString();
   }

   public static String commafy(Iterable var0, String var1) {
      return (new Commafier(var0, var1)).toString();
   }

   public void append(Object var1) {
      if(this.needsComma) {
         this.sb.append(this.m_separator);
      }

      this.needsComma = true;
      this.sb.append(var1);
   }

   public void appendUncommafied(String var1) {
      this.sb.append(var1);
   }

   public String toString() {
      return this.sb.toString();
   }
}
