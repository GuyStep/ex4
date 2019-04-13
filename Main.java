import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        Expression e2 = new Plus(new Var("x"), new Var("y"));
        System.out.println(e2.toString());
        e2 = new Minus(e2, new Var("x"));

        System.out.println(e2.toString());

        List<String> vars = e2.getVariables();
        for(String s : vars)
            System.out.println(s);

        e2 = e2.assign("x", new Num (3));
        System.out.println(e2.toString());
        Map<String, Double> varsMap = new TreeMap<>();
        varsMap.put("y", 2.0);

        try{
            double result = e2.evaluate(varsMap);
            System.out.println(result);

        }
        catch(Exception e) {
            System.out.println("Exception was thrown");

        }




        Expression e = new Sin(new Pow(new Mul(new Plus(new Mul(new Num(2), new Var("x")), new Var("y")),
                new Num(4)), new Var("x")));
        System.out.println(e.toString());
        System.out.println("");


        varsMap.clear();
        varsMap.put("y", 1.0);
        varsMap.put("x", 2.0);
        try{
            System.out.println("Should be: -0.85091935963");
            System.out.println(e.evaluate(varsMap));
        }         catch(Exception v) {
            System.out.println("Exception was thrown");

        }
        System.out.println("");



        Expression e3 = new Pow(new Plus(new Var("x"), new Var("y")), new Num(2));
        System.out.println("Should be: (x + y)^2");
        System.out.println(e3.toString());
        System.out.println("");


        Expression e4 = e3.assign("y", e3);
        System.out.println("Should be: (x + ((x + y)^2))^2");
        System.out.println(e4);
        System.out.println("");

        e4 = e4.assign("x", new Num(1));
        System.out.println("Should be: (1 + ((1 + y)^2))^2");
        System.out.println(e4);



        Expression e5 = new Log(new Num (10),new Pow(new Mul(new Plus(new Mul(new Num(2), new Num(2)), new Num(1)),
                new Num(4)), new Num(2)));
        try{
            double result = e5.evaluate(varsMap);
            System.out.println(result);

        }
        catch(Exception x) {
            System.out.println("Exception was thrown");

        }
        System.out.println("");



        Expression e6 = new Log(new Num(3), new Plus (new Mul(new Num(10), new Var ("x")), new Num (5)));
        System.out.println(e6);
        System.out.println("");
        System.out.println(e6.differentiate("x"));
        System.out.println("");


        Expression e7 = new Pow(new Var("x"), new Num(4));
        System.out.println(e7);

        Expression de = e7.differentiate("x");
        System.out.println(de);
        System.out.println("");


        Expression e8 = new Pow(new Plus(new Var("x"), new Var("y")), new Num(2));
        System.out.println(e8.differentiate("x"));
        System.out.println("");

        // the result is:
        //  (((x + y) ^ 2.0) * (((1.0 + 0.0) * (2.0 / (x + y))) + (0.0 * log(e, (x + y))))
        //My result is:
        //  ((((x + y) ^ 2.0) * ((1.0 + 0.0) * (2.0 / (x + y)))) + (0.0 * log(e, (x + y))))



        /// @@@@@ CHECK THE SIMPLIFICATION @@@@@
        //Expression sim1 = new Plus(new Var("x"), new Num(0));
        Expression sim1 = new Plus(new Plus(new Var("x"), new Num(0)), new Num(0));
        // expected to get only (x);
        System.out.println(sim1.simplify());
        System.out.println("");

    }
}
