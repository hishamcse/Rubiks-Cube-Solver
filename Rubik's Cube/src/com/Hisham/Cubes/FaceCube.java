package com.Hisham.Cubes;

import com.Hisham.Enumeration.Color;
import com.Hisham.Enumeration.Corner;
import com.Hisham.Enumeration.Edge;
import com.Hisham.Enumeration.Facelet;

import static com.Hisham.Enumeration.Corner.URF;
import static com.Hisham.Enumeration.Edge.UR;
import static com.Hisham.Enumeration.Facelet.*;
import static com.Hisham.Enumeration.Color.*;

// facelet level cube
public class FaceCube {

    public Color[] colors = new Color[54];

    // just match the Corner.java serially with the faces of a physical cube
    public static final Facelet[][] cornerFacelet = {{U9, R1, F3}, {U7, F1, L3}, {U1, L1, B3}, {U3, B1, R3},
            {D3, F9, R7}, {D1, L9, F7}, {D7, B9, L7}, {D9, R9, B7}};

    // just match the Edge.java serially with the edges of a physical cube
    public static final Facelet[][] edgeFacelet = {{U6, R2}, {U8, F2}, {U4, L2}, {U2, B2}, {D6, R8}, {D2, F8},
            {D4, L8}, {D8, B8}, {F6, R4}, {F4, L6}, {B6, L4}, {B4, R6}};

    // just match the Corner.java serially
    public static final Color[][] cornerColor = {{U, R, F}, {U, F, L}, {U, L, B}, {U, B, R}, {D, F, R},
            {D, L, F}, {D, B, L}, {D, R, B}};

    // just match the Edge.java serially
    public static final Color[][] edgeColor = {{U, R}, {U, F}, {U, L}, {U, B}, {D, R}, {D, F}, {D, L},
            {D, B}, {F, R}, {F, L}, {B, L}, {B, R}};

    FaceCube() {
        String s = "UUUUUUUUURRRRRRRRRFFFFFFFFFDDDDDDDDDLLLLLLLLLBBBBBBBBB";
        for (int i = 0; i < 54; i++) {
            colors[i] = Color.valueOf(String.valueOf(s.charAt(i)));
        }
    }

    // Construct a facelet cube from a string
    public FaceCube(String cubeString) {
        for (int i = 0; i < cubeString.length(); i++) {
            colors[i] = Color.valueOf(String.valueOf(cubeString.charAt(i)));
        }
    }

    // string representation of a facelet cube
    public String to_String() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 54; i++) {
            s.append(colors[i].toString());
        }
        return s.toString();
    }

    // Gives CubieCube representation of a faceletCube
    public CubieCube toCubieCube() {
        byte ori;
        CubieCube cubieCube = new CubieCube();
        for (int i = 0; i < 8; i++) {
            cubieCube.cornerPermute[i] = URF;        // invalidate corners
        }
        for (int i = 0; i < 12; i++) {
            cubieCube.edgePermute[i] = UR;           // and edges
        }

        Color col1, col2;

        for (Corner i : Corner.values()) {
            // get the colors of the cubie at corner i, starting with U/D
            for (ori = 0; ori < 3; ori++) {
                if (colors[cornerFacelet[i.ordinal()][ori].ordinal()] == U ||
                        colors[cornerFacelet[i.ordinal()][ori].ordinal()] == D) {
                    break;
                }
            }

            col1 = colors[cornerFacelet[i.ordinal()][(ori + 1) % 3].ordinal()];
            col2 = colors[cornerFacelet[i.ordinal()][(ori + 2) % 3].ordinal()];

            for (Corner j : Corner.values()) {
                if (col1 == cornerColor[j.ordinal()][1] && col2 == cornerColor[j.ordinal()][2]) {
                    // in corner position i we have cornerCubie j
                    cubieCube.cornerPermute[i.ordinal()] = j;
                    cubieCube.cornerOrient[i.ordinal()] = (byte) (ori % 3);
                    break;
                }
            }
        }

        for (Edge i : Edge.values()) {
            for (Edge j : Edge.values()) {
                if (colors[edgeFacelet[i.ordinal()][0].ordinal()] == edgeColor[j.ordinal()][0]
                        && colors[edgeFacelet[i.ordinal()][1].ordinal()] == edgeColor[j.ordinal()][1]) {
                    cubieCube.edgePermute[i.ordinal()] = j;
                    cubieCube.edgeOrient[i.ordinal()] = 0;
                    break;
                }
                if (colors[edgeFacelet[i.ordinal()][0].ordinal()] == edgeColor[j.ordinal()][1]
                        && colors[edgeFacelet[i.ordinal()][1].ordinal()] == edgeColor[j.ordinal()][0]) {
                    cubieCube.edgePermute[i.ordinal()] = j;
                    cubieCube.edgeOrient[i.ordinal()] = 1;
                    break;
                }
            }
        }
        return cubieCube;
    }
}
