package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.CycleDetectingLockFactory$1;
import com.google.common.util.concurrent.CycleDetectingLockFactory$ExampleStackTrace;
import com.google.common.util.concurrent.CycleDetectingLockFactory$Policy;
import com.google.common.util.concurrent.CycleDetectingLockFactory$PotentialDeadlockException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import javax.annotation.Nullable;

class CycleDetectingLockFactory$LockGraphNode {
   final Map allowedPriorLocks = (new MapMaker()).weakKeys().makeMap();
   final Map disallowedPriorLocks = (new MapMaker()).weakKeys().makeMap();
   final String lockName;

   CycleDetectingLockFactory$LockGraphNode(String var1) {
      this.lockName = (String)Preconditions.checkNotNull(var1);
   }

   String getLockName() {
      return this.lockName;
   }

   void checkAcquiredLocks(CycleDetectingLockFactory$Policy var1, List var2) {
      int var3 = 0;

      for(int var4 = var2.size(); var3 < var4; ++var3) {
         this.checkAcquiredLock(var1, (CycleDetectingLockFactory$LockGraphNode)var2.get(var3));
      }

   }

   void checkAcquiredLock(CycleDetectingLockFactory$Policy var1, CycleDetectingLockFactory$LockGraphNode var2) {
      Preconditions.checkState(this != var2, "Attempted to acquire multiple locks with the same rank %s", new Object[]{var2.getLockName()});
      if(!this.allowedPriorLocks.containsKey(var2)) {
         CycleDetectingLockFactory$PotentialDeadlockException var3 = (CycleDetectingLockFactory$PotentialDeadlockException)this.disallowedPriorLocks.get(var2);
         if(var3 != null) {
            CycleDetectingLockFactory$PotentialDeadlockException var7 = new CycleDetectingLockFactory$PotentialDeadlockException(var2, this, var3.getConflictingStackTrace(), (CycleDetectingLockFactory$1)null);
            var1.handlePotentialDeadlock(var7);
         } else {
            Set var4 = Sets.newIdentityHashSet();
            CycleDetectingLockFactory$ExampleStackTrace var5 = var2.findPathTo(this, var4);
            if(var5 == null) {
               this.allowedPriorLocks.put(var2, new CycleDetectingLockFactory$ExampleStackTrace(var2, this));
            } else {
               CycleDetectingLockFactory$PotentialDeadlockException var6 = new CycleDetectingLockFactory$PotentialDeadlockException(var2, this, var5, (CycleDetectingLockFactory$1)null);
               this.disallowedPriorLocks.put(var2, var6);
               var1.handlePotentialDeadlock(var6);
            }

         }
      }
   }

   @Nullable
   private CycleDetectingLockFactory$ExampleStackTrace findPathTo(CycleDetectingLockFactory$LockGraphNode var1, Set var2) {
      if(!var2.add(this)) {
         return null;
      } else {
         CycleDetectingLockFactory$ExampleStackTrace var3 = (CycleDetectingLockFactory$ExampleStackTrace)this.allowedPriorLocks.get(var1);
         if(var3 != null) {
            return var3;
         } else {
            Iterator var4 = this.allowedPriorLocks.entrySet().iterator();

            Entry var5;
            CycleDetectingLockFactory$LockGraphNode var6;
            do {
               if(!var4.hasNext()) {
                  return null;
               }

               var5 = (Entry)var4.next();
               var6 = (CycleDetectingLockFactory$LockGraphNode)var5.getKey();
               var3 = var6.findPathTo(var1, var2);
            } while(var3 == null);

            CycleDetectingLockFactory$ExampleStackTrace var7 = new CycleDetectingLockFactory$ExampleStackTrace(var6, this);
            var7.setStackTrace(((CycleDetectingLockFactory$ExampleStackTrace)var5.getValue()).getStackTrace());
            var7.initCause(var3);
            return var7;
         }
      }
   }
}
