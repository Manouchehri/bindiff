package com.google.security.zynamics.zylib.general.memmanager;

public interface IMemoryListener {
   void memoryChanged(long var1, int var3);

   void memoryCleared();
}
