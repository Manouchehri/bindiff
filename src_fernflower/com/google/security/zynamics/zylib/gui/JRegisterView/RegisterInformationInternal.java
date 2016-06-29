package com.google.security.zynamics.zylib.gui.JRegisterView;

import com.google.security.zynamics.zylib.gui.JRegisterView.RegisterInformation;
import java.math.BigInteger;

public class RegisterInformationInternal extends RegisterInformation {
   private BigInteger value;
   private boolean modified;

   public RegisterInformationInternal(String var1, int var2) {
      super(var1, var2);
      this.value = BigInteger.ZERO;
      this.modified = false;
   }

   public BigInteger getValue() {
      return this.value;
   }

   public boolean isModified() {
      return this.modified;
   }

   public void setModified(boolean var1) {
      this.modified = var1;
   }

   public void setValue(BigInteger var1) {
      this.value = var1;
   }
}
