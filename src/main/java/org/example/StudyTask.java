package org.example;

public class StudyTask extends Task {
    private String subject;
    private String topic;
    private int StudyDuration;


    public StudyTask(String subject, String topic, int studyDuration) {
        super();
        this.subject = subject;
        this.topic = topic;
        StudyDuration = studyDuration;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getStudyDuration() {
        return StudyDuration;
    }

    public void setStudyDuration(int studyDuration) {
        StudyDuration = studyDuration;
    }
}
