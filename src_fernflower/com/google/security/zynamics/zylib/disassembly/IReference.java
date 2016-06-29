package com.google.security.zynamics.zylib.disassembly;

import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.disassembly.ReferenceType;

public interface IReference {
   IAddress getTarget();

   ReferenceType getType();
}
