package com.google.protobuf;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.FieldSet;
import com.google.protobuf.GeneratedMessage$1;
import com.google.protobuf.GeneratedMessage$ExtendableMessage;
import com.google.protobuf.LazyField$LazyEntry;
import com.google.protobuf.Message;
import com.google.protobuf.WireFormat$JavaType;
import java.util.Iterator;
import java.util.Map.Entry;

public class GeneratedMessage$ExtendableMessage$ExtensionWriter {
   private final Iterator iter;
   private Entry next;
   private final boolean messageSetWireFormat;
   // $FF: synthetic field
   final GeneratedMessage$ExtendableMessage this$0;

   private GeneratedMessage$ExtendableMessage$ExtensionWriter(GeneratedMessage$ExtendableMessage var1, boolean var2) {
      this.this$0 = var1;
      this.iter = GeneratedMessage$ExtendableMessage.access$600(this.this$0).iterator();
      if(this.iter.hasNext()) {
         this.next = (Entry)this.iter.next();
      }

      this.messageSetWireFormat = var2;
   }

   public void writeUntil(int var1, CodedOutputStream var2) {
      while(this.next != null && ((Descriptors$FieldDescriptor)this.next.getKey()).getNumber() < var1) {
         Descriptors$FieldDescriptor var3 = (Descriptors$FieldDescriptor)this.next.getKey();
         if(this.messageSetWireFormat && var3.getLiteJavaType() == WireFormat$JavaType.MESSAGE && !var3.isRepeated()) {
            if(this.next instanceof LazyField$LazyEntry) {
               var2.writeRawMessageSetExtension(var3.getNumber(), ((LazyField$LazyEntry)this.next).getField().toByteString());
            } else {
               var2.writeMessageSetExtension(var3.getNumber(), (Message)this.next.getValue());
            }
         } else {
            FieldSet.writeField(var3, this.next.getValue(), var2);
         }

         if(this.iter.hasNext()) {
            this.next = (Entry)this.iter.next();
         } else {
            this.next = null;
         }
      }

   }

   // $FF: synthetic method
   GeneratedMessage$ExtendableMessage$ExtensionWriter(GeneratedMessage$ExtendableMessage var1, boolean var2, GeneratedMessage$1 var3) {
      this(var1, var2);
   }
}
