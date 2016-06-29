/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.labelcontent.editableline;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EPlaceholderType;
import com.google.security.zynamics.bindiff.graph.labelcontent.editableline.AbstractEditableLineObject;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ECommentPlacement;

public class PlaceholderObject
extends AbstractEditableLineObject {
    private final EPlaceholderType placeholderType;

    public PlaceholderObject(EPlaceholderType ePlaceholderType) {
        super(0, 0);
        Preconditions.checkNotNull((Object)ePlaceholderType);
        this.placeholderType = ePlaceholderType;
    }

    @Override
    public Object getPersistentModel() {
        return null;
    }

    public EPlaceholderType getPlaceholderType() {
        return this.placeholderType;
    }

    @Override
    public boolean isPlaceholder() {
        return true;
    }

    @Override
    public boolean update(String string) {
        return false;
    }

    @Override
    public boolean updateComment(String string, ECommentPlacement eCommentPlacement) {
        return false;
    }
}

