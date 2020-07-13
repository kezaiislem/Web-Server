/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomObjects;

/**
 *
 * @author ISLEM
 */
public class AnswerPostObject {
    
    private long id;
    private long questionId;
    private int value;
    private int[] values;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int[] getValues() {
        return values;
    }

    public void setValues(int[] values) {
        this.values = values;
    }
    
}
