/*
 * @Junior Software, DarkPlace (c) 2014.
 * Jangan merubah dan melakukan editing terhadap pembuat (author)
 * pada file ini. Boleh digunakan sebagai Referensi dan free untuk share
 * 
 * indrakodar.kodar@gmail.com - (c) Thursday, 15 January - 2015
 * Last Update : 5 Februari 2016
 */
package org.darkroom.kodar.komponen;

import java.awt.AWTEventMulticaster;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

import java.util.StringTokenizer;
import org.darkroom.kodar.interfes.ITextEditable;

/**
 *
 * @author IndraKodar
 */
public class IpTextField extends Panel implements ITextEditable {

    private static final long serialVersionUID = -7602563248517610907L;

    class IntegerListener extends KeyAdapter {

        IpTextField comp = null;

        // filter the non-numeric char
        @Override
        public void keyPressed(KeyEvent ke) {
            if (ke.getKeyCode() == KeyEvent.VK_DELETE
                    || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE
                    || ke.getKeyCode() == KeyEvent.VK_UP
                    || ke.getKeyCode() == KeyEvent.VK_DOWN
                    || ke.getKeyCode() == KeyEvent.VK_LEFT
                    || ke.getKeyCode() == KeyEvent.VK_RIGHT) {
                return;
            }
            //I'm sure of that
            TextField target = (TextField) ke.getComponent();
            String teks = target.getText();

            for (int i = 0; i < teks.length(); i++) {
                if ((target == comp.fields[1] || target == comp.fields[2] || target == comp.fields[3])
                        && teks.charAt(0) == '0') {
                    ke.consume();
                    requestFocusOnNextField(target);
                }

            }

            if (ke.getKeyChar() == '*') {
                ke.consume();
                target.setText("*");
                requestFocusOnNextField(target);
            } else if (ke.getKeyCode() == KeyEvent.VK_SPACE) {
                ke.consume();
                requestFocusOnNextField(target);
            } else if (ke.getKeyCode() == KeyEvent.VK_TAB
                    || ke.getKeyCode() == KeyEvent.VK_SPACE
                    || ke.getKeyCode() == KeyEvent.VK_ENTER) {
                requestFocusOnNextField(target);
            } else if (!(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')) {
                ke.consume();
            }
        }

        void requestFocusOnNextField(TextField target) {
            if (target == comp.fields[0]) {
                comp.fields[1].requestFocus();
            } else if (target == comp.fields[1]) {
                comp.fields[2].requestFocus();
            } else if (target == comp.fields[2]) {
                comp.fields[3].requestFocus();
            } else if (target == comp.fields[3]) {
                comp.fireActionEvent();
                comp.fields[0].requestFocus();
                comp.fields[0].setText("");
                comp.fields[1].setText("");
                comp.fields[2].setText("");
                comp.fields[3].setText("");
            }
        }

        IntegerListener(IpTextField comp) {
            this.comp = comp;
        }

    }

    class IPListener implements TextListener {

        IpTextField comp = null;

        @Override
        public void textValueChanged(TextEvent e) {
            // I'm sure of that
            TextField target = (TextField) e.getSource();
            String IP = target.getText();

            for (int i = 0; i < IP.length(); i++) {
                if (target == comp.fields[0] && IP.charAt(0) == '0') {
                    target.setText("");
                }
            }

            if (IP.length() < 3) {
                return;
            }
            if (IP.length() == 4) {
                target.setText(IP.substring(3));
                return;
            }

            try {
                short ip = Short.parseShort(IP);
                if (ip > 255) {
                    target.setText("");
                    return;
                }
            } catch (NumberFormatException ex) {
                target.setText("");
                return;
            }
            if (target == comp.fields[0]) {
                comp.fields[1].requestFocus();
            } else if (target == comp.fields[1]) {
                comp.fields[2].requestFocus();
            } else if (target == comp.fields[2]) {
                comp.fields[3].requestFocus();
            }
        }

        IPListener(IpTextField comp) {
            this.comp = comp;
        }
    }

    protected TextField[] fields = null;
    transient ActionListener actionListener;
    String command = "";

    @Override
    public synchronized void addActionListener(ActionListener al) {
        actionListener = AWTEventMulticaster.add(actionListener, al);
    }

    @Override
    public synchronized void removeActionListener(ActionListener al) {
        actionListener = AWTEventMulticaster.remove(actionListener, al);
    }

    protected void fireActionEvent() {
        if (actionListener != null) {
            ActionEvent ae = new ActionEvent(this,
                    ActionEvent.ACTION_PERFORMED,
                    command);
            actionListener.actionPerformed(ae);
        }
    }

    private String getFieldValue(TextField field) {
        String svalue = field.getText();
        if (svalue == null) {
            return "0";
        }
        if (svalue.length() == 0) {
            return "0";
        } else {
            return svalue;
        }
    }

    @Override
    public String getText() {
        return (getFieldValue(fields[0]) + "."
                + getFieldValue(fields[1]) + "."
                + getFieldValue(fields[2]) + "."
                + getFieldValue(fields[3]));
    }

    @Override
    public void setText(String IPT) {
        StringTokenizer st = new StringTokenizer(IPT, ".");
        int i = 0;
        while (i < 4 && st.hasMoreTokens()) {
            fields[i++].setText(st.nextToken());
        }
    }

    @Override
    public boolean updated() {
        return (!getText().equals("0.0.0.0"));
    }

    @Override
    public void setDefault() {
        fields[0].setText("0");
        fields[1].setText("0");
        fields[2].setText("0");
        fields[3].setText("0");
    }

    @Override
    public Dimension getMinimumSize() {
        return new Dimension(4 * fields[0].getMinimumSize().width,
                fields[0].getMinimumSize().height);
    }

    @Override
    public Dimension getPreferredSize() {
        return getMinimumSize();
    }

    public IpTextField() {
        IntegerListener intlistener = new IntegerListener(this);
        IPListener iplistener = new IPListener(this);

        fields = new TextField[4];
        for (int i = 0; i < fields.length; i++) {
            fields[i] = new TextField(3);
            fields[i].addTextListener(iplistener);
            fields[i].addKeyListener(intlistener);
        }
        setLayout(new GridLayout(1, 4));
        add(fields[0]);
        add(fields[1]);
        add(fields[2]);
        add(fields[3]);

    }

}
