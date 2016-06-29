package com.google.protobuf;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.FieldSet;
import com.google.protobuf.GeneratedMessageLite$1;
import com.google.protobuf.GeneratedMessageLite$ExtendableMessage;
import com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor;
import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat$JavaType;
import java.util.Iterator;
import java.util.Map.Entry;

public class GeneratedMessageLite$ExtendableMessage$ExtensionWriter {
   private final Iterator iter;
   private Entry next;
   private final boolean messageSetWireFormat;
   // $FF: synthetic field
   final GeneratedMessageLite$ExtendableMessage this$0;

   private GeneratedMessageLite$ExtendableMessage$ExtensionWriter(GeneratedMessageLite$ExtendableMessage var1, boolean var2) {
      this.this$0 = var1;
      this.iter = this.this$0.extensions.iterator();
      if(this.iter.hasNext()) {
         this.next = (Entry)this.iter.next();
      }

      this.messageSetWireFormat = var2;
   }

   public void writeUntil(int var1, CodedOutputStream var2) {
      while(this.next != null && ((GeneratedMessageLite$ExtensionDescriptor)this.next.getKey()).getNumber() < var1) {
         GeneratedMessageLite$ExtensionDescriptor var3 = (GeneratedMessageLite$ExtensionDescriptor)this.next.getKey();
         if(this.messageSetWireFormat && var3.getLiteJavaType() == WireFormat$JavaType.MESSAGE && !var3.isRepeated()) {
            var2.writeMessageSetExtension(var3.getNumber(), (MessageLite)this.next.getValue());
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
   GeneratedMessageLite$ExtendableMessage$ExtensionWriter(GeneratedMessageLite$ExtendableMessage var1, boolean var2, GeneratedMessageLite$1 var3) {
      this(var1, var2);
   }
}
