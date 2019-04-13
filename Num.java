import java.util.List;
import java.util.Map;

public class Num implements Expression {
    double num;

    public Num(double num) {
        this.num = num;
    }

    public double evaluate(Map<String, Double> assignment) throws Exception {
        return this.num;
    }

    public double evaluate() throws Exception {
        return this.num;
    }

    public List<String> getVariables() {
        return null; ////////////////////@@@@@@@
    }

    public String toString() {
        String str = Double.toString(num);
        ;
        return str;
    }

    public Expression assign(String var, Expression expression) {
        return this;
    }

    /**
     * Returns the expression tree resulting from differentiating the current expression relative to variable `var`.
     *
     * @param var the variable name
     * @return the expression after differentiation
     */
    @Override
    public Expression differentiate(String var) {
        return new Num (0);
    }
}
