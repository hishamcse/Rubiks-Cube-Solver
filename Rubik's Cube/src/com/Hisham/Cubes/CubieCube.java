package com.Hisham.Cubes;

import com.Hisham.Enumeration.Corner;
import com.Hisham.Enumeration.Edge;

import static com.Hisham.Enumeration.Corner.*;
import static com.Hisham.Enumeration.Edge.*;

// Representation of the cube on the cubie level
public class CubieCube {

    // corner permutation(same as Corner.java)
    public Corner[] cornerPermute = {URF, UFL, ULB, UBR, DFR, DLF, DBL, DRB};

    // corner orientation
    public byte[] cornerOrient = {0, 0, 0, 0, 0, 0, 0, 0};

    // edge permutation(same as Edge.java)
    public Edge[] edgePermute = {UR, UF, UL, UB, DR, DF, DL, DB, FR, FL, BL, BR};

    // edge orientation
    public byte[] edgeOrient = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    // now moves on the cubie level. orientation is 0,1 or 2 for corner. 0 or 1 for edge.
    // see the research paper (page 9 with the figure 2.3). all will be crystal clear

    // moving Up positive (physical experiment needed with a cube.then it will be crystal clear).
    public static Corner[] cornerPermuteUp = {UBR, URF, UFL, ULB, DFR, DLF, DBL, DRB};
    public static byte[] cornerOrientUp = {0, 0, 0, 0, 0, 0, 0, 0};
    public static Edge[] edgePermuteUp = {UB, UR, UF, UL, DR, DF, DL, DB, FR, FL, BL, BR};
    public static byte[] edgeOrientUp = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    // moving Right positive
    public static Corner[] cornerPermuteRight = {DFR, UFL, ULB, URF, DRB, DLF, DBL, UBR};
    public static byte[] cornerOrientRight = {2, 0, 0, 1, 1, 0, 0, 2};   // all facelet containing L is 0. only those containing R will be 1 or 2
    public static Edge[] edgePermuteRight = {FR, UF, UL, UB, BR, DF, DL, DB, DR, FL, BL, UR};
    public static byte[] edgeOrientRight = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    // moving Front positive
    public static Corner[] cornerPermuteFront = {UFL, DLF, ULB, UBR, URF, DFR, DBL, DRB};
    public static byte[] cornerOrientFront = {1, 2, 0, 0, 2, 1, 0, 0};   // all facelet containing F will be 1 or 2
    public static Edge[] edgePermuteFront = {UR, FL, UL, UB, DR, FR, DL, DB, UF, DF, BL, BR};
    public static byte[] edgeOrientFront = {0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0};

    // moving Down positive
    public static Corner[] cornerPermuteDown = {URF, UFL, ULB, UBR, DLF, DBL, DRB, DFR};
    public static byte[] cornerOrientDown = {0, 0, 0, 0, 0, 0, 0, 0};
    public static Edge[] edgePermuteDown = {UR, UF, UL, UB, DF, DL, DB, DR, FR, FL, BL, BR};
    public static byte[] edgeOrientDown = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    // moving Left positive
    public static Corner[] cornerPermuteLeft = {URF, ULB, DBL, UBR, DFR, UFL, DLF, DRB};
    public static byte[] cornerOrientLeft = {0, 1, 2, 0, 0, 2, 1, 0};
    public static Edge[] edgePermuteLeft = {UR, UF, BL, UB, DR, DF, FL, DB, FR, UL, DL, BR};
    public static byte[] edgeOrientLeft = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    // moving back positive
    public static Corner[] cornerPermuteBack = {URF, UFL, UBR, DRB, DFR, DLF, ULB, DBL};
    public static byte[] cornerOrientBack = {0, 0, 1, 2, 0, 0, 2, 1};
    public static Edge[] edgePermuteBack = {UR, UF, UL, BR, DR, DF, DL, BL, FR, FL, UB, DB};
    public static byte[] edgeOrientBack = {0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1};

    // storing this 6 moves to an array
    public static CubieCube[] moves = new CubieCube[6];

