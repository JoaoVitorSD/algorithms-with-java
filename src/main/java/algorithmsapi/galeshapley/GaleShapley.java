package algorithmsapi.galeshapley;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GaleShapley {
    public static void readEntry(){
        try (Scanner sc = new Scanner(new File("entry.txt"))) {
            int size = sc.nextInt();
            sc.nextLine();
            GaleShapley.matchPreferences(mapEntryToListMatching(sc, size),mapEntryToListMatching(sc, size));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static Matches mapEntryToListMatching(Scanner sc, int size) {
        List<Preference> preference = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            String s = sc.next();
            List<String> preferences = new ArrayList<>(size);
            for (int j = 0; j < size; j++)
            {
                preferences.add(sc.next());
            }
            preference.add(new Preference(s,preferences));
        }
        return new Matches(preference);
    }
    public static void matchPreferences(Matches hospitals, Matches students){
        while (hospitals.hasAnyEmptyNotProposedEveryone()){
            String hospital = hospitals.findEmpty();
            String student = hospitals.getFirstNotProposed(hospital);
            hospitals.addPropost(hospital,student);
            if(students.isEmpty(student)){
                hospitals.addMatch(hospital,student);
                students.addMatch(student,hospital);
            }
            else {
                String current = students.getCurrentPair(student);
                if(students.preferElemt(student,hospital)){
                    hospitals.addMatch(hospital,student);
                    hospitals.cleanMatch(current);
                    students.replaceMatch(student, hospital);
                }
            }
        }
        hospitals.print();

    }
}
