package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Classifier;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookB;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookSignature;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MedianAdapter extends MedianAdaptee implements Classifier {
    public int publicationYearMedian(Set<Book> bookSet) {
        Map<BookSignature, BookB> booksMap = new HashMap<>();

        for (Book book : bookSet) {
            BookB bookB = new BookB(book.getAuthor(), book.getTitle(), book.getPublicationYear());
            BookSignature bookSignature = new BookSignature(book.getSignature());
            booksMap.put(bookSignature, bookB);
        }
        return medianPublicationYear(booksMap);

    }
}
