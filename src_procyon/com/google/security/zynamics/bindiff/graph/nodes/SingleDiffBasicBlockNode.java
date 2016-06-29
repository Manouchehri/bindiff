package com.google.security.zynamics.bindiff.graph.nodes;

import y.c.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.resources.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;
import java.awt.*;
import java.util.*;

public class SingleDiffBasicBlockNode extends SingleDiffNode
{
    public SingleDiffBasicBlockNode(final q q, final IZyNodeRealizer zyNodeRealizer, final SingleViewNode singleViewNode, final ESide eSide) {
        super(q, zyNodeRealizer, singleViewNode, eSide);
    }
    
    @Override
    protected void onSelectionChanged() {
        Color darker = (this.getSide() == ESide.PRIMARY) ? Colors.PRIMARY_BASE : Colors.SECONDARY_BASE;
        if (this.isSelected()) {
            darker = darker.darker();
        }
        for (final ZyLineContent zyLineContent : this.getRealizer().getNodeContent().getContent()) {
            final int length = zyLineContent.getText().length();
            if (length > 0) {
                for (final CStyleRunData cStyleRunData : zyLineContent.getBackgroundStyleRunData(0, length - 1)) {
                    final Color color = cStyleRunData.getColor();
                    if (color != Colors.SEARCH_HIGHLIGHT_COLOR && color != null) {
                        if (length == cStyleRunData.getEnd()) {
                            zyLineContent.setBackgroundColor(cStyleRunData.getStart(), cStyleRunData.getLength(), darker);
                        }
                        else {
                            zyLineContent.setBackgroundColor(cStyleRunData.getStart(), cStyleRunData.getLength() - 1, darker);
                        }
                    }
                }
            }
        }
    }
}
