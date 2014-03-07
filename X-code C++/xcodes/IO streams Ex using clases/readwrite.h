/*
 *  readwrite.h
 *  streams
 *
 *  Created by Gerson Lobos on 11/16/11.
 *  Copyright 2011 westchester comunity college. All rights reserved.
 *
 */

#include <iostream>
#include <fstream>
#include <cstdlib>
#include <string>
using namespace std;

class readwrite {
public:
	readwrite(void);	// constructor
	void read(void);	// read from in.0
	void print(void);	// write to out.0
	void printToTXT(void);
	void reverse_print(void);	// write to out.0 in reverse order
	
	
private:
	int n;				// number of grades
	int A[1000];		// array to hold the grades
};

/************************************************************************
 The format of the file called in.0 is as follows:
 
 n
 grade_1
 grade_2
 ...
 grade_n
 
 where n (between 0 and 999 inclusive) is an integer representing the number of 
 grades in in.0 file. Each grade is between 0 and 100, inclusive. 
 THERE WILL NOT BE ERROR CHECKING REQUIRED.
 ************************************************************************/

/************************************************************************
 The definition of READ is as follows:
 
 READ();
 
 reads the n integers from in.0 file and stores them into A array. After this,
 READ interface generates the following message into out.0 file:
 
 n GRADES ARE READ.
 
 where n is the total number of grades in in.0 file.
 MAKE SURE THAT EVERY LINE ENDS WITH A endl.
 ************************************************************************/

/************************************************************************
 The definition of PRINT is as follows:
 
 PRINT();
 
 which prints the grades into out.0 file as follows:
 
 n GRADES ARE:
 grade_1
 grade_2
 ...
 grade_n
 
 where the order of the grades are the same as in in.0 file.
 MAKE SURE THAT EVERY LINE ENDS WITH A endl.
 ************************************************************************/

/************************************************************************
 The definition of REVERSE_PRINT is as follows:
 
 REVERSE_PRINT();
 
 which prints the grades into out.0 file as follows:
 
 n GRADES ARE:
 grade_n
 ...
 grade_2
 grade_1
 
 where the order of the grades in.0 file is reversed.
 MAKE SURE THAT EVERY LINE ENDS WITH A endl.
 ************************************************************************/