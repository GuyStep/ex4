import java.util.Map;

public class Log extends BinaryExpression implements Expression {


    public Log(Expression ex1, Expression ex2) {
        super(ex1, ex2);
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
    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        return Math.log(ex2.evaluate(assignment)) / Math.log(ex1.evaluate(assignment));
    }

    /**
     * A convenience method. Like the `evaluate(assignment)` method above,
     * but uses an empty assignment.
     *
     * @return the value
     */
    @Override
    public double evaluate() throws Exception {
        return Math.log(ex2.evaluate()) / Math.log(ex1.evaluate());
    }

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
    public Expression assign(String var, Expression expression) {
        Expression e1 = ex1.assign(var, expression);
        Expression e2 = ex2.assign(var, expression);
        return new Log(e1, e2);
    }

    public String toString() {
        return "log(" + ex1.toString() + "," + ex2.toString() + ")";
    }

    /**
     * Returns the expression tree resulting from differentiating the current expression relative to variable `var`.
     *
     * @param var the variable name
     * @return the expression after differentiation
     */
    @Override
    public Expression differentiate(String var) {
        Expression newExp1 = new Div(ex2.differentiate(var), ex2);
        Expression newExp2 = new Div(ex1.differentiate(var), ex1);
        return new Div(newExp1, newExp2).differentiate(var).differentiate(var);
        //return new Div(new Div(ex2.differentiate(var), ex2), new Div(ex1.differentiate(var), ex1));
        ///NEED TO TEST BETTER

    }

    /**
     * Returned a simplified version of the current expression.
     *
     * @return the simplified expression
     */
    @Override
    public Expression simplify() {
        return null;
    }
}


