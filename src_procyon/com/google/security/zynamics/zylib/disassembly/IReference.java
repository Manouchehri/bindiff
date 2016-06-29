package com.google.security.zynamics.zylib.disassembly;

public interface IReference
{
    IAddress getTarget();
    
    ReferenceType getType();
}
