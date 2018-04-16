package entities;

import java.util.ArrayList;
import java.util.List;


public class Question {
    
    String questionString;
    List<String> answerList = new ArrayList();
    String correctAnswer;

    public Question(String questionString, List<String> answerList, String correctAnswer) {
        this.questionString = questionString;
        this.answerList = answerList;
        this.correctAnswer = correctAnswer;
        
        if(!answerList.contains(this.correctAnswer)){
            answerList.add(correctAnswer);
        }
        
    }
    
    

    public String getQuestionString() {
        return questionString;
    }

    public void setQuestionString(String questionString) {
        this.questionString = questionString;
    }

    public List<String> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<String> answerList) {
        this.answerList = answerList;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
    
    
    public boolean isAnswerCorrect(String answer) {
        return correctAnswer == answer;
    }
    
    
}
