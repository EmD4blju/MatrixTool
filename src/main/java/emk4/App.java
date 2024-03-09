package emk4;

/**
 * @author EmDablju
 */


public class App 
{
    public static void main( String[] args )
    {
        Matrix matrix1 = Matrix.generate(5, 3);
        Matrix matrix2 = Matrix.generate(3, 3);
        System.out.println(matrix1);
        System.out.println(matrix2);
        try {
            System.out.println(matrix1.add(matrix2));
        }catch (NotCompatibleSizeException exception){
            System.out.println(exception.getMessage());
        }
    }
}
