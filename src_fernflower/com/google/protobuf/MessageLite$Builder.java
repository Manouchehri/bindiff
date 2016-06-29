package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import java.io.InputStream;

public interface MessageLite$Builder extends MessageLiteOrBuilder, Cloneable {
   MessageLite$Builder clear();

   MessageLite build();

   MessageLite buildPartial();

   MessageLite$Builder clone();

   MessageLite$Builder mergeFrom(CodedInputStream var1);

   MessageLite$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2);

   MessageLite$Builder mergeFrom(ByteString var1);

   MessageLite$Builder mergeFrom(ByteString var1, ExtensionRegistryLite var2);

   MessageLite$Builder mergeFrom(byte[] var1);

   MessageLite$Builder mergeFrom(byte[] var1, int var2, int var3);

   MessageLite$Builder mergeFrom(byte[] var1, ExtensionRegistryLite var2);

   MessageLite$Builder mergeFrom(byte[] var1, int var2, int var3, ExtensionRegistryLite var4);

   MessageLite$Builder mergeFrom(InputStream var1);

   MessageLite$Builder mergeFrom(InputStream var1, ExtensionRegistryLite var2);

   boolean mergeDelimitedFrom(InputStream var1);

   boolean mergeDelimitedFrom(InputStream var1, ExtensionRegistryLite var2);
}
