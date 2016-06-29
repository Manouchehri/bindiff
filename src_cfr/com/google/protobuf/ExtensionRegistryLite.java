/*
 * Decompiled with CFR 0_115.
 */
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

    public static void setEagerlyParseMessageSets(boolean bl2) {
        eagerlyParseMessageSets = bl2;
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

    public GeneratedMessageLite$GeneratedExtension findLiteExtensionByNumber(MessageLite messageLite, int n2) {
        return (GeneratedMessageLite$GeneratedExtension)this.extensionsByNumber.get(new ExtensionRegistryLite$ObjectIntPair(messageLite, n2));
    }

    public final void add(GeneratedMessageLite$GeneratedExtension generatedMessageLite$GeneratedExtension) {
        this.extensionsByNumber.put(new ExtensionRegistryLite$ObjectIntPair(generatedMessageLite$GeneratedExtension.getContainingTypeDefaultInstance(), generatedMessageLite$GeneratedExtension.getNumber()), generatedMessageLite$GeneratedExtension);
    }

    ExtensionRegistryLite() {
        this.extensionsByNumber = new HashMap();
    }

    ExtensionRegistryLite(ExtensionRegistryLite extensionRegistryLite) {
        if (extensionRegistryLite == EMPTY) {
            this.extensionsByNumber = Collections.emptyMap();
            return;
        }
        this.extensionsByNumber = Collections.unmodifiableMap(extensionRegistryLite.extensionsByNumber);
    }

    private ExtensionRegistryLite(boolean bl2) {
        this.extensionsByNumber = Collections.emptyMap();
    }
}

