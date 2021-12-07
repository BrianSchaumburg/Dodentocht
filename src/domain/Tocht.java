package domain;

import javax.naming.ldap.Control;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Tocht {
    private LocalDate datum;
    ArrayList<deelnemer> deelnemerArrayList = new ArrayList<>();
    public Controlepunt[] controlepunts;
    public Tocht(LocalDate datum, int aantal)
    {
        if (aantal <= 0) {
            throw new IllegalArgumentException();
        }
        controlepunts = new Controlepunt[aantal];
        setDate(datum);
    }

    public Tocht(LocalDate datum) {
        setDate(datum);
        controlepunts = new Controlepunt[15];

    }

    private void setDate(LocalDate datum) {
        if(datum == null || datum.isBefore(LocalDate.now()))
            throw new IllegalArgumentException();
        datum.atTime(21,00);
        this.datum = datum;
    }
    public void addControlepunt(Controlepunt controlepunt)
    {
        if (controlepunt == null) {
            throw new IllegalArgumentException();

        }
        for(int i= 0; i < controlepunts.length; i++ )
        {
            if (controlepunts[i] == null) {
                if(i!=0 && i!=1)
                {
                    if(controlepunts[i-1].isHeeftEHBOPost()) {
                        controlepunts[i]= controlepunt;
                        break;
                    }
                    else if (controlepunts[i-2].isHeeftEHBOPost() || controlepunt.isHeeftEHBOPost())
                    { controlepunts[i]= controlepunt;
                    break;}
                    else
                        throw new IllegalArgumentException();
                }
                controlepunts[i]= controlepunt;
                break;
            }
        }



    }
    public void addDeelnemer(deelnemer deelnemer)
    {
        if (deelnemer == null) {
            throw new IllegalArgumentException();
        }
        deelnemer.initialize(this.controlepunts.length);
        deelnemerArrayList.add(deelnemer);
    }
    public String ControlePointsInformation()
    {
        String result = "Wandelparcours:\n";
        for(Controlepunt punt: this.controlepunts)
        {
            result+=punt.toString()+"\n";
        }
        return result;
    }
    public String Deelnemers()
    {
        String result = deelnemerArrayList.size() + " zijn ingeschreven, namelijk \n";
        for(deelnemer punt: this.deelnemerArrayList)
        {
            result+=punt.toString()+"\n";
        }
        return result;

    }
    @Override
    public String toString() {
        return "Dodentocht " + datum.getYear() + ":" + datum.getMonth()+"-"+datum.getDayOfMonth()+"-"+datum.getDayOfMonth()
                + "\n"
                +   ControlePointsInformation()+ "\n"
                +"Huidige tijdstip : "+ LocalTime.now()+ "\n" + "\n"
                + this.Deelnemers() + "\n"
                + this.deelnemerArrayList.stream().filter(i->i.finish()).count() + " deelnemer heeft de tocht voltooid";
    }
}
