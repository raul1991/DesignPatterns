package bookingsystem;

import java.util.List;
import java.util.function.Predicate;

public interface Theatre {
    List<MovieShow> getShows();
    List<MovieShow> getShowsWithCriteria(SearchCriteria criteria);

    Predicate matches(SearchCriteria criteria);
}
