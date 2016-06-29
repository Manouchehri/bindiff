package com.google.security.zynamics.bindiff.graph.labelcontent;

import com.google.security.zynamics.bindiff.graph.labelcontent.editableline.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.project.rawflowgraph.*;
import java.util.*;

public class DiffLabelContent extends ZyLabelContent
{
    public DiffLabelContent(final IZyEditableObject zyEditableObject, final boolean b, final boolean b2) {
        super(zyEditableObject, b, false);
    }
    
    @Override
    public int getFirstLineIndexOfModelAt(int n) {
        final ZyLineContent lineContent = this.getLineContent(n);
        if (lineContent != null) {
            final IZyEditableObject lineObject = lineContent.getLineObject();
            if (lineObject.isPlaceholder()) {
                final EPlaceholderType placeholderType = ((PlaceholderObject)lineObject).getPlaceholderType();
                switch (DiffLabelContent$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EPlaceholderType[placeholderType.ordinal()]) {
                    case 1: {
                        while (--n > 0) {
                            final IZyEditableObject lineObject2 = this.getContent().get(n).getLineObject();
                            if (lineObject2.isPlaceholder() && ((PlaceholderObject)lineObject2).getPlaceholderType() == EPlaceholderType.MATCHED_ABOVE_INSTRUCTION_COMMENT) {
                                continue;
                            }
                            break;
                        }
                        return n + 1;
                    }
                    case 2: {
                        while (--n > 0 && this.getContent().get(n).getLineObject().isPlaceholder()) {}
                        int firstLineIndexOfModel = super.getFirstLineIndexOfModelAt(n);
                        while (--firstLineIndexOfModel > 0) {
                            final IZyEditableObject lineObject3 = this.getContent().get(firstLineIndexOfModel).getLineObject();
                            if (lineObject3.isPlaceholder() && ((PlaceholderObject)lineObject3).getPlaceholderType() == EPlaceholderType.MATCHED_ABOVE_INSTRUCTION_COMMENT) {
                                continue;
                            }
                            break;
                        }
                        return ++firstLineIndexOfModel;
                    }
                    case 3:
                    case 4:
                    case 5: {
                        boolean b = placeholderType == EPlaceholderType.UNMATCHED_INSTRUCTION || placeholderType == EPlaceholderType.UNMATCHED_ABOVE_INSTRUCTION_COMMENT;
                        while (--n > 0) {
                            final IZyEditableObject lineObject4 = this.getContent().get(n).getLineObject();
                            if (!lineObject4.isPlaceholder()) {
                                break;
                            }
                            final EPlaceholderType placeholderType2 = ((PlaceholderObject)lineObject4).getPlaceholderType();
                            if (b) {
                                if (placeholderType2 == EPlaceholderType.UNMATCHED_INSTRUCTION) {
                                    break;
                                }
                                if (placeholderType2 == EPlaceholderType.UNMATCHED_BEHIND_INSTRUCTION_COMMENT) {
                                    break;
                                }
                                continue;
                            }
                            else {
                                b = (placeholderType2 == EPlaceholderType.UNMATCHED_INSTRUCTION || placeholderType2 == EPlaceholderType.UNMATCHED_ABOVE_INSTRUCTION_COMMENT);
                            }
                        }
                        return ++n;
                    }
                    case 6: {
                        while (--n > 0) {
                            final IZyEditableObject lineObject5 = this.getContent().get(n).getLineObject();
                            if (lineObject5.isPlaceholder() && ((PlaceholderObject)lineObject5).getPlaceholderType() == EPlaceholderType.BASICBLOCK_COMMENT) {
                                continue;
                            }
                            if (lineObject5.getPersistentModel() instanceof RawBasicBlock) {
                                return super.getFirstLineIndexOfModelAt(n);
                            }
                            return ++n;
                        }
                        break;
                    }
                }
            }
            else {
                while (--n >= 0) {
                    final IZyEditableObject lineObject6 = this.getContent().get(n).getLineObject();
                    if (this.getContent().get(n).getLineObject() != lineObject) {
                        if (lineObject6.isPlaceholder() && ((PlaceholderObject)lineObject6).getPlaceholderType() == EPlaceholderType.MATCHED_ABOVE_INSTRUCTION_COMMENT) {
                            continue;
                        }
                        return ++n;
                    }
                }
            }
        }
        return n;
    }
    
