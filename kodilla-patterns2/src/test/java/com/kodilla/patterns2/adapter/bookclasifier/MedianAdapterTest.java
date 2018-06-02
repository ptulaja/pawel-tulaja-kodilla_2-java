package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class MedianAdapterTest {
    @Test
    public void testPublicationYearMedian() {
        //Given
        Book book1 = new Book("A", "T1", 1991, "1111");
        Book book2 = new Book("A", "T2", 1992, "1222");
        Book book3 = new Book("A", "T3", 1993, "1333");
        Book book4 = new Book("A", "T4", 1994, "1444");
        Book book5 = new Book("A", "T5", 1995, "5555");

        Set<Book> bookASet = new HashSet<>();
        bookASet.add(book1);
        bookASet.add(book2);
        bookASet.add(book3);
        bookASet.add(book4);
        bookASet.add(book5);

        MedianAdapter medianAdapter = new MedianAdapter();

        //When
        int median = medianAdapter.publicationYearMedian(bookASet);
        System.out.println(median);
        assertEquals(1993, median);

    }

}