import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class UnaryExpression extends BaseExpression {


    abstract double evaluate(Map<String, Double> assignment) throws Exception;

    abstract double evaluate() throws Exception;

    abstract List<String> getVariables();

    abstract Expression assign(String var, Expression expression);



}
