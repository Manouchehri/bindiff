/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.builders;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.security.zynamics.bindiff.enums.EInstructionHighlighting;
import com.google.security.zynamics.bindiff.enums.EPlaceholderType;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.builders.ViewCodeNodeBuilder$1;
import com.google.security.zynamics.bindiff.graph.labelcontent.editableline.BasicBlockCommentDelimiterLineObject;
import com.google.security.zynamics.bindiff.graph.labelcontent.editableline.BasicBlockCommentLineObject;
import com.google.security.zynamics.bindiff.graph.labelcontent.editableline.BasicBlockHeadLineObject;
import com.google.security.zynamics.bindiff.graph.labelcontent.editableline.BasicBlockLineObject;
import com.google.security.zynamics.bindiff.graph.labelcontent.editableline.CInstructionCommentLineObject;
import com.google.security.zynamics.bindiff.graph.labelcontent.editableline.InstructionCommentDelimiterLineObject;
import com.google.security.zynamics.bindiff.graph.labelcontent.editableline.InstructionObject;
import com.google.security.zynamics.bindiff.graph.labelcontent.editableline.PlaceholderObject;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.project.matches.BasicBlockMatchData;
import com.google.security.zynamics.bindiff.project.matches.FunctionMatchData;
import com.google.security.zynamics.bindiff.project.matches.InstructionMatchData;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedFlowGraph;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawFlowGraph;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawInstruction;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawInstructionComment;
import com.google.security.zynamics.bindiff.resources.Colors;
import com.google.security.zynamics.bindiff.resources.Fonts;
import com.google.security.zynamics.bindiff.types.AddressPairComparator;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.CStyleRunData;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ECommentPlacement;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEditableObject;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.Tokenizer.CMultiCommentLineTokenizer;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import com.google.security.zynamics.zylib.strings.StringHelper;
import java.awt.Color;
import java.awt.Font;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

public class ViewCodeNodeBuilder {
    private static final String ABOVE_INSTRUCTION_COMMENT_ESCAPE_STRING = "// ";
    private static final String BEHIND_INSTRUCTION_COMMNET_ESCAPE_STRING = " // ";
    private static final String BASICBLOCK_COMMENT_HEADLINE_STRING = "// Basic Block Commment: ";
    private static final String BASICBLOCK_COMMENT_ESCAPE_STRING = "// ";
    public static final int MAX_MNEMONIC_SIZE = 12;
    private static final String PADDING_AFTER_ADDRESS = "   ";
    private static final String PADDING_AFTER_FUNCTION_ADDRESS = "   ";
    private static final PlaceholderObject PLACEHOLDER_MATCHED_ABOVE_INSTRUCTION_COMMENT = new PlaceholderObject(EPlaceholderType.MATCHED_ABOVE_INSTRUCTION_COMMENT);
    private static final PlaceholderObject PLACEHOLDER_MATCHED_BEHIND_INSTRUCTION_COMMENT = new PlaceholderObject(EPlaceholderType.MATCHED_BEHIND_INSTRUCTION_COMMENT);
    private static final PlaceholderObject PLACEHOLDER_UNMATCHED_ABOVE_INSTRUCTION_COMMENT = new PlaceholderObject(EPlaceholderType.UNMATCHED_ABOVE_INSTRUCTION_COMMENT);
    private static final PlaceholderObject PLACEHOLDER_UNMATCHED_INSTRUCTION = new PlaceholderObject(EPlaceholderType.UNMATCHED_INSTRUCTION);
    private static final PlaceholderObject PLACEHOLDER_UNMATCHED_BEHIND_INSTRUCTION_COMMENT = new PlaceholderObject(EPlaceholderType.UNMATCHED_BEHIND_INSTRUCTION_COMMENT);
    private static final PlaceholderObject PLACEHOLDER_BASICBLOCK_COMMENT = new PlaceholderObject(EPlaceholderType.BASICBLOCK_COMMENT);

    private static void buildAddress(RawInstruction rawInstruction, StringBuffer stringBuffer, List list) {
        String string = String.valueOf(rawInstruction.getAddress().toHexString());
        String string2 = String.valueOf("   ");
        String string3 = string2.length() != 0 ? string.concat(string2) : new String(string);
        Color color = EInstructionHighlighting.getColor(EInstructionHighlighting.TYPE_ADDRESS);
        list.add(new CStyleRunData(0, string3.length(), color));
        stringBuffer.append(string3);
    }

