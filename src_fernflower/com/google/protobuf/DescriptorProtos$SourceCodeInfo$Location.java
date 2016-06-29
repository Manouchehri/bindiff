package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo$Location$1;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo$Location$Builder;
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
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$SourceCodeInfo$Location extends GeneratedMessage implements DescriptorProtos$SourceCodeInfo$LocationOrBuilder {
   private int bitField0_;
   public static final int PATH_FIELD_NUMBER = 1;
   private List path_;
   private int pathMemoizedSerializedSize;
   public static final int SPAN_FIELD_NUMBER = 2;
   private List span_;
   private int spanMemoizedSerializedSize;
   public static final int LEADING_COMMENTS_FIELD_NUMBER = 3;
   private volatile Object leadingComments_;
   public static final int TRAILING_COMMENTS_FIELD_NUMBER = 4;
   private volatile Object trailingComments_;
   public static final int LEADING_DETACHED_COMMENTS_FIELD_NUMBER = 6;
   private LazyStringList leadingDetachedComments_;
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final DescriptorProtos$SourceCodeInfo$Location DEFAULT_INSTANCE = new DescriptorProtos$SourceCodeInfo$Location();
   public static final Parser PARSER = new DescriptorProtos$SourceCodeInfo$Location$1();

   private DescriptorProtos$SourceCodeInfo$Location(GeneratedMessage$Builder var1) {
      super(var1);
      this.pathMemoizedSerializedSize = -1;
      this.spanMemoizedSerializedSize = -1;
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private DescriptorProtos$SourceCodeInfo$Location() {
      this.pathMemoizedSerializedSize = -1;
      this.spanMemoizedSerializedSize = -1;
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
      this.path_ = Collections.emptyList();
      this.span_ = Collections.emptyList();
      this.leadingComments_ = "";
      this.trailingComments_ = "";
      this.leadingDetachedComments_ = LazyStringArrayList.EMPTY;
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private DescriptorProtos$SourceCodeInfo$Location(CodedInputStream var1, ExtensionRegistryLite var2) {
      this();
      int var3 = 0;
      UnknownFieldSet$Builder var4 = UnknownFieldSet.newBuilder();

      try {
         boolean var5 = false;

         while(!var5) {
            int var6 = var1.readTag();
            int var17;
            ByteString var7;
            int var8;
            switch(var6) {
            case 0:
               var5 = true;
               continue;
            case 8:
               if((var3 & 1) != 1) {
                  this.path_ = new ArrayList();
                  var3 |= 1;
               }

               this.path_.add(Integer.valueOf(var1.readInt32()));
               continue;
            case 10:
               var17 = var1.readRawVarint32();
               var8 = var1.pushLimit(var17);
               if((var3 & 1) != 1 && var1.getBytesUntilLimit() > 0) {
                  this.path_ = new ArrayList();
                  var3 |= 1;
               }
               break;
            case 16:
               if((var3 & 2) != 2) {
                  this.span_ = new ArrayList();
                  var3 |= 2;
               }

               this.span_.add(Integer.valueOf(var1.readInt32()));
               continue;
            case 18:
               var17 = var1.readRawVarint32();
               var8 = var1.pushLimit(var17);
               if((var3 & 2) != 2 && var1.getBytesUntilLimit() > 0) {
                  this.span_ = new ArrayList();
                  var3 |= 2;
               }

               while(var1.getBytesUntilLimit() > 0) {
                  this.span_.add(Integer.valueOf(var1.readInt32()));
               }

               var1.popLimit(var8);
               continue;
            case 26:
               var7 = var1.readBytes();
               this.bitField0_ |= 1;
               this.leadingComments_ = var7;
               continue;
            case 34:
               var7 = var1.readBytes();
               this.bitField0_ |= 2;
               this.trailingComments_ = var7;
               continue;
            case 50:
               var7 = var1.readBytes();
               if((var3 & 16) != 16) {
                  this.leadingDetachedComments_ = new LazyStringArrayList();
                  var3 |= 16;
               }

               this.leadingDetachedComments_.add(var7);
               continue;
            default:
               if(!this.parseUnknownField(var1, var4, var2, var6)) {
                  var5 = true;
               }
               continue;
            }

            while(var1.getBytesUntilLimit() > 0) {
               this.path_.add(Integer.valueOf(var1.readInt32()));
            }

            var1.popLimit(var8);
         }
      } catch (InvalidProtocolBufferException var14) {
         throw new RuntimeException(var14.setUnfinishedMessage(this));
      } catch (IOException var15) {
         throw new RuntimeException((new InvalidProtocolBufferException(var15.getMessage())).setUnfinishedMessage(this));
      } finally {
         if((var3 & 1) == 1) {
            this.path_ = Collections.unmodifiableList(this.path_);
         }

         if((var3 & 2) == 2) {
            this.span_ = Collections.unmodifiableList(this.span_);
         }

         if((var3 & 16) == 16) {
            this.leadingDetachedComments_ = this.leadingDetachedComments_.getUnmodifiableView();
         }

         this.unknownFields = var4.build();
         this.makeExtensionsImmutable();
      }

   }

   public static final Descriptors$Descriptor getDescriptor() {
      return DescriptorProtos.access$23800();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return DescriptorProtos.access$23900().ensureFieldAccessorsInitialized(DescriptorProtos$SourceCodeInfo$Location.class, DescriptorProtos$SourceCodeInfo$Location$Builder.class);
   }

   public List getPathList() {
      return this.path_;
   }

   public int getPathCount() {
      return this.path_.size();
   }

   public int getPath(int var1) {
      return ((Integer)this.path_.get(var1)).intValue();
   }

   public List getSpanList() {
      return this.span_;
   }

   public int getSpanCount() {
      return this.span_.size();
   }

   public int getSpan(int var1) {
      return ((Integer)this.span_.get(var1)).intValue();
   }

   public boolean hasLeadingComments() {
      return (this.bitField0_ & 1) == 1;
   }

   public String getLeadingComments() {
      Object var1 = this.leadingComments_;
      if(var1 instanceof String) {
         return (String)var1;
      } else {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.leadingComments_ = var3;
         }

         return var3;
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

   public boolean hasTrailingComments() {
      return (this.bitField0_ & 2) == 2;
   }

   public String getTrailingComments() {
      Object var1 = this.trailingComments_;
      if(var1 instanceof String) {
         return (String)var1;
      } else {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.trailingComments_ = var3;
         }

         return var3;
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

   public ProtocolStringList getLeadingDetachedCommentsList() {
      return this.leadingDetachedComments_;
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
      this.getSerializedSize();
      if(this.getPathList().size() > 0) {
         var1.writeRawVarint32(10);
         var1.writeRawVarint32(this.pathMemoizedSerializedSize);
      }

      int var2;
      for(var2 = 0; var2 < this.path_.size(); ++var2) {
         var1.writeInt32NoTag(((Integer)this.path_.get(var2)).intValue());
      }

      if(this.getSpanList().size() > 0) {
         var1.writeRawVarint32(18);
         var1.writeRawVarint32(this.spanMemoizedSerializedSize);
      }

      for(var2 = 0; var2 < this.span_.size(); ++var2) {
         var1.writeInt32NoTag(((Integer)this.span_.get(var2)).intValue());
      }

      if((this.bitField0_ & 1) == 1) {
         var1.writeBytes(3, this.getLeadingCommentsBytes());
      }

      if((this.bitField0_ & 2) == 2) {
         var1.writeBytes(4, this.getTrailingCommentsBytes());
      }

      for(var2 = 0; var2 < this.leadingDetachedComments_.size(); ++var2) {
         var1.writeBytes(6, this.leadingDetachedComments_.getByteString(var2));
      }

      this.unknownFields.writeTo(var1);
   }

   public int getSerializedSize() {
      int var1 = this.memoizedSerializedSize;
      if(var1 != -1) {
         return var1;
      } else {
         byte var4 = 0;
         int var2 = 0;

         int var3;
         for(var3 = 0; var3 < this.path_.size(); ++var3) {
            var2 += CodedOutputStream.computeInt32SizeNoTag(((Integer)this.path_.get(var3)).intValue());
         }

         var1 = var4 + var2;
         if(!this.getPathList().isEmpty()) {
            ++var1;
            var1 += CodedOutputStream.computeInt32SizeNoTag(var2);
         }

         this.pathMemoizedSerializedSize = var2;
         var2 = 0;

         for(var3 = 0; var3 < this.span_.size(); ++var3) {
            var2 += CodedOutputStream.computeInt32SizeNoTag(((Integer)this.span_.get(var3)).intValue());
         }

         var1 += var2;
         if(!this.getSpanList().isEmpty()) {
            ++var1;
            var1 += CodedOutputStream.computeInt32SizeNoTag(var2);
         }

         this.spanMemoizedSerializedSize = var2;
         if((this.bitField0_ & 1) == 1) {
            var1 += CodedOutputStream.computeBytesSize(3, this.getLeadingCommentsBytes());
         }

         if((this.bitField0_ & 2) == 2) {
            var1 += CodedOutputStream.computeBytesSize(4, this.getTrailingCommentsBytes());
         }

         var2 = 0;

         for(var3 = 0; var3 < this.leadingDetachedComments_.size(); ++var3) {
            var2 += CodedOutputStream.computeBytesSizeNoTag(this.leadingDetachedComments_.getByteString(var3));
         }

         var1 += var2;
         var1 += 1 * this.getLeadingDetachedCommentsList().size();
         var1 += this.unknownFields.getSerializedSize();
         this.memoizedSerializedSize = var1;
         return var1;
      }
   }

   public static DescriptorProtos$SourceCodeInfo$Location parseFrom(ByteString var0) {
      return (DescriptorProtos$SourceCodeInfo$Location)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$SourceCodeInfo$Location parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$SourceCodeInfo$Location)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$SourceCodeInfo$Location parseFrom(byte[] var0) {
      return (DescriptorProtos$SourceCodeInfo$Location)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$SourceCodeInfo$Location parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$SourceCodeInfo$Location)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$SourceCodeInfo$Location parseFrom(InputStream var0) {
      return (DescriptorProtos$SourceCodeInfo$Location)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$SourceCodeInfo$Location parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$SourceCodeInfo$Location)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$SourceCodeInfo$Location parseDelimitedFrom(InputStream var0) {
      return (DescriptorProtos$SourceCodeInfo$Location)PARSER.parseDelimitedFrom(var0);
   }

   public static DescriptorProtos$SourceCodeInfo$Location parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$SourceCodeInfo$Location)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static DescriptorProtos$SourceCodeInfo$Location parseFrom(CodedInputStream var0) {
      return (DescriptorProtos$SourceCodeInfo$Location)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$SourceCodeInfo$Location parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$SourceCodeInfo$Location)PARSER.parseFrom(var0, var1);
   }

   public DescriptorProtos$SourceCodeInfo$Location$Builder newBuilderForType() {
      return newBuilder();
   }

   public static DescriptorProtos$SourceCodeInfo$Location$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static DescriptorProtos$SourceCodeInfo$Location$Builder newBuilder(DescriptorProtos$SourceCodeInfo$Location var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public DescriptorProtos$SourceCodeInfo$Location$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new DescriptorProtos$SourceCodeInfo$Location$Builder((DescriptorProtos$1)null):(new DescriptorProtos$SourceCodeInfo$Location$Builder((DescriptorProtos$1)null)).mergeFrom(this);
   }

   protected DescriptorProtos$SourceCodeInfo$Location$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      DescriptorProtos$SourceCodeInfo$Location$Builder var2 = new DescriptorProtos$SourceCodeInfo$Location$Builder(var1, (DescriptorProtos$1)null);
      return var2;
   }

   public static DescriptorProtos$SourceCodeInfo$Location getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public DescriptorProtos$SourceCodeInfo$Location getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   DescriptorProtos$SourceCodeInfo$Location(GeneratedMessage$Builder var1, DescriptorProtos$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static List access$24302(DescriptorProtos$SourceCodeInfo$Location var0, List var1) {
      return var0.path_ = var1;
   }

   // $FF: synthetic method
   static List access$24402(DescriptorProtos$SourceCodeInfo$Location var0, List var1) {
      return var0.span_ = var1;
   }

   // $FF: synthetic method
   static Object access$24502(DescriptorProtos$SourceCodeInfo$Location var0, Object var1) {
      return var0.leadingComments_ = var1;
   }

   // $FF: synthetic method
   static Object access$24602(DescriptorProtos$SourceCodeInfo$Location var0, Object var1) {
      return var0.trailingComments_ = var1;
   }

   // $FF: synthetic method
   static LazyStringList access$24702(DescriptorProtos$SourceCodeInfo$Location var0, LazyStringList var1) {
      return var0.leadingDetachedComments_ = var1;
   }

   // $FF: synthetic method
   static int access$24802(DescriptorProtos$SourceCodeInfo$Location var0, int var1) {
      return var0.bitField0_ = var1;
   }

   // $FF: synthetic method
   static List access$24300(DescriptorProtos$SourceCodeInfo$Location var0) {
      return var0.path_;
   }

   // $FF: synthetic method
   static List access$24400(DescriptorProtos$SourceCodeInfo$Location var0) {
      return var0.span_;
   }

   // $FF: synthetic method
   static Object access$24500(DescriptorProtos$SourceCodeInfo$Location var0) {
      return var0.leadingComments_;
   }

   // $FF: synthetic method
   static Object access$24600(DescriptorProtos$SourceCodeInfo$Location var0) {
      return var0.trailingComments_;
   }

   // $FF: synthetic method
   static LazyStringList access$24700(DescriptorProtos$SourceCodeInfo$Location var0) {
      return var0.leadingDetachedComments_;
   }

   // $FF: synthetic method
   DescriptorProtos$SourceCodeInfo$Location(CodedInputStream var1, ExtensionRegistryLite var2, DescriptorProtos$1 var3) {
      this(var1, var2);
   }
}
