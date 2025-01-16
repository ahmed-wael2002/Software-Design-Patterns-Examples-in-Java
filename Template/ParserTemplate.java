
abstract class Parser{
    // Varying functions that are customized by the children classes 
    abstract void readData();
    abstract void processData();
    // Common function that cannot be overridden by the children 
    final void outputData(){
        System.out.println("Output Data!");
    }
    final void parse(){
        readData();
        processData();
        outputData();
    }
}

class CSVParser extends Parser{
    public void readData(){
        System.out.println("Reading from CSV");
    }

    public void processData(){
        System.out.println("Processing from CSV");
    }
}

class DatabaseParser extends Parser{
    public void readData(){
        System.out.println("Reading from Database");
    }

    public void processData(){
        System.out.println("Processing from Database");
    }
}

public class ParserTemplate {
    public static void main(String [] args){
        Parser parser;
        
        parser = new CSVParser();
        parser.parse();

        parser = new DatabaseParser();
        parser.parse();
    }
}
