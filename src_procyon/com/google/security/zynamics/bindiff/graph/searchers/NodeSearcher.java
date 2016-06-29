package com.google.security.zynamics.bindiff.graph.searchers;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;
import java.util.*;
import java.util.regex.*;

public class NodeSearcher
{
    public static ArrayList search(final ZyGraphNode zyGraphNode, String lowerCase, final boolean b, final boolean b2) {
        final ArrayList<SearchResult> list = new ArrayList<SearchResult>();
        if (lowerCase.isEmpty()) {
            return list;
        }
        final IZyNodeRealizer realizer = zyGraphNode.getRealizer();
        final ZyLabelContent nodeContent = realizer.getNodeContent();
        int n = 0;
        for (final ZyLineContent zyLineContent : nodeContent) {
            String s = zyLineContent.getText();
            if (!b2) {
                s = s.toLowerCase();
            }
            int n2 = 0;
            while (true) {
                if (b) {
                    Pattern pattern;
                    if (b2) {
                        pattern = Pattern.compile(lowerCase);
                    }
                    else {
                        pattern = Pattern.compile(lowerCase, 2);
                    }
                    final Matcher matcher = pattern.matcher(s);
                    if (!matcher.find(n2)) {
                        break;
                    }
                    final int start = matcher.start();
                    final int end = matcher.end();
                    if (start != end) {
                        list.add(new SearchResult(zyGraphNode, n, start, end - start, s, zyLineContent.getBackgroundStyleRunData(start, end), realizer.getRealizer().getLineColor()));
                    }
                    if (start == (n2 = end)) {
                        ++n2;
                    }
                    if (matcher.end() == s.length()) {
                        break;
                    }
                    continue;
                }
                else {
                    if (!b2) {
                        lowerCase = lowerCase.toLowerCase();
                    }
                    final int index = s.indexOf(lowerCase, n2);
                    if (index == -1) {
                        break;
                    }
                    list.add(new SearchResult(zyGraphNode, n, index, lowerCase.length(), s, zyLineContent.getBackgroundStyleRunData(index, index + lowerCase.length() - 1), realizer.getRealizer().getLineColor()));
                    n2 = index + lowerCase.length();
                }
            }
            ++n;
        }
        return list;
    }
}
