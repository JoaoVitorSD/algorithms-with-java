package algorithmsapi.galeshapley;

import java.util.List;

public class Preference {
    private String element;
    private List<String> preferences;

    public Preference(String element, List<String> preferences) {
        this.element = element;
        this.preferences = preferences;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public List<String> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<String> preferences) {
        this.preferences = preferences;
    }
}
