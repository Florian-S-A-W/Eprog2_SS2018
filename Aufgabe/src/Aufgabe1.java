/*
    Aufgabe 1)
*/
public class Aufgabe1{

    public static void main(String[] args) {
        Song s1 = new Song("a1","b1",1);
        Song s2 = new Song("b2","b2",2);
        Song s3 = new Song("c3","b3",3);
        Song s4 = new Song("d4","b4",4);

        SongTree1 tree = new SongTree1();
        tree.add(s1);
        tree.add(s2);
        tree.print();
        tree.add(s3);
        tree.add(s4);
        tree.print();

        System.out.println(tree.toString());
    }

    /*

    a) Man kann mit dem Rückgabewert leicht einen Null-Node durch einen besetzten ersetzen. Ohne Rückgabewert wäre das schwerer,
    sofern man nicht prüfen darf ob der Unterbaum ein Null-Node ist. Man könnte zum Beispiel die add Funktion überladen um das
    Problem zu lösen.

    b) Beim print Aufruf weird bei den binary nodes immer der Song geprintet wenn print eines Childs aufgerufen wird. Ist es ein
    Null-Node wird nichts gemacht. Bei add wird bei Binary Nodes weitergegangen und der Song eingefügt wenn ein Null Node erreicht ist,
    also wenn dort add() aufgerufen wird.

    c) Ich habe SongTree nicht implementiert da ich leider an der letzten Übung nicht teilnehmen konnte.
    Tatsächlich sehe ich keine Vorteile, Nachteil ist dass es mühsamer zu implementieren ist. Theoretisch braucht SongTree1 mehr Speicher, aber so
    wenig dass es egal ist.

    2. a) Ich habe es hinzugefügt, da es übersichtlicher ist.

        b) print führt direkt die print Operation aus und toString gibt einen String zurück.


     */
}