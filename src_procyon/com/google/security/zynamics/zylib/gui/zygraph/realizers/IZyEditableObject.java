package com.google.security.zynamics.zylib.gui.zygraph.realizers;

public interface IZyEditableObject
{
    int getEnd();
    
    int getLength();
    
    Object getPersistentModel();
    
    int getStart();
    
    boolean isCommentDelimiter();
    
    boolean isPlaceholder();
    
    boolean update(final String p0);
    
    boolean updateComment(final String p0, final ECommentPlacement p1);
}
