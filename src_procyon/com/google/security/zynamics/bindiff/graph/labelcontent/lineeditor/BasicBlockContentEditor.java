package com.google.security.zynamics.bindiff.graph.labelcontent.lineeditor;

import com.google.security.zynamics.bindiff.graph.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.strings.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.project.rawflowgraph.*;
import com.google.security.zynamics.bindiff.project.helpers.*;
import com.google.security.zynamics.bindiff.graph.builders.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import java.util.*;
import com.google.security.zynamics.bindiff.graph.labelcontent.editableline.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;

public class BasicBlockContentEditor implements IZyLineEditor
{
    private static int NODELABEL_PADDING;
    private final GraphsContainer graphContainer;
    private final FunctionMatchData functionMatch;
    private final ESide side;
    
    public BasicBlockContentEditor(final FunctionMatchData functionMatch, final GraphsContainer graphsContainer, final ESide eSide) {
        this.functionMatch = functionMatch;
        this.graphContainer = (GraphsContainer)Preconditions.checkNotNull(graphsContainer);
        this.side = (ESide)Preconditions.checkNotNull(eSide);
    }
    
    private int preCountLabelCommentLines(final RawBasicBlock rawBasicBlock, final ESide eSide) {
        int n = 0;
        if (eSide == rawBasicBlock.getSide()) {
            if (!rawBasicBlock.getComment().isEmpty()) {
                n = StringHelper.count(rawBasicBlock.getComment(), '\n') + 1;
            }
        }
        else {
            SingleDiffNode singleDiffNode;
            if (eSide == ESide.PRIMARY) {
                singleDiffNode = GraphGetter.getPrimaryDiffNode(this.graphContainer.getSecondaryGraph(), rawBasicBlock);
            }
            else {
                singleDiffNode = GraphGetter.getSecondaryDiffNode(this.graphContainer.getPrimaryGraph(), rawBasicBlock);
            }
            if (singleDiffNode != null) {
                final RawBasicBlock rawBasicBlock2 = (RawBasicBlock)singleDiffNode.getRawNode();
                if (!rawBasicBlock2.getComment().isEmpty()) {
                    n = StringHelper.count(rawBasicBlock2.getComment(), '\n') + 1;
                }
            }
        }
        return n;
    }
    
    private void recreateInstruction(final ZyLabelContent zyLabelContent, final RawInstruction rawInstruction, final int n, final int n2, final int n3) {
        final RawBasicBlock rawBasicblock = ((BasicBlockLineObject)zyLabelContent.getModel()).getRawBasicblock();
        final int maxOperandLength = rawBasicblock.getMaxOperandLength();
        for (int lastLineIndexOfModel = zyLabelContent.getLastLineIndexOfModelAt(n), i = n; i <= lastLineIndexOfModel; ++i) {
            zyLabelContent.removeLine(n);
        }
        boolean matchedInstruction = false;
        if (this.functionMatch != null && rawInstruction != null) {
            matchedInstruction = MatchesGetter.isMatchedInstruction(this.functionMatch, rawBasicblock, rawInstruction);
        }
        final List buildInstruction = ViewCodeNodeBuilder.buildInstruction(rawInstruction, maxOperandLength, !matchedInstruction, this.side, n2, n3);
        int n4 = n;
        final Iterator<ZyLineContent> iterator = buildInstruction.iterator();
        while (iterator.hasNext()) {
            zyLabelContent.insertLine(iterator.next(), n4++);
        }
    }
    
