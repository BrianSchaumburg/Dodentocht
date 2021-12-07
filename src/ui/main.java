package ui;
import domain.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        Controlepunt grote= new Controlepunt("Grote Markt", 50.879128,4.701187,true);
        Controlepunt arenberg= new Controlepunt("Arenberg Kasteel", 50.863662,4.687672,false);
        Controlepunt zoetwater= new Controlepunt("Zoetwater Park", 50.879128,4.701187,true);
        Controlepunt proximus= new Controlepunt("Campus Proximus", 50.879128,4.701187,true);
        Controlepunt markt= new Controlepunt("Grote Markt", 50.879128,4.701187,false);
        deelnemer brian = new deelnemer("brian");
        deelnemer marina = new deelnemer("marina");
        deelnemer deevid = new deelnemer("deevid");
        LocalDate date = LocalDate.of(2021, Month.DECEMBER,8    );
        Tocht tocht =new Tocht(date,4  );
        tocht.addControlepunt(grote);
        tocht.addControlepunt(arenberg);
        tocht.addControlepunt(zoetwater);
        tocht.addControlepunt(proximus);
        tocht.addControlepunt(markt);
        tocht.addDeelnemer(brian);
        tocht.addDeelnemer(marina);
        tocht.addDeelnemer(deevid);
        int hour = 21; int minutes = 10;
        marina.addtime(LocalTime.of(hour,minutes));
        deevid.addtime(LocalTime.of(hour,minutes));
        for(int i = 0; i< 4; i ++ )
        {
            brian.addtime(LocalTime.of(hour,minutes++));
        }
        System.out.println(tocht.toString());
    //testen van de error
        try {
            Tocht foutetocht = new Tocht(LocalDate.now(), 3);
            Controlepunt test1 = new Controlepunt("Grote Markt", 50.879128, 4.701187, false);
            Controlepunt test2 = new Controlepunt("Grote Markt", 50.879128, 4.701187, false);
            Controlepunt test3 = new Controlepunt("Grote Markt", 50.879128, 4.701187, false);

            foutetocht.addControlepunt(test1);
            foutetocht.addControlepunt(test2);
            foutetocht.addControlepunt(test3);
        }
        catch(Exception e )
        {
            System.out.println(e.getMessage());
        }

    }
}
