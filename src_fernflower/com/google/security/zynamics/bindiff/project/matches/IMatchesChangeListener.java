package com.google.security.zynamics.bindiff.project.matches;

import com.google.security.zynamics.zylib.disassembly.IAddress;

public interface IMatchesChangeListener {
   void addedBasicblockMatch(IAddress var1, IAddress var2, IAddress var3, IAddress var4);

   void removedBasicblockMatch(IAddress var1, IAddress var2, IAddress var3, IAddress var4);
}
