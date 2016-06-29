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
import com.google.protobuf.MapEntry;
import com.google.protobuf.MapField;
import com.google.protobuf.Parser;
import com.google.protobuf.Struct$1;
import com.google.protobuf.Struct$Builder;
import com.google.protobuf.Struct$FieldsDefaultEntryHolder;
import com.google.protobuf.StructOrBuilder;
import com.google.protobuf.StructProto;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public final class Struct extends GeneratedMessage implements StructOrBuilder {
   public static final int FIELDS_FIELD_NUMBER = 1;
   private MapField fields_;
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final Struct DEFAULT_INSTANCE = new Struct();
   public static final Parser PARSER = new Struct$1();

   private Struct(GeneratedMessage$Builder var1) {
      super(var1);
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private Struct() {
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   public final UnknownFieldSet getUnknownFields() {
      return UnknownFieldSet.getDefaultInstance();
   }

   private Struct(CodedInputStream var1, ExtensionRegistryLite var2) {
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
                  this.fields_ = MapField.newMapField(Struct$FieldsDefaultEntryHolder.defaultEntry);
                  var3 |= true;
               }

               MapEntry var6 = (MapEntry)var1.readMessage(Struct$FieldsDefaultEntryHolder.defaultEntry.getParserForType(), var2);
               this.fields_.getMutableMap().put(var6.getKey(), var6.getValue());
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
      return StructProto.internal_static_google_protobuf_Struct_descriptor;
   }

   protected MapField internalGetMapField(int var1) {
      switch(var1) {
      case 1:
         return this.internalGetFields();
      default:
         throw new RuntimeException((new StringBuilder(37)).append("Invalid map field number: ").append(var1).toString());
      }
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return StructProto.internal_static_google_protobuf_Struct_fieldAccessorTable.ensureFieldAccessorsInitialized(Struct.class, Struct$Builder.class);
   }

   private MapField internalGetFields() {
      return this.fields_ == null?MapField.emptyMapField(Struct$FieldsDefaultEntryHolder.defaultEntry):this.fields_;
   }

   public Map getFields() {
      return this.internalGetFields().getMap();
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
      Iterator var2 = this.internalGetFields().getMap().entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         MapEntry var4 = Struct$FieldsDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(var3.getKey()).setValue(var3.getValue()).build();
         var1.writeMessage(1, var4);
      }

   }

   public int getSerializedSize() {
      int var1 = this.memoizedSerializedSize;
      if(var1 != -1) {
         return var1;
      } else {
         var1 = 0;

         MapEntry var4;
         for(Iterator var2 = this.internalGetFields().getMap().entrySet().iterator(); var2.hasNext(); var1 += CodedOutputStream.computeMessageSize(1, var4)) {
            Entry var3 = (Entry)var2.next();
            var4 = Struct$FieldsDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(var3.getKey()).setValue(var3.getValue()).build();
         }

         this.memoizedSerializedSize = var1;
         return var1;
      }
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof Struct)) {
         return super.equals(var1);
      } else {
         Struct var2 = (Struct)var1;
         boolean var3 = true;
         var3 = var3 && this.internalGetFields().equals(var2.internalGetFields());
         return var3;
      }
   }

   public int hashCode() {
      if(this.memoizedHashCode != 0) {
         return this.memoizedHashCode;
      } else {
         byte var1 = 41;
         int var2 = 19 * var1 + this.getDescriptorForType().hashCode();
         if(!this.internalGetFields().getMap().isEmpty()) {
            var2 = 37 * var2 + 1;
            var2 = 53 * var2 + this.internalGetFields().hashCode();
         }

         var2 = 29 * var2 + this.unknownFields.hashCode();
         this.memoizedHashCode = var2;
         return var2;
      }
   }

   public static Struct parseFrom(ByteString var0) {
      return (Struct)PARSER.parseFrom(var0);
   }

   public static Struct parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (Struct)PARSER.parseFrom(var0, var1);
   }

   public static Struct parseFrom(byte[] var0) {
      return (Struct)PARSER.parseFrom(var0);
   }

   public static Struct parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (Struct)PARSER.parseFrom(var0, var1);
   }

   public static Struct parseFrom(InputStream var0) {
      return (Struct)PARSER.parseFrom(var0);
   }

   public static Struct parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (Struct)PARSER.parseFrom(var0, var1);
   }

   public static Struct parseDelimitedFrom(InputStream var0) {
      return (Struct)PARSER.parseDelimitedFrom(var0);
   }

   public static Struct parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (Struct)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static Struct parseFrom(CodedInputStream var0) {
      return (Struct)PARSER.parseFrom(var0);
   }

   public static Struct parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (Struct)PARSER.parseFrom(var0, var1);
   }

   public Struct$Builder newBuilderForType() {
      return newBuilder();
   }

   public static Struct$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static Struct$Builder newBuilder(Struct var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public Struct$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new Struct$Builder((Struct$1)null):(new Struct$Builder((Struct$1)null)).mergeFrom(this);
   }

   protected Struct$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      Struct$Builder var2 = new Struct$Builder(var1, (Struct$1)null);
      return var2;
   }

   public static Struct getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public Struct getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   Struct(GeneratedMessage$Builder var1, Struct$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static MapField access$302(Struct var0, MapField var1) {
      return var0.fields_ = var1;
   }

   // $FF: synthetic method
   static MapField access$300(Struct var0) {
      return var0.fields_;
   }

   // $FF: synthetic method
   static MapField access$400(Struct var0) {
      return var0.internalGetFields();
   }

   // $FF: synthetic method
   Struct(CodedInputStream var1, ExtensionRegistryLite var2, Struct$1 var3) {
      this(var1, var2);
   }
}
