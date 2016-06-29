/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  javax.annotation.concurrent.Immutable
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Service$State;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
final class AbstractService$StateSnapshot {
    final Service$State state;
    final boolean shutdownWhenStartupFinishes;
    @Nullable
    final Throwable failure;

    AbstractService$StateSnapshot(Service$State service$State) {
        this(service$State, false, null);
    }

    AbstractService$StateSnapshot(Service$State service$State, boolean bl2, @Nullable Throwable throwable) {
        Preconditions.checkArgument(!bl2 || service$State == Service$State.STARTING, "shudownWhenStartupFinishes can only be set if state is STARTING. Got %s instead.", new Object[]{service$State});
        Preconditions.checkArgument(!(throwable != null ^ service$State == Service$State.FAILED), "A failure cause should be set if and only if the state is failed.  Got %s and %s instead.", new Object[]{service$State, throwable});
        this.state = service$State;
        this.shutdownWhenStartupFinishes = bl2;
        this.failure = throwable;
    }

    Service$State externalState() {
        if (!this.shutdownWhenStartupFinishes) return this.state;
        if (this.state != Service$State.STARTING) return this.state;
        return Service$State.STOPPING;
    }

    Throwable failureCause() {
        Preconditions.checkState(this.state == Service$State.FAILED, "failureCause() is only valid if the service has failed, service is %s", new Object[]{this.state});
        return this.failure;
    }
}

