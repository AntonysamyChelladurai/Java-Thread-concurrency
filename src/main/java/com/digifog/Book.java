package com.digifog;


public class Book {
        private String name;
        private int releaseYear;
        private String isbn;


        // getters and setters


        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public int getReleaseYear() {
                return releaseYear;
        }

        public void setReleaseYear(int releaseYear) {
                this.releaseYear = releaseYear;
        }

        public String getIsbn() {
                return isbn;
        }

        public void setIsbn(String isbn) {
                this.isbn = isbn;
        }

        public Book(String name, int releaseYear, String isbn) {
                this.name = name;
                this.releaseYear = releaseYear;
                this.isbn = isbn;
        }
}