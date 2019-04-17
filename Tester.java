import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Tester {

    public static void main(String[] args) {
        Expression e2 = new Plus(new Var("x"), new Var("y"));
        System.out.println(e2.toString());
        e2 = new Minus(e2, new Var("x"));

        System.out.println(e2.toString());

        List<String> vars = e2.getVariables();
        for (String s : vars)
            System.out.println(s);

        e2 = e2.assign("x", new Num(3));
        System.out.println(e2.toString());
        Map<String, Double> varsMap = new TreeMap<>();
        varsMap.put("y", 2.0);


        try {
            double result = e2.evaluate(varsMap);
            System.out.println(result);

        } catch (Exception e) {
            System.out.println("Exception was thrown");

        }


        Expression e = new Sin(new Pow(new Mult(new Plus(new Mult(new Num(2), new Var("x")), new Var("y")),
                new Num(4)), new Var("x")));
        System.out.println(e.toString());
        System.out.println("");


        varsMap.clear();
        varsMap.put("y", 1.0);
        varsMap.put("x", 2.0);
        try {
            System.out.println("Should be: -0.85091935963");
            System.out.println(e.evaluate(varsMap));
        } catch (Exception v) {
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


        Expression e5 = new Log(new Num(10), new Pow(new Mult(new Plus(new Mult(new Num(2), new Num(2)), new Num(1)),
                new Num(4)), new Num(2)));
        try {
            double result = e5.evaluate(varsMap);
            System.out.println(result);

        } catch (Exception x) {
            System.out.println("Exception was thrown");

        }
        System.out.println("");


        Expression e6 = new Log(new Num(3), new Plus(new Mult(new Num(10), new Var("x")), new Num(5)));
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
        ///Plus Tester:
        //Expression sim1 = new Plus(new Var("x"), new Num(0));
        Expression sim1 = new Plus(new Plus(new Var("x"), new Num(0)), new Num(0));
        // expected to get only (x);
        System.out.println(sim1.simplify());
        System.out.println("");

        ///Plus Tester:
        //Expression sim2 = new Minus(new Var("x"), new Num(0));
        Expression sim2 = new Minus(new Num(0), new Minus(new Num(0), new Var("x")));
        // expected to get only (x);
        System.out.println(sim2.simplify());
        System.out.println("");

        ///Mult Tester:
        //Expression sim3 = new Mult( new Num(0),new Mult( new Num(1), new Var("x")));
        Expression sim3 = new Mult(new Mult(new Num(0), new Var("x")), new Num(1));
        // expected to get only (0);
        System.out.println(sim3.simplify());
        System.out.println("");

        ///Div Tester:
        //Expression sim4 = new Mult( new Num(0),new Mult( new Num(1), new Var("x")));
        Expression sim4 = new Div(new Plus(new Mult(new Num(3), new Var("x")), new Num(10)),
                new Plus(new Mult(new Num(3), new Var("x")), new Num(10)));
        System.out.println(sim4.simplify());
        System.out.println("");

        ///Div Tester:
        //Expression sim5 = new Mult( new Num(0),new Mult( new Num(1), new Var("x")));
        Expression sim5 = new Log(new Plus(new Mult(new Num(3), new Var("x")), new Num(10)),
                new Plus(new Mult(new Num(3), new Var("x")), new Num(10)));
        System.out.println(sim5.simplify());
        System.out.println("");


        /// @@@@@ Previous year tester

        ///Ex1:
        {
            Expression ex1 = new Pow(new Plus(new Plus(new Var("x"), new Var("y")), new Var("z")), new Num(2));
            System.out.println("Expression 1: " + ex1);
            System.out.println("Expression 1 - Simp: " + ex1.simplify());
            System.out.println("");
        }

        ///Ex2:
        {
            Expression ex2 = new Pow(new Plus(new Plus(new Var("x"), new Var("Y")), new Plus(new Var("z"), new Var("w"))), new Num(4));
            System.out.println("Expression 2: " + ex2);
            System.out.println("Expression 2 - Simp: " + ex2.simplify());
            System.out.println("");
        }

        ///Ex3:
        {
            Expression ex3 = new Plus(new Plus(new Mult(new Num(2), new Var("x")), new Sin(new Mult(new Num(4), new Var("y")))), new Pow(new Var("e"), new Var("x")));
            System.out.println("Expression 3: " + ex3);
            System.out.println("Expression 3 - Simp: " + ex3.simplify());
            System.out.println("");
        }

        ///Ex4:
        {
            Expression ex4 = new Div(new Plus(new Sin(new Num(1)), new Cos(new Num(1))), new Num(10));
            System.out.println("Expression 4: " + ex4);
            System.out.println("Expression 4 - Simp: " + ex4.simplify());
            System.out.println("");
        }

        ///Ex5:
        {
            Expression ex5 = new Mult(new Log(new Mult(new Num(9), new Var("x")), new Mult(new Num(9), new Var("x"))), new Mult(new Num(2), new Var("y")));
            System.out.println("Expression 5: " + ex5);
            System.out.println("Expression 5 - Simp: " + ex5.simplify());
            System.out.println("");
        }

        ///Ex6:
        {
            Expression ex6 = new Neg(new Plus(new Neg(new Neg(new Minus(new Minus(new Neg(new Num(2)), new Num(0)), new Num(4)))), new Var("x")));
            //Expression ex6 = new Plus(new Neg(new Mult(new Div(new Var("y"), new Neg(new Div(new Var("y"), new Var("x")))), new Num(0))),
            //       new Neg(new Plus(new Neg(new Neg(new Minus(new Minus(new Neg(new Num(2)),new Num(0)), new Num(4)))),new Var ("x"))));
            System.out.println("Expression 6: " + ex6);
            //new Plus(new Mult(new Neg(new Div(new Var ("y") , (new Neg(new Div(new Var ("y") , new Var ("x")))) , new Num(0)) , (-((-(-((new Neg(new Num (2)) - new Num (0)))) - new Num (4))) + new Var("x"))
            System.out.println("Expression 6 - Simp: " + ex6.simplify());
            System.out.println("");
        }

        ///Ex7:
        {
            Expression ex7 = new Minus(new Plus(new Pow(new Var("x"), new Num(2)), new Pow(new Var("y"), new Num(2))), new Pow(new Var("z"), new Num(3)));
            System.out.println("Expression 7: " + ex7);
            System.out.println("Expression 7 - Simp: " + ex7.simplify());
            System.out.println("");
        }

        ///Ex8:
        {
            Expression ex8 = new Div(new Log(new Var("x"), new Var("x")), new Log(new Var("x"), new Var("x")));
            System.out.println("Expression 8: " + ex8);
            System.out.println("Expression 8 - Simp: " + ex8.simplify());
            System.out.println("");
        }

        ///Ex9:
        {
            Expression ex9 = new Minus( new Num(0) , new Div(new Mult(new Var("x") , new Num(1)) ,  new Num(1)));
            System.out.println("Expression 9: " + ex9);
            System.out.println("Expression 9 - Simp: " + ex9.simplify());
            System.out.println("");
        }


///TEST FROM TELEGRAM
        ////(Sin((Cos((-(x+(y-(z*(w/(k^(Log r Base t)))))))))))
        Expression e1 = new Sin(new Cos(new Neg(new Plus(new Var("x"),new Minus(new Var("y"),new Mult(new Var("z"),new Div(new Var("w"),new Pow(new Var("k"),new Log(new Var("t"),new Var("r"))))))))));

        System.out.println(e1.toString());
        System.out.println(e1.getVariables());
        Map<String, Double> assignment = new TreeMap<String, Double>();
        assignment.put("x", 2.0);
        assignment.put("y", 4.0);
        assignment.put("z", 2.0);
        assignment.put("w", 4.0);
        assignment.put("k", 2.0);
        assignment.put("t", 1.0);
        assignment.put("r", 1.0);
        try {
            System.out.println(Math.log(1));

            System.out.println(e1.evaluate(assignment));
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }


        Expression assignTest = new Plus(new Num(2), new Num(3));

        System.out.println(assignTest.toString());
        System.out.println(assignTest.getVariables());

    }
}


