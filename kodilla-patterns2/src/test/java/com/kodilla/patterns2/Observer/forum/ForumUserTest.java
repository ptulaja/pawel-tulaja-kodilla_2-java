package com.kodilla.patterns2.Observer.forum;

import org.junit.Test;

import static org.junit.Assert.*;

public class ForumUserTest {
    @Test
    public void testUptade() {
        //Given
        ForumTopic javaHelpForum = new JavaHelpForumTopic();
        ForumTopic javaToolsForum = new JavaToolsForumTopic();

        ForumUser johnSmith = new ForumUser("John Smith");
        ForumUser ivoneEscobar = new ForumUser("Ivone Escobar");
        ForumUser jessiePinkman = new ForumUser("Jessie Pinkman");

        javaHelpForum.registerObserver(johnSmith);
        javaHelpForum.registerObserver(jessiePinkman);
        javaToolsForum.registerObserver(jessiePinkman);
        javaToolsForum.registerObserver(ivoneEscobar);

        //When
        javaHelpForum.addPost("Hi everyone! Could you help me withfor loop?");
        javaHelpForum.addPost("Better try to use while loop in this case");
        javaToolsForum.addPost("Help pls, MySql db dosen't work");
        javaHelpForum.addPost("Why while, is it better?");
        javaToolsForum.addPost("When I try to log...");
        assertEquals(3, johnSmith.getUptadeCount());
        assertEquals(2, ivoneEscobar.getUptadeCount());
        assertEquals(5, jessiePinkman.getUptadeCount());
    }
}