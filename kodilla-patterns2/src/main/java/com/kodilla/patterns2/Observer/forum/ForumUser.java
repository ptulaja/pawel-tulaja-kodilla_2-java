package com.kodilla.patterns2.Observer.forum;

public class ForumUser implements Observer{
    private final String username;
    private int uptadeCount;

    public ForumUser(String username) {
        this.username = username;
    }

    public void uptade(ForumTopic forumTopic){
        System.out.println(username+": New messages in topic "+forumTopic.getName()+"\n"+
                " (total: " + forumTopic.getMessages().size() + "messages)");
        uptadeCount++;
    }

    public String getUsername() {
        return username;
    }

    public int getUptadeCount() {
        return uptadeCount;
    }
}
