/*
    Aufgabe 1)
*/
public class Aufgabe1{

    public static void main(String[] args) {
        Song s1 = new Song("a1","b1",1);
        Song s2 = new Song("b2","b2",2);
        Song s3 = new Song("c3","b3",3);
        Song s4 = new Song("d4","b4",4);
        Song s5 = new Song("e5","b1",1);
        Song s6 = new Song("f6","b2",2);
        Song s7 = new Song("g7","b3",3);
        Song s8 = new Song("h8","b4",4);
        Song s9 = new Song("i9","b1",1);
        Song s10 = new Song("iA","b2",2);
        Song s11 = new Song("jB","b3",3);
        Song s12 = new Song("kC","b4",4);

        SongTable table = new SongTable(11);

        table.add(s1);
        table.add(s2);
        table.add(s3);
        table.add(s4);
        table.add(s5);
        table.add(s6);
        table.add(s7);
        table.add(s8);
        table.add(s9);
        table.add(s10);
        table.add(s11);
        table.add(s12);

        table.print();
    }

    /*



     */
}