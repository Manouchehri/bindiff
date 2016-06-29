package com.google.security.zynamics.zylib.disassembly;

import com.google.security.zynamics.zylib.gui.zygraph.edges.*;

public interface ICodeEdge
{
    Object getSource();
    
    Object getTarget();
    
    EdgeType getType();
}
