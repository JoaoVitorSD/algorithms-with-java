package algorithmsapi.galeshapley;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Matches {
    private List<String> matchA;

    private List<String> matchB = new ArrayList<>();

    private List<List<String>> proposeds;

    private List<List<String>> prefereces;

    public Matches(List<Preference> elements) {
        this.matchA = elements.stream().map(Preference::getElement).collect(Collectors.toList());

        this.proposeds = new ArrayList<>(matchA.size());
        matchA.forEach(e -> {
            matchB.add("");
            proposeds.add(new ArrayList<>());
        });
        this.prefereces = elements.stream().map(Preference::getPreferences).collect(Collectors.toList());
    }

    public List<String> getProposeds(String key) {
        return proposeds.get(matchA.indexOf(key));
    }


    public void addMatch(String a, String b){
        int index = matchA.indexOf(a);
        matchB.set(index,b);
    }

    public void addPropost(String key, String proposed){
        int index = matchA.indexOf(key);

        proposeds.get(index).add(proposed);
    }

    public void replaceMatch(String key, String newPair){
        int index = matchA.indexOf(key);
        matchB.set(index,newPair);
    }

    public void cleanMatch(String key){
        int index = matchA.indexOf(key);
        matchB.set(index,"");
    }
    public boolean isEmpty(String element){
        return matchB.get(matchA.indexOf(element))=="";
    }
    public boolean hasAnyEmptyNotProposedEveryone(){
        for(int i =0;i< matchA.size();i++){
            if(matchB.get(i).equals("")){
                if(proposeds.get(i).size()<matchA.size()){
                    return true;
                }
            }
        }
            return false;
    }

    public String findEmpty(){
        int index = matchB.indexOf("");
        return matchA.get(index);
    }

    public String getCurrentPair(String key){
        int index = matchA.indexOf(key);
        return matchB.get(index);
    }
    public String getFirstNotProposed(String hospital){
        int index = matchA.indexOf(hospital);
        for(String preference: prefereces.get(index)){
            if(!proposeds.get(index).contains(preference)){
                return preference;
            }
        }
        throw new RuntimeException("Lista não possui elementos livres");
    }

    public boolean preferElemt(String key, String element){
        int index = matchA.indexOf(key);
        int currentPairPosition = prefereces.get(index).indexOf(matchB.get(index));
        int possiblePairPosition = prefereces.get(index).indexOf(element);

        return possiblePairPosition<currentPairPosition;
    }
    public void print(){
        for(int i = 0;i<matchA.size();i++){
            System.out.println(matchA.get(i)+" - "+ matchB.get(i));
        }
    }
}
