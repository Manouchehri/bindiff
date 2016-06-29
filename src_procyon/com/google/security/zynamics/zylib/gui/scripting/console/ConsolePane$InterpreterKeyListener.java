package com.google.security.zynamics.zylib.gui.scripting.console;

import com.google.security.zynamics.zylib.resources.*;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.*;
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

class ConsolePane$InterpreterKeyListener extends KeyAdapter
{
    final /* synthetic */ ConsolePane this$0;
    
    private ConsolePane$InterpreterKeyListener(final ConsolePane this$0) {
        this.this$0 = this$0;
    }
    
    private void execute() {
        final ConsolePane$InterpreterKeyListener$InternalScriptRunner consolePane$InterpreterKeyListener$InternalScriptRunner = new ConsolePane$InterpreterKeyListener$InternalScriptRunner(this, null);
        final CEndlessProgressDialog cEndlessProgressDialog = new CEndlessProgressDialog(null, this.this$0.getProgressWindowTitle(), Constants.MESSAGE_RUNNING_SCRIPT, consolePane$InterpreterKeyListener$InternalScriptRunner);
        consolePane$InterpreterKeyListener$InternalScriptRunner.run();
        cEndlessProgressDialog.setVisible(true);
        if (consolePane$InterpreterKeyListener$InternalScriptRunner.quitProperly()) {
            this.this$0.getOutputPane().setText(this.this$0.console.getOutput());
        }
    }
    
    private void handleBackspace(final KeyEvent keyEvent) {
        if (this.this$0.getInputPane().getSelectionStart() == this.this$0.getInputPane().getSelectionEnd() && this.this$0.getDocument().getCaretOffsetInLine(this.this$0.getInputPane().getCaretPosition()) <= this.this$0.m_CurrentPrompt.length()) {
            keyEvent.consume();
        }
    }
    
    private void handleDownKey(final KeyEvent keyEvent) {
        if (this.this$0.m_HistoryPosition < this.this$0.m_LineHistory.size() - 1) {
            this.this$0.setCurrentLine(this.this$0.m_LineHistory.get(++this.this$0.m_HistoryPosition));
        }
        else if (this.this$0.m_HistoryPosition == this.this$0.m_LineHistory.size() - 1) {
            this.this$0.m_HistoryPosition++;
            this.this$0.setCurrentLine(this.this$0.m_SavedTypedLine);
        }
        keyEvent.consume();
    }
    
    private void handleEnter(final KeyEvent keyEvent) {
        this.this$0.goToLastLine();
        final String access$1600 = this.this$0.getCurrentLine();
        final ConsolePane this$0 = this.this$0;
        final String access$1601 = this.this$0.buffered;
        this$0.buffered = new StringBuilder(1 + String.valueOf(access$1601).length() + String.valueOf(access$1600).length()).append(access$1601).append(access$1600).append("\n").toString();
        this.this$0.m_SavedTypedLine = "";
        if (keyEvent.isControlDown()) {
            this.execute();
            this.this$0.buffered = InitStringFactory.getInitString(this.this$0.currentLanguage, this.this$0.consoleName, this.this$0.m_libraryPath);
            this.this$0.getOutputDocument().flip();
            if (access$1600.trim().length() > 0) {
                this.this$0.m_LineHistory.add(access$1600);
            }
            this.this$0.m_HistoryPosition = this.this$0.m_LineHistory.size();
            this.this$0.interpreterNewLine(false);
        }
        else {
            if (access$1600.trim().length() > 0) {
                this.this$0.m_LineHistory.add(access$1600);
            }
            this.this$0.m_HistoryPosition = this.this$0.m_LineHistory.size();
            this.this$0.interpreterNewLine(true);
            this.this$0.getOutputDocument().flip();
        }
        this.this$0.getDocument().flushRemainingText(this.this$0.getInputPane().getText().length());
        keyEvent.consume();
    }
    
    private void handleTabKey(final KeyEvent keyEvent) {
        final int n = this.this$0.getInputPane().getCaretPosition() - this.this$0.m_LastAutoCompleteChunkLength;
        final String word = this.this$0.getDocument().getWord(n);
        if (word.length() > 0) {
            final String completion = this.this$0.m_tabCompletion.getCompletion(word);
            if (completion != null) {
                final String substring = completion.substring(word.length(), completion.length());
                try {
                    this.this$0.getDocument().remove(n, this.this$0.m_LastAutoCompleteChunkLength);
                    this.this$0.getDocument().insertString(n, substring, null);
                }
                catch (BadLocationException ex) {
                    ex.printStackTrace();
                }
                this.this$0.m_LastAutoCompleteChunkLength = substring.length();
                keyEvent.consume();
            }
        }
    }
    
    private void handleUpKey(final KeyEvent keyEvent) {
        if (this.this$0.m_HistoryPosition > 0) {
            if (this.this$0.m_HistoryPosition == this.this$0.m_LineHistory.size()) {
                this.this$0.goToLastLine();
                this.this$0.m_SavedTypedLine = this.this$0.getCurrentLine();
            }
            this.this$0.setCurrentLine(this.this$0.m_LineHistory.get(--this.this$0.m_HistoryPosition));
        }
        else {
            this.this$0.m_HistoryPosition = 0;
        }
        keyEvent.consume();
    }
    
    @Override
    public void keyPressed(final KeyEvent keyEvent) {
        if (this.this$0.getLastInputLine() != this.this$0.getCurrentInputLine()) {
            this.this$0.goToLastLine();
        }
        if (keyEvent.getKeyCode() == 10) {
            this.handleEnter(keyEvent);
        }
        else if (keyEvent.getModifiers() == 0) {
            if (keyEvent.getKeyCode() == 38) {
                this.handleUpKey(keyEvent);
            }
            else if (keyEvent.getKeyCode() == 40) {
                this.handleDownKey(keyEvent);
            }
            else if (keyEvent.getKeyCode() == 9) {
                this.handleTabKey(keyEvent);
            }
            else if (keyEvent.getKeyCode() == 8) {
                this.handleBackspace(keyEvent);
            }
            if (keyEvent.getKeyCode() != 9) {
                this.this$0.m_tabCompletion.reset();
                this.this$0.m_LastAutoCompleteChunkLength = 0;
            }
        }
    }
}
