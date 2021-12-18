package testovi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import program.Radnik;
import program.Zaposleni;

class ZaposleniTest {

	Zaposleni zaposleni;
	Radnik radnik;
	
	public static LinkedList<Radnik> novaLista = new LinkedList<Radnik>();
	@BeforeAll
	public static void create() {
		Zaposleni zaposle = new Zaposleni();
		assertTrue(System.getProperty("os.name").contains("Windows"));
		Zaposleni.radnik.add(new Radnik("Danilo", 12, 120));
	}
	@BeforeEach
	void init() {
		//
	}
	
	@AfterEach
	void destroy() {
		zaposleni = null;
	}
	
	@ParameterizedTest
	@MethodSource("testRadnikDodaj")
	public void testDodajRadnika(Radnik rad) {
		if(rad == null)
		assertThrows(NullPointerException.class, 
				() -> Zaposleni.dodajRadnik(rad));
		else if(Zaposleni.radnik.contains(rad))
			assertThrows(RuntimeException.class, 
					() -> Zaposleni.dodajRadnik(rad));
		else
			Zaposleni.dodajRadnik(rad);
		
	}
	
	public static Collection<Object[]> testRadnikDodaj(){
        return Arrays.asList(new Object[][]{
                {null},
                {new Radnik("Nenad Penezic", 14, 130)},
                {new Radnik("Nenad Penezic", 14, 130)},
                {new Radnik("Danilo Korac", 12, 160)},
                {new Radnik("Ivan Krstic", 18, 100)},
                {new Radnik("Jovan Govedarica", 10, 200)}

        });
        
	}
	
	@ParameterizedTest
	@MethodSource("radnikaPronadji")
	public void testPronadjiRadnika(String ime, int ocekivaniRezultat) {
		if(ime == null)
			assertNull(Zaposleni.pronadjiRadnik(ime));
		else
			assertEquals(ocekivaniRezultat, Zaposleni.pronadjiRadnik(ime).size());
		
	}
	
	public static Stream<Arguments> radnikaPronadji(){
		return Stream.of(
				Arguments.of(null, 0),
				Arguments.of("Marko", 0),
				Arguments.of("Nenad", 0),
				Arguments.of("Danilo", 1));
				
	}
	
}
