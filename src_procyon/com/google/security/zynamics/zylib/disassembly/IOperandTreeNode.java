package com.google.security.zynamics.zylib.disassembly;

import com.google.security.zynamics.zylib.ZyTree.*;
import java.util.*;

public interface IOperandTreeNode extends IZyTreeNode
{
    List getChildren();
    
    List getReferences();
    
    IReplacement getReplacement();
    
    ExpressionType getType();
    
    String getValue();
}
