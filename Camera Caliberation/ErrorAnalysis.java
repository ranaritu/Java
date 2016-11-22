
import java.util.Arrays;
import Jama.Matrix;


public class ErrorAnalysis {

	public static void main(String[] args) {
		
		/**
		 * projection matrix for trial purposes
		 */
//		double[][] projectionMatrix = {{0.007401051903789218, 0.005164316876827977, 0.8418943250353008, 1.5704240687751632}, 
//				{5.103173313634905, 3.1040729963481257, 2.5223278315987607, 0.5736667349224495},
//				{0.4617762988916537, 0.43679497569703984, 2.995008346971483,1}};
//		
//		double[][] projectionMatrix = {{-0.009127,0.082468,0.001122,0.929983},
//				{0.049397,0.049595,0.066448,-0.344865},
//				{0.000077,0.000077,0.000001,0.000321}};
		
//		double[][] projectionMatrix = {{91.27,-82.468,-11.22,-92.9983},
//				{-49.397,-49.595,-66.448,34.4865},
//				{-0.0077,-0.0077,-0.0001,-0.0321}};
		
//		double[][] projectionMatrix ={{-31.243458808570193, 239.08197140685863, 2.921070305003802, 2826.671570546453},
//		 {144.38380943327746, 144.64855677179466, 195.9807784065315,-986.6344388404616}, 
//			{ 0.22519960553793608, 0.22587607410416385, 0.0030240228802169426,1}};
//		
		
		double[][] projectionMatrix = {{0.009127,-0.082468,-0.001122,-0.929983},
				{-0.049397,-0.049595,-0.066448,0.344865},
				{-0.000077,-0.000077,-0.000001,-0.000321}};
		
		
		double[][] Pw1 ={{4},{0},{0},{1}};
		double[][] Pw2 ={{6},{0},{0},{1}};
		double[][] Pw3 ={{0},{4},{0},{1}};
		double[][] Pw4 ={{4},{0},{2},{1}};
		double[][] Pw5 ={{0},{4},{2},{1}};
		double[][] Pw6 ={{6},{0},{2},{1}};
		
		Matrix ProjectionMatrix = new Matrix(projectionMatrix);
		Matrix PW1 = new Matrix(Pw1);
		Matrix PW2 = new Matrix(Pw2);
		Matrix PW3 = new Matrix(Pw3);
		Matrix PW4 = new Matrix(Pw4);
		Matrix PW5 = new Matrix(Pw5);
		Matrix PW6 = new Matrix(Pw6);
		Matrix Pi1 = ProjectionMatrix.times(PW1);
		Matrix Pi2 = ProjectionMatrix.times(PW2);
		Matrix Pi3 = ProjectionMatrix.times(PW3);
		Matrix Pi4 = ProjectionMatrix.times(PW4);
		Matrix Pi5 = ProjectionMatrix.times(PW5);
		Matrix Pi6 = ProjectionMatrix.times(PW6);
		System.out.println(Arrays.deepToString(Pi1.getArray()).toString());
		System.out.println(Arrays.deepToString(Pi2.getArray()).toString());
		System.out.println(Arrays.deepToString(Pi3.getArray()).toString());
		System.out.println(Arrays.deepToString(Pi4.getArray()).toString());
		System.out.println(Arrays.deepToString(Pi5.getArray()).toString());
		System.out.println(Arrays.deepToString(Pi6.getArray()).toString());
		
		}

}

