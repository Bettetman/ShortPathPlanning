package cn.sicnu.frank;

import org.junit.Test;

import java.util.ArrayList;


public class ResultTest {

    @Test
    public void setStationLine() {
        Station chunxilu =new Station("春熙路");
        chunxilu.setLine("-1");
        ArrayList<String> lines = new ArrayList<>();
        lines.add("1");
        lines.add("2");
        lines.add("3");
        chunxilu.setBelonglines(lines);

        Station tianfuSqu = new Station("天府广场");
        ArrayList<String> line1s = new ArrayList<>();
        line1s.add("3");
        line1s.add("2");
        tianfuSqu.setBelonglines(line1s);

        if (Result.setStationLine(chunxilu, tianfuSqu))
        {
            System.out.println(chunxilu);
        }
    }
}