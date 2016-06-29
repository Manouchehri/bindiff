package com.google.common.util.concurrent;

final class AbstractFuture$Failure$1 extends Throwable
{
    AbstractFuture$Failure$1(final String s) {
        super(s);
    }
    
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
