package com.google.security.zynamics.zylib.disassembly;

import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.disassembly.IInstruction;
import java.util.List;

public interface ICodeContainer {
   IAddress getAddress();

   Iterable getInstructions();

   IInstruction getLastInstruction();

   List getOutgoingEdges();

   boolean hasInstruction(IInstruction var1);
}
