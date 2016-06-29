package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import java.util.concurrent.locks.*;
import javax.annotation.concurrent.*;
import java.util.concurrent.*;
import com.google.common.base.*;

@Beta
public final class Monitor
{
    private final boolean fair;
    private final ReentrantLock lock;
    @GuardedBy("lock")
    private Monitor$Guard activeGuards;
    
    public Monitor() {
        this(false);
    }
    
    public Monitor(final boolean fair) {
        this.activeGuards = null;
        this.fair = fair;
        this.lock = new ReentrantLock(fair);
    }
    
    public void enter() {
        this.lock.lock();
    }
    
    public void enterInterruptibly() {
        this.lock.lockInterruptibly();
    }
    
    public boolean enter(final long n, final TimeUnit timeUnit) {
        final long safeNanos = toSafeNanos(n, timeUnit);
        final ReentrantLock lock = this.lock;
        if (!this.fair && lock.tryLock()) {
            return true;
        }
        boolean interrupted = Thread.interrupted();
        try {
            final long nanoTime = System.nanoTime();
            long remainingNanos = safeNanos;
            try {
                return lock.tryLock(remainingNanos, TimeUnit.NANOSECONDS);
            }
            catch (InterruptedException ex) {
                interrupted = true;
                remainingNanos = remainingNanos(nanoTime, safeNanos);
            }
        }
        finally {
            if (interrupted) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    public boolean enterInterruptibly(final long n, final TimeUnit timeUnit) {
        return this.lock.tryLock(n, timeUnit);
    }
    
    public boolean tryEnter() {
        return this.lock.tryLock();
    }
    
    public void enterWhen(final Monitor$Guard monitor$Guard) {
        if (monitor$Guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        final ReentrantLock lock = this.lock;
        final boolean heldByCurrentThread = lock.isHeldByCurrentThread();
        lock.lockInterruptibly();
        boolean b = false;
        try {
            if (!monitor$Guard.isSatisfied()) {
                this.await(monitor$Guard, heldByCurrentThread);
            }
            b = true;
        }
        finally {
            if (!b) {
                this.leave();
            }
        }
    }
    
    public void enterWhenUninterruptibly(final Monitor$Guard monitor$Guard) {
        if (monitor$Guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        final ReentrantLock lock = this.lock;
        final boolean heldByCurrentThread = lock.isHeldByCurrentThread();
        lock.lock();
        boolean b = false;
        try {
            if (!monitor$Guard.isSatisfied()) {
                this.awaitUninterruptibly(monitor$Guard, heldByCurrentThread);
            }
            b = true;
        }
        finally {
            if (!b) {
                this.leave();
            }
        }
    }
    
    public boolean enterWhen(final Monitor$Guard monitor$Guard, final long n, final TimeUnit timeUnit) {
        final long safeNanos = toSafeNanos(n, timeUnit);
        if (monitor$Guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        final ReentrantLock lock = this.lock;
        final boolean heldByCurrentThread = lock.isHeldByCurrentThread();
        long initNanoTime = 0L;
        Label_0092: {
            if (!this.fair) {
                if (Thread.interrupted()) {
                    throw new InterruptedException();
                }
                if (lock.tryLock()) {
                    break Label_0092;
                }
            }
            initNanoTime = initNanoTime(safeNanos);
            if (!lock.tryLock(n, timeUnit)) {
                return false;
            }
        }
        boolean b = false;
        boolean b2 = true;
        try {
            b = (monitor$Guard.isSatisfied() || this.awaitNanos(monitor$Guard, (initNanoTime == 0L) ? safeNanos : remainingNanos(initNanoTime, safeNanos), heldByCurrentThread));
            b2 = false;
            return b;
        }
        finally {
            if (!b) {
                try {
                    if (b2 && !heldByCurrentThread) {
                        this.signalNextWaiter();
                    }
                }
                finally {
                    lock.unlock();
                }
            }
        }
    }
    
    public boolean enterWhenUninterruptibly(final Monitor$Guard monitor$Guard, final long n, final TimeUnit timeUnit) {
        final long safeNanos = toSafeNanos(n, timeUnit);
        if (monitor$Guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        final ReentrantLock lock = this.lock;
        long n2 = 0L;
        boolean heldByCurrentThread = lock.isHeldByCurrentThread();
        boolean interrupted = Thread.interrupted();
        try {
            if (this.fair || !lock.tryLock()) {
                n2 = initNanoTime(safeNanos);
                long remainingNanos = safeNanos;
                while (true) {
                    try {
                        if (!lock.tryLock(remainingNanos, TimeUnit.NANOSECONDS)) {
                            return false;
                        }
                    }
                    catch (InterruptedException ex) {
                        interrupted = true;
                        remainingNanos = remainingNanos(n2, safeNanos);
                        continue;
                    }
                    break;
                }
            }
            boolean awaitNanos = false;
            try {
                if (monitor$Guard.isSatisfied()) {
                    awaitNanos = true;
                }
                else {
                    long remainingNanos2;
                    if (n2 == 0L) {
                        n2 = initNanoTime(safeNanos);
                        remainingNanos2 = safeNanos;
                    }
                    else {
                        remainingNanos2 = remainingNanos(n2, safeNanos);
                    }
                    awaitNanos = this.awaitNanos(monitor$Guard, remainingNanos2, heldByCurrentThread);
                }
                return awaitNanos;
            }
            catch (InterruptedException ex2) {
                interrupted = true;
                heldByCurrentThread = false;
            }
            finally {
                if (!awaitNanos) {
                    lock.unlock();
                }
            }
        }
        finally {
            if (interrupted) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    public boolean enterIf(final Monitor$Guard monitor$Guard) {
        if (monitor$Guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        final ReentrantLock lock = this.lock;
        lock.lock();
        boolean satisfied = false;
        try {
            return satisfied = monitor$Guard.isSatisfied();
        }
        finally {
            if (!satisfied) {
                lock.unlock();
            }
        }
    }
    
    public boolean enterIfInterruptibly(final Monitor$Guard monitor$Guard) {
        if (monitor$Guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        boolean satisfied = false;
        try {
            return satisfied = monitor$Guard.isSatisfied();
        }
        finally {
            if (!satisfied) {
                lock.unlock();
            }
        }
    }
    
    public boolean enterIf(final Monitor$Guard monitor$Guard, final long n, final TimeUnit timeUnit) {
        if (monitor$Guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        if (!this.enter(n, timeUnit)) {
            return false;
        }
        boolean satisfied = false;
        try {
            return satisfied = monitor$Guard.isSatisfied();
        }
        finally {
            if (!satisfied) {
                this.lock.unlock();
            }
        }
    }
    
    public boolean enterIfInterruptibly(final Monitor$Guard monitor$Guard, final long n, final TimeUnit timeUnit) {
        if (monitor$Guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        final ReentrantLock lock = this.lock;
        if (!lock.tryLock(n, timeUnit)) {
            return false;
        }
        boolean satisfied = false;
        try {
            return satisfied = monitor$Guard.isSatisfied();
        }
        finally {
            if (!satisfied) {
                lock.unlock();
            }
        }
    }
    
    public boolean tryEnterIf(final Monitor$Guard monitor$Guard) {
        if (monitor$Guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        final ReentrantLock lock = this.lock;
        if (!lock.tryLock()) {
            return false;
        }
        boolean satisfied = false;
        try {
            return satisfied = monitor$Guard.isSatisfied();
        }
        finally {
            if (!satisfied) {
                lock.unlock();
            }
        }
    }
    
    public void waitFor(final Monitor$Guard monitor$Guard) {
        if (!(monitor$Guard.monitor == this & this.lock.isHeldByCurrentThread())) {
            throw new IllegalMonitorStateException();
        }
        if (!monitor$Guard.isSatisfied()) {
            this.await(monitor$Guard, true);
        }
    }
    
    public void waitForUninterruptibly(final Monitor$Guard monitor$Guard) {
        if (!(monitor$Guard.monitor == this & this.lock.isHeldByCurrentThread())) {
            throw new IllegalMonitorStateException();
        }
        if (!monitor$Guard.isSatisfied()) {
            this.awaitUninterruptibly(monitor$Guard, true);
        }
    }
    
    public boolean waitFor(final Monitor$Guard monitor$Guard, final long n, final TimeUnit timeUnit) {
        final long safeNanos = toSafeNanos(n, timeUnit);
        if (!(monitor$Guard.monitor == this & this.lock.isHeldByCurrentThread())) {
            throw new IllegalMonitorStateException();
        }
        if (monitor$Guard.isSatisfied()) {
            return true;
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        return this.awaitNanos(monitor$Guard, safeNanos, true);
    }
    
    public boolean waitForUninterruptibly(final Monitor$Guard monitor$Guard, final long n, final TimeUnit timeUnit) {
        final long safeNanos = toSafeNanos(n, timeUnit);
        if (!(monitor$Guard.monitor == this & this.lock.isHeldByCurrentThread())) {
            throw new IllegalMonitorStateException();
        }
        if (monitor$Guard.isSatisfied()) {
            return true;
        }
        boolean b = true;
        final long initNanoTime = initNanoTime(safeNanos);
        boolean interrupted = Thread.interrupted();
        try {
            long remainingNanos = safeNanos;
            try {
                return this.awaitNanos(monitor$Guard, remainingNanos, b);
            }
            catch (InterruptedException ex) {
                interrupted = true;
                if (monitor$Guard.isSatisfied()) {
                    return true;
                }
                b = false;
                remainingNanos = remainingNanos(initNanoTime, safeNanos);
                return this.awaitNanos(monitor$Guard, remainingNanos, b);
            }
        }
        finally {
            if (interrupted) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    public void leave() {
        final ReentrantLock lock = this.lock;
        try {
            if (lock.getHoldCount() == 1) {
                this.signalNextWaiter();
            }
        }
        finally {
            lock.unlock();
        }
    }
    
    public boolean isFair() {
        return this.fair;
    }
    
    public boolean isOccupied() {
        return this.lock.isLocked();
    }
    
    public boolean isOccupiedByCurrentThread() {
        return this.lock.isHeldByCurrentThread();
    }
    
    public int getOccupiedDepth() {
        return this.lock.getHoldCount();
    }
    
    public int getQueueLength() {
        return this.lock.getQueueLength();
    }
    
    public boolean hasQueuedThreads() {
        return this.lock.hasQueuedThreads();
    }
    
    public boolean hasQueuedThread(final Thread thread) {
        return this.lock.hasQueuedThread(thread);
    }
    
    public boolean hasWaiters(final Monitor$Guard monitor$Guard) {
        return this.getWaitQueueLength(monitor$Guard) > 0;
    }
    
    public int getWaitQueueLength(final Monitor$Guard monitor$Guard) {
        if (monitor$Guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        this.lock.lock();
        try {
            return monitor$Guard.waiterCount;
        }
        finally {
            this.lock.unlock();
        }
    }
    
    private static long toSafeNanos(final long n, final TimeUnit timeUnit) {
        final long nanos = timeUnit.toNanos(n);
        return (nanos <= 0L) ? 0L : ((nanos > 6917529027641081853L) ? 6917529027641081853L : nanos);
    }
    
    private static long initNanoTime(final long n) {
        if (n <= 0L) {
            return 0L;
        }
        final long nanoTime = System.nanoTime();
        return (nanoTime == 0L) ? 1L : nanoTime;
    }
    
    private static long remainingNanos(final long n, final long n2) {
        return (n2 <= 0L) ? 0L : (n2 - (System.nanoTime() - n));
    }
    
    @GuardedBy("lock")
    private void signalNextWaiter() {
        for (Monitor$Guard monitor$Guard = this.activeGuards; monitor$Guard != null; monitor$Guard = monitor$Guard.next) {
            if (this.isSatisfied(monitor$Guard)) {
                monitor$Guard.condition.signal();
                break;
            }
        }
    }
    
    @GuardedBy("lock")
    private boolean isSatisfied(final Monitor$Guard monitor$Guard) {
        try {
            return monitor$Guard.isSatisfied();
        }
        catch (Throwable t) {
            this.signalAllWaiters();
            throw Throwables.propagate(t);
        }
    }
    
    @GuardedBy("lock")
    private void signalAllWaiters() {
        for (Monitor$Guard monitor$Guard = this.activeGuards; monitor$Guard != null; monitor$Guard = monitor$Guard.next) {
            monitor$Guard.condition.signalAll();
        }
    }
    
    @GuardedBy("lock")
    private void beginWaitingFor(final Monitor$Guard activeGuards) {
        if (activeGuards.waiterCount++ == 0) {
            activeGuards.next = this.activeGuards;
            this.activeGuards = activeGuards;
        }
    }
    
    @GuardedBy("lock")
    private void endWaitingFor(final Monitor$Guard monitor$Guard) {
        final int waiterCount = monitor$Guard.waiterCount - 1;
        monitor$Guard.waiterCount = waiterCount;
        if (waiterCount == 0) {
            Monitor$Guard monitor$Guard2 = this.activeGuards;
            Monitor$Guard monitor$Guard3 = null;
            while (monitor$Guard2 != monitor$Guard) {
                monitor$Guard3 = monitor$Guard2;
                monitor$Guard2 = monitor$Guard2.next;
            }
            if (monitor$Guard3 == null) {
                this.activeGuards = monitor$Guard2.next;
            }
            else {
                monitor$Guard3.next = monitor$Guard2.next;
            }
            monitor$Guard2.next = null;
        }
    }
    
    @GuardedBy("lock")
    private void await(final Monitor$Guard monitor$Guard, final boolean b) {
        if (b) {
            this.signalNextWaiter();
        }
        this.beginWaitingFor(monitor$Guard);
        try {
            do {
                monitor$Guard.condition.await();
            } while (!monitor$Guard.isSatisfied());
        }
        finally {
            this.endWaitingFor(monitor$Guard);
        }
    }
    
    @GuardedBy("lock")
    private void awaitUninterruptibly(final Monitor$Guard monitor$Guard, final boolean b) {
        if (b) {
            this.signalNextWaiter();
        }
        this.beginWaitingFor(monitor$Guard);
        try {
            do {
                monitor$Guard.condition.awaitUninterruptibly();
            } while (!monitor$Guard.isSatisfied());
        }
        finally {
            this.endWaitingFor(monitor$Guard);
        }
    }
    
    @GuardedBy("lock")
    private boolean awaitNanos(final Monitor$Guard monitor$Guard, long awaitNanos, final boolean b) {
        int n = 1;
        try {
            while (awaitNanos > 0L) {
                if (n != 0) {
                    if (b) {
                        this.signalNextWaiter();
                    }
                    this.beginWaitingFor(monitor$Guard);
                    n = 0;
                }
                awaitNanos = monitor$Guard.condition.awaitNanos(awaitNanos);
                if (monitor$Guard.isSatisfied()) {
                    return true;
                }
            }
            return false;
        }
        finally {
            if (n == 0) {
                this.endWaitingFor(monitor$Guard);
            }
        }
    }
}
