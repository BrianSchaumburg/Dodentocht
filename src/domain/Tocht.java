package domain;

import javax.naming.ldap.Control;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Tocht {
    private LocalDate datum;
    ArrayList<deelnemer> deelnemerArrayList = new ArrayList<>();
    Controlepunt[] controlepunts;
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
        this.datum = datum;
    }
    public void addControlepunt(Controlepunt controlepunt)
    {
        if (controlepunt == null) {
            throw new IllegalArgumentException();

        }
        if(controlepunts.length>=2)
        {
            for(int i = 0; i < controlepunts.length; i++ )
            {
                if(controlepunts[i] == null)
                {

                     if(controlepunts[i-2].isHeeftEHBOPost()||controlepunts[i-1].isHeeftEHBOPost())
                {
                    controlepunts[i]=controlepunt;
                }
                   else if(controlepunts[i-1].isHeeftEHBOPost()==false && controlepunt.isHeeftEHBOPost()==false)
                   {
                       throw new IllegalStateException();
                   }

                   break;
                }

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
        String result = "wandelparcours + \n";
        for(Controlepunt punt: this.controlepunts)
        {
            result+=punt.toString()+"\n";
        }
        return result;
    }
    public String Deelnemers()
    {
        String result = deelnemerArrayList.size() + "zijn ingeschreven, namelijk \n";
        for(deelnemer punt: this.deelnemerArrayList)
        {
            result+=punt.toString()+"\n";
        }
        return result;

    }
    @Override
    public String toString() {
        return "Dodentocht" + datum.getYear() + ":" + datum.getYear()+"-"+datum.getDayOfMonth()+"-"+datum.getDayOfMonth()
                + "\n"
                +   ControlePointsInformation()+ "\n"
                +"huidige tijdstip : "+ LocalTime.now()+ "\n"
                + this.Deelnemers() + "\n"
                + this.deelnemerArrayList.stream().filter(i->i.finish()).count() + "deelnemer heeft de tocht voltooid";
    }
}
