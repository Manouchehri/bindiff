package com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;

final class ExecutionList$RunnableExecutorPair {
   final Runnable runnable;
   final Executor executor;
   @Nullable
   ExecutionList$RunnableExecutorPair next;

   ExecutionList$RunnableExecutorPair(Runnable var1, Executor var2, ExecutionList$RunnableExecutorPair var3) {
      this.runnable = var1;
      this.executor = var2;
      this.next = var3;
   }
}
