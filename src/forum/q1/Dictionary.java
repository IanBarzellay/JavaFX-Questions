package forum.q1;

import java.util.ArrayList;

public class Dictionary extends Exception{
    private ArrayList<Word> list = new ArrayList<Word>();

    public Dictionary(){
        list.add(new Word("כן", "yes"));
        list.add(new Word("לא", "no"));
        list.add(new Word("שלום", "hello"));
        list.add(new Word("ישראל", "israel"));
    }

    public String hebrewToEnglish (String word) throws Exception{
        for (Word w :
                list) {
            if(w.getHe().equals(word)) return w.getEn();
        }
        throw new Exception();
    }

    public String englishToHebrew (String word) throws Exception{
        for (Word w :
                list) {
            if(w.getEn().equals(word)) return w.getHe();
        }
        throw new Exception();
    }

}
