package com.google.security.zynamics.zylib.gui.zygraph.nodes;

import java.util.*;

public interface IFunctionNodeListener extends IViewNodeListener
{
    void appendedFunctionNodeComment(final Object p0, final Object p1);
    
    void deletedFunctionNodeComment(final Object p0, final Object p1);
    
    void editedFunctionNodeComment(final Object p0, final Object p1);
    
    void initializedFunctionNodeComment(final Object p0, final List p1);
}
