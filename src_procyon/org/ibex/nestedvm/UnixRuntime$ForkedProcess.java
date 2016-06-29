package org.ibex.nestedvm;

public final class UnixRuntime$ForkedProcess extends Thread
{
    private final UnixRuntime initial;
    
    public UnixRuntime$ForkedProcess(final UnixRuntime initial) {
        this.initial = initial;
        this.start();
    }
    
    public void run() {
        UnixRuntime.executeAndExec(this.initial);
    }
}
