package com.google.security.zynamics.bindiff.graph.builders;

import com.google.security.zynamics.zylib.strings.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.common.base.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.log.*;
import java.io.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.Tokenizer.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;
import com.google.security.zynamics.bindiff.resources.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import com.google.security.zynamics.bindiff.types.*;
import java.util.*;
import com.google.common.collect.*;
import com.google.security.zynamics.bindiff.graph.labelcontent.editableline.*;
import com.google.security.zynamics.bindiff.project.rawflowgraph.*;

public class ViewCodeNodeBuilder
{
    private static final String ABOVE_INSTRUCTION_COMMENT_ESCAPE_STRING = "// ";
    private static final String BEHIND_INSTRUCTION_COMMNET_ESCAPE_STRING = " // ";
    private static final String BASICBLOCK_COMMENT_HEADLINE_STRING = "// Basic Block Commment: ";
    private static final String BASICBLOCK_COMMENT_ESCAPE_STRING = "// ";
    public static final int MAX_MNEMONIC_SIZE = 12;
    private static final String PADDING_AFTER_ADDRESS = "   ";
    private static final String PADDING_AFTER_FUNCTION_ADDRESS = "   ";
    private static final PlaceholderObject PLACEHOLDER_MATCHED_ABOVE_INSTRUCTION_COMMENT;
    private static final PlaceholderObject PLACEHOLDER_MATCHED_BEHIND_INSTRUCTION_COMMENT;
    private static final PlaceholderObject PLACEHOLDER_UNMATCHED_ABOVE_INSTRUCTION_COMMENT;
    private static final PlaceholderObject PLACEHOLDER_UNMATCHED_INSTRUCTION;
    private static final PlaceholderObject PLACEHOLDER_UNMATCHED_BEHIND_INSTRUCTION_COMMENT;
    private static final PlaceholderObject PLACEHOLDER_BASICBLOCK_COMMENT;
    
    private static void buildAddress(final RawInstruction rawInstruction, final StringBuffer sb, final List list) {
        final String value = String.valueOf(rawInstruction.getAddress().toHexString());
        final String value2 = String.valueOf("   ");
        final String s = (value2.length() != 0) ? value.concat(value2) : new String(value);
        list.add(new CStyleRunData(0, s.length(), EInstructionHighlighting.getColor(EInstructionHighlighting.TYPE_ADDRESS)));
        sb.append(s);
    }
    
    private static void buildBasicblockComments(final RawBasicBlock rawBasicBlock, final RawBasicBlock rawBasicBlock2, final ZyLabelContent zyLabelContent, final ESide eSide) {
        int n = 0;
        if (rawBasicBlock != null) {
            n = StringHelper.count(rawBasicBlock.getComment(), '\n');
        }
        if (rawBasicBlock2 != null) {
            n = Math.max(n, StringHelper.count(rawBasicBlock2.getComment(), '\n'));
        }
        final Iterator iterator = buildBasicblockComment((eSide == ESide.PRIMARY) ? rawBasicBlock : rawBasicBlock2, n).iterator();
        while (iterator.hasNext()) {
            zyLabelContent.addLineContent(iterator.next());
        }
    }
    
