package org.jfree.base.log;

public class MemoryUsageMessage
{
    private final String message;
    
    public MemoryUsageMessage(final String message) {
        this.message = message;
    }
    
    public String toString() {
        return this.message + "Free: " + Runtime.getRuntime().freeMemory() + "; " + "Total: " + Runtime.getRuntime().totalMemory();
    }
}