    static {
        moves[0] = new CubieCube();
        moves[0].cornerPermute = cornerPermuteUp;
        moves[0].cornerOrient = cornerOrientUp;
        moves[0].edgePermute = edgePermuteUp;
        moves[0].edgeOrient = edgeOrientUp;

        moves[1] = new CubieCube();
        moves[1].cornerPermute = cornerPermuteRight;
        moves[1].cornerOrient = cornerOrientRight;
        moves[1].edgePermute = edgePermuteRight;
        moves[1].edgeOrient = edgeOrientRight;

        moves[2] = new CubieCube();
        moves[2].cornerPermute = cornerPermuteFront;
        moves[2].cornerOrient = cornerOrientFront;
        moves[2].edgePermute = edgePermuteFront;
        moves[2].edgeOrient = edgeOrientFront;

        moves[3] = new CubieCube();
        moves[3].cornerPermute = cornerPermuteDown;
        moves[3].cornerOrient = cornerOrientDown;
        moves[3].edgePermute = edgePermuteDown;
        moves[3].edgeOrient = edgeOrientDown;

        moves[4] = new CubieCube();
        moves[4].cornerPermute = cornerPermuteLeft;
        moves[4].cornerOrient = cornerOrientLeft;
        moves[4].edgePermute = edgePermuteLeft;
        moves[4].edgeOrient = edgeOrientLeft;

        moves[5] = new CubieCube();
        moves[5].cornerPermute = cornerPermuteBack;
        moves[5].cornerOrient = cornerOrientBack;
        moves[5].edgePermute = edgePermuteBack;
        moves[5].edgeOrient = edgeOrientBack;
    }

    public CubieCube() {

    }

//    public CubieCube(Corner[] cornerPermute, byte[] cornerOrient, Edge[] edgePermute, byte[] edgeOrient) {
//        this();
//        for (int i = 0; i < 8; i++) {
//            this.cornerPermute[i] = cornerPermute[i];
//            this.cornerOrient[i] = cornerOrient[i];
//        }
//        for (int i = 0; i < 12; i++) {
//            this.edgePermute[i] = edgePermute[i];
//            this.edgeOrient[i] = edgeOrient[i];
//        }
//    }

    // n choose k
    public static int nCk(int n, int k) {
        if (n < k) {
            return 0;
        }
        if (k > n / 2) {
            k = n - k;
        }
        int p,i,j;
        for (p=1,i = n, j = 1; i != n - k; i--, j++) {
            p *= i;
            p /= j;
        }
        return p;
    }

    // left rotating corners between l and r
    public static void leftRotateCorner(Corner[] corners, int l, int r) {
        Corner corner = corners[l];
        for (int i = l; i < r; i++) {
            corners[i] = corners[i + 1];
        }
        corners[r] = corner;
    }

    // right rotating corners between l and r
    public static void rightRotateCorner(Corner[] corners, int l, int r) {
        Corner corner = corners[r];
        for (int i = r; i > l; i--) {
            corners[i] = corners[i - 1];
        }
        corners[l] = corner;
    }

    // left rotating edges between l and r
    public static void leftRotateEdge(Edge[] edges, int l, int r) {
        Edge edge = edges[l];
        for (int i = l; i < r; i++) {
            edges[i] = edges[i + 1];
        }
        edges[r] = edge;
    }

    // right rotating edges between l and r
    public static void rightRotateEdge(Edge[] edges, int l, int r) {
        Edge edge = edges[r];
        for (int i = r; i > l; i--) {
            edges[i] = edges[i - 1];
        }
        edges[l] = edge;
    }

    // returning FaceCube
    public FaceCube toFaceCube() {
        FaceCube faceCube = new FaceCube();
        for (Corner c : Corner.values()) {
            int i = c.ordinal();
            int j = cornerPermute[i].ordinal();   // cornerCubie with index j at corner position with index i
            byte orient = cornerOrient[i];       // orientation of this cubie
            for (int k = 0; k < 3; k++) {       // as the corner has 3 sides(use physical cube to visualize)
                faceCube.colors[FaceCube.cornerFacelet[i][(k + orient) % 3].ordinal()] = FaceCube.cornerColor[j][k];
            }
        }
        for (Edge e : Edge.values()) {
            int i = e.ordinal();
            int j = edgePermute[i].ordinal();
            byte orient = edgeOrient[i];
            for (int k = 0; k < 2; k++) {    // as the edge has two sides(use physical cube to visualize)
                faceCube.colors[FaceCube.edgeFacelet[i][(k + orient) % 2].ordinal()] = FaceCube.edgeColor[j][k];
            }
        }
        return faceCube;
    }

