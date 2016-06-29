package org.ibex.nestedvm;

public class Runtime$FaultException extends Runtime$ExecutionException
{
    public final int addr;
    public final RuntimeException cause;
    
    public Runtime$FaultException(final int addr) {
        super("fault at: " + Runtime.toHex(addr));
        this.addr = addr;
        this.cause = null;
    }
    
    public Runtime$FaultException(final RuntimeException cause) {
        super(cause.toString());
        this.addr = -1;
        this.cause = cause;
    }
}
