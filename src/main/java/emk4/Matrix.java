package emk4;

import emk4.Exceptions.NotCompatibleSizeException;
public class Matrix {
    private final Double[][] data;
    private final int rowSize;
    private final int colSize;
    public Matrix(Double[][] data) {
        this.data = data;
        this.rowSize = this.data.length;
        this.colSize = this.data[0].length;
    }
    public static Matrix generate(int rowSize, int colSize){
        Double[][] generatedData = new Double[rowSize][colSize];
        for(int i = 0; i < rowSize; i++){
            for(int j = 0; j < colSize; j++){
                generatedData[i][j] = (double)(int)(Math.random() * 20);
            }
        }
        return new Matrix(generatedData);
    }
    public Matrix add(Matrix other) throws NotCompatibleSizeException {
        if(this.sameSizeAs(other)) {
            Matrix output = new Matrix(new Double[this.rowSize][this.colSize]);
            for (int i = 0; i < output.rowSize; i++) {
                for (int j = 0; j < output.colSize; j++) {
                    output.data[i][j] = this.data[i][j] + other.data[i][j];
                }
            }
            return output;
        }
        throw new NotCompatibleSizeException();
    }
    public Matrix subtract(Matrix other) throws NotCompatibleSizeException{
        if(this.sameSizeAs(other)) {
            Matrix output = new Matrix(new Double[this.rowSize][this.colSize]);
            for (int i = 0; i < output.rowSize; i++) {
                for (int j = 0; j < output.colSize; j++) {
                    output.data[i][j] = this.data[i][j] - other.data[i][j];
                }
            }
            return output;
        }
        throw new NotCompatibleSizeException();
    }
    public boolean sameSizeAs(Matrix other){
        return this.rowSize == other.rowSize && this.colSize == other.colSize;
    }
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < this.rowSize; i++){
            for (int j = 0; j < this.colSize; j++){
                output.append(String.format("%.2f", this.data[i][j])).append('\t');
            }
            output.append('\n');
        }
        return output.append('\t').append(this.rowSize).append(' ').append(this.colSize).toString();
    }
}
