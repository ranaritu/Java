import java.util.Arrays;

import Jama.Matrix;

public class Project1Part2 {

	public static void main(String[] args) {
		
		double U0, V0, beta1,alpha2,beta,alpha;
		
		double[][] projectionMatrix = {{0.009127,-0.082468,-0.001122,-0.929983},
				{-0.049397,-0.049595,-0.066448,0.344865},
				{-0.000077,-0.000077,-0.000001,-0.000321}};
		
		/**
		 * Separate  projection matrix into B and b to be used to find rotation
		 * and translation matrices
		 */
		
		double[][] BB = {{0.009127,-0.082468,-0.001122,},
				{-0.049397,-0.049595,-0.066448,},
				{-0.000077,-0.000077,-0.000001,}};
		
				
		double[][] bb ={{-0.929983},{0.344865},{-0.000321}};
		
		
				
		/**
		 * Convert the arrays into matrix
		 */
		Matrix B = new Matrix(BB);
		Matrix b = new Matrix(bb);
		
		/**
		 * Do the computation: B transpose and B*Btranspose
		 * 
		 * 
		 */
		
		
		Matrix BTranspose = B.transpose();
		Matrix BtimesBtranspose = B.times(BTranspose);
		
		System.out.println( "B times B transpose: " + Arrays.deepToString(BtimesBtranspose.getArray()).toString() +"\n");
		
		
		
		
		/**
		 * Substitute the values of BtimesBtranspose into a 2D array
		 */
		
		double[][] BBtranspose ={{0.006885532037, 0.003713708697, 5.648379E-6},
				{0.003713708697, 0.009315064338, 7.688832000000001E-6}, 
				{5.648379E-6, 7.688832000000001E-6, 1.1859E-8}};
		
		
		/**
		 * Divide the values of 2D array with the last element
		 * The resultant values will make the k matrix
		 */
		
		System.out.println("Final Matrix A: ");
		for(int i=0;i<BBtranspose.length;i++){
			for (int j = 0; j < BBtranspose[i].length; j++) {

				BBtranspose[i][j] = BBtranspose[i][j]/1.1859E-8; 
			System.out.print(BBtranspose[i][j] + " , ");
				}
			}
		System.out.println("\n");
	
		
		
		
		
		
		/**
		 * Declare the intrinsic parameters for the k matrix
		 */
		
		U0 = 476.29471287629644;
		V0 = 648.3541613964078;
		beta1 = 785484.8079939286   - V0*V0;
		alpha2 = 580616.5812463108 - U0*U0;
		beta  = Math.sqrt(beta1); 
		alpha = Math.sqrt(alpha2); 
		
		System.out.println("Camera's Intrinsic Parameters:");
		System.out.println("alpha = " + alpha +"\n" + "beta = " + beta +"\n"+ "U0 = " + U0 +"\n" + "V0 = " + V0);
		

		/**
		 * Compose the k matrix from the values obtained
		 */
		
		double[][] k = {{alpha, 0, U0},
				{0, beta, V0},
				{0,0,1}};
		
		/**
		 * Compute the rotation and the translation matrix from k
		 */
		Matrix K = new Matrix(k);
		Matrix Translation = K.inverse().times(b);
		Matrix Rotation = K.inverse().times(B);
		
		
		System.out.println("\n" + "Camera's Extrinsic Parameters:");
		System.out.println( "Rotation matrix (R): " +(Arrays.deepToString(Rotation.getArray()).toString()));
		System.out.println("Translation matrix (t): " +(Arrays.deepToString(Translation.getArray()).toString()));
		
		
		
		
		
	}// end main

}// end class
