package cn.sicnu.frank;

import org.jetbrains.annotations.NotNull;
import sun.security.util.Length;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private Station star;
    private Station end;
    private Double distance = -1.0D;

    private List<Station> passStations = new ArrayList<Station>();

    public Station getStar() {
        return star;
    }
    public void setStar(Station star) {
        this.star = star;
    }
    public Station getEnd() {
        return end;
    }
    public void setEnd(Station end) {
        this.end = end;
    }
    public Double getDistance() {
        return distance;
    }
    public void setDistance(Double distance) {
        this.distance = distance;
    }
    public List<Station> getPassStations() {
        return passStations;
    }
    public void setPassStations(List<Station> passStations) {
        this.passStations = passStations;
    }
    public Result(Station star, Station end, Double distance) {
        this.star = star;
        this.end = end;
        this.distance = distance;
    }
    public Result() {}

    @Override
    public String toString() {
        return "ss";
    }

    public  String getEndStr(){
        String outputStr = "";
        if (this.getDistance()>= 0.0D)
        {
             Station first =  this.getStar();
            for (Station station:
                 passStations) {
                if(first.isTransfer( station ))
                {
                    outputStr += first.getName() + "\n";
                }
                else {
                    outputStr += station.getLine()+"\n"+ first.getName() + "\n";
                }
                first = station;
            }
            outputStr += this.end.getName();
        }
        return  outputStr;
    }
    public boolean setAllLines()
    {
        Station first = this.passStations.get(1);
        for (Station s :
                this.passStations) {
            if (!first.equals(s))
            {
                Result.setStationLine(first,s);
                first = s;
            }

        }
        Result.setStationLine(first,this.passStations.get(passStations.size()-1));
        return  true;
    }

    public static boolean setStationLine(@NotNull Station first, @NotNull Station second)
    {
        List<String> firstlines = first.getBelonglines();
        List<String> secondlines = second.getBelonglines();

        if(firstlines.size()>=secondlines.size())
        {
            for (String line : firstlines) {
                if (secondlines.contains(line))
                {
                    first.setLine(line);
                }
            }
        }
        else {
            for (String line :secondlines) {
                if(firstlines.contains(line))
                {
                    first.setLine(line);
                }
            }
        }
        return first.equals(second)?false:true;
    }


}