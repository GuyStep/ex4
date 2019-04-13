import java.util.List;
import java.util.Map;

public abstract class BinaryExpression extends BaseExpression {
    Expression ex1, ex2;

    public BinaryExpression(Expression ex1, Expression ex2) {
        this.ex1 = ex1;
        this.ex2 = ex2;
    }

    public BinaryExpression(Expression ex1, double ex2) {
        this.ex1 = ex1;
        this.ex2 = new Num(ex2);
    }

    public BinaryExpression(double ex1, double ex2) {
        this.ex1 = new Num(ex1);
        this.ex2 = new Num(ex2);
    }

    public BinaryExpression(double ex1, Expression ex2) {
        this.ex1 = new Num(ex1);
        this.ex2 = ex2;
    }

    public BinaryExpression(String ex1, String ex2) {
        this.ex1 = new Var(ex1);
        this.ex2 = new Var(ex2);
    }

    public BinaryExpression(Expression ex1, String ex2) {
        this.ex1 = ex1;
        this.ex2 = new Var(ex2);
    }

    public BinaryExpression(String ex1, Expression ex2) {
        this.ex1 = new Var(ex1);
        this.ex2 = ex2;
    }

    public BinaryExpression(String ex1, double ex2) {
        this.ex1 = new Var(ex1);
        this.ex2 = new Num(ex2);
    }

    public BinaryExpression(double ex1, String ex2) {
        this.ex1 = new Num(ex1);
        this.ex2 = new Var(ex2);
    }
    public BinaryExpression(){};


    /**
     * Evaluate the expression using the variable values provided
     * in the assignment, and return the result.  If the expression
     * contains a variable which is not in the assignment, an exception
     * is thrown.
     *
     * @param assignment the map holds values of variables
     * @return the value of the expression
     */
    abstract double evaluate(Map<String, Double> assignment) throws Exception;

    /**
     * A convenience method. Like the `evaluate(assignment)` method above,
     * but uses an empty assignment.
     *
     * @return the value
     */
    @Override
    abstract double evaluate() throws Exception;

    /**
     * Returns a list of the variables in the expression.
     *
     * @return the variable names used in expression
     */
    @Override
    public List<String> getVariables() {
        List<String> ex1Variables = ex1.getVariables();
        List<String> ex2Variables = ex2.getVariables();
        for (String v : ex2Variables) {
            if (!ex1Variables.contains(v)) {
                ex1Variables.add(v);
            }
        }
        return ex1Variables;
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
    abstract Expression assign(String var, Expression expression);

}
