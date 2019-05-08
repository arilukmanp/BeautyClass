package com.kreasi.beautyclass.Model;

public class ProfileModel {
    private String photosProfile;
    private String nameProfile;
    private String dateBirth;
    private String addressProfile;

    public ProfileModel(String photosProfile, String nameProfile, String dateBirth, String addressProfile, String jobProfile, String idProfile) {
        this.photosProfile = photosProfile;
        this.nameProfile = nameProfile;
        this.dateBirth = dateBirth;
        this.addressProfile = addressProfile;
        this.jobProfile = jobProfile;
        this.idProfile = idProfile;
    }

    public ProfileModel() {
        this.photosProfile = getPhotosProfile();
        this.nameProfile = getNameProfile();
        this.dateBirth = getDateBirth();
        this.addressProfile = getAddressProfile();
        this.jobProfile = getJobProfile();
        this.idProfile = getIdProfile();
    }

    private String jobProfile;

    public String getPhotosProfile() {
        return photosProfile;
    }

    public void setPhotosProfile(String photosProfile) {
        this.photosProfile = photosProfile;
    }

    public String getNameProfile() {
        return nameProfile;
    }

    public void setNameProfile(String nameProfile) {
        this.nameProfile = nameProfile;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getAddressProfile() {
        return addressProfile;
    }

    public void setAddressProfile(String addressProfile) {
        this.addressProfile = addressProfile;
    }

    public String getJobProfile() {
        return jobProfile;
    }

    public void setJobProfile(String jobProfile) {
        this.jobProfile = jobProfile;
    }

    public String getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(String idProfile) {
        this.idProfile = idProfile;
    }

    private String idProfile;

}
