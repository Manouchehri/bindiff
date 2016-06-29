package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.FieldMask;
import com.google.protobuf.FieldMask$1;
import com.google.protobuf.FieldMaskOrBuilder;
import com.google.protobuf.FieldMaskProto;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;

public final class FieldMask$Builder extends GeneratedMessage$Builder implements FieldMaskOrBuilder {
   private int bitField0_;
   private LazyStringList paths_;

   public static final Descriptors$Descriptor getDescriptor() {
      return FieldMaskProto.internal_static_google_protobuf_FieldMask_descriptor;
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return FieldMaskProto.internal_static_google_protobuf_FieldMask_fieldAccessorTable.ensureFieldAccessorsInitialized(FieldMask.class, FieldMask$Builder.class);
   }

   private FieldMask$Builder() {
      this.paths_ = LazyStringArrayList.EMPTY;
      this.maybeForceBuilderInitialization();
   }

   private FieldMask$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.paths_ = LazyStringArrayList.EMPTY;
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(GeneratedMessage.alwaysUseFieldBuilders) {
         ;
      }

   }

   public FieldMask$Builder clear() {
      super.clear();
      this.paths_ = LazyStringArrayList.EMPTY;
      this.bitField0_ &= -2;
      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return FieldMaskProto.internal_static_google_protobuf_FieldMask_descriptor;
   }

   public FieldMask getDefaultInstanceForType() {
      return FieldMask.getDefaultInstance();
   }

   public FieldMask build() {
      FieldMask var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public FieldMask buildPartial() {
      FieldMask var1 = new FieldMask(this, (FieldMask$1)null);
      int var2 = this.bitField0_;
      if((this.bitField0_ & 1) == 1) {
         this.paths_ = this.paths_.getUnmodifiableView();
         this.bitField0_ &= -2;
      }

      FieldMask.access$302(var1, this.paths_);
      this.onBuilt();
      return var1;
   }

   public FieldMask$Builder mergeFrom(Message var1) {
      if(var1 instanceof FieldMask) {
         return this.mergeFrom((FieldMask)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public FieldMask$Builder mergeFrom(FieldMask var1) {
      if(var1 == FieldMask.getDefaultInstance()) {
         return this;
      } else {
         if(!FieldMask.access$300(var1).isEmpty()) {
            if(this.paths_.isEmpty()) {
               this.paths_ = FieldMask.access$300(var1);
               this.bitField0_ &= -2;
            } else {
               this.ensurePathsIsMutable();
               this.paths_.addAll(FieldMask.access$300(var1));
            }

            this.onChanged();
         }

         this.onChanged();
         return this;
      }
   }

   public final boolean isInitialized() {
      return true;
   }

   public FieldMask$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      FieldMask var3 = null;

      try {
         var3 = (FieldMask)FieldMask.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var9) {
         var3 = (FieldMask)var9.getUnfinishedMessage();
         throw var9;
      } finally {
         if(var3 != null) {
            this.mergeFrom(var3);
         }

      }

      return this;
   }

   private void ensurePathsIsMutable() {
      if((this.bitField0_ & 1) != 1) {
         this.paths_ = new LazyStringArrayList(this.paths_);
         this.bitField0_ |= 1;
      }

   }

   public ProtocolStringList getPathsList() {
      return this.paths_.getUnmodifiableView();
   }

   public int getPathsCount() {
      return this.paths_.size();
   }

   public String getPaths(int var1) {
      return (String)this.paths_.get(var1);
   }

   public ByteString getPathsBytes(int var1) {
      return this.paths_.getByteString(var1);
   }

   public FieldMask$Builder setPaths(int var1, String var2) {
      if(var2 == null) {
         throw new NullPointerException();
      } else {
         this.ensurePathsIsMutable();
         this.paths_.set(var1, (Object)var2);
         this.onChanged();
         return this;
      }
   }

   public FieldMask$Builder addPaths(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.ensurePathsIsMutable();
         this.paths_.add((Object)var1);
         this.onChanged();
         return this;
      }
   }

   public FieldMask$Builder addAllPaths(Iterable var1) {
      this.ensurePathsIsMutable();
      AbstractMessageLite$Builder.addAll(var1, this.paths_);
      this.onChanged();
      return this;
   }

   public FieldMask$Builder clearPaths() {
      this.paths_ = LazyStringArrayList.EMPTY;
      this.bitField0_ &= -2;
      this.onChanged();
      return this;
   }

   public FieldMask$Builder addPathsBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.ensurePathsIsMutable();
         this.paths_.add(var1);
         this.onChanged();
         return this;
      }
   }

   public final FieldMask$Builder setUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   public final FieldMask$Builder mergeUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   // $FF: synthetic method
   FieldMask$Builder(FieldMask$1 var1) {
      this();
   }

   // $FF: synthetic method
   FieldMask$Builder(GeneratedMessage$BuilderParent var1, FieldMask$1 var2) {
      this(var1);
   }
}
