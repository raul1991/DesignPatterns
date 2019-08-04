package filereader;

import filereader.criterias.GroupByCriteria;
import filereader.formatters.PlainReportFormatter;
import filereader.interfaces.Criteria;
import filereader.interfaces.Report;
import filereader.readers.CsvParser;
import filereader.readers.DelimitedFileParser;
import filereader.reports.SummaryReport;

import java.util.Arrays;

public class Client {

    public static void main(String[] args) {
        validateArgumentsOrThrowException(args);
        DelimitedFileParser csvParser = new CsvParser(args[0], ",");
        Criteria criteria = new GroupByCriteria.GroupByCriteriaBuilder()
                .select(Arrays.asList("City", "Country", "Gender", "Currency", "Average Income"))
                .headers(Arrays.asList("Country/City", "Gender", "Average Income"))
                .groupBy(Arrays.asList("Country", "Gender")).build();
        Report report = new SummaryReport(new PlainReportFormatter(args[1]), csvParser);
        report.generate(criteria);
    }

    private static void validateArgumentsOrThrowException(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException(String.format("Expected arguments: %d, found: %d", 2, args.length));
        }
    }
}
