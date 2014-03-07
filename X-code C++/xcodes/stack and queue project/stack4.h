// FILE: stack4.h (part of the namespace main_savitch_7B)
// TEMPLATE CLASS PROVIDED: stack<Item> (a stack of items)
//   The template parameter, Item, is the data type of the items in the stack,
//   also defined as stack<Item>::value_type.
//   It may be any of the C++ built-in types (int, char, etc.), or a class
//   with a default constructor, a copy constructor, and an assignment
//   operator. The definition stack<Item>::size_type is the data type of
//   any variable that keeps track of how many items are in a stack.
//
// CONSTRUCTOR for the stack<Item> template class:
//   stack( )
//     Postcondition: The stack has been initialized as an empty stack.
//
// MODIFICATION MEMBER FUNCTIONS for the stack<Item> class:
//   void push(const Item& entry)
//     Precondition: size( ) < CAPACITY.
//     Postcondition: A new copy of entry has been pushed onto the stack.
//
//   Item pop( )
//     Precondition: size( ) > 0.
//     Postcondition: The top item of the stack has been removed.
//
//   Item& top( ) 
//     Precondition: size( ) > 0.
//     Postcondition: The return value is a reference to the top item of
//     the stack (but the stack is unchanged).
//
// CONSTANT MEMBER FUNCTIONS for the stack<Item> class:
//   bool empty( ) const
//     Postcondition: Return value is true if the stack is empty.
//
//   size_type size( ) const
//     Postcondition: Return value is the total number of items in the stack.
//
//   const Item& top( ) const
//     Precondition: size( ) > 0.
//     Postcondition: The return value is a const reference to the top item of
//     the stack (but the stack is unchanged).
//
// VALUE SEMANTICS for the stack<Item> class:
//   Assignments and the copy constructor may be used with stack<Item>
//   objects.
//
// DYNAMIC MEMORY USAGE by the stack<Item> template class:
//   If there is insufficient dynamic memory, then the following functions
//   throw bad_alloc:
//   the copy constructor, push, and the assignment operator.

#ifndef STACK4_H
#define STACK4_H
#include <cstdlib>   // Provides NULL and size_t
#include "node2.h"   // Node template class from Figure 6.5 on page 308

namespace GelaS
{
    template <class Item>
    class stack
    {
    public:
        // TYPEDEFS 
        typedef std::size_t size_type;
        typedef Item value_type;
        // CONSTRUCTORS and DESTRUCTOR
        stack( ) { top_ptr = NULL; }
        stack(const stack& source);
        ~stack( ) { list_clear(top_ptr); }
        // MODIFICATION MEMBER FUNCTIONS
        void push(const Item& entry);
        void pop( );
        void operator =(const stack& source);
        Item& top( );
        // CONSTANT MEMBER FUNCTIONS
        size_type size( ) const
	    { return Gela::list_length(top_ptr); }
        bool empty( ) const { return (top_ptr == NULL); }
        const Item& top( ) const;
    private:
        Gela::node<Item> *top_ptr;  // Points to top of stack
    };
}

#include "stack4.hh" // Include the implementation 
#endif