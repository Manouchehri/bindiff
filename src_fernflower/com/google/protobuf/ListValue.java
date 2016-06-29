package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.ListValue$1;
import com.google.protobuf.ListValue$Builder;
import com.google.protobuf.ListValueOrBuilder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.StructProto;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.Value;
import com.google.protobuf.ValueOrBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ListValue extends GeneratedMessage implements ListValueOrBuilder {
   public static final int VALUES_FIELD_NUMBER = 1;
   private List values_;
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final ListValue DEFAULT_INSTANCE = new ListValue();
   public static final Parser PARSER = new ListValue$1();

   private ListValue(GeneratedMessage$Builder var1) {
      super(var1);
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private ListValue() {
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
      this.values_ = Collections.emptyList();
   }

   public final UnknownFieldSet getUnknownFields() {
      return UnknownFieldSet.getDefaultInstance();
   }

   private ListValue(CodedInputStream var1, ExtensionRegistryLite var2) {
      this();
      boolean var3 = false;

      try {
         boolean var4 = false;

         while(!var4) {
            int var5 = var1.readTag();
            switch(var5) {
            case 0:
               var4 = true;
               break;
            case 10:
               if(!(var3 & true)) {
                  this.values_ = new ArrayList();
                  var3 |= true;
               }

               this.values_.add(var1.readMessage(Value.PARSER, var2));
               break;
            default:
               if(!var1.skipField(var5)) {
                  var4 = true;
               }
            }
         }
      } catch (InvalidProtocolBufferException var11) {
         throw new RuntimeException(var11.setUnfinishedMessage(this));
      } catch (IOException var12) {
         throw new RuntimeException((new InvalidProtocolBufferException(var12.getMessage())).setUnfinishedMessage(this));
      } finally {
         if(var3 & true) {
            this.values_ = Collections.unmodifiableList(this.values_);
         }

         this.makeExtensionsImmutable();
      }

   }

   public static final Descriptors$Descriptor getDescriptor() {
      return StructProto.internal_static_google_protobuf_ListValue_descriptor;
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return StructProto.internal_static_google_protobuf_ListValue_fieldAccessorTable.ensureFieldAccessorsInitialized(ListValue.class, ListValue$Builder.class);
   }

   public List getValuesList() {
      return this.values_;
   }

   public List getValuesOrBuilderList() {
      return this.values_;
   }

   public int getValuesCount() {
      return this.values_.size();
   }

   public Value getValues(int var1) {
      return (Value)this.values_.get(var1);
   }

   public ValueOrBuilder getValuesOrBuilder(int var1) {
      return (ValueOrBuilder)this.values_.get(var1);
   }

   public final boolean isInitialized() {
      byte var1 = this.memoizedIsInitialized;
      if(var1 == 1) {
         return true;
      } else if(var1 == 0) {
         return false;
      } else {
         this.memoizedIsInitialized = 1;
         return true;
      }
   }

   public void writeTo(CodedOutputStream var1) {
      for(int var2 = 0; var2 < this.values_.size(); ++var2) {
         var1.writeMessage(1, (MessageLite)this.values_.get(var2));
      }

   }

   public int getSerializedSize() {
      int var1 = this.memoizedSerializedSize;
      if(var1 != -1) {
         return var1;
      } else {
         var1 = 0;

         for(int var2 = 0; var2 < this.values_.size(); ++var2) {
            var1 += CodedOutputStream.computeMessageSize(1, (MessageLite)this.values_.get(var2));
         }

         this.memoizedSerializedSize = var1;
         return var1;
      }
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof ListValue)) {
         return super.equals(var1);
      } else {
         ListValue var2 = (ListValue)var1;
         boolean var3 = true;
         var3 = var3 && this.getValuesList().equals(var2.getValuesList());
         return var3;
      }
   }

   public int hashCode() {
      if(this.memoizedHashCode != 0) {
         return this.memoizedHashCode;
      } else {
         byte var1 = 41;
         int var2 = 19 * var1 + this.getDescriptorForType().hashCode();
         if(this.getValuesCount() > 0) {
            var2 = 37 * var2 + 1;
            var2 = 53 * var2 + this.getValuesList().hashCode();
         }

         var2 = 29 * var2 + this.unknownFields.hashCode();
         this.memoizedHashCode = var2;
         return var2;
      }
   }

   public static ListValue parseFrom(ByteString var0) {
      return (ListValue)PARSER.parseFrom(var0);
   }

   public static ListValue parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (ListValue)PARSER.parseFrom(var0, var1);
   }

   public static ListValue parseFrom(byte[] var0) {
      return (ListValue)PARSER.parseFrom(var0);
   }

   public static ListValue parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (ListValue)PARSER.parseFrom(var0, var1);
   }

   public static ListValue parseFrom(InputStream var0) {
      return (ListValue)PARSER.parseFrom(var0);
   }

   public static ListValue parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (ListValue)PARSER.parseFrom(var0, var1);
   }

   public static ListValue parseDelimitedFrom(InputStream var0) {
      return (ListValue)PARSER.parseDelimitedFrom(var0);
   }

   public static ListValue parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (ListValue)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static ListValue parseFrom(CodedInputStream var0) {
      return (ListValue)PARSER.parseFrom(var0);
   }

   public static ListValue parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (ListValue)PARSER.parseFrom(var0, var1);
   }

   public ListValue$Builder newBuilderForType() {
      return newBuilder();
   }

   public static ListValue$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static ListValue$Builder newBuilder(ListValue var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public ListValue$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new ListValue$Builder((ListValue$1)null):(new ListValue$Builder((ListValue$1)null)).mergeFrom(this);
   }

   protected ListValue$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      ListValue$Builder var2 = new ListValue$Builder(var1, (ListValue$1)null);
      return var2;
   }

   public static ListValue getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public ListValue getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   ListValue(GeneratedMessage$Builder var1, ListValue$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static List access$302(ListValue var0, List var1) {
      return var0.values_ = var1;
   }

   // $FF: synthetic method
   static List access$300(ListValue var0) {
      return var0.values_;
   }

   // $FF: synthetic method
   ListValue(CodedInputStream var1, ExtensionRegistryLite var2, ListValue$1 var3) {
      this(var1, var2);
   }
}
