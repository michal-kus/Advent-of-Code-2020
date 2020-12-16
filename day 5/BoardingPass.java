public class BoardingPass {

    private String rowCode;
    private String columnCode;

    public BoardingPass(String code) {
        rowCode = code.substring(0, 7);
        columnCode = code.substring(7, 10);
    }
    
    public int getSeatId() {
        return this.getRow() * 8 + this.getColumn();
    }
    private int getRow() {
        byte rowIndex = 0;
        for (int i = 0; i < rowCode.length(); i++) {
            if (rowCode.charAt(i) == "B".charAt(0)){
                rowIndex = this.setBit(rowIndex, i + 1); //+1 because byte is signed
            }            
        }
        return rowIndex;
    }
    private int getColumn() {
        byte columnIndex = 0;
        for (int i = 0; i < columnCode.length(); i++) {
            if (columnCode.charAt(i) == "R".charAt(0)) {
                columnIndex = this.setBit(columnIndex, i + 5);
            }
        }
        return columnIndex;
    }
    public static byte setBit(byte bits, int position) {
        bits |= 1 << (7 - position); 
        return bits;
    }
    
    
    
    // private byte clearBit(byte bits, int position){
    //     bits &= ~(1 << position); 
    //     return bits;
    // }
}
