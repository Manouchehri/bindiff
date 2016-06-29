package com.google.security.zynamics.zylib.disassembly;

import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.util.List;

public interface IInstruction {
   IAddress getAddress();

   String getArchitecture();

   byte[] getData();

   long getLength();

   String getMnemonic();

   Integer getMnemonicCode();

   List getOperands();
}
