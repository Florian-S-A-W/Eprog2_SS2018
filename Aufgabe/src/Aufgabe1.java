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

        Playlist1 list = new Playlist1();

        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);
        list.add(s6);
        list.add(s7);
        list.add(s8);
        list.add(s9);
        list.add(s10);
        list.add(s11);
        list.add(s12);

        list.print();
    }

    /*



     */
}