    private static void buildBasicblockComments(RawBasicBlock rawBasicBlock, RawBasicBlock rawBasicBlock2, ZyLabelContent zyLabelContent, ESide eSide) {
        int n2 = 0;
        if (rawBasicBlock != null) {
            n2 = StringHelper.count(rawBasicBlock.getComment(), '\n');
        }
        if (rawBasicBlock2 != null) {
            n2 = Math.max(n2, StringHelper.count(rawBasicBlock2.getComment(), '\n'));
        }
        RawBasicBlock rawBasicBlock3 = eSide == ESide.PRIMARY ? rawBasicBlock : rawBasicBlock2;
        Iterator iterator = ViewCodeNodeBuilder.buildBasicblockComment(rawBasicBlock3, n2).iterator();
        while (iterator.hasNext()) {
            ZyLineContent zyLineContent = (ZyLineContent)iterator.next();
            zyLabelContent.addLineContent(zyLineContent);
        }
    }

    private static void buildMatchedCodeNodeContent(RawBasicBlock rawBasicBlock, RawBasicBlock rawBasicBlock2, List list, ZyLabelContent zyLabelContent, ESide eSide) {
        int n2;
        RawInstruction rawInstruction;
        RawInstruction rawInstruction2;
        int n3;
        int n4;
        ArrayList arrayList = new ArrayList();
        if (eSide == ESide.PRIMARY) {
            zyLabelContent.addLineContent(ViewCodeNodeBuilder.buildHeadline(rawBasicBlock));
            n2 = rawBasicBlock.getMaxOperandLength();
            for (Pair pair : list) {
                rawInstruction2 = null;
                if (rawBasicBlock != null && pair.first() != null) {
                    rawInstruction2 = rawBasicBlock.getInstruction((IAddress)pair.first());
                }
                rawInstruction = null;
                if (rawBasicBlock2 != null && pair.second() != null) {
                    rawInstruction = rawBasicBlock2.getInstruction((IAddress)pair.second());
                }
                n4 = ViewCodeNodeBuilder.precalcMaxCommentLineCount(rawInstruction2, rawInstruction, ECommentPlacement.ABOVE_LINE);
                n3 = ViewCodeNodeBuilder.precalcMaxCommentLineCount(rawInstruction2, rawInstruction, ECommentPlacement.BEHIND_LINE);
                arrayList.addAll(ViewCodeNodeBuilder.buildInstruction(rawInstruction2, n2, pair.second() == null, eSide, n4, n3));
            }
        } else {
            zyLabelContent.addLineContent(ViewCodeNodeBuilder.buildHeadline(rawBasicBlock2));
            n2 = rawBasicBlock2.getMaxOperandLength();
            for (Pair pair : list) {
                rawInstruction2 = null;
                if (rawBasicBlock != null && pair.first() != null) {
                    rawInstruction2 = rawBasicBlock.getInstruction((IAddress)pair.first());
                }
                rawInstruction = null;
                if (rawBasicBlock2 != null && pair.second() != null) {
                    rawInstruction = rawBasicBlock2.getInstruction((IAddress)pair.second());
                }
                n4 = ViewCodeNodeBuilder.precalcMaxCommentLineCount(rawInstruction2, rawInstruction, ECommentPlacement.ABOVE_LINE);
                n3 = ViewCodeNodeBuilder.precalcMaxCommentLineCount(rawInstruction2, rawInstruction, ECommentPlacement.BEHIND_LINE);
                arrayList.addAll(ViewCodeNodeBuilder.buildInstruction(rawInstruction, n2, pair.first() == null, eSide, n4, n3));
            }
        }
        Iterator iterator = arrayList.iterator();
        do {
            if (!iterator.hasNext()) {
                ViewCodeNodeBuilder.buildBasicblockComments(rawBasicBlock, rawBasicBlock2, zyLabelContent, eSide);
                return;
            }
            ZyLineContent zyLineContent = (ZyLineContent)iterator.next();
            zyLabelContent.addLineContent(zyLineContent);
        } while (true);
    }

