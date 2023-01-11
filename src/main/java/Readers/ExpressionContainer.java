package Readers;

import java.util.ArrayList;

public class ExpressionContainer {
    ArrayList<String> expressions;
    public ExpressionContainer(){
        expressions = new ArrayList<>();
    }
    public ExpressionContainer(ArrayList<String> exps){
        expressions.addAll(exps);
    }

    @Override
    public String toString() {
        return expressions.toString();
    }
}
