package com.google.security.zynamics.bindiff.graph.labelcontent.editableline;

import com.google.security.zynamics.bindiff.enums.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;

public class PlaceholderObject extends AbstractEditableLineObject
{
    private final EPlaceholderType placeholderType;
    
    public PlaceholderObject(final EPlaceholderType placeholderType) {
        super(0, 0);
        Preconditions.checkNotNull(placeholderType);
        this.placeholderType = placeholderType;
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
    public boolean update(final String s) {
        return false;
    }
    
    @Override
    public boolean updateComment(final String s, final ECommentPlacement eCommentPlacement) {
        return false;
    }
}
