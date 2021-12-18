package testovi;

import gume.AutoGuma;
import gume.VulkanizerskaRadnja;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

//@Timeout(value = 5, unit = TimeUnit.SECONDS)
public class VulkanizerskaRadnjaDodajGumuParametrizedTest {

    private AutoGuma AG;
    private VulkanizerskaRadnja VR;

    @BeforeEach
    void init(){
        VR = new VulkanizerskaRadnja();
    }

    @AfterEach
    void destroy(){
        VR = null;
    }

    @ParameterizedTest
    @MethodSource("gume")
    void dodajGumuTest(AutoGuma AG){
        if(AG == null)
            assertThrows(NullPointerException.class, () -> VR.dodajGumu(AG));
        else if(VR.gume.contains(AG))
            assertThrows(RuntimeException.class, () -> VR.dodajGumu(AG));
        else {
            assertFalse(VR.gume.contains(AG));
            VR.dodajGumu(AG);
            assertTrue(VR.gume.contains(AG));
        }
    }

    public static Collection<Object[]> gume(){
        return Arrays.asList(new Object[][]{
                {null},
                {new AutoGuma("Michelin", true, 18, 180, 40)},
                {new AutoGuma("Michelin", true, 18, 180, 40)},
                {new AutoGuma("Michelin", true, 18, 190, 40)},
                {new AutoGuma("Pirelli", false, 19, 170, 30)}

        });
    }

	@ParameterizedTest
	@MethodSource("marke")
	void pronadjiGumu(String markaModel, int brojElemenata) {
        	if (markaModel == null)
            		assertNull(VulkanizerskaRadnja.pronadjiGumu(markaModel));
        	else {
        		assertEquals(brojElemenata, VulkanizerskaRadnja.pronadjiGumu(markaModel).size());
        	}
	}

	private static Stream<Arguments> marke() {
		return Stream.of(
				Arguments.of(null, 0),
				Arguments.of("Dunlop", 2),
				Arguments.of("Sava", 1),
				Arguments.of("Pirelli", 0),
				Arguments.of("Continental", 0));
	}



}
