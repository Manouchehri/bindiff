package com.google.security.zynamics.zylib.gui.zygraph.nodes;

import com.google.security.zynamics.zylib.disassembly.*;

public interface ICodeNode extends ICodeContainer, ILineNode
{
    void addListener(final ICodeNodeListener p0);
    
    Iterable getInstructions();
    
    int instructionCount();
}
