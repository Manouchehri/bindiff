package com.google.security.zynamics.zylib.disassembly;

public interface IModule
{
    IModuleConfiguration getConfiguration();
    
    IModuleContent getContent();
}
