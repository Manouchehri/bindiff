/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import java.io.InputStream;

public interface Parser {
    public Object parseFrom(CodedInputStream var1);

    public Object parseFrom(CodedInputStream var1, ExtensionRegistryLite var2);

    public Object parsePartialFrom(CodedInputStream var1);

    public Object parsePartialFrom(CodedInputStream var1, ExtensionRegistryLite var2);

    public Object parseFrom(ByteString var1);

    public Object parseFrom(ByteString var1, ExtensionRegistryLite var2);

    public Object parsePartialFrom(ByteString var1);

    public Object parsePartialFrom(ByteString var1, ExtensionRegistryLite var2);

    public Object parseFrom(byte[] var1, int var2, int var3);

    public Object parseFrom(byte[] var1, int var2, int var3, ExtensionRegistryLite var4);

    public Object parseFrom(byte[] var1);

    public Object parseFrom(byte[] var1, ExtensionRegistryLite var2);

    public Object parsePartialFrom(byte[] var1, int var2, int var3);

    public Object parsePartialFrom(byte[] var1, int var2, int var3, ExtensionRegistryLite var4);

    public Object parsePartialFrom(byte[] var1);

    public Object parsePartialFrom(byte[] var1, ExtensionRegistryLite var2);

    public Object parseFrom(InputStream var1);

    public Object parseFrom(InputStream var1, ExtensionRegistryLite var2);

    public Object parsePartialFrom(InputStream var1);

    public Object parsePartialFrom(InputStream var1, ExtensionRegistryLite var2);

    public Object parseDelimitedFrom(InputStream var1);

    public Object parseDelimitedFrom(InputStream var1, ExtensionRegistryLite var2);

    public Object parsePartialDelimitedFrom(InputStream var1);

    public Object parsePartialDelimitedFrom(InputStream var1, ExtensionRegistryLite var2);
}

