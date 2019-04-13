import java.util.List;
import java.util.Map;

public class Sin implements Expression {
    Expression ex;

    public Sin(Expression ex) {
        this.ex = ex;
    }

    public double evaluate(Map<String, Double> assignment) throws Exception {
        return Math.sin(ex.evaluate(assignment));
    }

    public double evaluate() throws Exception {
        return Math.sin(evaluate());
    }

    public List<String> getVariables() {
        return null; ////////////////////@@@@@@@
    }

    public String toString() {
        String str = "Sin(" + ex.toString() + ")";
        return str;
    }

    public Expression assign(String var, Expression expression) {
        return new Sin(ex.assign(var, expression));
    }

    /**
     * Returns the expression tree resulting from differentiating the current expression relative to variable `var`.
     *
     * @param var the variable name
     * @return the expression after differentiation
     */
    @Override
    public Expression differentiate(String var) {
        return new Mul(new Cos(ex), ex.differentiate(var));
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
