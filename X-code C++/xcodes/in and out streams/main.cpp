/*
  Gerson Lobos
  Data Structures
  FILES:  main.cpp 
  Compiler: Xcode
 
 Note:
 the file created by this program is under the folder build/debug.
 
 Description:
 This program creates a file with a 1000 random numbers and stores them
 in a file called file.txt that is under build/debug. and then it reads 
 from the file all the numbers.
 */

#include <iostream>
#include <fstream>
#include <ctime>
#include <stdlib.h>
using namespace std;
int main () 
{
	srand(time(0));
	
	ofstream OutToFile; // takes data to the txt file
	OutToFile.open("file1.txt"); //creates or opens the file
	
	for (int i=0; i<1000; ++i) {
		OutToFile<< 1000 + rand()%(2000-1000) <<"\n";
	}
	
	OutToFile.close();
	
	ifstream InFromFile;
	
	InFromFile.open( "file1.txt");//opens the file to read from it.
	int nums;
	
	for (int i=0; i<1000/20; ++i)
	{
		for (int x=0; x<20; ++x) {
			InFromFile>>nums;
			cout<< nums <<" ";
		}
		cout<<endl;
	}
	InFromFile.close();
	
	cin.ignore().get();
    return EXIT_SUCCESS;
}
