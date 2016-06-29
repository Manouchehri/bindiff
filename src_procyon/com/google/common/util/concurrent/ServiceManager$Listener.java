package com.google.common.util.concurrent;

import com.google.common.annotations.*;

@Beta
public abstract class ServiceManager$Listener
{
    public void healthy() {
    }
    
    public void stopped() {
    }
    
    public void failure(final Service service) {
    }
}
