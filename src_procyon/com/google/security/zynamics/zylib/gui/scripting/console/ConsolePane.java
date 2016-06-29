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

public class ConsolePane extends AbstractScriptPanel
{
    private static final long serialVersionUID = 3114171042368746418L;
    private final KeyListener m_KeyListener;
    private int m_HistoryPosition;
    private final ArrayList m_LineHistory;
    private String m_SavedTypedLine;
    private final ConsolePane$TabCompletionManager m_tabCompletion;
    private static final boolean m_IsMultilineInput = false;
    private int m_LastAutoCompleteChunkLength;
    private String m_CurrentPrompt;
    private String consoleName;
    private String currentLanguage;
    private IScriptConsole console;
    private ArrayList realBindings;
    private ScriptEngine engine;
    private String buffered;
    private final TreeSet candidates;
    private String m_libraryPath;
    
    public ConsolePane() {
        super(new BorderLayout());
        this.m_KeyListener = new ConsolePane$InterpreterKeyListener(this, null);
        this.m_HistoryPosition = 0;
        this.m_LineHistory = new ArrayList();
        this.m_SavedTypedLine = "";
        this.m_tabCompletion = new ConsolePane$TabCompletionManager(this, null);
        this.m_LastAutoCompleteChunkLength = 0;
        this.buffered = "";
        this.updateDocument();
        this.candidates = new TreeSet(this.getDocument().getTabCompletionWords());
        this.getInputPane().addKeyListener(this.m_KeyListener);
        this.getDocument().setInputKeyListener(this.m_KeyListener);
        this.getOutputPane().setFont(new Font(GuiHelper.getMonospaceFont(), 0, 12));
        this.setBorder(new EmptyBorder(5, 5, 5, 5));
    }
    
    private void executeInitializer() {
        if (this.m_libraryPath == null) {
            return;
        }
        for (final String s : this.engine.getFactory().getExtensions()) {
            final String libraryPath = this.m_libraryPath;
            final String value = String.valueOf(File.separator);
            final String string = new StringBuilder(5 + String.valueOf(libraryPath).length() + String.valueOf(value).length() + String.valueOf(s).length()).append(libraryPath).append(value).append("init.").append(s).toString();
            if (FileUtils.exists(string)) {
                try {
                    this.engine.eval(FileUtils.readTextfile(string));
                    this.getOutputPane().setText(this.console.getOutput());
                }
                catch (ScriptException ex) {
                    this.getOutputPane().setText(ex.getLocalizedMessage());
                }
                catch (IOException ex2) {
                    this.getOutputPane().setText(ex2.getLocalizedMessage());
                }
            }
        }
    }
    
    private int getCurrentInputLine() {
        return this.getDocument().getLineStartOffset(this.getInputPane().getCaretPosition());
    }
    
    private String getCurrentLine() {
        final int caretPosition = this.getInputPane().getCaretPosition();
        final int length = this.m_CurrentPrompt.length();
        final String trim = this.getDocument().getCurrentLine(caretPosition).trim();
        String substring;
        if (length < trim.length()) {
            substring = trim.substring(length, trim.length());
        }
        else {
            substring = "";
        }
        return substring;
    }
    
    private ConsoleCodeDocument getDocument() {
        return (ConsoleCodeDocument)this.getInputPane().getDocument();
    }
    
    private int getLastInputLine() {
        return this.getDocument().getLineStartOffset(this.getInputPane().getText().length());
    }
    
    private void goToLastLine() {
        this.getInputPane().setCaretPosition(this.getInputPane().getText().length());
    }
    
    private void interpreterNewLine(final boolean b) {
        final int caretPosition = this.getInputPane().getCaretPosition();
        int n;
        if (caretPosition == 0) {
            n = 0;
        }
        else {
            this.getDocument().insertChar(caretPosition, "\n");
            n = caretPosition + 1;
        }
        this.m_CurrentPrompt = (b ? "... " : ">>> ");
        this.getDocument().insertPrompt(n, this.m_CurrentPrompt);
        this.getInputPane().setCaretPosition(n + this.m_CurrentPrompt.length());
    }
    
    private void setCurrentLine(final String s) {
        this.goToLastLine();
        this.getDocument().setCurrentLine(this.getInputPane().getCaretPosition(), this.m_CurrentPrompt.length(), s);
    }
    
    @Override
    protected void initConsole() {
        this.currentLanguage = this.getSelectedLanguage();
        this.console = new ConsoleWriter(new StringWriter());
        this.buffered = InitStringFactory.getInitString(this.currentLanguage, this.consoleName, this.m_libraryPath);
        this.realBindings = this.getBindings();
        if (this.consoleName != null) {
            this.realBindings.add(new Pair(this.consoleName, this.console));
        }
        if (this.currentLanguage == null) {
            return;
        }
        Preconditions.checkNotNull(this.engine = this.getManager().getEngineByName(this.currentLanguage), (Object)"Error: Unknown scripting language");
        this.engine.getContext().setWriter(this.console.getWriter());
        for (final Pair pair : this.realBindings) {
            this.engine.put((String)pair.first(), pair.second());
        }
        this.executeInitializer();
    }
    
    @Override
    protected void updateDocument() {
        this.getInputPane().setDocument(new ConsoleCodeDocument());
        this.interpreterNewLine(false);
    }
    
    public void setConsoleName(final String consoleName) {
        this.consoleName = consoleName;
        this.initConsole();
        this.updateDocument();
    }
    
    public void setLibraryPath(final String libraryPath) {
        this.m_libraryPath = libraryPath;
        this.initConsole();
        this.updateDocument();
    }
}
