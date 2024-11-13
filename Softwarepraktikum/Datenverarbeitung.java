Aufgabe 1:
Schreiben Sie eine Methode, die die Summe der Quadrate der Zahlen in einer Liste berechnet.

java
Code kopieren
import java.util.List;

public class Datenverarbeitung {

    public static int summeDerQuadrate(List<Integer> zahlen) {
        return zahlen.stream()
                     .mapToInt(x -> x * x)
                     .sum();
    }

    public static void main(String[] args) {
        List<Integer> zahlen = List.of(1, 2, 3, 4, 5);
        System.out.println("Summe der Quadrate: " + summeDerQuadrate(zahlen));
    }
}
Aufgabe 2:
Schreiben Sie eine Methode, die die Anzahl der geraden Zahlen in einer Liste zählt.

java
Code kopieren
import java.util.List;

public class Datenverarbeitung {

    public static long anzahlDerGeradenZahlen(List<Integer> zahlen) {
        return zahlen.stream()
                     .filter(x -> x % 2 == 0)
                     .count();
    }

    public static void main(String[] args) {
        List<Integer> zahlen = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Anzahl der geraden Zahlen: " + anzahlDerGeradenZahlen(zahlen));
    }
}
Aufgabe 3:
Schreiben Sie eine Methode, die den Durchschnitt der Längen von Strings in einer Liste berechnet.

java
Code kopieren
import java.util.List;

public class Datenverarbeitung {

    public static double durchschnittDerStringLängen(List<String> strings) {
        return strings.stream()
                      .mapToInt(String::length)
                      .average()
                      .orElse(0.0);
    }

    public static void main(String[] args) {
        List<String> strings = List.of("Hallo", "Welt", "Java", "Streams");
        System.out.println("Durchschnittliche Länge der Strings: " + durchschnittDerStringLängen(strings));
    }
}
Aufgabe 4:
Schreiben Sie eine Methode, die den größten String in einer Liste von Strings findet.

java
Code kopieren
import java.util.List;

public class Datenverarbeitung {

    public static String längsterString(List<String> strings) {
        return strings.stream()
                      .max(Comparator.comparingInt(String::length))
                      .orElse("");
    }

    public static void main(String[] args) {
        List<String> strings = List.of("Hallo", "Welt", "Java", "Streams");
        System.out.println("Längster String: " + längsterString(strings));
    }
}
Aufgabe 5:
Schreiben Sie eine Methode, die prüft, ob alle Strings in einer Liste aus mehr als 3 Buchstaben bestehen.

java
Code kopieren
import java.util.List;

public class Datenverarbeitung {

    public static boolean alleStringsLängerAlsDrei(List<String> strings) {
        return strings.stream()
                      .allMatch(s -> s.length() > 3);
    }

    public static void main(String[] args) {
        List<String> strings = List.of("Hallo", "Welt", "Java", "Streams");
        System.out.println("Alle Strings länger als drei Buchstaben: " + alleStringsLängerAlsDrei(strings));
    }
}
Ich hoffe, diese Übungsaufgaben und Lösungen sind hilfreich!



Aufgabe 6:
Gegeben ist eine Liste von Wörtern. Schreiben Sie eine Methode, die eine Map erstellt, die für jedes Wort in der Liste das Wort selbst als Schlüssel und die Länge des Wortes als Wert enthält.

java
Code kopieren
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Datenverarbeitung {

    public static Map<String, Integer> wortLängenMap(List<String> wörter) {
        return wörter.stream()
                     .collect(Collectors.toMap(wort -> wort, String::length));
    }

    public static void main(String[] args) {
        List<String> wörter = List.of("Hallo", "Welt", "Java", "Streams");
        Map<String, Integer> wortLängen = wortLängenMap(wörter);
        System.out.println("Wortlängen-Map: " + wortLängen);
    }
}
Aufgabe 7:
Gegeben ist eine Liste von Sätzen. Schreiben Sie eine Methode, die eine Liste von Wörtern zurückgibt, wobei Duplikate entfernt sind und die Wörter in Großbuchstaben sind, sortiert nach ihrer Länge in aufsteigender Reihenfolge.

java
Code kopieren
import java.util.List;
import java.util.stream.Collectors;

public class Datenverarbeitung {

    public static List<String> sortierteWortliste(List<String> sätze) {
        return sätze.stream()
                    .flatMap(satz -> List.of(satz.split("\\s+")).stream())
                    .distinct()
                    .map(String::toUpperCase)
                    .sorted((s1, s2) -> s1.length() - s2.length())
                    .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> sätze = List.of("Hallo Welt", "Java ist toll", "Streams sind nützlich");
        List<String> sortierteWörter = sortierteWortliste(sätze);
        System.out.println("Sortierte Wortliste: " + sortierteWörter);
    }
}
Aufgabe 8:
Gegeben ist eine Liste von Zahlen. Schreiben Sie eine Methode, die eine Liste von Wörtern zurückgibt, wobei jedes Wort die Darstellung der entsprechenden Zahl im Binärsystem ist.

java
Code kopieren
import java.util.List;
import java.util.stream.Collectors;

public class Datenverarbeitung {

    public static List<String> binäreDarstellungen(List<Integer> zahlen) {
        return zahlen.stream()
                     .map(Integer::toBinaryString)
                     .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> zahlen = List.of(10, 15, 20);
        List<String> binäreDarstellungen = binäreDarstellungen(zahlen);
        System.out.println("Binäre Darstellungen: " + binäreDarstellungen);
    }
}
Aufgabe 9:
Gegeben ist eine Liste von Studentenobjekten. Schreiben Sie eine Methode, die den Durchschnitt der Noten aller Studenten berechnet.

java
Code kopieren
import java.util.List;

public class Datenverarbeitung {

    static class Student {
        private String name;
        private int note;

        public Student(String name, int note) {
            this.name = name;
            this.note = note;
        }

        public int getNote() {
            return note;
        }
    }

    public static double durchschnittsNote(List<Student> studenten) {
        return studenten.stream()
                        .mapToInt(Student::getNote)
                        .average()
                        .orElse(0.0);
    }

    public static void main(String[] args) {
        List<Student> studenten = List.of(
            new Student("Max", 80),
            new Student("Lisa", 90),
            new Student("Tom", 70)
        );
        System.out.println("Durchschnittsnote: " + durchschnittsNote(studenten));
    }
}
Aufgabe 10:
Gegeben ist eine Liste von Wörtern. Schreiben Sie eine Methode, die die Häufigkeit jedes Worts zählt und die Ergebnisse als Map zurückgibt.

java
Code kopieren
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Datenverarbeitung {

    public static Map<String, Long> wortHäufigkeiten(List<String> wörter) {
        return wörter.stream()
                     .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
    }

    public static void main(String[] args) {
        List<String> wörter = List.of("Hallo", "Welt", "Hallo", "Java", "Hallo", "Streams", "Java");
        Map<String, Long> häufigkeiten = wortHäufigkeiten(wörter);
        System.out.println("Wort Häufigkeiten: " + häufigkeiten);
    }
}
