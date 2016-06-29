package com.google.common.util.concurrent;

import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.CycleDetectingLockFactory;
import com.google.common.util.concurrent.CycleDetectingLockFactory$LockGraphNode;
import com.google.common.util.concurrent.CycleDetectingLockFactory$WithExplicitOrdering;
import java.util.Arrays;
import java.util.Set;

class CycleDetectingLockFactory$ExampleStackTrace extends IllegalStateException {
   static final StackTraceElement[] EMPTY_STACK_TRACE = new StackTraceElement[0];
   static final Set EXCLUDED_CLASS_NAMES = ImmutableSet.of(CycleDetectingLockFactory.class.getName(), CycleDetectingLockFactory$ExampleStackTrace.class.getName(), CycleDetectingLockFactory$LockGraphNode.class.getName());

   CycleDetectingLockFactory$ExampleStackTrace(CycleDetectingLockFactory$LockGraphNode var1, CycleDetectingLockFactory$LockGraphNode var2) {
      String var3 = var1.getLockName();
      String var4 = var2.getLockName();
      super((new StringBuilder(4 + String.valueOf(var3).length() + String.valueOf(var4).length())).append(var3).append(" -> ").append(var4).toString());
      StackTraceElement[] var6 = this.getStackTrace();
      int var7 = 0;

      for(int var5 = var6.length; var7 < var5; ++var7) {
         if(CycleDetectingLockFactory$WithExplicitOrdering.class.getName().equals(var6[var7].getClassName())) {
            this.setStackTrace(EMPTY_STACK_TRACE);
            break;
         }

         if(!EXCLUDED_CLASS_NAMES.contains(var6[var7].getClassName())) {
            this.setStackTrace((StackTraceElement[])Arrays.copyOfRange(var6, var7, var5));
            break;
         }
      }

   }
}
