import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.lang.*;
import java.awt.geom.*;



public class grid extends Component
{
   
   BufferedImage gridBack;      
   int newpixel = 19;
   
   
   public void paint(Graphics g)
   {
         
         Graphics2D g2 = (Graphics2D) g;
                  
         g.drawImage(gridBack,0,0,null);
         // 382/20 = roughly 19 so each pixel is going to count as 19
         
         int width = gridBack.getWidth();
         int height = gridBack.getHeight();
         //Draw the oridinal and abscissa
         g2.setStroke(new BasicStroke(3));
         g2.draw(new Line2D.Double(0,height/2,width,height/2));
         g2.draw(new Line2D.Double(width/2,0,width/2,height));

         
         g2.setStroke(new BasicStroke(4));
         for(int i = -newpixel; i < newpixel; i++)
         {
            
            g2.setColor(Color.blue);
            int x = width/2 + (i-1)*newpixel;
            int y = height/2 - (f(i - 1))*newpixel;
            int nextx = width/2 + i*newpixel;
            int nexty = height/2 - f(i)*newpixel;
            g2.draw(new Line2D.Double(x,y,nextx,nexty));
          
            g.setColor(Color.red);
            g.drawOval(x,y,2,2);
                        
         }
    
   }
   
   public int f(int x)
   {
      return x*x;
   }
   //Show the grid
   public grid() 
    {
       try 
       {
          gridBack= ImageIO.read(new File("grid.gif"));
       }catch (IOException e) {}
 
    }
    
 //Set up the dimension of the grid   
    public Dimension getPreferredSize() 
    {
        if (gridBack == null) 
             return new Dimension(200,200);
        else 
           return new Dimension(gridBack.getWidth(null), gridBack.getHeight(null));
       
    }
 
 
  //Plot some points  
  //Create Point2D.Double
  
  //Point2D.Double point = new Point2D.Double(x, y);   

 
   
 
public static void main(String[] args) {
 
        JFrame f = new JFrame("Parent Graph");
             
        f.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
 
        f.add(new grid());
        f.pack();
        f.setVisible(true);
    }

}




//setLocation(double x, double y) 
//Ð To set the location of the point- defining coordinates as double values.