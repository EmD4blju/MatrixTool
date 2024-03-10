package emk4;

import emk4.Exceptions.NotCompatibleSizeException;
public class Matrix {
    private final double[][] data;
    private final int rowSize;
    private final int colSize;
    public Matrix(double[][] data) {
        this.data = data;
        this.rowSize = this.data.length;
        this.colSize = this.data[0].length;
    }
    public static Matrix generate(int rowSize, int colSize){
        double[][] generatedData = new double[rowSize][colSize];
        for(int i = 0; i < rowSize; i++){
            for(int j = 0; j < colSize; j++){
                generatedData[i][j] = (int)(Math.random() * 5);
            }
        }
        return new Matrix(generatedData);
    }
    public Matrix add(Matrix other) throws NotCompatibleSizeException {
        if(this.isAddableWith(other)) {
            Matrix output = new Matrix(new double[this.rowSize][this.colSize]);
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
        if(this.isAddableWith(other)) {
            Matrix output = new Matrix(new double[this.rowSize][this.colSize]);
            for (int i = 0; i < output.rowSize; i++) {
                for (int j = 0; j < output.colSize; j++) {
                    output.data[i][j] = this.data[i][j] - other.data[i][j];
                }
            }
            return output;
        }
        throw new NotCompatibleSizeException();
    }
    public Matrix multiply(Matrix other) throws NotCompatibleSizeException{
        if(this.isMultiplyableWith(other)){
            Matrix output = new Matrix(new double[this.rowSize][other.colSize]);
            for(int i = 0; i < output.rowSize; i++){
                for(int j = 0; j < output.colSize; j++){
                    for(int k = 0; k < other.rowSize; k++) {
                        output.data[i][j] += this.data[i][k] * other.data[k][j];
                    }
                }
            }
            return output;
        }
        throw new NotCompatibleSizeException();
    }
    public Matrix multiply(double n){
        Matrix output = new Matrix(new double[this.rowSize][this.colSize]);
        for(int i = 0; i < output.rowSize; i++){
            for(int j = 0; j < output.colSize; j++){
                output.data[i][j] = this.data[i][j] * n;
            }
        }
        return output;
    }
    public boolean isAddableWith(Matrix other){
        return this.rowSize == other.rowSize && this.colSize == other.colSize;
    }
    public boolean isMultiplyableWith(Matrix other){
        return this.colSize == other.rowSize;
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
