package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;

public class LazyFieldLite {
   private static final ExtensionRegistryLite EMPTY_REGISTRY = ExtensionRegistryLite.getEmptyRegistry();
   private ByteString delayedBytes;
   private ExtensionRegistryLite extensionRegistry;
   protected volatile MessageLite value;
   private volatile ByteString memoizedBytes;

   public LazyFieldLite(ExtensionRegistryLite var1, ByteString var2) {
      checkArguments(var1, var2);
      this.extensionRegistry = var1;
      this.delayedBytes = var2;
   }

   public LazyFieldLite() {
   }

   public static LazyFieldLite fromValue(MessageLite var0) {
      LazyFieldLite var1 = new LazyFieldLite();
      var1.setValue(var0);
      return var1;
   }

   public boolean containsDefaultInstance() {
      return this.memoizedBytes == ByteString.EMPTY || this.value == null && (this.delayedBytes == null || this.delayedBytes == ByteString.EMPTY);
   }

   public void clear() {
      this.delayedBytes = null;
      this.value = null;
      this.memoizedBytes = null;
   }

   public void set(LazyFieldLite var1) {
      this.delayedBytes = var1.delayedBytes;
      this.value = var1.value;
      this.memoizedBytes = var1.memoizedBytes;
      if(var1.extensionRegistry != null) {
         this.extensionRegistry = var1.extensionRegistry;
      }

   }

   public MessageLite getValue(MessageLite var1) {
      this.ensureInitialized(var1);
      return this.value;
   }

   public MessageLite setValue(MessageLite var1) {
      MessageLite var2 = this.value;
      this.delayedBytes = null;
      this.memoizedBytes = null;
      this.value = var1;
      return var2;
   }

   public void merge(LazyFieldLite var1) {
      if(!var1.containsDefaultInstance()) {
         if(this.containsDefaultInstance()) {
            this.set(var1);
         } else {
            if(this.extensionRegistry == null) {
               this.extensionRegistry = var1.extensionRegistry;
            }

            if(this.delayedBytes != null && var1.delayedBytes != null) {
               this.delayedBytes = this.delayedBytes.concat(var1.delayedBytes);
            } else if(this.value == null && var1.value != null) {
               this.setValue(mergeValueAndBytes(var1.value, this.delayedBytes, this.extensionRegistry));
            } else if(this.value != null && var1.value == null) {
               this.setValue(mergeValueAndBytes(this.value, var1.delayedBytes, var1.extensionRegistry));
            } else if(var1.extensionRegistry != null) {
               this.setValue(mergeValueAndBytes(this.value, var1.toByteString(), var1.extensionRegistry));
            } else if(this.extensionRegistry != null) {
               this.setValue(mergeValueAndBytes(var1.value, this.toByteString(), this.extensionRegistry));
            } else {
               this.setValue(mergeValueAndBytes(this.value, var1.toByteString(), EMPTY_REGISTRY));
            }
         }
      }
   }

   private static MessageLite mergeValueAndBytes(MessageLite var0, ByteString var1, ExtensionRegistryLite var2) {
      try {
         return var0.toBuilder().mergeFrom(var1, var2).build();
      } catch (InvalidProtocolBufferException var4) {
         return var0;
      }
   }

   public void setByteString(ByteString var1, ExtensionRegistryLite var2) {
      checkArguments(var2, var1);
      this.delayedBytes = var1;
      this.extensionRegistry = var2;
      this.value = null;
      this.memoizedBytes = null;
   }

   public int getSerializedSize() {
      return this.delayedBytes != null?this.delayedBytes.size():(this.memoizedBytes != null?this.memoizedBytes.size():(this.value != null?this.value.getSerializedSize():0));
   }

   public ByteString toByteString() {
      if(this.delayedBytes != null) {
         return this.delayedBytes;
      } else if(this.memoizedBytes != null) {
         return this.memoizedBytes;
      } else {
         synchronized(this) {
            if(this.memoizedBytes != null) {
               return this.memoizedBytes;
            } else {
               if(this.value == null) {
                  this.memoizedBytes = ByteString.EMPTY;
               } else {
                  this.memoizedBytes = this.value.toByteString();
               }

               return this.memoizedBytes;
            }
         }
      }
   }

   protected void ensureInitialized(MessageLite var1) {
      if(this.value == null) {
         synchronized(this) {
            if(this.value == null) {
               try {
                  if(this.delayedBytes != null) {
                     MessageLite var3 = (MessageLite)var1.getParserForType().parseFrom(this.delayedBytes, this.extensionRegistry);
                     this.value = var3;
                     this.memoizedBytes = this.delayedBytes;
                     this.delayedBytes = null;
                  } else {
                     this.value = var1;
                     this.memoizedBytes = ByteString.EMPTY;
                     this.delayedBytes = null;
                  }
               } catch (InvalidProtocolBufferException var5) {
                  this.value = var1;
                  this.memoizedBytes = ByteString.EMPTY;
                  this.delayedBytes = null;
               }

            }
         }
      }
   }

   private static void checkArguments(ExtensionRegistryLite var0, ByteString var1) {
      if(var0 == null) {
         throw new NullPointerException("found null ExtensionRegistry");
      } else if(var1 == null) {
         throw new NullPointerException("found null ByteString");
      }
   }
}
