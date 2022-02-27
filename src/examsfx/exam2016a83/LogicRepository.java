package examsfx.exam2016a83;

import java.util.ArrayList;

public class LogicRepository {
    private ArrayList<Question> list;

    public LogicRepository(){
        list = new ArrayList<Question>();
        list.add(new Question("q1", false));
        list.add(new Question("q2", false));
        list.add(new Question("q3", true));
        list.add(new Question("q4", true));
        list.add(new Question("q5",false));
    }

    public ArrayList<Question> getQuestions(int n){
        ArrayList<Question> temp = new ArrayList<Question>();
        for (int i = 0; i < n; i++) {
            temp.add(list.get(i));
        }
        return temp;
    }
}
