/**
 * Objekt tega razreda predstavlja imenik s podanim imenom in datotekami.
 */

 import java.util.Arrays;


 public class Imenik extends Datoteka{
 
    private Datoteka[] datoteke;
    public static final int METADATA = 256;
 
     public Imenik(String ime, Datoteka[] datoteke) {
        super(ime);
        this.datoteke = datoteke;
     }
     
     /**
      * Sestejemo velikosti posameznih datotek (in podimenikov)
      * v imeniku, nato pa se pristeje se 256.
      */
 
     @Override
     public int velikost() {
        int sumSize = this.METADATA;
        for(Datoteka e : this.datoteke){
            sumSize += e.velikost();
        }
         return sumSize;
     }
     
     /** Opis: ime [i n] */
     
     @Override
     public String opis() {
        return String.format("i %d", this.datoteke.length);
    }
     
     /** 
      * Vrne stevilo slikovnih datotek, neposredno vsebovanih v imeniku 
      * this, kjer je sirina in visina enaka najmanj <prag>.
      */
 
      public int steviloVecjihSlik(int prag) {
        int stSlik = 0;
        for (Datoteka file : this.datoteke) {
            if (file instanceof SlikovnaDatoteka) {
                SlikovnaDatoteka image = (SlikovnaDatoteka) file;
                if(image.jeVelikaVsaj(prag))
                    stSlik++;
            }
        }
        return stSlik;
    }
 
     /**
      * Poisce datoteko z imenom <ime> in vrne relativno pot
      * oz. null, ce datoteka ne obstaja. 
      *
      * Oblika poti: ./imenik/ime.jpg
      */
     
     private String poisci(String pot, String ime) {
        for (Datoteka file : this.datoteke) {
            //(this) .
            String fileName = file.getIme();
            String candidatPath = String.format("%s/%s", pot, fileName);
            if(fileName.equals(ime)){
                return candidatPath;
            }

            if (file instanceof Imenik) {
                Imenik imenik = (Imenik) file;
                String path = imenik.poisci(candidatPath, ime);
                if(path != null){
                    return path;
                }

            }
        }
        return null;
     }
 
     public String poisci(String ime) {
         return poisci(".", ime);
     }
 
     
     /**
      * Pomozne metode za izpis hierarhije imenika.
      */
 
     
    public static final int ODMIK = 5;

    private void izpisi(int odmik, Imenik imenik){

        System.out.printf("%s%n", imenik.getIme());

        for(int i = 0; i < imenik.datoteke.length; i++){
            Datoteka item = imenik.datoteke[i];

            for (int j = 0; j < odmik * Imenik.ODMIK; j++){
                System.out.printf("%c", (j % ODMIK == 0) ? '!' : ' ');
                System.out.printf("%c-- ", (i == imenik.datoteke.length - 1) ? '\\' : '|');
            }
        }
    }
    public void izpisi(){
        izpisi(0, this);
    }
 
     
     
 }