    private static void buildMatchedCodeNodeContent(final RawBasicBlock rawBasicBlock, final RawBasicBlock rawBasicBlock2, final List list, final ZyLabelContent zyLabelContent, final ESide eSide) {
        final ArrayList<ZyLineContent> list2 = new ArrayList<ZyLineContent>();
        if (eSide == ESide.PRIMARY) {
            zyLabelContent.addLineContent(buildHeadline(rawBasicBlock));
            final int maxOperandLength = rawBasicBlock.getMaxOperandLength();
            for (final Pair pair : list) {
                RawInstruction instruction = null;
                if (rawBasicBlock != null && pair.first() != null) {
                    instruction = rawBasicBlock.getInstruction((IAddress)pair.first());
                }
                RawInstruction instruction2 = null;
                if (rawBasicBlock2 != null && pair.second() != null) {
                    instruction2 = rawBasicBlock2.getInstruction((IAddress)pair.second());
                }
                list2.addAll((Collection<?>)buildInstruction(instruction, maxOperandLength, pair.second() == null, eSide, precalcMaxCommentLineCount(instruction, instruction2, ECommentPlacement.ABOVE_LINE), precalcMaxCommentLineCount(instruction, instruction2, ECommentPlacement.BEHIND_LINE)));
            }
        }
        else {
            zyLabelContent.addLineContent(buildHeadline(rawBasicBlock2));
            final int maxOperandLength2 = rawBasicBlock2.getMaxOperandLength();
            for (final Pair pair2 : list) {
                RawInstruction instruction3 = null;
                if (rawBasicBlock != null && pair2.first() != null) {
                    instruction3 = rawBasicBlock.getInstruction((IAddress)pair2.first());
                }
                RawInstruction instruction4 = null;
                if (rawBasicBlock2 != null && pair2.second() != null) {
                    instruction4 = rawBasicBlock2.getInstruction((IAddress)pair2.second());
                }
                list2.addAll((Collection<?>)buildInstruction(instruction4, maxOperandLength2, pair2.first() == null, eSide, precalcMaxCommentLineCount(instruction3, instruction4, ECommentPlacement.ABOVE_LINE), precalcMaxCommentLineCount(instruction3, instruction4, ECommentPlacement.BEHIND_LINE)));
            }
        }
        final Iterator<Object> iterator3 = list2.iterator();
        while (iterator3.hasNext()) {
            zyLabelContent.addLineContent(iterator3.next());
        }
        buildBasicblockComments(rawBasicBlock, rawBasicBlock2, zyLabelContent, eSide);
    }
    
    private static void buildMnemonic(final RawInstruction rawInstruction, final StringBuffer sb, final List list) {
        if (rawInstruction.getMnemonic().length() == 0) {
            return;
        }
        String s = rawInstruction.getMnemonic();
        if (rawInstruction.getOperands().length > 0) {
            s = Strings.padEnd(rawInstruction.getMnemonic(), rawInstruction.getMaxMnemonicLen(), ' ');
        }
        list.add(new CStyleRunData(sb.length(), s.length(), EInstructionHighlighting.getColor(EInstructionHighlighting.TYPE_MNEMONIC)));
        sb.append(s);
    }
    
    private static boolean appendStyleRunData(final ByteArrayOutputStream byteArrayOutputStream, final Color color, final StringBuffer sb, final List list) {
        if (byteArrayOutputStream == null || color == null) {
            return true;
        }
        if (byteArrayOutputStream.size() != 0) {
            final String string = byteArrayOutputStream.toString();
            list.add(new CStyleRunData(sb.length(), string.length(), color));
            sb.append(string);
            try {
                byteArrayOutputStream.close();
            }
            catch (IOException ex) {
                Logger.logWarning("Couldn't close ByteArrayOutputStream.", new Object[0]);
            }
            return true;
        }
        return false;
    }
    
    private static void buildOperands(final RawInstruction rawInstruction, final StringBuffer sb, final List list) {
        final byte[] operands = rawInstruction.getOperands();
        ByteArrayOutputStream byteArrayOutputStream = null;
        Color color = null;
        for (int i = 0; i < operands.length; ++i) {
            if (operands[i] < EInstructionHighlighting.getSize() && operands[i] > 0) {
                if (appendStyleRunData(byteArrayOutputStream, color, sb, list)) {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    color = EInstructionHighlighting.getColor(operands[i]);
                }
            }
            else {
                byteArrayOutputStream.write(operands[i]);
            }
        }
        appendStyleRunData(byteArrayOutputStream, color, sb, list);
    }
    
