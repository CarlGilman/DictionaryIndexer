# DictionaryIndexer
Parsing files against googles 1000 most common words and a dictionary file. outputting the dictionary definition and the times the word appeared in the text file.  Use of virtual threads 

all code should be run using eclipse or other java programming software.

This project is set up around using a runner class which loads a menu driven interface that allows for user input. This menu has multiple options which each have different interactions based on the users choice. This menu allows for the user to select a file from their system again using a JFrame with buttons system, which will store the selected filed to the memory of the executor of the program. (the frame must remain open for the duration of running to keep memory alive, however it can easily be tabbed away from in eclipse).

From here it is recommended to read in the dictionary file and google's 1000 most common words file. the program will then remove all capitals and symbols from the file before running the google file against it and remove all of the 1000 words that are most common. It will then run the file against the dictionary file finding each word from the file in the dictionary before printing it out, along with its definition and how many times it has appeared in the file. Both the reading in and parsing of the dictionary file and google file is done by using virtual threads in java JDK 19. it is important to note that special settings are required to make this work as the experimental features option is not on by default. the use of virtual threads helps to speed up the process of reading in the files by a significant amount. (there can sometimes be a small margin of error where a small amount of words can be skipped/ignored this is due to the fact virtual threads are a relatively new and still being improved and implemented feature).

Finally once the text file chosen has had both files ran against it, it is then output to a csv file called output.csv. This is done by a FileWriter class. If output.csv is already present in the project directory, it will overwrite it. Once this file has been output, the project will return to the menu and allow the user to either select another file and go again or quit out of the program. 

Note: there is some commented code in the application. this was used by me for debugging and thinking purposes which i thought appropriate to leave in for others to see my thought process. All code is labeled as best as possible by myself. 
