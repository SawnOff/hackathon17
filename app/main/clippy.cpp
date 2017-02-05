#include <iostream>
#include <fstream>
#include <string>
#include <stdio.h>
#include "stdlib.h"

using namespace std;

string readTmp (string dest);

int main () {
  ofstream myfile;
  //myfile.open ("out.txt");

  string currentDir = "";
  string tmpDir = "";

  system("pwd > tmp.txt");
  tmpDir = readTmp("tmp.txt");

  system(("pwd > " + tmpDir + "/tmp.txt").c_str());

  system(("echo " + tmpDir + "/tmp.txt").c_str());

  while (true) {
	char input[256] = { };
	
	system(("printf clippy:@" + currentDir + "$  ").c_str());
	cin.getline(input, 256);

	ofstream outFile((tmpDir + "/output.txt").c_str());
	outFile << string(input) + "\n";

  	string post = "cd " + currentDir + " && " + string(input) + " 2> " + tmpDir + "/tmp.txt 1>>&2 " + tmpDir + "/tmp.txt && pwd > \"" + tmpDir + "/tmp1.txt\"";
  	system(post.c_str());
	string outStr = readTmp(tmpDir + "/tmp.txt");
	system(("echo \"" + outStr + "\"").c_str());
	outFile << outStr;
	
	outFile.close();
	currentDir = readTmp(tmpDir + "/tmp1.txt");

	
  }
  //myfile << "Writing this to a file.\n";
  //myfile.close();
  return 0;
}

string readTmp (string dest) {
	string r;	
	string rTot = "";
	ifstream tmpFile((dest).c_str());
	if (tmpFile.is_open()) {
		getline(tmpFile, rTot);
		while (getline(tmpFile, r)) {
			rTot = rTot + "\n" + r;
		}
	}
	tmpFile.close();
	return rTot;
}
