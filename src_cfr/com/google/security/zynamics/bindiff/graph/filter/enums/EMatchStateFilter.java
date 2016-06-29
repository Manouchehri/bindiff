/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.filter.enums;

public enum EMatchStateFilter {
    NONE,
    UNMATCHED,
    MATCHED,
    MATCHED_IDENTICAL,
    MATCHED_INSTRUCTION_CHANGES,
    MATCHED_STRUTURAL_CHANGES;
    

    private EMatchStateFilter() {
    }
}

