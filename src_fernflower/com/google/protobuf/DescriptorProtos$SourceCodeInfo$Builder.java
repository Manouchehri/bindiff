package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo$Location;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo$Location$Builder;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder;
import com.google.protobuf.DescriptorProtos$SourceCodeInfoOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.RepeatedFieldBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$SourceCodeInfo$Builder extends GeneratedMessage$Builder implements DescriptorProtos$SourceCodeInfoOrBuilder {
   private int bitField0_;
   private List location_;
   private RepeatedFieldBuilder locationBuilder_;

   public static final Descriptors$Descriptor getDescriptor() {
      return DescriptorProtos.access$23600();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return DescriptorProtos.access$23700().ensureFieldAccessorsInitialized(DescriptorProtos$SourceCodeInfo.class, DescriptorProtos$SourceCodeInfo$Builder.class);
   }

   private DescriptorProtos$SourceCodeInfo$Builder() {
      this.location_ = Collections.emptyList();
      this.maybeForceBuilderInitialization();
   }

   private DescriptorProtos$SourceCodeInfo$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.location_ = Collections.emptyList();
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(GeneratedMessage.alwaysUseFieldBuilders) {
         this.getLocationFieldBuilder();
      }

   }

   public DescriptorProtos$SourceCodeInfo$Builder clear() {
      super.clear();
      if(this.locationBuilder_ == null) {
         this.location_ = Collections.emptyList();
         this.bitField0_ &= -2;
      } else {
         this.locationBuilder_.clear();
      }

      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return DescriptorProtos.access$23600();
   }

   public DescriptorProtos$SourceCodeInfo getDefaultInstanceForType() {
      return DescriptorProtos$SourceCodeInfo.getDefaultInstance();
   }

   public DescriptorProtos$SourceCodeInfo build() {
      DescriptorProtos$SourceCodeInfo var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public DescriptorProtos$SourceCodeInfo buildPartial() {
      DescriptorProtos$SourceCodeInfo var1 = new DescriptorProtos$SourceCodeInfo(this, (DescriptorProtos$1)null);
      int var2 = this.bitField0_;
      if(this.locationBuilder_ == null) {
         if((this.bitField0_ & 1) == 1) {
            this.location_ = Collections.unmodifiableList(this.location_);
            this.bitField0_ &= -2;
         }

         DescriptorProtos$SourceCodeInfo.access$25302(var1, this.location_);
      } else {
         DescriptorProtos$SourceCodeInfo.access$25302(var1, this.locationBuilder_.build());
      }

      this.onBuilt();
      return var1;
   }

   public DescriptorProtos$SourceCodeInfo$Builder mergeFrom(Message var1) {
      if(var1 instanceof DescriptorProtos$SourceCodeInfo) {
         return this.mergeFrom((DescriptorProtos$SourceCodeInfo)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public DescriptorProtos$SourceCodeInfo$Builder mergeFrom(DescriptorProtos$SourceCodeInfo var1) {
      if(var1 == DescriptorProtos$SourceCodeInfo.getDefaultInstance()) {
         return this;
      } else {
         if(this.locationBuilder_ == null) {
            if(!DescriptorProtos$SourceCodeInfo.access$25300(var1).isEmpty()) {
               if(this.location_.isEmpty()) {
                  this.location_ = DescriptorProtos$SourceCodeInfo.access$25300(var1);
                  this.bitField0_ &= -2;
               } else {
                  this.ensureLocationIsMutable();
                  this.location_.addAll(DescriptorProtos$SourceCodeInfo.access$25300(var1));
               }

               this.onChanged();
            }
         } else if(!DescriptorProtos$SourceCodeInfo.access$25300(var1).isEmpty()) {
            if(this.locationBuilder_.isEmpty()) {
               this.locationBuilder_.dispose();
               this.locationBuilder_ = null;
               this.location_ = DescriptorProtos$SourceCodeInfo.access$25300(var1);
               this.bitField0_ &= -2;
               this.locationBuilder_ = GeneratedMessage.alwaysUseFieldBuilders?this.getLocationFieldBuilder():null;
            } else {
               this.locationBuilder_.addAllMessages(DescriptorProtos$SourceCodeInfo.access$25300(var1));
            }
         }

         this.mergeUnknownFields(var1.unknownFields);
         this.onChanged();
         return this;
      }
   }

   public final boolean isInitialized() {
      return true;
   }

   public DescriptorProtos$SourceCodeInfo$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      DescriptorProtos$SourceCodeInfo var3 = null;

      try {
         var3 = (DescriptorProtos$SourceCodeInfo)DescriptorProtos$SourceCodeInfo.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var9) {
         var3 = (DescriptorProtos$SourceCodeInfo)var9.getUnfinishedMessage();
         throw var9;
      } finally {
         if(var3 != null) {
            this.mergeFrom(var3);
         }

      }

      return this;
   }

   private void ensureLocationIsMutable() {
      if((this.bitField0_ & 1) != 1) {
         this.location_ = new ArrayList(this.location_);
         this.bitField0_ |= 1;
      }

   }

   public List getLocationList() {
      return this.locationBuilder_ == null?Collections.unmodifiableList(this.location_):this.locationBuilder_.getMessageList();
   }

   public int getLocationCount() {
      return this.locationBuilder_ == null?this.location_.size():this.locationBuilder_.getCount();
   }

   public DescriptorProtos$SourceCodeInfo$Location getLocation(int var1) {
      return this.locationBuilder_ == null?(DescriptorProtos$SourceCodeInfo$Location)this.location_.get(var1):(DescriptorProtos$SourceCodeInfo$Location)this.locationBuilder_.getMessage(var1);
   }

   public DescriptorProtos$SourceCodeInfo$Builder setLocation(int var1, DescriptorProtos$SourceCodeInfo$Location var2) {
      if(this.locationBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureLocationIsMutable();
         this.location_.set(var1, var2);
         this.onChanged();
      } else {
         this.locationBuilder_.setMessage(var1, var2);
      }

      return this;
   }

   public DescriptorProtos$SourceCodeInfo$Builder setLocation(int var1, DescriptorProtos$SourceCodeInfo$Location$Builder var2) {
      if(this.locationBuilder_ == null) {
         this.ensureLocationIsMutable();
         this.location_.set(var1, var2.build());
         this.onChanged();
      } else {
         this.locationBuilder_.setMessage(var1, var2.build());
      }

      return this;
   }

   public DescriptorProtos$SourceCodeInfo$Builder addLocation(DescriptorProtos$SourceCodeInfo$Location var1) {
      if(this.locationBuilder_ == null) {
         if(var1 == null) {
            throw new NullPointerException();
         }

         this.ensureLocationIsMutable();
         this.location_.add(var1);
         this.onChanged();
      } else {
         this.locationBuilder_.addMessage(var1);
      }

      return this;
   }

   public DescriptorProtos$SourceCodeInfo$Builder addLocation(int var1, DescriptorProtos$SourceCodeInfo$Location var2) {
      if(this.locationBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureLocationIsMutable();
         this.location_.add(var1, var2);
         this.onChanged();
      } else {
         this.locationBuilder_.addMessage(var1, var2);
      }

      return this;
   }

   public DescriptorProtos$SourceCodeInfo$Builder addLocation(DescriptorProtos$SourceCodeInfo$Location$Builder var1) {
      if(this.locationBuilder_ == null) {
         this.ensureLocationIsMutable();
         this.location_.add(var1.build());
         this.onChanged();
      } else {
         this.locationBuilder_.addMessage(var1.build());
      }

      return this;
   }

   public DescriptorProtos$SourceCodeInfo$Builder addLocation(int var1, DescriptorProtos$SourceCodeInfo$Location$Builder var2) {
      if(this.locationBuilder_ == null) {
         this.ensureLocationIsMutable();
         this.location_.add(var1, var2.build());
         this.onChanged();
      } else {
         this.locationBuilder_.addMessage(var1, var2.build());
      }

      return this;
   }

   public DescriptorProtos$SourceCodeInfo$Builder addAllLocation(Iterable var1) {
      if(this.locationBuilder_ == null) {
         this.ensureLocationIsMutable();
         AbstractMessageLite$Builder.addAll(var1, this.location_);
         this.onChanged();
      } else {
         this.locationBuilder_.addAllMessages(var1);
      }

      return this;
   }

   public DescriptorProtos$SourceCodeInfo$Builder clearLocation() {
      if(this.locationBuilder_ == null) {
         this.location_ = Collections.emptyList();
         this.bitField0_ &= -2;
         this.onChanged();
      } else {
         this.locationBuilder_.clear();
      }

      return this;
   }

   public DescriptorProtos$SourceCodeInfo$Builder removeLocation(int var1) {
      if(this.locationBuilder_ == null) {
         this.ensureLocationIsMutable();
         this.location_.remove(var1);
         this.onChanged();
      } else {
         this.locationBuilder_.remove(var1);
      }

      return this;
   }

   public DescriptorProtos$SourceCodeInfo$Location$Builder getLocationBuilder(int var1) {
      return (DescriptorProtos$SourceCodeInfo$Location$Builder)this.getLocationFieldBuilder().getBuilder(var1);
   }

   public DescriptorProtos$SourceCodeInfo$LocationOrBuilder getLocationOrBuilder(int var1) {
      return this.locationBuilder_ == null?(DescriptorProtos$SourceCodeInfo$LocationOrBuilder)this.location_.get(var1):(DescriptorProtos$SourceCodeInfo$LocationOrBuilder)this.locationBuilder_.getMessageOrBuilder(var1);
   }

   public List getLocationOrBuilderList() {
      return this.locationBuilder_ != null?this.locationBuilder_.getMessageOrBuilderList():Collections.unmodifiableList(this.location_);
   }

   public DescriptorProtos$SourceCodeInfo$Location$Builder addLocationBuilder() {
      return (DescriptorProtos$SourceCodeInfo$Location$Builder)this.getLocationFieldBuilder().addBuilder(DescriptorProtos$SourceCodeInfo$Location.getDefaultInstance());
   }

   public DescriptorProtos$SourceCodeInfo$Location$Builder addLocationBuilder(int var1) {
      return (DescriptorProtos$SourceCodeInfo$Location$Builder)this.getLocationFieldBuilder().addBuilder(var1, DescriptorProtos$SourceCodeInfo$Location.getDefaultInstance());
   }

   public List getLocationBuilderList() {
      return this.getLocationFieldBuilder().getBuilderList();
   }

   private RepeatedFieldBuilder getLocationFieldBuilder() {
      if(this.locationBuilder_ == null) {
         this.locationBuilder_ = new RepeatedFieldBuilder(this.location_, (this.bitField0_ & 1) == 1, this.getParentForChildren(), this.isClean());
         this.location_ = null;
      }

      return this.locationBuilder_;
   }

   // $FF: synthetic method
   DescriptorProtos$SourceCodeInfo$Builder(DescriptorProtos$1 var1) {
      this();
   }

   // $FF: synthetic method
   DescriptorProtos$SourceCodeInfo$Builder(GeneratedMessage$BuilderParent var1, DescriptorProtos$1 var2) {
      this(var1);
   }
}
