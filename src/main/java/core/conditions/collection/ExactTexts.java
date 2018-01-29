package core.conditions.collection;

public class ExactTexts extends TextsOf {

    public ExactTexts(String... expectedTexts) {
        super(expectedTexts);
    }

    @Override
    public boolean checkElement(int index) {
        return actualTexts.get(index).equals(expectedTexts[index]);
    }
}
