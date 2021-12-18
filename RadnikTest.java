package testovi;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import program.Radnik;

class RadnikTest {
	
	Radnik radnik;
	
	@BeforeAll
	public static void setValues() {
		
	}
	
	@BeforeEach
	void init() {
		radnik = new Radnik("Danilo Korac", 12, 140);
	}
	
	@Test
	public void testSetCenaSata1() {
		int ocekivaniRezultat = 12;
		int stvarniRezultat = radnik.getCenaSata();
		
		assertEquals(ocekivaniRezultat, stvarniRezultat);
		
		
		radnik.setCenaSata(7);
		ocekivaniRezultat = 7;
		stvarniRezultat = radnik.getCenaSata();
		assertEquals(ocekivaniRezultat, stvarniRezultat);
		
			
		
	}

	@Test
	public void testSetCenaSata2() {
		int cenaSata = -8;
		assertThrows(RuntimeException.class, () -> radnik.setCenaSata(cenaSata));
		
	}
	
	@Test
	public void testSetBrSatiRada1() {
		int ocekivaniRezultat = 140;
		int stvarniRezultat = radnik.getBrSatiRada();
		
		assertEquals(ocekivaniRezultat, stvarniRezultat);
		
		
		radnik.setBrSatiRada(220);
		ocekivaniRezultat = 220;
		stvarniRezultat = radnik.getBrSatiRada();
		assertEquals(ocekivaniRezultat, stvarniRezultat);		
		
	}
	
	@Test
	void testSetBrSatiRada2() {
		int brSatiRada = -50;
		assertThrows(RuntimeException.class, () -> radnik.setBrSatiRada(brSatiRada));
		
	}
	
	@Test
	void testSetBrSatiRada3() {
		int brSatiRada = 420;
		assertThrows(RuntimeException.class, () -> radnik.setBrSatiRada(brSatiRada));
		
	}
	
	@Test
	public void testSetIme() {
		String ocekivaniRezultat = "Danilo Korac";
		String stvarniRezultat = radnik.getIme();
		
		assertEquals(ocekivaniRezultat, stvarniRezultat);
		
		
		radnik.setIme("Ivan");
		ocekivaniRezultat = "Ivan";
		stvarniRezultat = radnik.getIme();
		assertEquals(ocekivaniRezultat, stvarniRezultat);
		
			
		
	}
	
	@Test
	void testSetIme2() {
		String ime = null;
		assertThrows(RuntimeException.class, () -> radnik.setIme(ime));
		
	}
	
	@Test
	public void testBolovanjeFalse() {
		assertFalse(radnik.bolovanje());
		
	}
	
	@Test
	public void testBolovanjeTrue() {
		radnik.setCenaSata(0);
		assertTrue(radnik.bolovanje());
		
	}
	

}
