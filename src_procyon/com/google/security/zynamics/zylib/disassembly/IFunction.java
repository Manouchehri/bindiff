package com.google.security.zynamics.zylib.disassembly;

public interface IFunction
{
    IAddress getAddress();
    
    int getBasicBlockCount();
    
    String getDescription();
    
    int getEdgeCount();
    
    int getIndegree();
    
    String getName();
    
    int getOutdegree();
    
    FunctionType getType();
}
