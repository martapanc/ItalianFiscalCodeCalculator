# Italian Fiscal Code Calculator

This application was developed as final project of the course 'Advanced Programming - Spring 2015' held by Prof. Barbara Russo at Free University of Bozen-Bolzano (Italy).

The program features an algorithm for the calculation of the Italian Fiscal Code ('Codice Fiscale', similar to a SSN issued in the United States or the National Insurance number used in the UK) from the data entered by the user: first and last name; gender; date and place of birth. 

The result is an alfanumeric code of 16 characters, which uniquely identifies individuals residing in Italy (although the algorithm, as it was conceived, does not guarantee that no two identical Fiscal Codes may exist).
It could also be used to check if an individual's Code was computed correctly.

For example, given a user with the following data:
- Name: Maria
- Surname: Rossi
- Gender: F
- Born in Milan (MI) on 12th July 1995

the resulting Fiscal Code is: RSSMRA95L52F205R

See https://en.wikipedia.org/wiki/Italian_fiscal_code_card for further details.





