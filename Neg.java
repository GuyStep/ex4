import java.util.List;
import java.util.Map;

public class Neg implements Expression {
    Expression ex;

    public Neg(Expression ex) {
        this.ex = ex;
    }

    public double evaluate(Map<String, Double> assignment) throws Exception {
        return (-1) * ex.evaluate(assignment);
    }

    public double evaluate() throws Exception {
        return (-1) * ex.evaluate();
    }

    public List<String> getVariables() {
        return ex.getVariables();
    }

    public String toString() {
        String str = "-" + ex.toString();
        return str;
    }

    public Expression assign(String var, Expression expression) {
        return new Mul(new Num(-1), ex.assign(var, expression));
    }

    /**
     * Returns the expression tree resulting from differentiating the current expression relative to variable `var`.
     *
     * @param var the variable name
     * @return the expression after differentiation
     */
    @Override
    public Expression differentiate(String var) {
        return null;
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