    // Multiply this CubieCube with another cubieCube B, restricted to the corners
    // Because we also describe reflections of the whole cube by permutations, we get a complication with the corners.
    // The orientations of mirrored corners are described by the numbers 3, 4 and 5. The composition of the orientations
    // cannot be computed by addition modulo three in the cyclic group C3 any more. Instead the rules below give an
    // addition in the dihedral group D3 with 6 elements (as in the research paper)
    // the unused codes are in the research paper which deals with mirrored corners (I haven't implemented it here)

    public void multiplyCorner(CubieCube cubeB) {
        Corner[] corPerm = new Corner[8];
        byte[] corOrient = new byte[8];

        for (Corner c : Corner.values()) {
            int i = c.ordinal();
            int j = cubeB.cornerPermute[i].ordinal();

            corPerm[i] = cornerPermute[j];

            byte orientA = cornerOrient[j];
            byte orientB = cubeB.cornerOrient[i];
            byte orient = 0;

            if (orientA < 3 && orientB < 3)   // if both cubes are regular cubes
            {
                orient = (byte) (orientA + orientB);   // just do an addition modulo 3 here
                if (orient >= 3) {
                    orient -= 3;    // the composition is a regular cube
                }
            }
            corOrient[i] = orient;
        }

        for (Corner c : Corner.values()) {
            cornerPermute[c.ordinal()] = corPerm[c.ordinal()];
            cornerOrient[c.ordinal()] = corOrient[c.ordinal()];
        }
    }

    public void multiplyEdge(CubieCube cubeB) {
        Edge[] edgePerm = new Edge[12];
        byte[] edgeOri = new byte[12];

        for (Edge e : Edge.values()) {
            int i = e.ordinal();
            int j = cubeB.edgePermute[i].ordinal();

            edgePerm[i] = edgePermute[j];

            byte orientA = edgeOrient[j];
            byte orientB = cubeB.edgeOrient[i];

            edgeOri[i] = (byte) ((orientA + orientB) % 2);
        }

        for (Edge e : Edge.values()) {
            edgePermute[e.ordinal()] = edgePerm[e.ordinal()];
            edgeOrient[e.ordinal()] = edgeOri[e.ordinal()];
        }
    }

//    // Multiply this CubieCube with another CubieCube b.
//    public void multiply(CubieCube b) {
//        multiplyCorner(b);
//        // edgeMultiply(b);
//    }

//    // inverse of the parameter CubieCube
//    public void inverseCubieCube(CubieCube cube) {
//        for (Edge e : Edge.values()) {
//            cube.edgePermute[edgePermute[e.ordinal()].ordinal()] = e;
//        }
//        for (Edge e : Edge.values()) {
//            cube.edgeOrient[e.ordinal()] = edgeOrient[cube.edgePermute[e.ordinal()].ordinal()];
//        }
//        for (Corner corner : Corner.values()) {
//            cube.cornerPermute[cornerPermute[corner.ordinal()].ordinal()] = corner;
//        }
//        for (Corner corner : Corner.values()) {
//            byte orient = cornerOrient[cube.cornerPermute[corner.ordinal()].ordinal()];
//            if (orient >= 3) {  // Actually no need. We do not invert mirrored cubes in the program.
//                cube.cornerOrient[corner.ordinal()] = orient;
//            } else {      // standard case
//                cube.cornerOrient[corner.ordinal()] = (byte) -orient;
//                if (cube.cornerOrient[corner.ordinal()] < 0) {
//                    cube.cornerOrient[corner.ordinal()] += 3;
//                }
//            }
//        }
//    }

