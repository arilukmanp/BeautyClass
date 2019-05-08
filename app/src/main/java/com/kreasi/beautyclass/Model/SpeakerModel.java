package com.kreasi.beautyclass.Model;

public class SpeakerModel {

    SpeakerModel(){
        this.nameSpeaker=getNameSpeaker();
        this.achieveSpeaker=getAchieveSpeaker();
        this.cvSpeaker=getCvSpeaker();
        this.photoSpeaker=getPhotoSpeaker();
        this.degreeSpeaker=getDegreeSpeaker();
        this.jobSpeaker=getJobSpeaker();
    }
    SpeakerModel(String name, String achievement, String Job, String degree, String cv, String photo){
        this.nameSpeaker=name;
        this.achieveSpeaker=achievement;
        this.cvSpeaker=cv;
        this.photoSpeaker=photo;
        this.degreeSpeaker=degree;
        this.jobSpeaker=Job;
    }

    private String nameSpeaker;

    public String getNameSpeaker() {
        return nameSpeaker;
    }

    public void setNameSpeaker(String nameSpeaker) {
        this.nameSpeaker = nameSpeaker;
    }

    public String getPhotoSpeaker() {
        return photoSpeaker;
    }

    public void setPhotoSpeaker(String photoSpeaker) {
        this.photoSpeaker = photoSpeaker;
    }

    public String getDegreeSpeaker() {
        return degreeSpeaker;
    }

    public void setDegreeSpeaker(String degreeSpeaker) {
        this.degreeSpeaker = degreeSpeaker;
    }

    public String getCvSpeaker() {
        return cvSpeaker;
    }

    public void setCvSpeaker(String cvSpeaker) {
        this.cvSpeaker = cvSpeaker;
    }

    public String getJobSpeaker() {
        return jobSpeaker;
    }

    public void setJobSpeaker(String jobSpeaker) {
        this.jobSpeaker = jobSpeaker;
    }

    public String getAchieveSpeaker() {
        return achieveSpeaker;
    }

    public void setAchieveSpeaker(String achieveSpeaker) {
        this.achieveSpeaker = achieveSpeaker;
    }

    private String photoSpeaker;
    private String degreeSpeaker;
    private String cvSpeaker;
    private String jobSpeaker;
    private String achieveSpeaker;
}
