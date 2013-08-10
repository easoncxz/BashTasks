/*
 * University of Auckland
 * SoftEng 206 - Assignment 1 Part 2
 * Language: C
 *
 * Script by Roy Lin
 * Date: 10/07/2013
 *
 * Description:
 * 		Creates a .contact file.
 * Usage:
 *		./FileTask [DIRECTORY] [CONTACT_NAME] [CONTACT_NUMBER]
 * Example: 
 *		./FileTask . john 123456
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char *argv[])
{
	/* Output directory */
	char directory[256];
	
	/* Name of the contact. Is only one word consisting of letters */
	char contactName[256];
	
	/* Contact phone number. Is only contain digits */
	char contactNumber[256];

	/* ============= */
	/* Process Input */
	/* ============= */
	if (argc <= 1) {
		/* === Using standard input === */	
		scanf("%s", directory);
		scanf("%s", contactName);
		scanf("%s", contactNumber);
		
	} else {
		/* == Using command line arguments === */
		strcpy(directory, argv[1]);
		strcpy(contactName, argv[2]);
		strcpy(contactNumber, argv[3]);
		
	}

	/* ============ */
	/* Main Program */
	/* ============ */
	
	/* The file path is in the format of <path to file>/<contact name>.contact */
	char filePath[256];
	sprintf(filePath, "%s/%s.contact", directory, contactName);
	
	FILE *filePointer;
	filePointer = fopen(filePath, "r");
	
	if (filePointer == NULL) {
		/* === File (or contact) does not exist, so create one and write in correct phone number === */
		filePointer = fopen(filePath, "w");
		fprintf(filePointer, "%s", contactNumber);
		fclose(filePointer);
		
	} else {
		/* === File (or contact) already exists === */
		
		/* Close the file which was opened to test if the file existed */
		fclose(filePointer);
		
		/* Loop through for example john(1).contact, john(2).contact, john(3).contact and so on... */
		/* until one of them does not exist, then we write the contact number to that file */
		int count = 1;
		for(;;) {
			sprintf(filePath, "%s/%s(%i).contact", directory, contactName, count);
			filePointer = fopen(filePath, "r");
			if (filePointer == NULL) {
				filePointer = fopen(filePath, "w");
				fprintf(filePointer, "%s", contactNumber);
				fclose(filePointer);
				break;
			}
			fclose(filePointer);
			count = count + 1;
		}
	}
}	
	