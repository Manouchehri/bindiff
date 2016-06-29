package com.google.protobuf;

import com.google.protobuf.ExtensionLite;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;

public interface GeneratedMessage$ExtendableMessageOrBuilder extends MessageOrBuilder {
   Message getDefaultInstanceForType();

   boolean hasExtension(ExtensionLite var1);

   int getExtensionCount(ExtensionLite var1);

   Object getExtension(ExtensionLite var1);

   Object getExtension(ExtensionLite var1, int var2);
}
