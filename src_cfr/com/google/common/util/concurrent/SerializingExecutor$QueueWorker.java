/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.SerializingExecutor;
import com.google.common.util.concurrent.SerializingExecutor$1;
import java.util.logging.Level;

class SerializingExecutor$QueueWorker
implements Runnable {
    final /* synthetic */ SerializingExecutor this$0;

    private SerializingExecutor$QueueWorker(SerializingExecutor serializingExecutor) {
        this.this$0 = serializingExecutor;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        try {
            this.workOnQueue();
            return;
        }
        catch (Error var1_1) {
            Object object = SerializingExecutor.access$100(this.this$0);
            synchronized (object) {
                SerializingExecutor.access$202(this.this$0, false);
                throw var1_1;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void workOnQueue() {
        do {
            Runnable runnable = null;
            Object object = SerializingExecutor.access$100(this.this$0);
            synchronized (object) {
                if (SerializingExecutor.access$300(this.this$0) == 0) {
                    runnable = (Runnable)SerializingExecutor.access$400(this.this$0).poll();
                }
                if (runnable == null) {
                    SerializingExecutor.access$202(this.this$0, false);
                    return;
                }
            }
            try {
                runnable.run();
                continue;
            }
            catch (RuntimeException var2_3) {
                String string = String.valueOf(runnable);
                SerializingExecutor.access$500().log(Level.SEVERE, new StringBuilder(35 + String.valueOf(string).length()).append("Exception while executing runnable ").append(string).toString(), var2_3);
                continue;
            }
            break;
        } while (true);
    }

    /* synthetic */ SerializingExecutor$QueueWorker(SerializingExecutor serializingExecutor, SerializingExecutor$1 serializingExecutor$1) {
        this(serializingExecutor);
    }
}

