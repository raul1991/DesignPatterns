package bookingsystem;

// a builder to create a search criteria
public class SearchCriteria {
    private enum Genre {ROMANTIC, THRILLER}
    private enum Rating {
        ADULT(18),
        UNIVERSAL(5);
        private int age;
        Rating(int age) {
            this.age = age;
        }
    }
    private PriceRange range;

    private static class Builder
    {
        private final Genre genre;
        private final Rating rating;
        private final PriceRange priceRange;

        private Builder(Genre genre, Rating rating, PriceRange priceRange) {
            this.genre = genre;
            this.rating = rating;
            this.priceRange = priceRange;
        }

        public SearchCriteria build()
        {
            return new SearchCriteria();
        }
    }

    private class PriceRange {
        private int low;
        private int high;

        private PriceRange(int low, int high) {
            this.low = low;
            this.high = high;
        }
    }
}
