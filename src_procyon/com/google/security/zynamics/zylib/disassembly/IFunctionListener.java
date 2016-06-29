package com.google.security.zynamics.zylib.disassembly;

import java.util.*;

public interface IFunctionListener
{
    void appendedComment(final IFunction p0, final Object p1);
    
    void changedDescription(final IFunction p0, final String p1);
    
    void changedName(final IFunction p0, final String p1);
    
    void changedForwardedFunction(final IFunction p0);
    
    void closed(final IFunction p0);
    
    void deletedComment(final IFunction p0, final Object p1);
    
    void editedComment(final IFunction p0, final Object p1);
    
    void initializedComment(final IFunction p0, final List p1);
    
    void loadedFunction(final IFunction p0);
}
