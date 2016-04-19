package org.darkroom.kodar.event;

/*
 * 
 * @Junior Software, DarkPlace (c) 2014
 * Jangan merubah dan melakukan editing terhadap pembuat (author)
 * pada file ini. Boleh digunakan sebagai Referensi dan free untuk share
 *  
 * indrakodar.kodar@gmail.com - (c)Thursday - 24 March 2016
 * Last Update : 
 * 
 */
import org.apache.logging.log4j.*;

/**
 *
 * @author IndraArumanQadar
 */
public class LogKontrol {

    private static Logger logger;

    /**
     * Konstruktor untuk mendaftarkan registrasi Log, dimana harus dilakukan
     * agar file konfigurasi xml dapat mengenalinya
     *
     * @param kelas parameter dari kelas inisialisasi dimana kelas ini diambil
     * dari kelas utama dari aplikasi yang run pertama kali, ex this.getClass();
     */
    public LogKontrol(Class<?> kelas) {
        logger = LogManager.getLogger(kelas);
    }

    /**
     * Fungsi untuk memasukan log yang akan kita catat pada file text atau pada
     * command layar. Dimana setelah method ini dipanggil kemudian diikuti level
     * dari Log itu sendiri. info(), warn(), debug(), error(), fatal(), trace();
     *
     * @return Semua log yang berhubungan dengan kelas sebagai history akses
     */
    public Logger log() {
        return logger;
    }

}
