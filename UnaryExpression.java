import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class UnaryExpression extends BaseExpression {
    public UnaryExpression (Expression ex1){
         super(ex1);
    }


    abstract double evaluate(Map<String, Double> assignment) throws Exception;

    abstract double evaluate() throws Exception;


    abstract Expression assign(String var, Expression expression);



}
