package com.google.common.collect;

import com.google.common.annotations.*;
import javax.annotation.*;
import com.google.common.base.*;

@VisibleForTesting
final class LinkedHashMultimap$ValueEntry extends ImmutableEntry implements LinkedHashMultimap$ValueSetLink
{
    final int smearedValueHash;
    @Nullable
    LinkedHashMultimap$ValueEntry nextInValueBucket;
    LinkedHashMultimap$ValueSetLink predecessorInValueSet;
    LinkedHashMultimap$ValueSetLink successorInValueSet;
    LinkedHashMultimap$ValueEntry predecessorInMultimap;
    LinkedHashMultimap$ValueEntry successorInMultimap;
    
    LinkedHashMultimap$ValueEntry(@Nullable final Object o, @Nullable final Object o2, final int smearedValueHash, @Nullable final LinkedHashMultimap$ValueEntry nextInValueBucket) {
        super(o, o2);
        this.smearedValueHash = smearedValueHash;
        this.nextInValueBucket = nextInValueBucket;
    }
    
    boolean matchesValue(@Nullable final Object o, final int n) {
        return this.smearedValueHash == n && Objects.equal(this.getValue(), o);
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
    public void setPredecessorInValueSet(final LinkedHashMultimap$ValueSetLink predecessorInValueSet) {
        this.predecessorInValueSet = predecessorInValueSet;
    }
    
    @Override
    public void setSuccessorInValueSet(final LinkedHashMultimap$ValueSetLink successorInValueSet) {
        this.successorInValueSet = successorInValueSet;
    }
    
    public LinkedHashMultimap$ValueEntry getPredecessorInMultimap() {
        return this.predecessorInMultimap;
    }
    
    public LinkedHashMultimap$ValueEntry getSuccessorInMultimap() {
        return this.successorInMultimap;
    }
    
    public void setSuccessorInMultimap(final LinkedHashMultimap$ValueEntry successorInMultimap) {
        this.successorInMultimap = successorInMultimap;
    }
    
    public void setPredecessorInMultimap(final LinkedHashMultimap$ValueEntry predecessorInMultimap) {
        this.predecessorInMultimap = predecessorInMultimap;
    }
}
