package filereader.reports;

import filereader.CurrencyConverter;
import filereader.RowCell;
import filereader.RowData;
import filereader.interfaces.Criteria;
import filereader.interfaces.Report;
import filereader.interfaces.ReportFormatter;
import filereader.readers.DelimitedFileParser;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class SummaryReport implements Report {

    private ReportFormatter reportFormatter;
    private DelimitedFileParser fileParser;

    public SummaryReport(ReportFormatter reportFormatter, DelimitedFileParser fileParser)
    {
        this.reportFormatter = reportFormatter;
        this.fileParser = fileParser;
    }

    @Override
    public void generate(Criteria criteria) {
        fileParser.parseFile();
        List<RowData> rows = fileParser.getRows();
        List<String> selection = criteria.getSelection();
        // outputting the headers to the report
        reportFormatter.applyFormatting(criteria.outputHeaders().stream().collect(
                Collectors.joining(fileParser.getDelimiter())));

        // group by operation
        Map<String, Map<String, Double>> collect = rows.stream()
                .map(rowData -> getMatchingCells(criteria, rowData))
                .collect(groupingBy(this::getCountryOrElseCity,
                            groupingBy(cells -> cells.get(2).getValue(),
                                averagingDouble(cells -> toUSD(
                                        Double.parseDouble(cells.get(4).getValue()), cells.get(3).getValue())))));

        // output the values into the report
        collect.forEach((key, value) -> value.forEach((key1, value1) -> reportFormatter.applyFormatting(
                Stream.of(key, key1, value1).map(Object::toString)
                        .collect(Collectors.joining(fileParser.getDelimiter()))
        )));
    }

    private double toUSD(double income, String currency) {
        return CurrencyConverter.toUSD(income, currency);
    }

    private String getCountryOrElseCity(List<RowCell> cells) {
        String country = cells.get(1).getValue();
        RowCell city = cells.get(0);
        return country.trim().isEmpty() ? city.getValue() : country;
    }

    private static List<RowCell> getMatchingCells(Criteria criteria, RowData rowData) {
        return rowData.getRowCells().stream()
                .filter(rowCell -> criteria.getSelection().contains(rowCell.getHeaderName()))
                .collect(toList());
    }

}
