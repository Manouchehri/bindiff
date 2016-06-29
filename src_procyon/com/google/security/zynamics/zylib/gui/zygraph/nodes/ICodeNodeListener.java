package com.google.security.zynamics.zylib.gui.zygraph.nodes;

import java.util.*;

public interface ICodeNodeListener
{
    void appendedGlobalCodeNodeComment(final Object p0, final Object p1);
    
    void appendedLocalCodeNodeComment(final Object p0, final Object p1);
    
    void appendedLocalInstructionComment(final Object p0, final Object p1, final Object p2);
    
    void deletedGlobalCodeNodeComment(final Object p0, final Object p1);
    
    void deletedLocalCodeNodeComment(final Object p0, final Object p1);
    
    void deletedLocalInstructionComment(final Object p0, final Object p1, final Object p2);
    
    void editedGlobalCodeNodeComment(final Object p0, final Object p1);
    
    void editedLocalCodeNodeComment(final Object p0, final Object p1);
    
    void editedLocalInstructionComment(final Object p0, final Object p1, final Object p2);
    
    void initializedGlobalCodeNodeComment(final Object p0, final List p1);
    
    void initializedLocalCodeNodeComment(final Object p0, final List p1);
    
    void initializedLocalInstructionComment(final Object p0, final Object p1, final List p2);
}
