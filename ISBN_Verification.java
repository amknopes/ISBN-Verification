import java.lang.*;

/**
 * See page bottom of 120/ top of page 121 in the Discrete Math book 
 * for instructions on valid ISBN numbers
 * 
 * @author Athena Knopes
 * 
 */
public class ISBN_Verification
{
   public boolean isValid(String isbn)
   {
      String noDashes=removeDashes(isbn);
      boolean multiply=false;
      int total=0;
      for(int x=0; x<noDashes.length()-1; x++)
      {
          if(multiply)
          {
              total+=(3*Integer.parseInt(noDashes.substring(x,x+1)));
              multiply=false;
          }
          else
          {
              total+=Integer.parseInt(noDashes.substring(x,x+1));
              multiply=true;
          }
      }
      System.out.print(" " + Integer.parseInt(noDashes.substring(noDashes.length()-1)));
      if(Integer.parseInt(noDashes.substring(noDashes.length()-1)) != (10-total%10))
          return false;
       return true;
   }
   public String removeDashes(String isbn)
   {
       String ans="";
       for(int x=0; x<isbn.length(); x++)
       {
           if(!isbn.substring(x, x+1).equals("-"))
               ans+=isbn.substring(x, x+1);
       }
       return ans;
   }
}