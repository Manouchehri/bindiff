package com.google.protobuf;

import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.Message$Builder;

interface GeneratedMessage$FieldAccessorTable$FieldAccessor {
   Object get(GeneratedMessage var1);

   Object get(GeneratedMessage$Builder var1);

   Object getRaw(GeneratedMessage var1);

   Object getRaw(GeneratedMessage$Builder var1);

   void set(GeneratedMessage$Builder var1, Object var2);

   Object getRepeated(GeneratedMessage var1, int var2);

   Object getRepeated(GeneratedMessage$Builder var1, int var2);

   Object getRepeatedRaw(GeneratedMessage var1, int var2);

   Object getRepeatedRaw(GeneratedMessage$Builder var1, int var2);

   void setRepeated(GeneratedMessage$Builder var1, int var2, Object var3);

   void addRepeated(GeneratedMessage$Builder var1, Object var2);

   boolean has(GeneratedMessage var1);

   boolean has(GeneratedMessage$Builder var1);

   int getRepeatedCount(GeneratedMessage var1);

   int getRepeatedCount(GeneratedMessage$Builder var1);

   void clear(GeneratedMessage$Builder var1);

   Message$Builder newBuilder();

   Message$Builder getBuilder(GeneratedMessage$Builder var1);

   Message$Builder getRepeatedBuilder(GeneratedMessage$Builder var1, int var2);
}
