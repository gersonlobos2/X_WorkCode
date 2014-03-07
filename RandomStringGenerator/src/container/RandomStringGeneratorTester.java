package container;
import org.apache.commons.cli.*;


public class RandomStringGeneratorTester extends RandomStringGenerator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Options options = new Options();
		options.addOption("i",true,"<positive integer>");
		options.addOption("s",true,"<String>");
		
		CommandLineParser parser =  new BasicParser();
		String one = args[1];
		RandomStringGenerator Generator = new RandomStringGenerator();
		
		try {
			CommandLine cmd = parser.parse(options, args);
			if(cmd.hasOption("i")){
				
				
				Generator.addRange('0', '9');
				 System.out.println("Processing input");
				System.out.println(one+":");
				Generator.nextString(Integer.parseInt(one));
			}
			else if(cmd.hasOption("s")){
				
			    Generator = new RandomStringGenerator();
			   
			    Generator.addRange('a', 'z');
				Generator.addRange('A', 'Z');
				Generator.addRange('0', '9');
				 System.out.println("Processing input");
				System.out.print(one+":");
				Generator.nextString(one);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Parsing failed. Reason: "+e.getMessage());
		}

		
		
		
		
		

	}//end main

}//end class
