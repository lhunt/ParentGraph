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
  
   
   JFrame frame = new JFrame("Parent Graph");

   public void paint(Graphics g)
   {
         //Make the tic marks 20 apart
         frame.setSize(400,400);
         int newpixelX = getWidth()/20;
         System.out.println(newpixelX);
         System.out.println(getWidth());
         int newpixelY = getHeight()/20;
         int width = getWidth();
         int height = getHeight();
         Graphics2D g2 = (Graphics2D) g;
         //int remainderW = width%15;
         //int remainderH = height%15;
         
        // if(remainderH  0) height = height - remainderH;
        // if(remainderW != 0) width = width - remainderW;
        // frame.setSize(width,height);   
         //g.drawImage(gridBack,0,0,null);
         // 382/20 = roughly 19 so each pixel is going to count as 19
         g2.setStroke(new BasicStroke(1));
         for(int v = 0; v < width; v+=newpixelX)
          g2.draw(new Line2D.Double(v,height,v,0));
         for(int h = 0; h < height; h+=newpixelY)
          g2.draw(new Line2D.Double(0,h,width,h));
         
         
         
         g2.setStroke(new BasicStroke(3));
         g2.draw(new Line2D.Double(0,height/2,width,height/2));
         g2.draw(new Line2D.Double(width/2,0,width/2,height));

         
         g2.setStroke(new BasicStroke(4));
         for(int i = -newpixelX; i < newpixelX; i++)
         {
            
            g2.setColor(Color.blue);
            int x = width/2 + (i-1)*newpixelX;
            int y = height/2 - (f(i - 1))*newpixelY;
            int nextx = width/2 + i*newpixelX;
            int nexty = height/2 - f(i)*newpixelY;
            g2.draw(new Line2D.Double(x,y,nextx,nexty));
          
            g.setColor(Color.red);
            g.drawOval(x,y,2,2);
                        
         }
    
   }
   public grid()
   {
      
   
   }
   public int f(int x)
   {
      return Math.abs(x);
   }
   /*Show the grid
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
           return new Dimension(gridBack.width(null), gridBack.height(null));
       
    }
 
   */
 
public static void main(String[] args) {
 
         grid g = new grid();           
        g.frame.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
 
        //g.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        g.frame.add(g);
       // g.frame.pack();
        g.frame.setSize(100,100);
        g.frame.setVisible(true);
    }

}




//setLocation(double x, double y) 
//Ð To set the location of the point- defining coordinates as double values.