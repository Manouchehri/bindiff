package com.google.common.util.concurrent;

import java.util.concurrent.*;
import javax.annotation.concurrent.*;
import com.google.common.collect.*;
import com.google.common.base.*;
import java.util.logging.*;
import java.util.*;

final class ListenerCallQueue implements Runnable
{
    private static final Logger logger;
    private final Object listener;
    private final Executor executor;
    @GuardedBy("this")
    private final Queue waitQueue;
    @GuardedBy("this")
    private boolean isThreadScheduled;
    
    ListenerCallQueue(final Object o, final Executor executor) {
        this.waitQueue = Queues.newArrayDeque();
        this.listener = Preconditions.checkNotNull(o);
        this.executor = (Executor)Preconditions.checkNotNull(executor);
    }
    
    synchronized void add(final ListenerCallQueue$Callback listenerCallQueue$Callback) {
        this.waitQueue.add(listenerCallQueue$Callback);
    }
    
    void execute() {
        boolean b = false;
        synchronized (this) {
            if (!this.isThreadScheduled) {
                this.isThreadScheduled = true;
                b = true;
            }
        }
        if (b) {
            try {
                this.executor.execute(this);
            }
            catch (RuntimeException ex) {
                synchronized (this) {
                    this.isThreadScheduled = false;
                }
                final Logger logger = ListenerCallQueue.logger;
                final Level severe = Level.SEVERE;
                final String value = String.valueOf(this.listener);
                final String value2 = String.valueOf(this.executor);
                logger.log(severe, new StringBuilder(42 + String.valueOf(value).length() + String.valueOf(value2).length()).append("Exception while running callbacks for ").append(value).append(" on ").append(value2).toString(), ex);
                throw ex;
            }
        }
    }
    
    @Override
    public void run() {
        boolean b = true;
        try {
            while (true) {
                final ListenerCallQueue$Callback listenerCallQueue$Callback;
                synchronized (this) {
                    Preconditions.checkState(this.isThreadScheduled);
                    listenerCallQueue$Callback = this.waitQueue.poll();
                    if (listenerCallQueue$Callback == null) {
                        this.isThreadScheduled = false;
                        b = false;
                        break;
                    }
                }
                try {
                    listenerCallQueue$Callback.call(this.listener);
                }
                catch (RuntimeException ex) {
                    final Logger logger = ListenerCallQueue.logger;
                    final Level severe = Level.SEVERE;
                    final String value = String.valueOf(this.listener);
                    final String access$000 = listenerCallQueue$Callback.methodCall;
                    logger.log(severe, new StringBuilder(37 + String.valueOf(value).length() + String.valueOf(access$000).length()).append("Exception while executing callback: ").append(value).append(".").append(access$000).toString(), ex);
                }
            }
        }
        finally {
            if (b) {
                synchronized (this) {
                    this.isThreadScheduled = false;
                }
            }
        }
    }
    
    static {
        logger = Logger.getLogger(ListenerCallQueue.class.getName());
    }
}
