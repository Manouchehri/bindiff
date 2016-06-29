package com.google.security.zynamics.zylib.gui.scripting;

import javax.script.*;
import com.google.security.zynamics.zylib.gui.scripting.console.*;
import java.util.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.gui.*;
import javax.swing.text.*;
import javax.swing.border.*;
import java.awt.*;
import javax.swing.*;
import com.google.security.zynamics.zylib.general.*;

public abstract class AbstractScriptPanel extends JPanel implements IScriptPanel
{
    private static final long serialVersionUID = 8553550256320119608L;
    private final ScriptEngineManager manager;
    private final JTextPane m_inputPane;
    private final JTextPane m_OutputPane;
    private String m_progressWindowTitle;
    private final ConsoleStdoutDocument m_PythonStdoutDocument;
    private final ArrayList bindings;
    private final LanguageBox languageBox;
    
    public AbstractScriptPanel(final LayoutManager layoutManager) {
        super(layoutManager);
        this.manager = new ScriptEngineManager();
        this.m_inputPane = new JTextPane();
        this.m_OutputPane = new JTextPane();
        this.m_PythonStdoutDocument = new ConsoleStdoutDocument();
        this.bindings = new ArrayList();
        (this.languageBox = new LanguageBox(this.getManager())).addActionListener(new AbstractScriptPanel$InternalLanguageBoxListener(this, null));
        this.m_inputPane.setEditable(true);
        this.m_inputPane.setBackground(new Color(0.97f, 0.97f, 1.0f));
        this.m_inputPane.setFont(new Font(GuiHelper.getMonospaceFont(), 0, 13));
        this.m_OutputPane.setDocument(this.m_PythonStdoutDocument);
        this.m_OutputPane.setEditable(false);
        this.m_OutputPane.setBackground(new Color(0.97f, 0.97f, 1.0f));
        final JScrollPane scrollPane = new JScrollPane(this.m_inputPane);
        scrollPane.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 1, true), "Command Line"));
        scrollPane.setPreferredSize(new Dimension(600, 200));
        final JScrollPane scrollPane2 = new JScrollPane(this.m_OutputPane);
        scrollPane2.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 1, true), "Output"));
        scrollPane2.setPreferredSize(new Dimension(600, 200));
        this.add(this.languageBox, "North");
        this.add(new JSplitPane(0, false, scrollPane, scrollPane2));
    }
    
    protected ArrayList getBindings() {
        return (ArrayList)this.bindings.clone();
    }
    
    protected JTextPane getInputPane() {
        return this.m_inputPane;
    }
    
    protected ScriptEngineManager getManager() {
        return this.manager;
    }
    
    protected ConsoleStdoutDocument getOutputDocument() {
        return this.m_PythonStdoutDocument;
    }
    
    protected JTextPane getOutputPane() {
        return this.m_OutputPane;
    }
    
    protected String getProgressWindowTitle() {
        return this.m_progressWindowTitle;
    }
    
    protected String getSelectedLanguage() {
        return this.languageBox.getSelectedLanguage();
    }
    
    protected abstract void initConsole();
    
    protected abstract void updateDocument();
    
    public void addBinding(final String s, final Object o) {
        this.bindings.add(new Pair(s, o));
    }
    
    public void setLanguage(final String selectedLanguage) {
        this.languageBox.setSelectedLanguage(selectedLanguage);
    }
    
    @Override
    public void setOutput(final String text) {
        this.m_OutputPane.setText(text);
    }
    
    public void setProgressWindowTitle(final String progressWindowTitle) {
        this.m_progressWindowTitle = progressWindowTitle;
    }
}
