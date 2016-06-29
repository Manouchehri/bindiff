package com.google.security.zynamics.zylib.gui.scripting;

public class ScriptingLanguage implements Comparable {
   private final String name;
   private final String version;

   public ScriptingLanguage(String var1, String var2) {
      this.name = var1;
      this.version = var2;
   }

   public int compareTo(ScriptingLanguage var1) {
      return this.name.compareTo(var1.name);
   }

   public String getName() {
      return this.name;
   }

   public String toString() {
      String var1 = this.name;
      String var2 = this.version;
      return (new StringBuilder(1 + String.valueOf(var1).length() + String.valueOf(var2).length())).append(var1).append(" ").append(var2).toString();
   }
}
