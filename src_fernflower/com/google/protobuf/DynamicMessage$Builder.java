package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.Descriptors$FieldDescriptor$Type;
import com.google.protobuf.Descriptors$FileDescriptor$Syntax;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.DynamicMessage$1;
import com.google.protobuf.FieldSet;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.UnknownFieldSet;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class DynamicMessage$Builder extends AbstractMessage$Builder {
   private final Descriptors$Descriptor type;
   private FieldSet fields;
   private final Descriptors$FieldDescriptor[] oneofCases;
   private UnknownFieldSet unknownFields;

   private DynamicMessage$Builder(Descriptors$Descriptor var1) {
      this.type = var1;
      this.fields = FieldSet.newFieldSet();
      this.unknownFields = UnknownFieldSet.getDefaultInstance();
      this.oneofCases = new Descriptors$FieldDescriptor[var1.toProto().getOneofDeclCount()];
   }

   public DynamicMessage$Builder clear() {
      if(this.fields.isImmutable()) {
         this.fields = FieldSet.newFieldSet();
      } else {
         this.fields.clear();
      }

      this.unknownFields = UnknownFieldSet.getDefaultInstance();
      return this;
   }

   public DynamicMessage$Builder mergeFrom(Message var1) {
      if(var1 instanceof DynamicMessage) {
         DynamicMessage var2 = (DynamicMessage)var1;
         if(DynamicMessage.access$200(var2) != this.type) {
            throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
         } else {
            this.ensureIsMutable();
            this.fields.mergeFrom(DynamicMessage.access$300(var2));
            this.mergeUnknownFields(DynamicMessage.access$400(var2));

            for(int var3 = 0; var3 < this.oneofCases.length; ++var3) {
               if(this.oneofCases[var3] == null) {
                  this.oneofCases[var3] = DynamicMessage.access$500(var2)[var3];
               } else if(DynamicMessage.access$500(var2)[var3] != null && this.oneofCases[var3] != DynamicMessage.access$500(var2)[var3]) {
                  this.fields.clearField(this.oneofCases[var3]);
                  this.oneofCases[var3] = DynamicMessage.access$500(var2)[var3];
               }
            }

            return this;
         }
      } else {
         return (DynamicMessage$Builder)super.mergeFrom(var1);
      }
   }

   public DynamicMessage build() {
      if(!this.isInitialized()) {
         throw newUninitializedMessageException(new DynamicMessage(this.type, this.fields, (Descriptors$FieldDescriptor[])Arrays.copyOf(this.oneofCases, this.oneofCases.length), this.unknownFields));
      } else {
         return this.buildPartial();
      }
   }

   private DynamicMessage buildParsed() {
      if(!this.isInitialized()) {
         throw newUninitializedMessageException(new DynamicMessage(this.type, this.fields, (Descriptors$FieldDescriptor[])Arrays.copyOf(this.oneofCases, this.oneofCases.length), this.unknownFields)).asInvalidProtocolBufferException();
      } else {
         return this.buildPartial();
      }
   }

   public DynamicMessage buildPartial() {
      this.fields.makeImmutable();
      DynamicMessage var1 = new DynamicMessage(this.type, this.fields, (Descriptors$FieldDescriptor[])Arrays.copyOf(this.oneofCases, this.oneofCases.length), this.unknownFields);
      return var1;
   }

   public DynamicMessage$Builder clone() {
      DynamicMessage$Builder var1 = new DynamicMessage$Builder(this.type);
      var1.fields.mergeFrom(this.fields);
      var1.mergeUnknownFields(this.unknownFields);
      System.arraycopy(this.oneofCases, 0, var1.oneofCases, 0, this.oneofCases.length);
      return var1;
   }

   public boolean isInitialized() {
      return DynamicMessage.isInitialized(this.type, this.fields);
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return this.type;
   }

   public DynamicMessage getDefaultInstanceForType() {
      return DynamicMessage.getDefaultInstance(this.type);
   }

   public Map getAllFields() {
      return this.fields.getAllFields();
   }

   public DynamicMessage$Builder newBuilderForField(Descriptors$FieldDescriptor var1) {
      this.verifyContainingType(var1);
      if(var1.getJavaType() != Descriptors$FieldDescriptor$JavaType.MESSAGE) {
         throw new IllegalArgumentException("newBuilderForField is only valid for fields with message type.");
      } else {
         return new DynamicMessage$Builder(var1.getMessageType());
      }
   }

   public boolean hasOneof(Descriptors$OneofDescriptor var1) {
      this.verifyOneofContainingType(var1);
      Descriptors$FieldDescriptor var2 = this.oneofCases[var1.getIndex()];
      return var2 != null;
   }

   public Descriptors$FieldDescriptor getOneofFieldDescriptor(Descriptors$OneofDescriptor var1) {
      this.verifyOneofContainingType(var1);
      return this.oneofCases[var1.getIndex()];
   }

   public DynamicMessage$Builder clearOneof(Descriptors$OneofDescriptor var1) {
      this.verifyOneofContainingType(var1);
      Descriptors$FieldDescriptor var2 = this.oneofCases[var1.getIndex()];
      if(var2 != null) {
         this.clearField(var2);
      }

      return this;
   }

   public boolean hasField(Descriptors$FieldDescriptor var1) {
      this.verifyContainingType(var1);
      return this.fields.hasField(var1);
   }

   public Object getField(Descriptors$FieldDescriptor var1) {
      this.verifyContainingType(var1);
      Object var2 = this.fields.getField(var1);
      if(var2 == null) {
         if(var1.isRepeated()) {
            var2 = Collections.emptyList();
         } else if(var1.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE) {
            var2 = DynamicMessage.getDefaultInstance(var1.getMessageType());
         } else {
            var2 = var1.getDefaultValue();
         }
      }

      return var2;
   }

   public DynamicMessage$Builder setField(Descriptors$FieldDescriptor var1, Object var2) {
      this.verifyContainingType(var1);
      this.ensureIsMutable();
      if(var1.getType() == Descriptors$FieldDescriptor$Type.ENUM) {
         this.ensureEnumValueDescriptor(var1, var2);
      }

      Descriptors$OneofDescriptor var3 = var1.getContainingOneof();
      if(var3 != null) {
         int var4 = var3.getIndex();
         Descriptors$FieldDescriptor var5 = this.oneofCases[var4];
         if(var5 != null && var5 != var1) {
            this.fields.clearField(var5);
         }

         this.oneofCases[var4] = var1;
      }

      this.fields.setField(var1, var2);
      return this;
   }

   public DynamicMessage$Builder clearField(Descriptors$FieldDescriptor var1) {
      this.verifyContainingType(var1);
      this.ensureIsMutable();
      Descriptors$OneofDescriptor var2 = var1.getContainingOneof();
      if(var2 != null) {
         int var3 = var2.getIndex();
         if(this.oneofCases[var3] == var1) {
            this.oneofCases[var3] = null;
         }
      }

      this.fields.clearField(var1);
      return this;
   }

   public int getRepeatedFieldCount(Descriptors$FieldDescriptor var1) {
      this.verifyContainingType(var1);
      return this.fields.getRepeatedFieldCount(var1);
   }

   public Object getRepeatedField(Descriptors$FieldDescriptor var1, int var2) {
      this.verifyContainingType(var1);
      return this.fields.getRepeatedField(var1, var2);
   }

   public DynamicMessage$Builder setRepeatedField(Descriptors$FieldDescriptor var1, int var2, Object var3) {
      this.verifyContainingType(var1);
      this.ensureIsMutable();
      this.fields.setRepeatedField(var1, var2, var3);
      return this;
   }

   public DynamicMessage$Builder addRepeatedField(Descriptors$FieldDescriptor var1, Object var2) {
      this.verifyContainingType(var1);
      this.ensureIsMutable();
      this.fields.addRepeatedField(var1, var2);
      return this;
   }

   public UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   public DynamicMessage$Builder setUnknownFields(UnknownFieldSet var1) {
      if(this.getDescriptorForType().getFile().getSyntax() == Descriptors$FileDescriptor$Syntax.PROTO3) {
         return this;
      } else {
         this.unknownFields = var1;
         return this;
      }
   }

   public DynamicMessage$Builder mergeUnknownFields(UnknownFieldSet var1) {
      if(this.getDescriptorForType().getFile().getSyntax() == Descriptors$FileDescriptor$Syntax.PROTO3) {
         return this;
      } else {
         this.unknownFields = UnknownFieldSet.newBuilder(this.unknownFields).mergeFrom(var1).build();
         return this;
      }
   }

   private void verifyContainingType(Descriptors$FieldDescriptor var1) {
      if(var1.getContainingType() != this.type) {
         throw new IllegalArgumentException("FieldDescriptor does not match message type.");
      }
   }

   private void verifyOneofContainingType(Descriptors$OneofDescriptor var1) {
      if(var1.getContainingType() != this.type) {
         throw new IllegalArgumentException("OneofDescriptor does not match message type.");
      }
   }

   private void ensureSingularEnumValueDescriptor(Descriptors$FieldDescriptor var1, Object var2) {
      if(var2 == null) {
         throw new NullPointerException();
      } else if(!(var2 instanceof Descriptors$EnumValueDescriptor)) {
         throw new IllegalArgumentException("DynamicMessage should use EnumValueDescriptor to set Enum Value.");
      }
   }

   private void ensureEnumValueDescriptor(Descriptors$FieldDescriptor var1, Object var2) {
      if(var1.isRepeated()) {
         Iterator var3 = ((List)var2).iterator();

         while(var3.hasNext()) {
            Object var4 = var3.next();
            this.ensureSingularEnumValueDescriptor(var1, var4);
         }
      } else {
         this.ensureSingularEnumValueDescriptor(var1, var2);
      }

   }

   private void ensureIsMutable() {
      if(this.fields.isImmutable()) {
         this.fields = this.fields.clone();
      }

   }

   public Message$Builder getFieldBuilder(Descriptors$FieldDescriptor var1) {
      throw new UnsupportedOperationException("getFieldBuilder() called on a dynamic message type.");
   }

   public Message$Builder getRepeatedFieldBuilder(Descriptors$FieldDescriptor var1, int var2) {
      throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a dynamic message type.");
   }

   // $FF: synthetic method
   static DynamicMessage access$000(DynamicMessage$Builder var0) {
      return var0.buildParsed();
   }

   // $FF: synthetic method
   DynamicMessage$Builder(Descriptors$Descriptor var1, DynamicMessage$1 var2) {
      this(var1);
   }
}
