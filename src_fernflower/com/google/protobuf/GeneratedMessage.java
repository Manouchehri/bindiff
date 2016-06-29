package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.Extension;
import com.google.protobuf.Extension$ExtensionType;
import com.google.protobuf.ExtensionLite;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage$1;
import com.google.protobuf.GeneratedMessage$2;
import com.google.protobuf.GeneratedMessage$3;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$ExtensionDescriptorRetriever;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.GeneratedMessage$GeneratedExtension;
import com.google.protobuf.GeneratedMessageLite$SerializedForm;
import com.google.protobuf.MapField;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageReflection;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public abstract class GeneratedMessage extends AbstractMessage implements Serializable {
   private static final long serialVersionUID = 1L;
   protected static boolean alwaysUseFieldBuilders = false;
   protected UnknownFieldSet unknownFields;

   protected GeneratedMessage() {
      this.unknownFields = UnknownFieldSet.getDefaultInstance();
   }

   protected GeneratedMessage(GeneratedMessage$Builder var1) {
      this.unknownFields = var1.getUnknownFields();
   }

   public Parser getParserForType() {
      throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
   }

   static void enableAlwaysUseFieldBuildersForTesting() {
      alwaysUseFieldBuilders = true;
   }

   protected abstract GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable();

   public Descriptors$Descriptor getDescriptorForType() {
      return GeneratedMessage$FieldAccessorTable.access$000(this.internalGetFieldAccessorTable());
   }

   private Map getAllFieldsMutable(boolean var1) {
      TreeMap var2 = new TreeMap();
      Descriptors$Descriptor var3 = GeneratedMessage$FieldAccessorTable.access$000(this.internalGetFieldAccessorTable());
      Iterator var4 = var3.getFields().iterator();

      while(true) {
         while(var4.hasNext()) {
            Descriptors$FieldDescriptor var5 = (Descriptors$FieldDescriptor)var4.next();
            if(var5.isRepeated()) {
               List var6 = (List)this.getField(var5);
               if(!var6.isEmpty()) {
                  var2.put(var5, var6);
               }
            } else if(this.hasField(var5)) {
               if(var1 && var5.getJavaType() == Descriptors$FieldDescriptor$JavaType.STRING) {
                  var2.put(var5, this.getFieldRaw(var5));
               } else {
                  var2.put(var5, this.getField(var5));
               }
            }
         }

         return var2;
      }
   }

   public boolean isInitialized() {
      Iterator var1 = this.getDescriptorForType().getFields().iterator();

      while(true) {
         while(true) {
            Descriptors$FieldDescriptor var2;
            do {
               if(!var1.hasNext()) {
                  return true;
               }

               var2 = (Descriptors$FieldDescriptor)var1.next();
               if(var2.isRequired() && !this.hasField(var2)) {
                  return false;
               }
            } while(var2.getJavaType() != Descriptors$FieldDescriptor$JavaType.MESSAGE);

            if(var2.isRepeated()) {
               List var3 = (List)this.getField(var2);
               Iterator var4 = var3.iterator();

               while(var4.hasNext()) {
                  Message var5 = (Message)var4.next();
                  if(!var5.isInitialized()) {
                     return false;
                  }
               }
            } else if(this.hasField(var2) && !((Message)this.getField(var2)).isInitialized()) {
               return false;
            }
         }
      }
   }

   public Map getAllFields() {
      return Collections.unmodifiableMap(this.getAllFieldsMutable(false));
   }

   Map getAllFieldsRaw() {
      return Collections.unmodifiableMap(this.getAllFieldsMutable(true));
   }

   public boolean hasOneof(Descriptors$OneofDescriptor var1) {
      return GeneratedMessage$FieldAccessorTable.access$100(this.internalGetFieldAccessorTable(), var1).has(this);
   }

   public Descriptors$FieldDescriptor getOneofFieldDescriptor(Descriptors$OneofDescriptor var1) {
      return GeneratedMessage$FieldAccessorTable.access$100(this.internalGetFieldAccessorTable(), var1).get(this);
   }

   public boolean hasField(Descriptors$FieldDescriptor var1) {
      return GeneratedMessage$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), var1).has(this);
   }

   public Object getField(Descriptors$FieldDescriptor var1) {
      return GeneratedMessage$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), var1).get(this);
   }

   Object getFieldRaw(Descriptors$FieldDescriptor var1) {
      return GeneratedMessage$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), var1).getRaw(this);
   }

   public int getRepeatedFieldCount(Descriptors$FieldDescriptor var1) {
      return GeneratedMessage$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), var1).getRepeatedCount(this);
   }

   public Object getRepeatedField(Descriptors$FieldDescriptor var1, int var2) {
      return GeneratedMessage$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), var1).getRepeated(this, var2);
   }

   public UnknownFieldSet getUnknownFields() {
      throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
   }

   protected boolean parseUnknownField(CodedInputStream var1, UnknownFieldSet$Builder var2, ExtensionRegistryLite var3, int var4) {
      return var2.mergeFieldFrom(var4, var1);
   }

   public void writeTo(CodedOutputStream var1) {
      MessageReflection.writeMessageTo(this, this.getAllFieldsRaw(), var1, false);
   }

   public int getSerializedSize() {
      int var1 = this.memoizedSize;
      if(var1 != -1) {
         return var1;
      } else {
         this.memoizedSize = MessageReflection.getSerializedSize(this, this.getAllFieldsRaw());
         return this.memoizedSize;
      }
   }

   protected void makeExtensionsImmutable() {
   }

   protected abstract Message$Builder newBuilderForType(GeneratedMessage$BuilderParent var1);

   public static GeneratedMessage$GeneratedExtension newMessageScopedGeneratedExtension(Message var0, int var1, Class var2, Message var3) {
      return new GeneratedMessage$GeneratedExtension(new GeneratedMessage$1(var0, var1), var2, var3, Extension$ExtensionType.IMMUTABLE);
   }

   public static GeneratedMessage$GeneratedExtension newFileScopedGeneratedExtension(Class var0, Message var1) {
      return new GeneratedMessage$GeneratedExtension((GeneratedMessage$ExtensionDescriptorRetriever)null, var0, var1, Extension$ExtensionType.IMMUTABLE);
   }

   public static GeneratedMessage$GeneratedExtension newMessageScopedGeneratedExtension(Message var0, String var1, Class var2, Message var3) {
      return new GeneratedMessage$GeneratedExtension(new GeneratedMessage$2(var0, var1), var2, var3, Extension$ExtensionType.MUTABLE);
   }

   public static GeneratedMessage$GeneratedExtension newFileScopedGeneratedExtension(Class var0, Message var1, String var2, String var3) {
      return new GeneratedMessage$GeneratedExtension(new GeneratedMessage$3(var0, var2, var3), var0, var1, Extension$ExtensionType.MUTABLE);
   }

   private static java.lang.reflect.Method getMethodOrDie(Class var0, String var1, Class... var2) {
      try {
         return var0.getMethod(var1, var2);
      } catch (NoSuchMethodException var6) {
         String var4 = String.valueOf(String.valueOf(var0.getName()));
         String var5 = String.valueOf(String.valueOf(var1));
         throw new RuntimeException((new StringBuilder(45 + var4.length() + var5.length())).append("Generated message class \"").append(var4).append("\" missing method \"").append(var5).append("\".").toString(), var6);
      }
   }

   private static Object invokeOrDie(java.lang.reflect.Method var0, Object var1, Object... var2) {
      try {
         return var0.invoke(var1, var2);
      } catch (IllegalAccessException var5) {
         throw new RuntimeException("Couldn\'t use Java reflection to implement protocol message reflection.", var5);
      } catch (InvocationTargetException var6) {
         Throwable var4 = var6.getCause();
         if(var4 instanceof RuntimeException) {
            throw (RuntimeException)var4;
         } else if(var4 instanceof Error) {
            throw (Error)var4;
         } else {
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", var4);
         }
      }
   }

   protected MapField internalGetMapField(int var1) {
      // $FF: Couldn't be decompiled
   }

   protected Object writeReplace() {
      return new GeneratedMessageLite$SerializedForm(this);
   }

   private static Extension checkNotLite(ExtensionLite var0) {
      if(var0.isLite()) {
         throw new IllegalArgumentException("Expected non-lite extension.");
      } else {
         return (Extension)var0;
      }
   }

   // $FF: synthetic method
   static Extension access$500(ExtensionLite var0) {
      return checkNotLite(var0);
   }

   // $FF: synthetic method
   static Map access$800(GeneratedMessage var0, boolean var1) {
      return var0.getAllFieldsMutable(var1);
   }

   // $FF: synthetic method
   static java.lang.reflect.Method access$1100(Class var0, String var1, Class[] var2) {
      return getMethodOrDie(var0, var1, var2);
   }

   // $FF: synthetic method
   static Object access$1200(java.lang.reflect.Method var0, Object var1, Object[] var2) {
      return invokeOrDie(var0, var1, var2);
   }
}
