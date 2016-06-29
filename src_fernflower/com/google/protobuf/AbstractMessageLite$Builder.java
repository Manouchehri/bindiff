package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite$Builder$LimitedInputStream;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.UninitializedMessageException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;

public abstract class AbstractMessageLite$Builder implements MessageLite$Builder {
   public abstract AbstractMessageLite$Builder clone();

   public AbstractMessageLite$Builder mergeFrom(CodedInputStream var1) {
      return this.mergeFrom(var1, ExtensionRegistryLite.getEmptyRegistry());
   }

   public abstract AbstractMessageLite$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2);

   public AbstractMessageLite$Builder mergeFrom(ByteString var1) {
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

   public AbstractMessageLite$Builder mergeFrom(ByteString var1, ExtensionRegistryLite var2) {
      try {
         CodedInputStream var3 = var1.newCodedInput();
         this.mergeFrom(var3, var2);
         var3.checkLastTagWas(0);
         return this;
      } catch (InvalidProtocolBufferException var4) {
         throw var4;
      } catch (IOException var5) {
         throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", var5);
      }
   }

   public AbstractMessageLite$Builder mergeFrom(byte[] var1) {
      return this.mergeFrom(var1, 0, var1.length);
   }

   public AbstractMessageLite$Builder mergeFrom(byte[] var1, int var2, int var3) {
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

   public AbstractMessageLite$Builder mergeFrom(byte[] var1, ExtensionRegistryLite var2) {
      return this.mergeFrom(var1, 0, var1.length, var2);
   }

   public AbstractMessageLite$Builder mergeFrom(byte[] var1, int var2, int var3, ExtensionRegistryLite var4) {
      try {
         CodedInputStream var5 = CodedInputStream.newInstance(var1, var2, var3);
         this.mergeFrom(var5, var4);
         var5.checkLastTagWas(0);
         return this;
      } catch (InvalidProtocolBufferException var6) {
         throw var6;
      } catch (IOException var7) {
         throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", var7);
      }
   }

   public AbstractMessageLite$Builder mergeFrom(InputStream var1) {
      CodedInputStream var2 = CodedInputStream.newInstance(var1);
      this.mergeFrom(var2);
      var2.checkLastTagWas(0);
      return this;
   }

   public AbstractMessageLite$Builder mergeFrom(InputStream var1, ExtensionRegistryLite var2) {
      CodedInputStream var3 = CodedInputStream.newInstance(var1);
      this.mergeFrom(var3, var2);
      var3.checkLastTagWas(0);
      return this;
   }

   public boolean mergeDelimitedFrom(InputStream var1, ExtensionRegistryLite var2) {
      int var3 = var1.read();
      if(var3 == -1) {
         return false;
      } else {
         int var4 = CodedInputStream.readRawVarint32(var3, var1);
         AbstractMessageLite$Builder$LimitedInputStream var5 = new AbstractMessageLite$Builder$LimitedInputStream(var1, var4);
         this.mergeFrom((InputStream)var5, var2);
         return true;
      }
   }

   public boolean mergeDelimitedFrom(InputStream var1) {
      return this.mergeDelimitedFrom(var1, ExtensionRegistryLite.getEmptyRegistry());
   }

   protected static UninitializedMessageException newUninitializedMessageException(MessageLite var0) {
      return new UninitializedMessageException(var0);
   }

   protected static void addAll(Iterable var0, Collection var1) {
      if(var0 == null) {
         throw new NullPointerException();
      } else {
         if(var0 instanceof LazyStringList) {
            checkForNullValues(((LazyStringList)var0).getUnderlyingElements());
            var1.addAll((Collection)var0);
         } else if(var0 instanceof Collection) {
            checkForNullValues(var0);
            var1.addAll((Collection)var0);
         } else {
            Iterator var2 = var0.iterator();

            while(var2.hasNext()) {
               Object var3 = var2.next();
               if(var3 == null) {
                  throw new NullPointerException();
               }

               var1.add(var3);
            }
         }

      }
   }

   private static void checkForNullValues(Iterable var0) {
      Iterator var1 = var0.iterator();

      Object var2;
      do {
         if(!var1.hasNext()) {
            return;
         }

         var2 = var1.next();
      } while(var2 != null);

      throw new NullPointerException();
   }
}