    private void recreateInstructionSynchronized(final ZyLabelContent zyLabelContent, final RawInstruction rawInstruction, final int n) {
        final RawBasicBlock rawBasicblock = ((BasicBlockLineObject)zyLabelContent.getModel()).getRawBasicblock();
        final ESide side = rawBasicblock.getSide();
        RawInstruction instruction;
        RawInstruction instruction2;
        if (rawBasicblock.getSide() == ESide.PRIMARY) {
            instruction = rawInstruction;
            instruction2 = null;
            final RawBasicBlock secondaryRawBasicblock = GraphGetter.getSecondaryRawBasicblock(this.graphContainer, rawBasicblock);
            final BasicBlockMatchData basicblockMatch = MatchesGetter.getBasicblockMatch(this.functionMatch, rawBasicblock);
            if (basicblockMatch != null) {
                instruction2 = secondaryRawBasicblock.getInstruction(basicblockMatch.getSecondaryInstructionAddr(instruction.getAddress()));
            }
        }
        else {
            instruction = null;
            instruction2 = rawInstruction;
            final RawBasicBlock primaryRawBasicblock = GraphGetter.getPrimaryRawBasicblock(this.graphContainer, rawBasicblock);
            final BasicBlockMatchData basicblockMatch2 = MatchesGetter.getBasicblockMatch(this.functionMatch, rawBasicblock);
            if (basicblockMatch2 != null) {
                instruction = primaryRawBasicblock.getInstruction(basicblockMatch2.getPrimaryInstructionAddr(instruction2.getAddress()));
            }
        }
        final int precalcMaxCommentLineCount = ViewCodeNodeBuilder.precalcMaxCommentLineCount(instruction, instruction2, ECommentPlacement.ABOVE_LINE);
        final int precalcMaxCommentLineCount2 = ViewCodeNodeBuilder.precalcMaxCommentLineCount(instruction, instruction2, ECommentPlacement.BEHIND_LINE);
        zyLabelContent.setRightPadding(BasicBlockContentEditor.NODELABEL_PADDING);
        this.recreateInstruction(zyLabelContent, rawInstruction, n, precalcMaxCommentLineCount, precalcMaxCommentLineCount2);
        SingleDiffNode singleDiffNode;
        if (side == ESide.PRIMARY) {
            singleDiffNode = GraphGetter.getSecondaryDiffNode(this.graphContainer.getPrimaryGraph(), rawBasicblock);
        }
        else {
            singleDiffNode = GraphGetter.getPrimaryDiffNode(this.graphContainer.getSecondaryGraph(), rawBasicblock);
        }
        if (singleDiffNode != null) {
            final ZyLabelContent nodeContent = singleDiffNode.getRealizer().getNodeContent();
            nodeContent.setRightPadding(BasicBlockContentEditor.NODELABEL_PADDING);
            this.recreateInstruction(nodeContent, (side == ESide.PRIMARY) ? instruction2 : instruction, n, precalcMaxCommentLineCount, precalcMaxCommentLineCount2);
            final double width = zyLabelContent.getBounds().getWidth();
            final double width2 = nodeContent.getBounds().getWidth();
            if (width > width2) {
                nodeContent.setRightPadding((int)Math.round(width - width2) + 10);
            }
            else {
                zyLabelContent.setRightPadding((int)Math.round(width2 - width) + 10);
            }
            singleDiffNode.getRealizer().regenerate();
        }
        final SingleDiffNode diffNode = GraphGetter.getDiffNode(this.graphContainer, rawBasicblock);
        diffNode.getRealizer().regenerate();
        this.graphContainer.getSuperGraph().refreshSuperNodeSize(this.graphContainer.getPrimaryGraph(), this.graphContainer.getSecondaryGraph(), diffNode.getSuperDiffNode());
        this.graphContainer.updateViews();
    }
    
    private void recreateLabelComment(final ZyLabelContent zyLabelContent, final RawBasicBlock rawBasicBlock, final int n) {
        final ArrayList<ZyLineContent> list = new ArrayList<ZyLineContent>();
        final int lineCount = zyLabelContent.getLineCount();
        list.addAll((Collection<?>)ViewCodeNodeBuilder.buildBasicblockComment(rawBasicBlock, n));
        int n2 = lineCount;
        while (--n2 > 0) {
            final IZyEditableObject lineObject = zyLabelContent.getLineContent(n2).getLineObject();
            if (lineObject.isPlaceholder()) {
                if (((PlaceholderObject)lineObject).getPlaceholderType() != EPlaceholderType.BASICBLOCK_COMMENT) {
                    break;
                }
                zyLabelContent.removeLine(n2);
            }
            else {
                if (!(lineObject.getPersistentModel() instanceof RawBasicBlock)) {
                    break;
                }
                zyLabelContent.removeLine(n2);
            }
        }
        final Iterator<Object> iterator = list.iterator();
        while (iterator.hasNext()) {
            zyLabelContent.addLineContent(iterator.next());
        }
    }
    
