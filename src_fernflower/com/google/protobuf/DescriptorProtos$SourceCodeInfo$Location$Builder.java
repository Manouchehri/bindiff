package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo$Location;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.ProtocolStringList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$SourceCodeInfo$Location$Builder extends GeneratedMessage$Builder implements DescriptorProtos$SourceCodeInfo$LocationOrBuilder {
   private int bitField0_;
   private List path_;
   private List span_;
   private Object leadingComments_;
   private Object trailingComments_;
   private LazyStringList leadingDetachedComments_;

   public static final Descriptors$Descriptor getDescriptor() {
      return DescriptorProtos.access$23800();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return DescriptorProtos.access$23900().ensureFieldAccessorsInitialized(DescriptorProtos$SourceCodeInfo$Location.class, DescriptorProtos$SourceCodeInfo$Location$Builder.class);
   }

   private DescriptorProtos$SourceCodeInfo$Location$Builder() {
      this.path_ = Collections.emptyList();
      this.span_ = Collections.emptyList();
      this.leadingComments_ = "";
      this.trailingComments_ = "";
      this.leadingDetachedComments_ = LazyStringArrayList.EMPTY;
      this.maybeForceBuilderInitialization();
   }

   private DescriptorProtos$SourceCodeInfo$Location$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.path_ = Collections.emptyList();
      this.span_ = Collections.emptyList();
      this.leadingComments_ = "";
      this.trailingComments_ = "";
      this.leadingDetachedComments_ = LazyStringArrayList.EMPTY;
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(GeneratedMessage.alwaysUseFieldBuilders) {
         ;
      }

   }

   public DescriptorProtos$SourceCodeInfo$Location$Builder clear() {
      super.clear();
      this.path_ = Collections.emptyList();
      this.bitField0_ &= -2;
      this.span_ = Collections.emptyList();
      this.bitField0_ &= -3;
      this.leadingComments_ = "";
      this.bitField0_ &= -5;
      this.trailingComments_ = "";
      this.bitField0_ &= -9;
      this.leadingDetachedComments_ = LazyStringArrayList.EMPTY;
      this.bitField0_ &= -17;
      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return DescriptorProtos.access$23800();
   }

   public DescriptorProtos$SourceCodeInfo$Location getDefaultInstanceForType() {
      return DescriptorProtos$SourceCodeInfo$Location.getDefaultInstance();
   }

   public DescriptorProtos$SourceCodeInfo$Location build() {
      DescriptorProtos$SourceCodeInfo$Location var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public DescriptorProtos$SourceCodeInfo$Location buildPartial() {
      DescriptorProtos$SourceCodeInfo$Location var1 = new DescriptorProtos$SourceCodeInfo$Location(this, (DescriptorProtos$1)null);
      int var2 = this.bitField0_;
      int var3 = 0;
      if((this.bitField0_ & 1) == 1) {
         this.path_ = Collections.unmodifiableList(this.path_);
         this.bitField0_ &= -2;
      }

      DescriptorProtos$SourceCodeInfo$Location.access$24302(var1, this.path_);
      if((this.bitField0_ & 2) == 2) {
         this.span_ = Collections.unmodifiableList(this.span_);
         this.bitField0_ &= -3;
      }

      DescriptorProtos$SourceCodeInfo$Location.access$24402(var1, this.span_);
      if((var2 & 4) == 4) {
         var3 |= 1;
      }

      DescriptorProtos$SourceCodeInfo$Location.access$24502(var1, this.leadingComments_);
      if((var2 & 8) == 8) {
         var3 |= 2;
      }

      DescriptorProtos$SourceCodeInfo$Location.access$24602(var1, this.trailingComments_);
      if((this.bitField0_ & 16) == 16) {
         this.leadingDetachedComments_ = this.leadingDetachedComments_.getUnmodifiableView();
         this.bitField0_ &= -17;
      }

      DescriptorProtos$SourceCodeInfo$Location.access$24702(var1, this.leadingDetachedComments_);
      DescriptorProtos$SourceCodeInfo$Location.access$24802(var1, var3);
      this.onBuilt();
      return var1;
   }

   public DescriptorProtos$SourceCodeInfo$Location$Builder mergeFrom(Message var1) {
      if(var1 instanceof DescriptorProtos$SourceCodeInfo$Location) {
         return this.mergeFrom((DescriptorProtos$SourceCodeInfo$Location)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public DescriptorProtos$SourceCodeInfo$Location$Builder mergeFrom(DescriptorProtos$SourceCodeInfo$Location var1) {
      if(var1 == DescriptorProtos$SourceCodeInfo$Location.getDefaultInstance()) {
         return this;
      } else {
         if(!DescriptorProtos$SourceCodeInfo$Location.access$24300(var1).isEmpty()) {
            if(this.path_.isEmpty()) {
               this.path_ = DescriptorProtos$SourceCodeInfo$Location.access$24300(var1);
               this.bitField0_ &= -2;
            } else {
               this.ensurePathIsMutable();
               this.path_.addAll(DescriptorProtos$SourceCodeInfo$Location.access$24300(var1));
            }

            this.onChanged();
         }

         if(!DescriptorProtos$SourceCodeInfo$Location.access$24400(var1).isEmpty()) {
            if(this.span_.isEmpty()) {
               this.span_ = DescriptorProtos$SourceCodeInfo$Location.access$24400(var1);
               this.bitField0_ &= -3;
            } else {
               this.ensureSpanIsMutable();
               this.span_.addAll(DescriptorProtos$SourceCodeInfo$Location.access$24400(var1));
            }

            this.onChanged();
         }

         if(var1.hasLeadingComments()) {
            this.bitField0_ |= 4;
            this.leadingComments_ = DescriptorProtos$SourceCodeInfo$Location.access$24500(var1);
            this.onChanged();
         }

         if(var1.hasTrailingComments()) {
            this.bitField0_ |= 8;
            this.trailingComments_ = DescriptorProtos$SourceCodeInfo$Location.access$24600(var1);
            this.onChanged();
         }

         if(!DescriptorProtos$SourceCodeInfo$Location.access$24700(var1).isEmpty()) {
            if(this.leadingDetachedComments_.isEmpty()) {
               this.leadingDetachedComments_ = DescriptorProtos$SourceCodeInfo$Location.access$24700(var1);
               this.bitField0_ &= -17;
            } else {
               this.ensureLeadingDetachedCommentsIsMutable();
               this.leadingDetachedComments_.addAll(DescriptorProtos$SourceCodeInfo$Location.access$24700(var1));
            }

            this.onChanged();
         }

         this.mergeUnknownFields(var1.unknownFields);
         this.onChanged();
         return this;
      }
   }

   public final boolean isInitialized() {
      return true;
   }

   public DescriptorProtos$SourceCodeInfo$Location$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      DescriptorProtos$SourceCodeInfo$Location var3 = null;

      try {
         var3 = (DescriptorProtos$SourceCodeInfo$Location)DescriptorProtos$SourceCodeInfo$Location.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var9) {
         var3 = (DescriptorProtos$SourceCodeInfo$Location)var9.getUnfinishedMessage();
         throw var9;
      } finally {
         if(var3 != null) {
            this.mergeFrom(var3);
         }

      }

      return this;
   }

   private void ensurePathIsMutable() {
      if((this.bitField0_ & 1) != 1) {
         this.path_ = new ArrayList(this.path_);
         this.bitField0_ |= 1;
      }

   }

   public List getPathList() {
      return Collections.unmodifiableList(this.path_);
   }

   public int getPathCount() {
      return this.path_.size();
   }

   public int getPath(int var1) {
      return ((Integer)this.path_.get(var1)).intValue();
   }

   public DescriptorProtos$SourceCodeInfo$Location$Builder setPath(int var1, int var2) {
      this.ensurePathIsMutable();
      this.path_.set(var1, Integer.valueOf(var2));
      this.onChanged();
      return this;
   }

   public DescriptorProtos$SourceCodeInfo$Location$Builder addPath(int var1) {
      this.ensurePathIsMutable();
      this.path_.add(Integer.valueOf(var1));
      this.onChanged();
      return this;
   }

   public DescriptorProtos$SourceCodeInfo$Location$Builder addAllPath(Iterable var1) {
      this.ensurePathIsMutable();
      AbstractMessageLite$Builder.addAll(var1, this.path_);
      this.onChanged();
      return this;
   }

   public DescriptorProtos$SourceCodeInfo$Location$Builder clearPath() {
      this.path_ = Collections.emptyList();
      this.bitField0_ &= -2;
      this.onChanged();
      return this;
   }

   private void ensureSpanIsMutable() {
      if((this.bitField0_ & 2) != 2) {
         this.span_ = new ArrayList(this.span_);
         this.bitField0_ |= 2;
      }

   }

   public List getSpanList() {
      return Collections.unmodifiableList(this.span_);
   }

   public int getSpanCount() {
      return this.span_.size();
   }

   public int getSpan(int var1) {
      return ((Integer)this.span_.get(var1)).intValue();
   }

   public DescriptorProtos$SourceCodeInfo$Location$Builder setSpan(int var1, int var2) {
      this.ensureSpanIsMutable();
      this.span_.set(var1, Integer.valueOf(var2));
      this.onChanged();
      return this;
   }

   public DescriptorProtos$SourceCodeInfo$Location$Builder addSpan(int var1) {
      this.ensureSpanIsMutable();
      this.span_.add(Integer.valueOf(var1));
      this.onChanged();
      return this;
   }

   public DescriptorProtos$SourceCodeInfo$Location$Builder addAllSpan(Iterable var1) {
      this.ensureSpanIsMutable();
      AbstractMessageLite$Builder.addAll(var1, this.span_);
      this.onChanged();
      return this;
   }

   public DescriptorProtos$SourceCodeInfo$Location$Builder clearSpan() {
      this.span_ = Collections.emptyList();
      this.bitField0_ &= -3;
      this.onChanged();
      return this;
   }

   public boolean hasLeadingComments() {
      return (this.bitField0_ & 4) == 4;
   }

   public String getLeadingComments() {
      Object var1 = this.leadingComments_;
      if(!(var1 instanceof String)) {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.leadingComments_ = var3;
         }

         return var3;
      } else {
         return (String)var1;
      }
   }

   public ByteString getLeadingCommentsBytes() {
      Object var1 = this.leadingComments_;
      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         this.leadingComments_ = var2;
         return var2;
      } else {
         return (ByteString)var1;
      }
   }

   public DescriptorProtos$SourceCodeInfo$Location$Builder setLeadingComments(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 4;
         this.leadingComments_ = var1;
         this.onChanged();
         return this;
      }
   }

   public DescriptorProtos$SourceCodeInfo$Location$Builder clearLeadingComments() {
      this.bitField0_ &= -5;
      this.leadingComments_ = DescriptorProtos$SourceCodeInfo$Location.getDefaultInstance().getLeadingComments();
      this.onChanged();
      return this;
   }

   public DescriptorProtos$SourceCodeInfo$Location$Builder setLeadingCommentsBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 4;
         this.leadingComments_ = var1;
         this.onChanged();
         return this;
      }
   }

   public boolean hasTrailingComments() {
      return (this.bitField0_ & 8) == 8;
   }

   public String getTrailingComments() {
      Object var1 = this.trailingComments_;
      if(!(var1 instanceof String)) {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.trailingComments_ = var3;
         }

         return var3;
      } else {
         return (String)var1;
      }
   }

   public ByteString getTrailingCommentsBytes() {
      Object var1 = this.trailingComments_;
      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         this.trailingComments_ = var2;
         return var2;
      } else {
         return (ByteString)var1;
      }
   }

   public DescriptorProtos$SourceCodeInfo$Location$Builder setTrailingComments(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 8;
         this.trailingComments_ = var1;
         this.onChanged();
         return this;
      }
   }

   public DescriptorProtos$SourceCodeInfo$Location$Builder clearTrailingComments() {
      this.bitField0_ &= -9;
      this.trailingComments_ = DescriptorProtos$SourceCodeInfo$Location.getDefaultInstance().getTrailingComments();
      this.onChanged();
      return this;
   }

   public DescriptorProtos$SourceCodeInfo$Location$Builder setTrailingCommentsBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 8;
         this.trailingComments_ = var1;
         this.onChanged();
         return this;
      }
   }

   private void ensureLeadingDetachedCommentsIsMutable() {
      if((this.bitField0_ & 16) != 16) {
         this.leadingDetachedComments_ = new LazyStringArrayList(this.leadingDetachedComments_);
         this.bitField0_ |= 16;
      }

   }

   public ProtocolStringList getLeadingDetachedCommentsList() {
      return this.leadingDetachedComments_.getUnmodifiableView();
   }

   public int getLeadingDetachedCommentsCount() {
      return this.leadingDetachedComments_.size();
   }

   public String getLeadingDetachedComments(int var1) {
      return (String)this.leadingDetachedComments_.get(var1);
   }

   public ByteString getLeadingDetachedCommentsBytes(int var1) {
      return this.leadingDetachedComments_.getByteString(var1);
   }

   public DescriptorProtos$SourceCodeInfo$Location$Builder setLeadingDetachedComments(int var1, String var2) {
      if(var2 == null) {
         throw new NullPointerException();
      } else {
         this.ensureLeadingDetachedCommentsIsMutable();
         this.leadingDetachedComments_.set(var1, (Object)var2);
         this.onChanged();
         return this;
      }
   }

   public DescriptorProtos$SourceCodeInfo$Location$Builder addLeadingDetachedComments(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.ensureLeadingDetachedCommentsIsMutable();
         this.leadingDetachedComments_.add((Object)var1);
         this.onChanged();
         return this;
      }
   }

   public DescriptorProtos$SourceCodeInfo$Location$Builder addAllLeadingDetachedComments(Iterable var1) {
      this.ensureLeadingDetachedCommentsIsMutable();
      AbstractMessageLite$Builder.addAll(var1, this.leadingDetachedComments_);
      this.onChanged();
      return this;
   }

   public DescriptorProtos$SourceCodeInfo$Location$Builder clearLeadingDetachedComments() {
      this.leadingDetachedComments_ = LazyStringArrayList.EMPTY;
      this.bitField0_ &= -17;
      this.onChanged();
      return this;
   }

   public DescriptorProtos$SourceCodeInfo$Location$Builder addLeadingDetachedCommentsBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.ensureLeadingDetachedCommentsIsMutable();
         this.leadingDetachedComments_.add(var1);
         this.onChanged();
         return this;
      }
   }

   // $FF: synthetic method
   DescriptorProtos$SourceCodeInfo$Location$Builder(DescriptorProtos$1 var1) {
      this();
   }

   // $FF: synthetic method
   DescriptorProtos$SourceCodeInfo$Location$Builder(GeneratedMessage$BuilderParent var1, DescriptorProtos$1 var2) {
      this(var1);
   }
}
