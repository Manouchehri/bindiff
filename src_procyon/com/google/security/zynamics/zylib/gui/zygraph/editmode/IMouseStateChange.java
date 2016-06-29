package com.google.security.zynamics.zylib.gui.zygraph.editmode;

public interface IMouseStateChange
{
    IMouseState getNextState();
    
    boolean notifyYFiles();
}
