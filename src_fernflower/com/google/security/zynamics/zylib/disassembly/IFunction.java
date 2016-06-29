package com.google.security.zynamics.zylib.disassembly;

import com.google.security.zynamics.zylib.disassembly.FunctionType;
import com.google.security.zynamics.zylib.disassembly.IAddress;

public interface IFunction {
   IAddress getAddress();

   int getBasicBlockCount();

   String getDescription();

   int getEdgeCount();

   int getIndegree();

   String getName();

   int getOutdegree();

   FunctionType getType();
}
