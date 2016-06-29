package com.google.security.zynamics.zylib.gui.JRegisterView;

public class RegisterInformation {
   private final String registerName;
   private final int registerSize;

   public RegisterInformation(String var1, int var2) {
      this.registerName = var1;
      this.registerSize = var2;
   }

   public String getRegisterName() {
      return this.registerName;
   }

   public int getRegisterSize() {
      return this.registerSize;
   }
}
