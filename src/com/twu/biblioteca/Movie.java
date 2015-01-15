package com.twu.biblioteca;

public class Movie extends Item {
    private final String directorName;
    private final double movieRating;

    public Movie(String movieName, int yearOfRelease, String directorName, double movieRating, boolean checkOutStatus) {
        super(checkOutStatus, yearOfRelease, movieName);
        this.directorName = directorName;
        this.movieRating = movieRating;
    }

    @Override
    public String toString() {
        return name + '\t' + year + '\t' + directorName + '\t' + movieRating + '\n';
    }

    @Override
    public String returnHeader() {
        return "Movie Name\t\tYear Of Publication\t\tDirector Name\t\t Movie Rating";

    }
}
