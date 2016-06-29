package com.google.protobuf;

public final class RpcUtil
{
    public static RpcCallback specializeCallback(final RpcCallback rpcCallback) {
        return rpcCallback;
    }
    
    public static RpcCallback generalizeCallback(final RpcCallback rpcCallback, final Class clazz, final Message message) {
        return new RpcUtil$1(clazz, message, rpcCallback);
    }
    
    private static Message copyAsType(final Message message, final Message message2) {
        return message.newBuilderForType().mergeFrom(message2).build();
    }
    
    public static RpcCallback newOneTimeCallback(final RpcCallback rpcCallback) {
        return new RpcUtil$2(rpcCallback);
    }
}
