import java.util.Map;
import java.util.List;

/**
 * The interface Expression.
 */
public interface Expression {
    /**
     * Evaluate the expression using the variable values provided
     * in the assignment, and return the result.  If the expression
     * contains a variable which is not in the assignment, an exception
     * is thrown.
     *
     * @param assignment the map holds values of variables
     * @return the value of the expression
     * @throws Exception the exception
     */
    double evaluate(Map<String, Double> assignment) throws Exception;

    /**
     * A convenience method. Like the `evaluate(assignment)` method above,
     * but uses an empty assignment.
     *
     * @return the value
     * @throws Exception the exception
     */
    double evaluate() throws Exception;

    /**
     * Returns a list of the variables in the expression.
     *
     * @return the variable names used in expression
     */
    List<String> getVariables();


    /**
     * Returns a list of the variables in the expression.
     *
     * @return a nice string representation of the expression.
     */
    String toString();

    /**
     * Returns a new expression in which all occurrences of the variable
     * var are replaced with the provided expression (Does not modify the
     * current expression).
     *
     * @param var        the variable name
     * @param expression the expression to be assigned in the variable
     * @return the value of the expression
     */
    Expression assign(String var, Expression expression);

    /**
     * Returns the expression tree resulting from differentiating the current expression relative to variable `var`.
     *
     * @param var the variable name
     * @return the expression after differentiation
     */
    Expression differentiate(String var);

    /**
     * Returned a simplified version of the current expression.
     *
     * @return the simplified expression
     */
     Expression simplify();




}
