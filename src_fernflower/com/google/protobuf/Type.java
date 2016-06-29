package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Field;
import com.google.protobuf.FieldOrBuilder;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Option;
import com.google.protobuf.OptionOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.SourceContext;
import com.google.protobuf.SourceContext$Builder;
import com.google.protobuf.SourceContextOrBuilder;
import com.google.protobuf.Type$1;
import com.google.protobuf.Type$Builder;
import com.google.protobuf.TypeOrBuilder;
import com.google.protobuf.TypeProto;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Type extends GeneratedMessage implements TypeOrBuilder {
   private int bitField0_;
   public static final int NAME_FIELD_NUMBER = 1;
   private volatile Object name_;
   public static final int FIELDS_FIELD_NUMBER = 2;
   private List fields_;
   public static final int ONEOFS_FIELD_NUMBER = 3;
   private LazyStringList oneofs_;
   public static final int OPTIONS_FIELD_NUMBER = 4;
   private List options_;
   public static final int SOURCE_CONTEXT_FIELD_NUMBER = 5;
   private SourceContext sourceContext_;
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final Type DEFAULT_INSTANCE = new Type();
   public static final Parser PARSER = new Type$1();

   private Type(GeneratedMessage$Builder var1) {
      super(var1);
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private Type() {
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
      this.name_ = "";
      this.fields_ = Collections.emptyList();
      this.oneofs_ = LazyStringArrayList.EMPTY;
      this.options_ = Collections.emptyList();
   }

   public final UnknownFieldSet getUnknownFields() {
      return UnknownFieldSet.getDefaultInstance();
   }

   private Type(CodedInputStream var1, ExtensionRegistryLite var2) {
      this();
      int var3 = 0;

      try {
         boolean var4 = false;

         while(!var4) {
            int var5 = var1.readTag();
            ByteString var15;
            switch(var5) {
            case 0:
               var4 = true;
               break;
            case 10:
               var15 = var1.readBytes();
               this.name_ = var15;
               break;
            case 18:
               if((var3 & 2) != 2) {
                  this.fields_ = new ArrayList();
                  var3 |= 2;
               }

               this.fields_.add(var1.readMessage(Field.PARSER, var2));
               break;
            case 26:
               var15 = var1.readBytes();
               if((var3 & 4) != 4) {
                  this.oneofs_ = new LazyStringArrayList();
                  var3 |= 4;
               }

               this.oneofs_.add(var15);
               break;
            case 34:
               if((var3 & 8) != 8) {
                  this.options_ = new ArrayList();
                  var3 |= 8;
               }

               this.options_.add(var1.readMessage(Option.PARSER, var2));
               break;
            case 42:
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
            this.fields_ = Collections.unmodifiableList(this.fields_);
         }

         if((var3 & 4) == 4) {
            this.oneofs_ = this.oneofs_.getUnmodifiableView();
         }

         if((var3 & 8) == 8) {
            this.options_ = Collections.unmodifiableList(this.options_);
         }

         this.makeExtensionsImmutable();
      }

   }

   public static final Descriptors$Descriptor getDescriptor() {
      return TypeProto.internal_static_google_protobuf_Type_descriptor;
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return TypeProto.internal_static_google_protobuf_Type_fieldAccessorTable.ensureFieldAccessorsInitialized(Type.class, Type$Builder.class);
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

   public List getFieldsList() {
      return this.fields_;
   }

   public List getFieldsOrBuilderList() {
      return this.fields_;
   }

   public int getFieldsCount() {
      return this.fields_.size();
   }

   public Field getFields(int var1) {
      return (Field)this.fields_.get(var1);
   }

   public FieldOrBuilder getFieldsOrBuilder(int var1) {
      return (FieldOrBuilder)this.fields_.get(var1);
   }

   public ProtocolStringList getOneofsList() {
      return this.oneofs_;
   }

   public int getOneofsCount() {
      return this.oneofs_.size();
   }

   public String getOneofs(int var1) {
      return (String)this.oneofs_.get(var1);
   }

   public ByteString getOneofsBytes(int var1) {
      return this.oneofs_.getByteString(var1);
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
      for(var2 = 0; var2 < this.fields_.size(); ++var2) {
         var1.writeMessage(2, (MessageLite)this.fields_.get(var2));
      }

      for(var2 = 0; var2 < this.oneofs_.size(); ++var2) {
         var1.writeBytes(3, this.oneofs_.getByteString(var2));
      }

      for(var2 = 0; var2 < this.options_.size(); ++var2) {
         var1.writeMessage(4, (MessageLite)this.options_.get(var2));
      }

      if(this.sourceContext_ != null) {
         var1.writeMessage(5, this.getSourceContext());
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
         for(var2 = 0; var2 < this.fields_.size(); ++var2) {
            var1 += CodedOutputStream.computeMessageSize(2, (MessageLite)this.fields_.get(var2));
         }

         var2 = 0;

         for(int var3 = 0; var3 < this.oneofs_.size(); ++var3) {
            var2 += CodedOutputStream.computeBytesSizeNoTag(this.oneofs_.getByteString(var3));
         }

         var1 += var2;
         var1 += 1 * this.getOneofsList().size();

         for(var2 = 0; var2 < this.options_.size(); ++var2) {
            var1 += CodedOutputStream.computeMessageSize(4, (MessageLite)this.options_.get(var2));
         }

         if(this.sourceContext_ != null) {
            var1 += CodedOutputStream.computeMessageSize(5, this.getSourceContext());
         }

         this.memoizedSerializedSize = var1;
         return var1;
      }
   }

   public static Type parseFrom(ByteString var0) {
      return (Type)PARSER.parseFrom(var0);
   }

   public static Type parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (Type)PARSER.parseFrom(var0, var1);
   }

   public static Type parseFrom(byte[] var0) {
      return (Type)PARSER.parseFrom(var0);
   }

   public static Type parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (Type)PARSER.parseFrom(var0, var1);
   }

   public static Type parseFrom(InputStream var0) {
      return (Type)PARSER.parseFrom(var0);
   }

   public static Type parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (Type)PARSER.parseFrom(var0, var1);
   }

   public static Type parseDelimitedFrom(InputStream var0) {
      return (Type)PARSER.parseDelimitedFrom(var0);
   }

   public static Type parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (Type)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static Type parseFrom(CodedInputStream var0) {
      return (Type)PARSER.parseFrom(var0);
   }

   public static Type parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (Type)PARSER.parseFrom(var0, var1);
   }

   public Type$Builder newBuilderForType() {
      return newBuilder();
   }

   public static Type$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static Type$Builder newBuilder(Type var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public Type$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new Type$Builder((Type$1)null):(new Type$Builder((Type$1)null)).mergeFrom(this);
   }

   protected Type$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      Type$Builder var2 = new Type$Builder(var1, (Type$1)null);
      return var2;
   }

   public static Type getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public Type getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   Type(GeneratedMessage$Builder var1, Type$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static Object access$302(Type var0, Object var1) {
      return var0.name_ = var1;
   }

   // $FF: synthetic method
   static List access$402(Type var0, List var1) {
      return var0.fields_ = var1;
   }

   // $FF: synthetic method
   static LazyStringList access$502(Type var0, LazyStringList var1) {
      return var0.oneofs_ = var1;
   }

   // $FF: synthetic method
   static List access$602(Type var0, List var1) {
      return var0.options_ = var1;
   }

   // $FF: synthetic method
   static SourceContext access$702(Type var0, SourceContext var1) {
      return var0.sourceContext_ = var1;
   }

   // $FF: synthetic method
   static int access$802(Type var0, int var1) {
      return var0.bitField0_ = var1;
   }

   // $FF: synthetic method
   static Object access$300(Type var0) {
      return var0.name_;
   }

   // $FF: synthetic method
   static List access$400(Type var0) {
      return var0.fields_;
   }

   // $FF: synthetic method
   static LazyStringList access$500(Type var0) {
      return var0.oneofs_;
   }

   // $FF: synthetic method
   static List access$600(Type var0) {
      return var0.options_;
   }

   // $FF: synthetic method
   Type(CodedInputStream var1, ExtensionRegistryLite var2, Type$1 var3) {
      this(var1, var2);
   }
}
