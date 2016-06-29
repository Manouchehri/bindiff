/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.concurrent.GuardedBy
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Throwables;
import com.google.common.util.concurrent.Monitor$Guard;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.concurrent.GuardedBy;

@Beta
public final class Monitor {
    private final boolean fair;
    private final ReentrantLock lock;
    @GuardedBy(value="lock")
    private Monitor$Guard activeGuards = null;

    public Monitor() {
        this(false);
    }

    public Monitor(boolean bl2) {
        this.fair = bl2;
        this.lock = new ReentrantLock(bl2);
    }

    public void enter() {
        this.lock.lock();
    }

    public void enterInterruptibly() {
        this.lock.lockInterruptibly();
    }

    /*
     * Exception decompiling
     */
    public boolean enter(long var1_1, TimeUnit var3_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 3[CATCHBLOCK]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2869)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:817)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:129)
        // org.benf.cfr.reader.Main.main(Main.java:181)
        // the.bytecode.club.bytecodeviewer.decompilers.CFRDecompiler.decompileToZip(CFRDecompiler.java:245)
        // the.bytecode.club.bytecodeviewer.gui.MainViewerGUI$18$1$3.run(MainViewerGUI.java:1107)
        throw new IllegalStateException("Decompilation failed");
    }

    public boolean enterInterruptibly(long l2, TimeUnit timeUnit) {
        return this.lock.tryLock(l2, timeUnit);
    }

    public boolean tryEnter() {
        return this.lock.tryLock();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void enterWhen(Monitor$Guard monitor$Guard) {
        if (monitor$Guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.lock;
        boolean bl2 = reentrantLock.isHeldByCurrentThread();
        reentrantLock.lockInterruptibly();
        boolean bl3 = false;
        try {
            if (!monitor$Guard.isSatisfied()) {
                this.await(monitor$Guard, bl2);
            }
            bl3 = true;
            return;
        }
        finally {
            if (!bl3) {
                this.leave();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void enterWhenUninterruptibly(Monitor$Guard monitor$Guard) {
        if (monitor$Guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.lock;
        boolean bl2 = reentrantLock.isHeldByCurrentThread();
        reentrantLock.lock();
        boolean bl3 = false;
        try {
            if (!monitor$Guard.isSatisfied()) {
                this.awaitUninterruptibly(monitor$Guard, bl2);
            }
            bl3 = true;
            return;
        }
        finally {
            if (!bl3) {
                this.leave();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    public boolean enterWhen(Monitor$Guard var1_1, long var2_2, TimeUnit var4_3) {
        var5_4 = Monitor.toSafeNanos(var2_2, var4_3);
        if (var1_1.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        var7_5 = this.lock;
        var8_6 = var7_5.isHeldByCurrentThread();
        var9_7 = 0;
        if (this.fair) ** GOTO lbl-1000
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        if (!var7_5.tryLock()) lbl-1000: // 2 sources:
        {
            var9_7 = Monitor.initNanoTime(var5_4);
            if (!var7_5.tryLock(var2_2, var4_3)) {
                return false;
            }
        }
        var11_8 = false;
        var12_9 = true;
        try {
            var11_8 = var1_1.isSatisfied() != false || this.awaitNanos(var1_1, var9_7 == 0 ? var5_4 : Monitor.remainingNanos(var9_7, var5_4), var8_6) != false;
            var12_9 = false;
            var13_10 = var11_8;
            return var13_10;
        }
        finally {
            if (!var11_8) {
                try {
                    if (var12_9 && !var8_6) {
                        this.signalNextWaiter();
                    }
                }
                finally {
                    var7_5.unlock();
                }
            }
        }
    }

    public boolean enterWhenUninterruptibly(Monitor$Guard monitor$Guard, long l2, TimeUnit timeUnit) {
        boolean bl2;
        long l3;
        long l4;
        ReentrantLock reentrantLock;
        boolean bl3;
        boolean bl4;
        l4 = Monitor.toSafeNanos(l2, timeUnit);
        if (monitor$Guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        reentrantLock = this.lock;
        l3 = 0;
        bl2 = reentrantLock.isHeldByCurrentThread();
        bl4 = Thread.interrupted();
        try {
            if (this.fair || !reentrantLock.tryLock()) {
                l3 = Monitor.initNanoTime(l4);
                long l5 = l4;
                do {
                    try {
                        if (reentrantLock.tryLock(l5, TimeUnit.NANOSECONDS)) break;
                        boolean bl5 = false;
                        return bl5;
                    }
                    catch (InterruptedException var14_11) {
                        bl4 = true;
                        l5 = Monitor.remainingNanos(l3, l4);
                        continue;
                    }
                    break;
                } while (true);
            }
            bl3 = false;
        }
        finally {
            if (bl4) {
                Thread.currentThread().interrupt();
            }
        }
        do {
            try {
                if (monitor$Guard.isSatisfied()) {
                    bl3 = true;
                } else {
                    long l6;
                    if (l3 == 0) {
                        l3 = Monitor.initNanoTime(l4);
                        l6 = l4;
                    } else {
                        l6 = Monitor.remainingNanos(l3, l4);
                    }
                    bl3 = this.awaitNanos(monitor$Guard, l6, bl2);
                }
                boolean bl6 = bl3;
                return bl6;
            }
            catch (InterruptedException var13_13) {
                try {
                    bl4 = true;
                    bl2 = false;
                    continue;
                }
                catch (Throwable var16_17) {
                    throw var16_17;
                }
                finally {
                    if (!bl3) {
                        reentrantLock.unlock();
                    }
                }
            }
            break;
        } while (true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean enterIf(Monitor$Guard monitor$Guard) {
        if (monitor$Guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        boolean bl2 = false;
        try {
            boolean bl3 = bl2 = monitor$Guard.isSatisfied();
            return bl3;
        }
        finally {
            if (!bl2) {
                reentrantLock.unlock();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean enterIfInterruptibly(Monitor$Guard monitor$Guard) {
        if (monitor$Guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        boolean bl2 = false;
        try {
            boolean bl3 = bl2 = monitor$Guard.isSatisfied();
            return bl3;
        }
        finally {
            if (!bl2) {
                reentrantLock.unlock();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean enterIf(Monitor$Guard monitor$Guard, long l2, TimeUnit timeUnit) {
        if (monitor$Guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        if (!this.enter(l2, timeUnit)) {
            return false;
        }
        boolean bl2 = false;
        try {
            boolean bl3 = bl2 = monitor$Guard.isSatisfied();
            return bl3;
        }
        finally {
            if (!bl2) {
                this.lock.unlock();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean enterIfInterruptibly(Monitor$Guard monitor$Guard, long l2, TimeUnit timeUnit) {
        if (monitor$Guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.lock;
        if (!reentrantLock.tryLock(l2, timeUnit)) {
            return false;
        }
        boolean bl2 = false;
        try {
            boolean bl3 = bl2 = monitor$Guard.isSatisfied();
            return bl3;
        }
        finally {
            if (!bl2) {
                reentrantLock.unlock();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean tryEnterIf(Monitor$Guard monitor$Guard) {
        if (monitor$Guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.lock;
        if (!reentrantLock.tryLock()) {
            return false;
        }
        boolean bl2 = false;
        try {
            boolean bl3 = bl2 = monitor$Guard.isSatisfied();
            return bl3;
        }
        finally {
            if (!bl2) {
                reentrantLock.unlock();
            }
        }
    }

    public void waitFor(Monitor$Guard monitor$Guard) {
        if (!(monitor$Guard.monitor == this & this.lock.isHeldByCurrentThread())) {
            throw new IllegalMonitorStateException();
        }
        if (monitor$Guard.isSatisfied()) return;
        this.await(monitor$Guard, true);
    }

    public void waitForUninterruptibly(Monitor$Guard monitor$Guard) {
        if (!(monitor$Guard.monitor == this & this.lock.isHeldByCurrentThread())) {
            throw new IllegalMonitorStateException();
        }
        if (monitor$Guard.isSatisfied()) return;
        this.awaitUninterruptibly(monitor$Guard, true);
    }

    public boolean waitFor(Monitor$Guard monitor$Guard, long l2, TimeUnit timeUnit) {
        long l3 = Monitor.toSafeNanos(l2, timeUnit);
        if (!(monitor$Guard.monitor == this & this.lock.isHeldByCurrentThread())) {
            throw new IllegalMonitorStateException();
        }
        if (monitor$Guard.isSatisfied()) {
            return true;
        }
        if (!Thread.interrupted()) return this.awaitNanos(monitor$Guard, l3, true);
        throw new InterruptedException();
    }

    /*
     * Exception decompiling
     */
    public boolean waitForUninterruptibly(Monitor$Guard var1_1, long var2_2, TimeUnit var4_3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 4[CATCHBLOCK]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2869)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:817)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:129)
        // org.benf.cfr.reader.Main.main(Main.java:181)
        // the.bytecode.club.bytecodeviewer.decompilers.CFRDecompiler.decompileToZip(CFRDecompiler.java:245)
        // the.bytecode.club.bytecodeviewer.gui.MainViewerGUI$18$1$3.run(MainViewerGUI.java:1107)
        throw new IllegalStateException("Decompilation failed");
    }

    public void leave() {
        ReentrantLock reentrantLock = this.lock;
        try {
            if (reentrantLock.getHoldCount() != 1) return;
            this.signalNextWaiter();
            return;
        }
        finally {
            reentrantLock.unlock();
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

    public boolean hasQueuedThread(Thread thread) {
        return this.lock.hasQueuedThread(thread);
    }

    public boolean hasWaiters(Monitor$Guard monitor$Guard) {
        if (this.getWaitQueueLength(monitor$Guard) <= 0) return false;
        return true;
    }

    public int getWaitQueueLength(Monitor$Guard monitor$Guard) {
        if (monitor$Guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        this.lock.lock();
        try {
            int n2 = monitor$Guard.waiterCount;
            return n2;
        }
        finally {
            this.lock.unlock();
        }
    }

    private static long toSafeNanos(long l2, TimeUnit timeUnit) {
        long l3 = timeUnit.toNanos(l2);
        if (l3 <= 0) {
            return 0;
        }
        if (l3 > 6917529027641081853L) {
            return 6917529027641081853L;
        }
        long l4 = l3;
        return l4;
    }

    private static long initNanoTime(long l2) {
        if (l2 <= 0) {
            return 0;
        }
        long l3 = System.nanoTime();
        if (l3 == 0) {
            return 1;
        }
        long l4 = l3;
        return l4;
    }

    private static long remainingNanos(long l2, long l3) {
        if (l3 <= 0) {
            return 0;
        }
        long l4 = l3 - (System.nanoTime() - l2);
        return l4;
    }

    @GuardedBy(value="lock")
    private void signalNextWaiter() {
        Monitor$Guard monitor$Guard = this.activeGuards;
        while (monitor$Guard != null) {
            if (this.isSatisfied(monitor$Guard)) {
                monitor$Guard.condition.signal();
                return;
            }
            monitor$Guard = monitor$Guard.next;
        }
    }

    @GuardedBy(value="lock")
    private boolean isSatisfied(Monitor$Guard monitor$Guard) {
        try {
            return monitor$Guard.isSatisfied();
        }
        catch (Throwable var2_2) {
            this.signalAllWaiters();
            throw Throwables.propagate(var2_2);
        }
    }

    @GuardedBy(value="lock")
    private void signalAllWaiters() {
        Monitor$Guard monitor$Guard = this.activeGuards;
        while (monitor$Guard != null) {
            monitor$Guard.condition.signalAll();
            monitor$Guard = monitor$Guard.next;
        }
    }

    @GuardedBy(value="lock")
    private void beginWaitingFor(Monitor$Guard monitor$Guard) {
        int n2;
        if ((n2 = monitor$Guard.waiterCount++) != 0) return;
        monitor$Guard.next = this.activeGuards;
        this.activeGuards = monitor$Guard;
    }

    @GuardedBy(value="lock")
    private void endWaitingFor(Monitor$Guard monitor$Guard) {
        int n2;
        if ((n2 = --monitor$Guard.waiterCount) != 0) return;
        Monitor$Guard monitor$Guard2 = this.activeGuards;
        Monitor$Guard monitor$Guard3 = null;
        do {
            if (monitor$Guard2 == monitor$Guard) {
                if (monitor$Guard3 == null) {
                    this.activeGuards = monitor$Guard2.next;
                    break;
                }
                monitor$Guard3.next = monitor$Guard2.next;
                break;
            }
            monitor$Guard3 = monitor$Guard2;
            monitor$Guard2 = monitor$Guard2.next;
        } while (true);
        monitor$Guard2.next = null;
    }

    @GuardedBy(value="lock")
    private void await(Monitor$Guard monitor$Guard, boolean bl2) {
        if (bl2) {
            this.signalNextWaiter();
        }
        this.beginWaitingFor(monitor$Guard);
        try {
            do {
                monitor$Guard.condition.await();
            } while (!monitor$Guard.isSatisfied());
            return;
        }
        finally {
            this.endWaitingFor(monitor$Guard);
        }
    }

    @GuardedBy(value="lock")
    private void awaitUninterruptibly(Monitor$Guard monitor$Guard, boolean bl2) {
        if (bl2) {
            this.signalNextWaiter();
        }
        this.beginWaitingFor(monitor$Guard);
        try {
            do {
                monitor$Guard.condition.awaitUninterruptibly();
            } while (!monitor$Guard.isSatisfied());
            return;
        }
        finally {
            this.endWaitingFor(monitor$Guard);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @GuardedBy(value="lock")
    private boolean awaitNanos(Monitor$Guard monitor$Guard, long l2, boolean bl2) {
        boolean bl3 = true;
        try {
            do {
                if (l2 <= 0) {
                    boolean bl4 = false;
                    return bl4;
                }
                if (bl3) {
                    if (bl2) {
                        this.signalNextWaiter();
                    }
                    this.beginWaitingFor(monitor$Guard);
                    bl3 = false;
                }
                l2 = monitor$Guard.condition.awaitNanos(l2);
            } while (!monitor$Guard.isSatisfied());
            boolean bl5 = true;
            return bl5;
        }
        finally {
            if (!bl3) {
                this.endWaitingFor(monitor$Guard);
            }
        }
    }

    static /* synthetic */ ReentrantLock access$000(Monitor monitor) {
        return monitor.lock;
    }
}

