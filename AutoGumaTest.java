package testovi;

import gume.AutoGuma;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

//@Timeout(value = 5, unit = TimeUnit.SECONDS)
public class AutoGumaTest {

    private AutoGuma AG;

    @BeforeAll
    public static void proveriOperativniSistem(){
        assertTrue(System.getProperty("os.name").contains("Windows"));
    }

    @BeforeEach
    void init(){
        AG = new AutoGuma("Michelin", true, 18, 180, 40);
    }

    @TestFactory
    Collection<DynamicTest> getMetodeTest(){
        return Arrays.asList(
                DynamicTest.dynamicTest("Test getZimska",
                        () -> assertEquals(true, AG.getZimska())),
                DynamicTest.dynamicTest("Test getPrecnik",
                        () -> assertEquals(18, AG.getPrecnik())),
                DynamicTest.dynamicTest("Test getSirina",
                        () -> assertEquals(180, AG.getSirina())),
                DynamicTest.dynamicTest("Test getVisina",
                        () -> assertEquals(40, AG.getVisina()))

        );
    }

    @Test
    void setZimskaTest(){
        boolean ocekivaniRezultat = true;
        boolean stvarniRezultat = AG.getZimska();
        assertEquals(ocekivaniRezultat, stvarniRezultat);

        AG.setZimska(false);
        ocekivaniRezultat = false;
        stvarniRezultat = AG.getZimska();
        assertEquals(ocekivaniRezultat, stvarniRezultat);
    }

    @Test
    void setPrecnikTest(){
        int ocekivaniRezultat = 18;
        int stvarniRezultat = AG.getPrecnik();
        assertEquals(ocekivaniRezultat, stvarniRezultat);

        AG.setPrecnik(15);
        ocekivaniRezultat = 15;
        stvarniRezultat = AG.getPrecnik();
        assertEquals(ocekivaniRezultat, stvarniRezultat);


    }

    @Test
    void setPrecnikTest2(){
        int ocekivaniRezultat = 18;
        int stvarniRezultat = AG.getPrecnik();
        assertEquals(ocekivaniRezultat, stvarniRezultat);

        assertThrows(RuntimeException.class, () -> AG.setPrecnik(10));
    }

    @Test
    void setPrecnikTest3(){
        int ocekivaniRezultat = 18;
        int stvarniRezultat = AG.getPrecnik();
        assertEquals(ocekivaniRezultat, stvarniRezultat);

        assertThrows(RuntimeException.class, () -> AG.setPrecnik(25));
    }

    @Test
    void setSirinaTest(){
        int ocekivaniRezultat = 180;
        int stvarniRezultat = AG.getSirina();
        assertEquals(ocekivaniRezultat, stvarniRezultat);

        AG.setSirina(255);
        ocekivaniRezultat = 255;
        stvarniRezultat = AG.getSirina();
        assertEquals(ocekivaniRezultat, stvarniRezultat);


    }

    @Test
    void setSirinaTest2(){
        int ocekivaniRezultat = 180;
        int stvarniRezultat = AG.getSirina();
        assertEquals(ocekivaniRezultat, stvarniRezultat);

        assertThrows(RuntimeException.class, () -> AG.setSirina(100));


    }

    @Test
    void setSirinaTest3(){
        int ocekivaniRezultat = 180;
        int stvarniRezultat = AG.getSirina();
        assertEquals(ocekivaniRezultat, stvarniRezultat);

        assertThrows(RuntimeException.class, () -> AG.setSirina(380));


    }

    @Test
    void setVisinaTest(){
        int ocekivaniRezultat = 40;
        int stvarniRezultat = AG.getVisina();
        assertEquals(ocekivaniRezultat, stvarniRezultat);

        AG.setVisina(50);
        ocekivaniRezultat = 50;
        stvarniRezultat = AG.getVisina();
        assertEquals(ocekivaniRezultat, stvarniRezultat);


    }

    @Test
    void setVisinaTest2(){
        int ocekivaniRezultat = 40;
        int stvarniRezultat = AG.getVisina();
        assertEquals(ocekivaniRezultat, stvarniRezultat);

        assertThrows(RuntimeException.class, () -> AG.setVisina(12));

    }

    @Test
    void setVisinaTest3(){
        int ocekivaniRezultat = 40;
        int stvarniRezultat = AG.getVisina();
        assertEquals(ocekivaniRezultat, stvarniRezultat);

        assertThrows(RuntimeException.class, () -> AG.setVisina(125));

    }

    @Test
    void setMarkaModelTest(){
        String ocekivaniRezultat = "Michelin";
        String stvarniRezultat = AG.getMarkaModel();
        assertEquals(ocekivaniRezultat, stvarniRezultat);

        AG.setMarkaModel("Pirelli");
        ocekivaniRezultat = "Pirelli";
        stvarniRezultat = AG.getMarkaModel();
        assertEquals(ocekivaniRezultat, stvarniRezultat);
    }

    @Test
    void setMarkaModelTest2(){
        String ocekivaniRezultat = "Michelin";
        String stvarniRezultat = AG.getMarkaModel();
        assertEquals(ocekivaniRezultat, stvarniRezultat);

        assertThrows(RuntimeException.class, () -> AG.setMarkaModel(null));
    }

    @Test
    void setMarkaModelTest3(){
        String ocekivaniRezultat = "Michelin";
        String stvarniRezultat = AG.getMarkaModel();
        assertEquals(ocekivaniRezultat, stvarniRezultat);

        assertThrows(RuntimeException.class, () -> AG.setMarkaModel("MI"));
    }




}
