package com.google.security.zynamics.zylib.disassembly;

import java.util.*;

public interface IViewListener
{
    void changedDescription(final Object p0, final String p1);
    
    void changedModificationDate(final Object p0, final Date p1);
    
    void changedName(final Object p0, final String p1);
    
    boolean closingView(final Object p0);
    
    void loadedView(final Object p0);
}
