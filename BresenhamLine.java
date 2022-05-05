
/**
 * Does a line using Bresenham.
 *
 * @author Bill Viggers
 * @version 5-May-22
 */
public class BresenhamLine
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Plot
     */
    public BresenhamLine()
    {
        // initialise instance variables
        Board myBoard = new Board();
        Coordinate one=new Coordinate(2,0);
        Coordinate two=new Coordinate(10,3);

        // Parameters as defined byt Bresenham.
        // Yes the names are ugly names, but that is how they are defined.
        int a = (two.getY()-one.getY())*2;
        int b = a - 2*(two.getX()-one.getX());
        int p = a-(two.getX()-one.getX());

        System.out.println("Calculating A is "+a+", B as "+b+"; and p as "+p);
        int y=one.getY();
        for (int x=one.getX();x<=two.getX();x++){
            System.out.print("p is now "+p);
            System.out.println("; Plotting at "+x+","+y);
            myBoard.plot(new Coordinate(x,y));
            // Do Bresenham maths.  
            // This version only works with lines sloping up to the right at no more than 45 degrees.
            if (p < 0) { //draw on same line
                p+=a;
            } else{
                y++;
                p+=b;
            } // move up a line

        } // for x;
    } // Bresenham Line
}
