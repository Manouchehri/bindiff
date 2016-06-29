/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.RpcCallback;
import com.google.protobuf.RpcUtil$1;
import com.google.protobuf.RpcUtil$2;

public final class RpcUtil {
    private RpcUtil() {
    }

    public static RpcCallback specializeCallback(RpcCallback rpcCallback) {
        return rpcCallback;
    }

    public static RpcCallback generalizeCallback(RpcCallback rpcCallback, Class class_, Message message) {
        return new RpcUtil$1(class_, message, rpcCallback);
    }

    private static Message copyAsType(Message message, Message message2) {
        return message.newBuilderForType().mergeFrom(message2).build();
    }

    public static RpcCallback newOneTimeCallback(RpcCallback rpcCallback) {
        return new RpcUtil$2(rpcCallback);
    }

    static /* synthetic */ Message access$000(Message message, Message message2) {
        return RpcUtil.copyAsType(message, message2);
    }
}