    // for understanding twist, see twist at slide pg 44
    // return the twist of the 8 corners. 0 <= twist < 3^7
    public short getTwist() {
        short r = 0;
        for (int i = URF.ordinal(); i < DRB.ordinal(); i++) {
            r = (short) (3 * r + cornerOrient[i]);    // as we have 3 sides for each corner
        }
        return r;
    }

    // setting the twist of the 8 corners. 0 <= twist < 3^7
    public void setTwist(short twist) {
        int twistParity = 0;
        for (int i = DRB.ordinal() - 1; i >= URF.ordinal(); i--) {
            twistParity += cornerOrient[i] = (byte) (twist % 3);
            twist /= 3;
        }
        cornerOrient[DRB.ordinal()] = (byte) ((3 - twistParity % 3) % 3);
    }

    // return the flip of the 12 edges. 0<= flip < 2^11
    public short getFlip() {
        short ret = 0;
        for (int i = UR.ordinal(); i < BR.ordinal(); i++)
            ret = (short) (2 * ret + edgeOrient[i]);    // as there are 2 side for each edge
        return ret;
    }

    // setting the flip of the 12 edges. 0<= flip < 2^11
    public void setFlip(short flip) {
        int flipParity = 0;
        for (int i = BR.ordinal() - 1; i >= UR.ordinal(); i--) {
            flipParity += edgeOrient[i] = (byte) (flip % 2);
            flip /= 2;
        }
        edgeOrient[BR.ordinal()] = (byte) ((2 - flipParity % 2) % 2);
    }

    // for parity concept : https://www.ryanheise.com/cube/parity.html#:~:text=The%20parity%20of%20a%20permutation,permutation%20is%20even%20or%20odd.&text=To%20obey%20the%20laws%20of,parity%20must%20also%20be%20odd.

    // Parity of the corner permutation
    public short cornerParity() {
        int s = 0;
        for (int i = DRB.ordinal(); i >= URF.ordinal() + 1; i--) {
            for (int j = i - 1; j >= URF.ordinal(); j--) {
                if (cornerPermute[j].ordinal() > cornerPermute[i].ordinal()) {
                    s++;
                }
            }
        }
        return (short) (s % 2);
    }

    // Parity of the edges permutation. Parity of corners and edges are the same if the cube is solvable.
    public short edgeParity() {
        int s = 0;
        for (int i = BR.ordinal(); i >= UR.ordinal() + 1; i--) {
            for (int j = i - 1; j >= UR.ordinal(); j--) {
                if (edgePermute[j].ordinal() > edgePermute[i].ordinal())
                    s++;
            }
        }
        return (short) (s % 2);
    }

    // permutation of the UD-slice edges FR,FL,BL and BR
    public short getFRtoBR() {
        int a = 0, b = 0, x = 0;
        Edge[] edge4 = new Edge[4];

        // compute the index a < (12 choose 4) and the permutation array perm.
        for (int j = BR.ordinal(); j >= UR.ordinal(); j--) {
            if (FR.ordinal() <= edgePermute[j].ordinal() && edgePermute[j].ordinal() <= BR.ordinal()) {
                a += nCk(11 - j, x + 1);
                edge4[3 - x++] = edgePermute[j];
            }
        }

        // compute the index b < 4! for the permutation in perm
        for (int j = 3; j > 0; j--) {
            int k = 0;
            while (edge4[j].ordinal() != j + 8) {
                leftRotateEdge(edge4, 0, j);
                k++;
            }
            b = (j + 1) * b + k;
        }
        return (short) (24 * a + b);     // 4! * a + b
    }

