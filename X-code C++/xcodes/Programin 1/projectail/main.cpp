#include <iostream>
#include <iomanip>
#include <cmath>
/*
SDM
 This program code was create to display a projectile. It will ask you for gravity, velocity. Once you plug thos numbers then you will get the height of the projectile depending on time

*/
using namespace std;
double totTime (double velocity, double angle);
double maxHeight (double velocity, double angle, double time);
const  double GRAVITY = 9.80665;
int main()
{
	double velocity;
	double angle;
	double counter;
	const  double GRAVITY = 9.80665;
	double Time, 
	totDist, 
	height; 
	
	cout << "Lets see how far a projectile can be launched!"<<endl ;
	
	cout << "You are on the surface of the Earth at a gravity of 9.81 meters per second squared."<<endl;
	cout << "Please enter the intial angle of your projectile (0.0 to 90.0):"<<endl;
	cin >> angle;
	cout << "Please enter the intial velocity of your projectile (0.0 to 999.99):"<<endl;
	cin >> velocity;
	cout << "Please enter the number of height measurements to display (0 to 99):"<<endl;
	cin>> counter;
	
	angle = M_PI / 180 * angle;
	totDist = velocity * cos(angle) * Time;
	
	Time = totTime(velocity, angle);  
	
	for (int i=1;i<=counter;++i)
	{
		cout<< "At "<<i*(Time/counter)<< " seconds: " <<maxHeight(velocity, angle, i*(Time/counter))<< " meters high. "<<endl;
	}
	system ("pause");
	
	return EXIT_SUCCESS;
}
double totTime(double velocity, double angle)
{
	return (2.0 * velocity * sin(angle)) / GRAVITY;
}
double maxHeight (double velocity, double angle, double time)
{
	return velocity * sin(angle) * time - 0.5 * GRAVITY * pow(time, 2.0);
}