    private static List buildRightComment(final RawInstruction rawInstruction, final InstructionObject instructionObject, final RawInstructionComment rawInstructionComment, final StringBuffer sb, final List list, final int n, final boolean b, final ESide eSide, final int n2) {
        final ArrayList<ZyLineContent> list2 = new ArrayList<ZyLineContent>();
        String text = "";
        if (rawInstructionComment != null) {
            final int length = sb.length();
            final int n3 = rawInstruction.getAddress().toHexString().length() + "   ".length() + 12 + n;
            final Color color = EInstructionHighlighting.getColor(EInstructionHighlighting.TYPE_COMMENT);
            text = rawInstructionComment.getText();
            final CMultiCommentLineTokenizer cMultiCommentLineTokenizer = new CMultiCommentLineTokenizer(text, "\n");
            int n4 = 1;
            while (cMultiCommentLineTokenizer.hasMoreTokens()) {
                final String nextToken = cMultiCommentLineTokenizer.nextToken();
                if (n4 != 0) {
                    n4 = 0;
                    final String value = String.valueOf(Strings.repeat(" ", Math.max(0, n3 - length)));
                    final String value2 = String.valueOf(" // ");
                    final String s = (value2.length() != 0) ? value.concat(value2) : new String(value);
                    final int length2 = s.length();
                    list.add(new CStyleRunData(length, length2, color, new InstructionCommentDelimiterLineObject(rawInstruction, rawInstructionComment.getPlacement(), length, length2)));
                    sb.append(s);
                    if (!nextToken.isEmpty()) {
                        list.add(new CStyleRunData(sb.length(), nextToken.length(), color, new CInstructionCommentLineObject(rawInstruction, rawInstructionComment.getPlacement(), sb.length(), nextToken.length())));
                        sb.append(nextToken);
                    }
                    final ZyLineContent zyLineContent = new ZyLineContent(sb.toString(), Fonts.NORMAL_FONT, list, instructionObject);
                    if (b) {
                        zyLineContent.setBackgroundColor(0, length, (eSide == ESide.PRIMARY) ? Colors.PRIMARY_BASE : Colors.SECONDARY_BASE);
                    }
                    list2.add(zyLineContent);
                }
                else {
                    final ArrayList<CStyleRunData> list3 = new ArrayList<CStyleRunData>();
                    String format = String.format("%s%s", Strings.repeat(" ", n3), " // ");
                    list3.add(new CStyleRunData(0, format.length(), color, new InstructionCommentDelimiterLineObject(rawInstruction, rawInstructionComment.getPlacement(), 0, format.length())));
                    if (!nextToken.equals("")) {
                        list3.add(new CStyleRunData(format.length(), nextToken.length(), color, new CInstructionCommentLineObject(rawInstruction, rawInstructionComment.getPlacement(), format.length(), nextToken.length())));
                        final String value3 = String.valueOf(format);
                        final String value4 = String.valueOf(nextToken);
                        format = ((value4.length() != 0) ? value3.concat(value4) : new String(value3));
                    }
                    list2.add(new ZyLineContent(format, Fonts.NORMAL_FONT, list3, instructionObject));
                }
            }
        }
        if (text.isEmpty()) {
            final ZyLineContent zyLineContent2 = new ZyLineContent(sb.toString(), Fonts.NORMAL_FONT, list, instructionObject);
            if (b) {
                zyLineContent2.setBackgroundColor(0, sb.length(), (eSide == ESide.PRIMARY) ? Colors.PRIMARY_BASE : Colors.SECONDARY_BASE);
            }
            list2.add(zyLineContent2);
        }
        if (list2.size() < n2) {
            list2.addAll((Collection<?>)buildPlaceholderLines(n2 - list2.size(), EPlaceholderType.MATCHED_BEHIND_INSTRUCTION_COMMENT));
        }
        return list2;
    }
    
    private static List buildTopComment(final RawInstruction rawInstruction, final InstructionObject instructionObject, final RawInstructionComment rawInstructionComment, final int n) {
        if (rawInstructionComment == null) {
            return buildPlaceholderLines(n, EPlaceholderType.MATCHED_ABOVE_INSTRUCTION_COMMENT);
        }
        final ArrayList<ZyLineContent> list = new ArrayList<ZyLineContent>();
        final CMultiCommentLineTokenizer cMultiCommentLineTokenizer = new CMultiCommentLineTokenizer(rawInstructionComment.getText(), "\n");
        final Color color = EInstructionHighlighting.getColor(EInstructionHighlighting.TYPE_COMMENT);
        while (cMultiCommentLineTokenizer.hasMoreTokens()) {
            final ArrayList<CStyleRunData> list2 = new ArrayList<CStyleRunData>();
            final String s = "// ";
            list2.add(new CStyleRunData(0, s.length(), color, new InstructionCommentDelimiterLineObject(rawInstruction, rawInstructionComment.getPlacement(), 0, s.length())));
            final String nextToken = cMultiCommentLineTokenizer.nextToken();
            final CInstructionCommentLineObject cInstructionCommentLineObject = new CInstructionCommentLineObject(rawInstruction, rawInstructionComment.getPlacement(), s.length(), nextToken.length());
            final String value = String.valueOf(s);
            final String value2 = String.valueOf(nextToken);
            final String s2 = (value2.length() != 0) ? value.concat(value2) : new String(value);
            list2.add(new CStyleRunData(0, s2.length(), color, cInstructionCommentLineObject));
            list.add(new ZyLineContent(s2, Fonts.NORMAL_FONT, list2, instructionObject));
        }
        if (list.size() < n) {
            final ArrayList list3 = new ArrayList();
            list3.addAll(buildPlaceholderLines(n - list.size(), EPlaceholderType.MATCHED_ABOVE_INSTRUCTION_COMMENT));
            list3.addAll(list);
            return list3;
        }
        return list;
    }
    
