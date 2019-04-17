import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public abstract class BinaryExpression extends BaseExpression {
public BinaryExpression(Expression ex1, Expression ex2){
    super(ex1,ex2);
}




    /**
     * Evaluate the expression using the variable values provided
     * in the assignment, and return the result.  If the expression
     * contains a variable which is not in the assignment, an exception
     * is thrown.
     *
     * @param assignment the map holds values of variables
     * @return the value of the expression
     */
    abstract double evaluate(Map<String, Double> assignment) throws Exception;

    /**
     * A convenience method. Like the `evaluate(assignment)` method above,
     * but uses an empty assignment.
     *
     * @return the value
     */
    @Override
    abstract double evaluate() throws Exception;

    /**
     * Returns a new expression in which all occurrences of the variable
     * var are replaced with the provided expression (Does not modify the
     * current expression).
     *
     * @param var        the variable name
     * @param expression the expression to be assigned in the variable
     * @return the value of the expression
     */
    @Override
    abstract Expression assign(String var, Expression expression);



}
