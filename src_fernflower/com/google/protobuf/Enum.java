package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Enum$1;
import com.google.protobuf.Enum$Builder;
import com.google.protobuf.EnumOrBuilder;
import com.google.protobuf.EnumValue;
import com.google.protobuf.EnumValueOrBuilder;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Option;
import com.google.protobuf.OptionOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.SourceContext;
import com.google.protobuf.SourceContext$Builder;
import com.google.protobuf.SourceContextOrBuilder;
import com.google.protobuf.TypeProto;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Enum extends GeneratedMessage implements EnumOrBuilder {
   private int bitField0_;
   public static final int NAME_FIELD_NUMBER = 1;
   private volatile Object name_;
   public static final int ENUMVALUE_FIELD_NUMBER = 2;
   private List enumvalue_;
   public static final int OPTIONS_FIELD_NUMBER = 3;
   private List options_;
   public static final int SOURCE_CONTEXT_FIELD_NUMBER = 4;
   private SourceContext sourceContext_;
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final Enum DEFAULT_INSTANCE = new Enum();
   public static final Parser PARSER = new Enum$1();

   private Enum(GeneratedMessage$Builder var1) {
      super(var1);
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private Enum() {
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
      this.name_ = "";
      this.enumvalue_ = Collections.emptyList();
      this.options_ = Collections.emptyList();
   }

   public final UnknownFieldSet getUnknownFields() {
      return UnknownFieldSet.getDefaultInstance();
   }

   private Enum(CodedInputStream var1, ExtensionRegistryLite var2) {
      this();
      int var3 = 0;

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
               if((var3 & 2) != 2) {
                  this.enumvalue_ = new ArrayList();
                  var3 |= 2;
               }

               this.enumvalue_.add(var1.readMessage(EnumValue.PARSER, var2));
               break;
            case 26:
               if((var3 & 4) != 4) {
                  this.options_ = new ArrayList();
                  var3 |= 4;
               }

               this.options_.add(var1.readMessage(Option.PARSER, var2));
               break;
            case 34:
               SourceContext$Builder var6 = null;
               if(this.sourceContext_ != null) {
                  var6 = this.sourceContext_.toBuilder();
               }

               this.sourceContext_ = (SourceContext)var1.readMessage(SourceContext.PARSER, var2);
               if(var6 != null) {
                  var6.mergeFrom(this.sourceContext_);
                  this.sourceContext_ = var6.buildPartial();
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
         if((var3 & 2) == 2) {
            this.enumvalue_ = Collections.unmodifiableList(this.enumvalue_);
         }

         if((var3 & 4) == 4) {
            this.options_ = Collections.unmodifiableList(this.options_);
         }

         this.makeExtensionsImmutable();
      }

   }

   public static final Descriptors$Descriptor getDescriptor() {
      return TypeProto.internal_static_google_protobuf_Enum_descriptor;
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return TypeProto.internal_static_google_protobuf_Enum_fieldAccessorTable.ensureFieldAccessorsInitialized(Enum.class, Enum$Builder.class);
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

   public List getEnumvalueList() {
      return this.enumvalue_;
   }

   public List getEnumvalueOrBuilderList() {
      return this.enumvalue_;
   }

   public int getEnumvalueCount() {
      return this.enumvalue_.size();
   }

   public EnumValue getEnumvalue(int var1) {
      return (EnumValue)this.enumvalue_.get(var1);
   }

   public EnumValueOrBuilder getEnumvalueOrBuilder(int var1) {
      return (EnumValueOrBuilder)this.enumvalue_.get(var1);
   }

   public List getOptionsList() {
      return this.options_;
   }

   public List getOptionsOrBuilderList() {
      return this.options_;
   }

   public int getOptionsCount() {
      return this.options_.size();
   }

   public Option getOptions(int var1) {
      return (Option)this.options_.get(var1);
   }

   public OptionOrBuilder getOptionsOrBuilder(int var1) {
      return (OptionOrBuilder)this.options_.get(var1);
   }

   public boolean hasSourceContext() {
      return this.sourceContext_ != null;
   }

   public SourceContext getSourceContext() {
      return this.sourceContext_ == null?SourceContext.getDefaultInstance():this.sourceContext_;
   }

   public SourceContextOrBuilder getSourceContextOrBuilder() {
      return this.getSourceContext();
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

      int var2;
      for(var2 = 0; var2 < this.enumvalue_.size(); ++var2) {
         var1.writeMessage(2, (MessageLite)this.enumvalue_.get(var2));
      }

      for(var2 = 0; var2 < this.options_.size(); ++var2) {
         var1.writeMessage(3, (MessageLite)this.options_.get(var2));
      }

      if(this.sourceContext_ != null) {
         var1.writeMessage(4, this.getSourceContext());
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

         int var2;
         for(var2 = 0; var2 < this.enumvalue_.size(); ++var2) {
            var1 += CodedOutputStream.computeMessageSize(2, (MessageLite)this.enumvalue_.get(var2));
         }

         for(var2 = 0; var2 < this.options_.size(); ++var2) {
            var1 += CodedOutputStream.computeMessageSize(3, (MessageLite)this.options_.get(var2));
         }

         if(this.sourceContext_ != null) {
            var1 += CodedOutputStream.computeMessageSize(4, this.getSourceContext());
         }

         this.memoizedSerializedSize = var1;
         return var1;
      }
   }

   public static Enum parseFrom(ByteString var0) {
      return (Enum)PARSER.parseFrom(var0);
   }

   public static Enum parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (Enum)PARSER.parseFrom(var0, var1);
   }

   public static Enum parseFrom(byte[] var0) {
      return (Enum)PARSER.parseFrom(var0);
   }

   public static Enum parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (Enum)PARSER.parseFrom(var0, var1);
   }

   public static Enum parseFrom(InputStream var0) {
      return (Enum)PARSER.parseFrom(var0);
   }

   public static Enum parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (Enum)PARSER.parseFrom(var0, var1);
   }

   public static Enum parseDelimitedFrom(InputStream var0) {
      return (Enum)PARSER.parseDelimitedFrom(var0);
   }

   public static Enum parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (Enum)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static Enum parseFrom(CodedInputStream var0) {
      return (Enum)PARSER.parseFrom(var0);
   }

   public static Enum parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (Enum)PARSER.parseFrom(var0, var1);
   }

   public Enum$Builder newBuilderForType() {
      return newBuilder();
   }

   public static Enum$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static Enum$Builder newBuilder(Enum var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public Enum$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new Enum$Builder((Enum$1)null):(new Enum$Builder((Enum$1)null)).mergeFrom(this);
   }

   protected Enum$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      Enum$Builder var2 = new Enum$Builder(var1, (Enum$1)null);
      return var2;
   }

   public static Enum getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public Enum getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   Enum(GeneratedMessage$Builder var1, Enum$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static Object access$302(Enum var0, Object var1) {
      return var0.name_ = var1;
   }

   // $FF: synthetic method
   static List access$402(Enum var0, List var1) {
      return var0.enumvalue_ = var1;
   }

   // $FF: synthetic method
   static List access$502(Enum var0, List var1) {
      return var0.options_ = var1;
   }

   // $FF: synthetic method
   static SourceContext access$602(Enum var0, SourceContext var1) {
      return var0.sourceContext_ = var1;
   }

   // $FF: synthetic method
   static int access$702(Enum var0, int var1) {
      return var0.bitField0_ = var1;
   }

   // $FF: synthetic method
   static Object access$300(Enum var0) {
      return var0.name_;
   }

   // $FF: synthetic method
   static List access$400(Enum var0) {
      return var0.enumvalue_;
   }

   // $FF: synthetic method
   static List access$500(Enum var0) {
      return var0.options_;
   }

   // $FF: synthetic method
   Enum(CodedInputStream var1, ExtensionRegistryLite var2, Enum$1 var3) {
      this(var1, var2);
   }
}
