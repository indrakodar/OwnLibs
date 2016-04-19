/*
 * 
 * @Junior Software, DarkPlace (c) 2014
 * Jangan merubah dan melakukan editing terhadap pembuat (author)
 * pada file ini. Boleh digunakan sebagai Referensi dan free untuk share
 *  
 * indrakodar.kodar@gmail.com - (c)Friday - 15 April 2016
 * Last Update : 15 April 2016
 * 
 */
package org.darkroom.kodar.interfes;

/**
 *
 * @author IndraArumanQadar
 */
public interface IDataBaseAkses {

    public boolean simpan(String query);

    public boolean update(String query);

    public boolean hapus(String query);

}
