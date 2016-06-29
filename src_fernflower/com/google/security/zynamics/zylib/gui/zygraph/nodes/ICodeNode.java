package com.google.security.zynamics.zylib.gui.zygraph.nodes;

import com.google.security.zynamics.zylib.disassembly.ICodeContainer;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.ICodeNodeListener;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.ILineNode;

public interface ICodeNode extends ICodeContainer, ILineNode {
   void addListener(ICodeNodeListener var1);

   Iterable getInstructions();

   int instructionCount();
}
