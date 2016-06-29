package com.google.security.zynamics.zylib.gui.JRegisterView;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.JRegisterView.IRegisterModel;
import com.google.security.zynamics.zylib.gui.JRegisterView.IRegistersChangedListener;
import com.google.security.zynamics.zylib.gui.JRegisterView.RegisterInformation;
import com.google.security.zynamics.zylib.gui.JRegisterView.RegisterInformationInternal;
import java.math.BigInteger;
import java.util.HashMap;

public class SimpleRegisterModel implements IRegisterModel {
   private final HashMap registerMap = new HashMap();
   private final RegisterInformationInternal[] registers;

   public SimpleRegisterModel(RegisterInformation[] var1) {
      this.registers = new RegisterInformationInternal[var1.length];
      this.initializeRegisterInformation(var1);
   }

   private void initializeRegisterInformation(RegisterInformation[] var1) {
      // $FF: Couldn't be decompiled
   }

   public void addListener(IRegistersChangedListener var1) {
   }

   public int getNumberOfRegisters() {
      return this.registers.length;
   }

   public RegisterInformationInternal[] getRegisterInformation() {
      return this.registers;
   }

   public RegisterInformationInternal getRegisterInformation(int var1) {
      return this.registers[var1];
   }

   public void setValue(String var1, BigInteger var2) {
      Preconditions.checkNotNull(var1, "Error: Argument register can\'t be null");
      Preconditions.checkArgument(this.registerMap.containsKey(var1), "Error: Invalid register name");
      RegisterInformationInternal var3 = (RegisterInformationInternal)this.registerMap.get(var1);
      var3.setValue(var2);
      var3.setModified(true);
   }
}
