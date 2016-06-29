package com.google.security.zynamics.zylib.gui.scripting.console;

import java.awt.event.*;
import com.google.security.zynamics.zylib.gui.*;
import java.awt.*;
import javax.swing.border.*;
import com.google.security.zynamics.zylib.io.*;
import javax.script.*;
import java.util.*;
import java.io.*;
import com.google.security.zynamics.zylib.gui.scripting.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.common.base.*;
import javax.swing.text.*;
import javax.swing.*;

class ConsolePane$TabCompletionManager
{
    private int m_completionIndex;
    final /* synthetic */ ConsolePane this$0;
    
    private ConsolePane$TabCompletionManager(final ConsolePane this$0) {
        this.this$0 = this$0;
        this.m_completionIndex = 0;
    }
    
    private String getCompletionCandidate(final String[] array, final String s, int n) {
        boolean b = false;
        for (final String s2 : array) {
            if (s2.startsWith(s)) {
                b = true;
                if (n == 0) {
                    ++this.m_completionIndex;
                    return s2;
                }
                --n;
            }
        }
        if (b) {
            return this.getCompletionCandidate(array, s, n);
        }
        return null;
    }
    
    public String getCompletion(final String s) {
        return this.getCompletionCandidate((String[])this.this$0.candidates.toArray(new String[0]), s, this.m_completionIndex);
    }
    
    public void reset() {
        this.m_completionIndex = 0;
    }
}
