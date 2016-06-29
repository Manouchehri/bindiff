package com.google.security.zynamics.zylib.gui.zygraph.nodes;

import com.google.security.zynamics.zylib.disassembly.IFunction;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.ILineNode;
import java.util.List;

public interface IFunctionNode extends ILineNode {
   IFunction getFunction();

   List getLocalComment();
}
