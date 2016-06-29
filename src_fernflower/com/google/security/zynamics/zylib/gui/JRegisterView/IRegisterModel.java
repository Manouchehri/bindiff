package com.google.security.zynamics.zylib.gui.JRegisterView;

import com.google.security.zynamics.zylib.gui.JRegisterView.IRegistersChangedListener;
import com.google.security.zynamics.zylib.gui.JRegisterView.RegisterInformationInternal;
import java.math.BigInteger;

public interface IRegisterModel {
   void addListener(IRegistersChangedListener var1);

   int getNumberOfRegisters();

   RegisterInformationInternal[] getRegisterInformation();

   RegisterInformationInternal getRegisterInformation(int var1);

   void setValue(String var1, BigInteger var2);
}
