package com.Hisham.Solver;

import com.Hisham.Cubes.CoordCube;
import com.Hisham.Cubes.CubieCube;
import com.Hisham.Cubes.FaceCube;
import com.Hisham.Enumeration.Color;

import java.util.Random;

public class Tools {

    // Check if the cube string s represents a solvable cube.
    // 0: Cube is solvable
    // -1: There is not exactly one facelet of each colour
    // -2: Not all 12 edges exist exactly once
    // -3: Flip error: One edge has to be flipped
    // -4: Not all corners exist exactly once
    // -5: Twist error: One corner has to be twisted
    // -6: Parity error: Two corners or two edges have to be exchanged

    public static int verify(String s) {
        int[] count = new int[6];
        for (int i = 0; i < 54; i++) {
            count[Color.valueOf(String.valueOf(s.charAt(i))).ordinal()]++;
        }

        for (int i = 0; i < 6; i++) {
            if (count[i] != 9) {
                return -1;
            }
        }

        FaceCube faceCube = new FaceCube(s);
        CubieCube cubieCube = faceCube.toCubieCube();

        return cubieCube.verify();
    }

    // Generates a random cube.A random cube in the string representation.
    // Each cube of the cube space has the same probability.
    public static String randomCube() {
        CubieCube cubieCube = new CubieCube();
        Random gen = new Random();
        cubieCube.setFlip((short) gen.nextInt(CoordCube.N_FLIP));
        cubieCube.setTwist((short) gen.nextInt(CoordCube.N_TWIST));
        do {
            cubieCube.setURFtoDLB(gen.nextInt(CoordCube.N_URFtoDLB));
            cubieCube.setURtoBR(gen.nextInt(CoordCube.N_URtoBR));
        } while ((cubieCube.edgeParity() ^ cubieCube.cornerParity()) != 0);
        FaceCube faceCube = cubieCube.toFaceCube();
        return faceCube.to_String();
    }
}
