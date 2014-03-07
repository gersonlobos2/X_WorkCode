/*
 *  readwrite.cpp
 *  streams
 *
 *  Created by Gerson Lobos on 11/16/11.
 *  Copyright 2011 westchester comunity college. All rights reserved.
 *
 */

#include "readwrite.h"
using namespace std;


readwrite::readwrite(void)
{
	// Nothing to be done here
}

void readwrite::read(void)// read from in.0
{
	ifstream inFile;
	inFile.open("in.txt");//opens the file to read from it.
	
	int nums;
	int counter=0;
	
	while(!inFile.eof()){
	inFile >> nums;
	A[counter]=nums; 
	
		counter++;
	}
	
	n=counter-1; //minus one because one more counter was increased at end.

	inFile.close();
	
	// writing into out.0 saying the number of grades read
	ofstream outFile;
	outFile.open( "out.txt");
	
		
		outFile << n <<" GRADES ARE READ."<<endl;
		
	outFile.close();
	

}
void readwrite::print(void)// write to out.0
{
	ifstream inFile;
	string line;
	inFile.open("out.txt");//opens the file to read from it.
	
	getline(inFile,line); //it gets the line that was already stored in the file.
	inFile.close();
	
	
	
	ofstream outFile;
	outFile.open("out.txt");
	
	outFile << line << endl;
	
	for (int i=0; i<n; ++i) {
		outFile << A[i]<<endl;
	}
}

void readwrite::reverse_print(void)	// write to out.0 in reverse order
{
	ofstream outFile;
	outFile.open("out.txt");
	outFile<<n<< " grades are:"<<endl;
	
	for (int i=n-1; i>=0; i--) {
		outFile<<A[i]<<endl;
	}
	outFile.close();

}
//========================================
void readwrite::printToTXT(void)	
{
	ofstream outFile;
	outFile.open( "in.txt");
		
		outFile << 4<< endl;
		outFile << 90<< endl;
		outFile << 0<< endl;
		outFile << 40<< endl;
		outFile << 60 << endl;
		
	
	outFile.close();
	
}
//=========================================

// Implement the rest of the function