package com.google.common.util.concurrent;

import javax.annotation.concurrent.*;
import java.util.concurrent.*;
import java.util.logging.*;
import java.util.concurrent.locks.*;
import com.google.common.base.*;
import java.util.*;
import com.google.common.annotations.*;
import com.google.common.collect.*;

class CycleDetectingLockFactory$CycleDetectingReentrantReadLock extends ReadLock
{
    final CycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock readWriteLock;
    final /* synthetic */ CycleDetectingLockFactory this$0;
    
    CycleDetectingLockFactory$CycleDetectingReentrantReadLock(final CycleDetectingLockFactory this$0, final CycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock readWriteLock) {
        this.this$0 = this$0;
        super(readWriteLock);
        this.readWriteLock = readWriteLock;
    }
    
    @Override
    public void lock() {
        this.this$0.aboutToAcquire(this.readWriteLock);
        try {
            super.lock();
        }
        finally {
            this.this$0.lockStateChanged(this.readWriteLock);
        }
    }
    
    @Override
    public void lockInterruptibly() {
        this.this$0.aboutToAcquire(this.readWriteLock);
        try {
            super.lockInterruptibly();
        }
        finally {
            this.this$0.lockStateChanged(this.readWriteLock);
        }
    }
    
    @Override
    public boolean tryLock() {
        this.this$0.aboutToAcquire(this.readWriteLock);
        try {
            return super.tryLock();
        }
        finally {
            this.this$0.lockStateChanged(this.readWriteLock);
        }
    }
    
    @Override
    public boolean tryLock(final long n, final TimeUnit timeUnit) {
        this.this$0.aboutToAcquire(this.readWriteLock);
        try {
            return super.tryLock(n, timeUnit);
        }
        finally {
            this.this$0.lockStateChanged(this.readWriteLock);
        }
    }
    
    @Override
    public void unlock() {
        try {
            super.unlock();
        }
        finally {
            this.this$0.lockStateChanged(this.readWriteLock);
        }
    }
}
