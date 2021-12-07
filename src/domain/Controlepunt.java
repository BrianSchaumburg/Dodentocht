package domain;

public class Controlepunt {
    private String naam;
    private double breedte, lengte;
    boolean controlePost;
    public Controlepunt(String naam, double geldigeBreedteGraad, double geldigeLengteGraad, boolean b) {
        setNaam(naam);
        setBreedte(geldigeBreedteGraad);
        setLengte(geldigeLengteGraad);
        this.controlePost= b;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        if(naam == null)
            throw new IllegalArgumentException();
        if(naam.trim().isEmpty())
            throw new IllegalArgumentException();
        this.naam = naam;
    }

    public double getBreedtegraad() {
        return breedte;
    }

    public void setBreedte(double breedte) {
        if(breedte<=50 || breedte>=51)
            throw new IllegalArgumentException();
        this.breedte = breedte;
    }

    public double getLengtegraad() {
        return lengte;
    }

    public void setLengte(double lengte) {
        if(lengte<=4 || lengte>=5)
            throw new IllegalArgumentException();
        this.lengte = lengte;
    }

    public boolean isHeeftEHBOPost() {
        return controlePost;
    }

    @Override
    public String toString() {
        return "Controlepunt{" +
                "naam='" + naam + '\'' +
                ", breedte=" + breedte +
                ", lengte=" + lengte +
                ", controlePost=" + controlePost +
                '}';
    }
}
