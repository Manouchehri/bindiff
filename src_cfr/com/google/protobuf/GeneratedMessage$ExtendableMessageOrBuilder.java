/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ExtensionLite;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;

public interface GeneratedMessage$ExtendableMessageOrBuilder
extends MessageOrBuilder {
    @Override
    public Message getDefaultInstanceForType();

    public boolean hasExtension(ExtensionLite var1);

    public int getExtensionCount(ExtensionLite var1);

    public Object getExtension(ExtensionLite var1);

    public Object getExtension(ExtensionLite var1, int var2);
}

