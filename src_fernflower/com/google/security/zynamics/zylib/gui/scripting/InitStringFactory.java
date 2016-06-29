package com.google.security.zynamics.zylib.gui.scripting;

public class InitStringFactory {
   public static String getInitString(String var0, String var1, String var2) {
      return var0 == null?"":(var0.startsWith("python")?String.format("import sys\nsys.stdout = %s\nsys.path.append(\'%s\')\n", new Object[]{var1, var2}):"");
   }
}
