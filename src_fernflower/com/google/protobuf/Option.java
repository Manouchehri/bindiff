package com.google.protobuf;

import com.google.protobuf.Any;
import com.google.protobuf.Any$Builder;
import com.google.protobuf.AnyOrBuilder;
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
import com.google.protobuf.Option$1;
import com.google.protobuf.Option$Builder;
import com.google.protobuf.OptionOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.TypeProto;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;

public final class Option extends GeneratedMessage implements OptionOrBuilder {
   public static final int NAME_FIELD_NUMBER = 1;
   private volatile Object name_;
   public static final int VALUE_FIELD_NUMBER = 2;
   private Any value_;
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final Option DEFAULT_INSTANCE = new Option();
   public static final Parser PARSER = new Option$1();

   private Option(GeneratedMessage$Builder var1) {
      super(var1);
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private Option() {
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
      this.name_ = "";
   }

   public final UnknownFieldSet getUnknownFields() {
      return UnknownFieldSet.getDefaultInstance();
   }

   private Option(CodedInputStream var1, ExtensionRegistryLite var2) {
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
               ByteString var15 = var1.readBytes();
               this.name_ = var15;
               break;
            case 18:
               Any$Builder var6 = null;
               if(this.value_ != null) {
                  var6 = this.value_.toBuilder();
               }

               this.value_ = (Any)var1.readMessage(Any.PARSER, var2);
               if(var6 != null) {
                  var6.mergeFrom(this.value_);
                  this.value_ = var6.buildPartial();
               }
               break;
            default:
               if(!var1.skipField(var5)) {
                  var4 = true;
               }
            }
         }
      } catch (InvalidProtocolBufferException var12) {
         throw new RuntimeException(var12.setUnfinishedMessage(this));
      } catch (IOException var13) {
         throw new RuntimeException((new InvalidProtocolBufferException(var13.getMessage())).setUnfinishedMessage(this));
      } finally {
         this.makeExtensionsImmutable();
      }

   }

   public static final Descriptors$Descriptor getDescriptor() {
      return TypeProto.internal_static_google_protobuf_Option_descriptor;
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return TypeProto.internal_static_google_protobuf_Option_fieldAccessorTable.ensureFieldAccessorsInitialized(Option.class, Option$Builder.class);
   }

   public String getName() {
      Object var1 = this.name_;
      if(var1 instanceof String) {
         return (String)var1;
      } else {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.name_ = var3;
         }

         return var3;
      }
   }

   public ByteString getNameBytes() {
      Object var1 = this.name_;
      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         this.name_ = var2;
         return var2;
      } else {
         return (ByteString)var1;
      }
   }

   public boolean hasValue() {
      return this.value_ != null;
   }

   public Any getValue() {
      return this.value_ == null?Any.getDefaultInstance():this.value_;
   }

   public AnyOrBuilder getValueOrBuilder() {
      return this.getValue();
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
      if(!this.getNameBytes().isEmpty()) {
         var1.writeBytes(1, this.getNameBytes());
      }

      if(this.value_ != null) {
         var1.writeMessage(2, this.getValue());
      }

   }

   public int getSerializedSize() {
      int var1 = this.memoizedSerializedSize;
      if(var1 != -1) {
         return var1;
      } else {
         var1 = 0;
         if(!this.getNameBytes().isEmpty()) {
            var1 += CodedOutputStream.computeBytesSize(1, this.getNameBytes());
         }

         if(this.value_ != null) {
            var1 += CodedOutputStream.computeMessageSize(2, this.getValue());
         }

         this.memoizedSerializedSize = var1;
         return var1;
      }
   }

   public static Option parseFrom(ByteString var0) {
      return (Option)PARSER.parseFrom(var0);
   }

   public static Option parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (Option)PARSER.parseFrom(var0, var1);
   }

   public static Option parseFrom(byte[] var0) {
      return (Option)PARSER.parseFrom(var0);
   }

   public static Option parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (Option)PARSER.parseFrom(var0, var1);
   }

   public static Option parseFrom(InputStream var0) {
      return (Option)PARSER.parseFrom(var0);
   }

   public static Option parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (Option)PARSER.parseFrom(var0, var1);
   }

   public static Option parseDelimitedFrom(InputStream var0) {
      return (Option)PARSER.parseDelimitedFrom(var0);
   }

   public static Option parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (Option)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static Option parseFrom(CodedInputStream var0) {
      return (Option)PARSER.parseFrom(var0);
   }

   public static Option parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (Option)PARSER.parseFrom(var0, var1);
   }

   public Option$Builder newBuilderForType() {
      return newBuilder();
   }

   public static Option$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static Option$Builder newBuilder(Option var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public Option$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new Option$Builder((Option$1)null):(new Option$Builder((Option$1)null)).mergeFrom(this);
   }

   protected Option$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      Option$Builder var2 = new Option$Builder(var1, (Option$1)null);
      return var2;
   }

   public static Option getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public Option getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   Option(GeneratedMessage$Builder var1, Option$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static Object access$302(Option var0, Object var1) {
      return var0.name_ = var1;
   }

   // $FF: synthetic method
   static Any access$402(Option var0, Any var1) {
      return var0.value_ = var1;
   }

   // $FF: synthetic method
   static Object access$300(Option var0) {
      return var0.name_;
   }

   // $FF: synthetic method
   Option(CodedInputStream var1, ExtensionRegistryLite var2, Option$1 var3) {
      this(var1, var2);
   }
}