    private static void buildMnemonic(RawInstruction rawInstruction, StringBuffer stringBuffer, List list) {
        if (rawInstruction.getMnemonic().length() == 0) {
            return;
        }
        String string = rawInstruction.getMnemonic();
        if (rawInstruction.getOperands().length > 0) {
            string = Strings.padEnd(rawInstruction.getMnemonic(), rawInstruction.getMaxMnemonicLen(), ' ');
        }
        Color color = EInstructionHighlighting.getColor(EInstructionHighlighting.TYPE_MNEMONIC);
        list.add(new CStyleRunData(stringBuffer.length(), string.length(), color));
        stringBuffer.append(string);
    }

    private static boolean appendStyleRunData(ByteArrayOutputStream byteArrayOutputStream, Color color, StringBuffer stringBuffer, List list) {
        if (byteArrayOutputStream == null) return true;
        if (color == null) return true;
        if (byteArrayOutputStream.size() == 0) return false;
        String string = byteArrayOutputStream.toString();
        list.add(new CStyleRunData(stringBuffer.length(), string.length(), color));
        stringBuffer.append(string);
        try {
            byteArrayOutputStream.close();
            return true;
        }
        catch (IOException var5_5) {
            Logger.logWarning("Couldn't close ByteArrayOutputStream.", new Object[0]);
        }
        return true;
    }

    private static void buildOperands(RawInstruction rawInstruction, StringBuffer stringBuffer, List list) {
        byte[] arrby = rawInstruction.getOperands();
        ByteArrayOutputStream byteArrayOutputStream = null;
        Color color = null;
        int n2 = 0;
        do {
            if (n2 >= arrby.length) {
                ViewCodeNodeBuilder.appendStyleRunData(byteArrayOutputStream, color, stringBuffer, list);
                return;
            }
            if (arrby[n2] < EInstructionHighlighting.getSize() && arrby[n2] > 0) {
                if (ViewCodeNodeBuilder.appendStyleRunData(byteArrayOutputStream, color, stringBuffer, list)) {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    byte by2 = arrby[n2];
                    color = EInstructionHighlighting.getColor(by2);
                }
            } else {
                byteArrayOutputStream.write(arrby[n2]);
            }
            ++n2;
        } while (true);
    }

