package com.google.protobuf;

import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.Extension;
import com.google.protobuf.Extension$ExtensionType;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$4;
import com.google.protobuf.GeneratedMessage$ExtensionDescriptorRetriever;
import com.google.protobuf.GeneratedMessage$GeneratedExtension$1;
import com.google.protobuf.Message;
import com.google.protobuf.WireFormat$FieldType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class GeneratedMessage$GeneratedExtension extends Extension {
   private GeneratedMessage$ExtensionDescriptorRetriever descriptorRetriever;
   private final Class singularType;
   private final Message messageDefaultInstance;
   private final java.lang.reflect.Method enumValueOf;
   private final java.lang.reflect.Method enumGetValueDescriptor;
   private final Extension$ExtensionType extensionType;

   GeneratedMessage$GeneratedExtension(GeneratedMessage$ExtensionDescriptorRetriever var1, Class var2, Message var3, Extension$ExtensionType var4) {
      // $FF: Couldn't be decompiled
   }

   public void internalInit(Descriptors$FieldDescriptor var1) {
      if(this.descriptorRetriever != null) {
         throw new IllegalStateException("Already initialized.");
      } else {
         this.descriptorRetriever = new GeneratedMessage$GeneratedExtension$1(this, var1);
      }
   }

   public Descriptors$FieldDescriptor getDescriptor() {
      if(this.descriptorRetriever == null) {
         throw new IllegalStateException("getDescriptor() called before internalInit()");
      } else {
         return this.descriptorRetriever.getDescriptor();
      }
   }

   public Message getMessageDefaultInstance() {
      return this.messageDefaultInstance;
   }

   protected Extension$ExtensionType getExtensionType() {
      return this.extensionType;
   }

   protected Object fromReflectionType(Object var1) {
      Descriptors$FieldDescriptor var2 = this.getDescriptor();
      if(!var2.isRepeated()) {
         return this.singularFromReflectionType(var1);
      } else if(var2.getJavaType() != Descriptors$FieldDescriptor$JavaType.MESSAGE && var2.getJavaType() != Descriptors$FieldDescriptor$JavaType.ENUM) {
         return var1;
      } else {
         ArrayList var3 = new ArrayList();
         Iterator var4 = ((List)var1).iterator();

         while(var4.hasNext()) {
            Object var5 = var4.next();
            var3.add(this.singularFromReflectionType(var5));
         }

         return var3;
      }
   }

   protected Object singularFromReflectionType(Object var1) {
      Descriptors$FieldDescriptor var2 = this.getDescriptor();
      switch(GeneratedMessage$4.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[var2.getJavaType().ordinal()]) {
      case 1:
         if(this.singularType.isInstance(var1)) {
            return var1;
         }

         return this.messageDefaultInstance.newBuilderForType().mergeFrom((Message)var1).build();
      case 2:
         return GeneratedMessage.access$1200(this.enumValueOf, (Object)null, new Object[]{(Descriptors$EnumValueDescriptor)var1});
      default:
         return var1;
      }
   }

   protected Object toReflectionType(Object var1) {
      Descriptors$FieldDescriptor var2 = this.getDescriptor();
      if(!var2.isRepeated()) {
         return this.singularToReflectionType(var1);
      } else if(var2.getJavaType() != Descriptors$FieldDescriptor$JavaType.ENUM) {
         return var1;
      } else {
         ArrayList var3 = new ArrayList();
         Iterator var4 = ((List)var1).iterator();

         while(var4.hasNext()) {
            Object var5 = var4.next();
            var3.add(this.singularToReflectionType(var5));
         }

         return var3;
      }
   }

   protected Object singularToReflectionType(Object var1) {
      Descriptors$FieldDescriptor var2 = this.getDescriptor();
      switch(GeneratedMessage$4.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[var2.getJavaType().ordinal()]) {
      case 2:
         return GeneratedMessage.access$1200(this.enumGetValueDescriptor, var1, new Object[0]);
      default:
         return var1;
      }
   }

   public int getNumber() {
      return this.getDescriptor().getNumber();
   }

   public WireFormat$FieldType getLiteType() {
      return this.getDescriptor().getLiteType();
   }

   public boolean isRepeated() {
      return this.getDescriptor().isRepeated();
   }

   public Object getDefaultValue() {
      return this.isRepeated()?Collections.emptyList():(this.getDescriptor().getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE?this.messageDefaultInstance:this.singularFromReflectionType(this.getDescriptor().getDefaultValue()));
   }
}
