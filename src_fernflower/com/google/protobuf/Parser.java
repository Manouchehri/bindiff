package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import java.io.InputStream;

public interface Parser {
   Object parseFrom(CodedInputStream var1);

   Object parseFrom(CodedInputStream var1, ExtensionRegistryLite var2);

   Object parsePartialFrom(CodedInputStream var1);

   Object parsePartialFrom(CodedInputStream var1, ExtensionRegistryLite var2);

   Object parseFrom(ByteString var1);

   Object parseFrom(ByteString var1, ExtensionRegistryLite var2);

   Object parsePartialFrom(ByteString var1);

   Object parsePartialFrom(ByteString var1, ExtensionRegistryLite var2);

   Object parseFrom(byte[] var1, int var2, int var3);

   Object parseFrom(byte[] var1, int var2, int var3, ExtensionRegistryLite var4);

   Object parseFrom(byte[] var1);

   Object parseFrom(byte[] var1, ExtensionRegistryLite var2);

   Object parsePartialFrom(byte[] var1, int var2, int var3);

   Object parsePartialFrom(byte[] var1, int var2, int var3, ExtensionRegistryLite var4);

   Object parsePartialFrom(byte[] var1);

   Object parsePartialFrom(byte[] var1, ExtensionRegistryLite var2);

   Object parseFrom(InputStream var1);

   Object parseFrom(InputStream var1, ExtensionRegistryLite var2);

   Object parsePartialFrom(InputStream var1);

   Object parsePartialFrom(InputStream var1, ExtensionRegistryLite var2);

   Object parseDelimitedFrom(InputStream var1);

   Object parseDelimitedFrom(InputStream var1, ExtensionRegistryLite var2);

   Object parsePartialDelimitedFrom(InputStream var1);

   Object parsePartialDelimitedFrom(InputStream var1, ExtensionRegistryLite var2);
}
