package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite$Builder$LimitedInputStream;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$1;
import com.google.protobuf.UnknownFieldSet$Field;
import com.google.protobuf.UnknownFieldSet$Field$Builder;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public final class UnknownFieldSet$Builder implements MessageLite$Builder {
   private Map fields;
   private int lastFieldNumber;
   private UnknownFieldSet$Field$Builder lastField;

   private static UnknownFieldSet$Builder create() {
      UnknownFieldSet$Builder var0 = new UnknownFieldSet$Builder();
      var0.reinitialize();
      return var0;
   }

   private UnknownFieldSet$Field$Builder getFieldBuilder(int var1) {
      if(this.lastField != null) {
         if(var1 == this.lastFieldNumber) {
            return this.lastField;
         }

         this.addField(this.lastFieldNumber, this.lastField.build());
      }

      if(var1 == 0) {
         return null;
      } else {
         UnknownFieldSet$Field var2 = (UnknownFieldSet$Field)this.fields.get(Integer.valueOf(var1));
         this.lastFieldNumber = var1;
         this.lastField = UnknownFieldSet$Field.newBuilder();
         if(var2 != null) {
            this.lastField.mergeFrom(var2);
         }

         return this.lastField;
      }
   }

   public UnknownFieldSet build() {
      this.getFieldBuilder(0);
      UnknownFieldSet var1;
      if(this.fields.isEmpty()) {
         var1 = UnknownFieldSet.getDefaultInstance();
      } else {
         var1 = new UnknownFieldSet(Collections.unmodifiableMap(this.fields), (UnknownFieldSet$1)null);
      }

      this.fields = null;
      return var1;
   }

   public UnknownFieldSet buildPartial() {
      return this.build();
   }

   public UnknownFieldSet$Builder clone() {
      this.getFieldBuilder(0);
      return UnknownFieldSet.newBuilder().mergeFrom(new UnknownFieldSet(this.fields, (UnknownFieldSet$1)null));
   }

   public UnknownFieldSet getDefaultInstanceForType() {
      return UnknownFieldSet.getDefaultInstance();
   }

   private void reinitialize() {
      this.fields = Collections.emptyMap();
      this.lastFieldNumber = 0;
      this.lastField = null;
   }

   public UnknownFieldSet$Builder clear() {
      this.reinitialize();
      return this;
   }

   public UnknownFieldSet$Builder clearField(int var1) {
      if(var1 == 0) {
         throw new IllegalArgumentException("Zero is not a valid field number.");
      } else {
         if(this.lastField != null && this.lastFieldNumber == var1) {
            this.lastField = null;
            this.lastFieldNumber = 0;
         }

         if(this.fields.containsKey(Integer.valueOf(var1))) {
            this.fields.remove(Integer.valueOf(var1));
         }

         return this;
      }
   }

   public UnknownFieldSet$Builder mergeFrom(UnknownFieldSet var1) {
      if(var1 != UnknownFieldSet.getDefaultInstance()) {
         Iterator var2 = UnknownFieldSet.access$200(var1).entrySet().iterator();

         while(var2.hasNext()) {
            Entry var3 = (Entry)var2.next();
            this.mergeField(((Integer)var3.getKey()).intValue(), (UnknownFieldSet$Field)var3.getValue());
         }
      }

      return this;
   }

   public UnknownFieldSet$Builder mergeField(int var1, UnknownFieldSet$Field var2) {
      if(var1 == 0) {
         throw new IllegalArgumentException("Zero is not a valid field number.");
      } else {
         if(this.hasField(var1)) {
            this.getFieldBuilder(var1).mergeFrom(var2);
         } else {
            this.addField(var1, var2);
         }

         return this;
      }
   }

   public UnknownFieldSet$Builder mergeVarintField(int var1, int var2) {
      if(var1 == 0) {
         throw new IllegalArgumentException("Zero is not a valid field number.");
      } else {
         this.getFieldBuilder(var1).addVarint((long)var2);
         return this;
      }
   }

   public UnknownFieldSet$Builder mergeLengthDelimitedField(int var1, ByteString var2) {
      if(var1 == 0) {
         throw new IllegalArgumentException("Zero is not a valid field number.");
      } else {
         this.getFieldBuilder(var1).addLengthDelimited(var2);
         return this;
      }
   }

   public boolean hasField(int var1) {
      if(var1 == 0) {
         throw new IllegalArgumentException("Zero is not a valid field number.");
      } else {
         return var1 == this.lastFieldNumber || this.fields.containsKey(Integer.valueOf(var1));
      }
   }

   public UnknownFieldSet$Builder addField(int var1, UnknownFieldSet$Field var2) {
      if(var1 == 0) {
         throw new IllegalArgumentException("Zero is not a valid field number.");
      } else {
         if(this.lastField != null && this.lastFieldNumber == var1) {
            this.lastField = null;
            this.lastFieldNumber = 0;
         }

         if(this.fields.isEmpty()) {
            this.fields = new TreeMap();
         }

         this.fields.put(Integer.valueOf(var1), var2);
         return this;
      }
   }

   public Map asMap() {
      this.getFieldBuilder(0);
      return Collections.unmodifiableMap(this.fields);
   }

   public UnknownFieldSet$Builder mergeFrom(CodedInputStream var1) {
      int var2;
      do {
         var2 = var1.readTag();
      } while(var2 != 0 && this.mergeFieldFrom(var2, var1));

      return this;
   }

   public boolean mergeFieldFrom(int var1, CodedInputStream var2) {
      int var3 = WireFormat.getTagFieldNumber(var1);
      switch(WireFormat.getTagWireType(var1)) {
      case 0:
         this.getFieldBuilder(var3).addVarint(var2.readInt64());
         return true;
      case 1:
         this.getFieldBuilder(var3).addFixed64(var2.readFixed64());
         return true;
      case 2:
         this.getFieldBuilder(var3).addLengthDelimited(var2.readBytes());
         return true;
      case 3:
         UnknownFieldSet$Builder var4 = UnknownFieldSet.newBuilder();
         var2.readGroup(var3, (MessageLite$Builder)var4, ExtensionRegistry.getEmptyRegistry());
         this.getFieldBuilder(var3).addGroup(var4.build());
         return true;
      case 4:
         return false;
      case 5:
         this.getFieldBuilder(var3).addFixed32(var2.readFixed32());
         return true;
      default:
         throw InvalidProtocolBufferException.invalidWireType();
      }
   }

   public UnknownFieldSet$Builder mergeFrom(ByteString var1) {
      try {
         CodedInputStream var2 = var1.newCodedInput();
         this.mergeFrom(var2);
         var2.checkLastTagWas(0);
         return this;
      } catch (InvalidProtocolBufferException var3) {
         throw var3;
      } catch (IOException var4) {
         throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", var4);
      }
   }

   public UnknownFieldSet$Builder mergeFrom(byte[] var1) {
      try {
         CodedInputStream var2 = CodedInputStream.newInstance(var1);
         this.mergeFrom(var2);
         var2.checkLastTagWas(0);
         return this;
      } catch (InvalidProtocolBufferException var3) {
         throw var3;
      } catch (IOException var4) {
         throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", var4);
      }
   }

   public UnknownFieldSet$Builder mergeFrom(InputStream var1) {
      CodedInputStream var2 = CodedInputStream.newInstance(var1);
      this.mergeFrom(var2);
      var2.checkLastTagWas(0);
      return this;
   }

   public boolean mergeDelimitedFrom(InputStream var1) {
      int var2 = var1.read();
      if(var2 == -1) {
         return false;
      } else {
         int var3 = CodedInputStream.readRawVarint32(var2, var1);
         AbstractMessageLite$Builder$LimitedInputStream var4 = new AbstractMessageLite$Builder$LimitedInputStream(var1, var3);
         this.mergeFrom((InputStream)var4);
         return true;
      }
   }

   public boolean mergeDelimitedFrom(InputStream var1, ExtensionRegistryLite var2) {
      return this.mergeDelimitedFrom(var1);
   }

   public UnknownFieldSet$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      return this.mergeFrom(var1);
   }

   public UnknownFieldSet$Builder mergeFrom(ByteString var1, ExtensionRegistryLite var2) {
      return this.mergeFrom(var1);
   }

   public UnknownFieldSet$Builder mergeFrom(byte[] var1, int var2, int var3) {
      try {
         CodedInputStream var4 = CodedInputStream.newInstance(var1, var2, var3);
         this.mergeFrom(var4);
         var4.checkLastTagWas(0);
         return this;
      } catch (InvalidProtocolBufferException var5) {
         throw var5;
      } catch (IOException var6) {
         throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", var6);
      }
   }

   public UnknownFieldSet$Builder mergeFrom(byte[] var1, ExtensionRegistryLite var2) {
      return this.mergeFrom(var1);
   }

   public UnknownFieldSet$Builder mergeFrom(byte[] var1, int var2, int var3, ExtensionRegistryLite var4) {
      return this.mergeFrom(var1, var2, var3);
   }

   public UnknownFieldSet$Builder mergeFrom(InputStream var1, ExtensionRegistryLite var2) {
      return this.mergeFrom(var1);
   }

   public boolean isInitialized() {
      return true;
   }

   // $FF: synthetic method
   static UnknownFieldSet$Builder access$000() {
      return create();
   }
}
