import java.util.Map;
import java.util.TreeMap;

public class ExpressionsTest {
    public static void main(String[] args){
        Expression ex3 = new Plus(new Plus(new Mult(new Num(2), new Var("x")), new Sin(new Mult(new Num(4), new Var("y")))), new Pow(new Var("e"), new Var("x")));
        //Print original expression
        System.out.println(ex3);

        Map<String, Double> assignment = new TreeMap<String, Double>();
        assignment.put("x", 2.0);
        assignment.put("y", 0.25);
        assignment.put("e", 2.71);
        //Print evaluated expression according to the map
        try {
            System.out.println(ex3.evaluate(assignment));
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
        //Print differentiated expression
        Expression ex3Dif = ex3.differentiate("x");
        System.out.println(ex3Dif);

        //Print value of differentiated expression with map
        try {
            System.out.println(ex3Dif.evaluate(assignment));
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
        //Print simlified differentiated expression
        System.out.println(ex3Dif.simplify());

    }
}