    public void setFRtoBR(short idx) {
        int x;
        Edge[] sliceEdge = {FR, FL, BL, BR};
        Edge[] otherEdge = {UR, UF, UL, UB, DR, DF, DL, DB};
        int b = idx % 24;     // Permutation
        int a = idx / 24;     // Combination
        for (Edge e : Edge.values()) {
            edgePermute[e.ordinal()] = DB;      // Use DB to invalidate all edges.
        }

        // generate permutation from index b
        for (int j = 1, k; j < 4; j++) {
            k = b % (j + 1);
            b /= j + 1;
            while (k-- > 0) {
                rightRotateEdge(sliceEdge, 0, j);
            }
        }

        // generate combination and set slice edges
        x = 3;
        for (int j = UR.ordinal(); j <= BR.ordinal(); j++) {
            if (a - nCk(11 - j, x + 1) >= 0) {
                edgePermute[j] = sliceEdge[3 - x];
                a -= nCk(11 - j, x-- + 1);
            }
        }

        // set the remaining edges UR..DB(their original value)
        x = 0;
        for (int j = UR.ordinal(); j <= BR.ordinal(); j++) {
            if (edgePermute[j] == DB)
                edgePermute[j] = otherEdge[x++];
        }

    }

    // Permutation of all corners except DBL and DRB
    public short getURFtoDLF() {
        int a = 0, x = 0;
        Corner[] corner6 = new Corner[6];

        // compute the index a < (8 choose 6) and the corner permutation.
        for (int j = URF.ordinal(); j <= DRB.ordinal(); j++) {
            if (cornerPermute[j].ordinal() <= DLF.ordinal()) {
                a += nCk(j, x + 1);
                corner6[x++] = cornerPermute[j];
            }
        }

        // compute the index b < 6! for the permutation in corner6
        int b = 0;
        for (int j = 5; j > 0; j--) {
            int k = 0;
            while (corner6[j].ordinal() != j) {
                leftRotateCorner(corner6, 0, j);
                k++;
            }
            b = (j + 1) * b + k;
        }
        return (short) (720 * a + b);     // 6! * a + b
    }

    public void setURFtoDLF(short idx) {
        int x;
        Corner[] corner6 = {URF, UFL, ULB, UBR, DFR, DLF};
        Corner[] otherCorner = {DBL, DRB};
        int b = idx % 720;   // Permutation
        int a = idx / 720;   // Combination
        for (Corner c : Corner.values())
            cornerPermute[c.ordinal()] = DRB;   // Use DRB to invalidate all corners

        // generate permutation from index b
        for (int j = 1, k; j < 6; j++) {
            k = b % (j + 1);
            b /= j + 1;
            while (k-- > 0)
                rightRotateCorner(corner6, 0, j);
        }

        // generate combination and set corners
        x = 5;
        for (int j = DRB.ordinal(); j >= 0; j--) {
            if (a - nCk(j, x + 1) >= 0) {
                cornerPermute[j] = corner6[x];
                a -= nCk(j, x-- + 1);
            }
        }

        // set the other corner permutation to their original values
        x = 0;
        for (int j = URF.ordinal(); j <= DRB.ordinal(); j++) {
            if (cornerPermute[j] == DRB)
                cornerPermute[j] = otherCorner[x++];
        }
    }

    // Permutation of the six edges UR,UF,UL,UB,DR,DF.
    public int getURtoDF() {
        int a = 0, x = 0;
        Edge[] edge6 = new Edge[6];

        // compute the index a < (12 choose 6) and the edge permutation.
        for (int j = UR.ordinal(); j <= BR.ordinal(); j++) {
            if (edgePermute[j].ordinal() <= DF.ordinal()) {
                a += nCk(j, x + 1);
                edge6[x++] = edgePermute[j];
            }
        }

        // compute the index b < 6! for the permutation in edge6
        int b = 0;
        for (int j = 5; j > 0; j--) {
            int k = 0;
            while (edge6[j].ordinal() != j) {
                leftRotateEdge(edge6, 0, j);
                k++;
            }
            b = (j + 1) * b + k;
        }
        return 720 * a + b;
    }

