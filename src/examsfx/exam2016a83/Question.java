package examsfx.exam2016a83;

public class Question {
    private  String text;
    private boolean answer;

    public Question(String text, boolean answer) {
        this.text = text;
        this.answer = answer;
    }

    public String getText(){return text;}
    public boolean getAnswer(){return answer;}
}
