/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.io.comments;

import com.google.security.zynamics.bindiff.database.CommentsDatabase;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawFlowGraph;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawInstructionComment;
import com.google.security.zynamics.bindiff.project.userview.FlowGraphViewData;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ECommentPlacement;
import java.sql.SQLException;

public final class CommentsWriter {
    private CommentsWriter() {
    }

    private static void writeBasicblockComment(CommentsDatabase commentsDatabase, String string, IAddress iAddress, IAddress iAddress2, String string2) {
        if (string2 == null) return;
        commentsDatabase.writeBasicblockComment(string, iAddress, iAddress2, string2);
    }

    /*
     * Exception decompiling
     */
    private static Pair writeComments(CommentsDatabase var0, String var1_1, RawFlowGraph var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [4[DOLOOP]], but top level block is 6[UNCONDITIONALDOLOOP]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2869)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:817)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:129)
        // org.benf.cfr.reader.Main.main(Main.java:181)
        // the.bytecode.club.bytecodeviewer.decompilers.CFRDecompiler.decompileToZip(CFRDecompiler.java:245)
        // the.bytecode.club.bytecodeviewer.gui.MainViewerGUI$18$1$3.run(MainViewerGUI.java:1107)
        throw new IllegalStateException("Decompilation failed");
    }

    private static void writeInstructionComment(CommentsDatabase commentsDatabase, String string, IAddress iAddress, IAddress iAddress2, RawInstructionComment rawInstructionComment) {
        if (!rawInstructionComment.isChangedComment()) return;
        String string2 = rawInstructionComment.getText();
        if (rawInstructionComment == null) return;
        ECommentPlacement eCommentPlacement = rawInstructionComment.getPlacement();
        commentsDatabase.writeInstructionComment(string, iAddress, iAddress2, eCommentPlacement, string2);
    }

    public static void writeComments(Workspace workspace, String string, String string2, ViewData viewData) {
        CommentsDatabase commentsDatabase = new CommentsDatabase(workspace, false);
        Throwable throwable = null;
        try {
            if (!viewData.isFlowgraphView()) return;
            RawFlowGraph rawFlowGraph = ((FlowGraphViewData)viewData).getRawGraph(ESide.PRIMARY);
            Pair pair = CommentsWriter.writeComments(commentsDatabase, string, rawFlowGraph);
            RawFlowGraph rawFlowGraph2 = ((FlowGraphViewData)viewData).getRawGraph(ESide.SECONDARY);
            Pair pair2 = CommentsWriter.writeComments(commentsDatabase, string2, rawFlowGraph2);
            int n2 = (Integer)pair.first() + (Integer)pair2.first();
            int n3 = (Integer)pair.second() + (Integer)pair2.second();
            if (n2 <= 0) return;
            throw new SQLException(String.format("View 's%' failed to write %d of %d changed comments.", viewData.getViewName(), n2, n3));
        }
        catch (Throwable var6_8) {
            throwable = var6_8;
            throw var6_8;
        }
        finally {
            if (commentsDatabase != null) {
                if (throwable != null) {
                    try {
                        commentsDatabase.close();
                    }
                    catch (Throwable var6_7) {
                        throwable.addSuppressed(var6_7);
                    }
                } else {
                    commentsDatabase.close();
                }
            }
        }
    }
}

