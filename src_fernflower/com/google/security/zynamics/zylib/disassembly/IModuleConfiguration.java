package com.google.security.zynamics.zylib.disassembly;

import com.google.security.zynamics.zylib.disassembly.IAddress;

public interface IModuleConfiguration {
   IAddress getFileBase();

   String getName();
}
