package com.google.security.zynamics.zylib.disassembly;

public interface IModuleConfiguration
{
    IAddress getFileBase();
    
    String getName();
}
