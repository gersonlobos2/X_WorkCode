//**************************************************************************
// Professor Branca
// Data Structures
// October 7, 2010
// Card Class Definition
// FILE:   card.h
// Class:  Card
//**************************************************************************

//**************************************************************************
// CONSTRUCTOR
//**************************************************************************
// Card(int r=1, int s=1)
// Constructor with defaults
// Precondition:     r >= 1 && <= 13, s <= 1 && s <= 4
// Postcondition:    The Card object has valid rank and suit values
// Calls setCard()

//**************************************************************************
// DESTRUCTOR
//**************************************************************************
// ~Card()

//**************************************************************************
// MUTATOR MEMBER FUNCTIONS
//**************************************************************************
// void setCard(int r=1, int s=1)
// Precondition:     r >= 1 && <= 13, s <= 1 && s <= 4
// Postcondition:    The Card object has valid rank and suit values
// Calls setRank() and setSuit() and setPicked()
// =========================================================================
// void setRank(int r=1)
// Precondition:     r >= 1 && <= 13
// Postcondition:    The Card object has a valid rank value
// Verifies and initializes rank
// =========================================================================
// void setSuit(int r=1)
// Precondition:     s <= 1 && s <= 4
// Postcondition:    The Card object has a valid suit value
// Verifies and initialize suit
// =========================================================================
// void setPicked(bool p = false)
// Precondition:     p == true || p == false
// Postcondition:    The Card object has a valid picked value
// Verifies and initializes picked
// =========================================================================
//*******************************************************************
// ASSESSOR MEMBER FUNCTIONS*
// ******************************************************************
// int getRank(void) const
// Postcondition:    Value returned is the rank of the Card object
// Returns rank
// =========================================================================
// int getSuit(void) const
// Postcondition:    Value returned is the suit of the Card object
// Returns suit
// =========================================================================
// bool getPicked(void) const
// Postcondition:    Value returned is the picked value of the Card object
// Returns picked
// =========================================================================
// void printCard() const
// Postcondition:    Output of the rank and suit of the Card object
// Calls printRank() and printSuit() and printPicked()
// =========================================================================
// void printRank() const
// Postcondition:   rank of the Card object output
// Prints rank
// =========================================================================
// void printSuit() const
// Postcondition:   suit of the Card object output
// Prints suit
// =========================================================================
// void printPicked() const
// Postcondition:   picked value of the Card object output
// Prints picked
// =========================================================================

//**************************************************************************
// VALUE SEMANTICS: Use automatic copy constructor to copy one
//                  card to another card
//**************************************************************************
/*My Fucntions
 // =========================================================================
 void operator =(Card x);
 // Precondition: a card has to be set equal to another
 // Postcondition: it will set them both equal  
 // =========================================================================
 bool operator ==(Card w);
 // Postcondition: it will return a bool checking if they are equal or not
 // =========================================================================
 ostream& operator <<(ostream& out, const Card g);
 // Precondition: an object card has to be passed
 // Postcondition: it will display a card object;
 // =========================================================================
 bool operator ==(const Card p1,const Card p2);
 // Postcondition: it will return a bool checking if they are equal or not
 // =========================================================================
 
 ***************************************************************************
 */
#ifndef CARD_H
#define CARD_H
#include <fstream>
//#include "node.h"
using namespace std;

class Card
{
public:
	// CONSTRUCTOR
	//Card();
	Card(int r = 1, int s = 1, bool p = false);
	
	
	// DESTRUCTOR
	~Card();
	
	// MUTATOR MEMBER FUNCTIONS
	void setCard(int r = 1, int s = 1, bool p = false);
	void setRank(int r = 1);
	void setSuit(int r = 1);
	void setPicked(bool p =false);
	
	// ASSESSOR MEMBER FUNCTIONS
	int getRank(void) const;
	int getSuit(void) const;
	bool getPicked(void) const;
	void printCard() const;
	void printRank() const;
	void printSuit() const;
	void printPicked() const;
	
	void operator =(Card x);
	bool operator ==(Card w);
	
	
private:
	int rank;
	int suit;
	bool picked;
	
};

//**************************************************************************
// CONSTANT VAIRABLES
//**************************************************************************
const int DECKSIZE = 52;
//**************************************************************************

//**************************************************************************
// NON-MEMBER FUNCTION PROTOTYPES
//**************************************************************************
void createDeck(Card []);

void generateCards ( Card [], Card * c, const int n);
void printCardArray(const Card *, const int );
ostream& operator <<(ostream& out, const Card g); //$
bool operator ==(const Card p1,const Card p2);

//void operator =(valueType,Card x);



#endif
