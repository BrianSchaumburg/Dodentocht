package domain;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Arrays;
import java.util.stream.Collectors;

public class deelnemer {
private String naam;
private LocalTime[] times;

    public deelnemer(String naam) {
        setNaam(naam);
    }
    public void setNaam(String naam)
    {
        if (naam.trim().isEmpty() || naam == null) {
            throw new IllegalArgumentException();
        }
        this.naam =naam;
    }
    public void initialize(int waarde)
    {
        if (waarde <= 0) {
            throw new IllegalArgumentException();
        }
        times = new LocalTime[waarde];
    }
    public void addtime(LocalTime time)

    {if(time == null)
    {
        throw new IllegalArgumentException();
    }
        for (int i = 0; i < times.length; i++) {
            if(times[i] == null
            )
            {
                this.times[i] = time;
                break;
            }
        }
    }
    public boolean finish()
    {
        return Arrays.stream(times).filter(a->a == null).collect(Collectors.toList()).isEmpty()? true: false;
    }
    public int lastcontrolepunt(){
        for(int i = 0; i< times.length; i ++ )
        {
            if (times[i] == null && times[i-1] != null) {
                return i;
            }
        }
        throw new IllegalArgumentException();
    }
    public String wandeltijd(){
        int waarde = 0;
        for (int i = 0; i < this.times.length; i++) {
            if(times[i] == null
            )
            {
                waarde = i ;
            }
        }
        if(waarde == 0) waarde = times.length-1;
        long hours=  ChronoUnit.HOURS.between(times[0], times[waarde]);
        long minutes = ChronoUnit.MINUTES.between(times[0],times[waarde]);
        long seconds = ChronoUnit.SECONDS.between(times[0], times[waarde]);
        return Long.toString(hours)+":"+Long.toString(minutes)+":"+Long.toString(seconds);

    }

    @Override
    public String toString() {
       return this.finish()? this.naam+"heeft de tocht beëindigd in een tijd van: "+ this.wandeltijd(): this.naam+"heeft de tocht niet beëindigd; laatse controlepunt: "+this.lastcontrolepunt();

    }
}
