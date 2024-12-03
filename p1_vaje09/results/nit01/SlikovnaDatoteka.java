/** 
 * Objekt tega razreda predstavlja slikovno datoteko s podanim imenom, sirino 
 * in visino.
 */

 public class SlikovnaDatoteka extends Datoteka{

    // ppm image: P6 10 20 raster
    private int sirina, visina;
    private static final int METADATA = 54;


    public SlikovnaDatoteka(String ime, int sirina, int visina) {
        super(ime);
        this.sirina = sirina;
        this.visina = visina;
    }

    /**
     * Vrne velikost datoteke: 3 * w * h + HEADER
     */

    
    
    /** Opis: ime [s w x h] */

    @Override
    public String opis() {
        return String.format("s %d x %d", this.sirina, this.visina);
    }

    public int velikost(){
        return 3 * this.visina * this.sirina + SlikovnaDatoteka.METADATA;
    }
    
    public boolean jeVelikaVsaj(int size) {
        return (this.sirina >= size && this.visina >= size);
    } 
    /**
     * Velikost obeh dimenzij vsaj <size>
     */
    
    
} 
