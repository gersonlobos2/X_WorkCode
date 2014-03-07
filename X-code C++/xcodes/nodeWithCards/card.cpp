//**************************************************************************
// Professor Branca
// Data Structures
// October 7, 2010
// Card Class Implementation
// FILE:   card.cpp
// Class:  Card
//**************************************************************************

//**************************************************************************
// PREPROCESSOR
//**************************************************************************
#include <iostream>               // provides I/O
#include <iomanip>			    // provides output manipulation
#include <string>			    // provides string manipulation
#include "card.h"                 // provides card class
#include <fstream>
#include <iomanip>
//#include "node.h"


using namespace std;              // uses standard namespace items

//**************************************************************************
// MEMBER FUNCTION IMPLEMENTATIONS
//**************************************************************************
//DEFAULT CONSTRUCTOR
/*Card::Card()
{
	rank=1;
	suit=1;
	picked=false;
	setCard(rank, suit, picked);

}*/
//**************************************************************************
// CONSTRUCTOR
//**************************************************************************
Card::Card(int r, int s, bool p)
{
    setCard(r, s, p);           // sets rank, suit and picked
}

//**************************************************************************
// DESTRUCTOR
//**************************************************************************
Card::~Card()
{
}

//**************************************************************************
// MODIFICATION MEMBER FUNCTIONS
//**************************************************************************
void Card::setCard(int r, int s, bool p)
{
    setRank(r);                   // sets rank
    setSuit(s);                   // sets suit
    setPicked(p);                 // sets pciked
}

//**************************************************************************
void Card::setRank(int r)
{
    rank = ( (r >= 1) && (r <= 13) ? r : 1);   // validate rank value
}

//**************************************************************************
void Card::setSuit(int s)
{
    suit = ( (s >= 1) && (s <= 4) ? s : 1);    // validate suit value
}

//**************************************************************************
void Card::setPicked(bool p)
{
   picked = ( (p == false) || (p == true) ? p : false);  // set picked value
	//picked =true;
}

//**************************************************************************
// CONSTANT MEMBER FUNCTIONS
//**************************************************************************
int Card::getRank(void) const
{
    return rank;                  // return rank
}

//**************************************************************************
int Card::getSuit(void) const
{
    return suit;                  // return suit
}

//**************************************************************************
bool Card::getPicked(void) const
{
    return picked;                  // return picked
}

//**************************************************************************
void Card::printCard() const
{
    printRank();                  // print rank
    printSuit();                  // print suit
    printPicked();                // print picked
}

//**************************************************************************
void Card::printRank() const
{
    string str;
	
    // print rank
    switch (rank)
    {
		case 1    :    cout << setw(7) << "Rank:" << setw(9) << "Ace";
			break;
		case 2    :
		case 3    :
		case 4    :
		case 5    :
		case 6    :
		case 7    :
		case 8    :
		case 9    :
		case 10   :    cout << setw(7) << "Rank:" << setw(9) << rank;
			break;
		case 11   :    cout << setw(7) << "Rank:" << setw(9) << "Jack";
			break;
		case 12   :    cout << setw(7) << "Rank:" << setw(9) << "Queen";
			break;
		case 13   :    cout << setw(7) << "Rank:" << setw(9) << "King";
			break;
		default   :    cout << "Error!";
    }
}

//**************************************************************************
void Card::printSuit() const
{
    string str;
	
    switch (suit)
    {
		case 1    :    str = "Hearts";
			break;
		case 2    :    str = "Diamonds";
			break;
		case 3    :    str = "Spades";
			break;
		case 4    :    str = "Clubs";
			break;
		default   :    str = "Error!";
    }
	
    cout << setw(11) << "Suit:" << setw(10 ) << str;       // print suit
}

//**************************************************************************
void Card::printPicked() const
{
    string str;
	
    switch (picked)
    {
		case false      :    str = "False";
			break;
		case true       :    str = "True";
			break;
		default         :    str = "Error!";
    }
	
    cout << setw(13) << "Picked:" << setw(7) << str;       // print picked
}

//**************************************************************************


//**************************************************************************
// NON-MEMBER FUNCTION IMPLEMENTATIONS
//**************************************************************************

//**************************************************************************
// This function creates a deck of cards stored in an array
//**************************************************************************
void createDeck(Card  d [])
//void createDeck(Node * p)
{
	int count = 0;                    // for counting cards in deck
	
	for (int i = 1; i <= 4; i++)
	{
		for (int x = 1; x <= 13; x++, count++)
		{
			d[count].setCard(x, i);
			
			
		}
	}
}

//**************************************************************************
// This function creates an array of randomly selected cards from a deck
//**************************************************************************
void generateCards ( Card d [], Card * c, const int n)
{
	int deckCard;
	
	for (int i = 0; i < n; i++)
	{
		deckCard = rand() % DECKSIZE;
		while ( d[deckCard].getPicked() )
		{
			deckCard = rand() % DECKSIZE;
		}
		d[deckCard].setPicked(true);;
		c[i] = d[deckCard];
	}
}    // end generateCards()

//**************************************************************************
// This function prints an array of cards
//**************************************************************************
void printCardArray(const Card * c, const int n)
{
	for (int i = 0; i < n; i++)
	{
     	c[i].printCard();
		cout << endl;
	}
}    // end printCardArray
//**************************************************************************
// This function overloads the out and displays the lincked list
//**************************************************************************
ostream& operator <<(ostream& out,Card g)//$
{
	
	out<<"the rank is:"<<g.getRank()<<setw(10)<<g.getSuit()<<setw(10)<<g.getPicked()<<endl;
	return out;

}

//**************************************************************************
// This function this function checks if two objects are equal
//**************************************************************************
bool operator ==(const Card C1,const Card C2)
{
	return (C1.getRank()==C2.getRank()) && (C1.getSuit()==C2.getSuit()&& (C1.getPicked()==C2.getPicked() ));

}
//**************************************************************************
// This function makes one card equals to the othes passed
//**************************************************************************
void Card::operator =(Card x)
{
	int r,s;
	bool p;
	r = x.getRank();
	s = x.getSuit();
	p = x.getPicked();
	this->setRank(r);
	this->setSuit(s);
	this->setPicked(p);

}
//**************************************************************************
// This function this function checks if two objects are equal
//**************************************************************************
bool Card::operator ==(Card w)
{
	if (this->getRank()==w.getRank()&&this->getSuit()==w.getSuit()) {
		return true;
	}
	else {
		return false;
	}


}
//**************************************************************************
