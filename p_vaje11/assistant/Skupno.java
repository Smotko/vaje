import java.util.*;

public class Skupno {

	/**
	 * Uredi podani vektor po narascajocem vrstnem redu glede na "naravno" 
	 * urejanje elementov (selection sort, stable).
	 * Vsi elementi (T) v vektorju morajo implementirati interface Comparable. 
	 */

	public static <T extends Comparable<T>> void uredi(Vektor<T> vektor) {
		int stElementov = vektor.steviloElementov();
		for (int i = 1; i < stElementov; i++) {
			T element = vektor.vrni(i);
			int j = i - 1;
			while (j >= 0 && vektor.vrni(j).compareTo(element) > 0) {
				vektor.nastavi(j + 1, vektor.vrni(j));
				j--;
			}
			vektor.nastavi(j + 1, element);
		}
	}
	
	/**
	 * Uredi podani vektor po vrstnem redu, ki ga doloca podani primerjalnik. 
	 */
	
	public static <T> void uredi(Vektor<T> vektor, Comparator<T> primerjalnik) {
		int stElementov = vektor.steviloElementov();
		for (int i = 1;  i < stElementov;  i++) {
			T element = vektor.vrni(i);
			int j = i - 1;
			while (j >= 0 && primerjalnik.compare(vektor.vrni(j), element) > 0) {
				vektor.nastavi(j + 1, vektor.vrni(j));
				j--;
			}
			vektor.nastavi(j + 1, element);
		}
	}
	
	
	// 3

	// T.java 
	public static <T> Comparator<T> kompozitum(Comparator<T> prim1, Comparator<T> prim2) {
		return new SestavljenPrimerjalnik<T>(prim1, prim2);
	}	
	
	/**
	 * Primerjalniki (nested static)
	 */

	private static class SestavljenPrimerjalnik<T> implements Comparator<T> {

		private Comparator<T> prim1;
		private Comparator<T> prim2;

		public SestavljenPrimerjalnik(Comparator<T> prim1, Comparator<T> prim2) {
			this.prim1 = prim1;
			this.prim2 = prim2;
		}

		@Override
		public int compare(T a, T b) {
			int rezultatPrvega = this.prim1.compare(a, b);
			return (rezultatPrvega == 0) ? this.prim2.compare(a, b) : rezultatPrvega;
		}
	}
	
	
	public static class Obrat<T> implements Comparator<T> {

		private Comparator<T> original;

		public Obrat(Comparator<T> original) {
			this.original = original;
		}

		@Override
		public int compare(T a, T b) {
			// return this.original.compare(b, a);
			return - this.original.compare(a, b);
		}
	}
}