    private static void buildUnmatchedCodeNodeContent(final RawBasicBlock rawBasicBlock, final ZyLabelContent zyLabelContent) {
        zyLabelContent.addLineContent(buildHeadline(rawBasicBlock));
        final ArrayList<ZyLineContent> list = new ArrayList<ZyLineContent>();
        final int maxOperandLength = rawBasicBlock.getMaxOperandLength();
        final Iterator iterator = rawBasicBlock.iterator();
        while (iterator.hasNext()) {
            list.addAll((Collection<?>)buildInstruction(iterator.next(), maxOperandLength, false, null, 0, 0));
        }
        final Iterator<Object> iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            zyLabelContent.addLineContent(iterator2.next());
        }
        buildBasicblockComments((rawBasicBlock.getSide() == ESide.PRIMARY) ? rawBasicBlock : null, (rawBasicBlock.getSide() == ESide.SECONDARY) ? rawBasicBlock : null, zyLabelContent, rawBasicBlock.getSide());
    }
    
    private static List getMatchedFunctionsBasicblockInstructionAddressPairs(final FunctionMatchData functionMatchData, final RawCombinedFlowGraph rawCombinedFlowGraph, final IAddress address, final IAddress address2) {
        final ArrayList<Pair> list = new ArrayList<Pair>();
        final RawFlowGraph primaryFlowgraph = rawCombinedFlowGraph.getPrimaryFlowgraph();
        final RawFlowGraph secondaryFlowgraph = rawCombinedFlowGraph.getSecondaryFlowgraph();
        if (address != null && address2 != null) {
            final BasicBlockMatchData basicblockMatch = functionMatchData.getBasicblockMatch(address, ESide.PRIMARY);
            for (final InstructionMatchData instructionMatchData : basicblockMatch.getInstructionMatches()) {
                list.add(new Pair(instructionMatchData.getIAddress(ESide.PRIMARY), instructionMatchData.getIAddress(ESide.SECONDARY)));
            }
            for (final Map.Entry<IAddress, V> entry : primaryFlowgraph.getBasicblock(address).getInstructions().entrySet()) {
                if (basicblockMatch.getInstructionMatch(entry.getKey(), ESide.PRIMARY) == null) {
                    list.add(new Pair(entry.getKey(), null));
                }
            }
            for (final Map.Entry<IAddress, V> entry2 : secondaryFlowgraph.getBasicblock(address2).getInstructions().entrySet()) {
                if (basicblockMatch.getInstructionMatch(entry2.getKey(), ESide.SECONDARY) == null) {
                    list.add(new Pair(null, entry2.getKey()));
                }
            }
        }
        else if (address != null) {
            final Iterator<Map.Entry<Object, V>> iterator3 = primaryFlowgraph.getBasicblock(address).getInstructions().entrySet().iterator();
            while (iterator3.hasNext()) {
                list.add(new Pair(iterator3.next().getKey(), null));
            }
        }
        else if (address2 != null) {
            final Iterator<Map.Entry<Object, V>> iterator4 = secondaryFlowgraph.getBasicblock(address2).getInstructions().entrySet().iterator();
            while (iterator4.hasNext()) {
                list.add(new Pair(null, iterator4.next().getKey()));
            }
        }
        return list;
    }
    
    private static List getMatchedFunctionsBasicblockInstructionAddressPairs(final FunctionMatchData functionMatchData, final RawCombinedFlowGraph rawCombinedFlowGraph, final IAddress address, final IAddress address2, final ESide eSide) {
        List<E> list = (List<E>)new ArrayList<Object>(getMatchedFunctionsBasicblockInstructionAddressPairs(functionMatchData, rawCombinedFlowGraph, address, address2));
        final ArrayList list2 = new ArrayList<Pair>();
        final ArrayList list3 = new ArrayList<Object>();
        for (Pair pair : list) {
            if (ESide.SECONDARY == eSide) {
                pair = new Pair(pair.second(), pair.first());
            }
            if (pair.first() != null) {
                list2.add((T)pair);
            }
            if (pair.second() != null) {
                list3.add(pair);
            }
        }
        Collections.sort((List<E>)list2, new AddressPairComparator(ESide.PRIMARY));
        Collections.sort((List<E>)list3, new AddressPairComparator(ESide.SECONDARY));
        list.clear();
        if (list2.size() == 0) {
            list = list3;
        }
        if (list3.size() == 0) {
            list = list2;
        }
        if (list2.size() != 0 && list3.size() != 0) {
            int n = 0;
            for (final Pair pair2 : list2) {
                if (pair2.second() == null) {
                    list.add((E)pair2);
                }
                else {
                    if (n >= list3.size()) {
                        continue;
                    }
                    for (int i = 1; i != 0; i = 0) {
                        final Pair pair3 = list3.get(n);
                        if (pair3.first() == null) {
                            list.add((E)pair3);
                        }
                        else {
                            i = 0;
                        }
                        if (++n >= list3.size()) {}
                    }
                    list.add((E)pair2);
                }
            }
        }
        final ArrayList<Pair> list4 = new ArrayList<Pair>();
        int j = list3.size();
        while (j > 0) {
            --j;
            if (((Pair)list3.get(j)).first() != null) {
                break;
            }
            list4.add((Pair)list3.get(j));
        }
        Collections.sort((List<Object>)list4, new AddressPairComparator(ESide.SECONDARY));
        list.addAll((Collection<? extends E>)list4);
        final List<E> list5 = list;
        if (ESide.SECONDARY == eSide) {
            list5.clear();
            for (final Pair pair4 : list) {
                list5.add((E)new Pair(pair4.second(), pair4.first()));
            }
        }
        return list5;
    }
    
    public static List buildBasicblockComment(final RawBasicBlock rawBasicBlock, final int n) {
        final Color color = EInstructionHighlighting.getColor(EInstructionHighlighting.TYPE_COMMENT);
        final BasicBlockLineObject basicBlockLineObject = new BasicBlockLineObject(rawBasicBlock);
        final ArrayList<Object> list = new ArrayList<Object>();
        final String comment = rawBasicBlock.getComment();
        int n2 = 1;
        final CMultiCommentLineTokenizer cMultiCommentLineTokenizer = new CMultiCommentLineTokenizer(comment, "\n");
        int n3 = 0;
        while (cMultiCommentLineTokenizer.hasMoreTokens()) {
            ++n3;
            final String nextToken = cMultiCommentLineTokenizer.nextToken();
            final String value = String.valueOf("// ");
            final String value2 = String.valueOf(nextToken);
            String s = (value2.length() != 0) ? value.concat(value2) : new String(value);
            int n4 = "// ".length();
            if (n2 != 0) {
                final String value3 = String.valueOf("// Basic Block Commment: ");
                final String value4 = String.valueOf(nextToken);
                s = ((value4.length() != 0) ? value3.concat(value4) : new String(value3));
                n4 = "// Basic Block Commment: ".length();
                n2 = 0;
            }
            final BasicBlockCommentDelimiterLineObject basicBlockCommentDelimiterLineObject = new BasicBlockCommentDelimiterLineObject(rawBasicBlock, 0, n4);
            final BasicBlockCommentLineObject basicBlockCommentLineObject = new BasicBlockCommentLineObject(rawBasicBlock, n4, nextToken.length());
            final ArrayList<CStyleRunData> list2 = new ArrayList<CStyleRunData>();
            list2.add(new CStyleRunData(0, n4, color, basicBlockCommentDelimiterLineObject));
            list2.add(new CStyleRunData(n4, nextToken.length(), color, basicBlockCommentLineObject));
            list.add(new ZyLineContent(s, Fonts.NORMAL_FONT, list2, basicBlockLineObject));
        }
        if (n3 < n) {
            list.addAll(buildPlaceholderLines(n - n3, EPlaceholderType.BASICBLOCK_COMMENT));
        }
        return list;
    }
    
    public static ZyLineContent buildHeadline(final RawBasicBlock rawBasicBlock) {
        return new ZyLineContent(String.format("%s%s%s", rawBasicBlock.getFunctionAddr().toHexString(), "   ", rawBasicBlock.getFunctionName()), Fonts.BOLD_FONT, Lists.newArrayList(new CStyleRunData(0, -1, Color.BLACK)), new BasicBlockHeadLineObject(rawBasicBlock));
    }
    
    public static List buildInstruction(final RawInstruction rawInstruction, final int n, final boolean b, final ESide eSide, final int n2, final int n3) {
        final ArrayList list = new ArrayList();
        final StringBuffer sb = new StringBuffer();
        final ArrayList list2 = new ArrayList();
        if (rawInstruction != null) {
            RawInstructionComment rawInstructionComment = null;
            RawInstructionComment rawInstructionComment2 = null;
            if (rawInstruction.hasComments()) {
                for (final RawInstructionComment rawInstructionComment3 : rawInstruction.getComments()) {
                    if (rawInstructionComment3.getPlacement() == ECommentPlacement.ABOVE_LINE) {
                        rawInstructionComment = rawInstructionComment3;
                    }
                    else {
                        if (rawInstructionComment3.getPlacement() != ECommentPlacement.BEHIND_LINE) {
                            continue;
                        }
                        rawInstructionComment2 = rawInstructionComment3;
                    }
                }
            }
            buildAddress(rawInstruction, sb, list2);
            buildMnemonic(rawInstruction, sb, list2);
            buildOperands(rawInstruction, sb, list2);
            final InstructionObject instructionObject = new InstructionObject(rawInstruction, 0, sb.length());
            list.addAll(buildTopComment(rawInstruction, instructionObject, rawInstructionComment, n2));
            list.addAll(buildRightComment(rawInstruction, instructionObject, rawInstructionComment2, sb, list2, n, b, eSide, n3));
        }
        else {
            list.addAll(buildPlaceholderLines(n2, EPlaceholderType.UNMATCHED_ABOVE_INSTRUCTION_COMMENT));
            list.addAll(buildPlaceholderLines(1, EPlaceholderType.UNMATCHED_INSTRUCTION));
            list.addAll(buildPlaceholderLines(n3 - 1, EPlaceholderType.UNMATCHED_BEHIND_INSTRUCTION_COMMENT));
        }
        return list;
    }
    
    public static List buildPlaceholderLines(final int n, final EPlaceholderType ePlaceholderType) {
        final ArrayList<ZyLineContent> list = new ArrayList<ZyLineContent>();
        IZyEditableObject zyEditableObject = null;
        switch (ViewCodeNodeBuilder$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EPlaceholderType[ePlaceholderType.ordinal()]) {
            case 1: {
                zyEditableObject = ViewCodeNodeBuilder.PLACEHOLDER_MATCHED_ABOVE_INSTRUCTION_COMMENT;
                break;
            }
            case 2: {
                zyEditableObject = ViewCodeNodeBuilder.PLACEHOLDER_MATCHED_BEHIND_INSTRUCTION_COMMENT;
                break;
            }
            case 3: {
                zyEditableObject = ViewCodeNodeBuilder.PLACEHOLDER_UNMATCHED_ABOVE_INSTRUCTION_COMMENT;
                break;
            }
            case 4: {
                zyEditableObject = ViewCodeNodeBuilder.PLACEHOLDER_UNMATCHED_INSTRUCTION;
                break;
            }
            case 5: {
                zyEditableObject = ViewCodeNodeBuilder.PLACEHOLDER_UNMATCHED_BEHIND_INSTRUCTION_COMMENT;
                break;
            }
            case 6: {
                zyEditableObject = ViewCodeNodeBuilder.PLACEHOLDER_BASICBLOCK_COMMENT;
                break;
            }
        }
        for (int i = 0; i < n; ++i) {
            list.add(new ZyLineContent("\t", Fonts.NORMAL_FONT, zyEditableObject));
        }
        return list;
    }
    
    public static void buildSingleCodeNodeContent(final FunctionMatchData functionMatchData, final RawCombinedFlowGraph rawCombinedFlowGraph, final RawCombinedBasicBlock rawCombinedBasicBlock, final ZyLabelContent zyLabelContent, final ESide eSide) {
        final RawBasicBlock rawNode = rawCombinedBasicBlock.getRawNode(ESide.PRIMARY);
        final RawBasicBlock rawNode2 = rawCombinedBasicBlock.getRawNode(ESide.SECONDARY);
        if (eSide == ESide.PRIMARY) {
            if (rawNode2 == null) {
                buildUnmatchedCodeNodeContent(rawNode, zyLabelContent);
                return;
            }
        }
        else if (rawNode == null) {
            buildUnmatchedCodeNodeContent(rawNode2, zyLabelContent);
            return;
        }
        final IAddress address = rawCombinedBasicBlock.getAddress(ESide.PRIMARY);
        final IAddress address2 = rawCombinedBasicBlock.getAddress(ESide.SECONDARY);
        buildMatchedCodeNodeContent(rawCombinedFlowGraph.getPrimaryFlowgraph().getBasicblock(address), rawCombinedFlowGraph.getSecondaryFlowgraph().getBasicblock(address2), getMatchedFunctionsBasicblockInstructionAddressPairs(functionMatchData, rawCombinedFlowGraph, address, address2, ESide.PRIMARY), zyLabelContent, eSide);
    }
    
    public static int precalcMaxCommentLineCount(final RawInstruction rawInstruction, final RawInstruction rawInstruction2, final ECommentPlacement eCommentPlacement) {
        int n = (eCommentPlacement == ECommentPlacement.BEHIND_LINE) ? 1 : 0;
        int n2 = (eCommentPlacement == ECommentPlacement.BEHIND_LINE) ? 1 : 0;
        if (rawInstruction != null && rawInstruction.hasComments()) {
            for (final RawInstructionComment rawInstructionComment : rawInstruction.getComments()) {
                if (rawInstructionComment.getPlacement() == eCommentPlacement && !rawInstructionComment.getText().isEmpty()) {
                    n = StringHelper.count(rawInstructionComment.getText(), '\n') + 1;
                }
            }
        }
        if (rawInstruction2 != null && rawInstruction2.getComments() != null) {
            for (final RawInstructionComment rawInstructionComment2 : rawInstruction2.getComments()) {
                if (rawInstructionComment2.getPlacement() == eCommentPlacement && !rawInstructionComment2.getText().isEmpty()) {
                    n2 = StringHelper.count(rawInstructionComment2.getText(), '\n') + 1;
                }
            }
        }
        return Math.max(n, n2);
    }
    
    static {
        PLACEHOLDER_MATCHED_ABOVE_INSTRUCTION_COMMENT = new PlaceholderObject(EPlaceholderType.MATCHED_ABOVE_INSTRUCTION_COMMENT);
        PLACEHOLDER_MATCHED_BEHIND_INSTRUCTION_COMMENT = new PlaceholderObject(EPlaceholderType.MATCHED_BEHIND_INSTRUCTION_COMMENT);
        PLACEHOLDER_UNMATCHED_ABOVE_INSTRUCTION_COMMENT = new PlaceholderObject(EPlaceholderType.UNMATCHED_ABOVE_INSTRUCTION_COMMENT);
        PLACEHOLDER_UNMATCHED_INSTRUCTION = new PlaceholderObject(EPlaceholderType.UNMATCHED_INSTRUCTION);
        PLACEHOLDER_UNMATCHED_BEHIND_INSTRUCTION_COMMENT = new PlaceholderObject(EPlaceholderType.UNMATCHED_BEHIND_INSTRUCTION_COMMENT);
        PLACEHOLDER_BASICBLOCK_COMMENT = new PlaceholderObject(EPlaceholderType.BASICBLOCK_COMMENT);
    }
}
