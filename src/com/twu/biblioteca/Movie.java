package com.twu.biblioteca;

public class Movie extends Item {
    public final String directorName;
    public final double movieRating;

    public Movie(String movieName, int yearOfRelease, String directorName, double movieRating, boolean checkOutStatus) {
        super(checkOutStatus, yearOfRelease, movieName);
        this.directorName = directorName;
        this.movieRating = movieRating;
    }


    @Override
    public String[] returnHeader() {
        return new String[]{"Movie Name","Year Of Release","Director Name","Movie Rating"};

    }
}
