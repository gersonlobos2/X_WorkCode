#include <iostream>
#include "readwrite.h"

int main () 
{
	
	readwrite c; // instantiate an object c which is of class readwrite
	
	//c.read(); // read the grades from in.0
	c.printToTXT(); // print the grades into out.0
	c.read();
	c.print();//prints to out.0
	//c.reverse_print();
	cout << "it printed"<<endl;
	
    cin.ignore().get();
	return EXIT_SUCCESS;
}
