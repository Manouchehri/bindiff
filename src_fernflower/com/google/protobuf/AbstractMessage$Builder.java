package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.MessageReflection;
import com.google.protobuf.MessageReflection$BuilderAdapter;
import com.google.protobuf.TextFormat;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public abstract class AbstractMessage$Builder extends AbstractMessageLite$Builder implements Message$Builder {
   public abstract AbstractMessage$Builder clone();

   public boolean hasOneof(Descriptors$OneofDescriptor var1) {
      throw new UnsupportedOperationException("hasOneof() is not implemented.");
   }

   public Descriptors$FieldDescriptor getOneofFieldDescriptor(Descriptors$OneofDescriptor var1) {
      throw new UnsupportedOperationException("getOneofFieldDescriptor() is not implemented.");
   }

   public AbstractMessage$Builder clearOneof(Descriptors$OneofDescriptor var1) {
      throw new UnsupportedOperationException("clearOneof() is not implemented.");
   }

   public AbstractMessage$Builder clear() {
      Iterator var1 = this.getAllFields().entrySet().iterator();

      while(var1.hasNext()) {
         Entry var2 = (Entry)var1.next();
         this.clearField((Descriptors$FieldDescriptor)var2.getKey());
      }

      return this;
   }

   public List findInitializationErrors() {
      return MessageReflection.findMissingFields(this);
   }

   public String getInitializationErrorString() {
      return MessageReflection.delimitWithCommas(this.findInitializationErrors());
   }

   public AbstractMessage$Builder mergeFrom(Message var1) {
      if(var1.getDescriptorForType() != this.getDescriptorForType()) {
         throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
      } else {
         Iterator var2 = var1.getAllFields().entrySet().iterator();

         while(true) {
            while(var2.hasNext()) {
               Entry var3 = (Entry)var2.next();
               Descriptors$FieldDescriptor var4 = (Descriptors$FieldDescriptor)var3.getKey();
               if(var4.isRepeated()) {
                  Iterator var7 = ((List)var3.getValue()).iterator();

                  while(var7.hasNext()) {
                     Object var6 = var7.next();
                     this.addRepeatedField(var4, var6);
                  }
               } else if(var4.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE) {
                  Message var5 = (Message)this.getField(var4);
                  if(var5 == var5.getDefaultInstanceForType()) {
                     this.setField(var4, var3.getValue());
                  } else {
                     this.setField(var4, var5.newBuilderForType().mergeFrom(var5).mergeFrom((Message)var3.getValue()).build());
                  }
               } else {
                  this.setField(var4, var3.getValue());
               }
            }

            this.mergeUnknownFields(var1.getUnknownFields());
            return this;
         }
      }
   }

   public AbstractMessage$Builder mergeFrom(CodedInputStream var1) {
      return this.mergeFrom((CodedInputStream)var1, ExtensionRegistry.getEmptyRegistry());
   }

   public AbstractMessage$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      UnknownFieldSet$Builder var3 = UnknownFieldSet.newBuilder(this.getUnknownFields());

      int var4;
      MessageReflection$BuilderAdapter var5;
      do {
         var4 = var1.readTag();
         if(var4 == 0) {
            break;
         }

         var5 = new MessageReflection$BuilderAdapter(this);
      } while(MessageReflection.mergeFieldFrom(var1, var3, var2, this.getDescriptorForType(), var5, var4));

      this.setUnknownFields(var3.build());
      return this;
   }

   public AbstractMessage$Builder mergeUnknownFields(UnknownFieldSet var1) {
      this.setUnknownFields(UnknownFieldSet.newBuilder(this.getUnknownFields()).mergeFrom(var1).build());
      return this;
   }

   public Message$Builder getFieldBuilder(Descriptors$FieldDescriptor var1) {
      throw new UnsupportedOperationException("getFieldBuilder() called on an unsupported message type.");
   }

   public Message$Builder getRepeatedFieldBuilder(Descriptors$FieldDescriptor var1, int var2) {
      throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on an unsupported message type.");
   }

   public String toString() {
      return TextFormat.printToString((MessageOrBuilder)this);
   }

   protected static UninitializedMessageException newUninitializedMessageException(Message var0) {
      return new UninitializedMessageException(MessageReflection.findMissingFields(var0));
   }

   public AbstractMessage$Builder mergeFrom(ByteString var1) {
      return (AbstractMessage$Builder)super.mergeFrom(var1);
   }

   public AbstractMessage$Builder mergeFrom(ByteString var1, ExtensionRegistryLite var2) {
      return (AbstractMessage$Builder)super.mergeFrom(var1, var2);
   }

   public AbstractMessage$Builder mergeFrom(byte[] var1) {
      return (AbstractMessage$Builder)super.mergeFrom(var1);
   }

   public AbstractMessage$Builder mergeFrom(byte[] var1, int var2, int var3) {
      return (AbstractMessage$Builder)super.mergeFrom(var1, var2, var3);
   }

   public AbstractMessage$Builder mergeFrom(byte[] var1, ExtensionRegistryLite var2) {
      return (AbstractMessage$Builder)super.mergeFrom(var1, var2);
   }

   public AbstractMessage$Builder mergeFrom(byte[] var1, int var2, int var3, ExtensionRegistryLite var4) {
      return (AbstractMessage$Builder)super.mergeFrom(var1, var2, var3, var4);
   }

   public AbstractMessage$Builder mergeFrom(InputStream var1) {
      return (AbstractMessage$Builder)super.mergeFrom(var1);
   }

   public AbstractMessage$Builder mergeFrom(InputStream var1, ExtensionRegistryLite var2) {
      return (AbstractMessage$Builder)super.mergeFrom(var1, var2);
   }

   public boolean mergeDelimitedFrom(InputStream var1) {
      return super.mergeDelimitedFrom(var1);
   }

   public boolean mergeDelimitedFrom(InputStream var1, ExtensionRegistryLite var2) {
      return super.mergeDelimitedFrom(var1, var2);
   }
}
