
/*
 * @Junior Software, DarkPlace (c) 2014.
 * Jangan merubah dan melakukan editing terhadap pembuat (author)
 * pada file ini. Boleh digunakan sebagai Referensi dan free untuk share
 * 
 * indrakodar.kodar@gmail.com - (c) 0210, 29-July-2015
 * Last Update : 5 Februari 2016
 */
package org.darkroom.kodar.komponen;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import org.darkroom.kodar.ref.KONST;

/**
 *
 * @author Kodar ~ Dark Places
 */
public class Statusbar extends JPanel {

    private static final long serialVersionUID = 1L;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int y = 0;
        g.setColor(new Color(156, 154, 140));
        g.drawLine(0, y, getWidth(), y);
        y++;

        g.setColor(new Color(196, 194, 183));
        g.drawLine(0, y, getWidth(), y);
        y++;

        g.setColor(new Color(218, 215, 201));
        g.drawLine(0, y, getWidth(), y);
        y++;

        g.setColor(new Color(233, 231, 217));
        g.drawLine(0, y, getWidth(), y);

        y = getHeight() - 3;

        g.setColor(new Color(233, 232, 218));
        g.drawLine(0, y, getWidth(), y);
        y++;

        g.setColor(new Color(233, 231, 216));
        g.drawLine(0, y, getWidth(), y);
        y++;

        g.setColor(new Color(221, 221, 220));
        g.drawLine(0, y, getWidth(), y);
    }

    @Override
    public String toString() {
        return KONST.TO_STRING;
    }
}
