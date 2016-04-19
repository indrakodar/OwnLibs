/*
 * @Junior Software, DarkPlace (c) 2014.
 * Jangan merubah dan melakukan editing terhadap pembuat (author)
 * pada file ini. Boleh digunakan sebagai Referensi dan free untuk share
 * 
 * indrakodar.kodar@gmail.com - (c) Thursday, 15 January - 2015
 * Last Update : 5 Februari 2016
 */
package org.darkroom.kodar.interfes;

import java.awt.event.ActionListener;

/**
 *
 * @author IndraKodar
 */
public interface ITextEditable {

    public void setText(String text);

    public String getText();

    public boolean updated();

    public void setDefault();

    public void addActionListener(ActionListener al);

    public void removeActionListener(ActionListener al);
}
