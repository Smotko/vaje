/** 
 * Objekt tega razreda predstavlja datoteko s podanim imenom. 
 */

 public abstract class Datoteka {
    
    private String ime;

    public Datoteka(String ime) {
        this.ime = ime;
    }
    

    @Override
    public String toString(){
        return String.format("%s [%s]", this.ime, opis());
    }

    public abstract String opis();

    public abstract int velikost();
    
    public String getIme(){
        return this.ime;
    }

    /**
     * Vrne velikost datoteke <this> v bajtih.
     */


}
