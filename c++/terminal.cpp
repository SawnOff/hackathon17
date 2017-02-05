#include <iostream>
#include "stdlib.h"
#include <stdio.h>
#include <string>

using namespace std;

int main(int argc, char* argv[]) {
        string input = "cd " + string(argv[1]) + " && " + string(argv[2]) + " && pwd";
        system(input.c_str());
}
