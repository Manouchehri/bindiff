package com.google.security.zynamics.zylib.gui.zygraph.nodes;

import com.google.security.zynamics.zylib.disassembly.*;
import java.util.*;

public interface IFunctionNode extends ILineNode
{
    IFunction getFunction();
    
    List getLocalComment();
}
