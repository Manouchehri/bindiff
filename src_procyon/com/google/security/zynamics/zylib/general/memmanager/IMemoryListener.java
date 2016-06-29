package com.google.security.zynamics.zylib.general.memmanager;

public interface IMemoryListener
{
    void memoryChanged(final long p0, final int p1);
    
    void memoryCleared();
}
