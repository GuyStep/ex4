import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class BaseExpression {

    Expression ex1, ex2;

    public BaseExpression(Expression ex1, Expression ex2) {
        this.ex1 = ex1;
        this.ex2 = ex2;
    }

    public BaseExpression(Expression ex1, double ex2) {
        this.ex1 = ex1;
        this.ex2 = new Num(ex2);
    }

    public BaseExpression(double ex1, double ex2) {
        this.ex1 = new Num(ex1);
        this.ex2 = new Num(ex2);
    }

    public BaseExpression(double ex1, Expression ex2) {
        this.ex1 = new Num(ex1);
        this.ex2 = ex2;
    }

    public BaseExpression(String ex1, String ex2) {
        this.ex1 = new Var(ex1);
        this.ex2 = new Var(ex2);
    }

    public BaseExpression(Expression ex1, String ex2) {
        this.ex1 = ex1;
        this.ex2 = new Var(ex2);
    }

    public BaseExpression(String ex1, Expression ex2) {
        this.ex1 = new Var(ex1);
        this.ex2 = ex2;
    }

    public BaseExpression(String ex1, double ex2) {
        this.ex1 = new Var(ex1);
        this.ex2 = new Num(ex2);
    }

    public BaseExpression(double ex1, String ex2) {
        this.ex1 = new Num(ex1);
        this.ex2 = new Var(ex2);
    }

    public BaseExpression(Expression ex1) {
        this.ex1 = ex1;
    }

    public BaseExpression() {
    }

    public Expression getEx1(){
        return ex1;
    }
    public Expression getEx2(){
        return ex2;
    }

    abstract double evaluate(Map<String, Double> assignment) throws Exception;

    abstract double evaluate() throws Exception;


    /**
     * Returns a list of the variables in the expression.
     *
     * @return the variable names used in expression
     */
    public List<String> getVariables(){
        List<String> ex1Variables = ex1.getVariables();
        List<String> ex2Variables = ex2.getVariables();
        if(ex1Variables == null){return ex2Variables;}
        if(ex2Variables == null){return ex1Variables;}
        for (String v : ex2Variables) {
            if (!ex1Variables.contains(v)) {
                ex1Variables.add(v);
            }
        }
        return ex1Variables;
    }

    abstract Expression assign(String var, Expression expression);

}
