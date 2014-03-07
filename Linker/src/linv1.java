
/*
 * Gerson Enrique lobos Aguilar
 * 
 */
import java.io.*;
import java.lang.*;
import java.lang.String.*;
import java.nio.charset.Charset;

public class linv1
{
public static void main(String[] args) throws IOException
{
	//	This is the required greeting for linv1 and displaying of the greeting
	String greeting = "linv1.java written by Gerson Enrique Lobos Aguilar";
	System.out.println(greeting);
/*
*******************
******************* DOIFILE - Determines if extension is available
*******************
*/
class changeExtension
{
	String name;	// name of file within the method
	String ext;    	// extension you want to change to within the method
	public String changeExtension(String originalName, String newExtension)
	{
 	name = originalName;	// received String set to name
 	ext = newExtension;	// received String set to extension
 	int lastDot = name.lastIndexOf(".");	// searches to find out if their is a period, indicating an extension exists
 	int lastSlash = name.indexOf('\\', lastDot);
   
 	if(lastSlash != -1)
 	{
     	return name + ext;
 	}  	 
 	else if (lastDot != -1)	// if there is a period (has an extension) the method returns the existing name
 	{
     	return name;
 	}
 	else  // if there is no period (has no extension) the method returns the existing name with the new extension
 	{
     	return name + ext;
 	}
	}
}
class endian
{
public short reverseOrder(short x)
{
	int y = ((int) x) & 0xffff;
	return (short) (256 * (y%256) + y/256);
}
}
	final endian revOrd = new endian();
	int whichS = 0;
/*
*******************
******************* /DOIFILE
*******************
*/
/*
*******************
******************* TABLES - Creates the Tables
*******************
*/
class T
{
private final int mainMemorySize = 4096;	// amount of memory available
private short[] buffer = new short[4096];	// creating an array for addresses for the Text Buffer
private int index;                    	// increments through the array
public T()
{
}
public void enter(short x)	// enters a short (address) into Text Buffer
{
	if (index >= mainMemorySize)
	{
	System.out.println("ERROR: Linked program too big");
	System.out.println("-----");
	System.exit(0);
	}
	else
	{
	buffer[index] = x;    	// received short is added to the array buffer at location index
	//System.out.println("This is what goes in Text Buffer " + buffer[index]);	// this was added for debugging to make sure the Text Buffer received short properly
	index++;	// increment index, so when enter method of t class is run, the next short goes to next location in array
}
}
public void relocate(int address , int change )	// relocates an address in the Text Buffer to match the newly relocated variable.
{
	buffer[change] = (short)address;
}
public void write(DataOutputStream s) throws IOException	// outputs the Text Buffer into the final file
{
	s.writeByte('T');
	//System.out.println("T");
	for(int y = 0; y < index; y++)
	{
 	{
     	s.writeShort(revOrd.reverseOrder(buffer[y]));
     	//System.out.println(buffer[y]);in
 	 
	}
}
}
public short getAddress(int i)
{
	return buffer[i];
}
}

class P
{
private String[] symbol = new String[6];	// creating an array for symbols (variables) for the P Table
private short[] address = new short[6];	// creating an array for addresses for the P Table
private int index = 0;                	// increments through the arrays
private static final int maxSize = 5;    	// max amount of symbols for the P Table
	public P()
	{
	}
	public int search(String s)    	// searches the table for entered String for relocating purposes
	{
	for(int i = 0; i < 5; i++)	// finds symbol in table and returns its index i
	{
 	if ((s.equals(symbol[i])) == true)	// finds out if the entered String is available inside the array
 	{
     	return i;    	// returns the location of the variable that is being searched for
 	}
	}
	System.out.println("ERROR: Unresolved external symbol " + s);	// This error comes up when the variable being searched for isn't found
	System.out.println("-----");
	System.exit(0);                                    	// Terminates the program
	return 0;	// needed to end method, will never be accessed as program will be terminated prior
	}
	public void searchDup(String s)
	{
	for(int z = 0; z < index; z++)	// finds symbol in table and returns its index i
	{
 	if ((s.equals(symbol[z])) == true)	// finds out if the entered String is available inside the array
 	{
     	System.out.println("ERROR: Duplicate PUBLIC symbol " + s);
     	System.out.println("-----");
     	System.exit(0);
 	}
	}
	}
   
public short getAddress(int i)
{
	return address[i];
}
public String getSymbol(int i)
{
	return symbol[i];
}
public int size()
{
	return index;
}
public void enter(short add, String sym)
{
	searchDup(sym);
	symbol[index] = sym;
	address[index] = add;
	//System.out.println("This is what goes in P Table " + address[index] + " and " + symbol[index]);
	if(index == maxSize)
	{
	System.out.println("ERROR: P table overflow");
	System.out.println("-----");
	System.exit(0);
	}
	index++;
	return;
}

public void write (DataOutputStream s) throws IOException
{
	for(int y = 0; y < index; y++)
	{
 	//if(address[y] < index)
 	{
     	s.writeByte('P');
     	//System.out.print("P ");
     	s.writeShort(revOrd.reverseOrder(address[y]));
     	//System.out.print(address[y] + " ");
     	//byte[] stringToByte = symbol[y].getBytes();
     	s.writeBytes(symbol[y]);
     	/*for(int sTB = 0; sTB < (stringToByte.length); sTB++)
     	{
         	s.writeByte(stringToByte[sTB]);
         	//System.out.println(stringToByte[sTB]);
     	}
     	*/
 	}
	}
}
}
class E
{
	private String[] symbol = new String[6];
private short[] address = new short[6];
private int index = 0;
private static final int maxSize = 5;
	public E()
	{
	}
	public void enter(short add, String sym)
{
	symbol[index] = sym;
	address[index] = add;
	//System.out.println("This is what goes in E Table " + address[index] + " and " + symbol[index]);
	if(index == maxSize)
	{
	System.out.println("ERROR: E table overflow");
	System.out.println("-----");
	System.exit(0);
	}
	index++;
	return;
	}
public short getAddress(int i)
{
	return address[i];
}
public String getSymbol(int i)
{
	return symbol[i];
}
	public void write (DataOutputStream s) throws IOException
	{
 	for(int y = 0; y < index; y++)
	{
 	if(address[y] >= 0)
 	{
     	s.writeByte('R');
     	//System.out.print("R ");
     	s.writeShort(revOrd.reverseOrder(address[y]));
     	//System.out.println(address[y]);
    	}
	}
	}

}

class R
{
private short[] address = new short[6];
private int index = 0;
private short[] module_address = new short[6];
private static final int maxSize = 5;
	public R()
	{
	}
	public void enter(short add, short mod_add)
{
	address[index] = add;
	module_address[index] = mod_add;
	//System.out.println("This is what goes in R Table " + address[index] + " and " + module_address[index]);
	if(index == maxSize)
	{
	System.out.println("ERROR: R table overflow");
	System.out.println("-----");
	System.exit(0);
	}
	index++;
	return;
	}
	public short getAddress(short i)
{
	return address[i];
}
	public short getModule(short i)
	{
	return module_address[i];
	}
	public void write (DataOutputStream s) throws IOException
	{   	 
 	for(int y = 0; y < index; y++)
	{
 	if(address[y] >= 0)
 	{
     	s.writeByte('R');
     	//System.out.print("R ");
     	s.writeShort(revOrd.reverseOrder(address[y]));
     	//System.out.println(address[y]);
    	}
	}
	}

	}

class S
{
private short[] address = new short[2];
private int index = 0;
private static final int maxSize = 1;
	public S()
	{
	}
	public void enter(short add)
	{
	address[index] = add;
	//System.out.println("This is what goes in S Table " + address[index]);
	index++;
	return;
	}
	public short getAddress(int i)
{
	index = i;
	return address[index];
}
	public void write (DataOutputStream s) throws IOException
	{
 	s.writeByte('S');
 	//System.out.print("S ");
 	s.writeShort(revOrd.reverseOrder(address[0]));
 	//System.out.println(address[0]);
	}

	}
    
class littleS
{
private short[] address = new short[2];
private int index = 0;
private static final int maxSize = 1;
	public littleS()
	{
	}
	public void enter(short add)
	{
	address[index] = add;
	//System.out.println("This is what goes in S Table " + address[index]);
	index++;
	return;
	}
	public short getAddress(int i)
{
	index = i;
	return address[index];
}
	public void write (DataOutputStream s) throws IOException
	{
 	s.writeByte('s');
 	//System.out.print("S ");
 	s.writeShort(revOrd.reverseOrder(address[0]));
 	//System.out.println(address[0]);
	}

}
    
/*
*******************
******************* /TABLES
*******************
*/
/* *****************************************************************************************
****************************--------DOIFILE--MAIN----------********************************
******************************************************************************************
******************************************************************************************/
int startValue = 0; //For checking S/s table for multiple s values
P pTable = new P();
E eTable = new E();
R rTable = new R();
S sTable = new S();
T tTable = new T();
littleS littlesTable = new littleS();

short[] fileLength = new short[args.length];
short relocAdd = 0;
if(args.length == 0)
{
System.out.println("ERROR: Incorrect number of command line arguments");
System.out.println("-----");
System.exit(0);
}
for(int i = 0; i < args.length; i++)
{
	if(i > 0)
	{
	relocAdd = fileLength[i-1];
	}
	String fileName = " ";
	try
	{
 	fileName = args[i];
	}

	// Print out the exception that occurred and end program
	catch (ArrayIndexOutOfBoundsException e)
	{
 	System.out.println("Incorrect number of command-line arguments. " +e.getMessage());
 	System.exit(0);
	}
   
	String targetExtension = ".mob";
	changeExtension chanExt = new changeExtension();
	fileName = chanExt.changeExtension(fileName, targetExtension);
	//System.out.println(fileName);

/******************************************************************************************
****************************--------DOIFILE--/MAIN----------********************************
******************************************************************************************
******************************************************************************************/
	DataInputStream inStream = null;
	try
	{
	inStream = new DataInputStream(new FileInputStream(fileName));
	}
	catch (FileNotFoundException f)
	{
    	System.err.println("ERROR: Cannot open input file " + fileName);
    	System.out.println("-----");
    	System.exit(0);
	}
   
	byte b;
	short x;

	while(inStream.available() > 0)
	{
 	b = inStream.readByte();
 	if(b != 84 & b != 83 & b != 115 & b != 80 & b != 82 & b != 69)
 	{
      	System.out.println("ERROR: Input file " + fileName + " is not linkable");
     	System.out.println("-----");
     	System.exit(0);
 	}
    
 	if (b == 84) // Text Buffer
     	{
        	//System.out.println("This is Text Buffer");
        	while(inStream.available() > 0)
        	{
          	x = inStream.readShort();
          	x = revOrd.reverseOrder(x);
          	tTable.enter(x);
          	fileLength[i]++;
        	}
      	}

 	else if (b == 83) // S Table
     	{
         	//System.out.println("This is S table");
         	x = inStream.readShort();
         	x = revOrd.reverseOrder(x);
         	if(startValue != 1)
         	{
             	sTable.enter(x);
             	startValue++;
         	}
         	else
         	{
             	System.out.println("ERROR: More than one starting address");
             	System.out.println("-----");
             	System.exit(0);
         	}
     	}
   	 
 	else if (b == 115) // s Table
    	{
        	x = inStream.readShort();
        	x = revOrd.reverseOrder(x);
        	x = (short)(x + relocAdd);
        	whichS = 1;
        	if(startValue != 1)
        	{
            	littlesTable.enter(x);
            	startValue++;
        	}
      	 
        	else
        	{
            	System.out.println("ERROR: More than one starting address");
            	System.out.println("-----");
            	System.exit(0);
        	}
    	}
 	else if (b == 82) // R Table
 	{
     	//System.out.println("This is R table");
     	x = inStream.readShort();
     	x = revOrd.reverseOrder(x);
     	x = (short)(x + relocAdd);
     	rTable.enter(x, relocAdd);
  	}
 	else if (b == 80) // P Table
 	{
     	//System.out.println("This is P table");
     	x = inStream.readShort();
     	x = revOrd.reverseOrder(x);
     	x = (short)(x + relocAdd);
     	byte[] bP = new byte[10];
     	int loopP = 0;
     	b = inStream.readByte();
     	do
     	{
         	bP[loopP] = b;
         	loopP++;
     	}
     	while((b = inStream.readByte()) != 0);
     	String strP = new String(bP, 0, (loopP + 1));
     	pTable.enter(x, strP);
 	}
 	else if (b == 69) // E Table
 	{
     	//System.out.println("This is E table");
     	x = inStream.readShort();
     	x = revOrd.reverseOrder(x);
     	x = (short)(x + relocAdd);
     	byte[] bE = new byte[10];
     	int loopE = 0;
     	b = inStream.readByte();
     	do
     	{
         	bE[loopE] = b;
         	loopE++;
     	}
     	while((b = inStream.readByte()) != 0);
     	String strE = new String(bE, 0, (loopE + 1));
     	eTable.enter(x, strE);
 	}
	}
   
}
String findVariable;
	for(int j = 0; j < 6; j++)
	{
	if((findVariable = eTable.getSymbol(j)) != null)
	{
   	int findVar = pTable.search(findVariable);
   	short pVarAdd = pTable.getAddress(findVar);
   	short eVarAdd = eTable.getAddress(j);
   	short tBufAdd = tTable.getAddress(eVarAdd);
   	int opCodeOnly = tBufAdd&0xF000;
   	int addOnly = (pVarAdd + tBufAdd)&0x0FFF;
   	int newAdd = (opCodeOnly + addOnly);
   	tTable.relocate(newAdd, eVarAdd);
   	//System.out.println("TextBuff Address : " + eVarAdd + " was changed to " + newAdd);
   	//output e as R
	}
	}
short rVarAdd;
	for(short k = 0; k < 6; k++)
	{
	if((rVarAdd = rTable.getAddress(k)) != 0)
	{
   	short tBufAdd = tTable.getAddress(rVarAdd);
   	tBufAdd = (short)(tBufAdd + rTable.getModule(k));
   	tTable.relocate(tBufAdd, rVarAdd);
	}
   
	}
	String outputName = args[0];
String targetExtension = ".mac";
changeExtension chanExt = new changeExtension();
outputName = chanExt.changeExtension(outputName, targetExtension);
//System.out.println(outputName);
File f;
f = new File(outputName);
DataOutputStream outStream = new DataOutputStream(new FileOutputStream(f));
pTable.write(outStream);
rTable.write(outStream);
eTable.write(outStream);
if (whichS == 0)
{
	sTable.write(outStream);
}
else
{
	littlesTable.write(outStream);
}
tTable.write(outStream);
outStream.close();
}
}


