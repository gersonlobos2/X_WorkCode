/* ~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~
  Name: Nellical Mathew
  Date: 11/20/2010
  COMSC 201A Data Structures
  Professor: E. Branca
  Assignment: Recursion Exercises
  File Name: recursion.cpp
  Compiler Used: GNU C++ [GCC] version 4.5.1
  Operating System: Arch Linux

  ~- Description: -~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~
    This program uses traces a function called "mystery()" when the input is
    4, and also displays the output. There are 3 recursive functions
    implemented: factorial(), fibonacci() and reverse() which is used to
    reverse the characters in a string and return it.8
  ~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~ */

#include <iostream>
#include <iomanip>
#include <string>

using namespace std;

/* ~- trace mystery(4): -~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~
  call: [mystery(4)] -> return (4) * (4) + [14] = [30] -> final answer
                                            ^^
  call: [mystery(3)] -> return (3) * (3) + [5] = [14];
                                            ^
  call: [mystery(2)] -> return (2) * (2) + [1] = [5];
                                            ^
  call: [mystery(1)] -> return (1) * (1) + [0] = [1];
                                            ^
  call: [mystery(0)] -> return [0];         
  ~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~ */

int mystery (int n)
{
    if (n == 0)
        return 0;
    else
        return n * n + mystery (n - 1);
}

int factorial(int num)
{
    if (num == 1)
        return num;
    else
        return num * factorial(num - 1);
}

long fibonacci(long num)
{
    if ((num == 0) || (num == 1))
        return num;
    else
        return fibonacci(num - 1) + fibonacci(num - 2);
}

string reverse(string input, int index = 0)
{
    if (index > input.length() - 1)
        return input;
    else
        return reverse(input.substr(0, index) +
            input[input.length() - 1] +
            input.substr(index, input.length() - index - 1),
            index + 1);
}

int main(int argc, char *argv[])
{
    cout << "  recursion exercises: by nellical mathew" << endl;
    cout << " -----------------------------------------" << endl;
    cout << setw(25) << right << "mystery(4): ";
    cout << mystery(4) << endl;

    cout << setw(25) << right << "factorial(5): ";
    cout << factorial(5) << endl;
    
    cout << setw(25) << right << "fibonacci(12): ";
    cout << fibonacci(12) << endl;
    
    cout << setw(25) << right << "reverse(\"nellical\"): ";
    cout << reverse("nellical") << endl;

    cout << " -----------------------------------------" << endl;
    cout << "  press <RETURN> to close this window!...";
    cin.ignore().get();
    return EXIT_SUCCESS;
}
