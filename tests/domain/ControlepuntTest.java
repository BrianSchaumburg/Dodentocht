package domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class ControlepuntTest {
    private double geldigeBreedteGraad, geldigeLengteGraad;
    private String geldigeNaam;

    @org.junit.Before
    public void setUp() throws Exception {
        geldigeNaam = "Campus Proximus";
        geldigeBreedteGraad = 50.2;
        geldigeLengteGraad = 4.7;
    }

    @org.junit.Test (expected = IllegalArgumentException.class)
    public void test_Controlepunt_Met_null_als_naam_Gooit_Exception(){
        new Controlepunt(null,geldigeBreedteGraad,geldigeLengteGraad,true);
    }

    @org.junit.Test (expected = IllegalArgumentException.class)
    public void test_Controlepunt_Met_lege_naam_Gooit_Exception(){
        new Controlepunt("   ",geldigeBreedteGraad,geldigeLengteGraad,true);
    }

    @org.junit.Test (expected = IllegalArgumentException.class)
    public void test_Controlepunt_Met_breedtegraad_kleiner_dan_50_Gooit_Exception(){
        new Controlepunt(geldigeNaam,49.9,geldigeLengteGraad,true);
    }

    @org.junit.Test (expected = IllegalArgumentException.class)
    public void test_Controlepunt_Met_breedtegraad_gelijk_aan_50_Gooit_Exception(){
        new Controlepunt(geldigeNaam,50,geldigeLengteGraad,true);
    }

    @org.junit.Test (expected = IllegalArgumentException.class)
    public void test_Controlepunt_Met_breedtegraad_groter_dan_51_Gooit_Exception(){
        new Controlepunt(geldigeNaam,51.1,geldigeLengteGraad,true);
    }

    @org.junit.Test (expected = IllegalArgumentException.class)
    public void test_Controlepunt_Met_breedtegraad_gelijk_aan_51_Gooit_Exception(){
        new Controlepunt(geldigeNaam,51,geldigeLengteGraad,true);
    }

    @org.junit.Test (expected = IllegalArgumentException.class)
    public void test_Controlepunt_Met_lengtegraad_kleiner_dan_4_Gooit_Exception(){
        new Controlepunt(geldigeNaam,geldigeBreedteGraad,3.9,true);
    }

    @org.junit.Test (expected = IllegalArgumentException.class)
    public void test_Controlepunt_Met_lengtegraad_gelijk_aan_4_Gooit_Exception(){
        new Controlepunt(geldigeNaam,geldigeBreedteGraad,4,true);
    }

    @org.junit.Test (expected = IllegalArgumentException.class)
    public void test_Controlepunt_Met_lengtegraad_groter_dan_5_Gooit_Exception(){
        new Controlepunt(geldigeNaam,geldigeBreedteGraad,5.1,true);
    }

    @org.junit.Test (expected = IllegalArgumentException.class)
    public void test_Controlepunt_Met_lengtegraad_gelijk_aan_5_Gooit_Exception(){
        new Controlepunt(geldigeNaam,geldigeBreedteGraad,5,true);
    }
    @Test
    public void test_Controlepunt_Met_geldige_parameters_Maakt_Object_met_correcte_eigenschappen(){
        Controlepunt c = new Controlepunt(geldigeNaam,geldigeBreedteGraad,geldigeLengteGraad,true);
        assertEquals(geldigeNaam,c.getNaam());
        assertEquals(geldigeBreedteGraad,c.getBreedtegraad(),0.1);
        assertEquals(geldigeLengteGraad,c.getLengtegraad(),0.1);
        assertTrue(c.isHeeftEHBOPost());
        Controlepunt c2 = new Controlepunt(geldigeNaam,geldigeBreedteGraad,geldigeLengteGraad,false);
        assertFalse(c2.isHeeftEHBOPost());
    }

    @Override
    public String toString() {
        return "ControlepuntTest{" +
                "geldigeBreedteGraad=" + geldigeBreedteGraad +
                ", geldigeLengteGraad=" + geldigeLengteGraad +
                ", geldigeNaam='" + geldigeNaam + '\'' +
                '}';
    }
}