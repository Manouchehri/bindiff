/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import java.io.InputStream;

public interface MessageLite$Builder
extends MessageLiteOrBuilder,
Cloneable {
    public MessageLite$Builder clear();

    public MessageLite build();

    public MessageLite buildPartial();

    public MessageLite$Builder clone();

    public MessageLite$Builder mergeFrom(CodedInputStream var1);

    public MessageLite$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2);

    public MessageLite$Builder mergeFrom(ByteString var1);

    public MessageLite$Builder mergeFrom(ByteString var1, ExtensionRegistryLite var2);

    public MessageLite$Builder mergeFrom(byte[] var1);

    public MessageLite$Builder mergeFrom(byte[] var1, int var2, int var3);

    public MessageLite$Builder mergeFrom(byte[] var1, ExtensionRegistryLite var2);

    public MessageLite$Builder mergeFrom(byte[] var1, int var2, int var3, ExtensionRegistryLite var4);

    public MessageLite$Builder mergeFrom(InputStream var1);

    public MessageLite$Builder mergeFrom(InputStream var1, ExtensionRegistryLite var2);

    public boolean mergeDelimitedFrom(InputStream var1);

    public boolean mergeDelimitedFrom(InputStream var1, ExtensionRegistryLite var2);
}

