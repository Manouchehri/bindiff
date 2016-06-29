/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.scripting.console;

import com.google.security.zynamics.zylib.gui.ProgressDialogs.CEndlessProgressDialog;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.IEndlessProgressModel;
import com.google.security.zynamics.zylib.gui.scripting.InitStringFactory;
import com.google.security.zynamics.zylib.gui.scripting.console.ConsolePane;
import com.google.security.zynamics.zylib.gui.scripting.console.ConsolePane$1;
import com.google.security.zynamics.zylib.gui.scripting.console.ConsolePane$InterpreterKeyListener$InternalScriptRunner;
import com.google.security.zynamics.zylib.resources.Constants;
import java.awt.Window;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;

class ConsolePane$InterpreterKeyListener
extends KeyAdapter {
    final /* synthetic */ ConsolePane this$0;

    private ConsolePane$InterpreterKeyListener(ConsolePane consolePane) {
        this.this$0 = consolePane;
    }

    private void execute() {
        ConsolePane$InterpreterKeyListener$InternalScriptRunner consolePane$InterpreterKeyListener$InternalScriptRunner = new ConsolePane$InterpreterKeyListener$InternalScriptRunner(this, null);
        CEndlessProgressDialog cEndlessProgressDialog = new CEndlessProgressDialog(null, ConsolePane.access$300(this.this$0), Constants.MESSAGE_RUNNING_SCRIPT, consolePane$InterpreterKeyListener$InternalScriptRunner);
        consolePane$InterpreterKeyListener$InternalScriptRunner.run();
        cEndlessProgressDialog.setVisible(true);
        if (!consolePane$InterpreterKeyListener$InternalScriptRunner.quitProperly()) return;
        ConsolePane.access$500(this.this$0).setText(ConsolePane.access$400(this.this$0).getOutput());
    }

    private void handleBackspace(KeyEvent keyEvent) {
        if (ConsolePane.access$600(this.this$0).getSelectionStart() != ConsolePane.access$700(this.this$0).getSelectionEnd()) return;
        if (ConsolePane.access$900(this.this$0).getCaretOffsetInLine(ConsolePane.access$800(this.this$0).getCaretPosition()) > ConsolePane.access$1000(this.this$0).length()) return;
        keyEvent.consume();
    }

    private void handleDownKey(KeyEvent keyEvent) {
        if (ConsolePane.access$1100(this.this$0) < ConsolePane.access$1200(this.this$0).size() - 1) {
            ConsolePane.access$1300(this.this$0, (String)ConsolePane.access$1200(this.this$0).get(ConsolePane.access$1104(this.this$0)));
        } else if (ConsolePane.access$1100(this.this$0) == ConsolePane.access$1200(this.this$0).size() - 1) {
            ConsolePane.access$1108(this.this$0);
            ConsolePane.access$1300(this.this$0, ConsolePane.access$1400(this.this$0));
        }
        keyEvent.consume();
    }

    private void handleEnter(KeyEvent keyEvent) {
        ConsolePane.access$1500(this.this$0);
        String string = ConsolePane.access$1600(this.this$0);
        String string2 = ConsolePane.access$1700(this.this$0);
        ConsolePane.access$1702(this.this$0, new StringBuilder(1 + String.valueOf(string2).length() + String.valueOf(string).length()).append(string2).append(string).append("\n").toString());
        ConsolePane.access$1402(this.this$0, "");
        if (keyEvent.isControlDown()) {
            this.execute();
            ConsolePane.access$1702(this.this$0, InitStringFactory.getInitString(ConsolePane.access$1800(this.this$0), ConsolePane.access$1900(this.this$0), ConsolePane.access$2000(this.this$0)));
            ConsolePane.access$2100(this.this$0).flip();
            if (string.trim().length() > 0) {
                ConsolePane.access$1200(this.this$0).add(string);
            }
            ConsolePane.access$1102(this.this$0, ConsolePane.access$1200(this.this$0).size());
            ConsolePane.access$2200(this.this$0, false);
        } else {
            if (string.trim().length() > 0) {
                ConsolePane.access$1200(this.this$0).add(string);
            }
            ConsolePane.access$1102(this.this$0, ConsolePane.access$1200(this.this$0).size());
            ConsolePane.access$2200(this.this$0, true);
            ConsolePane.access$2300(this.this$0).flip();
        }
        ConsolePane.access$900(this.this$0).flushRemainingText(ConsolePane.access$2400(this.this$0).getText().length());
        keyEvent.consume();
    }

    private void handleTabKey(KeyEvent keyEvent) {
        int n2 = ConsolePane.access$2500(this.this$0).getCaretPosition() - ConsolePane.access$2600(this.this$0);
        String string = ConsolePane.access$900(this.this$0).getWord(n2);
        if (string.length() <= 0) return;
        String string2 = ConsolePane.access$2700(this.this$0).getCompletion(string);
        if (string2 == null) return;
        String string3 = string2.substring(string.length(), string2.length());
        try {
            ConsolePane.access$900(this.this$0).remove(n2, ConsolePane.access$2600(this.this$0));
            ConsolePane.access$900(this.this$0).insertString(n2, string3, null);
        }
        catch (BadLocationException var6_6) {
            var6_6.printStackTrace();
        }
        ConsolePane.access$2602(this.this$0, string3.length());
        keyEvent.consume();
    }

    private void handleUpKey(KeyEvent keyEvent) {
        if (ConsolePane.access$1100(this.this$0) > 0) {
            if (ConsolePane.access$1100(this.this$0) == ConsolePane.access$1200(this.this$0).size()) {
                ConsolePane.access$1500(this.this$0);
                ConsolePane.access$1402(this.this$0, ConsolePane.access$1600(this.this$0));
            }
            ConsolePane.access$1300(this.this$0, (String)ConsolePane.access$1200(this.this$0).get(ConsolePane.access$1106(this.this$0)));
        } else {
            ConsolePane.access$1102(this.this$0, 0);
        }
        keyEvent.consume();
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int n2;
        int n3 = ConsolePane.access$2800(this.this$0);
        if (n3 != (n2 = ConsolePane.access$2900(this.this$0))) {
            ConsolePane.access$1500(this.this$0);
        }
        if (keyEvent.getKeyCode() == 10) {
            this.handleEnter(keyEvent);
            return;
        }
        if (keyEvent.getModifiers() != 0) return;
        if (keyEvent.getKeyCode() == 38) {
            this.handleUpKey(keyEvent);
        } else if (keyEvent.getKeyCode() == 40) {
            this.handleDownKey(keyEvent);
        } else if (keyEvent.getKeyCode() == 9) {
            this.handleTabKey(keyEvent);
        } else if (keyEvent.getKeyCode() == 8) {
            this.handleBackspace(keyEvent);
        }
        if (keyEvent.getKeyCode() == 9) return;
        ConsolePane.access$2700(this.this$0).reset();
        ConsolePane.access$2602(this.this$0, 0);
    }

    /* synthetic */ ConsolePane$InterpreterKeyListener(ConsolePane consolePane, ConsolePane$1 consolePane$1) {
        this(consolePane);
    }
}

