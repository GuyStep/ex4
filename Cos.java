import java.util.List;
import java.util.Map;

public class Cos implements Expression {
    Expression ex;

    public Cos(Expression ex) {
        this.ex = ex;
    }

    public double evaluate(Map<String, Double> assignment) throws Exception {
        return Math.sin(ex.evaluate(assignment));
    }

    public double evaluate() throws Exception {
        return Math.cos(evaluate());
    }

    public List<String> getVariables() {
        return null; ////////////////////@@@@@@@
    }

    public String toString() {
        String str = "Cos(" + ex.toString() + ")";
        return str;
    }

    public Expression assign(String var, Expression expression) {
        return new Cos(ex.assign(var, expression));
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
}