    public void setURtoDF(int idx) {
        int x;
        Edge[] edge6 = {UR, UF, UL, UB, DR, DF};
        Edge[] otherEdge = {DL, DB, FR, FL, BL, BR};
        int b = idx % 720; // Permutation
        int a = idx / 720; // Combination
        for (Edge e : Edge.values())
            edgePermute[e.ordinal()] = BR;    // Use BR to invalidate all edges

        for (int j = 1, k; j < 6; j++)// generate permutation from index b
        {
            k = b % (j + 1);
            b /= j + 1;
            while (k-- > 0)
                rightRotateEdge(edge6, 0, j);
        }

        // generate combination and set edges
        x = 5;
        for (int j = BR.ordinal(); j >= 0; j--) {
            if (a - nCk(j, x + 1) >= 0) {
                edgePermute[j] = edge6[x];
                a -= nCk(j, x-- + 1);
            }
        }

        // set the remaining edges DL..BR
        x = 0;
        for (int j = UR.ordinal(); j <= BR.ordinal(); j++) {
            if (edgePermute[j] == BR)
                edgePermute[j] = otherEdge[x++];
        }
    }

    // Permutation of the six edges UR,UF,UL,UB,DR,DF
    public static int getURtoDF(short idx1, short idx2) {
        CubieCube a = new CubieCube();
        CubieCube b = new CubieCube();
        a.setURtoUL(idx1);
        b.setUBtoDF(idx2);
        for (int i = 0; i < 8; i++) {
            if (a.edgePermute[i] != BR)
                if (b.edgePermute[i] != BR)     // collision
                    return -1;
                else
                    b.edgePermute[i] = a.edgePermute[i];
        }
        return b.getURtoDF();
    }

    // Permutation of the three edges UR,UF,UL
    public short getURtoUL() {
        int a = 0, x = 0;
        Edge[] edge3 = new Edge[3];

        // compute the index a < (12 choose 3) and the edge permutation.
        for (int j = UR.ordinal(); j <= BR.ordinal(); j++) {
            if (edgePermute[j].ordinal() <= UL.ordinal()) {
                a += nCk(j, x + 1);
                edge3[x++] = edgePermute[j];
            }
        }

        // compute the index b < 3! for the permutation in edge3
        int b = 0;
        for (int j = 2; j > 0; j--) {
            int k = 0;
            while (edge3[j].ordinal() != j) {
                leftRotateEdge(edge3, 0, j);
                k++;
            }
            b = (j + 1) * b + k;
        }
        return (short) (6 * a + b);
    }

    public void setURtoUL(short idx) {
        int x;
        Edge[] edge3 = {UR, UF, UL};
        int b = idx % 6; // Permutation
        int a = idx / 6; // Combination
        for (Edge e : Edge.values())
            edgePermute[e.ordinal()] = BR;// Use BR to invalidate all edges

        // generate permutation from index b
        for (int j = 1, k; j < 3; j++) {
            k = b % (j + 1);
            b /= j + 1;
            while (k-- > 0)
                rightRotateEdge(edge3, 0, j);
        }

        // generate combination and set edges
        x = 2;
        for (int j = BR.ordinal(); j >= 0; j--)
            if (a - nCk(j, x + 1) >= 0) {
                edgePermute[j] = edge3[x];
                a -= nCk(j, x-- + 1);
            }
    }

    // Permutation of the three edges UB,DR,DF
    public short getUBtoDF() {
        int a = 0, x = 0;
        Edge[] edge3 = new Edge[3];

        // compute the index a < (12 choose 3) and the edge permutation.
        for (int j = UR.ordinal(); j <= BR.ordinal(); j++) {
            if (UB.ordinal() <= edgePermute[j].ordinal() && edgePermute[j].ordinal() <= DF.ordinal()) {
                a += nCk(j, x + 1);
                edge3[x++] = edgePermute[j];
            }
        }

        // compute the index b < 3! for the permutation in edge3
        int b = 0;
        for (int j = 2; j > 0; j--) {
            int k = 0;
            while (edge3[j].ordinal() != UB.ordinal() + j) {
                leftRotateEdge(edge3, 0, j);
                k++;
            }
            b = (j + 1) * b + k;
        }
        return (short) (6 * a + b);
    }