    @Override
    public int getLastLineIndexOfModelAt(int n) {
        final List content = this.getContent();
        final int size = content.size();
        final ZyLineContent lineContent = this.getLineContent(n);
        if (lineContent != null) {
            final IZyEditableObject lineObject = lineContent.getLineObject();
            if (lineObject.isPlaceholder()) {
                final EPlaceholderType placeholderType = ((PlaceholderObject)lineObject).getPlaceholderType();
                switch (DiffLabelContent$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EPlaceholderType[placeholderType.ordinal()]) {
                    case 1: {
                        while (++n < size && this.getContent().get(n).getLineObject().isPlaceholder()) {}
                        int lastLineIndexOfModel = super.getLastLineIndexOfModelAt(n);
                        while (++lastLineIndexOfModel < size) {
                            final IZyEditableObject lineObject2 = this.getContent().get(lastLineIndexOfModel).getLineObject();
                            if (lineObject2.isPlaceholder() && ((PlaceholderObject)lineObject2).getPlaceholderType() == EPlaceholderType.MATCHED_BEHIND_INSTRUCTION_COMMENT) {
                                continue;
                            }
                            --lastLineIndexOfModel;
                            break;
                        }
                        if (lastLineIndexOfModel >= size) {
                            lastLineIndexOfModel = size - 1;
                        }
                        return lastLineIndexOfModel;
                    }
                    case 2: {
                        while (++n < size) {
                            final IZyEditableObject lineObject3 = this.getContent().get(n).getLineObject();
                            if (lineObject3.isPlaceholder() && ((PlaceholderObject)lineObject3).getPlaceholderType() == EPlaceholderType.MATCHED_BEHIND_INSTRUCTION_COMMENT) {
                                continue;
                            }
                            break;
                        }
                        return size - 1;
                    }
                    case 3:
                    case 4:
                    case 5: {
                        boolean b = placeholderType == EPlaceholderType.UNMATCHED_INSTRUCTION || placeholderType == EPlaceholderType.UNMATCHED_BEHIND_INSTRUCTION_COMMENT;
                        while (++n < size) {
                            final IZyEditableObject lineObject4 = this.getContent().get(n).getLineObject();
                            if (!lineObject4.isPlaceholder()) {
                                break;
                            }
                            final EPlaceholderType placeholderType2 = ((PlaceholderObject)lineObject4).getPlaceholderType();
                            if (b) {
                                if (placeholderType2 == EPlaceholderType.UNMATCHED_INSTRUCTION) {
                                    break;
                                }
                                if (placeholderType2 == EPlaceholderType.UNMATCHED_ABOVE_INSTRUCTION_COMMENT) {
                                    break;
                                }
                                continue;
                            }
                            else {
                                b = (placeholderType2 == EPlaceholderType.UNMATCHED_INSTRUCTION || placeholderType2 == EPlaceholderType.UNMATCHED_BEHIND_INSTRUCTION_COMMENT);
                            }
                        }
                        return --n;
                    }
                    case 6: {
                        return size - 1;
                    }
                }
            }
            else {
                while (++n < size) {
                    if (content.get(n).getLineObject() != lineObject) {
                        final IZyEditableObject lineObject5 = this.getContent().get(n).getLineObject();
                        if (lineObject5.isPlaceholder() && ((PlaceholderObject)lineObject5).getPlaceholderType() == EPlaceholderType.MATCHED_BEHIND_INSTRUCTION_COMMENT) {
                            continue;
                        }
                        return --n;
                    }
                }
            }
            return size - 1;
        }
        return n;
    }
}
