package com.google.protobuf;

import com.google.protobuf.ExtensionRegistryLite$ObjectIntPair;
import com.google.protobuf.GeneratedMessageLite$GeneratedExtension;
import com.google.protobuf.MessageLite;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ExtensionRegistryLite {
   private static volatile boolean eagerlyParseMessageSets = false;
   private final Map extensionsByNumber;
   private static final ExtensionRegistryLite EMPTY = new ExtensionRegistryLite(true);

   public static boolean isEagerlyParseMessageSets() {
      return eagerlyParseMessageSets;
   }

   public static void setEagerlyParseMessageSets(boolean var0) {
      eagerlyParseMessageSets = var0;
   }

   public static ExtensionRegistryLite newInstance() {
      return new ExtensionRegistryLite();
   }

   public static ExtensionRegistryLite getEmptyRegistry() {
      return EMPTY;
   }

   public ExtensionRegistryLite getUnmodifiable() {
      return new ExtensionRegistryLite(this);
   }

   public GeneratedMessageLite$GeneratedExtension findLiteExtensionByNumber(MessageLite var1, int var2) {
      return (GeneratedMessageLite$GeneratedExtension)this.extensionsByNumber.get(new ExtensionRegistryLite$ObjectIntPair(var1, var2));
   }

   public final void add(GeneratedMessageLite$GeneratedExtension var1) {
      this.extensionsByNumber.put(new ExtensionRegistryLite$ObjectIntPair(var1.getContainingTypeDefaultInstance(), var1.getNumber()), var1);
   }

   ExtensionRegistryLite() {
      this.extensionsByNumber = new HashMap();
   }

   ExtensionRegistryLite(ExtensionRegistryLite var1) {
      if(var1 == EMPTY) {
         this.extensionsByNumber = Collections.emptyMap();
      } else {
         this.extensionsByNumber = Collections.unmodifiableMap(var1.extensionsByNumber);
      }

   }

   private ExtensionRegistryLite(boolean var1) {
      this.extensionsByNumber = Collections.emptyMap();
   }
}
