/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.base.log;

public class MemoryUsageMessage {
    private final String message;

    public MemoryUsageMessage(String string) {
        this.message = string;
    }

    public String toString() {
        return new StringBuffer().append(this.message).append("Free: ").append(Runtime.getRuntime().freeMemory()).append("; ").append("Total: ").append(Runtime.getRuntime().totalMemory()).toString();
    }
}

