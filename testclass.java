
package testproject;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigInteger;


public class testclass {


	public static void main(String[] args)
	{
		char Matrix[][] = { 
				
							{ ' ', '*', '4', '>', 'H', 'R', '\\', 'f', 'o', 'x' },
							{ '!', '+', '5', '?', 'I', 'S', ']', 'g', 'p', 'y' },
							{ '\\', ',', '6', '@', 'J', 'T', '^', 'h', 'q', 'z' },
							{ '#', '-', '7', 'A', 'K', 'U', '_', 'i', 'r', '{' },
							{ '$', '.', '8', 'B', 'L', 'V', '`', 'j', 's', '|' }, 
							{ '%', '/', '9', 'C', 'M', 'W', 'a', 'k', 't', '}' },
							{ '&', '0', ':', 'D', 'N', 'X', 'b', 'l', 'u', '~' },
							{ '\'', '1', ';', 'E', 'O', 'Y', 'c', 'm', 'v', ' ' }, 
							{ '(', '2', '<', 'F', 'P', 'Z', 'd', 'n', 'w', ' ' },
							{ ')', '3', '=', 'G', 'Q', '[', 'e', '\\', 'n', ' ' } 
				
	};
		
		
		// M and W are given in the data.
		BigInteger MM = new BigInteger("2036764117802210446778721319780021001");
		BigInteger M = MM.nextProbablePrime();
		System.out.println("Value of M: "+ M);
		
		BigInteger WW = new BigInteger("127552671440279916013001");
		BigInteger W = WW.nextProbablePrime();
		System.out.println("Value of W: "+ W);
	
		System.out.println("Cross check M and W values, their gcd should be 1: " + W.gcd(M));
		
		// Initialize the given public key.
		BigInteger knapsack[] = { 
				new BigInteger("7379441564850969401451185884533"), new BigInteger("56378280776603722877755282"), new BigInteger("112884114224647725671523585"),
				new BigInteger("60452387844955357941794678553967454"), new BigInteger("1658184728723638908169273"), new BigInteger("30226193922350126299457059360970706"),
				new BigInteger("1627613290730052207554796267157973143"), new BigInteger("1801681484093953813683921625"), new BigInteger("3689721101307163301425382974819"),
				new BigInteger("59035535069861184017207807336684"), new BigInteger("450516035527068663357990172"), new BigInteger("3571474800327837648364588"),
				new BigInteger("472284279921126114936262878628367"), new BigInteger("1844860359324574490292817467878"), new BigInteger("944568559714699558432245841243713"),
				new BigInteger("14413069214737309669723333937"), new BigInteger("483619102758622442162835189103635464"), new BigInteger("900904518382697046799967323"),
				new BigInteger("3778274240261877619572062441118083"), new BigInteger("28061587716861581522864620"), new BigInteger("1889137120194715145506171178565552"),
				new BigInteger("1218462463657766415659430934619911908"), new BigInteger("236142140151892064628551313333715"), new BigInteger("15113096961302615821168809596498374"),
				new BigInteger("800321619026644769080281098919604918"), new BigInteger("1832188704265876221823878233636971208"), new BigInteger("29517767152272577687764155629279"),
				new BigInteger("461215026054807902433246360459"), new BigInteger("241809551379183668409977314635804711"), new BigInteger("7206853489047255534651699521"),
				new BigInteger("225002912420653771846969044"), new BigInteger("115303660849198395398374580349"), new BigInteger("892868700081959412091147"),
				new BigInteger("1934476411034489768651340756414541856"), new BigInteger("57651639095592037279313270643"), new BigInteger("922430307214958685426324746960"),
				new BigInteger("13903241186990510845419289"), new BigInteger("120904775689272952526387957527869803"), new BigInteger("230607704356411111636497199761"),
				new BigInteger("28825883324131738779614641832"), new BigInteger("14758884022570638884861783860213"), new BigInteger("7270502272095955212742197"),
				new BigInteger("3602980310173586787619804187"), new BigInteger("400160809513705042554461389207841522"), new BigInteger("118071070267275039474695530686389"),
				new BigInteger("967238205517244884325670378207270928"), new BigInteger("7556548480778860582024684714262208") 
				
		};
		
		// step 1: generate the permutation out of given knapsack values
		int length = knapsack.length;
		BigInteger Winverse = W.modInverse(M);
		BigInteger permutation[] = new BigInteger[47];
		for (int i = 0; i < length; i++)
		{
			permutation[i] = (knapsack[i].multiply(Winverse)).mod(M);
		
		
		System.out.println(permutation[i]);
		}
		
		// store the value as new key
		BigInteger[] newkey = new BigInteger[47];
		for (int i = 0; i < length; i++)
		{
			newkey[i] = permutation[i];
		}
		
		
		// apply knapsack algorithm
		BigInteger Temp;
		for (int i = 0; i < length - 1; i++)
		{
			for (int j = 0; j < length - 1; j++)
			{
				if (newkey[j].compareTo(newkey[j + 1]) == 1)
				{
					Temp = newkey[j];
					newkey[j] = newkey[j + 1];
					newkey[j + 1] = Temp;
				}
			}
		}
		
		
		// compare the permutation with the new key
		int NewPermutation[] = new int[47];
		for (int i = 0; i < length; i++)
		{
			for (int j = 0; j < length; j++)
			{
				if (permutation[i].compareTo(newkey[j]) == 0)
				{
					NewPermutation[i] = j;
					break;
				}
			}
		}
		
		
		
	
		String FinalPlainText = "";
		
	
	 String fileName = "ciphertext.txt";

	        // This will reference one line at a time
	        String line = null;

	      try {
	            // FileReader reads text files in the default encoding.
	            FileReader fileReader = 
	                new FileReader("C:\\Users\\ritu\\Desktop\\ciphertext.txt");

	            // wrap FileReader in BufferedReader.
	            BufferedReader bufferedReader = 
	                new BufferedReader(fileReader);
	        //    PrintStream out = new PrintStream(new FileOutputStream("plaintext.txt"));
	            PrintStream finalans = new PrintStream(new FileOutputStream("decoded.txt"));

	            while((line = bufferedReader.readLine()) != null) {
	             
	                //--->code goes here
	                BigInteger CipherText = new BigInteger (line);
	    			BigInteger midResult = (Winverse.multiply(CipherText)).mod(M);
	    			
	    			
	    			int TempArray[] = new int[47];
	    			for (int i = length - 1; i >= 0; i--)
	    			{
	    				if (midResult.compareTo(newkey[i]) >= 0)
	    				{
	    					TempArray[i] = 1;
	    					midResult = midResult.subtract(newkey[i]);
	    				}
	    				else
	    				{
	    					TempArray[i] = 0;
	    				}
	    			}
	    			
	    			
	    			
	    			int newArray[] = new int[47];
	    			for (int i = 0; i < length; i++)
	    			{
	    				int k = NewPermutation[i];
	    				newArray[i] = TempArray[k];
	    			}
	    			
	    			String PlainText = "";
	    			for (int i = 0; i < length; i++)
	    			{
	    				PlainText = PlainText + newArray[i];
	    			}
	    			
	    		//	BufferedWriter writer = null;	
	    			
	    			BigInteger cipherTextOld = new BigInteger(PlainText, 2);
	    			String StringCipher = cipherTextOld.toString();
	    			int columnValue[] = new int[64];
	    			int rowValue[] = new int[64];
	    			
	    			
	    			while (StringCipher.length() != 14)
	    				{
	    				StringCipher = 0 + StringCipher;
	    			}
	    			
	    			// get the row value from the matrix
	    			for (int i = 0; i < StringCipher.length(); i = i + 2)
	    			{
	    				rowValue[i] = Integer.parseInt(Character.toString(StringCipher.charAt(i)));
	    			}
	    			
	    			//get the column value from the matrix
	    			for (int j = 0; j < StringCipher.length(); j = j + 2)
	    				{
	    				columnValue[j] = Integer.parseInt(Character.toString(StringCipher.charAt(j + 1)));
	    			}
	    			
	    			// store the final result obtained from the matrix in finalplain text
	    			for (int i = 0; i < StringCipher.length(); i = i + 2)
	    				{
	    				FinalPlainText = FinalPlainText + Matrix[Character.getNumericValue(StringCipher.charAt(i))][Character.getNumericValue(StringCipher.charAt(i + 1))];;
	    			}
	    			
	    			//finalans.write(MatrixrowValue[i]columnValue[j]);
	    		//	finalans.write(FinalPlainText);
	            }
	    		
	            // display the plain text in console
	    		System.out.println("Your Plain Text : " + FinalPlainText);
	    		
	             
	            
	         //close files.
	            bufferedReader.close();         
	        }
	        
	        catch(FileNotFoundException ex) {
	            System.out.println(
	                "Unable to open file '" + 
	                fileName + "'");                
	        }
	        
	        catch(IOException ex) {
	            System.out.println(
	                "Error reading file '" 
	                + fileName + "'");                  
	            
	        }
		
		
	}// end main
}// end class
