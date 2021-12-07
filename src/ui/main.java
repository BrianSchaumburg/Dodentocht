package ui;
import domain.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        Controlepunt grote= new Controlepunt("Grote markt", 50.879128,4.701187,true);
        Controlepunt arenberg= new Controlepunt("arenbergkasteel", 50.879128,4.701187,false);
        Controlepunt zoetwater= new Controlepunt("zoetwater", 50.879128,4.701187,true);
        Controlepunt proximus= new Controlepunt("proximus", 50.879128,4.701187,true);
        Controlepunt markt= new Controlepunt("grote markt", 50.879128,4.701187,false);
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

    }
}
