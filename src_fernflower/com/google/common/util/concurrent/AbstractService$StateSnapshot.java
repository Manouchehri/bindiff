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

   AbstractService$StateSnapshot(Service$State var1) {
      this(var1, false, (Throwable)null);
   }

   AbstractService$StateSnapshot(Service$State var1, boolean var2, @Nullable Throwable var3) {
      Preconditions.checkArgument(!var2 || var1 == Service$State.STARTING, "shudownWhenStartupFinishes can only be set if state is STARTING. Got %s instead.", new Object[]{var1});
      Preconditions.checkArgument(!(var3 != null ^ var1 == Service$State.FAILED), "A failure cause should be set if and only if the state is failed.  Got %s and %s instead.", new Object[]{var1, var3});
      this.state = var1;
      this.shutdownWhenStartupFinishes = var2;
      this.failure = var3;
   }

   Service$State externalState() {
      return this.shutdownWhenStartupFinishes && this.state == Service$State.STARTING?Service$State.STOPPING:this.state;
   }

   Throwable failureCause() {
      Preconditions.checkState(this.state == Service$State.FAILED, "failureCause() is only valid if the service has failed, service is %s", new Object[]{this.state});
      return this.failure;
   }
}
