import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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

        double res = Math.log(getEx2().evaluate(assignment)) / Math.log(getEx2().evaluate(assignment));
        return res;
    }

    /**
     * A convenience method. Like the `evaluate(assignment)` method above,
     * but uses an empty assignment.
     *
     * @return the value
     */
    @Override
    public double evaluate() throws Exception {
        return Math.log(getEx2().evaluate()) / Math.log(getEx2().evaluate());
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
        Expression e1 = getEx2().assign(var, expression);
        Expression e2 = getEx2().assign(var, expression);
        return new Log(e1, e2);
    }

    public String toString() {
        return "log(" + getEx2().toString() + "," + getEx2().toString() + ")";
    }

    /**
     * Returns the expression tree resulting from differentiating the current expression relative to variable `var`.
     *
     * @param var the variable name
     * @return the expression after differentiation
     */
    @Override
    public Expression differentiate(String var) {
        Expression firstLn = new Log(new Var("e"), this.getEx2());
        Expression secondLn = new Log(new Var("e"), this.getEx2());
        Expression denom = new Pow(secondLn, new Num(2));
        Expression div1 = new Div(this.getEx2().differentiate(var), this.getEx2());
        Expression div2 = new Div(this.getEx2().differentiate(var), this.getEx2());
        Expression mult1 = new Mult(div1, secondLn);
        Expression mult2 = new Mult(div2, firstLn);
        Expression numer = new Minus(mult1, mult2);
        Expression difEx = new Div(numer, denom);
        return difEx;
       
       
       
        /*Expression newExp1 = new Div(ex2.differentiate(var), ex2);
        Expression newExp2 = new Div(ex1.differentiate(var), ex1);
        return new Div(newExp1, newExp2).differentiate(var).differentiate(var);
        //return new Div(new Div(ex2.differentiate(var), ex2), new Div(ex1.differentiate(var), ex1));
        ///NEED TO TEST BETTER */

    }

    /**
     * Returned a simplified version of the current expression.
     *
     * @return the simplified expression
     */
    @Override
    public Expression simplify() {
        Expression ex1Simp = getEx2().simplify(), ex2Simp = getEx2().simplify();

        try {
            if (ex2Simp.evaluate() == 1) {
                return ex1Simp.simplify();
            }
        } catch (Exception e) {

        }
        ;
        Boolean equality = false;
        try {
            if (ex1Simp.evaluate() == ex2Simp.evaluate()) {
                equality = true;
            } else {
                equality = false;
            }
        } catch (Exception e) {
        }

        List<String> vars = ex1Simp.getVariables();
        List<String> vars2 = ex2Simp.getVariables();

        if (vars.containsAll(vars2) && vars2.containsAll(vars)) {
            Map<String, Double> varsMap = new TreeMap<>();
            double i = 2;
            for (String s : vars) {
                varsMap.put(s, i);
                i += 1;
            }

            try {
                if (ex1Simp.evaluate(varsMap) == ex2Simp.evaluate(varsMap)) {
                    equality = true;
                } else {
                    equality = false;
                }
            } catch (Exception e) {
            }

        }


        if (equality) {
            return new Num(1);
        } else return new Log(getEx2().simplify(), getEx2().simplify());
    }

}


