package com.google.common.util.concurrent;

import javax.annotation.concurrent.*;
import javax.annotation.*;
import com.google.common.base.*;

@Immutable
final class AbstractService$StateSnapshot
{
    final Service$State state;
    final boolean shutdownWhenStartupFinishes;
    @Nullable
    final Throwable failure;
    
    AbstractService$StateSnapshot(final Service$State service$State) {
        this(service$State, false, null);
    }
    
    AbstractService$StateSnapshot(final Service$State state, final boolean shutdownWhenStartupFinishes, @Nullable final Throwable failure) {
        Preconditions.checkArgument(!shutdownWhenStartupFinishes || state == Service$State.STARTING, "shudownWhenStartupFinishes can only be set if state is STARTING. Got %s instead.", state);
        Preconditions.checkArgument(!(failure != null ^ state == Service$State.FAILED), "A failure cause should be set if and only if the state is failed.  Got %s and %s instead.", state, failure);
        this.state = state;
        this.shutdownWhenStartupFinishes = shutdownWhenStartupFinishes;
        this.failure = failure;
    }
    
    Service$State externalState() {
        if (this.shutdownWhenStartupFinishes && this.state == Service$State.STARTING) {
            return Service$State.STOPPING;
        }
        return this.state;
    }
    
    Throwable failureCause() {
        Preconditions.checkState(this.state == Service$State.FAILED, "failureCause() is only valid if the service has failed, service is %s", this.state);
        return this.failure;
    }
}
