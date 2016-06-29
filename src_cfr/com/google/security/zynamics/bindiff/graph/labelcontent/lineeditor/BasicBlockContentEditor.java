/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.labelcontent.lineeditor;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EPlaceholderType;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import com.google.security.zynamics.bindiff.graph.builders.ViewCodeNodeBuilder;
import com.google.security.zynamics.bindiff.graph.labelcontent.editableline.BasicBlockLineObject;
import com.google.security.zynamics.bindiff.graph.labelcontent.editableline.PlaceholderObject;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperDiffNode;
import com.google.security.zynamics.bindiff.project.helpers.GraphGetter;
import com.google.security.zynamics.bindiff.project.helpers.MatchesGetter;
import com.google.security.zynamics.bindiff.project.matches.BasicBlockMatchData;
import com.google.security.zynamics.bindiff.project.matches.FunctionMatchData;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawInstruction;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ECommentPlacement;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEditableObject;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyLineEditor;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import com.google.security.zynamics.zylib.strings.StringHelper;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class BasicBlockContentEditor
implements IZyLineEditor {
    private static int NODELABEL_PADDING = 10;
    private final GraphsContainer graphContainer;
    private final FunctionMatchData functionMatch;
    private final ESide side;

    public BasicBlockContentEditor(FunctionMatchData functionMatchData, GraphsContainer graphsContainer, ESide eSide) {
        this.functionMatch = functionMatchData;
        this.graphContainer = (GraphsContainer)Preconditions.checkNotNull(graphsContainer);
        this.side = (ESide)((Object)Preconditions.checkNotNull((Object)eSide));
    }

    private int preCountLabelCommentLines(RawBasicBlock rawBasicBlock, ESide eSide) {
        int n2 = 0;
        if (eSide == rawBasicBlock.getSide()) {
            if (rawBasicBlock.getComment().isEmpty()) return n2;
            return StringHelper.count(rawBasicBlock.getComment(), '\n') + 1;
        }
        SingleDiffNode singleDiffNode = null;
        singleDiffNode = eSide == ESide.PRIMARY ? GraphGetter.getPrimaryDiffNode(this.graphContainer.getSecondaryGraph(), rawBasicBlock) : GraphGetter.getSecondaryDiffNode(this.graphContainer.getPrimaryGraph(), rawBasicBlock);
        if (singleDiffNode == null) return n2;
        RawBasicBlock rawBasicBlock2 = (RawBasicBlock)singleDiffNode.getRawNode();
        if (rawBasicBlock2.getComment().isEmpty()) return n2;
        return StringHelper.count(rawBasicBlock2.getComment(), '\n') + 1;
    }

    private void recreateInstruction(ZyLabelContent zyLabelContent, RawInstruction rawInstruction, int n2, int n3, int n4) {
        int n5;
        RawBasicBlock rawBasicBlock = ((BasicBlockLineObject)zyLabelContent.getModel()).getRawBasicblock();
        int n6 = rawBasicBlock.getMaxOperandLength();
        int n7 = zyLabelContent.getLastLineIndexOfModelAt(n2);
        for (n5 = n2; n5 <= n7; ++n5) {
            zyLabelContent.removeLine(n2);
        }
        n5 = 0;
        if (this.functionMatch != null && rawInstruction != null) {
            n5 = (int)MatchesGetter.isMatchedInstruction(this.functionMatch, rawBasicBlock, rawInstruction) ? 1 : 0;
        }
        List list = ViewCodeNodeBuilder.buildInstruction(rawInstruction, n6, n5 == 0, this.side, n3, n4);
        int n8 = n2;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ZyLineContent zyLineContent = (ZyLineContent)iterator.next();
            zyLabelContent.insertLine(zyLineContent, n8++);
        }
    }

    private void recreateInstructionSynchronized(ZyLabelContent zyLabelContent, RawInstruction rawInstruction, int n2) {
        BasicBlockMatchData basicBlockMatchData;
        Object object;
        Object object2;
        RawBasicBlock rawBasicBlock;
        RawBasicBlock rawBasicBlock2 = ((BasicBlockLineObject)zyLabelContent.getModel()).getRawBasicblock();
        ESide eSide = rawBasicBlock2.getSide();
        RawInstruction rawInstruction2 = null;
        RawInstruction rawInstruction3 = null;
        if (rawBasicBlock2.getSide() == ESide.PRIMARY) {
            rawInstruction2 = rawInstruction;
            rawInstruction3 = null;
            rawBasicBlock = GraphGetter.getSecondaryRawBasicblock(this.graphContainer, rawBasicBlock2);
            basicBlockMatchData = MatchesGetter.getBasicblockMatch(this.functionMatch, rawBasicBlock2);
            if (basicBlockMatchData != null) {
                object = basicBlockMatchData.getSecondaryInstructionAddr(rawInstruction2.getAddress());
                rawInstruction3 = rawBasicBlock.getInstruction((IAddress)object);
            }
        } else {
            rawInstruction2 = null;
            rawInstruction3 = rawInstruction;
            rawBasicBlock = GraphGetter.getPrimaryRawBasicblock(this.graphContainer, rawBasicBlock2);
            basicBlockMatchData = MatchesGetter.getBasicblockMatch(this.functionMatch, rawBasicBlock2);
            if (basicBlockMatchData != null) {
                object = basicBlockMatchData.getPrimaryInstructionAddr(rawInstruction3.getAddress());
                rawInstruction2 = rawBasicBlock.getInstruction((IAddress)object);
            }
        }
        int n3 = ViewCodeNodeBuilder.precalcMaxCommentLineCount(rawInstruction2, rawInstruction3, ECommentPlacement.ABOVE_LINE);
        int n4 = ViewCodeNodeBuilder.precalcMaxCommentLineCount(rawInstruction2, rawInstruction3, ECommentPlacement.BEHIND_LINE);
        zyLabelContent.setRightPadding(NODELABEL_PADDING);
        this.recreateInstruction(zyLabelContent, rawInstruction, n2, n3, n4);
        object = null;
        object = eSide == ESide.PRIMARY ? GraphGetter.getSecondaryDiffNode(this.graphContainer.getPrimaryGraph(), rawBasicBlock2) : GraphGetter.getPrimaryDiffNode(this.graphContainer.getSecondaryGraph(), rawBasicBlock2);
        if (object != null) {
            object2 = object.getRealizer().getNodeContent();
            object2.setRightPadding(NODELABEL_PADDING);
            this.recreateInstruction((ZyLabelContent)object2, eSide == ESide.PRIMARY ? rawInstruction3 : rawInstruction2, n2, n3, n4);
            double d2 = zyLabelContent.getBounds().getWidth();
            double d3 = object2.getBounds().getWidth();
            if (d2 > d3) {
                object2.setRightPadding((int)Math.round(d2 - d3) + 10);
            } else {
                zyLabelContent.setRightPadding((int)Math.round(d3 - d2) + 10);
            }
            object.getRealizer().regenerate();
        }
        object2 = GraphGetter.getDiffNode(this.graphContainer, rawBasicBlock2);
        object2.getRealizer().regenerate();
        this.graphContainer.getSuperGraph().refreshSuperNodeSize(this.graphContainer.getPrimaryGraph(), this.graphContainer.getSecondaryGraph(), object2.getSuperDiffNode());
        this.graphContainer.updateViews();
    }

    private void recreateLabelComment(ZyLabelContent zyLabelContent, RawBasicBlock rawBasicBlock, int n2) {
        Object object;
        Object object2;
        ArrayList arrayList = new ArrayList();
        int n3 = zyLabelContent.getLineCount();
        arrayList.addAll(ViewCodeNodeBuilder.buildBasicblockComment(rawBasicBlock, n2));
        int n4 = n3;
        while (--n4 > 0) {
            object = zyLabelContent.getLineContent(n4);
            object2 = object.getLineObject();
            if (object2.isPlaceholder()) {
                if (((PlaceholderObject)object2).getPlaceholderType() != EPlaceholderType.BASICBLOCK_COMMENT) break;
                zyLabelContent.removeLine(n4);
                continue;
            }
            if (!(object2.getPersistentModel() instanceof RawBasicBlock)) break;
            zyLabelContent.removeLine(n4);
        }
        object = arrayList.iterator();
        while (object.hasNext()) {
            object2 = (ZyLineContent)object.next();
            zyLabelContent.addLineContent((ZyLineContent)object2);
        }
    }

    private void recreateLabelCommentSynchronized(ZyLabelContent zyLabelContent, RawBasicBlock rawBasicBlock) {
        Object object;
        ESide eSide = rawBasicBlock.getSide();
        int n2 = this.preCountLabelCommentLines(rawBasicBlock, eSide);
        int n3 = this.preCountLabelCommentLines(rawBasicBlock, eSide == ESide.PRIMARY ? ESide.SECONDARY : ESide.PRIMARY);
        int n4 = Math.max(n2, n3);
        zyLabelContent.setRightPadding(NODELABEL_PADDING);
        this.recreateLabelComment(zyLabelContent, rawBasicBlock, n4);
        SingleDiffNode singleDiffNode = null;
        RawBasicBlock rawBasicBlock2 = null;
        if (eSide == ESide.PRIMARY) {
            singleDiffNode = GraphGetter.getSecondaryDiffNode(this.graphContainer.getPrimaryGraph(), rawBasicBlock);
            rawBasicBlock2 = GraphGetter.getSecondaryRawBasicblock(this.graphContainer, rawBasicBlock);
        } else {
            singleDiffNode = GraphGetter.getPrimaryDiffNode(this.graphContainer.getSecondaryGraph(), rawBasicBlock);
            rawBasicBlock2 = GraphGetter.getPrimaryRawBasicblock(this.graphContainer, rawBasicBlock);
        }
        if (rawBasicBlock2 != null) {
            object = singleDiffNode.getRealizer().getNodeContent();
            object.setRightPadding(NODELABEL_PADDING);
            this.recreateLabelComment((ZyLabelContent)object, rawBasicBlock2, n4);
            double d2 = zyLabelContent.getBounds().getWidth();
            double d3 = object.getBounds().getWidth();
            if (d2 > d3) {
                object.setRightPadding((int)Math.round(d2 - d3) + NODELABEL_PADDING);
            } else {
                zyLabelContent.setRightPadding((int)Math.round(d3 - d2) + NODELABEL_PADDING);
            }
            singleDiffNode.getRealizer().regenerate();
        }
        object = GraphGetter.getDiffNode(this.graphContainer, rawBasicBlock);
        object.getRealizer().regenerate();
        this.graphContainer.getSuperGraph().refreshSuperNodeSize(this.graphContainer.getPrimaryGraph(), this.graphContainer.getSecondaryGraph(), object.getSuperDiffNode());
        this.graphContainer.updateViews();
    }

    private boolean validateLineCountEquality(ZyLabelContent zyLabelContent, RawBasicBlock rawBasicBlock) {
        SingleDiffNode singleDiffNode;
        RawBasicBlock rawBasicBlock2;
        ESide eSide = rawBasicBlock.getSide();
        if (eSide == ESide.PRIMARY) {
            singleDiffNode = GraphGetter.getSecondaryDiffNode(this.graphContainer.getPrimaryGraph(), rawBasicBlock);
            rawBasicBlock2 = GraphGetter.getSecondaryRawBasicblock(this.graphContainer, rawBasicBlock);
        } else {
            singleDiffNode = GraphGetter.getPrimaryDiffNode(this.graphContainer.getSecondaryGraph(), rawBasicBlock);
            rawBasicBlock2 = GraphGetter.getPrimaryRawBasicblock(this.graphContainer, rawBasicBlock);
        }
        if (rawBasicBlock2 == null) return true;
        ZyLabelContent zyLabelContent2 = singleDiffNode.getRealizer().getNodeContent();
        if (zyLabelContent.getLineCount() != zyLabelContent2.getLineCount()) return false;
        return true;
    }

    @Override
    public void recreateLabelLines(ZyLabelContent zyLabelContent, Object object) {
        int n2 = 0;
        Iterator iterator = zyLabelContent.getContent().iterator();
        do {
            if (!iterator.hasNext()) {
                if (!(object instanceof RawBasicBlock)) return;
                this.recreateLabelCommentSynchronized(zyLabelContent, (RawBasicBlock)object);
                if (this.validateLineCountEquality(zyLabelContent, ((BasicBlockLineObject)zyLabelContent.getModel()).getRawBasicblock())) return;
                throw new RuntimeException("Pimary and secondary basicblock label content line count are not equal.");
            }
            ZyLineContent zyLineContent = (ZyLineContent)iterator.next();
            IZyEditableObject iZyEditableObject = zyLineContent.getLineObject();
            if (iZyEditableObject != null && iZyEditableObject.getPersistentModel() == object) {
                if (object instanceof RawBasicBlock) {
                    this.recreateLabelCommentSynchronized(zyLabelContent, (RawBasicBlock)object);
                    return;
                }
                if (object instanceof RawInstruction) {
                    n2 = zyLabelContent.getFirstLineIndexOfModelAt(n2);
                    this.recreateInstructionSynchronized(zyLabelContent, (RawInstruction)object, n2);
                    if (!this.validateLineCountEquality(zyLabelContent, ((BasicBlockLineObject)zyLabelContent.getModel()).getRawBasicblock())) {
                        throw new RuntimeException("Pimary and secondary basicblock label content line count are not equal.");
                    }
                }
            }
            ++n2;
        } while (true);
    }

    @Override
    public void refreshSize(ZyLabelContent zyLabelContent, Object object) {
        RawBasicBlock rawBasicBlock = null;
        if (object instanceof RawBasicBlock) {
            rawBasicBlock = (RawBasicBlock)object;
        } else {
            if (!(object instanceof RawInstruction)) return;
            rawBasicBlock = ((BasicBlockLineObject)zyLabelContent.getModel()).getRawBasicblock();
        }
        SingleDiffNode singleDiffNode = GraphGetter.getDiffNode(this.graphContainer, rawBasicBlock);
        this.graphContainer.getSuperGraph().refreshSuperNodeSize(this.graphContainer.getPrimaryGraph(), this.graphContainer.getPrimaryGraph(), singleDiffNode.getSuperDiffNode());
    }
}

