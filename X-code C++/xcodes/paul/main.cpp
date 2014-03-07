/*  ****************************************************************************
 Name:Paul Velasco
 Date:9/20/2010
 Data Structures
 Assignment #:Review Lab 
 File Name:Review Lab 
 Compiler Used:Dev C++
 ****************************************************************************
 
 Problem Statement **********************************************************
 Write a program which simulates the creation of 6 dice and stores them in a 
 dynamic array or a vector. Ask the user how many sides and what color all 6 
 dice have. Roll the dice and output the current values of the dice and the 
 sum of the values on all the dice. The number of sides on each die should 
 come from the user, and be no less than 6 or more than 10. The values on 
 each side of the dice should fall in the range of the number of sides
 (e.g., if there are 6 sides than the face values should be in the range of 
 1-6). The color choices are limited to red, yellow and blue.
 
 Data Requirements **********************************************************
 
 // Enter the data variables and formulas required for the problem
 // Indicate names, datatypes and initial values
 
 //      Input
 //      Output
 //      Processing
 //      Formulas
 
 
 //  Algorithm Design ***********************************************************
 
 // Enter the algorithm in step-by-step outline format
 // For example:
 
 //	1. Prompt and read data
 //		1.1 Prompt user to enter data
 //		1.2 Read data from keyboard
 
 
 //  Testing Specifications *****************************************************
 
 // Specify tests needed to verify that program works correctly
 
 
 
 
 */

#include <iostream>
#include <cstdlib>
#include "Imp.h"
#include <string>
#include <vector>
using namespace std;


//  Function Prototypes ********************************************************


//  main function 

int main ()
{   
    srand(time(0));
	int total;
	char selection;
	string colors;
	int sidesD;
	vector<Die*> bag;
	int rolles;
	
	
	
	//int *arrayM;
	while ((sidesD<6)||(sidesD>10)) {
		cout << "enter the number of sides you want in the die"<<endl;
		cin>>sidesD;
	}
	//halgo en el loop esta malo
	//0000000000000000000000000000000000000000000000
     do
	{
	cout << "select between the colors for the dice: "<<endl;
	cout << "#1 for blue"<<endl;
	cout << "#2 for yellow"<<endl;
	cout << "#3 for red"<<endl;
		cin>>selection;
		
	switch (selection) 
		{
		case '1': colors="blue";
			break;
		case '2': colors="yellow";
			break;
		case '3': colors="red";
			break;
				
			default: return 4; //cout<<"incorrect input";
			break;
	}
		
	}while(selection<=3);
	//0000000000000000000000000000000000000000000000
	
	cout << "how many times do you want to roll the dice: "<<endl;
	cin>>rolles;
	for (int x=0; x<rolles; ++x) 
	{
		bag.push_back(new Die(sidesD,colors));
	}
	
	
	for (int p=0; p<rolles; p++) {
		total += bag[p]->getfacevalue();
	}
	cout << "the sum of all dice is: "<<total<<endl;
	
	for (int c=0; c<rolles; ++c) {
		cout << *(bag[c]);
	}
	
	
	
	
	
	
	
	
	system("pause");
	return 0;           	// successful termination
    
}
