package com.google.security.zynamics.zylib.gui.zygraph.nodes;

import java.util.*;

public interface IGroupNodeListener
{
    void appendedGroupNodeComment(final Object p0, final Object p1);
    
    void deletedGroupNodeComment(final Object p0, final Object p1);
    
    void editedGroupNodeComment(final Object p0, final Object p1);
    
    void initializedGroupNodeComment(final Object p0, final List p1);
}