    private void recreateLabelCommentSynchronized(final ZyLabelContent zyLabelContent, final RawBasicBlock rawBasicBlock) {
        final ESide side = rawBasicBlock.getSide();
        final int max = Math.max(this.preCountLabelCommentLines(rawBasicBlock, side), this.preCountLabelCommentLines(rawBasicBlock, (side == ESide.PRIMARY) ? ESide.SECONDARY : ESide.PRIMARY));
        zyLabelContent.setRightPadding(BasicBlockContentEditor.NODELABEL_PADDING);
        this.recreateLabelComment(zyLabelContent, rawBasicBlock, max);
        SingleDiffNode singleDiffNode;
        RawBasicBlock rawBasicBlock2;
        if (side == ESide.PRIMARY) {
            singleDiffNode = GraphGetter.getSecondaryDiffNode(this.graphContainer.getPrimaryGraph(), rawBasicBlock);
            rawBasicBlock2 = GraphGetter.getSecondaryRawBasicblock(this.graphContainer, rawBasicBlock);
        }
        else {
            singleDiffNode = GraphGetter.getPrimaryDiffNode(this.graphContainer.getSecondaryGraph(), rawBasicBlock);
            rawBasicBlock2 = GraphGetter.getPrimaryRawBasicblock(this.graphContainer, rawBasicBlock);
        }
        if (rawBasicBlock2 != null) {
            final ZyLabelContent nodeContent = singleDiffNode.getRealizer().getNodeContent();
            nodeContent.setRightPadding(BasicBlockContentEditor.NODELABEL_PADDING);
            this.recreateLabelComment(nodeContent, rawBasicBlock2, max);
            final double width = zyLabelContent.getBounds().getWidth();
            final double width2 = nodeContent.getBounds().getWidth();
            if (width > width2) {
                nodeContent.setRightPadding((int)Math.round(width - width2) + BasicBlockContentEditor.NODELABEL_PADDING);
            }
            else {
                zyLabelContent.setRightPadding((int)Math.round(width2 - width) + BasicBlockContentEditor.NODELABEL_PADDING);
            }
            singleDiffNode.getRealizer().regenerate();
        }
        final SingleDiffNode diffNode = GraphGetter.getDiffNode(this.graphContainer, rawBasicBlock);
        diffNode.getRealizer().regenerate();
        this.graphContainer.getSuperGraph().refreshSuperNodeSize(this.graphContainer.getPrimaryGraph(), this.graphContainer.getSecondaryGraph(), diffNode.getSuperDiffNode());
        this.graphContainer.updateViews();
    }
    
    private boolean validateLineCountEquality(final ZyLabelContent zyLabelContent, final RawBasicBlock rawBasicBlock) {
        SingleDiffNode singleDiffNode;
        RawBasicBlock rawBasicBlock2;
        if (rawBasicBlock.getSide() == ESide.PRIMARY) {
            singleDiffNode = GraphGetter.getSecondaryDiffNode(this.graphContainer.getPrimaryGraph(), rawBasicBlock);
            rawBasicBlock2 = GraphGetter.getSecondaryRawBasicblock(this.graphContainer, rawBasicBlock);
        }
        else {
            singleDiffNode = GraphGetter.getPrimaryDiffNode(this.graphContainer.getSecondaryGraph(), rawBasicBlock);
            rawBasicBlock2 = GraphGetter.getPrimaryRawBasicblock(this.graphContainer, rawBasicBlock);
        }
        return rawBasicBlock2 == null || zyLabelContent.getLineCount() == singleDiffNode.getRealizer().getNodeContent().getLineCount();
    }
    
    @Override
    public void recreateLabelLines(final ZyLabelContent zyLabelContent, final Object o) {
        int firstLineIndexOfModel = 0;
        final Iterator<ZyLineContent> iterator = zyLabelContent.getContent().iterator();
        while (iterator.hasNext()) {
            final IZyEditableObject lineObject = iterator.next().getLineObject();
            if (lineObject != null && lineObject.getPersistentModel() == o) {
                if (o instanceof RawBasicBlock) {
                    this.recreateLabelCommentSynchronized(zyLabelContent, (RawBasicBlock)o);
                    return;
                }
                if (o instanceof RawInstruction) {
                    firstLineIndexOfModel = zyLabelContent.getFirstLineIndexOfModelAt(firstLineIndexOfModel);
                    this.recreateInstructionSynchronized(zyLabelContent, (RawInstruction)o, firstLineIndexOfModel);
                    if (!this.validateLineCountEquality(zyLabelContent, ((BasicBlockLineObject)zyLabelContent.getModel()).getRawBasicblock())) {
                        throw new RuntimeException("Pimary and secondary basicblock label content line count are not equal.");
                    }
                }
            }
            ++firstLineIndexOfModel;
        }
        if (o instanceof RawBasicBlock) {
            this.recreateLabelCommentSynchronized(zyLabelContent, (RawBasicBlock)o);
            if (!this.validateLineCountEquality(zyLabelContent, ((BasicBlockLineObject)zyLabelContent.getModel()).getRawBasicblock())) {
                throw new RuntimeException("Pimary and secondary basicblock label content line count are not equal.");
            }
        }
    }
    
    @Override
    public void refreshSize(final ZyLabelContent zyLabelContent, final Object o) {
        RawBasicBlock rawBasicblock;
        if (o instanceof RawBasicBlock) {
            rawBasicblock = (RawBasicBlock)o;
        }
        else {
            if (!(o instanceof RawInstruction)) {
                return;
            }
            rawBasicblock = ((BasicBlockLineObject)zyLabelContent.getModel()).getRawBasicblock();
        }
        this.graphContainer.getSuperGraph().refreshSuperNodeSize(this.graphContainer.getPrimaryGraph(), this.graphContainer.getPrimaryGraph(), GraphGetter.getDiffNode(this.graphContainer, rawBasicblock).getSuperDiffNode());
    }
    
    static {
        BasicBlockContentEditor.NODELABEL_PADDING = 10;
    }
}