    private static List buildRightComment(RawInstruction rawInstruction, InstructionObject instructionObject, RawInstructionComment rawInstructionComment, StringBuffer stringBuffer, List list, int n2, boolean bl2, ESide eSide, int n3) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        String string = "";
        if (rawInstructionComment != null) {
            int n4 = stringBuffer.length();
            int n5 = rawInstruction.getAddress().toHexString().length() + "   ".length() + 12 + n2;
            Color color = EInstructionHighlighting.getColor(EInstructionHighlighting.TYPE_COMMENT);
            string = rawInstructionComment.getText();
            CMultiCommentLineTokenizer cMultiCommentLineTokenizer = new CMultiCommentLineTokenizer(string, "\n");
            boolean bl3 = true;
            while (cMultiCommentLineTokenizer.hasMoreTokens()) {
                InstructionCommentDelimiterLineObject instructionCommentDelimiterLineObject;
                CStyleRunData cStyleRunData;
                Object object;
                CStyleRunData cStyleRunData2;
                Object object2;
                String string2 = cMultiCommentLineTokenizer.nextToken();
                if (bl3) {
                    bl3 = false;
                    object = Strings.repeat(" ", Math.max(0, n5 - n4));
                    String string3 = String.valueOf(object);
                    String string4 = String.valueOf(" // ");
                    object = string4.length() != 0 ? string3.concat(string4) : new String(string3);
                    int n6 = object.length();
                    instructionCommentDelimiterLineObject = new InstructionCommentDelimiterLineObject(rawInstruction, rawInstructionComment.getPlacement(), n4, n6);
                    cStyleRunData = new CStyleRunData(n4, n6, color, instructionCommentDelimiterLineObject);
                    list.add(cStyleRunData);
                    stringBuffer.append((String)object);
                    if (!string2.isEmpty()) {
                        object2 = new CInstructionCommentLineObject(rawInstruction, rawInstructionComment.getPlacement(), stringBuffer.length(), string2.length());
                        cStyleRunData2 = new CStyleRunData(stringBuffer.length(), string2.length(), color, (IZyEditableObject)object2);
                        list.add(cStyleRunData2);
                        stringBuffer.append(string2);
                    }
                    object2 = new ZyLineContent(stringBuffer.toString(), Fonts.NORMAL_FONT, list, instructionObject);
                    if (bl2) {
                        object2.setBackgroundColor(0, n4, eSide == ESide.PRIMARY ? Colors.PRIMARY_BASE : Colors.SECONDARY_BASE);
                    }
                    arrayList.add(object2);
                    continue;
                }
                object = new ArrayList();
                String string5 = String.format("%s%s", Strings.repeat(" ", n5), " // ");
                instructionCommentDelimiterLineObject = new InstructionCommentDelimiterLineObject(rawInstruction, rawInstructionComment.getPlacement(), 0, string5.length());
                cStyleRunData = new CStyleRunData(0, string5.length(), color, instructionCommentDelimiterLineObject);
                object.add(cStyleRunData);
                if (!string2.equals("")) {
                    object2 = new CInstructionCommentLineObject(rawInstruction, rawInstructionComment.getPlacement(), string5.length(), string2.length());
                    cStyleRunData2 = new CStyleRunData(string5.length(), string2.length(), color, (IZyEditableObject)object2);
                    object.add(cStyleRunData2);
                    String string6 = String.valueOf(string5);
                    String string7 = String.valueOf(string2);
                    string5 = string7.length() != 0 ? string6.concat(string7) : new String(string6);
                }
                object2 = new ZyLineContent(string5, Fonts.NORMAL_FONT, (List)object, instructionObject);
                arrayList.add((ZyLineContent)object2);
            }
        }
        if (string.isEmpty()) {
            ZyLineContent zyLineContent = new ZyLineContent(stringBuffer.toString(), Fonts.NORMAL_FONT, list, instructionObject);
            if (bl2) {
                zyLineContent.setBackgroundColor(0, stringBuffer.length(), eSide == ESide.PRIMARY ? Colors.PRIMARY_BASE : Colors.SECONDARY_BASE);
            }
            arrayList.add(zyLineContent);
        }
        if (arrayList.size() >= n3) return arrayList;
        arrayList.addAll(ViewCodeNodeBuilder.buildPlaceholderLines(n3 - arrayList.size(), EPlaceholderType.MATCHED_BEHIND_INSTRUCTION_COMMENT));
        return arrayList;
    }

    private static List buildTopComment(RawInstruction rawInstruction, InstructionObject instructionObject, RawInstructionComment rawInstructionComment, int n2) {
        if (rawInstructionComment == null) {
            return ViewCodeNodeBuilder.buildPlaceholderLines(n2, EPlaceholderType.MATCHED_ABOVE_INSTRUCTION_COMMENT);
        }
        ArrayList<ZyLineContent> arrayList = new ArrayList<ZyLineContent>();
        String string = rawInstructionComment.getText();
        CMultiCommentLineTokenizer cMultiCommentLineTokenizer = new CMultiCommentLineTokenizer(string, "\n");
        Color color = EInstructionHighlighting.getColor(EInstructionHighlighting.TYPE_COMMENT);
        do {
            ArrayList<Object> arrayList2;
            if (!cMultiCommentLineTokenizer.hasMoreTokens()) {
                if (arrayList.size() >= n2) return arrayList;
                arrayList2 = new ArrayList();
                arrayList2.addAll(ViewCodeNodeBuilder.buildPlaceholderLines(n2 - arrayList.size(), EPlaceholderType.MATCHED_ABOVE_INSTRUCTION_COMMENT));
                arrayList2.addAll(arrayList);
                return arrayList2;
            }
            arrayList2 = new ArrayList<Object>();
            String string2 = "// ";
            InstructionCommentDelimiterLineObject instructionCommentDelimiterLineObject = new InstructionCommentDelimiterLineObject(rawInstruction, rawInstructionComment.getPlacement(), 0, string2.length());
            CStyleRunData cStyleRunData = new CStyleRunData(0, string2.length(), color, instructionCommentDelimiterLineObject);
            arrayList2.add(cStyleRunData);
            String string3 = cMultiCommentLineTokenizer.nextToken();
            CInstructionCommentLineObject cInstructionCommentLineObject = new CInstructionCommentLineObject(rawInstruction, rawInstructionComment.getPlacement(), string2.length(), string3.length());
            String string4 = String.valueOf(string2);
            String string5 = String.valueOf(string3);
            string2 = string5.length() != 0 ? string4.concat(string5) : new String(string4);
            CStyleRunData cStyleRunData2 = new CStyleRunData(0, string2.length(), color, cInstructionCommentLineObject);
            arrayList2.add(cStyleRunData2);
            ZyLineContent zyLineContent = new ZyLineContent(string2, Fonts.NORMAL_FONT, arrayList2, instructionObject);
            arrayList.add(zyLineContent);
        } while (true);
    }

    private static void buildUnmatchedCodeNodeContent(RawBasicBlock rawBasicBlock, ZyLabelContent zyLabelContent) {
        zyLabelContent.addLineContent(ViewCodeNodeBuilder.buildHeadline(rawBasicBlock));
        ArrayList arrayList = new ArrayList();
        int n2 = rawBasicBlock.getMaxOperandLength();
        for (Object object2 : rawBasicBlock) {
            arrayList.addAll(ViewCodeNodeBuilder.buildInstruction((RawInstruction)object2, n2, false, null, 0, 0));
        }
        for (Object object2 : arrayList) {
            zyLabelContent.addLineContent((ZyLineContent)object2);
        }
        ViewCodeNodeBuilder.buildBasicblockComments(rawBasicBlock.getSide() == ESide.PRIMARY ? rawBasicBlock : null, rawBasicBlock.getSide() == ESide.SECONDARY ? rawBasicBlock : null, zyLabelContent, rawBasicBlock.getSide());
    }

    private static List getMatchedFunctionsBasicblockInstructionAddressPairs(FunctionMatchData functionMatchData, RawCombinedFlowGraph rawCombinedFlowGraph, IAddress iAddress, IAddress iAddress2) {
        ArrayList<Pair> arrayList = new ArrayList<Pair>();
        RawFlowGraph rawFlowGraph = rawCombinedFlowGraph.getPrimaryFlowgraph();
        RawFlowGraph rawFlowGraph2 = rawCombinedFlowGraph.getSecondaryFlowgraph();
        if (iAddress != null && iAddress2 != null) {
            BasicBlockMatchData basicBlockMatchData = functionMatchData.getBasicblockMatch(iAddress, ESide.PRIMARY);
            for (InstructionMatchData entry3 : basicBlockMatchData.getInstructionMatches()) {
                arrayList.add(new Pair(entry3.getIAddress(ESide.PRIMARY), entry3.getIAddress(ESide.SECONDARY)));
            }
            RawBasicBlock rawBasicBlock = rawFlowGraph.getBasicblock(iAddress);
            for (Map.Entry entry2 : rawBasicBlock.getInstructions().entrySet()) {
                if (basicBlockMatchData.getInstructionMatch((IAddress)entry2.getKey(), ESide.PRIMARY) != null) continue;
                arrayList.add(new Pair(entry2.getKey(), null));
            }
            RawBasicBlock rawBasicBlock2 = rawFlowGraph2.getBasicblock(iAddress2);
            Iterator iterator = rawBasicBlock2.getInstructions().entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = iterator.next();
                if (basicBlockMatchData.getInstructionMatch((IAddress)entry.getKey(), ESide.SECONDARY) != null) continue;
                arrayList.add(new Pair(null, entry.getKey()));
            }
            return arrayList;
        }
        if (iAddress != null) {
            RawBasicBlock rawBasicBlock = rawFlowGraph.getBasicblock(iAddress);
            Iterator iterator = rawBasicBlock.getInstructions().entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = iterator.next();
                arrayList.add(new Pair(entry.getKey(), null));
            }
            return arrayList;
        }
        if (iAddress2 == null) return arrayList;
        RawBasicBlock rawBasicBlock = rawFlowGraph2.getBasicblock(iAddress2);
        Iterator iterator = rawBasicBlock.getInstructions().entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            arrayList.add(new Pair(null, entry.getKey()));
        }
        return arrayList;
    }

    /*
     * Unable to fully structure code
     */
    private static List getMatchedFunctionsBasicblockInstructionAddressPairs(FunctionMatchData var0, RawCombinedFlowGraph var1_1, IAddress var2_2, IAddress var3_3, ESide var4_4) {
        var5_5 = new ArrayList<Object>(ViewCodeNodeBuilder.getMatchedFunctionsBasicblockInstructionAddressPairs(var0, var1_1, var2_2, var3_3));
        var6_6 = new ArrayList<Pair>();
        var7_7 = new ArrayList<Pair>();
        var8_8 = var5_5.iterator();
        while (var8_8.hasNext()) {
            var9_10 = (Pair)var8_8.next();
            if (ESide.SECONDARY == var4_4) {
                var9_10 = new Pair(var9_10.second(), var9_10.first());
            }
            if (var9_10.first() != null) {
                var6_6.add((Pair)var9_10);
            }
            if (var9_10.second() == null) continue;
            var7_7.add((Pair)var9_10);
        }
        Collections.sort(var6_6, new AddressPairComparator(ESide.PRIMARY));
        Collections.sort(var7_7, new AddressPairComparator(ESide.SECONDARY));
        var5_5.clear();
        if (var6_6.size() == 0) {
            var5_5 = var7_7;
        }
        if (var7_7.size() == 0) {
            var5_5 = var6_6;
        }
        if (var6_6.size() == 0 || var7_7.size() == 0) ** GOTO lbl-1000
        var8_9 = 0;
        var9_10 = var6_6.iterator();
        do {
            if (var9_10.hasNext()) {
                var10_12 = (Pair)var9_10.next();
                if (var10_12.second() == null) {
                    var5_5.add((Pair)var10_12);
                    continue;
                }
                if (var8_9 >= var7_7.size()) continue;
                var11_13 = true;
            } else lbl-1000: // 2 sources:
            {
                var8_8 = new ArrayList<E>();
                var9_11 = var7_7.size();
                while (var9_11 > 0 && ((Pair)var7_7.get(--var9_11)).first() == null) {
                    var8_8.add(var7_7.get(var9_11));
                }
                Collections.sort(var8_8, new AddressPairComparator(ESide.SECONDARY));
                var5_5.addAll((Collection<Object>)var8_8);
                var10_12 = var5_5;
                if (ESide.SECONDARY != var4_4) return var10_12;
                var10_12.clear();
                var11_14 = var5_5.iterator();
                while (var11_14.hasNext() != false) {
                    var12_15 = (Pair)var11_14.next();
                    var10_12.add(new Pair(var12_15.second(), var12_15.first()));
                }
                return var10_12;
            }
            while (var11_13) {
                var12_15 = (Pair)var7_7.get(var8_9);
                if (var12_15.first() == null) {
                    var5_5.add(var12_15);
                } else {
                    var11_13 = false;
                }
                if (++var8_9 < var7_7.size()) break;
                var11_13 = false;
            }
            var5_5.add(var10_12);
        } while (true);
    }

    public static List buildBasicblockComment(RawBasicBlock rawBasicBlock, int n2) {
        Color color = EInstructionHighlighting.getColor(EInstructionHighlighting.TYPE_COMMENT);
        BasicBlockLineObject basicBlockLineObject = new BasicBlockLineObject(rawBasicBlock);
        ArrayList<ZyLineContent> arrayList = new ArrayList<ZyLineContent>();
        String string = rawBasicBlock.getComment();
        boolean bl2 = true;
        CMultiCommentLineTokenizer cMultiCommentLineTokenizer = new CMultiCommentLineTokenizer(string, "\n");
        int n3 = 0;
        do {
            if (!cMultiCommentLineTokenizer.hasMoreTokens()) {
                if (n3 >= n2) return arrayList;
                arrayList.addAll(ViewCodeNodeBuilder.buildPlaceholderLines(n2 - n3, EPlaceholderType.BASICBLOCK_COMMENT));
                return arrayList;
            }
            ++n3;
            String string2 = cMultiCommentLineTokenizer.nextToken();
            String string3 = String.valueOf("// ");
            String string4 = String.valueOf(string2);
            String string5 = string4.length() != 0 ? string3.concat(string4) : new String(string3);
            int n4 = "// ".length();
            if (bl2) {
                String string6 = String.valueOf("// Basic Block Commment: ");
                String string7 = String.valueOf(string2);
                string5 = string7.length() != 0 ? string6.concat(string7) : new String(string6);
                n4 = "// Basic Block Commment: ".length();
                bl2 = false;
            }
            BasicBlockCommentDelimiterLineObject basicBlockCommentDelimiterLineObject = new BasicBlockCommentDelimiterLineObject(rawBasicBlock, 0, n4);
            BasicBlockCommentLineObject basicBlockCommentLineObject = new BasicBlockCommentLineObject(rawBasicBlock, n4, string2.length());
            ArrayList<CStyleRunData> arrayList2 = new ArrayList<CStyleRunData>();
            arrayList2.add(new CStyleRunData(0, n4, color, basicBlockCommentDelimiterLineObject));
            arrayList2.add(new CStyleRunData(n4, string2.length(), color, basicBlockCommentLineObject));
            arrayList.add(new ZyLineContent(string5, Fonts.NORMAL_FONT, arrayList2, basicBlockLineObject));
        } while (true);
    }

    public static ZyLineContent buildHeadline(RawBasicBlock rawBasicBlock) {
        String string = String.format("%s%s%s", rawBasicBlock.getFunctionAddr().toHexString(), "   ", rawBasicBlock.getFunctionName());
        BasicBlockHeadLineObject basicBlockHeadLineObject = new BasicBlockHeadLineObject(rawBasicBlock);
        return new ZyLineContent(string, Fonts.BOLD_FONT, Lists.newArrayList(new CStyleRunData(0, -1, Color.BLACK)), basicBlockHeadLineObject);
    }

    public static List buildInstruction(RawInstruction rawInstruction, int n2, boolean bl2, ESide eSide, int n3, int n4) {
        ArrayList arrayList = new ArrayList();
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList arrayList2 = new ArrayList();
        if (rawInstruction == null) {
            arrayList.addAll(ViewCodeNodeBuilder.buildPlaceholderLines(n3, EPlaceholderType.UNMATCHED_ABOVE_INSTRUCTION_COMMENT));
            arrayList.addAll(ViewCodeNodeBuilder.buildPlaceholderLines(1, EPlaceholderType.UNMATCHED_INSTRUCTION));
            arrayList.addAll(ViewCodeNodeBuilder.buildPlaceholderLines(n4 - 1, EPlaceholderType.UNMATCHED_BEHIND_INSTRUCTION_COMMENT));
            return arrayList;
        }
        RawInstructionComment rawInstructionComment = null;
        RawInstructionComment rawInstructionComment2 = null;
        if (rawInstruction.hasComments()) {
            for (RawInstructionComment rawInstructionComment3 : rawInstruction.getComments()) {
                if (rawInstructionComment3.getPlacement() == ECommentPlacement.ABOVE_LINE) {
                    rawInstructionComment = rawInstructionComment3;
                    continue;
                }
                if (rawInstructionComment3.getPlacement() != ECommentPlacement.BEHIND_LINE) continue;
                rawInstructionComment2 = rawInstructionComment3;
            }
        }
        ViewCodeNodeBuilder.buildAddress(rawInstruction, stringBuffer, arrayList2);
        ViewCodeNodeBuilder.buildMnemonic(rawInstruction, stringBuffer, arrayList2);
        ViewCodeNodeBuilder.buildOperands(rawInstruction, stringBuffer, arrayList2);
        InstructionObject instructionObject = new InstructionObject(rawInstruction, 0, stringBuffer.length());
        arrayList.addAll(ViewCodeNodeBuilder.buildTopComment(rawInstruction, instructionObject, rawInstructionComment, n3));
        arrayList.addAll(ViewCodeNodeBuilder.buildRightComment(rawInstruction, instructionObject, rawInstructionComment2, stringBuffer, arrayList2, n2, bl2, eSide, n4));
        return arrayList;
    }

    public static List buildPlaceholderLines(int n2, EPlaceholderType ePlaceholderType) {
        ArrayList<ZyLineContent> arrayList = new ArrayList<ZyLineContent>();
        PlaceholderObject placeholderObject = null;
        switch (ViewCodeNodeBuilder$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EPlaceholderType[ePlaceholderType.ordinal()]) {
            case 1: {
                placeholderObject = PLACEHOLDER_MATCHED_ABOVE_INSTRUCTION_COMMENT;
                break;
            }
            case 2: {
                placeholderObject = PLACEHOLDER_MATCHED_BEHIND_INSTRUCTION_COMMENT;
                break;
            }
            case 3: {
                placeholderObject = PLACEHOLDER_UNMATCHED_ABOVE_INSTRUCTION_COMMENT;
                break;
            }
            case 4: {
                placeholderObject = PLACEHOLDER_UNMATCHED_INSTRUCTION;
                break;
            }
            case 5: {
                placeholderObject = PLACEHOLDER_UNMATCHED_BEHIND_INSTRUCTION_COMMENT;
                break;
            }
            case 6: {
                placeholderObject = PLACEHOLDER_BASICBLOCK_COMMENT;
            }
        }
        int n3 = 0;
        while (n3 < n2) {
            ZyLineContent zyLineContent = new ZyLineContent("\t", Fonts.NORMAL_FONT, placeholderObject);
            arrayList.add(zyLineContent);
            ++n3;
        }
        return arrayList;
    }

    public static void buildSingleCodeNodeContent(FunctionMatchData functionMatchData, RawCombinedFlowGraph rawCombinedFlowGraph, RawCombinedBasicBlock rawCombinedBasicBlock, ZyLabelContent zyLabelContent, ESide eSide) {
        RawBasicBlock rawBasicBlock = rawCombinedBasicBlock.getRawNode(ESide.PRIMARY);
        RawBasicBlock rawBasicBlock2 = rawCombinedBasicBlock.getRawNode(ESide.SECONDARY);
        if (eSide == ESide.PRIMARY) {
            if (rawBasicBlock2 == null) {
                ViewCodeNodeBuilder.buildUnmatchedCodeNodeContent(rawBasicBlock, zyLabelContent);
                return;
            }
        } else if (rawBasicBlock == null) {
            ViewCodeNodeBuilder.buildUnmatchedCodeNodeContent(rawBasicBlock2, zyLabelContent);
            return;
        }
        IAddress iAddress = rawCombinedBasicBlock.getAddress(ESide.PRIMARY);
        IAddress iAddress2 = rawCombinedBasicBlock.getAddress(ESide.SECONDARY);
        List list = ViewCodeNodeBuilder.getMatchedFunctionsBasicblockInstructionAddressPairs(functionMatchData, rawCombinedFlowGraph, iAddress, iAddress2, ESide.PRIMARY);
        RawBasicBlock rawBasicBlock3 = rawCombinedFlowGraph.getPrimaryFlowgraph().getBasicblock(iAddress);
        RawBasicBlock rawBasicBlock4 = rawCombinedFlowGraph.getSecondaryFlowgraph().getBasicblock(iAddress2);
        ViewCodeNodeBuilder.buildMatchedCodeNodeContent(rawBasicBlock3, rawBasicBlock4, list, zyLabelContent, eSide);
    }

    public static int precalcMaxCommentLineCount(RawInstruction rawInstruction, RawInstruction rawInstruction2, ECommentPlacement eCommentPlacement) {
        int n2;
        int n3 = eCommentPlacement == ECommentPlacement.BEHIND_LINE ? 1 : 0;
        int n4 = n2 = eCommentPlacement == ECommentPlacement.BEHIND_LINE ? 1 : 0;
        if (rawInstruction != null && rawInstruction.hasComments()) {
            for (RawInstructionComment rawInstructionComment : rawInstruction.getComments()) {
                if (rawInstructionComment.getPlacement() != eCommentPlacement || rawInstructionComment.getText().isEmpty()) continue;
                n3 = StringHelper.count(rawInstructionComment.getText(), '\n') + 1;
            }
        }
        if (rawInstruction2 == null) return Math.max(n3, n2);
        if (rawInstruction2.getComments() == null) return Math.max(n3, n2);
        Iterator iterator = rawInstruction2.getComments().iterator();
        while (iterator.hasNext()) {
            RawInstructionComment rawInstructionComment;
            rawInstructionComment = (RawInstructionComment)iterator.next();
            if (rawInstructionComment.getPlacement() != eCommentPlacement || rawInstructionComment.getText().isEmpty()) continue;
            n2 = StringHelper.count(rawInstructionComment.getText(), '\n') + 1;
        }
        return Math.max(n3, n2);
    }
}

