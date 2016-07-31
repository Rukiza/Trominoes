package com.company;


import java.util.ArrayList;
import java.util.List;

public class Tiler {


    List<Pair> list = new ArrayList<>();
    int i = 0;
    public void tile (int height, int heightmod, int width, int widthmod, int n, Coordinate m){
        int newN = n/2;
        boolean m1b = heightmod+newN <= m.y && height > m.y &&
                widthmod+newN <= m.x && width > m.x;
        boolean m2b = heightmod <= m.y && height-newN > m.y &&
                widthmod+newN <= m.x && width > m.x;
        boolean m3b = heightmod+newN <= m.y && height > m.y &&
                widthmod <= m.x && width-newN > m.x;
        boolean m4b = heightmod <= m.y && height-newN > m.y &&
                widthmod <= m.x && width-newN > m.x;

        System.out.println();
        System.out.println(m1b);
        System.out.println(m2b);
        System.out.println(m3b);
        System.out.println(m4b);
        System.out.println();
        System.out.println("X: "+m.x+"  Y: "+m.y);
        System.out.println("Height: "+height+" heightmod: "+heightmod+" width: "+width+" widthmod: "+widthmod+" N:"+n);

        if (m1b) {
            list.add(new Pair(new Coordinate(widthmod+newN, heightmod+newN), Trom.LL));
        } else if (m2b) {
            list.add(new Pair(new Coordinate(widthmod+newN, heightmod+newN), Trom.UL));
        } else if (m3b) {
            list.add(new Pair(new Coordinate(widthmod+newN, heightmod+newN), Trom.LR));
        } else if (m4b) {
            list.add(new Pair(new Coordinate(widthmod+newN, heightmod+newN), Trom.UR));
        }

        if (n == 2) {
            return;
        }

        Coordinate m1 = m1b ? m : new Coordinate(widthmod+newN,heightmod+newN);
        Coordinate m2 = m2b ? m : new Coordinate(widthmod+newN,heightmod+newN-1);
        Coordinate m3 = m3b ? m : new Coordinate(widthmod+newN-1,heightmod+newN);
        Coordinate m4 = m4b ? m : new Coordinate(widthmod+newN-1,heightmod+newN-1);

        tile(height, heightmod+newN, width, widthmod+newN, newN, m1);
        tile(height-newN, heightmod, width, widthmod+newN, newN, m2);
        tile(height, heightmod+newN, width-newN, widthmod, newN, m3);
        tile(height-newN, heightmod, width-newN, widthmod, newN, m4);
    }

    public static void main(String[] args) {

        Tiler b = new Tiler();
        b.tile(8,0,8,0,8,b.createC(3,2));
        b.print();

    }

    public Coordinate createC(int x, int y) {
        return new Coordinate(x,y);
    }

    public void print() {
        for (Pair p: list) {
            System.out.println("X : "+p.c.x+ "   Y : "+p.c.y);
            System.out.println(p.t);
        }
    }

    public class Coordinate {
        public int y,x;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public enum Trom {
        LL, UL, LR, UR, MM, EE
    }

    public class Pair {
        Coordinate c;
        Trom t;

        public Pair (Coordinate c, Trom t) {
            this.c = c;
            this.t = t;
        }

        public Coordinate getC() {
            return c;
        }

        public Trom getT() {
            return t;
        }
    }
}
