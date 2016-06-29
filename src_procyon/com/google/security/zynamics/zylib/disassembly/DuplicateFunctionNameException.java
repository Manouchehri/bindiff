package com.google.security.zynamics.zylib.disassembly;

@Deprecated
public class DuplicateFunctionNameException extends Exception
{
    private static final long serialVersionUID = 8935154529155710030L;
    private final StackTraceElement[] m_originalStacktrace;
    
    public DuplicateFunctionNameException(final String s) {
        super(s);
        this.m_originalStacktrace = new Throwable().getStackTrace();
    }
    
    @Override
    public StackTraceElement[] getStackTrace() {
        return this.m_originalStacktrace;
    }
}
