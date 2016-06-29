package com.google.security.zynamics.zylib.general.undo;

public interface IUndoable
{
    String getDescription();
    
    String getSubCommandDescription(final int p0);
    
    int getSubCommands();
    
    void revertToSnapshot();
    
    void undo();
}
