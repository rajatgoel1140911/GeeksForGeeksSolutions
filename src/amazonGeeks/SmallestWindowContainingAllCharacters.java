package amazonGeeks;

import java.util.*;

public class SmallestWindowContainingAllCharacters {
	public static void main (String[] args) {
		//code
		
		Scanner obj=new Scanner(System.in);
		int t=obj.nextInt();
		
		while(t>=1)
		{
		    String s=obj.next();
		    String pat=obj.next();
		    
		    int ar[]=new int[26];
		  
		    HashSet<Character> hs=new HashSet<Character>(); 
		    HashMap<Character,Integer> hm=new HashMap<Character,Integer>();
		    
		    for(int i=0;i<pat.length();i++)
		    {
		    if(!hm.containsKey(pat.charAt(i)))
		    hm.put(pat.charAt(i),1);
		    
		    else
		    hm.put(pat.charAt(i),hm.get(pat.charAt(i))+1);
		    
		    
		    hs.add(pat.charAt(i));
		    }
		  
		    int l=0;
		    int r=0;
		    int minl=-1;
		    int minr=0;
		    int minlen=Integer.MAX_VALUE;
		    
		   while(r<s.length())
		   {
		       char c=s.charAt(r);
		       
		       if(hm.containsKey(c))
		       {
		          hm.put(c,hm.get(c)-1); 
		           if(hm.get(c)<=0)
		           hs.remove(c);
		           
		       }
		       
		 
		  while(hs.isEmpty())
		  {
			 // System.out.println("inside");
		      char ch=s.charAt(l);
		      
		       if(minlen>(r-l+1))
		           {
		               minlen=r-l+1;
		               minl=l;
		               minr=r;
		           }  
		               
		               if(hm.containsKey(ch))
		               {
		               hm.put(ch,hm.get(ch)+1);
		               if(hm.get(ch)>0)
		               hs.add(ch);
		               
		               }
		               
		               l++;
		  }
		   
	      r++;
	       
	      
	             
		    
		   }
		   
		    
		   System.out.println(s.substring(minl,minr+1)); 
		    t--;
		}
		
	}
}
