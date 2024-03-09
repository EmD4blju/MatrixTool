package emk4;

import emk4.Exceptions.NotCompatibleSizeException;

/**
 * @author EmDablju
 */


public class App 
{
    public static void main( String[] args )
    {
        Matrix matrix1 = Matrix.generate(2, 2);
        Matrix matrix2 = Matrix.generate(2, 2);
        Matrix matrix3 = Matrix.generate(3, 2);
        System.out.println(matrix1);
        System.out.println(matrix2);
        System.out.println(matrix3);
        try {
            System.out.println(matrix1.add(matrix2).subtract(matrix3));
        }catch (NotCompatibleSizeException exception){
            System.out.println(exception.getMessage());
        }
    }
}
