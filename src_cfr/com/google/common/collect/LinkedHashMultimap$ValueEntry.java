/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableEntry;
import com.google.common.collect.LinkedHashMultimap$ValueSetLink;
import javax.annotation.Nullable;

@VisibleForTesting
final class LinkedHashMultimap$ValueEntry
extends ImmutableEntry
implements LinkedHashMultimap$ValueSetLink {
    final int smearedValueHash;
    @Nullable
    LinkedHashMultimap$ValueEntry nextInValueBucket;
    LinkedHashMultimap$ValueSetLink predecessorInValueSet;
    LinkedHashMultimap$ValueSetLink successorInValueSet;
    LinkedHashMultimap$ValueEntry predecessorInMultimap;
    LinkedHashMultimap$ValueEntry successorInMultimap;

    LinkedHashMultimap$ValueEntry(@Nullable Object object, @Nullable Object object2, int n2, @Nullable LinkedHashMultimap$ValueEntry linkedHashMultimap$ValueEntry) {
        super(object, object2);
        this.smearedValueHash = n2;
        this.nextInValueBucket = linkedHashMultimap$ValueEntry;
    }

    boolean matchesValue(@Nullable Object object, int n2) {
        if (this.smearedValueHash != n2) return false;
        if (!Objects.equal(this.getValue(), object)) return false;
        return true;
    }

    @Override
    public LinkedHashMultimap$ValueSetLink getPredecessorInValueSet() {
        return this.predecessorInValueSet;
    }

    @Override
    public LinkedHashMultimap$ValueSetLink getSuccessorInValueSet() {
        return this.successorInValueSet;
    }

    @Override
    public void setPredecessorInValueSet(LinkedHashMultimap$ValueSetLink linkedHashMultimap$ValueSetLink) {
        this.predecessorInValueSet = linkedHashMultimap$ValueSetLink;
    }

    @Override
    public void setSuccessorInValueSet(LinkedHashMultimap$ValueSetLink linkedHashMultimap$ValueSetLink) {
        this.successorInValueSet = linkedHashMultimap$ValueSetLink;
    }

    public LinkedHashMultimap$ValueEntry getPredecessorInMultimap() {
        return this.predecessorInMultimap;
    }

    public LinkedHashMultimap$ValueEntry getSuccessorInMultimap() {
        return this.successorInMultimap;
    }

    public void setSuccessorInMultimap(LinkedHashMultimap$ValueEntry linkedHashMultimap$ValueEntry) {
        this.successorInMultimap = linkedHashMultimap$ValueEntry;
    }

    public void setPredecessorInMultimap(LinkedHashMultimap$ValueEntry linkedHashMultimap$ValueEntry) {
        this.predecessorInMultimap = linkedHashMultimap$ValueEntry;
    }
}

