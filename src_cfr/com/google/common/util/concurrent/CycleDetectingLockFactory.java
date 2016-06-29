/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.concurrent.ThreadSafe
 */
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
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Logger;
import javax.annotation.concurrent.ThreadSafe;

@Beta
@ThreadSafe
public class CycleDetectingLockFactory {
    private static final ConcurrentMap lockGraphNodesPerType = new MapMaker().weakKeys().makeMap();
    private static final Logger logger = Logger.getLogger(CycleDetectingLockFactory.class.getName());
    final CycleDetectingLockFactory$Policy policy;
    private static final ThreadLocal acquiredLocks = new CycleDetectingLockFactory$1();

    public static CycleDetectingLockFactory newInstance(CycleDetectingLockFactory$Policy cycleDetectingLockFactory$Policy) {
        return new CycleDetectingLockFactory(cycleDetectingLockFactory$Policy);
    }

    public ReentrantLock newReentrantLock(String string) {
        return this.newReentrantLock(string, false);
    }

    public ReentrantLock newReentrantLock(String string, boolean bl2) {
        ReentrantLock reentrantLock;
        if (this.policy == CycleDetectingLockFactory$Policies.DISABLED) {
            reentrantLock = new ReentrantLock(bl2);
            return reentrantLock;
        }
        reentrantLock = new CycleDetectingLockFactory$CycleDetectingReentrantLock(this, new CycleDetectingLockFactory$LockGraphNode(string), bl2, null);
        return reentrantLock;
    }

    public ReentrantReadWriteLock newReentrantReadWriteLock(String string) {
        return this.newReentrantReadWriteLock(string, false);
    }

    public ReentrantReadWriteLock newReentrantReadWriteLock(String string, boolean bl2) {
        ReentrantReadWriteLock reentrantReadWriteLock;
        if (this.policy == CycleDetectingLockFactory$Policies.DISABLED) {
            reentrantReadWriteLock = new ReentrantReadWriteLock(bl2);
            return reentrantReadWriteLock;
        }
        reentrantReadWriteLock = new CycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock(this, new CycleDetectingLockFactory$LockGraphNode(string), bl2, null);
        return reentrantReadWriteLock;
    }

    public static CycleDetectingLockFactory$WithExplicitOrdering newInstanceWithExplicitOrdering(Class class_, CycleDetectingLockFactory$Policy cycleDetectingLockFactory$Policy) {
        Preconditions.checkNotNull(class_);
        Preconditions.checkNotNull(cycleDetectingLockFactory$Policy);
        Map map = CycleDetectingLockFactory.getOrCreateNodes(class_);
        return new CycleDetectingLockFactory$WithExplicitOrdering(cycleDetectingLockFactory$Policy, map);
    }

    private static Map getOrCreateNodes(Class class_) {
        Map map = (Map)lockGraphNodesPerType.get(class_);
        if (map != null) {
            return map;
        }
        Map map2 = CycleDetectingLockFactory.createNodes(class_);
        map = lockGraphNodesPerType.putIfAbsent(class_, map2);
        return (Map)MoreObjects.firstNonNull(map, map2);
    }

    @VisibleForTesting
    static Map createNodes(Class class_) {
        int n2;
        EnumMap enumMap = Maps.newEnumMap(class_);
        Enum[] arrenum = (Enum[])class_.getEnumConstants();
        int n3 = arrenum.length;
        ArrayList arrayList = Lists.newArrayListWithCapacity(n3);
        for (Enum enum_ : arrenum) {
            CycleDetectingLockFactory$LockGraphNode cycleDetectingLockFactory$LockGraphNode = new CycleDetectingLockFactory$LockGraphNode(CycleDetectingLockFactory.getLockName(enum_));
            arrayList.add(cycleDetectingLockFactory$LockGraphNode);
            enumMap.put(enum_, cycleDetectingLockFactory$LockGraphNode);
        }
        for (n2 = 1; n2 < n3; ++n2) {
            ((CycleDetectingLockFactory$LockGraphNode)arrayList.get(n2)).checkAcquiredLocks(CycleDetectingLockFactory$Policies.THROW, arrayList.subList(0, n2));
        }
        n2 = 0;
        while (n2 < n3 - 1) {
            ((CycleDetectingLockFactory$LockGraphNode)arrayList.get(n2)).checkAcquiredLocks(CycleDetectingLockFactory$Policies.DISABLED, arrayList.subList(n2 + 1, n3));
            ++n2;
        }
        return Collections.unmodifiableMap(enumMap);
    }

    private static String getLockName(Enum enum_) {
        String string = String.valueOf(enum_.getDeclaringClass().getSimpleName());
        String string2 = String.valueOf(enum_.name());
        return new StringBuilder(1 + String.valueOf(string).length() + String.valueOf(string2).length()).append(string).append(".").append(string2).toString();
    }

    private CycleDetectingLockFactory(CycleDetectingLockFactory$Policy cycleDetectingLockFactory$Policy) {
        this.policy = (CycleDetectingLockFactory$Policy)Preconditions.checkNotNull(cycleDetectingLockFactory$Policy);
    }

    private void aboutToAcquire(CycleDetectingLockFactory$CycleDetectingLock cycleDetectingLockFactory$CycleDetectingLock) {
        if (cycleDetectingLockFactory$CycleDetectingLock.isAcquiredByCurrentThread()) return;
        ArrayList arrayList = (ArrayList)acquiredLocks.get();
        CycleDetectingLockFactory$LockGraphNode cycleDetectingLockFactory$LockGraphNode = cycleDetectingLockFactory$CycleDetectingLock.getLockGraphNode();
        cycleDetectingLockFactory$LockGraphNode.checkAcquiredLocks(this.policy, arrayList);
        arrayList.add(cycleDetectingLockFactory$LockGraphNode);
    }

    private void lockStateChanged(CycleDetectingLockFactory$CycleDetectingLock cycleDetectingLockFactory$CycleDetectingLock) {
        if (cycleDetectingLockFactory$CycleDetectingLock.isAcquiredByCurrentThread()) return;
        ArrayList arrayList = (ArrayList)acquiredLocks.get();
        CycleDetectingLockFactory$LockGraphNode cycleDetectingLockFactory$LockGraphNode = cycleDetectingLockFactory$CycleDetectingLock.getLockGraphNode();
        int n2 = arrayList.size() - 1;
        while (n2 >= 0) {
            if (arrayList.get(n2) == cycleDetectingLockFactory$LockGraphNode) {
                arrayList.remove(n2);
                return;
            }
            --n2;
        }
    }

    static /* synthetic */ Logger access$100() {
        return logger;
    }

    /* synthetic */ CycleDetectingLockFactory(CycleDetectingLockFactory$Policy cycleDetectingLockFactory$Policy, CycleDetectingLockFactory$1 cycleDetectingLockFactory$1) {
        this(cycleDetectingLockFactory$Policy);
    }

    static /* synthetic */ void access$600(CycleDetectingLockFactory cycleDetectingLockFactory, CycleDetectingLockFactory$CycleDetectingLock cycleDetectingLockFactory$CycleDetectingLock) {
        cycleDetectingLockFactory.aboutToAcquire(cycleDetectingLockFactory$CycleDetectingLock);
    }

    static /* synthetic */ void access$700(CycleDetectingLockFactory cycleDetectingLockFactory, CycleDetectingLockFactory$CycleDetectingLock cycleDetectingLockFactory$CycleDetectingLock) {
        cycleDetectingLockFactory.lockStateChanged(cycleDetectingLockFactory$CycleDetectingLock);
    }
}

