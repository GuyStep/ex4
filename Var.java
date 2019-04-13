import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Var implements Expression {
    String var;

    public Var(String variable) {
        this.var = variable;
    }

    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        return assignment.get(this.var);
    }

    @Override
    public double evaluate() throws Exception {
        return 0;
    }

    @Override
    public List<String> getVariables() {
        List<String> list = new ArrayList<>();
        list.add(var);
        return list;
    }

    @Override
    public Expression assign(String var, Expression expression) {
        if (var.equals(this.var)) {
            return expression;
        } else {
            return this;
        }
    }

    public String toString() {
        return this.var;
    }

    /**
     * Returns the expression tree resulting from differentiating the current expression relative to variable `var`.
     *
     * @param var the variable name
     * @return the expression after differentiation
     */
    @Override
    public Expression differentiate(String var) {
        if (this.var == var){
            return new Num(1);
        }
        else{
            return new Num(0);
        }
    }
}
