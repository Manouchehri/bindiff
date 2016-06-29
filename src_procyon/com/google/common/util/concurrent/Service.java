package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import java.util.concurrent.*;

@Beta
public interface Service
{
    Service startAsync();
    
    boolean isRunning();
    
    Service$State state();
    
    Service stopAsync();
    
    void awaitRunning();
    
    void awaitRunning(final long p0, final TimeUnit p1);
    
    void awaitTerminated();
    
    void awaitTerminated(final long p0, final TimeUnit p1);
    
    Throwable failureCause();
    
    void addListener(final Service$Listener p0, final Executor p1);
}
