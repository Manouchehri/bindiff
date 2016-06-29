package com.google.security.zynamics.zylib.disassembly;

import com.google.security.zynamics.zylib.ZyTree.IZyTreeNode;
import com.google.security.zynamics.zylib.disassembly.ExpressionType;
import com.google.security.zynamics.zylib.disassembly.IReplacement;
import java.util.List;

public interface IOperandTreeNode extends IZyTreeNode {
   List getChildren();

   List getReferences();

   IReplacement getReplacement();

   ExpressionType getType();

   String getValue();
}
