package com.google.security.zynamics.zylib.disassembly;

import com.google.security.zynamics.zylib.disassembly.IModuleConfiguration;
import com.google.security.zynamics.zylib.disassembly.IModuleContent;

public interface IModule {
   IModuleConfiguration getConfiguration();

   IModuleContent getContent();
}
