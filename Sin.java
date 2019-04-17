import java.util.List;
import java.util.Map;

public class Sin extends UnaryExpression implements Expression  {
    public Sin(Expression ex) {
        super(ex);
    }

    public double evaluate(Map<String, Double> assignment) throws Exception {
        double res = Math.sin(getEx1().evaluate(assignment));
        return res;
    }

    public double evaluate() throws Exception {
        return Math.sin(getEx1().evaluate());
    }

    public List<String> getVariables() {
        return getEx1().getVariables();   }

    public String toString() {
        String str = "Sin(" + getEx1().toString() + ")";
        return str;
    }

    public Expression assign(String var, Expression expression) {
        return new Sin(getEx1().assign(var, expression));
    }

    /**
     * Returns the expression tree resulting from differentiating the current expression relative to variable `var`.
     *
     * @param var the variable name
     * @return the expression after differentiation
     */
    @Override
    public Expression differentiate(String var) {
        Expression difEx =new Mult(new Cos(getEx1()), getEx1().differentiate(var));
        return difEx;
    }

    /**
     * Returned a simplified version of the current expression.
     *
     * @return the simplified expression
     */
    @Override
    public Expression simplify() {
        return this;
    }
}
