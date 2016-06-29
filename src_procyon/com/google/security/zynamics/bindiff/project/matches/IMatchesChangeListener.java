package com.google.security.zynamics.bindiff.project.matches;

import com.google.security.zynamics.zylib.disassembly.*;

public interface IMatchesChangeListener
{
    void addedBasicblockMatch(final IAddress p0, final IAddress p1, final IAddress p2, final IAddress p3);
    
    void removedBasicblockMatch(final IAddress p0, final IAddress p1, final IAddress p2, final IAddress p3);
}
