package com.google.security.zynamics.bindiff.io.comments;

import com.google.security.zynamics.bindiff.database.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.zylib.general.*;
import java.sql.*;
import com.google.security.zynamics.bindiff.project.rawflowgraph.*;
import java.util.*;
import com.google.security.zynamics.bindiff.project.*;
import com.google.security.zynamics.bindiff.project.userview.*;
import com.google.security.zynamics.bindiff.enums.*;

public final class CommentsWriter
{
    private static void writeBasicblockComment(final CommentsDatabase commentsDatabase, final String s, final IAddress address, final IAddress address2, final String s2) {
        if (s2 != null) {
            commentsDatabase.writeBasicblockComment(s, address, address2, s2);
        }
    }
    
    private static Pair writeComments(final CommentsDatabase commentsDatabase, final String s, final RawFlowGraph rawFlowGraph) {
        int n = 0;
        int n2 = 0;
        if (rawFlowGraph != null) {
            for (final RawBasicBlock rawBasicBlock : rawFlowGraph) {
                final IAddress functionAddr = rawBasicBlock.getFunctionAddr();
                if (rawBasicBlock.isChangedComment()) {
                    final IAddress address = rawBasicBlock.getAddress();
                    final String comment = rawBasicBlock.getComment();
                    try {
                        ++n2;
                        writeBasicblockComment(commentsDatabase, s, functionAddr, address, comment);
                    }
                    catch (SQLException ex) {
                        ++n;
                    }
                }
                for (final RawInstruction rawInstruction : rawBasicBlock) {
                    if (rawInstruction.hasComments()) {
                        for (final RawInstructionComment rawInstructionComment : rawInstruction.getComments()) {
                            if (rawInstructionComment.isChangedComment()) {
                                final IAddress address2 = rawInstruction.getAddress();
                                try {
                                    ++n2;
                                    writeInstructionComment(commentsDatabase, s, functionAddr, address2, rawInstructionComment);
                                }
                                catch (SQLException ex2) {
                                    ++n;
                                }
                            }
                        }
                    }
                }
            }
        }
        return new Pair(n, n2);
    }
    
    private static void writeInstructionComment(final CommentsDatabase commentsDatabase, final String s, final IAddress address, final IAddress address2, final RawInstructionComment rawInstructionComment) {
        if (rawInstructionComment.isChangedComment()) {
            final String text = rawInstructionComment.getText();
            if (rawInstructionComment != null) {
                commentsDatabase.writeInstructionComment(s, address, address2, rawInstructionComment.getPlacement(), text);
            }
        }
    }
    
    public static void writeComments(final Workspace workspace, final String s, final String s2, final ViewData viewData) {
        try (final CommentsDatabase commentsDatabase = new CommentsDatabase(workspace, false)) {
            if (viewData.isFlowgraphView()) {
                final Pair writeComments = writeComments(commentsDatabase, s, ((FlowGraphViewData)viewData).getRawGraph(ESide.PRIMARY));
                final Pair writeComments2 = writeComments(commentsDatabase, s2, ((FlowGraphViewData)viewData).getRawGraph(ESide.SECONDARY));
                final int n = (int)writeComments.first() + (int)writeComments2.first();
                final int n2 = (int)writeComments.second() + (int)writeComments2.second();
                if (n > 0) {
                    throw new SQLException(String.format("View 's%' failed to write %d of %d changed comments.", viewData.getViewName(), n, n2));
                }
            }
        }
    }
}
