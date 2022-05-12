
/**
 * Does a line using Bresenham.
 *
 * @author Bill Viggers
 * @version 5-May-22
 */
public class BresenhamLine
{
    // instance variables - replace the example below with your own
    final boolean VERBOSE=true;

    /**
     * Constructor for objects of class Plot
     */

    public BresenhamLine(){
        Coordinate one=new Coordinate(0,0);
        Coordinate two=new Coordinate(10,7);
        BLine(one,two,true);
    }

    public BresenhamLine(boolean plot){
        if (plot){
            Coordinate one=new Coordinate(0,0);
            Coordinate two=new Coordinate(10,7);
            BLine(one,two,true);
        }
    }

    Board myBoard = new Board();

    // we use coordinate.getX() to get the X value of a coordinate and 
    // coordinate.getY() to get the Y value of a coordinate.
    public void BLine(Coordinate start, Coordinate end, boolean plot)
    {

        // Parameters as defined byt Bresenham.
        // Yes the names are ugly names, but that is how they are defined.
        int a = (end.getY()-start.getY())*2;
        int b = a - 2*(end.getX()-start.getX());
        int p = a-(end.getX()-start.getX());
        int yStep=1;  // What do we adjust Y by for each move in X?

        if (VERBOSE) System.out.println("Calculating A is "+a+", B as "+b+"; and p as "+p);
        int y=start.getY();
        for (int x=start.getX();x<=end.getX();x++){
            if (VERBOSE){
                System.out.print("p is now "+p);
                System.out.println("; Plotting at "+x+","+y);
            }
            if (plot) myBoard.plot(new Coordinate(x,y));
            // Do Bresenham maths.  
            // This version only works with lines sloping up to the right at no more than 45 degrees.
            if (p < 0) { //draw on same line
                p+=a;
            } else{
                y+=yStep;
                p+=b;
            } // move up a line

        } // for x;
    } // Bresenham Line
}
