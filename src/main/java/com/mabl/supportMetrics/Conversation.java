package com.mabl.supportMetrics;
public class Conversation {
    public String email;
    public String company;
    public String assignee;
    public String timeToReplySeconds;

    //field name is a misnomer -- first response is customer opening the case
    public String firstResponseEpochTime;

    public String closedAtEpochTime;
    public double timeOpenEpochTime;
    public String customerRating;
    public String customerComment;

    public Conversation(
            String email,
            String assignee,
            String timeToReplySeconds,
            String firstResponseEpochTime,
            String closedAtEpochTime,
            String customerRating,
            String customerComment){
        this.email = email;
        this.company = email.substring(email.indexOf("@")+1);
        this.assignee = getName(assignee);
        this.timeToReplySeconds = timeToReplySeconds;
        this.firstResponseEpochTime = firstResponseEpochTime;
        this.closedAtEpochTime = closedAtEpochTime;
        this.timeOpenEpochTime = Double.parseDouble(closedAtEpochTime) - Double.parseDouble(firstResponseEpochTime);
        this.customerRating = customerRating;
        this.customerComment = customerComment;
    }

    //Resolve "admin id" (case owner) to human name of team member
    public String getName(String id){
        int i = Integer.parseInt(id);
        switch (i){
            case 3215638: return "Damon";
            case 3261500: return "Ketan";
            case 5020091: return "Damien";
            case 5076273: return "Sam";
            case 5107832: return "Ben";
            case 5131392: return "Molly";
            default: return "Not found";
        }
    }


}
