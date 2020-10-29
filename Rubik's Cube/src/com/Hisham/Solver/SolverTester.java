package com.Hisham.Solver;

// string should be inputted as such presentation
//         *             |*U1**U2**U3*|
//         *             |************|
//         *             |*U4**U5**U6*|
//         *             |************|
//         *             |*U7**U8**U9*|
//         *             |************|
//         * ************|************|************|************|
//         * *L1**L2**L3*|*F1**F2**F3*|*R1**R2**F3*|*B1**B2**B3*|
//         * ************|************|************|************|
//         * *L4**L5**L6*|*F4**F5**F6*|*R4**R5**R6*|*B4**B5**B6*|
//         * ************|************|************|************|
//         * *L7**L8**L9*|*F7**F8**F9*|*R7**R8**R9*|*B7**B8**B9*|
//         * ************|************|************|************|
//         *             |************|
//         *             |*D1**D2**D3*|
//         *             |************|
//         *             |*D4**D5**D6*|
//         *             |************|
//         *             |*D7**D8**D9*|
//         *             |************|

public class SolverTester {

    int maxDepth = 21;             // Sets the maximum amount of manoeuvre to start with.
    long startTime = 0;
    long endTime = 0;
    int maxTime = 15;             // no need now.but if any time restriction,then use it

    String cubeString = "";
    String result = "";
    boolean useSeparator = false;

    SolverTester() {
        calculate();
    }

    void calculate() {

//        // we can create random(scrambled) cube to solve
//        cubeString = Tools.randomCube();

        // or,manually create the string
        cubeString += "DUUUUUUUD";   // U
        cubeString += "FBRRRRFRR";   // R
        cubeString += "FFRFFFBBR";   // F
        cubeString += "UDUDDDDDD";   // D
        cubeString += "LLLLLLLLL";   // L
        cubeString += "BRFBBBBFB";   // B

        if (Tools.verify(cubeString) != 0) {
            System.out.println("Unsolvable");
            return;
        }

        startTime = System.currentTimeMillis();            // Get the time when calculation is started.
        result = Search.solution(cubeString, maxDepth, maxTime, useSeparator); // Get the solution by Herbert Kociemba Two Phase Algorithm.
        endTime = System.currentTimeMillis();              // Get the time when calculation is finished.

        System.out.println(cubeString);
        System.out.println(result);
        System.out.println("Time taken = " + (endTime - startTime) * 1E-3);
    }

    public static void main(String[] args) {
        new SolverTester();
    }
}
