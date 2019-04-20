package entities;

/**
 * ! \class Renderable \brief kelas abstrak yang menghasilkan char unik untuk
 * setiap kelas turunannya untuk ditampilkan pada GUI
 */
public abstract class Renderable {
    /**
     * ! \brief Fungsi yang mengembalikan char untuk di render pada map GUI kelas
     * turunan renderable
     * 
     * @return int 0 callback jika fungsi render pada kelas turunan gagal dipanggil
     */
    public char render() {
        return 0;
    }
}
