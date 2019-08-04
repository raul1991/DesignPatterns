package filereader.formatters;

import filereader.interfaces.ReportFormatter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Paths;

public class PlainReportFormatter implements ReportFormatter {

    private PrintWriter writer;
    public PlainReportFormatter(String reportFile)
    {
        try {
            writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(reportFile)));
        } catch (FileNotFoundException e) {
            System.err.printf("Output file (%s) not found", reportFile);
        }
    }

    @Override
    public void applyFormatting(String line) {
        writer.println(line);
        writer.flush();
    }
}
