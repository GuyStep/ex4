import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class Div extends BinaryExpression implements Expression {

    public Div(Expression ex1, Expression ex2) {
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
        return ex1.evaluate(assignment) / ex2.evaluate(assignment);
    }

    /**
     * A convenience method. Like the `evaluate(assignment)` method above,
     * but uses an empty assignment.
     *
     * @return the value
     */
    @Override
    public double evaluate() throws Exception {
        return ex1.evaluate() / ex2.evaluate();
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
        return new Div(e1, e2);
    }

    public String toString() {
        return "(" + ex1.toString() + " / " + ex2.toString() + ")";
    }

    /**
     * Returns the expression tree resulting from differentiating the current expression relative to variable `var`.
     *
     * @param var the variable name
     * @return the expression after differentiation
     */
    @Override
    public Expression differentiate(String var) {
        return new Div(new Minus(new Mul(ex1.differentiate(var), ex2), new Mul(ex1, ex2.differentiate(var))),
                new Pow(ex2, new Num(2)));
    }
}


