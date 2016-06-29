package com.google.security.zynamics.bindiff.project.matches;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.zylib.disassembly.IAddress;

public interface IAddressPair {
   long getAddress(ESide var1);

   IAddress getIAddress(ESide var1);
}
