/*
 * @Author: Nidhi Parmar
 * 
 */

package com.example;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadWriteLinkedProfile {
	public static void main(String[] args) {

		// The name of the file to open.
		
		
		//Step 1: Read the linked in profile
		String fileRead = "C:\\Users\\W550S\\Desktop\\nidprofile.html";
		
		//Step 2: Write the file to abc.html and exclude iframe and script tag
		String fileWrite = "abc.html";

		// This will reference one line at a time
		String line = null;

		try {
		
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fileRead);
			FileWriter fileWriter = new FileWriter(fileWrite);
			
			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
			
			
			// Step 3: Regular expresson to exclude tag
			
			Pattern p = Pattern.compile("(<iframe>|</iframe>|<script>|</script>)");
			StringBuffer result = new StringBuffer();
			
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
				Matcher m = p.matcher(line);
				while(m.find()) {
					System.out.println("Found : " + m.group());
					m.appendReplacement(result, " ");
					System.out.println("result -- " + result);
				}
				
				m.appendTail(result);
				// Step 4: Write the content to abc.html
				bufferWriter.write(result.toString());
				
			}

			// Always close files.
			bufferWriter.close();
			bufferedReader.close();
			
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileRead + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileRead + "'");
			// Or we could just do this:
			// ex.printStackTrace();
		}
	}

}


