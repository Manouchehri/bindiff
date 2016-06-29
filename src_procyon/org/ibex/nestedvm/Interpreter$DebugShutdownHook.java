package org.ibex.nestedvm;

public class Interpreter$DebugShutdownHook implements Runnable
{
    private final Interpreter this$0;
    
    public Interpreter$DebugShutdownHook(final Interpreter this$0) {
        this.this$0 = this$0;
    }
    
    public void run() {
        final int access$000 = Interpreter.access$000(this.this$0);
        if (this.this$0.getState() == 0) {
            System.err.print("\nCPU Executing " + Runtime.toHex(access$000) + ": " + this.this$0.sourceLine(access$000) + "\n");
        }
    }
}
