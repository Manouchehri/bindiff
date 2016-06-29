package com.google.protobuf;

public final class RpcUtil$AlreadyCalledException extends RuntimeException
{
    private static final long serialVersionUID = 5469741279507848266L;
    
    public RpcUtil$AlreadyCalledException() {
        super("This RpcCallback was already called and cannot be called multiple times.");
    }
}
