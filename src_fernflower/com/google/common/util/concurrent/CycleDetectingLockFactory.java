package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.CycleDetectingLockFactory$1;
import com.google.common.util.concurrent.CycleDetectingLockFactory$CycleDetectingLock;
import com.google.common.util.concurrent.CycleDetectingLockFactory$CycleDetectingReentrantLock;
import com.google.common.util.concurrent.CycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock;
import com.google.common.util.concurrent.CycleDetectingLockFactory$LockGraphNode;
import com.google.common.util.concurrent.CycleDetectingLockFactory$Policies;
import com.google.common.util.concurrent.CycleDetectingLockFactory$Policy;
import com.google.common.util.concurrent.CycleDetectingLockFactory$WithExplicitOrdering;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Logger;
import javax.annotation.concurrent.ThreadSafe;

@Beta
@ThreadSafe
public class CycleDetectingLockFactory {
   private static final ConcurrentMap lockGraphNodesPerType = (new MapMaker()).weakKeys().makeMap();
   private static final Logger logger = Logger.getLogger(CycleDetectingLockFactory.class.getName());
   final CycleDetectingLockFactory$Policy policy;
   private static final ThreadLocal acquiredLocks = new CycleDetectingLockFactory$1();

   public static CycleDetectingLockFactory newInstance(CycleDetectingLockFactory$Policy var0) {
      return new CycleDetectingLockFactory(var0);
   }

   public ReentrantLock newReentrantLock(String var1) {
      return this.newReentrantLock(var1, false);
   }

   public ReentrantLock newReentrantLock(String var1, boolean var2) {
      return (ReentrantLock)(this.policy == CycleDetectingLockFactory$Policies.DISABLED?new ReentrantLock(var2):new CycleDetectingLockFactory$CycleDetectingReentrantLock(this, new CycleDetectingLockFactory$LockGraphNode(var1), var2, (CycleDetectingLockFactory$1)null));
   }

   public ReentrantReadWriteLock newReentrantReadWriteLock(String var1) {
      return this.newReentrantReadWriteLock(var1, false);
   }

   public ReentrantReadWriteLock newReentrantReadWriteLock(String var1, boolean var2) {
      return (ReentrantReadWriteLock)(this.policy == CycleDetectingLockFactory$Policies.DISABLED?new ReentrantReadWriteLock(var2):new CycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock(this, new CycleDetectingLockFactory$LockGraphNode(var1), var2, (CycleDetectingLockFactory$1)null));
   }

   public static CycleDetectingLockFactory$WithExplicitOrdering newInstanceWithExplicitOrdering(Class var0, CycleDetectingLockFactory$Policy var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      Map var2 = getOrCreateNodes(var0);
      return new CycleDetectingLockFactory$WithExplicitOrdering(var1, var2);
   }

   private static Map getOrCreateNodes(Class var0) {
      Map var1 = (Map)lockGraphNodesPerType.get(var0);
      if(var1 != null) {
         return var1;
      } else {
         Map var2 = createNodes(var0);
         var1 = (Map)lockGraphNodesPerType.putIfAbsent(var0, var2);
         return (Map)MoreObjects.firstNonNull(var1, var2);
      }
   }

   @VisibleForTesting
   static Map createNodes(Class var0) {
      EnumMap var1 = Maps.newEnumMap(var0);
      Enum[] var2 = (Enum[])var0.getEnumConstants();
      int var3 = var2.length;
      ArrayList var4 = Lists.newArrayListWithCapacity(var3);
      Enum[] var5 = var2;
      int var6 = var2.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         Enum var8 = var5[var7];
         CycleDetectingLockFactory$LockGraphNode var9 = new CycleDetectingLockFactory$LockGraphNode(getLockName(var8));
         var4.add(var9);
         var1.put(var8, var9);
      }

      int var10;
      for(var10 = 1; var10 < var3; ++var10) {
         ((CycleDetectingLockFactory$LockGraphNode)var4.get(var10)).checkAcquiredLocks(CycleDetectingLockFactory$Policies.THROW, var4.subList(0, var10));
      }

      for(var10 = 0; var10 < var3 - 1; ++var10) {
         ((CycleDetectingLockFactory$LockGraphNode)var4.get(var10)).checkAcquiredLocks(CycleDetectingLockFactory$Policies.DISABLED, var4.subList(var10 + 1, var3));
      }

      return Collections.unmodifiableMap(var1);
   }

   private static String getLockName(Enum var0) {
      String var1 = String.valueOf(var0.getDeclaringClass().getSimpleName());
      String var2 = String.valueOf(var0.name());
      return (new StringBuilder(1 + String.valueOf(var1).length() + String.valueOf(var2).length())).append(var1).append(".").append(var2).toString();
   }

   private CycleDetectingLockFactory(CycleDetectingLockFactory$Policy var1) {
      this.policy = (CycleDetectingLockFactory$Policy)Preconditions.checkNotNull(var1);
   }

   private void aboutToAcquire(CycleDetectingLockFactory$CycleDetectingLock var1) {
      if(!var1.isAcquiredByCurrentThread()) {
         ArrayList var2 = (ArrayList)acquiredLocks.get();
         CycleDetectingLockFactory$LockGraphNode var3 = var1.getLockGraphNode();
         var3.checkAcquiredLocks(this.policy, var2);
         var2.add(var3);
      }

   }

   private void lockStateChanged(CycleDetectingLockFactory$CycleDetectingLock var1) {
      if(!var1.isAcquiredByCurrentThread()) {
         ArrayList var2 = (ArrayList)acquiredLocks.get();
         CycleDetectingLockFactory$LockGraphNode var3 = var1.getLockGraphNode();

         for(int var4 = var2.size() - 1; var4 >= 0; --var4) {
            if(var2.get(var4) == var3) {
               var2.remove(var4);
               break;
            }
         }
      }

   }

   // $FF: synthetic method
   static Logger access$100() {
      return logger;
   }

   // $FF: synthetic method
   CycleDetectingLockFactory(CycleDetectingLockFactory$Policy var1, CycleDetectingLockFactory$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static void access$600(CycleDetectingLockFactory var0, CycleDetectingLockFactory$CycleDetectingLock var1) {
      var0.aboutToAcquire(var1);
   }

   // $FF: synthetic method
   static void access$700(CycleDetectingLockFactory var0, CycleDetectingLockFactory$CycleDetectingLock var1) {
      var0.lockStateChanged(var1);
   }
}
