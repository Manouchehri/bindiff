package com.google.common.util.concurrent;

import javax.annotation.concurrent.*;
import java.util.concurrent.*;
import java.util.logging.*;
import java.util.concurrent.locks.*;
import com.google.common.base.*;
import java.util.*;
import com.google.common.annotations.*;
import com.google.common.collect.*;

@Beta
@ThreadSafe
public class CycleDetectingLockFactory
{
    private static final ConcurrentMap lockGraphNodesPerType;
    private static final Logger logger;
    final CycleDetectingLockFactory$Policy policy;
    private static final ThreadLocal acquiredLocks;
    
    public static CycleDetectingLockFactory newInstance(final CycleDetectingLockFactory$Policy cycleDetectingLockFactory$Policy) {
        return new CycleDetectingLockFactory(cycleDetectingLockFactory$Policy);
    }
    
    public ReentrantLock newReentrantLock(final String s) {
        return this.newReentrantLock(s, false);
    }
    
    public ReentrantLock newReentrantLock(final String s, final boolean b) {
        return (this.policy == CycleDetectingLockFactory$Policies.DISABLED) ? new ReentrantLock(b) : new CycleDetectingLockFactory$CycleDetectingReentrantLock(this, new CycleDetectingLockFactory$LockGraphNode(s), b, null);
    }
    
    public ReentrantReadWriteLock newReentrantReadWriteLock(final String s) {
        return this.newReentrantReadWriteLock(s, false);
    }
    
    public ReentrantReadWriteLock newReentrantReadWriteLock(final String s, final boolean b) {
        return (this.policy == CycleDetectingLockFactory$Policies.DISABLED) ? new ReentrantReadWriteLock(b) : new CycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock(this, new CycleDetectingLockFactory$LockGraphNode(s), b, null);
    }
    
    public static CycleDetectingLockFactory$WithExplicitOrdering newInstanceWithExplicitOrdering(final Class clazz, final CycleDetectingLockFactory$Policy cycleDetectingLockFactory$Policy) {
        Preconditions.checkNotNull(clazz);
        Preconditions.checkNotNull(cycleDetectingLockFactory$Policy);
        return new CycleDetectingLockFactory$WithExplicitOrdering(cycleDetectingLockFactory$Policy, getOrCreateNodes(clazz));
    }
    
    private static Map getOrCreateNodes(final Class clazz) {
        final Map map = (Map)CycleDetectingLockFactory.lockGraphNodesPerType.get(clazz);
        if (map != null) {
            return map;
        }
        final Map nodes = createNodes(clazz);
        return (Map)MoreObjects.firstNonNull(CycleDetectingLockFactory.lockGraphNodesPerType.putIfAbsent(clazz, nodes), nodes);
    }
    
    @VisibleForTesting
    static Map createNodes(final Class clazz) {
        final EnumMap enumMap = Maps.newEnumMap(clazz);
        final Enum[] array = clazz.getEnumConstants();
        final int length = array.length;
        final ArrayList arrayListWithCapacity = Lists.newArrayListWithCapacity(length);
        for (final Enum enum1 : array) {
            final CycleDetectingLockFactory$LockGraphNode cycleDetectingLockFactory$LockGraphNode = new CycleDetectingLockFactory$LockGraphNode(getLockName(enum1));
            arrayListWithCapacity.add(cycleDetectingLockFactory$LockGraphNode);
            enumMap.put(enum1, cycleDetectingLockFactory$LockGraphNode);
        }
        for (int j = 1; j < length; ++j) {
            arrayListWithCapacity.get(j).checkAcquiredLocks(CycleDetectingLockFactory$Policies.THROW, arrayListWithCapacity.subList(0, j));
        }
        for (int k = 0; k < length - 1; ++k) {
            arrayListWithCapacity.get(k).checkAcquiredLocks(CycleDetectingLockFactory$Policies.DISABLED, arrayListWithCapacity.subList(k + 1, length));
        }
        return Collections.unmodifiableMap((Map<?, ?>)enumMap);
    }
    
    private static String getLockName(final Enum enum1) {
        final String value = String.valueOf(enum1.getDeclaringClass().getSimpleName());
        final String value2 = String.valueOf(enum1.name());
        return new StringBuilder(1 + String.valueOf(value).length() + String.valueOf(value2).length()).append(value).append(".").append(value2).toString();
    }
    
    private CycleDetectingLockFactory(final CycleDetectingLockFactory$Policy cycleDetectingLockFactory$Policy) {
        this.policy = (CycleDetectingLockFactory$Policy)Preconditions.checkNotNull(cycleDetectingLockFactory$Policy);
    }
    
    private void aboutToAcquire(final CycleDetectingLockFactory$CycleDetectingLock cycleDetectingLockFactory$CycleDetectingLock) {
        if (!cycleDetectingLockFactory$CycleDetectingLock.isAcquiredByCurrentThread()) {
            final ArrayList<CycleDetectingLockFactory$LockGraphNode> list = CycleDetectingLockFactory.acquiredLocks.get();
            final CycleDetectingLockFactory$LockGraphNode lockGraphNode = cycleDetectingLockFactory$CycleDetectingLock.getLockGraphNode();
            lockGraphNode.checkAcquiredLocks(this.policy, list);
            list.add(lockGraphNode);
        }
    }
    
    private void lockStateChanged(final CycleDetectingLockFactory$CycleDetectingLock cycleDetectingLockFactory$CycleDetectingLock) {
        if (!cycleDetectingLockFactory$CycleDetectingLock.isAcquiredByCurrentThread()) {
            final ArrayList list = CycleDetectingLockFactory.acquiredLocks.get();
            final CycleDetectingLockFactory$LockGraphNode lockGraphNode = cycleDetectingLockFactory$CycleDetectingLock.getLockGraphNode();
            for (int i = list.size() - 1; i >= 0; --i) {
                if (list.get(i) == lockGraphNode) {
                    list.remove(i);
                    break;
                }
            }
        }
    }
    
    static {
        lockGraphNodesPerType = new MapMaker().weakKeys().makeMap();
        logger = Logger.getLogger(CycleDetectingLockFactory.class.getName());
        acquiredLocks = new CycleDetectingLockFactory$1();
    }
}
