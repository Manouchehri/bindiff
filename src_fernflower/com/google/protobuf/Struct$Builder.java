package com.google.protobuf;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapField;
import com.google.protobuf.Message;
import com.google.protobuf.Struct;
import com.google.protobuf.Struct$1;
import com.google.protobuf.Struct$FieldsDefaultEntryHolder;
import com.google.protobuf.StructOrBuilder;
import com.google.protobuf.StructProto;
import com.google.protobuf.UnknownFieldSet;
import java.util.Map;

public final class Struct$Builder extends GeneratedMessage$Builder implements StructOrBuilder {
   private int bitField0_;
   private MapField fields_;

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

   protected MapField internalGetMutableMapField(int var1) {
      switch(var1) {
      case 1:
         return this.internalGetMutableFields();
      default:
         throw new RuntimeException((new StringBuilder(37)).append("Invalid map field number: ").append(var1).toString());
      }
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return StructProto.internal_static_google_protobuf_Struct_fieldAccessorTable.ensureFieldAccessorsInitialized(Struct.class, Struct$Builder.class);
   }

   private Struct$Builder() {
      this.maybeForceBuilderInitialization();
   }

   private Struct$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(GeneratedMessage.alwaysUseFieldBuilders) {
         ;
      }

   }

   public Struct$Builder clear() {
      super.clear();
      this.internalGetMutableFields().clear();
      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return StructProto.internal_static_google_protobuf_Struct_descriptor;
   }

   public Struct getDefaultInstanceForType() {
      return Struct.getDefaultInstance();
   }

   public Struct build() {
      Struct var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public Struct buildPartial() {
      Struct var1 = new Struct(this, (Struct$1)null);
      int var2 = this.bitField0_;
      Struct.access$302(var1, this.internalGetFields());
      Struct.access$300(var1).makeImmutable();
      this.onBuilt();
      return var1;
   }

   public Struct$Builder mergeFrom(Message var1) {
      if(var1 instanceof Struct) {
         return this.mergeFrom((Struct)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public Struct$Builder mergeFrom(Struct var1) {
      if(var1 == Struct.getDefaultInstance()) {
         return this;
      } else {
         this.internalGetMutableFields().mergeFrom(Struct.access$400(var1));
         this.onChanged();
         return this;
      }
   }

   public final boolean isInitialized() {
      return true;
   }

   public Struct$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      Struct var3 = null;

      try {
         var3 = (Struct)Struct.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var9) {
         var3 = (Struct)var9.getUnfinishedMessage();
         throw var9;
      } finally {
         if(var3 != null) {
            this.mergeFrom(var3);
         }

      }

      return this;
   }

   private MapField internalGetFields() {
      return this.fields_ == null?MapField.emptyMapField(Struct$FieldsDefaultEntryHolder.defaultEntry):this.fields_;
   }

   private MapField internalGetMutableFields() {
      this.onChanged();
      if(this.fields_ == null) {
         this.fields_ = MapField.newMapField(Struct$FieldsDefaultEntryHolder.defaultEntry);
      }

      if(!this.fields_.isMutable()) {
         this.fields_ = this.fields_.copy();
      }

      return this.fields_;
   }

   public Map getFields() {
      return this.internalGetFields().getMap();
   }

   public Map getMutableFields() {
      return this.internalGetMutableFields().getMutableMap();
   }

   public final Struct$Builder setUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   public final Struct$Builder mergeUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   // $FF: synthetic method
   Struct$Builder(Struct$1 var1) {
      this();
   }

   // $FF: synthetic method
   Struct$Builder(GeneratedMessage$BuilderParent var1, Struct$1 var2) {
      this(var1);
   }
}
