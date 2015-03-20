#Plum Calculator

##Author:
Mohd Zeeshan Shaikh
<mohdzeeshanshaikh@gmail.com>

##How to build this app
1. Extract the zip file and open the project with Android Studio.
2. Build/Run the project from the toolbar menu at the top.

*Alternately, just transfer the PlumCalculator.apk file from the top 
directory level to your android phone and install/execute there.*

###Please Note
1. All the sample tests mentioned in the assignment lab 1 pdf execute as expected.
2. User is allowed to enter only 7 digits but the sum can be upto 8 digits. If the sum is more than 8 digits the value is reset to 0.


##How I made it
1. Initially, design the UI in activity_calculator.xml
	- I've used LinearLayouts to get the exact UI that complies with the provided wire frame.
	- The nested LinearLayouts are used for proper display of "=" button.
	- Update the strings in the strings.xml file as per requirements.
	- Use the "android:layout_weight" feature for proper scaling of buttons and textView.
2. You can change the icon in AndroidManifest.xml
3. Then, in the CalculatorActivity.java file:
	- Create the required variables and methods as follows,
		-The scrutinyAppend(String) method scrutinizes the textView and digits before appending.The scrutiny discards the leading 0's and ensures that only 7 digits are entered.
		- The discardLeadingZeros() method discards all the leading 0's by simply converting the value in the textView to an integer and displaying back as a string.
		- The keepOnlySevenDigits() method ensures that the entered value is only up to 7 digits.
		- The operate() method updates and displays the value of operand1 on the textView whenever plus or minus buttons are pressed.
		- The onClickListener(s) of plus/minus buttons handles multiple operations in a sequence.
		- The onClickListener(s) of equal button performs the appropriate operation and displays the result on the textView. If the result is greater than '99999999' or less than '-9999999' it resets the result to '0'.
		- The onClickListener(s) of clear button resets all variables along with the textView.