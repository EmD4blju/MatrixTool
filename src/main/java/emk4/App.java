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
        System.out.println(matrix1);
        System.out.println(matrix2);
        try {
            Matrix outcomeMatrix = matrix1.subtract(matrix2)
                    .multiply(matrix1)
                    .add(matrix1);
            System.out.println(outcomeMatrix);
        }catch (NotCompatibleSizeException exception){
            System.out.println(exception.getMessage());
        }
    }
}
