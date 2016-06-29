/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.labelcontent;

import com.google.security.zynamics.bindiff.enums.EPlaceholderType;
import com.google.security.zynamics.bindiff.graph.labelcontent.DiffLabelContent$1;
import com.google.security.zynamics.bindiff.graph.labelcontent.editableline.PlaceholderObject;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEditableObject;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import java.util.List;

public class DiffLabelContent
extends ZyLabelContent {
    public DiffLabelContent(IZyEditableObject iZyEditableObject, boolean bl2, boolean bl3) {
        super(iZyEditableObject, bl2, false);
    }

    @Override
    public int getFirstLineIndexOfModelAt(int n2) {
        ZyLineContent zyLineContent = this.getLineContent(n2);
        if (zyLineContent == null) return n2;
        IZyEditableObject iZyEditableObject = zyLineContent.getLineObject();
        int n3 = n2;
        if (iZyEditableObject.isPlaceholder()) {
            EPlaceholderType ePlaceholderType = ((PlaceholderObject)iZyEditableObject).getPlaceholderType();
            switch (DiffLabelContent$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EPlaceholderType[ePlaceholderType.ordinal()]) {
                case 1: {
                    while (--n3 > 0) {
                        IZyEditableObject iZyEditableObject2 = ((ZyLineContent)this.getContent().get(n3)).getLineObject();
                        if (!iZyEditableObject2.isPlaceholder()) return n3 + 1;
                        if (((PlaceholderObject)iZyEditableObject2).getPlaceholderType() != EPlaceholderType.MATCHED_ABOVE_INSTRUCTION_COMMENT) return n3 + 1;
                    }
                    return n3 + 1;
                }
                case 2: {
                    IZyEditableObject iZyEditableObject3;
                    while (--n3 > 0 && (iZyEditableObject3 = ((ZyLineContent)this.getContent().get(n3)).getLineObject()).isPlaceholder()) {
                    }
                    n3 = super.getFirstLineIndexOfModelAt(n3);
                    while (--n3 > 0) {
                        iZyEditableObject3 = ((ZyLineContent)this.getContent().get(n3)).getLineObject();
                        if (!iZyEditableObject3.isPlaceholder()) return ++n3;
                        if (((PlaceholderObject)iZyEditableObject3).getPlaceholderType() != EPlaceholderType.MATCHED_ABOVE_INSTRUCTION_COMMENT) return ++n3;
                    }
                    return ++n3;
                }
                case 3: 
                case 4: 
                case 5: {
                    boolean bl2 = ePlaceholderType == EPlaceholderType.UNMATCHED_INSTRUCTION || ePlaceholderType == EPlaceholderType.UNMATCHED_ABOVE_INSTRUCTION_COMMENT;
                    while (--n3 > 0) {
                        IZyEditableObject iZyEditableObject4 = ((ZyLineContent)this.getContent().get(n3)).getLineObject();
                        if (!iZyEditableObject4.isPlaceholder()) return ++n3;
                        EPlaceholderType ePlaceholderType2 = ((PlaceholderObject)iZyEditableObject4).getPlaceholderType();
                        if (bl2) {
                            if (ePlaceholderType2 == EPlaceholderType.UNMATCHED_INSTRUCTION) return ++n3;
                            if (ePlaceholderType2 != EPlaceholderType.UNMATCHED_BEHIND_INSTRUCTION_COMMENT) continue;
                            return ++n3;
                        }
                        bl2 = ePlaceholderType2 == EPlaceholderType.UNMATCHED_INSTRUCTION || ePlaceholderType2 == EPlaceholderType.UNMATCHED_ABOVE_INSTRUCTION_COMMENT;
                    }
                    return ++n3;
                }
                case 6: {
                    IZyEditableObject iZyEditableObject5;
                    do {
                        if (--n3 <= 0) return n2;
                    } while ((iZyEditableObject5 = ((ZyLineContent)this.getContent().get(n3)).getLineObject()).isPlaceholder() && ((PlaceholderObject)iZyEditableObject5).getPlaceholderType() == EPlaceholderType.BASICBLOCK_COMMENT);
                    if (!(iZyEditableObject5.getPersistentModel() instanceof RawBasicBlock)) return ++n3;
                    return super.getFirstLineIndexOfModelAt(n3);
                }
            }
            return n2;
        }
        while (--n3 >= 0) {
            IZyEditableObject iZyEditableObject6 = ((ZyLineContent)this.getContent().get(n3)).getLineObject();
            if (((ZyLineContent)this.getContent().get(n3)).getLineObject() == iZyEditableObject) continue;
            if (!iZyEditableObject6.isPlaceholder()) return ++n3;
            if (((PlaceholderObject)iZyEditableObject6).getPlaceholderType() != EPlaceholderType.MATCHED_ABOVE_INSTRUCTION_COMMENT) return ++n3;
        }
        return n2;
    }

    @Override
    public int getLastLineIndexOfModelAt(int n2) {
        List list = this.getContent();
        int n3 = list.size();
        ZyLineContent zyLineContent = this.getLineContent(n2);
        if (zyLineContent == null) return n2;
        IZyEditableObject iZyEditableObject = zyLineContent.getLineObject();
        int n4 = n2;
        if (iZyEditableObject.isPlaceholder()) {
            EPlaceholderType ePlaceholderType = ((PlaceholderObject)iZyEditableObject).getPlaceholderType();
            switch (DiffLabelContent$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EPlaceholderType[ePlaceholderType.ordinal()]) {
                case 1: {
                    IZyEditableObject iZyEditableObject2;
                    while (++n4 < n3 && (iZyEditableObject2 = ((ZyLineContent)this.getContent().get(n4)).getLineObject()).isPlaceholder()) {
                    }
                    n4 = super.getLastLineIndexOfModelAt(n4);
                    while (++n4 < n3) {
                        iZyEditableObject2 = ((ZyLineContent)this.getContent().get(n4)).getLineObject();
                        if (iZyEditableObject2.isPlaceholder() && ((PlaceholderObject)iZyEditableObject2).getPlaceholderType() == EPlaceholderType.MATCHED_BEHIND_INSTRUCTION_COMMENT) continue;
                        --n4;
                        break;
                    }
                    if (n4 < n3) return n4;
                    return n3 - 1;
                }
                case 2: {
                    while (++n4 < n3) {
                        IZyEditableObject iZyEditableObject3 = ((ZyLineContent)this.getContent().get(n4)).getLineObject();
                        if (!iZyEditableObject3.isPlaceholder()) return n3 - 1;
                        if (((PlaceholderObject)iZyEditableObject3).getPlaceholderType() != EPlaceholderType.MATCHED_BEHIND_INSTRUCTION_COMMENT) return n3 - 1;
                    }
                    return n3 - 1;
                }
                case 3: 
                case 4: 
                case 5: {
                    boolean bl2 = ePlaceholderType == EPlaceholderType.UNMATCHED_INSTRUCTION || ePlaceholderType == EPlaceholderType.UNMATCHED_BEHIND_INSTRUCTION_COMMENT;
                    while (++n4 < n3) {
                        IZyEditableObject iZyEditableObject4 = ((ZyLineContent)this.getContent().get(n4)).getLineObject();
                        if (!iZyEditableObject4.isPlaceholder()) return --n4;
                        EPlaceholderType ePlaceholderType2 = ((PlaceholderObject)iZyEditableObject4).getPlaceholderType();
                        if (bl2) {
                            if (ePlaceholderType2 == EPlaceholderType.UNMATCHED_INSTRUCTION) return --n4;
                            if (ePlaceholderType2 != EPlaceholderType.UNMATCHED_ABOVE_INSTRUCTION_COMMENT) continue;
                            return --n4;
                        }
                        bl2 = ePlaceholderType2 == EPlaceholderType.UNMATCHED_INSTRUCTION || ePlaceholderType2 == EPlaceholderType.UNMATCHED_BEHIND_INSTRUCTION_COMMENT;
                    }
                    return --n4;
                }
                case 6: {
                    return n3 - 1;
                }
            }
            return n3 - 1;
        }
        while (++n4 < n3) {
            if (((ZyLineContent)list.get(n4)).getLineObject() == iZyEditableObject) continue;
            IZyEditableObject iZyEditableObject5 = ((ZyLineContent)this.getContent().get(n4)).getLineObject();
            if (!iZyEditableObject5.isPlaceholder()) return --n4;
            if (((PlaceholderObject)iZyEditableObject5).getPlaceholderType() != EPlaceholderType.MATCHED_BEHIND_INSTRUCTION_COMMENT) return --n4;
        }
        return n3 - 1;
    }
}

