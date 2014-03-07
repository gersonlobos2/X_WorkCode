
//  ****************************************************************************
//  Name: Gerson Lobos
//  Name: Professor Branca 
//  Date:
//  COMSC 110 Computer Programming II
//  Assignment #: 1
//  File Name: imp.h
//  Compiler Used: Xcode
//  ****************************************************************************

// Problem Statement ********************************************************** 
/* 
 1.	Design a class named Die. The class should only be used to create and manipulate 1 die.
	The properties of the die should include its number of sides, current face value 
    (after rolling) and a color.
 
 2.	In addition to the standard constructor, mutator and accessor functions for the 
 Die class, you should have the following:
 
		a.	Member function to simulate the rolling of one die using random # generation. 
		b.	Overloaded << operator that outputs current face value of one die. 
		c.	Overloaded + operator to add the values of all dice after rolling them. 
		d.	Non-member function(s) to generate random numbers for a collection (size of
			collection can vary) of dice to simulate dice rolling.
			Non-member functions that are not specifically related to dice should be stored
			in separate header and implementation files than the Die class.
 
 3.	Create the necessary header files, implementation files and program files. 
 See templates for format.
 
 4.	Write a program which simulates the creation of 6 dice and stores them in a 
 dynamic array or a vector. Ask the user how many sides and what color all 6 dice have. 
 Roll the dice and output the current values of the dice and the sum of the values 
 on all the dice. The number of sides on each die should come from the user, 
 and be no less than 6 or more than 10. The values on each side of the dice should fall
 in the range of the number of sides (e.g., if there are 6 sides than the face values 
 should be in the range of 1-6). The color choices are limited to red, yellow and blue.
 


// Data Requirements ********************************************************** 

	Input		dsides				int			users input to the sides of the dice
				dcolor				string		users input to the color of the dice
				rolls				int			users input to the amount of times the dice was rolled
				total				int			the sum of all the dices' roll results.
				faceValue			int			random number generated from the times the user wants 
												to roll the dice.
				vector<Die*>vec		Die			the vector were all the dice are stored.
	
	Processing
 
	Formulas    1+rand()%(max-min+1)
 
	Libreries	ctime	vector	iostream	fstream	cstdlib	string

// Algorithm Design *********************************************************** 
																	Function
	
 1.Display program description										programDescription();
 2.Promp the user for the color and sides of the dice
   read and validate them with the program specifications.
 3.Generate and create a vector of objects Dice.					
   store them. Each with its descriptions. 
   and a random number definig the face value.
                                  vec.push_back (new Die(dsides,dcolor,1+rand()%(dsides-1+1)));
 
 4.add all the face values from the dice and add them all total += vec[u]->getfaceValue()
 

// Testing Specifications ***************************************************** 
 
test the string for the color of the dice
 test for the size of the die
 test for the times you roll the dice


// Compiler directives : libraries and namespaces *****************************
*/
#include <iostream>
#include <string>
#include "imp.h"
#include <ctime>
#include <cstdlib>
#include <vector>
#include <fstream>

using namespace std;
using namespace dieclass;
int main()
{
	srand(time(0));
	int dsides;
	//int dfaceValue=1+rand()%(dsides-1+1);
	string dcolor;
	int rolls;
	int total;
	int selc; // this is going to be used to chose the color between red, blue,yellow
	vector <Die*> vec;
	//vector <Die> vec;
	Die dado;
	Die dedo;//object
	
	dado.programDescription();
	do
	{
		cout << "what color do you want the Dices to be:"<<endl;
		cout << "1. red" <<endl;
		cout << "2. blue" <<endl;
		cout << "3. yellow"<<endl ;
		cout << "Enter the number of color you want:"<<endl;
		cin >> selc;
		
		switch (selc) {
			case 1: {
				dcolor="red";
				break;
			}
			case 2: {
				dcolor="blue";
				break;
			}
			case 3: {
				dcolor="yellow";
				break;
			}
			default:{
				selc= -1;
				//cout<<"*******Invalid selection, please try again.*******"<<endl;
				break;
			}
		}
	}while(selc == -1);
	
	
	//puting the number of sides in the dies 
	while (6>dsides||10<dsides) {
		cout <<"how many sides do you want in the dice between 6-10: "<<endl;
		cin >>dsides;
	}
	

	
	dado.setcolor(dcolor);
	dado.setfaceValue(dsides);
	dado.setsides(dsides);
	
	cout<<"die color = "<<dado.getcolor()<<endl;
	cout<<"die facevalue = "<<dado.getfaceValue()<<endl;
	cout<<"die sides = "<<dado.getsides()<<endl;
	
	//making the dies roll less than 10
	do  {
		cout << "how many times do you want to roll the Dices has to be less than 5: ";
		cin >> rolls;
	}while(rolls > 5);
	
	//****************   creating a vector with dies on it.
	for (int i=0; i<rolls; i++) 
	{
		vec.push_back (new Die(dsides,dcolor));
		//vec.push_back (new Die(dsides,dcolor,1+rand()%(dsides-1+1)));
	}
	
	
	//**************** adding every value that was rolled in the die
	for (int u=0; u<rolls; u++) 
	{
		//total += (*vec[u]);
		//sorry i couldnt figure it out how to pass the object.
		total += vec[u]->getfaceValue();
	}
	cout << "the total of all the dice rolls is:"<<total<<endl;
	
	//**************** using the overloading operator " + "
	int temp = 0;

	temp = vec[0]->getfaceValue() + vec[1]->getfaceValue();
	//temp= *vec[1] + *vec[2];
	temp= dado+dedo;
	//cout << "die1= "<<vec[0]->getfaceValue()<<" + "<<"die2= "<<vec[1]->getfaceValue();
	cout << " id equals to="<<temp<<endl;
	
	
	//***************** using operator " << " and showing the value
	cout << "the value of the dies are: "<<endl;
	for (int x=0; x<rolls; ++x) {
		cout << *vec[x];
	}

	
	
	
	cout << "please press enter one or twitce to continue...";
	
	cin.ignore().get();
	return EXIT_SUCCESS;
}
