package com.google.protobuf;

import java.util.*;

public class ExtensionRegistryLite
{
    private static volatile boolean eagerlyParseMessageSets;
    private final Map extensionsByNumber;
    private static final ExtensionRegistryLite EMPTY;
    
    public static boolean isEagerlyParseMessageSets() {
        return ExtensionRegistryLite.eagerlyParseMessageSets;
    }
    
    public static void setEagerlyParseMessageSets(final boolean eagerlyParseMessageSets) {
        ExtensionRegistryLite.eagerlyParseMessageSets = eagerlyParseMessageSets;
    }
    
    public static ExtensionRegistryLite newInstance() {
        return new ExtensionRegistryLite();
    }
    
    public static ExtensionRegistryLite getEmptyRegistry() {
        return ExtensionRegistryLite.EMPTY;
    }
    
    public ExtensionRegistryLite getUnmodifiable() {
        return new ExtensionRegistryLite(this);
    }
    
    public GeneratedMessageLite$GeneratedExtension findLiteExtensionByNumber(final MessageLite messageLite, final int n) {
        return this.extensionsByNumber.get(new ExtensionRegistryLite$ObjectIntPair(messageLite, n));
    }
    
    public final void add(final GeneratedMessageLite$GeneratedExtension generatedMessageLite$GeneratedExtension) {
        this.extensionsByNumber.put(new ExtensionRegistryLite$ObjectIntPair(generatedMessageLite$GeneratedExtension.getContainingTypeDefaultInstance(), generatedMessageLite$GeneratedExtension.getNumber()), generatedMessageLite$GeneratedExtension);
    }
    
    ExtensionRegistryLite() {
        this.extensionsByNumber = new HashMap();
    }
    
    ExtensionRegistryLite(final ExtensionRegistryLite extensionRegistryLite) {
        if (extensionRegistryLite == ExtensionRegistryLite.EMPTY) {
            this.extensionsByNumber = Collections.emptyMap();
        }
        else {
            this.extensionsByNumber = Collections.unmodifiableMap((Map<?, ?>)extensionRegistryLite.extensionsByNumber);
        }
    }
    
    private ExtensionRegistryLite(final boolean b) {
        this.extensionsByNumber = Collections.emptyMap();
    }
    
    static {
        ExtensionRegistryLite.eagerlyParseMessageSets = false;
        EMPTY = new ExtensionRegistryLite(true);
    }
}