    public void setUBtoDF(short idx) {
        int x;
        Edge[] edge3 = {UB, DR, DF};
        int b = idx % 6; // Permutation
        int a = idx / 6; // Combination
        for (Edge e : Edge.values())
            edgePermute[e.ordinal()] = BR;// Use BR to invalidate all edges

        // generate permutation from index b
        for (int j = 1, k; j < 3; j++) {
            k = b % (j + 1);
            b /= j + 1;
            while (k-- > 0)
                rightRotateEdge(edge3, 0, j);
        }

        // generate combination and set edges
        x = 2;
        for (int j = BR.ordinal(); j >= 0; j--) {
            if (a - nCk(j, x + 1) >= 0) {
                edgePermute[j] = edge3[x];
                a -= nCk(j, x-- + 1);
            }
        }
    }

    // permutation for all corners
    public int getURFtoDLB() {
        Corner[] perm = new Corner[8];
        int b = 0;
        for (int i = 0; i < 8; i++)
            perm[i] = cornerPermute[i];

        // compute the index b < 8! for the permutation in perm
        for (int j = 7; j > 0; j--) {
            int k = 0;
            while (perm[j].ordinal() != j) {
                leftRotateCorner(perm, 0, j);
                k++;
            }
            b = (j + 1) * b + k;
        }
        return b;
    }

    public void setURFtoDLB(int idx) {
        Corner[] perm = {URF, UFL, ULB, UBR, DFR, DLF, DBL, DRB};
        int k;
        for (int j = 1; j < 8; j++) {
            k = idx % (j + 1);
            idx /= j + 1;
            while (k-- > 0)
                rightRotateCorner(perm, 0, j);
        }

        // set corners
        int x = 7;
        for (int j = 7; j >= 0; j--) {
            cornerPermute[j] = perm[x--];
        }
    }

    // permutation for all edges
    public int getURtoBR() {
        Edge[] perm = new Edge[12];
        int b = 0;
        for (int i = 0; i < 12; i++)
            perm[i] = edgePermute[i];

        // compute the index b < 12! for the permutation in perm
        for (int j = 11; j > 0; j--) {
            int k = 0;
            while (perm[j].ordinal() != j) {
                leftRotateEdge(perm, 0, j);
                k++;
            }
            b = (j + 1) * b + k;
        }
        return b;
    }

    public void setURtoBR(int idx) {
        Edge[] perm = {UR, UF, UL, UB, DR, DF, DL, DB, FR, FL, BL, BR};
        int k;
        for (int j = 1; j < 12; j++) {
            k = idx % (j + 1);
            idx /= j + 1;
            while (k-- > 0)
                rightRotateEdge(perm, 0, j);
        }

        // set edges
        int x = 11;
        for (int j = 11; j >= 0; j--) {
            edgePermute[j] = perm[x--];
        }
    }

    // Check a cubieCube for solvability. Return the error code.
    //  0: Cube is solvable
    // -2: Not all 12 edges exist exactly once
    // -3: Flip error: One edge has to be flipped
    // -4: Not all corners exist exactly once
    // -5: Twist error: One corner has to be twisted
    // -6: Parity error: Two corners or two edges have to be exchanged
    public int verify() {
        int sum = 0;
        int[] edgeCount = new int[12];
        for (Edge e : Edge.values()) {
            edgeCount[edgePermute[e.ordinal()].ordinal()]++;
        }

        // whether all 12 edges exist exactly once
        for (int i = 0; i < 12; i++) {
            if (edgeCount[i] != 1)
                return -2;
        }

        for (int i = 0; i < 12; i++) {
            sum += edgeOrient[i];
        }

        // check for flip error
        if (sum % 2 != 0) {
            return -3;
        }

        int[] cornerCount = new int[8];
        for (Corner c : Corner.values()) {
            cornerCount[cornerPermute[c.ordinal()].ordinal()]++;
        }

        // whether all corners exist exactly once
        for (int i = 0; i < 8; i++) {
            if (cornerCount[i] != 1)
                return -4;     // missing corners
        }

        sum = 0;
        for (int i = 0; i < 8; i++) {
            sum += cornerOrient[i];
        }

        // check for Twist error
        if (sum % 3 != 0) {
            return -5;// twisted corner
        }

        // check for parity error. Parity of corners and edges must be same if the cube is solvable.
        if ((edgeParity() ^ cornerParity()) != 0) {
            return -6;// parity error
        }

        return 0;// cube ok
    }
}
