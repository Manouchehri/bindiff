package com.google.common.util.concurrent;

import com.google.common.annotations.*;

@Beta
public abstract class Service$Listener
{
    public void starting() {
    }
    
    public void running() {
    }
    
    public void stopping(final Service$State service$State) {
    }
    
    public void terminated(final Service$State service$State) {
    }
    
    public void failed(final Service$State service$State, final Throwable t) {
    }
}
