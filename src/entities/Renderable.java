package entities;

import javax.swing.*;

/**
 * Kelas abstrak yang menghasilkan char unik untuk
 * setiap kelas turunannya untuk ditampilkan pada GUI
 */
public abstract class Renderable {
    /**
     * Fungsi yang mengembalikan char untuk di render pada map GUI kelas
     * turunan renderable
     * 
     * @return int 0 callback jika fungsi render pada kelas turunan gagal dipanggil
     */
    public char render() {
        return 0;
    }

    public ImageIcon renderGUI() {
        return null;
    }
}
