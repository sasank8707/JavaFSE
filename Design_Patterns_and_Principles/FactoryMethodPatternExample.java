public class FactoryMethodPatternExample {

    public static void main(String[] args) {

        DocumentFactory wordFactory = new WordFactory();
        DocumentFactory pdfFactory = new PdfFactory();
        DocumentFactory excelFactory = new ExcelFactory();

        Document wordDoc = wordFactory.createDocument();
        Document pdfDoc = pdfFactory.createDocument();
        Document excelDoc = excelFactory.createDocument();

        wordDoc.open();
        pdfDoc.open();
        excelDoc.open();
    }
}

interface Document {
    void open();
}

class WordDocument implements Document {

    @Override
    public void open() {
        System.out.println("Open Word");
    }
}

class PdfDocument implements Document {

    @Override
    public void open() {
        System.out.println("Open PDF");
    }
}

class ExcelDocument implements Document {

    @Override
    public void open() {
        System.out.println("Open Excel");
    }
}

abstract class DocumentFactory {

    public abstract Document createDocument();
}

class WordFactory extends DocumentFactory {

    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}

class PdfFactory extends DocumentFactory {

    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}

class ExcelFactory extends DocumentFactory {

    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}