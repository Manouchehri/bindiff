package com.google.security.zynamics.zylib.disassembly;

import java.util.*;

public interface ICodeContainer
{
    IAddress getAddress();
    
    Iterable getInstructions();
    
    IInstruction getLastInstruction();
    
    List getOutgoingEdges();
    
    boolean hasInstruction(final IInstruction p0);
}
